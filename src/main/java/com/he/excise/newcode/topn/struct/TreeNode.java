package com.he.excise.newcode.topn.struct;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2020/12/16 16:33
 */
public class TreeNode {
    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;
    public TreeNode(){

    }
    public TreeNode(int val){
        this.val = val;
    }
    public TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
