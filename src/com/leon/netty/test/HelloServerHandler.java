package com.leon.netty.test;

import java.net.InetAddress;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class HelloServerHandler extends SimpleChannelInboundHandler<String>{
	     
	     /*
	      * 
	      * 覆盖 channelActive 方法 在channel被启用的时候触发 (在建立连接的时候)
	      * 
	      * channelActive 和 channelInActive 在后面的内容中讲述，这里先不做详细的描述
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
