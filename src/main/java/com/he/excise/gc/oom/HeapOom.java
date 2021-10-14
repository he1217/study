package com.he.excise.gc.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/7/15 17:39
 */
public class HeapOom {
    static long count = 0L;

    public static void main(String[] args) {
        List<Object> a = new ArrayList<>();
        while (true){
            a.add(new Object());
            System.out.println("当前创建对象个数:"+(++count));
        }
    }


}
