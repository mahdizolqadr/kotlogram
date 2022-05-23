package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

public class TLUpdatePeerSettings extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0x6a7e7366;

    protected TLAbsPeer peer;

    protected TLPeerSettings settings;

    private final String _constructor = "updatePeerSettings#6a7e7366";

    public TLUpdatePeerSettings() {
    }

    public TLUpdatePeerSettings(TLAbsPeer peer, TLPeerSettings settings) {
        this.peer = peer;
        this.settings = settings;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(peer, stream);
        writeTLObject(settings, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        peer = readTLObject(stream, context, TLAbsPeer.class, -1);
        settings = readTLObject(stream, context, TLPeerSettings.class, TLPeerSettings.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += peer.computeSerializedSize();
        size += settings.computeSerializedSize();
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

    public TLPeerSettings getSettings() {
        return settings;
    }

    public void setSettings(TLPeerSettings settings) {
        this.settings = settings;
    }
}
