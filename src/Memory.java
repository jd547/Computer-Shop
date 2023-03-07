
public class Memory extends ComputerPart {
    private final String SOCKET;
    private final String SIZE;

    public Memory() {
        this("", "", "", "", "", 0);
    }

    public Memory(String pre, String s, String b, String sz, String m, double p) {
        super(pre, b, m, p);
        SOCKET = s;
        SIZE = sz;
    }

    public Memory(Memory m) {
        SOCKET=m.SOCKET;
        SIZE=m.SIZE;
    }

    // getters 
    public String getSocket() {
        return SOCKET;
    }

    public String getSize() {
        return SIZE;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s | %s | $%.2f", getID(), getSocket(), getSize(), getModel(), getBrand(), getPrice());
    }
    
}
