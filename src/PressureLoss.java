public class PressureLoss {

    public static double[] pressureLossCalc(double q, double id, double v,
                                            double ar, double len, double den, double el) {


        //these system outputs allow us to determine if we are getting out the same
        //values that we are getting within the PipeEstimator main class
        System.out.println("Flow Rate: " + q);
        System.out.println("Inner Diameter: " + id);
        System.out.println("Viscosity: " + v);
        System.out.println("Absolute Roughness: " + ar);
        System.out.println("Length: " + len);
        System.out.println("Density: " + den);
        System.out.println("Elevation Change: " + el);


        //calculating relevant numbers to show for results and for calculations
        double velocity = (0.4084 * q) / (id * id);
        //System.out.println(velocity);
        double Re = (velocity * (id / 12.0)) / v;
        //System.out.println(Re);
        double relrough = ar / (id / 12.0);
        //System.out.println(relrough);


        //CALCULATING A, B OR F IS WRONG. I NEED TO FIX
        //below is the friction factor, F, calculation using the Churchill Equation.
        //the calculations are broken up into small steps.
        //calculating A
        double b = (7.0 / Re);
        //System.out.println(b);
        double c = (Math.pow(b, 0.9));
        //System.out.println(c);
        double d = (0.27 * relrough);
        //System.out.println(d);
        double e = (c + d);
        //System.out.println(e);
        double f = (1.0 / e);
        //System.out.println(f);
        double g = Math.log(f);
        //System.out.println(g);
        double h = (2.457 * g);
        //System.out.println(h);
        double A = Math.pow(h, 16.0);
        //System.out.println(A);

        //calculating B
        double i = (37530.0 / Re);
        //System.out.println(i);
        double B = (Math.pow(i, 16.0));
        //System.out.println(B);

        //calculating friction factor
        double j = (A + B);
        //System.out.println(j);
        double k = (Math.pow(j, 1.5));
        //System.out.println(k);
        double l = (1.0 / k);
        //System.out.println(l);
        double m = (8.0 / Re);
        //System.out.println(m);
        double n = (Math.pow(m, 12.0));
        //System.out.println(n);
        double o = (n + l);
        //System.out.println(o);
        double p = (Math.pow(o, 0.08333333));
        //System.out.println(p);
        double F = (8.0 * p);
        //System.out.println(F);

        //the friction factor, F, can now be used in the Darcy-Weisbach Equation to determine
        //pressure loss due to frictional losses.
        double r = (velocity * velocity);
        //System.out.println(r);
        double s = ((den * r) / 2.0);
        //System.out.println(s);
        double t = (len / (id / 12.0));
        //System.out.println(t);
        //this is all calculated out in feet then divided by 144 to convert to psi instead of psf
        double frictionpsi = (F * (t * s)) / 144.0;
        //System.out.println(frictionpsi);

        //below is the calculating of pressure loss or gain due to change in elevation
        double elevationpsi = (den * el) / 144.0;
        //System.out.println(elevationpsi);

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
