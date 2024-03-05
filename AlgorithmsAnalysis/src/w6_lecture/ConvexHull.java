package w6_lecture;

import java.util.Vector;

public class ConvexHull {

    public static void convexHull(Point[] points) {
        if (points.length < 3)
            return;

        Vector<Point> hull = new Vector<>();

        int l = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[i].x < points[l].x) {
                l = i;
            }
        }

        int p = l, q;
        do {
            hull.add(points[p]);
            q = (p + 1) % points.length;

            for (int i = 0; i < points.length; i++) {
                if (orientation(points[p], points[i], points[q]) == 2)
                    q = i;
            }

            p = q;
        } while (p != l);

        for (int i = 0; i < hull.size(); i++)
            System.out.println("(" + hull.get(i).x + ", " +
                    hull.get(i).y + ")");
    }

    public static int orientation(Point p, Point q, Point r) {
        int val = (q.y - p.y) * (r.x - q.x) -
                (q.x - p.x) * (r.y - q.y);

        if (val == 0)
            return 0; // colinear

        return (val > 0) ? 1 : 2;
    }

    public static void main(String[] args) {
        Point points[] = new Point[8];
        points[0] = new Point(0, 3);
        points[1] = new Point(1, 1);
        points[2] = new Point(2, 2);
        points[3] = new Point(4, 4);
        points[4] = new Point(0, 0);
        points[5] = new Point(1, 2);
        points[6] = new Point(3, 1);
        points[7] = new Point(3, 3);
        convexHull(points);
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
