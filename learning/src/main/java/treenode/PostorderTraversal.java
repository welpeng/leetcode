package treenode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cwp
 */
public class PostorderTraversal {


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(7);
        treeNode2.left = new TreeNode(3);
        treeNode2.right = new TreeNode(6);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;

        List<Integer> integers = postorderTraversal2(treeNode);
        System.out.println(integers);


    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }

    public static List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();

        if (null == root) {
            return list;
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.push(root);

        while (!treeNodes.isEmpty()) {
            TreeNode poll = treeNodes.poll();
            list.addFirst(poll.val);


            if (poll.left != null) {
                treeNodes.push(poll.left);
            }
            if (poll.right != null) {
                treeNodes.push(poll.right);
            }
        }
        return list;

    }

}
