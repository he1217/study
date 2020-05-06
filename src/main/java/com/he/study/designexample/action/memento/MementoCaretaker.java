package com.he.study.designexample.action.memento;

/**
 * @author he.xuelong
 * @Description 象棋棋子备忘录管理类：负责人    可以设置一个数组还返回多种状态
 * @ClassName MementoCaretaker
 * @Date 2020年03月25日 14:41
 */
public class MementoCaretaker {
    private ChessmanMemento memento;

    public ChessmanMemento getMemento() {
        return memento;
    }

    public void setMemento(ChessmanMemento memento) {
        this.memento = memento;
    }
}
