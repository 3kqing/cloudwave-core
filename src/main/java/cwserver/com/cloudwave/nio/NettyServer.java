package com.cloudwave.nio;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;


/**
 * User: DolphinBoy
 * Date: 13-6-26
 * Time: 下午10:45
 * To change this template use File | Settings | File Templates.
 */
public class NettyServer extends NIOServer {
    public final static int port = 8080;
    private ServerBootstrap bootstrap;
    private Channel parentChannel;
    private InetSocketAddress localAddress;
    private MyChannelHandler channelHandler = new MyChannelHandler();

    public NettyServer() {
        bootstrap = new ServerBootstrap(new NioServerSocketChannelFactory(
                Executors.newCachedThreadPool(), Executors
                .newCachedThreadPool()));
        bootstrap.setOption("reuseAddress", true);
        bootstrap.setOption("child.tcpNoDelay", true);
        bootstrap.setOption("child.soLinger", 2);
        bootstrap.getPipeline().addLast("servercnfactory", channelHandler);
    }

    void config(int port) {
        this.localAddress = new InetSocketAddress(port);
    }

    void start() {
        parentChannel = bootstrap.bind(localAddress);
    }

    class MyChannelHandler extends SimpleChannelHandler {

        @Override
        public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e)
                throws Exception {
            System.out.println("Channel closed " + e);
        }

        @Override
        public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
            System.out.println("Channel connected " + e);
        }

        @Override
        public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
                throws Exception {
            try {
                System.out.println("New message " + e.toString() + " from "
                        + ctx.getChannel());
                processMessage(e);
            } catch (Exception ex) {
                ex.printStackTrace();
                throw ex;
            }
        }

        private void processMessage(MessageEvent e) {
            Channel ch = e.getChannel();
            ch.write(e.getMessage());
        }
    }

    public static void main(String[] args) {
        NettyServer server = new NettyServer();
        server.config(port);
        server.start();
    }
}