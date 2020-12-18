package com.he.excise.newcode.huawei;
/**
 *  @Description 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
 *
 * 输入
 * 9
 * 输出   1  1  2 3 5 8 13 21 34
 * 34
 *public static int getTotalCount(int monthCount)
        *{
        *return 0;
        *}
 *  @ClassName 兔子总数
 *  @author he.xuelong
 *  @Date 2020年06月01日 13:45
 * 
 */
public class 兔子总数 {
    public static void main(String[] args) {
        System.out.println(getTotalCount(9));
    }
    public static int getTotalCount(int monthCount){
        if (monthCount<0){
            return 0;
        }else if (monthCount<3){
            return 1;
        }else {
             return getTotalCount(monthCount-1)+getTotalCount(monthCount-2);
        }

    }

}
