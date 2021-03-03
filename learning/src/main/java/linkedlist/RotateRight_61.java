package linkedlist;

import linkedlist.base.ListNode;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cwp
 */
public class RotateRight_61 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);

        for (int i = 2; i < 6; i++) {
            insertNode(i, listNode);
        }
        ListNode listNode1 = rotateRight(listNode, 2);
        System.out.println(listNode1);

    }

    public static ListNode rotateRight(ListNode head, int k) {


        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode temp = head;
        int size = 1;

        while (temp.next != null) {
            size++;
            temp = temp.next;
        }
        temp.next = head;
        int realSize = size - k % size;

        ListNode newHead = head;
        for (int i = 1; i < realSize ; i++){
           newHead = newHead.next;
        }
        ListNode result = newHead.next;
        newHead.next = null;

        return result;
    }

    public static ListNode insertNode(int data, ListNode head) {
        ListNode listNode = new ListNode(data);
        if (null == head) {
            head = listNode;
            return listNode;
        }
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }

        cur.next = listNode;
        return head;
    }
}
