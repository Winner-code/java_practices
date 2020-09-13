package com.proandcus;

public class Test {
	public static void main(String[] args) {
		Goods g=new Goods();
		Producter p=new Producter(g);
		Customer c=new Customer(g);
		new Thread(p).start();
		new Thread(c).start();
	}
}
