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
public class TLUpdateChatUserTyping extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected long chatId;

    protected TLAbsPeer fromId;

    protected TLAbsSendMessageAction action;

    private final String _constructor = "updateChatUserTyping#0";

    public TLUpdateChatUserTyping() {
    }

    public TLUpdateChatUserTyping(long chatId, TLAbsPeer fromId, TLAbsSendMessageAction action) {
        this.chatId = chatId;
        this.fromId = fromId;
        this.action = action;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(chatId, stream);
        writeTLObject(fromId, stream);
        writeTLObject(action, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        chatId = readLong(stream);
        fromId = readTLObject(stream, context, TLAbsPeer.class, -1);
        action = readTLObject(stream, context, TLAbsSendMessageAction.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += fromId.computeSerializedSize();
        size += action.computeSerializedSize();
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

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public TLAbsPeer getFromId() {
        return fromId;
    }

    public void setFromId(TLAbsPeer fromId) {
        this.fromId = fromId;
    }

    public TLAbsSendMessageAction getAction() {
        return action;
    }

    public void setAction(TLAbsSendMessageAction action) {
        this.action = action;
    }
}
