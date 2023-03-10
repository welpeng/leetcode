package dynamicprogramming;

/**
 * 45. 跳跃游戏 II
 * <p>
 * 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
 * 示例 2:
 * <p>
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cwp
 * @date 2022-07-08 12:05
 */
public class JumpII_45 {
    public int jump(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    public int jump2(int[] nums) {
        int length = nums.length;
        // 上次跳跃可达范围右边界（下次的最右起跳点）
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 1, 4};
        JumpII_45 jumpII_45 = new JumpII_45();
        int i = jumpII_45.jump2(arr);
        System.out.println(i);
    }
}
