package treenode;

/**
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 *
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 * 示例 2：
 *
 * 输入：root = []
 * 输出：0
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 树中节点的数目范围是[0, 5 * 104]
 * 0 <= Node.val <= 5 * 104
 * 题目数据保证输入的树是 完全二叉树
 *  
 *
 * 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author cwp
 */
public class CountNodes_222 {
    int count = 0;

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.stringToTreeNode("[1,2,3,4,5,6]");
        CountNodes_222 countNodes_222 = new CountNodes_222();
        int i = countNodes_222.countNodes(treeNode);
        System.out.println(i);
    }
    /*public int countNodes(TreeNode root) {
        dfs(root);
        return count;
    }

    private void dfs(TreeNode root) {

        if (root == null) {
            return;
        }
        count++;
        dfs(root.left);
        dfs(root.right);
    }*/

    /**
     * 最大层数为 hh 的完全二叉树，节点个数一定在 [2^h,2^{h+1}-1][2
     * h
     *  ,2
     * h+1
     *  −1] 的范围内，可以在该范围内通过二分查找的方式得到完全二叉树的节点个数。
     *
     * 具体做法是，根据节点个数范围的上下界得到当前需要判断的节点个数 kk，如果第 kk 个节点存在，则节点个数一定大于或等于 kk，如果第 kk 个节点不存在，则节点个数一定小于 kk，由此可以将查找的范围缩小一半，直到得到节点个数。
     *
     * 如何判断第 kk 个节点是否存在呢？如果第 kk 个节点位于第 hh 层，则 kk 的二进制表示包含 h+1h+1 位，其中最高位是 11，其余各位从高到低表示从根节点到第 kk 个节点的路径，00 表示移动到左子节点，11 表示移动到右子节点。通过位运算得到第 kk 个节点对应的路径，判断该路径对应的节点是否存在，即可判断第 kk 个节点是否存在。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes/solution/wan-quan-er-cha-shu-de-jie-dian-ge-shu-by-leetco-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean exists(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }

}
