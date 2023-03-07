
public abstract class Motherboard extends ComputerPart {

    public Motherboard() {
        this("", "", "", 0);
    }

    public Motherboard(String b, String m, double p) {
        super(b, m, p);
    }

    public Motherboard(String i, String b, String m, double p) {
        super(i, b, m, p);
    }

    public Motherboard(Motherboard mb) {

    }

    public String toString() {
        return String.format("%-14s %-10s %-10s $%d", "Motherboard", getBrand(), getModel(), getPrice());
    }
}
