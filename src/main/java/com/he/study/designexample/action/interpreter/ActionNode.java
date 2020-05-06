package com.he.study.designexample.action.interpreter;

/**
 * @author he.xuelong
 * @Description 动作解释：终结符表达式
 * @ClassName ActionNode
 * @Date 2020年03月24日 13:39
 */
public class ActionNode extends AbstractNode {
    private String action;

    public ActionNode(String action) {
        this.action = action;
    }

    @Override
    public String interpret() {
        if (action.equalsIgnoreCase("move")) {
            return "移动";
        } else if (action.equalsIgnoreCase("run")) {
            return "快速移动";
        } else {
            return "无效指令";
        }
    }
}
