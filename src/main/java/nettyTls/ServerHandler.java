package nettyTls;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class ServerHandler extends ChannelInboundHandlerAdapter {

    //当通道就绪
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("server:" + ctx);
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello, client;i am server", CharsetUtil.UTF_8));
    }

    //读取数据
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("客户端消息:" + buf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端地址： "+ ctx.channel().remoteAddress());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
