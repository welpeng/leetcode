package other;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 * <p>
 * 提示：
 * <p>
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cwp
 */
public class AddBinary_67 {
    public static void main(String[] args) {
        AddBinary_67 add = new AddBinary_67();
        String s = add.addBinary("1010", "1011");
        System.out.println(s);


    }
    public String addBinary(String a, String b) {
        if (null == b || b.length() == 0) {
            return a;
        }
        int al = a.length();
        int bl = b.length();
        int max = Math.max(al, bl);
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (i = 0; i < max; i++) {
            int as = (a.length() - 1 - i) >= 0 ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            int bs = (b.length() - 1 - i) >= 0 ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            int sum = as + bs;
            if (carry == 1) {
                sum += 1;
                carry = 0;
            }
            if (sum >= 2) {
                carry = 1;
                sum -= 2;
            }
            sb.append(sum);
        }

        if (carry > 0){
            sb.append("1");
        }
        return sb.reverse().toString();
    }


}
