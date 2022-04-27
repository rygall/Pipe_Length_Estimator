public class HeadToPSI {

    private double density;
    private double specificGravity;
    private double head;
    private Fluid[] fluid = new Fluid[1]; //setting fluid

    public void setFluid(String f) {
        if (f.equalsIgnoreCase("Fresh Water")) {
            FreshWater freshwater = new FreshWater();
            fluid[0] = freshwater;
        }
        if (f.equalsIgnoreCase("Seawater")) {
            Seawater seawater = new Seawater();
            fluid[0] = seawater;
        }
        if (f.equalsIgnoreCase("F-76")) {
            F76 f76 = new F76();
            fluid[0] = f76;
        }
        if (f.equalsIgnoreCase("JP-5")) {
            JP5 jp5 = new JP5();
            fluid[0] = jp5;
        }

        for (Fluid fluid : fluid) {
            density = fluid.getDensity();
        }

        //setting specific gravity
        specificGravity = density / 62.31;

    }

    public void setHead(Double h) {
        head = h;
    }

    public double getPSI() {
        double psi = 0.433 * head * specificGravity;
        return psi;
    }

}
