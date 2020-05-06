package com.he.study.designexample.action.iterator;

import java.util.List;
/**
 *  @Description 商品数据类：具体聚合类
 *  @ClassName ProductList
 *  @author he.xuelong
 *  @Date 2020年03月24日 15:14
 * 
 */
public class ProductList extends AbstractObjectList {
    public ProductList(List products) {
        super(products);
    }

    @Override
    public AbstractIterator createIterator() {
        return new ProductIterator(this);
    }
}
