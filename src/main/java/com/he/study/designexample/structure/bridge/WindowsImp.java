package com.he.study.designexample.structure.bridge;
/**
 *  @Description 抽象操作系统实现类:具体实现类
 *  @ClassName WindowsImp
 *  @author he.xuelong
 *  @Date 2020年03月19日 16:09
 * 
 */
public class WindowsImp implements ImageImp {

    @Override
    public void doPaint(Matrix m) {
        //调用Windows系统的绘制函数绘制像素矩阵
        System.out.print("在Windows操作系统中显示图像：");
    }
}

//Linux操作系统实现类：具体实现类
class LinuxImp implements ImageImp {
    @Override
    public void doPaint(Matrix m) { //调用Linux系统的绘制函数绘制像素矩阵
        System.out.print("在Linux操作系统中显示图像：");
    }
}//Unix操作系统实现类：具体实现类

class UnixImp implements ImageImp {
    @Override
    public void doPaint(Matrix m) { //调用Unix系统的绘制函数绘制像素矩阵
        System.out.print("在Unix操作系统中显示图像：");
    }
}
