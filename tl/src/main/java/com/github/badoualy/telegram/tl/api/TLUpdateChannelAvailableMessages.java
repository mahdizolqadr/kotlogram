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

public class TLUpdateChannelAvailableMessages extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0xb23fc698;

    protected long channelId;
    protected int availableMinId;

    private final String _constructor = "updateChannelAvailableMessages#b23fc698";

    public TLUpdateChannelAvailableMessages() {
    }

    public TLUpdateChannelAvailableMessages(long channelId, int availableMinId) {
        this.channelId = channelId;
        this.availableMinId = availableMinId;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(channelId, stream);
        writeInt(availableMinId, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        channelId = readLong(stream);
        availableMinId = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
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

    public int getAvailableMinId() {
        return availableMinId;
    }

    public void setAvailableMinId(int availableMinId) {
        this.availableMinId = availableMinId;
    }
}
