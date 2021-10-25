public class UnitsOfMeasurement {

    private double meters;
    private double feet;
    private double inches;


    public double metersToFeet(double m){
        feet = m * 3.281;
        return feet;
    }

    public double metersToInches(double m){
        inches = m * 39.37;
        return inches;
    }

    public double feetToMeters(double f){
        meters = f /  3.281;
        return meters;
    }

    public double feetToInches(double f){
        inches = f * 12;
        return inches;
    }

    public double inchesToFeet(double i){
        feet = i / 12;
        return feet;
    }

    public double inchesToMeters(double i){
        meters = i / 39.37;
        return meters;
    }

    public double getFeet(){
        return feet;
    }

    public double getMeters(){
        return meters;
    }

    public double getInches(){
        return inches;
    }


}
