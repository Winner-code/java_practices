package com.runnable;

public class Test1 {
	public static void main(String[] args) {
		MyRunnable my=new MyRunnable();
		Thread t=new Thread(my);
		t.start();
		
		for(int i=0;i<10;i++){
			System.out.println("Test1.main()---------->"+i);
		}
	}
}
