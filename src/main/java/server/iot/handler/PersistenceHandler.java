package server.iot.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import server.iot.pojo.RingRecord;
import server.utils.RingUtils;

public class PersistenceHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        RingRecord record = (RingRecord) msg;
        System.out.println("[----------- PersistenceHandler -----------]");
        persistence(record);
        ctx.fireChannelRead(record);
    }

    private void persistence(RingRecord record) {
        RingUtils.persistence(record);
    }

}
