package com.he.excise.newcode.topn;

import com.he.excise.newcode.topn.struct.ListNode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author he.xl
 * @Description TODO 给定一个链表，删除链表的倒数第n个节点并返回链表的头指针
 * @ClassName
 * @Date 2021/1/4 15:14
 */
public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        ListNode dummy = new ListNode(0);//创建一个头节点,避免第一个next为空
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 1; i <= n+1; i++) {
            fast = fast.next;
        }
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) throws ParseException {
//        removeNthFromEnd(new ListNode(0),2);
//        Map<String,String> a = new HashMap<>();
//        a.put("12","32");
//        List<Map<String,String>> all = new ArrayList<>();
//        all.add(a);
//        System.out.println(all.contains(a));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = simpleDateFormat.format(new Date().getTime());
        System.out.println(simpleDateFormat.parse(today).getTime());
    }
}
