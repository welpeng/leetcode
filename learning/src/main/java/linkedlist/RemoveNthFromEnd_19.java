package linkedlist;

import linkedlist.base.ListNode;

import java.util.HashMap;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cwp
 */
public class RemoveNthFromEnd_19 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode4.next = listNode5;
        listNode3.next = listNode4;
        listNode2.next = listNode3;
        listNode.next = listNode2;

        ListNode listNode1 = removeNthFromEnd(listNode, 2);
        System.out.println(listNode1);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode pre = null;
        ListNode cur = head;

        HashMap<Integer, Integer> map = new HashMap<>();
        int size = 0;
        while (null != head) {
            map.put(size, head.val);
            size++;
            head = head.next;
        }

        int a = size - n;

        ListNode listNode = new ListNode(0);

        for (int i = 0; i < size; i++) {
            if (i != a) {
                insertNode(map.get(i), listNode);
            }
        }

        return listNode.next;
    }

    public static ListNode insertNode(int data, ListNode head) {
        ListNode listNode = new ListNode(data);
        if (null == head) {
            head = listNode;
            return listNode;
        }
        System.out.println(head);
        ListNode cur = head;
        System.out.println(cur);
        while (cur.next != null) {
            cur = cur.next;
        }

        cur.next = listNode;
        return head;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

}
