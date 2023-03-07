public class AMDGPU extends GPU {
    private final String SOCKET;

    public AMDGPU() {
        this("", "", "", "", 0);
    }

    public AMDGPU(String pre, String s, String b, String m, double p) {
        super(pre, b, m, p);
        SOCKET=s;
    }

    public AMDGPU(AMDGPU ag) {
        SOCKET=ag.SOCKET;
    }

    public String getSocket() {
        return SOCKET;
    }
    
    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s | $%.2f", getID(), getSocket(), getModel(), getBrand(), getPrice());
    }
}
