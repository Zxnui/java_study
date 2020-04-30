package nettyDemo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class FirstNettyServer {

    public static void main(String[] args) {
        //mainReactor, Accetpt 连接建立事件并分发请求,内部包括selector and taskQueue
        // accept
        // step1 selector 轮询 Accept 事件，处理i/o，和client建立链接，监听复数个channel，等待处理结果
        // step2 processSelectedKeys  生成nioSocketChannel 注册channel到workerGroup的selector上
        // step3 runAllTasks 用户调用 eventloop.execute 或 schedule 执行的任务，或者其他线程提交到该 eventloop 的任务。
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        //subReactor and workerThread 处理 I/O 读写事件和业务逻辑。内部包括selector and taskQueue
        // step1 selector 监听复数个channel，等待处理结果
        // step2 processSelectedKeys 轮询i/o事件，处理i/o,在 NioSocketChannel 可读、可写事件发生时进行处理 触发pipeline 各种handler
        // step3 runAllTasks
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            final ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap
                    //装载NioEventLoopGroup
                    .group(bossGroup, workerGroup)
                    //channel类型
                    .channel(NioServerSocketChannel.class)
                    //配置连接参数
                    .option(ChannelOption.SO_BACKLOG, 100)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childOption(ChannelOption.TCP_NODELAY, true)
                    //配置入站、出站handler
                    .childHandler(new ChannelInitializer<NioSocketChannel>() {
                        protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                            //TODO 配置出入站事件channel
                            System.out.println("客户端 channel hashcode = " + nioSocketChannel.hashCode());
                            nioSocketChannel.pipeline().addLast(new FirstNettyServerHandler());
                        }
                    });

            ChannelFuture cf = serverBootstrap.bind(9999).sync();

            cf.channel().closeFuture().sync();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
