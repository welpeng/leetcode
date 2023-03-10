package linkedlist;

import linkedlist.base.ListNode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 *
 * @author cwp
 * @date 2022-09-26 9:39
 */

public class MergeKLists_23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode listNode = null;
        int startIndex = 0;
        for (; startIndex < lists.length; startIndex++) {
            if (lists[startIndex] != null) {
                listNode = lists[startIndex];
                break;
            }
        }

        for (int a = startIndex + 1; a < lists.length; a++) {
            ListNode listNodeIndex = lists[a];
            listNode = mergeTwoList(listNode, listNodeIndex);
        }

        return listNode;
    }

    public ListNode mergeTwoList(ListNode a, ListNode b) {
        ListNode prehead = new ListNode(0);

        ListNode prev = prehead;

        while (a != null && b != null) {
            int valA = a.val;
            int valB = b.val;
            if (valA < valB) {
                prev.next = new ListNode(valA);
                a = a.next;
            } else {
                prev.next = new ListNode(valB);
                b = b.next;
            }
            prev = prev.next;
        }

        prev.next = a == null ? b : a;
        return prehead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(5);
        listNode.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode11 = new ListNode(2);
        ListNode listNode12 = new ListNode(6);
        listNode11.next = listNode12;

        ListNode listNode21 = new ListNode(1);
        ListNode listNode22 = new ListNode(3);
        ListNode listNode23 = new ListNode(4);
        listNode21.next = listNode22;
        listNode22.next = listNode23;

        MergeKLists_23 mergeKLists_23 = new MergeKLists_23();
        ListNode listNode1 = mergeKLists_23.mergeKLists(new ListNode[]{listNode, listNode21, listNode11});
        System.out.println(listNode1);

    }
}
