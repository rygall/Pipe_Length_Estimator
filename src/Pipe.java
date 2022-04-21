public class Pipe {


    private double length; //lengths are stored in feet in the class
    private double flowRate; //flows stored in gpm
    private int npsIndex; //sets index to pull specific ID out of IDs array for each class
    private double ID; //inner diameter stored in inches
    private double absoluteRoughness; //absolute roughness stored in feet
    private double viscosity; //viscosity stored in ft^2/s
    private double density; //density stored lb/ft^3
    private double elevationchange; //elevation change stored in feet
    private Material[] material = new Material[1];
    private Fluid[] fluid = new Fluid[1];


    public Pipe() {
    }

    public void setLength(double l) {
        length = l;
    }

    public void setNPS(String n) {
        if (n.equalsIgnoreCase("1/4")) {
            npsIndex = 0;
        }
        if (n.equalsIgnoreCase("3/8")) {
            npsIndex = 1;
        }
        if (n.equalsIgnoreCase("1/2")) {
            npsIndex = 2;
        }
        if (n.equalsIgnoreCase("3/4")) {
            npsIndex = 3;
        }
        if (n.equalsIgnoreCase("1")) {
            npsIndex = 4;
        }
        if (n.equalsIgnoreCase("1-1/4")) {
            npsIndex = 5;
        }
        if (n.equalsIgnoreCase("1-1/2")) {
            npsIndex = 6;
        }
        if (n.equalsIgnoreCase("2")) {
            npsIndex = 7;
        }
        if (n.equalsIgnoreCase("2-1/2")) {
            npsIndex = 8;
        }
        if (n.equalsIgnoreCase("3")) {
            npsIndex = 9;
        }
        if (n.equalsIgnoreCase("4")) {
            npsIndex = 10;
        }
        if (n.equalsIgnoreCase("5")) {
            npsIndex = 11;
        }
        if (n.equalsIgnoreCase("6")) {
            npsIndex = 12;
        }
        if (n.equalsIgnoreCase("8")) {
            npsIndex = 13;
        }
        if (n.equalsIgnoreCase("10")) {
            npsIndex = 14;
        }
        if (n.equalsIgnoreCase("12")) {
            npsIndex = 15;
        }

    }

    public void setMaterial(String m) {
        if (m.equalsIgnoreCase("Copper Type K")) {
            CopperK copperK = new CopperK();
            material[0] = copperK;
        }
        if (m.equalsIgnoreCase("Copper Type L")) {
            CopperL copperL = new CopperL();
            material[0] = copperL;
        }
        if (m.equalsIgnoreCase("Copper Nickel 90/10")) {
            CopperNickel copperNickel = new CopperNickel();
            material[0] = copperNickel;
        }
        if (m.equalsIgnoreCase("Copper Nickel 70/30")) {
            CopperNickel copperNickel = new CopperNickel();
            material[0] = copperNickel;
        }
        if (m.equalsIgnoreCase("CRES 304L/316L")) {
            CRES cres = new CRES();
            material[0] = cres;
        }

        for (Material material : material) {
            ID = material.getID(npsIndex);
            absoluteRoughness = material.getAbsoluteRoughness();
        }

    }

    public void setFlowRate(double q) {
        flowRate = q;
    }

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
            viscosity = fluid.getViscosity();
        }

    }

    public void setElevationChange(double el) {
        elevationchange = el;
    }

    public void addValve(String v) {
        if (v.equalsIgnoreCase("Ball")) {
            //this creates a new object and obtains the equivalent length
            Ball ball = new Ball();
            double equivlengthratio = ball.getEquivalentLengthRatio();
            double equivlength = equivlengthratio * (ID / 12.0);
            length += equivlength;

        }
        if (v.equalsIgnoreCase("Butterfly")) {
            //this creates a new object and obtains the equivalent length
            Butterfly butterfly = new Butterfly();
            double equivlengthratio = butterfly.getEquivalentLengthRatio();
            double equivlength = equivlengthratio * (ID / 12.0);
            length += equivlength;
        }
        if (v.equalsIgnoreCase("Check")) {
            //this creates a new object and obtains the equivalent length
            Check check = new Check();
            double equivlengthratio = check.getEquivalentLengthRatio();
            double equivlength = equivlengthratio * (ID / 12.0);
            length += equivlength;
        }

    }

    public double getLength(){
        return length;
    }

    public int getNPS() {
        return npsIndex;
    }

    public double getID() {
        return ID;
    }

    public double getAbsoluteRoughness() {
        return absoluteRoughness;
    }

    public double getFlowRate() {
        return flowRate;
    }

    public double getViscosity() {
        return viscosity;
    }

    public double getDensity() {
        return density;
    }

    public double getElevationchange() {
        return elevationchange;
    }


    //returns the results array from the PressureLoss class
    public double[] getPressureLoss() {

        double[] pressureLoss = PressureLoss.pressureLossCalc(
        flowRate,
        ID,
        viscosity,
        absoluteRoughness,
        length,
        density,
        elevationchange);

        return pressureLoss;

    }

    //return results array from the Estimation class
    public double[] getEstimation() {

        double[] pipeEstimation = Estimation.pipeEstimationCalc(length);

        return pipeEstimation;

    }


}
