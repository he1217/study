package com.he.excise.gc.oom;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/7/15 17:39
 */
public class VirtualStackOom {
    static long count = 0L;

    public static void main(String[] args) {
        work();
    }

    private static void work() {
        System.out.println("目前调用"+(++count)+"次");
        work();
    }

}
