package com.he.excise.newcode.topn;

import com.he.excise.newcode.topn.struct.ListNode;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/3/3 16:41
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1==null||pHead2==null){
            return null;
        }
        ListNode p = pHead1;
        ListNode q = pHead2;
        while (q!=p){
            p=p.next;
            q=q.next;
            if (p==q){
                return q;
            }
            if (p==null){
                p=pHead2;
            }
            if (q==null){
                q=pHead1;
            }
        }
        return q;
    }

    public static void main(String[] args) {
        int a = 12;
        int ret = (int)Math.sqrt(a);
        System.out.println(ret);
    }
}
