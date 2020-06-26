package server.iot.bootstrap;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import server.iot.emergency.KinestateEmergencyListener;
import server.iot.emergency.OverstepEmergencyListener;
import server.iot.emergency.PhysicalEmergencyListener;
import server.iot.handler.EmergencyRecognizeHandler;
import server.iot.handler.PersistenceHandler;
import server.iot.handler.RegroupMsgHandler;
import server.iot.handler.RingObjDecoder;


@Component
public class IotServerBootStrap {


    private static final Logger LOGGER = LoggerFactory.getLogger(IotServerBootStrap.class);

    @Value("${iot.server.port}")
    private Integer servicePort;


    public void start() {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workGroup = new NioEventLoopGroup();
        ServerBootstrap boot = new ServerBootstrap();
        boot.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 100)    //TODO 配置缓冲区大小，后续定制服务端Channel
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(getChildChannelHandler());

        try {
            ChannelFuture future = boot.bind(servicePort).sync();
            startupLog();
            future.channel().closeFuture().sync();    //TODO ???
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();    //TODO 作用???
            workGroup.shutdownGracefully();
        }

    }

    private ChannelHandler getChildChannelHandler() {

        return new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline()
                        .addLast(new RegroupMsgHandler())    //TODO 考虑使用Decoder
                        .addLast(new RingObjDecoder())
                        .addLast(getEmergencyHandler())    //TODO 考虑持久化与告警的顺序
                        .addLast(new PersistenceHandler());
                //TODO 添加其他handler
            }
        };
    }

    private EmergencyRecognizeHandler getEmergencyHandler() {
        EmergencyRecognizeHandler handler = new EmergencyRecognizeHandler();
        handler.addListener(new OverstepEmergencyListener());
        handler.addListener(new PhysicalEmergencyListener());
        handler.addListener(new KinestateEmergencyListener());
        return handler;
    }

    private void startupLog() {
        LOGGER.info("*******************************************");
        LOGGER.info("************ IoTServer started ************");
        LOGGER.info("*******************************************");
    }

}
