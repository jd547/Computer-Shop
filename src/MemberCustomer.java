public class MemberCustomer extends Customer{
    private final double DISCOUNT=0.05;
    private static Order o = new Order();

    public MemberCustomer() {
        this("", "", "", "", "");
    }

    public MemberCustomer(String i, String n, String g, String m, String a) {
        super(i, n, g, m, a);
    }

    public double getDISCOUNT() {
        return DISCOUNT*o.getTotalPrice();
    }

    public double getDiscountPrice() {
        return o.getTotalPrice()-getDISCOUNT();
    }

    @Override
    public String toString() {
        return String.format("Customer: %s, %s, %s, %s, %s", getID(), getName(), getGender(), getMobile(), getAddress());
    }
}
