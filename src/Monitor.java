
public class Monitor extends ComputerPart {
    private final String SIZE;

    public Monitor() {
        this("", "", "", "", 0);
    }

    public Monitor(String pre, String b, String s, String m, double p) {
        super(pre, b, m, p);
        SIZE = s;
    }

    public Monitor(Monitor m) {
        SIZE=m.SIZE;
    }

    // getters
    public String getSize() {
        return SIZE;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s | $%.2f", getID(), getBrand(), getSize(), getModel(), getPrice());
    }

}
