package com.he.excise.classic;

import com.he.excise.newcode.topn.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2020/12/22 18:05
 */
public class LevelOrder {
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // 借助队列进行层次遍历
        ArrayList<ArrayList<Integer>> Res = new ArrayList<ArrayList<Integer>>();//存放遍历结果

        Queue<TreeNode> Q = new LinkedList<TreeNode>();//创建队列
        Q.add(root);
        if(root==null){
            return Res;
        }
        while(!Q.isEmpty()){
            ArrayList<Integer> result = new ArrayList<Integer>();
            int size = Q.size();//当前队列中的元素个数(当前层)

            for(int i=1;i<=size;i++){ //将当前层的节点出队，并且将其相应的孩子节点出队
                TreeNode temp = Q.poll();//出队
                result.add(temp.val);
                if(temp.left!=null){
                    Q.add(temp.left);
                }
                if(temp.right!=null){
                    Q.add(temp.right);
                }
            }
            Res.add(result);//将当前层的遍历结果存放到Res

        }
        return Res;
    }
}
