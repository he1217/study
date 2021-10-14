package com.he.excise.gc;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/6/8 16:56
 */
public class OldGC {
    public static void main(String[] args) {
        byte[] arr = new byte[4*1024*1024];
        arr = null;
        byte[] arr2 = new byte[256*1024];
        byte[] arr3 = new byte[2*1024*1024];
        byte[] arr4 = new byte[2*1024*1024];
        byte[] arr5 = new byte[2*1024*1024];

        byte[] arr6 = new byte[2*1024*1024];



    }
}
