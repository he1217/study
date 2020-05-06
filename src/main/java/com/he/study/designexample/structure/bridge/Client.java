package com.he.study.designexample.structure.bridge;


public class Client {
    public static void main(String args[]) {
        Image image;
        ImageImp imp;
        image = new JPGImage();
        imp = new WindowsImp();
        image.setImageImp(imp);
        image.parseFile("小龙女");
    }
}
