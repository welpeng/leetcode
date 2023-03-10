package backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cwp
 * @date 2022-08-02 9:10
 */
public class SubsetsWithDup_90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        // 记录回溯算法的递归路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(res, track, 0, nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, LinkedList<Integer> track, int start, int[] nums) {
        res.add(new LinkedList<>(track));
        System.out.println(res);
        for (int a = start; a < nums.length; a++) {
            if (a > start && nums[a] == nums[a - 1]) {
                continue;
            }
            track.addLast(nums[a]);

            backtrack(res, track, a + 1, nums);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        SubsetsWithDup_90 subsetsWithDup_90 = new SubsetsWithDup_90();
        List<List<Integer>> lists = subsetsWithDup_90.subsetsWithDup(new int[]{1, 2, 2});
        System.out.println(lists);

    }
}
