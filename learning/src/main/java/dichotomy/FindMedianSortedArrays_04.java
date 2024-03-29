package dichotomy;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组nums1 和nums2。
 * <p>
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为O(log(m + n))。
 * <p>
 * 你可以假设nums1和nums2不会同时为空。
 * <p>
 * 
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cwp
 */
public class FindMedianSortedArrays_04 {

    public static void main(String[] args) {
        int[] nums1 = {10001};
        int[] nums2 = {10000};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    /**
     *  时间复杂度达不到 O(log(m+n))
     * @param nums1
     * @param nums2
     * @return
     */
    @Deprecated
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int left = 0;
        int right = 0;
        int size = (nums1.length + nums2.length) / 2 + 1;

        boolean isEven = (nums1.length + nums2.length) % 2 == 0;

        int[] ints = new int[size];
        for (int a = 0; a < size; a++) {
            if ((left != -1)  && nums1.length > 0 && (nums2.length == 0 || right == -1|| (nums1[left] <= nums2[right])) ){
                ints[a] = nums1[left++];
                if (left >= nums1.length) {
                    left = -1;
                }
            } else{
                ints[a] = nums2[right];
                right++;
                if (right >= nums2.length) {
                    right = -1;
                }
            }
        }


        if (isEven) {
            return (double) (ints[ints.length - 1] + ints[ints.length - 2]) / 2;
        }

        return ints[ints.length - 1];
    }


    /**
     *  二分查找
     *  时间复杂度：O(\log(m+n))O(log(m+n))，
     *  其中 mm 和 nn 分别是数组 \text{nums1}nums1 和 \text{nums2}nums2 的长度。
     *  初始时有 k=(m+n)/2k=(m+n)/2 或 k=(m+n)/2+1k=(m+n)/2+1，
     *  每一轮循环可以将查找范围减少一半，因此时间复杂度是 O(\log(m+n))O(log(m+n))。
     *
     * 空间复杂度：O(1)。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
         * 这里的 "/" 表示整除
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */

        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
