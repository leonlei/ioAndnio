package com.leon.thread;

import java.util.LinkedList;


/**
 * �����ߺ�������ģ��
 * @author Administrator
 *
 */
public class ProducerAndConsumer {
	
	private int MAX_SIZE = 100;
	
	private LinkedList<Object> list = new LinkedList<>();
	
	public void produce(int num){
		while(list.size() +  num > MAX_SIZE){
			System.out.println("��Ҫ�����Ĳ�Ʒ������:" + num + "/t���������:"  
                    + list.size() + "/t��ʱ����ִ����������!"); 
		}
		
		for(int i = 0; i < num; i++){
			list.add(new Object());
		}
		
        System.out.println("���Ѿ�������Ʒ����:" + num + "/t���ֲִ���Ϊ��:" + list.size());  
	}
	
	public void consume(int num){
		while(list.size() < num){
			System.out.println("��Ҫ���ѵĲ�Ʒ������:" + num + "/t���������:"  
                    + list.size() + "/t��ʱ����ִ����������!");  	
		}
		for (int i = 1; i <= num; ++i)  
        {  
            list.remove();  
        }  

        System.out.println("���Ѿ����Ѳ�Ʒ����:" + num + "/t���ֲִ���Ϊ��:" + list.size());
	}
	
	
}
