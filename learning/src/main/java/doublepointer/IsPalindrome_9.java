package doublepointer;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cwp
 */
public class IsPalindrome_9 {
    public static void main(String[] args) {
        IsPalindrome_9 isPalindrome_9 = new IsPalindrome_9();
        boolean palindrome = isPalindrome_9.isPalindrome(121);
        boolean palindrome1 = isPalindrome_9.isPalindrome(1212);
        boolean palindrome2 = isPalindrome_9.isPalindrome(10);
        boolean palindrome3 = isPalindrome_9.isPalindrome(-121);
        System.out.println("====");
    }
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int length = s.length();
        int start = 0;
        int end = length - 1;
        boolean flag = true;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                flag = false;
                break;
            }
            start++;
            end--;
        }
        return flag;
    }
}
