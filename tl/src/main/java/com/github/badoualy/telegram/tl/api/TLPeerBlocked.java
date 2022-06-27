package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

public class TLPeerBlocked extends TLObject {

    public static final int CONSTRUCTOR_ID = 0xe8fd8014;

    protected TLAbsPeer peerId;

    protected int date;

    private final String _constructor = "peerBlocked#e8fd8014";

    public TLPeerBlocked() {
    }

    public TLPeerBlocked(TLAbsPeer peerId, int date) {
        this.peerId = peerId;
        this.date = date;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(peerId, stream);
        writeInt(date, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        peerId = readTLObject(stream, context, TLAbsPeer.class, -1);
        date = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += peerId.computeSerializedSize();
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

    public TLAbsPeer getPeerId() {
        return peerId;
    }

    public void setPeerId(TLAbsPeer peerId) {
        this.peerId = peerId;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
