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
public class TLUpdateInlineBotCallbackQuery extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected long queryId;

    protected long userId;

    protected TLAbsInputBotInlineMessageID msgId;

    protected long chatInstance;

    protected TLBytes data;

    protected String gameShortName;

    private final String _constructor = "updateInlineBotCallbackQuery#0";

    public TLUpdateInlineBotCallbackQuery() {
    }

    public TLUpdateInlineBotCallbackQuery(long queryId, long userId, TLAbsInputBotInlineMessageID msgId, long chatInstance, TLBytes data, String gameShortName) {
        this.queryId = queryId;
        this.userId = userId;
        this.msgId = msgId;
        this.chatInstance = chatInstance;
        this.data = data;
        this.gameShortName = gameShortName;
    }

    private void computeFlags() {
        flags = 0;
        flags = data != null ? (flags | 1) : (flags & ~1);
        flags = gameShortName != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(queryId, stream);
        writeLong(userId, stream);
        writeTLObject(msgId, stream);
        writeLong(chatInstance, stream);
        if ((flags & 1) != 0) {
            if (data == null) throwNullFieldException("data", flags);
            writeTLBytes(data, stream);
        }
        if ((flags & 2) != 0) {
            if (gameShortName == null) throwNullFieldException("gameShortName", flags);
            writeString(gameShortName, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        queryId = readLong(stream);
        userId = readLong(stream);
        msgId = readTLObject(stream, context, TLAbsInputBotInlineMessageID.class, -1);
        chatInstance = readLong(stream);
        data = (flags & 1) != 0 ? readTLBytes(stream, context) : null;
        gameShortName = (flags & 2) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += msgId.computeSerializedSize();
        size += SIZE_INT64;
        if ((flags & 1) != 0) {
            if (data == null) throwNullFieldException("data", flags);
            size += computeTLBytesSerializedSize(data);
        }
        if ((flags & 2) != 0) {
            if (gameShortName == null) throwNullFieldException("gameShortName", flags);
            size += computeTLStringSerializedSize(gameShortName);
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

    public TLAbsInputBotInlineMessageID getMsgId() {
        return msgId;
    }

    public void setMsgId(TLAbsInputBotInlineMessageID msgId) {
        this.msgId = msgId;
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

    public String getGameShortName() {
        return gameShortName;
    }

    public void setGameShortName(String gameShortName) {
        this.gameShortName = gameShortName;
    }
}
