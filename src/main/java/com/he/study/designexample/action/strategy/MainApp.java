package com.he.study.designexample.action.strategy;

/**
 *  @ClassName main
 *  @Description main
 *  @author he.xuelong
 *  @Date 2020年03月12日 18:41
 *
 */
public class MainApp {
    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new Subtract());
        System.out.println(context.handNumber(5, 4));
    }
}
