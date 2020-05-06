package com.he.study.designexample.action.mediator;
/**
 *  @Description 抽象组件类：抽象同事类
 *  @ClassName Component
 *  @author he.xuelong
 *  @Date 2020年03月25日 12:41
 * 
 */
abstract class Component {
    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }//转发调用

    public void changed() {
        mediator.componentChanged(this);
    }

    public abstract void update();
}
