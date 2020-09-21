package com.datastructure;

/**
 * 合并两个有序链表
 */
public class mergeTwoList {
    public ListNode mergeList (ListNode l1,ListNode l2){
        if(l1 == null || l2 == null){
            return l1 !=null ? l1 : l2;
        }
        //判断l1 l2 链表的头结点哪个小，小的作为头
        ListNode head = l1.val <l2.val ? l1 :l2 ;
        ListNode other = l1.val >= l2.val ? l1 :l2 ;
        ListNode preHead = head;
        ListNode preOther = other;
        //头结点不为空
        while (preHead != null){
            ListNode next = preHead.next;
            //l1 的第二个节点和l2的第一个节点比较
            if(next != null && next.val > preOther.val){
                preHead.next = preOther;
                preOther = next;
            }
            //头结点为空，则preOther接替
            if(preHead.next == null){
                preHead.next = preOther;
                break;
            }

            //头结点的下一个节点作为新的节点
            preHead = preHead.next;
        }
        return head;
    }
}
