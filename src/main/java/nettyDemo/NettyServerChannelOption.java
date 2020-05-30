package nettyDemo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author: zhuxun
 * @data: 2020-05-30 11:37
 * @description:
 * bootstrap.channel 初始化时处理
 * bootstrap.option 初始化配置
 * bootstrap.childOption 客户端连接后参数
 * bootstrap.childHandler 客户端连接后处理
 */
public class NettyServerChannelOption {

    public static void main(String[] args) {
        NioEventLoopGroup boss = new NioEventLoopGroup(1);
        NioEventLoopGroup work = new NioEventLoopGroup(200);

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();

            bootstrap.group(boss,work)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,1024)//临时存放已完成三次握手的请求，队列大小
                    .option(ChannelOption.SO_REUSEADDR,true)//允许端口可被其他服务监听,一般udp，多播系统。tcp不支持多播
                    .option(ChannelOption.SO_KEEPALIVE,true)//是否启用心跳保活机制。在双方TCP套接字建立连接后（即都进入ESTABLISHED状态）并且在两个小时左右上层没有任何数据传输的情况下，这套机制才会被激活
                    .option(ChannelOption.TCP_NODELAY,true)//true数据马上发送，实时性高。false 通过Nagle算法，减少发送次数，数据累积一定大小后，再发送，适合文件传输
                    .option(ChannelOption.SO_SNDBUF,1024)//发送缓冲区，保存发送数据，直到发送成功
                    .option(ChannelOption.SO_RCVBUF,1024)//接受缓冲区，保存收到的数据，直到被读取成功
                    .option(ChannelOption.SO_LINGER,1)//当贝close,0 直接放弃缓冲区可能的数据，直接返回.非0，尝试着将缓冲区数据发送完成，在返回
            ;

            ChannelFuture cf = bootstrap.bind(9999).sync();

            //sync，主线程等待子线程结果
            //closeFuture 开启channel监听，channel关闭，子线程才关闭
            //主线程执行下面代码处，wati子线程。
            cf.channel().closeFuture().sync();
        } catch (Exception e){

        } finally {
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }
    }
}
