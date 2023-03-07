public class IntelCPU extends CPU {
    private final String SOCKET;

    public IntelCPU() {
        this("", "", "", "", "", 0);
    }

    public IntelCPU(String pre, String s, String c, String m, String b, double p) {
        super(pre, c, m, b, p);
        SOCKET=s;
    }

    public IntelCPU(IntelCPU ic) {
        SOCKET=ic.SOCKET;
    }

    public String getSocket() {
        return SOCKET;
    }

    //Format
    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s | %s | $%.2f", getID(), getSocket(), getCore(), getModel(), getBrand(), getPrice());
    }
}
