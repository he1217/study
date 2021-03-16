package com.he.excise.newcode.topn;

import com.he.excise.newcode.topn.struct.TreeNode;

import javax.swing.tree.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author he.xl
 * @Description TODO 给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
 * @ClassName
 * @Date 2021/2/26 16:57
 */
public class zigzagLevelOrder {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
        // write code here
        if(root == null) return new ArrayList();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int count = 1;//记录奇数还是偶数
        while(!queue.isEmpty()){
            int n = queue.size();
            System.out.println("n的数字维" +n);
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < n; i++){
                TreeNode node = queue.poll();
                System.out.println(node);
                list.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }

            if(count % 2 == 1){//奇数
                res.add(list);
                count++;
            }else{
                Collections.reverse(list);
                res.add(list);
                count++;
            }
        }
        return res;
    }
    public ArrayList<ArrayList<Integer>> zigzagLevelOrderTest (TreeNode root) {
        // write code here
        if(root == null) return new ArrayList();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int count = 1;//记录奇数还是偶数
        while(!queue.isEmpty()){
            int n = queue.size();
            System.out.println("n的数字维" +n);
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < n; i++){
                TreeNode node = queue.poll();
                System.out.println(node);
                list.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }

            if(count % 2 == 1){//奇数
                res.add(list);
                count++;
            }else{
                Collections.reverse(list);
                res.add(list);
                count++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node4.right = node5;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node1);
        String str = "123";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        str.substring(str.length()-1,str.length());
        stringBuilder.reverse();
        stringBuilder.toString();
        while(!queue.isEmpty()){
            int n = queue.size();
            System.out.println("n的数字维" +n);
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                System.out.println(node);
            }
        }

    }
}
