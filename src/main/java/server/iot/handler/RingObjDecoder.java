package server.iot.handler;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import server.iot.pojo.RingRecord;

import java.io.IOException;

public class RingObjDecoder extends ChannelInboundHandlerAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(RingObjDecoder.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws IOException {
        String ringJson = (String) msg;
        RingRecord record = readObject(ringJson);
        LOG.info("[----------- RingObjDecoder -----------]");
        LOG.info(record.toString());
        ctx.fireChannelRead(record);
    }

    RingRecord readObject(String json) throws IOException {
        //TODO 是否存在更优的反序列化方式
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, RingRecord.class);
    }

}
