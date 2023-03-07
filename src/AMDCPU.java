public class AMDCPU extends CPU{
    private final String SOCKET;

    public AMDCPU() {
        this("", "", "", "", "", 0);
    }

    public AMDCPU(String pre, String s, String c, String m, String b, double p) {
        super(pre, c, m, b, p);
        SOCKET=s;
    }

    public AMDCPU(AMDCPU ac) {
        SOCKET=ac.SOCKET;
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
