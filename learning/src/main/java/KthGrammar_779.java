/**
 * 我们构建了一个包含 n 行( 索引从 1  开始 )的表。首先在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 * <p>
 * 例如，对于 n = 3 ，第 1 行是 0 ，第 2 行是 01 ，第3行是 0110 。
 * 给定行数 n 和序数 k，返回第 n 行中第 k 个字符。（ k 从索引 1 开始）
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1, k = 1
 * 输出: 0
 * 解释: 第一行：0
 * 示例 2:
 * <p>
 * 输入: n = 2, k = 1
 * 输出: 0
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * 示例 3:
 * <p>
 * 输入: n = 2, k = 2
 * 输出: 1
 * 解释:
 * 第一行: 0
 * 第二行: 01
 *
 * @author cwp
 * @date 2022-10-20 10:44
 */
public class KthGrammar_779 {
    /**
     * 内存过多
     *
     * @param n
     * @param k
     * @return
     */
    public int kthGrammar(int n, int k) {
        String[] dp = new String[n];
        dp[0] = "0";
        for (int a = 1; a < n; a++) {
            String s = dp[a - 1];
            char[] chars = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char c : chars) {
                sb.append(c == '0' ? "01" : "10");
            }
            dp[a] = sb.toString();
        }

        return dp[n - 1].charAt(k - 1) - 48;
    }



    public static void main(String[] args) {
        KthGrammar_779 kthGrammar_779 = new KthGrammar_779();
        int i = kthGrammar_779.kthGrammar(30, 2);
        System.out.println(i);
    }
}
