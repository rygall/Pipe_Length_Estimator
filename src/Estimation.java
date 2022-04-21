public class Estimation {

    public static double[] pipeEstimationCalc(double l) {

        double estLength = l * 1.25;
        double elbows90 =  Math.ceil(l / 8);
        double elbows45 = Math.ceil(l / 4);

        double[] estResults = new double[3];

        estResults[0] = estLength;
        estResults[1] = elbows90;
        estResults[2] = elbows45;

        return estResults;

    }


}
