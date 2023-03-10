package doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含n 个整数的数组nums和一个目标值target，判断nums中是否存在四个元素 a，b，c和 d，
 * 使得a + b + c + d的值与target相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * <p>
 * <p>
 * 注意：答案中不可以包含重复的四元组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cwp
 */
public class FourSum_18 {
    public static void main(String[] args) {
        FourSum_18 fourSum_18 = new FourSum_18();
        int[] arr = new int[]{0, 0, 0, -1000000000, -1000000000, -1000000000, -1000000000,
                -1000000000};
        int target = -1000000000;
        List<List<Integer>> lists = fourSum_18.fourSum(arr, target);
        System.out.println(lists);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> quadruplets = new ArrayList<>();

        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long)nums[i] + (long)nums[i + 1] + (long)nums[i + 2] + (long)nums[i + 3] > target) {
                break;
            }
            if ((long)nums[i] + (long)nums[length - 3] + (long)nums[length - 2] + (long)nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long)nums[i] + (long)nums[j] + (long)nums[j + 1] + (long)nums[j + 2] > target) {
                    break;
                }
                if ((long)nums[i] + (long)nums[j] + (long)nums[length - 2] + (long)nums[length - 1] < target) {
                    continue;
                }
                int left = j + 1, right = length - 1;
                while (left < right) {
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[left] + (long)nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;

    }
}

