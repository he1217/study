package com.he.study.designexample.action.interpreter;

/**
 * @author he.xuelong
 * @Description 简单句子解释：非终结符表达式
 * @ClassName SentenceNode
 * @Date 2020年03月24日 13:34
 */
public class SentenceNode extends AbstractNode {
    private AbstractNode direction;
    private AbstractNode action;
    private AbstractNode distance;

    public SentenceNode(AbstractNode direction, AbstractNode action, AbstractNode distance) {
        this.direction = direction;
        this.action = action;
        this.distance = distance;
    }

    @Override
    public String interpret() {
        return direction.interpret() + action.interpret() + distance.interpret();
    }
}
