package com.example.socket.L6_Base.clink.frames;

import com.example.socket.L6_Base.clink.core.Frame;
import com.example.socket.L6_Base.clink.core.IoArgs;
import com.example.socket.L6_Base.clink.core.SendPacket;

import java.io.IOException;
import java.nio.channels.ReadableByteChannel;

/**
 * Created by mac on 2020-09-28.
 */
public class SendEntityFrame extends AbsSendPacketFrame {
    private final ReadableByteChannel channel;
    private final long unConsumeEntityLength;


    public SendEntityFrame(short identifier, long entityLength, ReadableByteChannel channel, SendPacket packet) {
        super((int) Math.min(entityLength, Frame.MAX_CAPACITY),
                Frame.TYPE_PACKET_ENTITY,
                Frame.FLAG_NONE,
                identifier,
                packet);

        // 1234567890
        // 1234 5678 90
        // 10 4,6 4,2 2
        this.unConsumeEntityLength = entityLength - bodyRemaining;
        this.channel = channel;
    }

    @Override
    protected int consumeBody(IoArgs args) throws IOException {
        if (packet == null) {
            // 已终止当前帧，则填充假数据
            return args.fillEmpty(bodyRemaining);
        }
        return args.readFrom(channel);
    }

    @Override
    public Frame buildNextFrame() {
        if (unConsumeEntityLength == 0) {
            return null;
        }
        // 将未消费的长度用于构建下一帧
        return new SendEntityFrame(getBodyIdentifier(),
                unConsumeEntityLength,
                channel,
                packet);
    }
}
