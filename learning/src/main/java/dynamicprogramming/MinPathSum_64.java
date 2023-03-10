package dynamicprogramming;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 示例 2：
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cwp
 * @date 2022-07-07 10:01
 */
public class MinPathSum_64 {

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        if (n <= 0) {
            return 0;
        }
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        for (int j = 1; j < m; j++) {
            dp[j][0] = dp[j - 1][0] + grid[j][0];
        }

        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }


        for (int a = 1; a < m; a++) {
            for (int b = 1; b < n; b++) {
                dp[a][b] = Math.min(dp[a][b - 1], dp[a - 1][b]) + grid[a][b];
            }
        }

        return dp[m - 1][n - 1];

    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}};
        MinPathSum_64 minPathSum_64 = new MinPathSum_64();
        int i = minPathSum_64.minPathSum(arr);
        System.out.println(i);

    }
}
