package com.he.study.designexample.action.visitor;
/**
 *  @Description 员工类,抽象元素类
 *  @ClassName Employee
 *  @author he.xuelong
 *  @Date 2020年03月30日 16:19
 * 
 */
interface  Employee {
    public void accept(Department handler); //接受一个抽象访问者访问
}
