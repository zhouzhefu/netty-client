/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeff.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 *
 * @author winnie
 */
public class TimeClient {
    
    public void startClient() throws Exception {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ChannelFuture f;
        
        Bootstrap b = new Bootstrap();
        b.group(workerGroup)
         .channel(NioSocketChannel.class)
         .option(ChannelOption.SO_KEEPALIVE, true)
         .handler(new ChannelInitializer<SocketChannel>() {

            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new TimeClientPojoDecoder(), new TimeClientPojoHandler());
                System.out.println("Client channel initiated.");
            }
             
         });
        
        f = b.connect("localhost", 8080).sync();
        //f = b.connect("localhost", 8080).sync(); //try 2nd time connection
        System.out.println("Port binded");
        
        
        f.channel().closeFuture().sync();
        workerGroup.shutdownGracefully();
        System.out.println("Time client ended. Yeah.");
    }
    
    
    
}
