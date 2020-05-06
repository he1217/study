package com.he.study.designexample.structure.bridge;
/**
 *  @Description 抽象类
 *  @ClassName Image
 *  @author he.xuelong
 *  @Date 2020年03月19日 14:43
 * 
 */
abstract class Image {

    protected ImageImp imp;

    public void setImageImp(ImageImp imp) {
        this.imp = imp;
    }

    public abstract void parseFile(String fileName);
}
/**
 *  @Description 辅助类
 *  @ClassName Image
 *  @author he.xuelong
 *  @Date 2020年03月19日 16:09
 * 
 */
class Matrix { //此处代码省略
     }