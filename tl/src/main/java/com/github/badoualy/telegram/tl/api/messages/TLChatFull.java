package com.github.badoualy.telegram.tl.api.messages;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsChat;
import com.github.badoualy.telegram.tl.api.TLAbsChatFull;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */

//TODO: field set is incomplete, @see <a href ="https://core.telegram.org/constructor/messages.chatFull">
public class TLChatFull extends TLObject {

    public static final int CONSTRUCTOR_ID = 0xe5d7d19c;

    protected TLAbsChatFull fullChat;

    private final String _constructor = "messages.chatFull#e5d7d19c";

    public TLChatFull() {
    }

    public TLChatFull(TLAbsChatFull fullChat, TLVector<TLAbsChat> chats, TLVector<TLAbsUser> users) {
        this.fullChat = fullChat;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(fullChat, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        fullChat = readTLObject(stream, context, TLAbsChatFull.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += fullChat.computeSerializedSize();
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

    public TLAbsChatFull getFullChat() {
        return fullChat;
    }

    public void setFullChat(TLAbsChatFull fullChat) {
        this.fullChat = fullChat;
    }
}
