import java.util.ArrayList;

public class Order {
    private static ArrayList<ComputerPart> parts;
    private final String ID; // read obly
    private double totalPrice;

    public Order() {;
        ID="";
        parts=new ArrayList<ComputerPart>(0);
    }

    public Order(String i, Customer c, ArrayList<ComputerPart> pa) {
        parts=pa;
        ID=i;
    }

    // getters
    public String getID() {
        return ID;
    }

    // add computerpart obj to parts arraylist
    public void addComputerPart(ComputerPart cp) {
        addPrice(cp.getPrice());
        parts.add(cp);
    }

    // remove computerpart obj from parts arraylist from index
    public void removeComputerPart(int i) {
        reducePrice(i);
        parts.remove(i);
    }

    public ArrayList<ComputerPart> getComputerParts() {
        return parts;
    }

    public void displayParts() {
        int j=0;
        for (ComputerPart i: parts) {
            System.out.printf("(%d) %s %n", j, i);
            // if (i.getBrand()!="AMD") {
            //     isCompatible(i);
            // }
            j++;
        }
    }

    public void reducePrice(int i) {
        totalPrice-=parts.get(i).getPrice();
    }

    public void addPrice(double p) {
        totalPrice+=p;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public static String createOrderID() {
        String prefix="O";
        for (int i=0; i<=4; i++) {
            prefix += generateDigit(0, 10);
        }
        return prefix;
    }

    public static int generateDigit(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return (int)(Math.random() * ((max - min) + 1)) + min;
    }

    public String toString() {
        return String.format("Order: %-10s%nTotal Price: $%.2f", getID(), getTotalPrice());
    }

}
