package server.iot.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import server.iot.observer.EventListener;
import server.iot.observer.EventSourse;
import server.pojo.RingRecord;
import server.pojo.RingRecordAdaptor;

import java.util.LinkedList;
import java.util.List;

public class EmergencyRecognizeHandler extends ChannelInboundHandlerAdapter implements EventSourse {

    private static final Logger LOG = LoggerFactory.getLogger(EmergencyRecognizeHandler.class);
    private final List<EventListener> listeners = new LinkedList<EventListener>();

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        RingRecordAdaptor record = new RingRecordAdaptor((RingRecord) msg);
        LOG.info("[----------- EmergencyRecognizeHandler -----------]");
        handleEmergency(record);
        ctx.fireChannelRead(record.getRecord());
    }

    private void handleEmergency(RingRecordAdaptor record) {
        for (EventListener listener : listeners) {
            listener.notify(record);
        }
    }

    @Override
    public void addListener(EventListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(EventListener listener) {
        listeners.remove(listener);
    }

}
