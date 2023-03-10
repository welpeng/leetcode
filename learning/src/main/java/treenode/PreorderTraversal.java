package treenode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的前序遍历。
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
 * 输出: [1,2,3]
 * 进阶:递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cwp
 * <p>
 * 前序遍历是指，对于树中的任意节点来说，先打印这个节点，然后再打印它的左子树，最后打印它的右子树。
 * <p>
 * 中序遍历是指，对于树中的任意节点来说，先打印它的左子树，然后再打印它本身，最后打印它的右子树。
 * <p>
 * 后序遍历是指，对于树中的任意节点来说，先打印它的左子树，然后再打印它的右子树，最后打印这个节点本身。
 */
public class PreorderTraversal {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(7);
        treeNode2.left = new TreeNode(3);
        treeNode2.right = new TreeNode(6);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;

        List<Integer> integers = preorderTraversal(treeNode);
        System.out.println(integers);


    }

    public static List<Integer> preorderTraversal(TreeNode root) {

        if (root == null) {
            return list;
        }
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;

    }

    /**
     * 迭代
     * 递归的本质即 栈
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal2(TreeNode root) {

        if (null == root) {
            return list;
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.push(root);

        while (!treeNodes.isEmpty()) {
            TreeNode poll = treeNodes.poll();
            list.add(poll.val);
            if (poll.right != null) {
                treeNodes.push(poll.right);
            }
            if (poll.left != null) {
                treeNodes.push(poll.left);
            }
        }

        return list;

    }
}
