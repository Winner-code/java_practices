package com.datastructure;

/**
 * 递归的方式实现链表的
 */
public class reverseList {
    public ListNode reverse_List(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = reverse_List(head.next);
        head.next.next = head;
        head.next = null;
        return pre;
    }
}
