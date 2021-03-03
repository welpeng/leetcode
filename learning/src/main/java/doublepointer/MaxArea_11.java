package doublepointer;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cwp
 */
public class MaxArea_11 {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = maxArea2(height);
        System.out.println(i);
    }

    /**
     * 暴力破解
     * 时间复杂 On2
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int length = height.length;

        int min;
        int sum = 0;
        for (int a = 0; a < length - 1; a++) {

            for (int b = a + 1; b < length; b++) {

                int start = height[a];
                int end = height[b];
                min = Math.min(start, end);
                sum = Math.max(min * (b - a), sum);
                System.out.println("" + start + "  " + end + "  " + sum);
            }
        }
        return sum;
    }


    /**
     * 双指针
     * 时间复杂度 On
     *
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        int start = 0;
        int end =  height.length - 1;
        int sum = 0;

        while (start < end) {
            if (height[start] < height[end]) {
                sum = Math.max(sum, (end - start) * height[start]);
                start++;
            } else {
                sum = Math.max(sum, (end - start) * height[end]);
                end--;
            }
        }
        return sum;

    }
}
