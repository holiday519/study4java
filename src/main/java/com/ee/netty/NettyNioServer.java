//package com.ee.netty;
//
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.buffer.ByteBuf;
//import io.netty.buffer.Unpooled;
//import io.netty.channel.*;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//import io.netty.util.CharsetUtil;
//import io.netty.util.ReferenceCountUtil;
//
//import java.net.InetSocketAddress;
//import java.nio.charset.Charset;
//
//public class NettyNioServer {
//    public static void server(int port) throws InterruptedException {
//        final ByteBuf buf = Unpooled.copiedBuffer("Hi!\r\n", Charset.forName("UTF-8"));
//        EventLoopGroup group = new NioEventLoopGroup();
//        try {
//            ServerBootstrap b = new ServerBootstrap();
//            b.group(group).channel(NioServerSocketChannel.class)
//                    .localAddress(new InetSocketAddress(port))
//                    .childHandler(new ChannelInitializer<SocketChannel>() {
//                        @Override
//                        protected void initChannel(SocketChannel ch) throws Exception {
//                            ch.pipeline().addLast("handler1", new ChannelInboundHandlerAdapter() {
//                                @Override
//                                public void channelActive(ChannelHandlerContext ctx) {
////                                    ctx.writeAndFlush(buf.duplicate())
////                                            .addListener(ChannelFutureListener.CLOSE);
//                                    System.out.println("EE-DEBUG==>first channelActive");
//                                    ctx.fireChannelActive();
//                                }
//                                @Override
//                                public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//                                    System.out.println("EE-DEBUG==>first channelRead");
//                                    ByteBuf in = (ByteBuf) msg;
//                                    System.out.println((char) in.readByte());
//                                    ctx.fireChannelRead(msg);
//                                }
//                            }).addLast("handler2", new ChannelInboundHandlerAdapter() {
//                                @Override
//                                public void channelActive(ChannelHandlerContext ctx) throws Exception {
//                                    System.out.println("EE-DEBUG==>second channelActive");
//                                    Channel channel = ctx.channel();
//                                    channel.write(Unpooled.copiedBuffer("Hello Netty", CharsetUtil.UTF_8));
//                                }
//                                @Override
//                                public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//                                    System.out.println("EE-DEBUG==>second channelRead");
//                                    ByteBuf in = (ByteBuf) msg;
//                                    System.out.println((char) in.readByte());
//                                    ReferenceCountUtil.release(msg);
//                                }
//                            });
//                        }
//                    });
//            ChannelFuture f = b.bind().sync();
//            f.channel().closeFuture().sync();
//        } finally {
//            group.shutdownGracefully().sync();
//        }
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        server(8888);
//    }
//}
