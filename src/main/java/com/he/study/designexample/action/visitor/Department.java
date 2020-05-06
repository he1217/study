package com.he.study.designexample.action.visitor;
/**
 *  @Description 部门类：抽象访问者类
 *  @ClassName Department
 *  @author he.xuelong
 *  @Date 2020年03月30日 17:06
 * 
 */
abstract class Department {
    //声明一组重载的访问方法，用于访问不同类型的具体元素
    public abstract void visit(FulltimeEmployee employee);

    public abstract void visit(ParttimeEmployee employee);
}
