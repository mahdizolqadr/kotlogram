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
public class TLUpdateBotEditBusinessMessage extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected String connectionId;

    protected TLAbsMessage message;

    protected TLAbsMessage replyToMessage;

    protected int qts;

    private final String _constructor = "updateBotEditBusinessMessage#0";

    public TLUpdateBotEditBusinessMessage() {
    }

    public TLUpdateBotEditBusinessMessage(String connectionId, TLAbsMessage message, TLAbsMessage replyToMessage, int qts) {
        this.connectionId = connectionId;
        this.message = message;
        this.replyToMessage = replyToMessage;
        this.qts = qts;
    }

    private void computeFlags() {
        flags = 0;
        flags = replyToMessage != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(connectionId, stream);
        writeTLObject(message, stream);
        if ((flags & 1) != 0) {
            if (replyToMessage == null) throwNullFieldException("replyToMessage", flags);
            writeTLObject(replyToMessage, stream);
        }
        writeInt(qts, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        connectionId = readTLString(stream);
        message = readTLObject(stream, context, TLAbsMessage.class, -1);
        replyToMessage = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsMessage.class, -1) : null;
        qts = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(connectionId);
        size += message.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (replyToMessage == null) throwNullFieldException("replyToMessage", flags);
            size += replyToMessage.computeSerializedSize();
        }
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

    public TLAbsMessage getMessage() {
        return message;
    }

    public void setMessage(TLAbsMessage message) {
        this.message = message;
    }

    public TLAbsMessage getReplyToMessage() {
        return replyToMessage;
    }

    public void setReplyToMessage(TLAbsMessage replyToMessage) {
        this.replyToMessage = replyToMessage;
    }

    public int getQts() {
        return qts;
    }

    public void setQts(int qts) {
        this.qts = qts;
    }
}
