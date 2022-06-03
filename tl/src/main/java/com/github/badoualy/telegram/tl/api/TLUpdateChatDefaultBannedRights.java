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

public class TLUpdateChatDefaultBannedRights extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0x54c01850;

    protected TLAbsPeer peer;
    protected TLChatBannedRights defaultBannedRights;
    protected int version;

    private final String _constructor = "updateChatDefaultBannedRights#54c01850";

    public TLUpdateChatDefaultBannedRights() {
    }

    public TLUpdateChatDefaultBannedRights(TLAbsPeer peer, TLChatBannedRights defaultBannedRights, int version) {
        this.peer = peer;
        this.defaultBannedRights = defaultBannedRights;
        this.version = version;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(peer, stream);
        writeTLObject(defaultBannedRights, stream);
        writeInt(version, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        peer = readTLObject(stream, context, TLAbsPeer.class, -1);
        defaultBannedRights = readTLObject(stream, context, TLChatBannedRights.class, TLChatBannedRights.CONSTRUCTOR_ID);
        version = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += peer.computeSerializedSize();
        size += defaultBannedRights.computeSerializedSize();
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

    public TLAbsPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsPeer peer) {
        this.peer = peer;
    }

    public TLChatBannedRights getDefaultBannedRights() {
        return defaultBannedRights;
    }

    public void setDefaultBannedRights(TLChatBannedRights defaultBannedRights) {
        this.defaultBannedRights = defaultBannedRights;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
