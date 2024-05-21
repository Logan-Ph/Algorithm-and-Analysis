package MockTest2;

public class problem1 {
    public static void main(String[] args) {
        SangSecretSearch sangSecretSearch = new SangSecretSearch(-1, 1, 1, 1, -1, 0.5);
        System.out.println(sangSecretSearch.timeFromA(0));
        System.out.println(sangSecretSearch.pointC());
    }
}

class SangSecretSearch {
    double XA, YA, VA, XB, YB, VB;

    public SangSecretSearch(double XA, double YA, double VA, double XB, double YB, double VB) {
        this.XA = XA;
        this.YA = YA;
        this.VA = VA;
        this.XB = XB;
        this.YB = YB;
        this.VB = VB;
    }

    public double timeFromA(double XZ) {
        double distance = Math.sqrt((XA - XZ) * (XA - XZ) + YA * YA);
        return distance / VA;
    }

    private double timeFromB(double XZ) {
        double distance = Math.sqrt((XB - XZ) * (XB - XZ) + YB * YB);
        return distance / VB;
    }

    public double pointC() {
        double eps = 0.0000001;
        double minX = XA;
        double maxX = XB;
        while (maxX - minX > eps) {
            double mid = (maxX + minX) / 2;
            double tA = timeFromA(mid);
            double tB = timeFromB(mid);
            if (tA < tB) {
                minX = mid;
            } else {
                maxX = mid;
            }
        }
        return maxX;
    }
}
