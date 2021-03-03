package treenode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * <p>
 *  
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 *  
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 1000
 * 注意：本题与主站 102 题相同：
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cwp
 */
public class LevelOrder_jz32 {

    public static void main(String[] args) {

        TreeNode treeNode = TreeNode.stringToTreeNode("[1,2,3,4,5,6,7]");
        LevelOrder_jz32 levelOrder_jz32 = new LevelOrder_jz32();
        List<List<Integer>> lists = levelOrder_jz32.levelOrder(treeNode);


    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        dfs(lists, root, 0);
        return lists;
    }

    private void dfs(List<List<Integer>> lists, TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        int size = lists.size();
        if (size <= depth) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            lists.add(list);
        } else {
            List<Integer> integers = lists.get(depth);
            integers.add(root.val);
        }
        dfs(lists, root.left, depth + 1);
        dfs(lists, root.right, depth + 1);
    }


}
