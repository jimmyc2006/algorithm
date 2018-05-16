import java.util.Arrays;

import edu.princeton.cs.algs4.Merge;

public class FastCollinearPoints {
    private LineSegment[] lineSegment;
    private static final int NUMBERS = 4;
    private int lineCount = 0;

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

    private void cal(Point[] points) {
        Point[] heads = new Point[points.length];
        Point[] tails = new Point[points.length];
        double[] slopes = new double[points.length];
        Merge.sort(points);
        int N = points.length;
        for (int i = 0; i < N - 3; i++) {
            Point base = points[i];
            Point[] otherPoints = this.sort(base, points, i + 1, N);
            double currentSlope = base.slopeTo(otherPoints[0]);
            int sameCount = 2;
            for (int j = 1; j < otherPoints.length; j++) {
                double slope = base.slopeTo(otherPoints[j]);
                if (slope == currentSlope) {
                    sameCount++;
                } else {
                    if (sameCount >= NUMBERS) {
                        addLineIfSatisfy(heads, tails, slopes, base, otherPoints[j - 1], currentSlope);
                    }
                    sameCount = 2;
                    currentSlope = slope;
                }
                // 处理最后一个的问题
                if (j == otherPoints.length - 1) {
                    if (sameCount >= NUMBERS) {
                        addLineIfSatisfy(heads, tails, slopes, base, otherPoints[j - 1], currentSlope);
                    }
                }
            }
        }
        if (this.lineCount > 0) {
            this.lineSegment = new LineSegment[this.lineCount];
            for (int i = 0; i < this.lineCount; i++) {
                lineSegment[i] = new LineSegment(heads[i], tails[i]);
            }
        }
    }

    private void addLineIfSatisfy(Point[] heads, Point[] tails, double[] slopes, Point start, Point end, double slope) {
        for (int i = 0; i < this.lineCount; i++) {
            if (start.compareTo(heads[i]) == 0 || start.compareTo(heads[i]) == 0 || end.compareTo(tails[i]) == 0
                    || end.compareTo(heads[i]) == 0) {
                if (slope == slopes[i]) {
                    // 已经有的
                    return;
                }
            }
        }
        heads[lineCount] = start;
        tails[lineCount] = end;
        slopes[lineCount] = slope;
        lineCount++;
    }

    private Point[] sort(Point basePoint, Point[] a, int start, int end) {
        Point[] result = Arrays.copyOfRange(a, start, end);
        Arrays.sort(result, basePoint.slopeOrder());
        return result;
    }

    // the number of line segments
    public int numberOfSegments() {
        return this.lineCount;
    }

    // the line segments
    public LineSegment[] segments() {
        return this.lineSegment;
    }
}
