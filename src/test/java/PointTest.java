import org.junit.Test;

public class PointTest {
    @Test
    public void testSlopeTo() {
        Point p1 = new Point(8, 8);
        Point p2 = new Point(8, 7);
        System.out.println(p1.slopeTo(p2));
    }
}
