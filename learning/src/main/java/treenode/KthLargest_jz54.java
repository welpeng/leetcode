package treenode;

import java.util.*;

/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *  
 *
 * 限制：
 *
 * 1 ≤ k ≤ 二叉搜索树元素个数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author cwp
 */
public class KthLargest_jz54 {

    public static void main(String[] args) {
        KthLargest_jz54 kthLargest_jz54 = new KthLargest_jz54();
        TreeNode treeNode = TreeNode.stringToTreeNode("[5,3,6,2,4,null,null,1]");
        int i = kthLargest_jz54.kthLargest(treeNode, 3);
        System.out.println(i);

    }
    public int kthLargest(TreeNode root, int k) {

        ArrayList<Integer> list = new ArrayList<>();
        preorderTraversal(root, list);
        Collections.sort(list, (o1, o2) -> o2 - o1);
        Integer integer = list.get(k - 1);
        return integer;
    }

    private void preorderTraversal(TreeNode root, ArrayList<Integer> list) {
        if (root == null){
            return;
        }
        list.add(root.val);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
    }
}
