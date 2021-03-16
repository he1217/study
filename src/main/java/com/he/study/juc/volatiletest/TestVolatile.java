package com.he.study.juc.volatiletest;

/**
 * 一、volatile 关键字：当多个线程进行操作共享数据时，可以保证内存中的数据可见。
 * 					  相较于 synchronized 是一种较为轻量级的同步策略。
 *
 * 注意：
 * 1. volatile 不具备“互斥性”
 * 2. volatile 不能保证变量的“原子性”
 *
 *
 * 第一，一旦 data 变量定义的时候前面加了 volatile 来修饰的话，那么线程 1 只要修改 data 变量的值，
 * 就会在修改完自己本地工作内存的 data 变量值之后，强制将这个 data 变量最新的值刷回主内存，必须让主内存里的 data 变量值立马变成最新的值！
 *
 *第二，如果此时别的线程的工作内存中有这个 data 变量的本地缓存，也就是一个变量副本的话，
 * 那么会强制让其他线程的工作内存中的 data 变量缓存直接失效过期，不允许再次读取和使用了！
 *
 * 第三，如果线程 2 在代码运行过程中再次需要读取 data 变量的值，此时尝试从本地工作内存中读取，就会发现这个 data = 0 已经过期了！
 * 此时，他就必须重新从主内存中加载 data 变量最新的值！那么不就可以读取到 data = 1 这个最新的值了！
 */
public class TestVolatile {

	public static void main(String[] args) {
		ThreadDemo td = new ThreadDemo();

		new Thread(td).start();
		//new Thread(td).start();
		System.out.println("11111111111");
		while(true){
			System.out.println(td.isFlag());
			if(td.isFlag()){
				System.out.println("------------------");
				break;
			}
		}

	}

}

class ThreadDemo implements Runnable {

	private volatile boolean flag = false;


	@Override
	public void run() {

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
		}

		flag = true;

		System.out.println("flag=" + isFlag());

	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
