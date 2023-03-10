/**
 * 7. 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * <p>
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * <p>
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * <p>
 * 输入：x = 0
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * -231 <= x <= 231 - 1
 *
 * @author cwp
 * @date 2022-09-05 9:19
 */
public class Reverse_47 {

    public int reverse(int x) {
        int tmp = 0;
        int res = 0;
        int i = Integer.MAX_VALUE / 10;
        int j = Integer.MAX_VALUE % 10;
        int xa = Math.abs(x);
        while ((tmp = xa % 10) != 0) {
            res = tmp + res * 10;
            if (res > i || (res == i && (xa % 10) > j)) {
                return 0;
            }
        }
        return x > 0 ? res : -res;
    }

    public static void main(String[] args) {
        Reverse_47 reverse_47 = new Reverse_47();
        int reverse = reverse_47.reverse(-123);
        System.out.println(reverse);
    }

}
