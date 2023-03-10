package linkedlist;

import linkedlist.base.ListNode;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 *
 * @author cwp
 * @date 2023-03-06 14:38
 */
public class Partition_86 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(2);

        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        Partition_86 partition_86 = new Partition_86();
        ListNode partition = partition_86.partition(listNode, 3);
        System.out.println(partition);

    }



    public ListNode partition(ListNode head, int x) {
        ListNode listNode = new ListNode(0);
        ListNode tmpNode = new ListNode(0);
        ListNode preTmpNode = tmpNode;
        ListNode preNode = listNode;


        while (head != null) {
            if (head.val < x) {
                preNode.next = head;
                preNode = preNode.next;
            } else {
                preTmpNode.next = head;
                preTmpNode = preTmpNode.next;
            }
            head = head.next;
        }
        preTmpNode.next = null;
        preNode.next = tmpNode.next;

        return listNode.next;
    }
}
