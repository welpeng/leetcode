import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * //示例 1:
 * //
 * //输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * //输出: True
 * //示例 2:
 * //
 * //输入：p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
 * //输出：false
 * //示例 3:
 * //
 * //输入：p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
 * //输出：true
 *
 * @author cwp
 * @date 2022-07-29 12:02
 */
public class ValidSquare_593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        int x1 = Math.abs(p1[0] - p2[0]);
        int y1 = Math.abs(p1[1] - p2[1]);
        int x2 = Math.abs(p1[0] - p3[0]);
        int y2 = Math.abs(p1[1] - p3[1]);
        int x3 = Math.abs(p1[0] - p4[0]);
        int y3 = Math.abs(p1[1] - p4[1]);

        List<Integer> sum = new ArrayList<>();
        sum.add(x1 * x1 + y1 * y1);
        sum.add(x2 * x2 + y2 * y2);
        sum.add(x3 * x3 + y3 * y3);

        Collections.sort(sum);
        System.out.println(sum);

        if (sum.get(0).equals(0)) {
            return false;
        }
        return sum.get(0).equals(sum.get(1)) && sum.get(0) + sum.get(1) == sum.get(2);
    }

    public static void main(String[] args) {
        ValidSquare_593 validSquare_593 = new ValidSquare_593();
        //[0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
        int[] p1 = {0,1};
        int[] p2 = {1,2};
        int[] p3 = {0,2};
        int[] p4 = {0,0};
        boolean b = validSquare_593.validSquare(p1, p2, p3, p4);
        System.out.println(b);

    }
}
