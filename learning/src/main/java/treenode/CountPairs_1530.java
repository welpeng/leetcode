package treenode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数 distance 。
 * <p>
 * 如果二叉树中两个 叶 节点之间的 最短路径长度 小于或者等于 distance ，那它们就可以构成一组 好叶子节点对 。
 * <p>
 * 返回树中 好叶子节点对的数量 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,4], distance = 3
 * 输出：1
 * 解释：树的叶节点是 3 和 4 ，它们之间的最短路径的长度是 3 。这是唯一的好叶子节点对。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6,7], distance = 3
 * 输出：2
 * 解释：好叶子节点对为 [4,5] 和 [6,7] ，最短路径长度都是 2 。但是叶子节点对 [4,6] 不满足要求，因为它们之间的最短路径长度为 4 。
 * 示例 3：
 * <p>
 * 输入：root = [7,1,4,6,null,5,3,null,null,null,null,null,2], distance = 3
 * 输出：1
 * 解释：唯一的好叶子节点对是 [2,5] 。
 * 示例 4：
 * <p>
 * 输入：root = [100], distance = 1
 * 输出：0
 * 示例 5：
 * <p>
 * 输入：root = [1,1,1], distance = 2
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * tree 的节点数在 [1, 2^10] 范围内。
 * 每个节点的值都在 [1, 100] 之间。
 * 1 <= distance <= 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-good-leaf-nodes-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cwp
 */
public class CountPairs_1530 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.stringToTreeNode("[1,2,3,4,5,6,7]");
        CountPairs_1530 countPairs_1530 = new CountPairs_1530();
        int i = countPairs_1530.countPairs(treeNode, 2);
        System.out.println(i);
    }
    private int res = 0;
    public int countPairs(TreeNode root, int distance) {
        recur(root, distance);
        return res;
    }

    private List<Integer> recur(TreeNode root, int distance) {//抽象为每个子节点到自己的距离
        if(root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(root.left == null && root.right == null) {
            list.add(1);
            return list;
        }

        List<Integer> left = recur(root.left, distance);
        for(int item : left) {
            if(++item > distance) continue;
            list.add(item);
        }

        List<Integer> right = recur(root.right, distance);
        for(int item : right) {
            if(++item > distance) continue;
            list.add(item);

        }

        for(int item1: left) {
            for(int item2: right) {
                res += (item1 + item2) <= distance ? 1 : 0;
            }
        }

        return list;
    }
}
