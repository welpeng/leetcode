package treenode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序 遍历。
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
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cwp
 */
public class InorderTraversal {

    static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.stringToTreeNode("[1,2,3,4,5,6,7]");
        InorderTraversal inorderTraversal = new InorderTraversal();
        List<Integer> integers = inorderTraversal(treeNode);
        System.out.println(integers);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }

    public static List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.push(root);
        TreeNode curr = root;
        while (curr != null || !treeNodes.isEmpty()) {
            while (curr != null) {
                treeNodes.push(curr);
                curr = curr.left;
            }
            curr = treeNodes.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }
}
