import java.util.Scanner;

import java.util.ArrayList;

public class OrderingSystem {
    private static ArrayList<Customer> customers;
    private static ArrayList<ComputerPart> parts;
    private static Customer person;
    private static Order order;

    public OrderingSystem() {
        customers = new ArrayList<Customer>(0);
        parts = new ArrayList<ComputerPart>(0);
    }

    public static void main(String[] args) {
        OrderingSystem oS = new OrderingSystem();
        Order o = new Order();
      
        // initialise shop
        oS.initialiseShop();

        Scanner in = new Scanner(System.in);

        // prompt user information
        System.out.println("Welcome to our computer shop!");

        int item = -1;

        while (item!=8) {
            System.out.println("\nPlease make a selection from the following items: ");
            System.out.println("1: Login as an existing member\n2: Login as a new member\n3: Add computer parts\n4: View/modify the current order");
            System.out.println("5: Submit the current order\n6: Review/cancel submitted orders\n7: Exit the shop\n");

            item = in.nextInt();
            in.nextLine();

            if (item==1) {
                // login as an existing member
                System.out.println("Please enter your customer ID: ");
                String cID = in.nextLine();

                int a=0;
                for (Customer i: customers) {
                    
                    if (cID.equals(i.getID())) {
                        MemberCustomer mCus = (MemberCustomer)i;
                        String orderID = createOrderID();
                        // create DiscountOrder obj last
                        DiscountOrder dOrder = new DiscountOrder(orderID, mCus, o.getComputerParts());
                        person=i;
                        order=dOrder;
                        a++;
                    }
                }
                if (a==0) {
                    System.out.println("Sorry, your ID can't be found. Please login as a new member.");
                }

            } else if (item==2) {
                // login as a new customer
                System.out.println("Please enter your name: ");
                String name = in.nextLine();
                System.out.println("Please enter your gender: ");
                String gender = in.nextLine();
                System.out.println("Please enter your mobile number: ");
                String mobile = in.nextLine();
                System.out.println("Please enter your delivery address: ");
                String address = in.nextLine();

                String cID = createCustomerID();
                String oID = createOrderID();

                Customer cus = new Customer(cID, name, gender, mobile, address);
                Order ord = new Order(oID, cus, o.getComputerParts());
                oS.addCustomer(cus);
                person=cus;
                order=ord;
                

            } else if (item==3) {
                // add computer parts
                System.out.println("We offer the following products: ");
                // display all computer parts with index
                for (int i=0; i<parts.size(); i++) {
                    System.out.printf("(%d) %s %n", i, parts.get(i));
                }

                boolean loop=true;
                while (loop) {
                    System.out.println("Please select part/s (-1 to return to main menu): ");
                    String[] partSelect = in.nextLine().split(",");
                    ArrayList<Integer> numbers = new ArrayList<Integer>(0);
                    int i=0;
                    // parse string to int
                    for (String str: partSelect) {
                        numbers.add(Integer.parseInt(str.trim()));
                        i++;
                    }

                    // break condition and remove -1
                    for (int a=0; a<numbers.size(); a++) {
                        if (numbers.get(a)==-1) {
                            numbers.remove(a);
                            loop=false;
                        }
                    }

                    // add the parts to list
                    for (int k=0; k<numbers.size(); k++) {
                        o.addComputerPart(parts.get(numbers.get(k)));
                    }
                }

            } else if (item==4) {
                //view/modify the current order
                System.out.println("Here is the summary of your current order: ");
                System.out.println(person);
                o.displayParts();
                System.out.printf("Order: %s    Total Price: $%.2f %n", order.getID(), o.getTotalPrice());
                if (person instanceof MemberCustomer) {
                    person=(MemberCustomer)person;
                    System.out.printf("Member Customer Discount: $%.2f      Total Price after the Discount: $%.2f %n%n", o.getTotalPrice()*0.05, o.getTotalPrice()-(o.getTotalPrice()*0.05));
                }
                
                boolean loop=true;
                while (loop) {
                    
                    System.out.println("Please select part/s to remove from the order (-1 to return to main menu): ");
                    String[] partSelect = in.nextLine().split(",");
                    ArrayList<Integer> numbers = new ArrayList<Integer>(0);
                    int i=0;
                    // parse string to int
                    for (String str: partSelect) {
                        numbers.add(Integer.parseInt(str.trim()));
                        i++;
                    }

                    // break condition and remove -1
                    for (int a=0; a<numbers.size(); a++) {
                        if (numbers.get(a)==-1) {
                            numbers.remove(a);
                            loop=false;
                        }
                    }

                    // add the parts to list
                    for (int k=0; k<numbers.size(); k++) {
                        o.removeComputerPart(numbers.get(k));
                    }
                }            
            

            } else if (item==5) {
                // submit the current order
                System.out.println(person);
                o.displayParts();
                System.out.printf("Order: %s    Total Price: $%.2f %n", order.getID(), o.getTotalPrice());
                if (person instanceof MemberCustomer) {
                    person=(MemberCustomer)person;
                    System.out.printf("Member Customer Discount: $%.2f      Total Price after the Discount: $%.2f %n%n", o.getTotalPrice()*0.05, o.getTotalPrice()-(o.getTotalPrice()*0.05));
                }

                // if (person instanceof MemberCustomer) {
                //     person=(MemberCustomer)person;
                //     person.addOrder(order);
                // } else {
                //     person.addOrder(order);
                // }

                person.addOrder(order);
                System.out.println("Your order has been submitted. Thank you for your purchase!");
                //person.printOrders();

            } else if (item==6) {
                // review/cancel submitted orders
                System.out.println("Here are all your submitted orders.");
                o.displayParts();
                System.out.printf("Order: %s    Total Price: $%.2f %n", order.getID(), o.getTotalPrice());
                if (person instanceof MemberCustomer) {
                    person=(MemberCustomer)person;
                    System.out.printf("Member Customer Discount: $%.2f      Total Price after the Discount: $%.2f %n%n", o.getTotalPrice()*0.05, o.getTotalPrice()-(o.getTotalPrice()*0.05));
                }

            } else if (item==7) {
                // exist the shop
                System.out.println("Thank you for browsing! Come again!");
                System.exit(1);
            }
        }
    }

    private void initialiseShop() {
        //existing customers
        MemberCustomer amy = new MemberCustomer("C000001", "Amy Bell", "Female", "04211111", "No. 1, NoName Street, NeverLand, 0000.");
        MemberCustomer bob = new MemberCustomer("C000002", "Bob Brown", "Male", "04212222", "No. 2, NoName Street, NeverLand, 0000.");
        MemberCustomer cindy = new MemberCustomer("C000003", "Cindy Ma", "Female", "04213333", "No. 3, NoName Street, NeverLand, 0000.");
        MemberCustomer david = new MemberCustomer("C000004", "David Hintz", "Male", "04214444", "No. 4, NoName Street, NeverLand, 0000.");
        MemberCustomer rex = new MemberCustomer("C000005", "Rex White", "Male", "04215555", "No. 5, NoName Street, NeverLand, 0000.");
        addCustomer(amy);
        addCustomer(bob);
        addCustomer(cindy);
        addCustomer(david);
        addCustomer(rex);

        // CPU
        //String s, String c, String m, String b, double p
        IntelCPU i9600K = new IntelCPU("INTCPU", "Intel", "i5", "9600K", "Intel", 323);
        IntelCPU i9700K = new IntelCPU("INTCPU", "Intel", "i7", "9700K", "Intel", 462);
        IntelCPU i9700F = new IntelCPU("INTCPU", "Intel", "i7", "9700F", "Intel", 396);
        IntelCPU i9900K = new IntelCPU("INTCPU", "Intel", "i9", "9900K", "Intel", 591);
        AMDCPU aR2200 = new AMDCPU("AMDCPU", "AMD", "4", "Ryzen 2200", "AMD", 200);
        AMDCPU aR3600 = new AMDCPU("AMDCPU", "AMD", "6", "Ryzen 3600", "AMD", 310);
        AMDCPU aR3700 = new AMDCPU("AMDCPU", "AMD", "8", "Ryzen 3700", "AMD", 489);
        AMDCPU aR5800 = new AMDCPU("AMDCPU", "AMD", "8", "Ryzen 5800", "AMD", 669);
        addComputerPart(i9600K);
        addComputerPart(i9700K);
        addComputerPart(i9700F);
        addComputerPart(i9900K);
        addComputerPart(aR2200);
        addComputerPart(aR3600);
        addComputerPart(aR3700);
        addComputerPart(aR5800);

        // Motherboard
        //String s, String b, String m, double p
        IntelMotherboard gI_H81M = new IntelMotherboard("INTMOT", "Intel", "Gigabyte", "H81M-DS2", 129);
        IntelMotherboard aI_J40051 = new IntelMotherboard("INTMOT", "Intel", "Asus", "J40051-C", 169);
        IntelMotherboard mI_Mpg = new IntelMotherboard("INTMOT", "Intel", "Msi", "Mpg-2390", 225);
        IntelMotherboard gI_Z490 = new IntelMotherboard("INTMOT", "Intel", "Gigabyte", "Z490", 471);
        AMDMotherboard gA_B450 = new AMDMotherboard("AMDMOT", "AMD", "Gigabyte", "B-450", 117);
        AMDMotherboard aA_A320I = new AMDMotherboard("AMDMOT", "AMD", "Asus", "A320I", 128);
        AMDMotherboard mA_B450 = new AMDMotherboard("AMDMOT", "AMD", "Msi", "B450", 323);
        AMDMotherboard gA_X570S = new AMDMotherboard("AMDMOT", "AMD", "Gigabyte", "X570S", 679);
        addComputerPart(gI_H81M);
        addComputerPart(aI_J40051);
        addComputerPart(mI_Mpg);
        addComputerPart(gI_Z490);
        addComputerPart(gA_B450);
        addComputerPart(aA_A320I);
        addComputerPart(mA_B450);
        addComputerPart(gA_X570S);

        // hardcode memory
        //String s, String b, String sz, String m, double p
        Memory king8GR3 = new Memory("MEM", "DDR3", "Kingston", "8G", "KCP316ND8", 116);
        Memory adata16GR3 = new Memory("MEM", "DDR3", "ADATA", "16G", "AX4U360038G18", 189);
        Memory gskill8GR3 = new Memory("MEM", "DDR3", "G.Skill", "16G", "F3-10666CL9D", 96);
        Memory king8GR4 = new Memory("MEM", "DDR4", "Kingston", "8G", "KCP426SS8", 93);
        Memory gskill16GR4 = new Memory("MEM", "DDR4", "G.Skill", "16G", "F4-2666C18S", 158);
        Memory crucial32GR4 = new Memory("MEM", "DDR4", "Crucial", "32G", "CT32G4SFD832A", 259);
        addComputerPart(king8GR3);
        addComputerPart(adata16GR3);
        addComputerPart(gskill8GR3);
        addComputerPart(king8GR4);
        addComputerPart(gskill16GR4);
        addComputerPart(crucial32GR4);

        // hardcode gpu 
        //String s, String b, String m, double p
        IntelGPU nGigaRTX3070 = new IntelGPU("INTGPU", "NVIDIA", "Gigabyte", "GeForce RTX 3070", 1999);
        IntelGPU nAsusRTX3070 = new IntelGPU("INTGPU", "NVIDIA", "Asus", "GeForce RTX 3070", 1899);
        IntelGPU nMsiRTX3080 = new IntelGPU("INTGPU", "NVIDIA", "Msi", "GeForce RTX 3080", 3099);
        AMDGPU aGigaRX6900 = new AMDGPU("AMDGPU", "AMD", "Gigabyte", "Radeon RX 6900", 3699);
        AMDGPU aAsusRx6900 = new AMDGPU("AMDGPU", "AMD", "Asus", "Radeon RX 6900", 3199);
        AMDGPU aMsiRX6900 = new AMDGPU("AMDGPU", "AMD", "Gigabyte", "Radeon RX 6900", 2699);
        addComputerPart(nGigaRTX3070);
        addComputerPart(nAsusRTX3070);
        addComputerPart(nMsiRTX3080);
        addComputerPart(aGigaRX6900);
        addComputerPart(aAsusRx6900);
        addComputerPart(aMsiRX6900);

        // hardcode monitor
        //String s, String b, String m, double p
        Monitor acer24_K242 = new Monitor("MON", "Acer", "24", "K242HYLB", 194);
        Monitor lg32_32QN = new Monitor("MON", "LG", "32", "32QN600", 506);
        Monitor asus16_MB16 = new Monitor("MON", "Asus", "16", "MB16ACZ", 429);
        Monitor msi27_MP27 = new Monitor("MON", "Msi", "27", "MP271QP", 399);
        Monitor benq32_PD32 = new Monitor("MON", "BenQ", "32", "PD3200Q", 653);
        Monitor philips27_272M = new Monitor("MON", "Philips", "27", "272M8CZ", 289);
        addComputerPart(acer24_K242);
        addComputerPart(lg32_32QN);
        addComputerPart(asus16_MB16);
        addComputerPart(msi27_MP27);
        addComputerPart(benq32_PD32);
        addComputerPart(philips27_272M);
    
    
    
    
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public ArrayList<ComputerPart> getComputerParts() {
        return parts;
    }

    public void addCustomer(Customer c) {
        customers.add(c);
    }

    public void addComputerPart(ComputerPart cp) {
        parts.add(cp);
    }

    // creates customer id by randomly generating single digit, appending to string
    public static String createCustomerID() {
        String unique = "C";
        for (int i=0; i<=4; i++) {
            unique += generateDigit(0, 10);
        }
        return unique;
    }

    // creates order id 
    public static String createOrderID() {
        String unique = "C";
        for (int i=0; i<=4; i++) {
            unique += generateDigit(0, 10);
        }
        return unique;
    }

    public static int generateDigit(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return (int)(Math.random() * ((max - min) + 1)) + min;
    }
}
