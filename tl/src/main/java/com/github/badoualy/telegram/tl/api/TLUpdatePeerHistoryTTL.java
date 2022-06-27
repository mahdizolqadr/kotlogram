package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

public class TLUpdatePeerHistoryTTL extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0xbb9bb9a5;

    protected int flags;
    protected TLAbsPeer peer;
    protected Integer ttlPeriod;

    private final String _constructor = "updatePeerHistoryTTL#bb9bb9a5";

    public TLUpdatePeerHistoryTTL() {
    }

    public TLUpdatePeerHistoryTTL(TLAbsPeer peer, Integer ttlPeriod) {
        this.peer = peer;
        this.ttlPeriod = ttlPeriod;
    }

    private void computeFlags() {
        flags = 0;
        flags = ttlPeriod != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();
        writeInt(flags, stream);
        writeTLObject(peer, stream);
        if ((flags & 1) != 0) {
            if (ttlPeriod == null) {
                throwNullFieldException("ttlPeriod", flags);
            }
            writeInt(ttlPeriod, stream);
        }
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        peer = readTLObject(stream, context, TLAbsPeer.class, -1);
        ttlPeriod = (flags & 1) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (ttlPeriod == null) {
                throwNullFieldException("ttlPeriod", flags);
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

    public TLAbsPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsPeer peer) {
        this.peer = peer;
    }

    public Integer getTtlPeriod() {
        return ttlPeriod;
    }

    public void setTtlPeriod(Integer ttlPeriod) {
        this.ttlPeriod = ttlPeriod;
    }
}
