public class PressureLoss {

    public static double[] pressureLossCalc(double q, double id, double v,
                                            double ar, double len, double den, double el) {


        //calculating relevant numbers to show for results and for calculations
        double velocity = (0.4084 * q) / (id * id);
        //System.out.println(velocity);
        double Re = (velocity * (id / 12.0)) / v;
        //System.out.println(Re);
        double relrough = ar / (id / 12.0);
        //System.out.println(relrough);


        //below is the friction factor, F, calculation using the Churchill Equation.
        //the calculations are broken up into small steps.
        //calculating A
        double b = (7.0 / Re);
        double c = (Math.pow(b, 0.9));
        double d = (0.27 * relrough);
        double e = (c + d);
        double f = (1.0 / e);
        double g = Math.log(f);
        double h = (2.457 * g);
        double A = Math.pow(h, 16.0);

        //calculating B
        double i = (37530.0 / Re);
        double B = (Math.pow(i, 16.0));

        //calculating friction factor
        double j = (A + B);
        double k = (Math.pow(j, 1.5));
        double l = (1.0 / k);
        double m = (8.0 / Re);
        double n = (Math.pow(m, 12.0));
        double o = (n + l);
        double p = (Math.pow(o, 0.08333333));
        double F = (8.0 * p);

        //the friction factor, F, can now be used in the Darcy-Weisbach Equation to determine
        //pressure loss due to frictional losses.
        double r = (velocity * velocity);
        double s = ((den * r) / 2.0);
        double t = (len / (id / 12.0));
        //this is all calculated out in feet then divided by 144 to convert to psi instead of psf
        double frictionpsi = (F * (t * s)) / 144.0;

        //below is the calculating of pressure loss or gain due to change in elevation
        double elevationpsi = (den * el) / 144.0;

        //adding up total change in pressure
        double psi = elevationpsi + frictionpsi;

        //im packing up all the results into an array so that we can get them all out together.
        //it works out since they are all doubles, otherwise I think we'd have to do more work
        //outside the PressureLoss class to unpack the results.
        double[] results = new double[4];
        results[0] = velocity;
        results[1] = Re;
        results[2] = F;
        results[3] = psi;

        return results;


    }

}
