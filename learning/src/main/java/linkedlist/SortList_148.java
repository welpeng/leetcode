package linkedlist;

import linkedlist.base.ListNode;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cwp
 */
public class SortList_148 {

    public static void main(String[] args) {
        SortList_148 sortList_148 = new SortList_148();
        ListNode listNode = ListNode.getListNode(4, 2, 1, 3);

        ListNode listNode1 = sortList_148.sortList2(listNode);
        System.out.println("===");
    }

    /**
     * 递归 时间复杂度 nlog n
     * 空间复杂度 log n
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }

    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int len = getListNodeLen(head);
        int itrv = 1;
        while (itrv < len) {
            ListNode pre = dummy;
            ListNode h = dummy.next;
            // 找到合并链表的h1和h2头节点
            while (h != null) {
                int i = itrv;
                ListNode h1 = h;
                while (i > 0 && h != null) {
                    h = h.next;
                    i--;
                }
                // i>0说明没有链表2直接返回
                if (i > 0) break;
                ListNode h2 = h;
                i = itrv;
                while (i > 0 && h != null) {
                    h = h.next;
                    i--;
                }
                // 求出两个链表的长度
                int c1 = itrv;
                int c2 = itrv - i;

                //合并
                while (c1 > 0 && c2 > 0) {
                    if (h1.val < h2.val) {
                        pre.next = h1;
                        h1 = h1.next;
                        c1--;
                    } else {
                        pre.next = h2;
                        h2 = h2.next;
                        c2--;
                    }
                    pre = pre.next;
                }
                pre.next = c1 > 0 ? h1 : h2;
                while (c1 > 0 || c2 > 0) {
                    pre = pre.next;
                    c1--;
                    c2--;
                }
                pre.next = h;
            }
            itrv *= 2;
        }
        return dummy.next;

    }

    private int getListNodeLen(ListNode head) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }
}
