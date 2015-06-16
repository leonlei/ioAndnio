package com.leon.thread;

import java.util.LinkedList;


/**
 * 生产者和消费者模型
 * @author Administrator
 *
 */
public class ProducerAndConsumer {
	
	private int MAX_SIZE = 100;
	
	private LinkedList<Object> list = new LinkedList<>();
	
	public void produce(int num){
		while(list.size() +  num > MAX_SIZE){
			System.out.println("【要生产的产品数量】:" + num + "/t【库存量】:"  
                    + list.size() + "/t暂时不能执行生产任务!"); 
		}
		
		for(int i = 0; i < num; i++){
			list.add(new Object());
		}
		
        System.out.println("【已经生产产品数】:" + num + "/t【现仓储量为】:" + list.size());  
	}
	
	public void consume(int num){
		while(list.size() < num){
			System.out.println("【要消费的产品数量】:" + num + "/t【库存量】:"  
                    + list.size() + "/t暂时不能执行生产任务!");  	
		}
		for (int i = 1; i <= num; ++i)  
        {  
            list.remove();  
        }  

        System.out.println("【已经消费产品数】:" + num + "/t【现仓储量为】:" + list.size());
	}
	
	
}
