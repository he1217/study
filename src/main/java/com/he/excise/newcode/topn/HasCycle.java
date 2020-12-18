package com.he.excise.newcode.topn;

import com.he.excise.newcode.topn.struct.ListNode;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2020/12/15 18:56
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode p=head;
        ListNode q=head;
        while(q!=null&&q.next!=null){
            q=q.next.next;
            p=p.next;
            if(q==p){
                return true;
            }
        }
        return false;
    }
}
