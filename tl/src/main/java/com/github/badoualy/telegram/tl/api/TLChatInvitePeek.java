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
public class TLChatInvitePeek extends TLAbsChatInvite {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsChat chat;

    protected int expires;

    private final String _constructor = "chatInvitePeek#0";

    public TLChatInvitePeek() {
    }

    public TLChatInvitePeek(TLAbsChat chat, int expires) {
        this.chat = chat;
        this.expires = expires;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(chat, stream);
        writeInt(expires, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        chat = readTLObject(stream, context, TLAbsChat.class, -1);
        expires = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += chat.computeSerializedSize();
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

    public TLAbsChat getChat() {
        return chat;
    }

    public void setChat(TLAbsChat chat) {
        this.chat = chat;
    }

    public int getExpires() {
        return expires;
    }

    public void setExpires(int expires) {
        this.expires = expires;
    }
}
