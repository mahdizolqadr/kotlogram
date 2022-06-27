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

public class TLUpdateChannelMessageForwards extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0xd29a27f4;

    protected long channelId;
    protected int id;
    protected int forwards;

    private final String _constructor = "updateChannelMessageForwards#d29a27f4";

    public TLUpdateChannelMessageForwards() {
    }

    public TLUpdateChannelMessageForwards(long channelId, int id, int forwards) {
        this.channelId = channelId;
        this.id = id;
        this.forwards = forwards;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(channelId, stream);
        writeInt(id, stream);
        writeInt(forwards, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        channelId = readLong(stream);
        id = readInt(stream);
        forwards = readInt(stream);
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getForwards() {
        return forwards;
    }

    public void setForwards(int forwards) {
        this.forwards = forwards;
    }
}
