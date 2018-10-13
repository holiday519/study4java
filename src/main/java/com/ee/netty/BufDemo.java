//package com.ee.netty;
//
//import io.netty.buffer.ByteBuf;
//import io.netty.buffer.EmptyByteBuf;
//import io.netty.buffer.Unpooled;
//
//import java.nio.charset.Charset;
//
//public class BufDemo {
//    public static void main(String[] args) {
//        Charset utf8 = Charset.forName("UTF-8");
//        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rock!", utf8);
//        while (buf.isReadable()) {
//            System.out.println(buf.readByte());
//        }
//
//    }
//}
