package com.he.test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2020/12/14 17:55
 */
public class IntTest {
    static double a = 0.0d;
    static double b = 1.0d;
    public static void main(String[] args) {
        String serviceName ="marathon-lb-users.sae-skyark.dcos.yizhuang.unicom.local:9059";
        if (serviceName.startsWith("marathon")){
            int index = serviceName.indexOf(".");
            serviceName = serviceName.substring(0,index);
        }
        System.out.println(serviceName);
    }
}
