package backtracking;

import java.util.*;

/**
 * 77. 组合
 * <p>
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2：
 * <p>
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cwp
 * @date 2022-07-15 9:07
 */
public class Combine_77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        backtrack(1, n, k, path, res);
        return res;
    }

    private void backtrack(int begin, int n, int k, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i <= n; i++) {
            path.add(i);
            backtrack(i + 1, n, k, path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Combine_77 combine_77 = new Combine_77();
        List<List<Integer>> combine = combine_77.combine(4, 2);
        System.out.println(combine);
    }
}
