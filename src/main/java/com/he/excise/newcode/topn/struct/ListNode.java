package com.he.excise.newcode.topn.struct;

import java.util.SortedMap;
import java.util.SortedSet;

/**
 * @author he.xl
 * @Description intODO
 * @ClassName
 * @Date 2020/12/16 15:48
 */

public class ListNode {

    public int val;//数据域
    public ListNode next;//指向下一个节点（指针域）

    public int getVal() {
        return val;
    }
    public void setVal(int data) {
        this.val = data;
    }
    public ListNode getNext() {
        return next;
    }
    public void setNext(ListNode next) {
        this.next = next;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + val;
        result = prime * result + ((next == null) ? 0 : next.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ListNode other = (ListNode) obj;
        if (val != other.val)
            return false;
        if (next == null) {
            if (other.next != null)
                return false;
        } else if (!next.equals(other.next))
            return false;
        return true;
    }
    ListNode(int data, ListNode next) {
        super();
        this.val = data;
        this.next = next;
    }
    public ListNode() {
        super();
    }
    public ListNode(int data) {
        super();
        this.val = data;
    }
    @Override
    public String toString() {
        return "[data=" + val + ", next->\n" + next + "]";
    }
}
