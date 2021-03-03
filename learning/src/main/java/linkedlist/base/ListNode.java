package linkedlist.base;

/**
 * @author cwp
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode getListNode(Integer ... arr){
        ListNode head = new ListNode(0);
        ListNode res = head;
        for (int a = 0; a < arr.length; a++) {
            int i = arr[a];
            ListNode listNode = new ListNode(i);
            head.next = listNode;
            head = head.next;
        }
        return res.next;
    }


}
