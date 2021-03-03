package treenode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题 04.03. 特定深度节点链表
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 *
 *  
 *
 * 示例：
 *
 * 输入：[1,2,3,4,5,null,7,8]
 *
 *         1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *    /
 *   8
 *
 * 输出：[[1],[2,3],[4,5,7],[8]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/list-of-depth-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author cwp
 */
public class ListOfDepth_m0403 {
    public static void main(String[] args) {

    }

    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> ans = new ArrayList<>();
        dfs(tree, ans, 0);
        return ans.toArray(new ListNode[0]);
    }

    private void dfs(TreeNode tree, List<ListNode> ans, int dept) {
        if (tree == null) {
            return ;
        }
        if (ans.size() <= dept) {
            // 如果ans的size小于等于dept,表示当前深度的节点还未添加到ans中
            ans.add(new ListNode(tree.val));
        } else {
            ListNode node = new ListNode(tree.val);
            node.next = ans.get(dept);
            ans.set(dept, node);
        }
        // 先递归遍历右子树是因为，如果先遍历左子树的话，无法获取每个层级链表的最后一个节点
        // 先遍历右子树的话，就相当于先获取到每个层级的后面的节点，然后让当前节点的next指向它
        dfs(tree.right, ans, dept + 1);
        dfs(tree.left, ans, dept + 1);

    }
}
