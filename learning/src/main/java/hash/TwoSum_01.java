package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ����һ���������� nums?��һ��Ŀ��ֵ target�������ڸ��������ҳ���ΪĿ��ֵ����?����?���������������ǵ������±ꡣ
 * <p>
 * ����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ�������ͬһ��Ԫ�ز���ʹ�����顣
 * <p>
 * ?
 * <p>
 * ʾ��:
 * <p>
 * ���� nums = [2, 7, 11, 15], target = 9
 * <p>
 * ��Ϊ nums[0] + nums[1] = 2 + 7 = 9
 * ���Է��� [0, 1]
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/two-sum
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
