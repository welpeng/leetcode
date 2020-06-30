package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums?和一个目标值 target，请你在该数组中找出和为目标值的那?两个?整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * ?
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 *
 * @author cwp
 */
public class TwoSum_01 {
    public static void main(String[] args) {

        int[] nums = {3,3};
//        int[] nums = {2,7,11,15};

        int[] ints = twoSum(nums, 6);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int a = 0; a < nums.length; a++) {
            map.put(nums[a], a);
        }
        for (int a = 0; a < nums.length; a++) {
            int look = target - nums[a];
            if (map.containsKey(look) && (map.get(look) != a)){
                result[0] = map.get(look);
                result[1] = a;
                return result;
            }
        }
        throw new IllegalArgumentException("error");
    }
}
