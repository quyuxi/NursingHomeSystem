package server.iot.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import server.pojo.RingRecord;
import server.utils.RingUtils;

public class PersistenceHandler extends ChannelInboundHandlerAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(PersistenceHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        RingRecord record = (RingRecord) msg;
        LOG.info("[----------- PersistenceHandler -----------]");
        persistence(record);
        ctx.fireChannelRead(record);
    }

    private void persistence(RingRecord record) {
        RingUtils.persistence(record);
    }

}
