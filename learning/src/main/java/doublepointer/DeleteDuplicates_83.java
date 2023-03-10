package doublepointer;

import linkedlist.base.ListNode;

/**
 * @author cwp
 * @date 2023-03-07 10:17
 */
public class DeleteDuplicates_83 {


    public ListNode deleteDuplicates(ListNode head) {
        ListNode fast = head;

        ListNode res = new ListNode(0);
        ListNode slow = res;
        slow.next = head;
        slow = slow.next;
        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        if (slow !=null && slow.next != null) {
            slow.next = null;
        }
        return res.next;
    }

}
