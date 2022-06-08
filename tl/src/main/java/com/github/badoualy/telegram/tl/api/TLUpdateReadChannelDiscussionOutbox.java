package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;

public class TLUpdateReadChannelDiscussionOutbox extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0x695c9e7c;

    protected long channelId;
    protected int topMsgId;
    protected int readMaxId;

    private final String _constructor = "updateReadChannelDiscussionOutbox#695c9e7c";

    public TLUpdateReadChannelDiscussionOutbox() {
    }

    public TLUpdateReadChannelDiscussionOutbox(long channelId, int topMsgId, int readMaxId) {
        this.channelId = channelId;
        this.topMsgId = topMsgId;
        this.readMaxId = readMaxId;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(channelId, stream);
        writeInt(topMsgId, stream);
        writeInt(readMaxId, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        channelId = readLong(stream);
        topMsgId = readInt(stream);
        readMaxId = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += SIZE_INT32;
        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public long getChannelId() {
        return channelId;
    }

    public void setChannelId(long channelId) {
        this.channelId = channelId;
    }

    public int getTopMsgId() {
        return topMsgId;
    }

    public void setTopMsgId(int topMsgId) {
        this.topMsgId = topMsgId;
    }

    public int getReadMaxId() {
        return readMaxId;
    }

    public void setReadMaxId(int readMaxId) {
        this.readMaxId = readMaxId;
    }
}
