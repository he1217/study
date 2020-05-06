package com.he.study.designexample.action.interpreter;

/**
 * @author he.xuelong
 * @Description 方向解释：终结符表达式
 * @ClassName DirectionNode
 * @Date 2020年03月24日 13:36
 */
public class DirectionNode extends AbstractNode {
    private String direction;

    public DirectionNode(String direction) {
        this.direction = direction;
    }
/**
 *
 * @description 
 * @author he.xuelong
 * @date 2020/3/24 13:38
 * @params []
 * @return java.lang.String
 */
    @Override
    public String interpret() {
        if (direction.equalsIgnoreCase("up")) {
            return "向上";
        } else if (direction.equalsIgnoreCase("down")) {
            return "向下";
        } else if (direction.equalsIgnoreCase("left")) {
            return "向左";
        } else if (direction.equalsIgnoreCase("right")) {
            return "向右";
        } else {
            return "无效指令";
        }
    }
}
