package backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回 s 所有可能的分割方案。
 * <p>
 * 示例:
 * <p>
 * 输入: "aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cwp
 */
public class Partition_131 {
    private List<List<String>> result = new ArrayList<>();

    private int length;

    public List<List<String>> partition(String s) {
        length = s.length();
        Deque<String> path = new ArrayDeque<>();
        backtracking(s, 0, path);
        return result;
    }

    /**
     * @param s
     * @param start 起始字符的索引
     */
    private void backtracking(String s, int start, Deque<String> path) {
        if (start == length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < length; i++) {
            if (!checkPalindrome(s, start, i)) {
                continue;
            }
            path.addLast(s.substring(start, i + 1));
            backtracking(s, i + 1, path);
            path.removeLast();
        }

    }

    /**
     * 这一步的时间复杂度是 O(N)，因此，可以采用动态规划先把回文子串的结果记录在一个表格里
     *
     * @param str
     * @param left  子串的左边界，可以取到
     * @param right 子串的右边界，可以取到
     * @return
     */
    private boolean checkPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Partition_131 partition_131 = new Partition_131();
        List<List<String>> aab = partition_131.partition("aab");
        System.out.println(aab);
    }
}
