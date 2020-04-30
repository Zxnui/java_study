package nettyDemo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.util.CharsetUtil;

public class FirstNettyServerHandler extends ChannelInboundHandlerAdapter {

    public void channelRead(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        System.out.println("服务器读取线程："+Thread.currentThread().getName() + " channle = " + channelHandlerContext.channel());
        System.out.println("server ctx = "+channelHandlerContext);
        System.out.println("看看channel 和 pipeline的关系");
        Channel channel = channelHandlerContext.channel();
        ChannelPipeline pipeline = channelHandlerContext.pipeline(); //本质是一个双向链接, 出站入站

        ByteBuf buf = (ByteBuf) o;
        System.out.println("客户端发送消息是:" + buf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端地址:" + channel.remoteAddress());
    }

    //数据读取完毕
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello, 客户端", CharsetUtil.UTF_8));
    }

    //处理异常
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }
}
