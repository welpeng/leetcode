package backtracking;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cwp
 * @date 2022-07-12 17:06
 */
public class PermuteUnique_47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);

        backtrack(res, path, nums, len, used);
        return res;
    }

    private void backtrack(List<List<Integer>> res, Deque<Integer> path, int[] nums, int len, boolean[] used) {
        if (path.size() == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int a = 0; a < len; a++) {
            if (used[a]) {
                continue;
            }
            if (a > 0 && nums[a - 1] == nums[a] && !used[a - 1]) {
                continue;
            }
            path.add(nums[a]);
            used[a] = true;
            backtrack(res, path, nums, len, used);
            used[a] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        PermuteUnique_47 permuteUnique_47 = new PermuteUnique_47();
        List<List<Integer>> lists = permuteUnique_47.permuteUnique(new int[]{1, 2, 3,4});
        System.out.println(lists);
    }
}
