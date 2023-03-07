import java.util.ArrayList;

public class DiscountOrder extends Order {
    private double discountRate;

    public DiscountOrder() {
        this(0);
    }

    public DiscountOrder(String i, Customer c, ArrayList<ComputerPart> pa) {
        super(i, c, pa);
    }

    public DiscountOrder(double d) {
        discountRate=d;
    }

    public double getDiscount() {
        return discountRate;
    }

    // format
    public String toString() {
        return String.format("");
    }

}
