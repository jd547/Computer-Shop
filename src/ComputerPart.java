public abstract class ComputerPart  {
    private final String ID;
    private final String BRAND;
    private final String MODEL;
    private double price;

    public ComputerPart() {
        this("", "", "", 0);
    }

    public ComputerPart(String b, String m, double p) {
        ID="";
        BRAND=b;
        MODEL=m;
        price=p;
    }

    public ComputerPart(String pre, String b, String m, double p) {
        // do something here with ID and pre
        ID=createPartID(pre);
        BRAND=b;
        MODEL=m;
        price=p;
    }

    public ComputerPart(ComputerPart cp) {
        ID=cp.ID;
        BRAND=cp.BRAND;
        MODEL=cp.MODEL;
        price=cp.price;
    }

    public String getID() {
        return ID;
    }

    public String getBrand() {
        return BRAND;
    }

    public String getModel() {
        return MODEL;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double p) {
        price=p;
    }

    // @Override
    // public boolean isCompatible(ComputerPart cp) {
    //     if (cp instanceof AMDCPU) {
            
    //     }
        
    // }

    public static String createPartID(String prefix) {
        for (int i=0; i<=3; i++) {
            prefix += generateDigit(0, 10);
        }
        System.out.println("TEST");
        return prefix;

    }

    public static int generateDigit(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return (int)(Math.random() * ((max - min) + 1)) + min;
    }

    // format
    public String toString() {
        return String.format("");
    }

}
