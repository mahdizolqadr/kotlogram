package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateNotifySettings extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsNotifyPeer peer;

    protected TLPeerNotifySettings notifySettings;

    private final String _constructor = "updateNotifySettings#0";

    public TLUpdateNotifySettings() {
    }

    public TLUpdateNotifySettings(TLAbsNotifyPeer peer, TLPeerNotifySettings notifySettings) {
        this.peer = peer;
        this.notifySettings = notifySettings;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(peer, stream);
        writeTLObject(notifySettings, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        peer = readTLObject(stream, context, TLAbsNotifyPeer.class, -1);
        notifySettings = readTLObject(stream, context, TLPeerNotifySettings.class, TLPeerNotifySettings.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += peer.computeSerializedSize();
        size += notifySettings.computeSerializedSize();
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

    public TLAbsNotifyPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsNotifyPeer peer) {
        this.peer = peer;
    }

    public TLPeerNotifySettings getNotifySettings() {
        return notifySettings;
    }

    public void setNotifySettings(TLPeerNotifySettings notifySettings) {
        this.notifySettings = notifySettings;
    }
}
