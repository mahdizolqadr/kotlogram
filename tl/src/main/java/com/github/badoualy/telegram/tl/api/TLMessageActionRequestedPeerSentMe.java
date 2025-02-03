package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;
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
public class TLMessageActionRequestedPeerSentMe extends TLAbsMessageAction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int buttonId;

    protected TLVector<TLAbsRequestedPeer> peers;

    private final String _constructor = "messageActionRequestedPeerSentMe#0";

    public TLMessageActionRequestedPeerSentMe() {
    }

    public TLMessageActionRequestedPeerSentMe(int buttonId, TLVector<TLAbsRequestedPeer> peers) {
        this.buttonId = buttonId;
        this.peers = peers;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(buttonId, stream);
        writeTLVector(peers, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        buttonId = readInt(stream);
        peers = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peers.computeSerializedSize();
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

    public int getButtonId() {
        return buttonId;
    }

    public void setButtonId(int buttonId) {
        this.buttonId = buttonId;
    }

    public TLVector<TLAbsRequestedPeer> getPeers() {
        return peers;
    }

    public void setPeers(TLVector<TLAbsRequestedPeer> peers) {
        this.peers = peers;
    }
}
