package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLIntVector;
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
public class TLUpdateBotDeleteBusinessMessage extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected String connectionId;

    protected TLAbsPeer peer;

    protected TLIntVector messages;

    protected int qts;

    private final String _constructor = "updateBotDeleteBusinessMessage#0";

    public TLUpdateBotDeleteBusinessMessage() {
    }

    public TLUpdateBotDeleteBusinessMessage(String connectionId, TLAbsPeer peer, TLIntVector messages, int qts) {
        this.connectionId = connectionId;
        this.peer = peer;
        this.messages = messages;
        this.qts = qts;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(connectionId, stream);
        writeTLObject(peer, stream);
        writeTLVector(messages, stream);
        writeInt(qts, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        connectionId = readTLString(stream);
        peer = readTLObject(stream, context, TLAbsPeer.class, -1);
        messages = readTLIntVector(stream, context);
        qts = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(connectionId);
        size += peer.computeSerializedSize();
        size += messages.computeSerializedSize();
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

    public String getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(String connectionId) {
        this.connectionId = connectionId;
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

    public int getQts() {
        return qts;
    }

    public void setQts(int qts) {
        this.qts = qts;
    }
}
