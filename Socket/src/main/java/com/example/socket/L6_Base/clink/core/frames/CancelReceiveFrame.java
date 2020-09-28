package com.example.socket.L6_Base.clink.core.frames;

import com.example.socket.L6_Base.clink.core.IoArgs;

import java.io.IOException;

/**
 * 取消传输帧，接收实现
 */
public class CancelReceiveFrame extends AbsReceiveFrame {

    CancelReceiveFrame(byte[] header) {
        super(header);
    }

    @Override
    protected int consumeBody(IoArgs args) throws IOException {
        return 0;
    }
}
