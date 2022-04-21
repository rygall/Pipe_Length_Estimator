public class Material {

    protected double absoluteRoughness;
    protected double[] IDs;

    public Material(){
        absoluteRoughness = 0;
        IDs = new double[]{};
    }

    public double getAbsoluteRoughness() {
        return absoluteRoughness;
    }
    public double getID(int i) {
        double id = 0;
        if (i == 0) {
            id = IDs[0];
        }
        if (i == 1) {
            id = IDs[1];
        }
        if (i == 2) {
            id = IDs[2];
        }
        if (i == 3) {
            id = IDs[3];
        }
        if (i == 4) {
            id = IDs[4];
        }
        if (i == 5) {
            id = IDs[5];
        }
        if (i == 6) {
            id = IDs[6];
        }
        if (i == 7) {
            id = IDs[7];
        }
        if (i == 8) {
            id = IDs[8];
        }
        if (i == 9) {
            id = IDs[9];
        }
        if (i == 10) {
            id = IDs[10];
        }
        if (i == 11) {
            id = IDs[11];
        }
        if (i == 12) {
            id = IDs[12];
        }
        if (i == 13) {
            id = IDs[13];
        }
        if (i == 14) {
            id = IDs[14];
        }
        if (i == 15) {
            id = IDs[15];
        }

        return id;
    }

}
