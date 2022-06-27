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

public class TLMessageActionGroupCallScheduled extends TLAbsMessageAction {

    public static final int CONSTRUCTOR_ID = 0xb3a07661;

    protected TLInputGroupCall call;
    protected int scheduleDate;

    private final String _constructor = "messageActionGroupCallScheduled#b3a07661";

    public TLMessageActionGroupCallScheduled() {
    }

    public TLMessageActionGroupCallScheduled(TLInputGroupCall call, int scheduleDate) {
        this.call = call;
        this.scheduleDate = scheduleDate;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(call, stream);
        writeInt(scheduleDate, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        call = readTLObject(stream, context, TLInputGroupCall.class, TLInputGroupCall.CONSTRUCTOR_ID);
        scheduleDate = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += call.computeSerializedSize();
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

    public TLInputGroupCall getCall() {
        return call;
    }

    public void setCall(TLInputGroupCall call) {
        this.call = call;
    }

    public int getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(int scheduleDate) {
        this.scheduleDate = scheduleDate;
    }
}
