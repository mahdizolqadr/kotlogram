package com.github.badoualy.telegram.tl.api.stories;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsChat;
import com.github.badoualy.telegram.tl.api.TLAbsStoryItem;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.core.TLIntVector;
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
public class TLStories extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected int count;

    protected TLVector<TLAbsStoryItem> stories;

    protected TLIntVector pinnedToTop;

    protected TLVector<TLAbsChat> chats;

    protected TLVector<TLAbsUser> users;

    private final String _constructor = "stories.stories#0";

    public TLStories() {
    }

    public TLStories(int count, TLVector<TLAbsStoryItem> stories, TLIntVector pinnedToTop, TLVector<TLAbsChat> chats, TLVector<TLAbsUser> users) {
        this.count = count;
        this.stories = stories;
        this.pinnedToTop = pinnedToTop;
        this.chats = chats;
        this.users = users;
    }

    private void computeFlags() {
        flags = 0;
        flags = pinnedToTop != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(count, stream);
        writeTLVector(stories, stream);
        if ((flags & 1) != 0) {
            if (pinnedToTop == null) throwNullFieldException("pinnedToTop", flags);
            writeTLVector(pinnedToTop, stream);
        }
        writeTLVector(chats, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        count = readInt(stream);
        stories = readTLVector(stream, context);
        pinnedToTop = (flags & 1) != 0 ? readTLIntVector(stream, context) : null;
        chats = readTLVector(stream, context);
        users = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += stories.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (pinnedToTop == null) throwNullFieldException("pinnedToTop", flags);
            size += pinnedToTop.computeSerializedSize();
        }
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public TLVector<TLAbsStoryItem> getStories() {
        return stories;
    }

    public void setStories(TLVector<TLAbsStoryItem> stories) {
        this.stories = stories;
    }

    public TLIntVector getPinnedToTop() {
        return pinnedToTop;
    }

    public void setPinnedToTop(TLIntVector pinnedToTop) {
        this.pinnedToTop = pinnedToTop;
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
