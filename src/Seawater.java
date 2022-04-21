public class Seawater extends Fluid {

    public final double viscosity = 0.0000111; //ft^2/s
    public final double density = 63.95; //lb/ft^3

    public Seawater() {
    }

    public double getViscosity() {
        return viscosity;
    }
    public double getDensity() {
        return density;
    }

}
