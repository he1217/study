package com.he.excise.newcode.topn;

import com.he.excise.newcode.topn.struct.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2020/12/14 13:42
 */


public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        if(head==null) {
            return null;
        }
        ListNode newHead=null;
        ListNode cur=head;

        while(cur!=null) {
            ListNode curNext=cur.next;
            if(curNext==null) {
                newHead=cur;
            }
            cur.next=pre;
            pre=cur;


            cur=curNext;
        }
        return newHead;

    }
    ListNode pre=null;

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
    }
}
