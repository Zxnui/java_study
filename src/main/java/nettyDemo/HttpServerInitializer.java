package nettyDemo;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpServerCodec;

public class HttpServerInitializer extends ChannelInitializer {
    @Override
    protected void initChannel(Channel channel) throws Exception {
        //得到管道
        ChannelPipeline pipeline = channel.pipeline();

        //加入一个netty 提供的httpServerCodec codec =>[coder - decoder]
        //HttpServerCodec 说明
        //1. HttpServerCodec 是netty 提供的处理http的 编-解码器
        pipeline.addLast("HttpServerCodec",new HttpServerCodec());
        //2. 增加一个自定义的handler
        pipeline.addLast("HttpServerHandler", new HttpServerHandler());

        System.out.println("ok");
    }
}
