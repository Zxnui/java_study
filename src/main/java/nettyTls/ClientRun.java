package nettyTls;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author: zhuxun
 * @data: 2020-05-27 9:19
 * @description:
 * 客户端私钥 client.keystore
 * 客户端公钥 client.crt
 * 算法：RSA
 * 私钥加密方式：aes256
 * 私钥密码：1234
 * 外部依赖netty ssl/tls
 * 本案例java11 netty 4.1.46.Final ,若java版本不一致，切换对应支持的netty版本
 */
public class ClientRun {

    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();

            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ClientInitializer(ClientContext.getSSLContext()))
            ;

            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 9999).sync();

            channelFuture.channel().closeFuture().sync();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }

    }
}
