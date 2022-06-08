package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.call.TLAbsGroupCall;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;

public class TLUpdateGroupCall extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0x14b24500;

    protected long chatId;
    protected TLAbsGroupCall call;

    private final String _constructor = "updateGroupCall#14b24500";

    public TLUpdateGroupCall() {
    }

    public TLUpdateGroupCall(long chatId, TLAbsGroupCall call) {
        this.chatId = chatId;
        this.call = call;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(chatId, stream);
        writeTLObject(call, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        chatId = readLong(stream);
        call = readTLObject(stream, context, TLAbsGroupCall.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += call.computeSerializedSize();
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

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public TLAbsGroupCall getCall() {
        return call;
    }

    public void setCall(TLAbsGroupCall call) {
        this.call = call;
    }
}
