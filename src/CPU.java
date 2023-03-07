
public abstract class CPU extends ComputerPart  {
    private final String CORE;

    public CPU() {
        this("", "", "", 0);
    }

    public CPU(String b, String c, String m, double p) {
        super(b, m, p);
        CORE=c;
    }

    public CPU(String i, String b, String c, String m, double p) {
        super(i, b, m, p);
        CORE=c;
    }

    public CPU(CPU c) {
        CORE=c.CORE;
    }

    // getters
    public String getCore() {
        return CORE;
    }

    // change
    public String toString() {
        return String.format("%-14s %-10s %-10s %-15s $%d", "CPU", getBrand(), getCore(), getModel(), getPrice());
    }
    
}
