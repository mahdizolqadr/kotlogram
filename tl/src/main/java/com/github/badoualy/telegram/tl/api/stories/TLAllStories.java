package com.github.badoualy.telegram.tl.api.stories;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsChat;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.api.TLPeerStories;
import com.github.badoualy.telegram.tl.api.TLStoriesStealthMode;
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
public class TLAllStories extends TLAbsAllStories {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected boolean hasMore;

    protected int count;

    protected TLVector<TLPeerStories> peerStories;

    protected TLVector<TLAbsChat> chats;

    protected TLVector<TLAbsUser> users;

    private final String _constructor = "stories.allStories#0";

    public TLAllStories() {
    }

    public TLAllStories(boolean hasMore, int count, String state, TLVector<TLPeerStories> peerStories, TLVector<TLAbsChat> chats, TLVector<TLAbsUser> users, TLStoriesStealthMode stealthMode) {
        this.hasMore = hasMore;
        this.count = count;
        this.state = state;
        this.peerStories = peerStories;
        this.chats = chats;
        this.users = users;
        this.stealthMode = stealthMode;
    }

    private void computeFlags() {
        flags = 0;
        flags = hasMore ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(count, stream);
        writeString(state, stream);
        writeTLVector(peerStories, stream);
        writeTLVector(chats, stream);
        writeTLVector(users, stream);
        writeTLObject(stealthMode, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        hasMore = (flags & 1) != 0;
        count = readInt(stream);
        state = readTLString(stream);
        peerStories = readTLVector(stream, context);
        chats = readTLVector(stream, context);
        users = readTLVector(stream, context);
        stealthMode = readTLObject(stream, context, TLStoriesStealthMode.class, TLStoriesStealthMode.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(state);
        size += peerStories.computeSerializedSize();
        size += chats.computeSerializedSize();
        size += users.computeSerializedSize();
        size += stealthMode.computeSerializedSize();
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

    public boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public TLVector<TLPeerStories> getPeerStories() {
        return peerStories;
    }

    public void setPeerStories(TLVector<TLPeerStories> peerStories) {
        this.peerStories = peerStories;
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

    public TLStoriesStealthMode getStealthMode() {
        return stealthMode;
    }

    public void setStealthMode(TLStoriesStealthMode stealthMode) {
        this.stealthMode = stealthMode;
    }
}
