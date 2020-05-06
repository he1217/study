package com.he.study.designexample.action.interpreter;

/**
 * @author he.xuelong
 * @Description 距离解释：终结符表达式
 * @ClassName DistanceNode
 * @Date 2020年03月24日 13:40
 */
public class DistanceNode extends AbstractNode {

    private String distance;

    public DistanceNode(String distance) {
        this.distance = distance;
    }

    @Override
    public String interpret() {
        return this.distance;
    }
}
