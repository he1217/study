package com.he.study.designexample.action.interpreter;

/**
 * @author he.xuelong
 * @Description And解释：非终结符表达式
 * @ClassName AndNode
 * @Date 2020年03月24日 13:33
 */
public class AndNode extends AbstractNode {
    private AbstractNode left; //And的左表达式
    private AbstractNode right; //And的右表达式

    public AndNode(AbstractNode left, AbstractNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String interpret() {
        return left.interpret() + "再" + right.interpret();
    }
}
