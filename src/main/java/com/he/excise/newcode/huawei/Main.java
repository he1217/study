package com.he.excise.newcode.huawei;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        list. add("a");
        Collection<String> clist = Collections. unmodifiableCollection(list);
        clist. add("a"); //运行时此行报错
        System.out.println(clist. size());
    }
}
