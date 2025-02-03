package com.github.badoualy.telegram.tl.api.messages;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsChat;
import com.github.badoualy.telegram.tl.api.TLAbsForumTopic;
import com.github.badoualy.telegram.tl.api.TLAbsMessage;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
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
public class TLChannelMessages extends TLAbsMessages {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean inexact;

    protected int pts;

    protected int count;

    protected Integer offsetIdOffset;

    protected TLVector<TLAbsMessage> messages;

    protected TLVector<TLAbsForumTopic> topics;

    protected TLVector<TLAbsChat> chats;

    protected TLVector<TLAbsUser> users;

    private final String _constructor = "messages.channelMessages#0";

    public TLChannelMessages() {
    }

    public TLChannelMessages(boolean inexact, int pts, int count, Integer offsetIdOffset, TLVector<TLAbsMessage> messages, TLVector<TLAbsForumTopic> topics, TLVector<TLAbsChat> chats, TLVector<TLAbsUser> users) {
        this.inexact = inexact;
        this.pts = pts;
        this.count = count;
        this.offsetIdOffset = offsetIdOffset;
        this.messages = messages;
        this.topics = topics;
        this.chats = chats;
        this.users = users;
    }

    private void computeFlags() {
        flags = 0;
        flags = inexact ? (flags | 2) : (flags & ~2);
        flags = offsetIdOffset != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(pts, stream);
        writeInt(count, stream);
        if ((flags & 4) != 0) {
            if (offsetIdOffset == null) throwNullFieldException("offsetIdOffset", flags);
            writeInt(offsetIdOffset, stream);
        }
        writeTLVector(messages, stream);
        writeTLVector(topics, stream);
        writeTLVector(chats, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        inexact = (flags & 2) != 0;
        pts = readInt(stream);
        count = readInt(stream);
        offsetIdOffset = (flags & 4) != 0 ? readInt(stream) : null;
        messages = readTLVector(stream, context);
        topics = readTLVector(stream, context);
        chats = readTLVector(stream, context);
        users = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 4) != 0) {
            if (offsetIdOffset == null) throwNullFieldException("offsetIdOffset", flags);
            size += SIZE_INT32;
        }
        size += messages.computeSerializedSize();
        size += topics.computeSerializedSize();
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

    public boolean getInexact() {
        return inexact;
    }

    public void setInexact(boolean inexact) {
        this.inexact = inexact;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Integer getOffsetIdOffset() {
        return offsetIdOffset;
    }

    public void setOffsetIdOffset(Integer offsetIdOffset) {
        this.offsetIdOffset = offsetIdOffset;
    }

    public TLVector<TLAbsMessage> getMessages() {
        return messages;
    }

    public void setMessages(TLVector<TLAbsMessage> messages) {
        this.messages = messages;
    }

    public TLVector<TLAbsForumTopic> getTopics() {
        return topics;
    }

    public void setTopics(TLVector<TLAbsForumTopic> topics) {
        this.topics = topics;
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
