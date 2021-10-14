package com.he.excise.gc.oom;

import com.he.excise.gc.com.Car;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/7/15 14:42
 */
public class MetaDataOom {
    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(Car.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) ->
            {
                if ("run".equals(method.getName())) {
                    System.out.println("启动之前,先进行检查----------------");
                    return methodProxy.invokeSuper(o, objects);
                } else {
                    return methodProxy.invokeSuper(o, objects);
                }
            });
            Car car = (Car) enhancer.create();
            car.run();
        }
    }
}
