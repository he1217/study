package com.he.study.designexample.structure.bridge;

/**
 * @author he.xuelong
 * @Description 扩充抽象类
 * @ClassName JPGImage
 * @Date 2020年03月19日 14:37
 */
public class JPGImage extends Image {
    @Override
    public void parseFile(String fileName) {
        Matrix m = new Matrix();
        imp.doPaint(m);
        System.out.println(fileName + "，格式为JPG。");
    }
}

//PNG格式图像：扩充抽象类
class PNGImage extends Image {
    @Override
    public void parseFile(String fileName) { //模拟解析PNG文件并获得一个像素矩阵对象m;
        Matrix m = new Matrix();
        imp.doPaint(m);
        System.out.println(fileName + "，格式为PNG。");
    }
}

//BMP格式图像：扩充抽象类
class BMPImage extends Image {
    @Override
    public void parseFile(String fileName) { //模拟解析BMP文件并获得一个像素矩阵对象m;
        Matrix m = new Matrix();
        imp.doPaint(m);
        System.out.println(fileName + "，格式为BMP。");
    }
}//GIF格式图像：扩充抽象类

class GIFImage extends Image {
    @Override
    public void parseFile(String fileName) { //模拟解析GIF文件并获得一个像素矩阵对象m;
        Matrix m = new Matrix();
        imp.doPaint(m);
        System.out.println(fileName + "，格式为GIF。");
    }
}