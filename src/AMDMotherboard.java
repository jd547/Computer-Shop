public class AMDMotherboard extends Motherboard{
    private final String SOCKET;

    public AMDMotherboard() {
        this("", "", "", "", 0);
    }

    public AMDMotherboard(String pre, String s, String b, String m, double p) {
        super(pre, b, m, p);
        SOCKET=s;
    }

    public AMDMotherboard(AMDMotherboard am) {
        SOCKET=am.SOCKET;
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
