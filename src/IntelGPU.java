public class IntelGPU extends GPU {
    private final String SOCKET;

    public IntelGPU() {
        this("", "", "", "", 0);
    }

    public IntelGPU(String pre, String s, String b, String m, double p) {
        super(pre, b, m, p);
        SOCKET=s;
    }

    public IntelGPU(IntelGPU ig) {
        SOCKET=ig.SOCKET;
    }

    public String getSocket() {
        return SOCKET;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s | $%.2f", getID(), getSocket(), getModel(), getBrand(), getPrice());
    }
}
