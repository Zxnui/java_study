package nettyTls;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.ssl.SslHandler;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;

public class ClientInitializer extends ChannelInitializer {
    private final SSLContext sslContext;

    ClientInitializer(SSLContext sslC){
        this.sslContext = sslC;
    }

    @Override
    protected void initChannel(Channel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();

        SSLEngine sslEngine = sslContext.createSSLEngine();
        sslEngine.setUseClientMode(true);//服务端模式

        pipeline.addLast("ssl",new SslHandler(sslEngine));
        pipeline.addLast(new ClientHandler());
    }
}
