package com.he.excise.newcode.huawei;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *  @Description 有一种技巧可以对数据进行加密，它使用一个单词作为它的密匙。下面是它的工作原理：首先，
 *  选择一个单词作为密匙，如TRAILBLAZERS。如果单词中包含有重复的字母，只保留第1个，其余几个丢弃。
 *  现在，修改过的那个单词属于字母表的下面，如下所示：
 *
 * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 *
 * T R A I L B Z E S C D F G H J K M N O P Q U V W X Y
 *
 * 上面其他用字母表中剩余的字母填充完整。在对信息进行加密时，信息中的每个字母被固定于顶上那行，
 * 并用下面那行的对应字母一一取代原文的字母(字母字符的大小写状态应该保留)。因此，使用这个密匙，
 * Attack AT DAWN(黎明时攻击)就会被加密为Tpptad TP ITVH。
 *  @ClassName 字符串加密
 *  @author he.xuelong
 *  @Date 2020年06月01日 13:10
 * 
 */
public class 字符串加密 {
    public static void main(String[] args) {
        String str = "nihao";//key
        String str1 = "ni";//明文
        StringBuffer sb = new StringBuffer();
        sb.append(str).append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        String to = sb.toString().toLowerCase();
        HashSet<Character> list = new LinkedHashSet<>();
        for (int i = 0; i < to.length(); i++) {
            list.add(to.charAt(i));
        }
        Object[] ch =list.toArray();
        sb.delete(0,sb.length());
        for (int i = 0; i < str1.length(); i++) {
            if (Character.isLowerCase(str1.charAt(i))){
                sb.append((char)ch[str1.charAt(i)-'a']);
            }else {
                sb.append((char)ch[str1.charAt(i)-'A']);
            }
        }
        System.out.println(sb);
    }
}
