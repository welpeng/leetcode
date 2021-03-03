package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.12. 八皇后
 * <p>
 * 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
 * <p>
 * 注意：本题相对原题做了扩展
 * <p>
 * 示例:
 * <p>
 * 输入：4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * <p>
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/eight-queens-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cwp
 */
public class SolveNQueens {
    private List<List<String>> result = new ArrayList<>();

    public static void main(String[] args) {

        SolveNQueens solveNQueens = new SolveNQueens();
        List<List<String>> lists = solveNQueens.solveNQueens(4);
        System.out.println(lists);

    }

    List<List<String>> solveNQueens(int n) {
        //初始化棋盘
        ArrayList<String> board = new ArrayList<>();
        for (int a = 0; a < n; a++) {
            char[] chars = new char[n];
            for (int b = 0; b < n; b++) {
                chars[b] = '.';
            }
            board.add(new String(chars));
        }

        backtrack(board, 0);
        return result;
    }

    private void backtrack(ArrayList<String> board, int row) {
        if (row == board.size()) {
            ArrayList<String> ll = new ArrayList<>(board);
            result.add(ll);
            return;
        }

        int n = board.size();

        for (int col = 0; col < n; col++) {
            if (!isvalid(board, row, col)) {
                continue;
            }
            //做选择
            replace(board, row, col, 'Q');
            //进入下一行决策
            backtrack(board, row + 1);
            //撤销选择
            replace(board, row, col, '.');

        }
    }


    /**
     *  校验剪枝
     * @param board
     * @param row
     * @param col
     * @return
     */
    private boolean isvalid(ArrayList<String> board, int row, int col) {
        int n = board.size();
        // 检查列是否有皇后互相冲突
        for (int i = 0; i < n; i++) {
            if (board.get(i).charAt(col) == 'Q')
                return false;
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q')
                return false;
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q')
                return false;
        }
        return true;
    }

    private void replace(ArrayList<String> board, int row, int col, Character c) {
        String s = board.get(row);
        char[] chars = s.toCharArray();
        chars[col] = c;
        board.set(row, new String(chars));
    }
}
