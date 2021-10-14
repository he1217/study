package com.he.study.juc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/7/14 16:13
 */
public class test {
    public static void main(String[] args) {
        List<String> synonyms = Arrays.asList("(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)");
        HashMap<String,Integer> names = new HashMap<>(16);
        names.put("John",15);
        names.put("Jon",12);
        names.put("Chris",13);
        names.put("Kris",4);
        names.put("Christopher",19);
        for (int i = 0; i < synonyms.size(); i++) {
            String single = synonyms.get(i);
            single = single.replace("(","").replace(")","");
            String[] split = single.split(",");
        }

    }
}
