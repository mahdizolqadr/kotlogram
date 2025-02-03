package com.github.badoualy.telegram.tl.api.messages;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsChat;
import com.github.badoualy.telegram.tl.api.TLAbsMessage;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLDiscussionMessage extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLVector<TLAbsMessage> messages;

    protected Integer maxId;

    protected Integer readInboxMaxId;

    protected Integer readOutboxMaxId;

    protected int unreadCount;

    protected TLVector<TLAbsChat> chats;

    protected TLVector<TLAbsUser> users;

    private final String _constructor = "messages.discussionMessage#0";

    public TLDiscussionMessage() {
    }

    public TLDiscussionMessage(TLVector<TLAbsMessage> messages, Integer maxId, Integer readInboxMaxId, Integer readOutboxMaxId, int unreadCount, TLVector<TLAbsChat> chats, TLVector<TLAbsUser> users) {
        this.messages = messages;
        this.maxId = maxId;
        this.readInboxMaxId = readInboxMaxId;
        this.readOutboxMaxId = readOutboxMaxId;
        this.unreadCount = unreadCount;
        this.chats = chats;
        this.users = users;
    }

    private void computeFlags() {
        flags = 0;
        flags = maxId != null ? (flags | 1) : (flags & ~1);
        flags = readInboxMaxId != null ? (flags | 2) : (flags & ~2);
        flags = readOutboxMaxId != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLVector(messages, stream);
        if ((flags & 1) != 0) {
            if (maxId == null) throwNullFieldException("maxId", flags);
            writeInt(maxId, stream);
        }
        if ((flags & 2) != 0) {
            if (readInboxMaxId == null) throwNullFieldException("readInboxMaxId", flags);
            writeInt(readInboxMaxId, stream);
        }
        if ((flags & 4) != 0) {
            if (readOutboxMaxId == null) throwNullFieldException("readOutboxMaxId", flags);
            writeInt(readOutboxMaxId, stream);
        }
        writeInt(unreadCount, stream);
        writeTLVector(chats, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        messages = readTLVector(stream, context);
        maxId = (flags & 1) != 0 ? readInt(stream) : null;
        readInboxMaxId = (flags & 2) != 0 ? readInt(stream) : null;
        readOutboxMaxId = (flags & 4) != 0 ? readInt(stream) : null;
        unreadCount = readInt(stream);
        chats = readTLVector(stream, context);
        users = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += messages.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (maxId == null) throwNullFieldException("maxId", flags);
            size += SIZE_INT32;
        }
        if ((flags & 2) != 0) {
            if (readInboxMaxId == null) throwNullFieldException("readInboxMaxId", flags);
            size += SIZE_INT32;
        }
        if ((flags & 4) != 0) {
            if (readOutboxMaxId == null) throwNullFieldException("readOutboxMaxId", flags);
            size += SIZE_INT32;
        }
        size += SIZE_INT32;
        size += chats.computeSerializedSize();
        size += users.computeSerializedSize();
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

    public TLVector<TLAbsMessage> getMessages() {
        return messages;
    }

    public void setMessages(TLVector<TLAbsMessage> messages) {
        this.messages = messages;
    }

    public Integer getMaxId() {
        return maxId;
    }

    public void setMaxId(Integer maxId) {
        this.maxId = maxId;
    }

    public Integer getReadInboxMaxId() {
        return readInboxMaxId;
    }

    public void setReadInboxMaxId(Integer readInboxMaxId) {
        this.readInboxMaxId = readInboxMaxId;
    }

    public Integer getReadOutboxMaxId() {
        return readOutboxMaxId;
    }

    public void setReadOutboxMaxId(Integer readOutboxMaxId) {
        this.readOutboxMaxId = readOutboxMaxId;
    }

    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }

    public TLVector<TLAbsChat> getChats() {
        return chats;
    }

    public void setChats(TLVector<TLAbsChat> chats) {
        this.chats = chats;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }
}
