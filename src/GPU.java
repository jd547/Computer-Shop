

public abstract class GPU extends ComputerPart  {
    public GPU() {
        this("", "", "", 0);
    }

    public GPU(String b, String m, double p) {
        super(b, m, p);
    }

    public GPU(String pre, String b, String m, double p) {
        super(pre, b, m, p);
    }

    public GPU(GPU g) {

    }

    public String toString() {
        return String.format("%-14s %-10s %-10s %-20s $%d", "Graphics Card", getBrand(), getModel(), getPrice());
    }
}
