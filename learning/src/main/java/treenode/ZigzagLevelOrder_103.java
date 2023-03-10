package treenode;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 *  3
 * / \
 * 9  20
 *   /  \
 * 15   7
 * 返回锯齿形层序遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cwp
 */
public class ZigzagLevelOrder_103 {

    public static void main(String[] args) {
        ZigzagLevelOrder_103 zigzagLevelOrder_103 = new ZigzagLevelOrder_103();
        TreeNode treeNode = TreeNode.stringToTreeNode("[3,9,20,null,null,15,7]");
        List<List<Integer>> lists = zigzagLevelOrder_103.zigzagLevelOrder(treeNode);
        System.out.println(lists);
    }
/*

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {


    }
*/














    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode root, List<List<Integer>> res, int depth) {
        if (root == null) {
            return;
        }

        if(res.size() <= depth) {
            LinkedList<Integer> list = new LinkedList<>();
            list.push(root.val);
            res.add(list);
        }else {
            LinkedList<Integer> integers = (LinkedList<Integer>) res.get(depth);
            if (depth % 2 == 0) {
                integers.add(root.val);
            } else {
                integers.push(root.val);
            }
        }

        dfs(root.left, res, depth + 1);
        dfs(root.right, res, depth + 1);
    }
}
