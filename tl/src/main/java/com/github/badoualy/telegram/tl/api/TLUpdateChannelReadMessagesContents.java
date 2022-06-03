package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLIntVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLIntVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;

public class TLUpdateChannelReadMessagesContents extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0x44bdd535;

    protected long channelId;
    protected TLIntVector messages;

    private final String _constructor = "updateChannelReadMessagesContents#44bdd535";

    public TLUpdateChannelReadMessagesContents() {
    }

    public TLUpdateChannelReadMessagesContents(long channelId, TLIntVector messages) {
        this.channelId = channelId;
        this.messages = messages;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(channelId, stream);
        writeTLVector(messages, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        channelId = readLong(stream);
        messages = readTLIntVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += messages.computeSerializedSize();
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

    public TLIntVector getMessages() {
        return messages;
    }

    public void setMessages(TLIntVector messages) {
        this.messages = messages;
    }
}
