package nettyTls;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author: zhuxun
 * @data: 2020-05-27 9:19
 * @description:
 * 客户端私钥 server.keystore
 * 客户端公钥 server.crt
 * 算法：RSA
 * 私钥加密方式：aes256
 * 私钥密码：1234
 * 外部依赖netty ssl/tls
 * 本案例java11 netty 4.1.46.Final ,若java版本不一致，切换对应支持的netty版本
 */
public class ServerRun {

    public static void main(String[] args) {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();

            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ServerInitializer(ServerContext.getSSLContext()));

            ChannelFuture channelFuture = bootstrap.bind(9999).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
