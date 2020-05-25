package nettyDemo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class NettyBufTest {

    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.copiedBuffer("hellowww".getBytes());

        System.out.println(byteBuf);

        //读取1位
        byteBuf.readByte();
        System.out.println(byteBuf);
        //读取1位
        byteBuf.readByte();
        System.out.println(byteBuf);

        //丢弃无用数据
        byteBuf.discardReadBytes();
        System.out.println(byteBuf);

        //清空
        byteBuf.clear();
        System.out.println(byteBuf);

        //写入
        byteBuf.writeBytes("1234".getBytes());
        System.out.println(byteBuf);

        //读1位
        byteBuf.readByte();
        System.out.println(byteBuf);

        //索引读标记
        byteBuf.markReaderIndex();
        System.out.println(byteBuf);

        //读取1位
        byteBuf.readByte();
        //读取1位
        byteBuf.readByte();
        System.out.println(byteBuf);;

        //重置索引到读标记位
        byteBuf.resetReaderIndex();
        System.out.println(byteBuf);

        byteBuf.writeBytes("5".getBytes());
        System.out.println(byteBuf);

        //索引写标记
        byteBuf.markWriterIndex();
        //写1位
        byteBuf.writeBytes("6".getBytes());
        System.out.println(byteBuf);

        //重置索引到写标记位
        byteBuf.resetWriterIndex();
        System.out.println(byteBuf);
        System.out.println(byteBuf.getByte(4));
    }
}
