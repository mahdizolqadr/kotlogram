package com.github.badoualy.telegram.tl.api.messages;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsChat;
import com.github.badoualy.telegram.tl.api.TLAbsForumTopic;
import com.github.badoualy.telegram.tl.api.TLAbsMessage;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
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
public class TLForumTopics extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean orderByCreateDate;

    protected int count;

    protected TLVector<TLAbsForumTopic> topics;

    protected TLVector<TLAbsMessage> messages;

    protected TLVector<TLAbsChat> chats;

    protected TLVector<TLAbsUser> users;

    protected int pts;

    private final String _constructor = "messages.forumTopics#0";

    public TLForumTopics() {
    }

    public TLForumTopics(boolean orderByCreateDate, int count, TLVector<TLAbsForumTopic> topics, TLVector<TLAbsMessage> messages, TLVector<TLAbsChat> chats, TLVector<TLAbsUser> users, int pts) {
        this.orderByCreateDate = orderByCreateDate;
        this.count = count;
        this.topics = topics;
        this.messages = messages;
        this.chats = chats;
        this.users = users;
        this.pts = pts;
    }

    private void computeFlags() {
        flags = 0;
        flags = orderByCreateDate ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(count, stream);
        writeTLVector(topics, stream);
        writeTLVector(messages, stream);
        writeTLVector(chats, stream);
        writeTLVector(users, stream);
        writeInt(pts, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        orderByCreateDate = (flags & 1) != 0;
        count = readInt(stream);
        topics = readTLVector(stream, context);
        messages = readTLVector(stream, context);
        chats = readTLVector(stream, context);
        users = readTLVector(stream, context);
        pts = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += topics.computeSerializedSize();
        size += messages.computeSerializedSize();
        size += chats.computeSerializedSize();
        size += users.computeSerializedSize();
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

    public boolean getOrderByCreateDate() {
        return orderByCreateDate;
    }

    public void setOrderByCreateDate(boolean orderByCreateDate) {
        this.orderByCreateDate = orderByCreateDate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public TLVector<TLAbsForumTopic> getTopics() {
        return topics;
    }

    public void setTopics(TLVector<TLAbsForumTopic> topics) {
        this.topics = topics;
    }

    public TLVector<TLAbsMessage> getMessages() {
        return messages;
    }

    public void setMessages(TLVector<TLAbsMessage> messages) {
        this.messages = messages;
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

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }
}
