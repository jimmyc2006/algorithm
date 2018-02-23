import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.princeton.cs.algs4.Merge;

public class FastCollinearPoints {
    private LineSegment[] lineSegment;

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
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

    private Map<Point, Double> endPointAndSlope = new HashMap<>();
    private List<LineSegment> lines = new ArrayList<>();
    
    private void cal(Point[] points) {
        Merge.sort(points);
        int N = points.length;
        for (int i = 0; i < N - 3; i++) {
            Point base = points[i];
            Point[] otherPoints = this.sort(base, points, i + 1, N);
            double currentSlope = base.slopeTo(otherPoints[0]);
            int sameCount = 2;
            // 如何去掉中途的线？
            for (int j = 1; j < otherPoints.length; j++) {
                double slope = base.slopeTo(otherPoints[j]);
                if (slope == currentSlope) {
                    sameCount++;
                } else {
                    addIfSatisfy(sameCount, base, otherPoints[j - 1], currentSlope);
                    sameCount = 2;
                    currentSlope = slope;
                }
                // 处理最后一个的问题
                if (j == otherPoints.length - 1) {
                    addIfSatisfy(sameCount, base, otherPoints[j - 1], currentSlope);
                }
            }
        }
        this.lineSegment = lines.toArray(new LineSegment[lines.size()]);
    }

    private void addIfSatisfy(int sameCount, Point start, Point end, double currentSlope) {
        if (sameCount >= 4) {
            if (endPointAndSlope.get(end) == null || endPointAndSlope.get(end) != currentSlope) {
                lines.add(new LineSegment(start, end));
                endPointAndSlope.put(end, currentSlope);
            }
        }
    }

    private Point[] sort(Point basePoint, Point[] a, int start, int end) {
        Point[] result = Arrays.copyOfRange(a, start, end);
        Arrays.sort(result, basePoint.slopeOrder());
        return result;
    }

    // the number of line segments
    public int numberOfSegments() {
        return this.lineSegment.length;
    }

    // the line segments
    public LineSegment[] segments() {
        return this.lineSegment;
    }
}
