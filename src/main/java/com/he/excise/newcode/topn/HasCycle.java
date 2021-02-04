package com.he.excise.newcode.topn;

import com.he.excise.newcode.topn.struct.ListNode;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2020/12/15 18:56
 */
public class HasCycle {
    /**
     * 相遇点不是入口节点
     * @param head
     * @return boolean
     */
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
    /**
     *  对于一个给定的链表，返回环的入口节点，如果没有环，返回null
     * @param head
     * @return com.he.excise.newcode.topn.struct.ListNode
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;

            if(fast==slow){                 //利用快慢指针找相遇点
                ListNode slow2=head;    //设置以相同速度的新指针从起始位置出发
                while(slow2!=slow){      //未相遇循环。
                    slow=slow.next;
                    slow2=slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}
