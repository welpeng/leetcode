package linkedlist;

import linkedlist.base.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cwp
 */
public class AddTwoNumbers_02 {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        listNode2.next = new ListNode(3);
        listNode.next = listNode2;

        ListNode listNode11 = new ListNode(5);
        ListNode listNode12 = new ListNode(6);
        listNode12.next = new ListNode(4);
        listNode11.next = listNode12;


        ListNode listNode1 = addTwoNumbers(listNode, listNode11);
        System.out.println(listNode1);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode cur = temp;
        int carry = 0;
        while (l1 != null || l2 != null) {

            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int num = val1 + val2 + carry;
            carry = num / 10;
            ListNode listNode = new ListNode(num % 10);
            cur.next = listNode;
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            ListNode listNode = new ListNode(carry);
            cur.next = listNode;
        }
        return temp.next;
    }

}