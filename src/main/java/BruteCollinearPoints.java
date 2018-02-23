import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.StdIn;

public class BruteCollinearPoints {
    private LineSegment[] lineSegment;
    
    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException();
                }
            }
        }
        cal(points);
    }
    
    private void cal(Point[] points) {
        List<LineSegment> lines = new ArrayList<>();
        Merge.sort(points);
        int N = points.length;
        for (int a = 0 ; a < N; a++) {
            for (int b = a + 1; b < N; b++) {
                for (int c = b + 1; c < N; c++) {
                    if (points[a].slopeTo(points[b]) == points[a].slopeTo(points[c])) {
                        for (int d = c + 1; d < N; d++) {
                            if (points[a].slopeTo(points[b]) == points[a].slopeTo(points[d])) {
                                LineSegment ls = new LineSegment(points[a], points[d]);
                                lines.add(ls);
                            }
                        }
                    }
                }
            }
        }
        this.lineSegment = lines.toArray(new LineSegment[lines.size()]);
    }
    
    // the number of line segments
    public int numberOfSegments() {
        return lineSegment.length;
    }
    // the line segments
    public LineSegment[] segments() {
        return this.lineSegment;
    }
    
    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readLine().trim();
            String[] n = item.split("\\s+");
            if (n.length > 1) {
                System.out.println("[" + n[0] + "], [" + n[1] + "]");
                points.add(new Point(Integer.parseInt(n[0]), Integer.parseInt(n[1])));
            }
        }
        BruteCollinearPoints bcp = new BruteCollinearPoints(points.toArray(new Point[1]));
        System.out.println(bcp.numberOfSegments());
        System.out.println(Arrays.deepToString(bcp.lineSegment));
    }
}
