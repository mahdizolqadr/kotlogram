package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLIntVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLIntVector;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

public class TLUpdateDeleteScheduledMessages extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0x90866cee;

    protected TLAbsPeer peer;
    protected TLIntVector messages;

    private final String _constructor = "updateDeleteScheduledMessages#90866cee";

    public TLUpdateDeleteScheduledMessages() {
    }

    public TLUpdateDeleteScheduledMessages(TLAbsPeer peer, TLIntVector messages) {
        this.peer = peer;
        this.messages = messages;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(peer, stream);
        writeTLVector(messages, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        peer = readTLObject(stream, context, TLAbsPeer.class, -1);
        messages = readTLIntVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += peer.computeSerializedSize();
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

    public TLAbsPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsPeer peer) {
        this.peer = peer;
    }

    public TLIntVector getMessages() {
        return messages;
    }

    public void setMessages(TLIntVector messages) {
        this.messages = messages;
    }
}
