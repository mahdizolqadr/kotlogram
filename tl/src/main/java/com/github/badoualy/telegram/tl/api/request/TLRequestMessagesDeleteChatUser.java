package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputUser;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestMessagesDeleteChatUser extends TLMethod<TLAbsUpdates> {

    public static final int CONSTRUCTOR_ID = 0xa2185cab;

    protected int flags;
    protected boolean revokeHistory;
    protected long chatId;
    protected TLAbsInputUser userId;

    private final String _constructor = "messages.deleteChatUser#a2185cab";

    public TLRequestMessagesDeleteChatUser() {
    }

    public TLRequestMessagesDeleteChatUser(boolean revokeHistory, long chatId, TLAbsInputUser userId) {
        this.revokeHistory = revokeHistory;
        this.chatId = chatId;
        this.userId = userId;
    }

    private void computeFlags() {
        flags = 0;
        flags = revokeHistory ? (flags | 1) : (flags & ~1);
    }

    @Override
    public TLAbsUpdates deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsUpdates)) {
            throw new IOException(
                    "Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response
                            .getClass().getCanonicalName());
        }
        return (TLAbsUpdates) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();
        writeInt(flags, stream);
        writeLong(chatId, stream);
        writeTLObject(userId, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        revokeHistory = (flags & 1) != 0;
        chatId = readLong(stream);
        userId = readTLObject(stream, context, TLAbsInputUser.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += userId.computeSerializedSize();
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

    public boolean isRevokeHistory() {
        return revokeHistory;
    }

    public void setRevokeHistory(boolean revokeHistory) {
        this.revokeHistory = revokeHistory;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public TLAbsInputUser getUserId() {
        return userId;
    }

    public void setUserId(TLAbsInputUser userId) {
        this.userId = userId;
    }
}
