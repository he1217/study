package com.he.excise.gc;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/6/8 14:23
 */
public class AgeTest {
    public static void main(String[] args) {
        //大对象
        byte[] arr = new byte[2*1024*1024];
        byte[] arr2 = new byte[256*1024];
        arr2 = null;
        byte[] arr3 = new byte[2*1024*1024];



    }
    public void 动态年龄(){
        byte[] arr = new byte[2*1024*1024];

        arr = null;
        byte[] arr2 = new byte[256*1024];
        byte[] arr3 = new byte[2*1024*1024];
        arr3 = new byte[2*1024*1024];
        arr3 = new byte[2*1024*1024];
        arr3 = new byte[2*1024*1024];
        arr3 = null;
    }
}
