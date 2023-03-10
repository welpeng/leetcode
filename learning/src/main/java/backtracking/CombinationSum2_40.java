package backtracking;

import java.util.*;

/**
 * 给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * <p>
 * candidates中的每个数字在每个组合中只能使用一次。
 * <p>
 * 注意：解集不能包含重复的组合。
 * <p>
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入: candidates =[10,1,2,7,6,1,5], target =8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例2:
 * <p>
 * 输入: candidates =[2,5,2,1,2], target =5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <=candidates.length <= 100
 * 1 <=candidates[i] <= 50
 * 1 <= target <= 30
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cwp
 * @date 2022-07-14 15:53
 */
public class CombinationSum2_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;

    }

    /**
     * @param candidates 候选数组
     * @param len        冗余变量，是 candidates 里的属性，可以不传
     * @param target     每减去一个元素，目标值变小
     * @param path       从根结点到叶子结点的路径，是一个栈
     * @param res        结果集列表
     */
    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            // 大剪枝：减去 candidates[i] 小于 0，减去后面的 candidates[i + 1]、candidates[i + 2] 肯定也小于 0，因此用 break
            if (target - candidates[i] < 0) {
                break;
            }

            // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);

            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            dfs(candidates, i + 1, len, target - candidates[i], path, res);

            path.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSum2_40 combinationSum2_40 = new CombinationSum2_40();
        List<List<Integer>> lists = combinationSum2_40.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
        System.out.println(lists);
    }
}
