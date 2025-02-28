public final class Utils {

    public static boolean isNear(double[] x1y1Cord, double[] x2y2Cord, double sensitivity) {
        double distance = Math.sqrt(Math.pow(x2y2Cord[0] - x1y1Cord[0],2) + Math.pow(x2y2Cord[1] -x1y1Cord[1], 2));
        return distance <= sensitivity;
    }
}