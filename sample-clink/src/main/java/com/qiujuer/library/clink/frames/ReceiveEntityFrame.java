package com.qiujuer.library.clink.frames;

import com.qiujuer.library.clink.core.IoArgs;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/**
 * Created by mac on 2019/7/15.
 */
public class ReceiveEntityFrame extends AbsReceiveFrame {

    private WritableByteChannel channel;

    ReceiveEntityFrame(byte[] header) {
        super(header);
    }

    public void bindPacketChannel(WritableByteChannel channel) {
        this.channel = channel;
    }

    @Override
    protected int consumeBody(IoArgs args) throws IOException {
        return channel == null ? args.setEmpty(bodyRemaining) : args.writeTo(channel);
    }

}

