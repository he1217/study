package com.he.study.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

/**
 *  @Description 集合类混合
 *  @ClassName RoomClass
 *  @author he.xuelong
 *  @Date 2020年05月21日 10:58
 *
 */
public class RoomClass {
    /**ArrayList扩容机制
     *
     * 空数组无数据,不占大小数,组中添加第一个元素时，数组容量扩为10
     */
    ArrayList<String> arrayList = new ArrayList<>();

    ArrayList<String> arrayList1 = new ArrayList<>(8);
    ArrayList arrayList2 = new ArrayList<String>(Arrays.asList("1","2"));
    /**
     * int newCapacity = oldCapacity + (oldCapacity >> 1),所以 TestArrayList 每次扩容之后容量都会变为原来的 1.5 倍左右
     * （oldCapacity为偶数就是1.5倍，否则是1.5倍左右）！ 奇偶不同，
     * 比如 ：10+10/2 = 15, 33+33/2=49。如果是奇数的话会丢掉小数.
     */

    /**阅读源码的话，我们就会发现 TestArrayList 中大量调用了这两个方法。
     * 比如：我们上面讲的扩容操作以及add(int index, E element)、toArray() 等方法中都用到了该方法！
     * arraycopy() 需要目标数组，将原数组拷贝到你自己定义的数组里或者原数组，而且可以选择拷贝的起点和长度以及放入新数组中的位置
     * copyOf() 是系统自动在内部新建一个数组，并返回该数组。
     *
     */
    /**
     * ensureCapacity方法
     * TestArrayList 添加大量元素之前最好先使用ensureCapacity 方法，以减少增量重新分配的次数。
     */

    HashMap<Integer, String> hashMap = new HashMap<>();
    Hashtable<Integer, String> hashtable = new Hashtable<>();

    /**
     * Collection
     * 1. List
     * Arraylist: Objects数组
     * Vector: Object数组
     * a Linkedlist：双向链表（DK1.6之前为循环链表、JDK1.7取消了循环）
     * 2. Set
     * a Hashset（无序，唯一）：基于 Hashmap实现的，底层采用 Hashmap来保存元素
     * a Linkedhashset: Linkedhashset继承于 Hashset，并且其内部是通过 Linkedhashmap来实现的。有点类似于我们之前说的 Linkedhashmap其内部是基于 Hashmap实现一样，不过还是有一点
     * 点区别的
     * Treeset（有序，唯一)红黑树（自平衡的排序二又树）
     *
     * MAP
     * Hashmap:JDK1.8之前 Hashmap I由数组+链表组成的，数组是 Hashmap的主体，链表则是主要为
     * 了解决哈希冲突而存在的（"拉链法"解决冲突）。JDK1.8以后在解决哈希冲突时有了较大的变化，当链表长度大于阈值（默认为8)时，将链表转化为红黑树、以减少搜索时间
     * Linkedhashmap: Linkedhashmap继承自 Hashmap，所以它的底层仍然是基于拉链式散列结构即由数组和链表或红黑树组成。另外， Linkedhashmap在上面结构的基础上，増加了一条双向链
     * 表，使得上面的结构可以保持键值对的插入顺序。同时通过对链表进行相应的操作，实现了访问顺序
     * 
     * a Hashtable：数组十链表组成的，数组是 Hashmap的主体，链表则是主要为了解决哈希冲突而存在
     * 的
     * m Treemap：红黑树（自平衡的排序二叉树
     *
     */



    public static void main(String[] args) {
        System.out.println(1 << 4);
    }

}
