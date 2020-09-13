package com.proandcus;

public class Customer implements Runnable {
	private Goods goods;
	public Customer(Goods goods){
		this.goods=goods;
	}
	public void run() {
		for(int i=0;i<10;i++){
			goods.get();//������Ʒ���е�ȡֵ�ķ���
		}
		
	};
}
