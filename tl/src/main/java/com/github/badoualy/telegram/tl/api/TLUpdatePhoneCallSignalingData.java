package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize;

public class TLUpdatePhoneCallSignalingData extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0x2661bf09;

    protected long phoneCallId;
    protected TLBytes data;

    private final String _constructor = "updatePhoneCallSignalingData#2661bf09";

    public TLUpdatePhoneCallSignalingData() {
    }

    public TLUpdatePhoneCallSignalingData(long phoneCallId, TLBytes data) {
        this.phoneCallId = phoneCallId;
        this.data = data;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(phoneCallId, stream);
        writeTLBytes(data, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        phoneCallId = readLong(stream);
        data = readTLBytes(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += computeTLBytesSerializedSize(data);
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

    public long getPhoneCallId() {
        return phoneCallId;
    }

    public void setPhoneCallId(long phoneCallId) {
        this.phoneCallId = phoneCallId;
    }

    public TLBytes getData() {
        return data;
    }

    public void setData(TLBytes data) {
        this.data = data;
    }
}
