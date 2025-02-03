package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLGroupCallStreamChannel extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int channel;

    protected int scale;

    protected long lastTimestampMs;

    private final String _constructor = "groupCallStreamChannel#0";

    public TLGroupCallStreamChannel() {
    }

    public TLGroupCallStreamChannel(int channel, int scale, long lastTimestampMs) {
        this.channel = channel;
        this.scale = scale;
        this.lastTimestampMs = lastTimestampMs;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(channel, stream);
        writeInt(scale, stream);
        writeLong(lastTimestampMs, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        channel = readInt(stream);
        scale = readInt(stream);
        lastTimestampMs = readLong(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT64;
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

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public long getLastTimestampMs() {
        return lastTimestampMs;
    }

    public void setLastTimestampMs(long lastTimestampMs) {
        this.lastTimestampMs = lastTimestampMs;
    }
}
