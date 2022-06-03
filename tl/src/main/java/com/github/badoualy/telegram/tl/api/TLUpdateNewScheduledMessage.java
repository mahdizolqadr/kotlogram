package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

public class TLUpdateNewScheduledMessage extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0x39a51dfb;

    protected TLAbsMessage message;

    private final String _constructor = "updateNewScheduledMessage#39a51dfb";

    public TLUpdateNewScheduledMessage() {
    }

    public TLUpdateNewScheduledMessage(TLAbsMessage message) {
        this.message = message;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(message, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        message = readTLObject(stream, context, TLAbsMessage.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += message.computeSerializedSize();
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

    public TLAbsMessage getMessage() {
        return message;
    }

    public void setMessage(TLAbsMessage message) {
        this.message = message;
    }
}
