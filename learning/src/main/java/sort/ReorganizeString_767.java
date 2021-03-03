package sort;

import java.util.Arrays;

/**
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * <p>
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 * <p>
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 * <p>
 * S 只包含小写字母并且长度在[1, 500]区间内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorganize-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cwp
 */
public class ReorganizeString_767 {

    public static void main(String[] args) {
        String a = "aab";
        ReorganizeString_767 aaa = new ReorganizeString_767();
        String s = aaa.reorganizeString(a);
        System.out.println(s);
    }

    public String reorganizeString(String S) {
        int N = S.length();
        int[] counts = new int[26];
        for (char c : S.toCharArray())
            counts[c - 'a'] += 100;
        for (int i = 0; i < 26; ++i)
            counts[i] += i;
        //Encoded counts[i] = 100*(actual count) + (i)
        Arrays.sort(counts);

        char[] ans = new char[N];
        int t = 1;
        for (int code : counts) {
            int ct = code / 100;
            char ch = (char) ('a' + (code % 100));
            if (ct > (N + 1) / 2)
                return "";
            for (int i = 0; i < ct; ++i) {
                if (t >= N)
                    t = 0;
                ans[t] = ch;
                t += 2;
            }
        }

        return String.valueOf(ans);


    }
}
