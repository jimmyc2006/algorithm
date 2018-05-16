import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shuwei
 * @version 创建时间：2018年2月6日 上午10:06:30
 * 类说明
 */
public class TestA {
    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:/argorithm4/3/collinear/input8.txt"));
        System.out.println(br.readLine());
        List<Point> points = new ArrayList<>();
        while (true) {
            String line = br.readLine();
            if (line == null || "".equalsIgnoreCase(line)) {
                break;
            }
            line = line.trim();
            String[] n = line.split("\\s+");
            if (n.length > 1) {
                System.out.println("[" + n[0] + "], [" + n[1] + "]");
                points.add(new Point(Integer.parseInt(n[0]), Integer.parseInt(n[1])));
            }
        }
        System.out.println("size:" + points.size());
        FastCollinearPoints fcp = new FastCollinearPoints(points.toArray(new Point[points.size()]));
        System.out.println("segments:" + fcp.numberOfSegments());
        System.out.println("结果:" + Arrays.deepToString(fcp.segments()));
        br.close();
    }
    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        System.out.println(p1.compareTo(null));
    }
}
