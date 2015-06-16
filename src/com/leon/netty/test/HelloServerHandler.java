package com.leon.netty.test;

import java.net.InetAddress;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class HelloServerHandler extends SimpleChannelInboundHandler<String>{
	     
	     /*
	      * 
	      * ���� channelActive ���� ��channel�����õ�ʱ�򴥷� (�ڽ������ӵ�ʱ��)
	      * 
	      * channelActive �� channelInActive �ں���������н����������Ȳ�����ϸ������
	      * */
	     @Override
	     public void channelActive(ChannelHandlerContext ctx) throws Exception {
	         
	         System.out.println("RamoteAddress : " + ctx.channel().remoteAddress() + " active !");
	         
	         ctx.writeAndFlush( "Welcome to " + InetAddress.getLocalHost().getHostName() + " service!\n");
	         
	         super.channelActive(ctx);
	     }

		@Override
		protected void channelRead0(ChannelHandlerContext arg0, String arg1)
				throws Exception {
			
		}
}
