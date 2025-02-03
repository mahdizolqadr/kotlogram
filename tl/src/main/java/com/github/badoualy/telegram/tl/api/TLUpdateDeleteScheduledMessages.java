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
public class TLUpdateDeleteScheduledMessages extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLAbsPeer peer;

    protected TLIntVector messages;

    protected TLIntVector sentMessages;

    private final String _constructor = "updateDeleteScheduledMessages#0";

    public TLUpdateDeleteScheduledMessages() {
    }

    public TLUpdateDeleteScheduledMessages(TLAbsPeer peer, TLIntVector messages, TLIntVector sentMessages) {
        this.peer = peer;
        this.messages = messages;
        this.sentMessages = sentMessages;
    }

    private void computeFlags() {
        flags = 0;
        flags = sentMessages != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peer, stream);
        writeTLVector(messages, stream);
        if ((flags & 1) != 0) {
            if (sentMessages == null) throwNullFieldException("sentMessages", flags);
            writeTLVector(sentMessages, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        peer = readTLObject(stream, context, TLAbsPeer.class, -1);
        messages = readTLIntVector(stream, context);
        sentMessages = (flags & 1) != 0 ? readTLIntVector(stream, context) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        size += messages.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (sentMessages == null) throwNullFieldException("sentMessages", flags);
            size += sentMessages.computeSerializedSize();
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

    public TLIntVector getMessages() {
        return messages;
    }

    public void setMessages(TLIntVector messages) {
        this.messages = messages;
    }

    public TLIntVector getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(TLIntVector sentMessages) {
        this.sentMessages = sentMessages;
    }
}
