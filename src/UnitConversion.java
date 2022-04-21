public class UnitConversion {

    public static double metersToFeet(double m){
        return m * 3.281;
    }

    public static double metersToMillimeters(double m) {
        return m * 1000;
    }

    public static double metersToInches(double m){
        return m * 39.37;
    }

    public static double feetToMeters(double f){
        return f / 3.281;
    }

    public static double feetToMillimeters(double f) {
        return f * 304.8;
    }

    public static double feetToInches(double f){
        return f * 12;
    }

    public static double millimetersToMeters(double mm) {
        return mm / 1000;
    }

    public static double millimetersToFeet(double mm) {
        return mm / 304.8;
    }

    public static double millimetersToInches(double mm) {
        return mm / 25.4;
    }

    public static double inchesToMeters(double i){
        return i / 39.37;
    }

    public static double inchesToFeet(double i){
        return i / 12;
    }

    public static double inchesToMillimeters(double i) {
        return i * 25.4;
    }

}
