package server.iot.handler;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import server.pojo.RingRecord;

import java.io.IOException;

public class RingObjDecoder extends ChannelInboundHandlerAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(RingObjDecoder.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws IOException {
        String ringJson = (String) msg;
        RingRecord record = readObject(ringJson);
        LOG.info("[----------- RingObjDecoder -----------]");
        LOG.info(JSON.toJSONString(record, true));
        ctx.fireChannelRead(record);
    }

    RingRecord readObject(String json) throws IOException {
        //TODO 是否存在更优的反序列化方式
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, RingRecord.class);
    }

}
