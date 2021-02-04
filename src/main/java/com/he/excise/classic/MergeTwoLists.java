package com.he.excise.classic;

import com.he.excise.newcode.topn.struct.ListNode;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2020/12/23 13:59
 */
public class MergeTwoLists {
    //递归实现
    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        // write code here
        if(l1 == null){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }
        else if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    //遍历实现
    public ListNode mergeTwoListsOrder (ListNode l1, ListNode l2) {
        // write code here
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode result = new ListNode(-1);
        ListNode last = result;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                last.next = node1;
                node1 = node1.next;
            } else {
                last.next = node2;
                node2 = node2.next;
            }
            last = last.next;
        }
        if (node1 != null) {
            last.next = node1;
        }
        if (node2 != null) {
            last.next = node2;
        }
        return result.next;
    }

}
