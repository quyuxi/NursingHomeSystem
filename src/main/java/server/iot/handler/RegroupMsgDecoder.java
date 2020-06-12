package server.iot.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RegroupMsgDecoder extends ByteToMessageDecoder {
    private static final Logger LOG = LoggerFactory.getLogger(PersistenceHandler.class);

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        //TODO 解决拆包粘包问题，生成Json串
        String ringJson = getRingJson(in);

        LOG.info("[---] RegroupMsgDecoder:");
        LOG.info(ringJson);
        out.add(ringJson);
    }

    String getRingJson(ByteBuf in) {
        byte[] bytes = new byte[in.readableBytes()];
        in.getBytes(0, bytes);
        return new String(bytes);
    }
}
