public class IntelMotherboard extends Motherboard {
    private final String SOCKET;

    public IntelMotherboard() {
        this("", "", "", "", 0);
    }

    public IntelMotherboard(String pre, String s, String b, String m, double p) {
        super(pre, b, m, p);
        SOCKET=s;
    }

    public IntelMotherboard(IntelMotherboard im) {
        SOCKET=im.SOCKET;
    }

    public String getSocket() {
        return SOCKET;
    }

    //format
    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s | $%.2f", getID(), getSocket(), getModel(), getBrand(), getPrice());
    }

    
}
