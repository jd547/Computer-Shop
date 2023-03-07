import java.util.ArrayList;

public class Customer { 
    private final String ID; //read only
    private String name;
    private String gender;
    private String mobile;
    private String address;
    private ArrayList<Order> orders; // customer order/s

    public Customer() {
        this("", "", "", "", "");
    }

    public Customer(String i, String n, String m, String a) {
        ID=i;
        name=n;
        mobile=m;
        address=a;
    }

    public Customer(String i, String n, String g, String m, String a) {
        ID = i;
        name = n;
        gender = g;
        mobile = m;
        address = a;
        orders = new ArrayList<Order>(0);
    }

    // getters
    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAddress() {
        return address;
    }

    // setters
    public void setName(String n) {
        name = n;
    }

    public void setGender(String g) {
        gender = g;
    }

    public void setMobile(String m) {
        mobile = m;
    }

    public void getAddress(String a) {
        address = a;
    }

    public void printOrders() {
        for (Order i: orders) {
            System.out.println(i);
        }
    }

    // return arraylist orders
    public ArrayList<Order> getOrders() {
        return orders;
    }

    // adds an Order object to orders arraylist
    public void addOrder(Order o) {
        orders.add(o);
    }

    // removes Order object from orders arraylist from index
    public void removeOrder(int i) {
        orders.remove(i);
    }

    @Override
    public String toString() {
        return String.format("Customer: %s, %s, %s, %s, %s", getID(), getName(), getGender(), getMobile(), getAddress());
    }
}
