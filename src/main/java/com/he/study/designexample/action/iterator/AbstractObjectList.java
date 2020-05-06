package com.he.study.designexample.action.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author he.xuelong
 * @Description 抽象聚合类
 * @ClassName AbstractObjectList
 * @Date 2020年03月24日 15:13
 */
abstract class AbstractObjectList {
    protected List<Object> objects = new ArrayList<Object>();

    public AbstractObjectList(List objects) {
        this.objects = objects;
    }

    public void addObject(Object obj) {
        this.objects.add(obj);
    }

    public void removeObject(Object obj) {
        this.objects.remove(obj);
    }

    public List getObjects() {
        return this.objects;
    }//声明创建迭代器对象的抽象工厂方法
     public abstract AbstractIterator createIterator();
}
