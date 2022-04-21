public class FreshWater extends Fluid {

    public final double viscosity = 0.0000105; //ft^2/s
    public final double density = 62.31; //lb/ft^3

    public FreshWater() {
    }

    public double getViscosity() {
        return viscosity;
    }
    public double getDensity() {
        return density;
    }

}
