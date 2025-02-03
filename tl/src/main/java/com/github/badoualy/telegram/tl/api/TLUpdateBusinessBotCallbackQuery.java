package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
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
public class TLUpdateBusinessBotCallbackQuery extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected long queryId;

    protected long userId;

    protected String connectionId;

    protected TLAbsMessage message;

    protected TLAbsMessage replyToMessage;

    protected long chatInstance;

    protected TLBytes data;

    private final String _constructor = "updateBusinessBotCallbackQuery#0";

    public TLUpdateBusinessBotCallbackQuery() {
    }

    public TLUpdateBusinessBotCallbackQuery(long queryId, long userId, String connectionId, TLAbsMessage message, TLAbsMessage replyToMessage, long chatInstance, TLBytes data) {
        this.queryId = queryId;
        this.userId = userId;
        this.connectionId = connectionId;
        this.message = message;
        this.replyToMessage = replyToMessage;
        this.chatInstance = chatInstance;
        this.data = data;
    }

    private void computeFlags() {
        flags = 0;
        flags = replyToMessage != null ? (flags | 4) : (flags & ~4);
        flags = data != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(queryId, stream);
        writeLong(userId, stream);
        writeString(connectionId, stream);
        writeTLObject(message, stream);
        if ((flags & 4) != 0) {
            if (replyToMessage == null) throwNullFieldException("replyToMessage", flags);
            writeTLObject(replyToMessage, stream);
        }
        writeLong(chatInstance, stream);
        if ((flags & 1) != 0) {
            if (data == null) throwNullFieldException("data", flags);
            writeTLBytes(data, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        queryId = readLong(stream);
        userId = readLong(stream);
        connectionId = readTLString(stream);
        message = readTLObject(stream, context, TLAbsMessage.class, -1);
        replyToMessage = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsMessage.class, -1) : null;
        chatInstance = readLong(stream);
        data = (flags & 1) != 0 ? readTLBytes(stream, context) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(connectionId);
        size += message.computeSerializedSize();
        if ((flags & 4) != 0) {
            if (replyToMessage == null) throwNullFieldException("replyToMessage", flags);
            size += replyToMessage.computeSerializedSize();
        }
        size += SIZE_INT64;
        if ((flags & 1) != 0) {
            if (data == null) throwNullFieldException("data", flags);
            size += computeTLBytesSerializedSize(data);
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

    public long getQueryId() {
        return queryId;
    }

    public void setQueryId(long queryId) {
        this.queryId = queryId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public long getChatInstance() {
        return chatInstance;
    }

    public void setChatInstance(long chatInstance) {
        this.chatInstance = chatInstance;
    }

    public TLBytes getData() {
        return data;
    }

    public void setData(TLBytes data) {
        this.data = data;
    }
}
