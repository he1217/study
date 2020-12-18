package com.he.study.designexample.action.mediator;

//抽象同事类
abstract class Colleague
{
    protected Mediator mediator;
    public void setMedium(Mediator mediator)
    {
        this.mediator=mediator;
    }
    public abstract void receive();
    public abstract void send();
}
//具体同事类
class ConcreteColleague1 extends Colleague
{
    @Override
    public void receive()
    {
        System.out.println("具体同事类1收到请求。");
    }
    @Override
    public void send()
    {
        System.out.println("具体同事类1发出请求。");
        mediator.relay(this); //请中介者转发
    }
}
//具体同事类
class ConcreteColleague2 extends Colleague
{
    @Override
    public void receive()
    {
        System.out.println("具体同事类2收到请求。");
    }
    @Override
    public void send()
    {
        System.out.println("具体同事类2发出请求。");
        mediator.relay(this); //请中介者转发
    }
}