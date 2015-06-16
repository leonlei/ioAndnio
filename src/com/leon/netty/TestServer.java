package com.leon.netty;

import java.util.concurrent.Executors;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TestServer {
	
	private final int port;
	
	public TestServer(int port){
		this.port = 9000;
	}
	
	public void run(){
		 // EventLoop ����ԭ���� ChannelFactory
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
         try {
             ServerBootstrap serverBootstrap = new ServerBootstrap();
             // server�˲��ü�����д��ʽ��client�˲��÷ֶ���ͨд����
            serverBootstrap.group(bossGroup, workerGroup)
                      .channel(NioServerSocketChannel. class )
                      .childHandler( new ChannelInitializer<SocketChannel>() {
                            @Override
                            public void initChannel(SocketChannel ch)
                                     throws Exception {
                                ch.pipeline().addLast( new HelloServerHandler());
                           }
                      }).option(ChannelOption. SO_KEEPALIVE , true );

            ChannelFuture f = serverBootstrap.bind(8000).sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
	}
}

class HelloServerHandler extends ChannelInboundHandlerAdapter {

		/**
		* ���󶨵�����˵�ʱ�򴥷�����ӡ"Hello world, I'm client."
		*
		* @alia OneCoder
		* @author lihzh
		* @date 2013��11��16�� ����12:50:47
		*/
		@Override
		public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System. out .println("Hello world, I'm server.");
		}
}
