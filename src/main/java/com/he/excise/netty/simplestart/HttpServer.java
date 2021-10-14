package com.he.excise.netty.simplestart;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

import java.net.InetSocketAddress;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/1/27 14:09
 */
public class HttpServer {
    public void start(int port) throws Exception {
        //主
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //从
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) {
                            ch.pipeline()
                                    .addLast("codec", new HttpServerCodec())                  // HTTP 编解码
                                    .addLast("compressor", new HttpContentCompressor())       // HttpContent 压缩
                                    .addLast("aggregator", new HttpObjectAggregator(65536))   // HTTP 消息聚合
                                    .addLast("handler", new HttpServerHandler());             // 自定义业务逻辑处理器
                        }
                    })
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            ChannelFuture f = b.bind().sync();
            System.out.println("Http Server started， Listening on " + port);
            f.channel().closeFuture().sync();//让线程进入 wait 状态，这样服务端可以一直处于运行状态
        } finally {
            //,10.161.11.15:9092,10.161.11.25:9092,10.161.11.26:9092
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
    public static void main(String[] args) throws Exception {
        new HttpServer().start(8088);
    }
}
