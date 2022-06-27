package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.call.TLInputGroupCall;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

public class TLMessageActionGroupCall extends TLAbsMessageAction {

    public static final int CONSTRUCTOR_ID = 0x7a0d7f42;

    protected int flags;
    protected TLInputGroupCall call;
    protected Integer duration;

    private final String _constructor = "messageActionGroupCall#7a0d7f42";

    public TLMessageActionGroupCall() {
    }

    public TLMessageActionGroupCall(TLInputGroupCall call, Integer duration) {
        this.call = call;
        this.duration = duration;
    }

    private void computeFlags() {
        flags = 0;
        flags = duration != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();
        writeInt(flags, stream);
        writeTLObject(call, stream);
        if ((flags & 1) != 0) {
            if (duration == null) {
                throwNullFieldException("duration", flags);
            }
            writeInt(duration, stream);
        }
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        call = readTLObject(stream, context, TLInputGroupCall.class, TLInputGroupCall.CONSTRUCTOR_ID);
        duration = (flags & 1) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += call.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (duration == null) {
                throwNullFieldException("duration", flags);
            }
            size += SIZE_INT32;
        }
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

    public TLInputGroupCall getCall() {
        return call;
    }

    public void setCall(TLInputGroupCall call) {
        this.call = call;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
