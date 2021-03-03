package dynamicprogramming;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cwp
 */
public class UniquePaths_62 {

    public static void main(String[] args) {
        int i = uniquePaths(3, 2);
        System.out.println(i);
    }

    public static int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        for (int a = 0; a < m; a++) {
            dp[a][0] = 1;
        }
        for (int b = 0; b < n; b++) {
            dp[0][b] = 1;
        }

        for (int a = 1; a < m; a++) {
            for (int b = 1; b < n; b++) {
                dp[a][b] = dp[a][b-1] + dp[a-1][b];
            }
        }
        return dp[m-1][n-1];
    }
}
