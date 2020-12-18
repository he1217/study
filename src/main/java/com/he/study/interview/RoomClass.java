package com.he.study.interview;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *  @Description ArrayList扩容机制
 *  @ClassName ArrayListEnlarge
 *  @author he.xuelong
 *  @Date 2020年05月21日 10:58
 * 
 */
public class ArrayListEnlarge {
    /**
     * 空数组无数据,不占大小
     */
    ArrayList<String> arrayList = new ArrayList<>();
    /**
     *
     */
    ArrayList<String> arrayList1 = new ArrayList<>(8);
    ArrayList arrayList2 = new ArrayList<String>(Arrays.asList("1","2"));

}
