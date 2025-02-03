package com.github.badoualy.telegram.tl.api.stories;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsChat;
import com.github.badoualy.telegram.tl.api.TLAbsStoryView;
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
public class TLStoryViewsList extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected int count;

    protected int viewsCount;

    protected int forwardsCount;

    protected int reactionsCount;

    protected TLVector<TLAbsStoryView> views;

    protected TLVector<TLAbsChat> chats;

    protected TLVector<TLAbsUser> users;

    protected String nextOffset;

    private final String _constructor = "stories.storyViewsList#0";

    public TLStoryViewsList() {
    }

    public TLStoryViewsList(int count, int viewsCount, int forwardsCount, int reactionsCount, TLVector<TLAbsStoryView> views, TLVector<TLAbsChat> chats, TLVector<TLAbsUser> users, String nextOffset) {
        this.count = count;
        this.viewsCount = viewsCount;
        this.forwardsCount = forwardsCount;
        this.reactionsCount = reactionsCount;
        this.views = views;
        this.chats = chats;
        this.users = users;
        this.nextOffset = nextOffset;
    }

    private void computeFlags() {
        flags = 0;
        flags = nextOffset != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(count, stream);
        writeInt(viewsCount, stream);
        writeInt(forwardsCount, stream);
        writeInt(reactionsCount, stream);
        writeTLVector(views, stream);
        writeTLVector(chats, stream);
        writeTLVector(users, stream);
        if ((flags & 1) != 0) {
            if (nextOffset == null) throwNullFieldException("nextOffset", flags);
            writeString(nextOffset, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        count = readInt(stream);
        viewsCount = readInt(stream);
        forwardsCount = readInt(stream);
        reactionsCount = readInt(stream);
        views = readTLVector(stream, context);
        chats = readTLVector(stream, context);
        users = readTLVector(stream, context);
        nextOffset = (flags & 1) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += views.computeSerializedSize();
        size += chats.computeSerializedSize();
        size += users.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (nextOffset == null) throwNullFieldException("nextOffset", flags);
            size += computeTLStringSerializedSize(nextOffset);
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(int viewsCount) {
        this.viewsCount = viewsCount;
    }

    public int getForwardsCount() {
        return forwardsCount;
    }

    public void setForwardsCount(int forwardsCount) {
        this.forwardsCount = forwardsCount;
    }

    public int getReactionsCount() {
        return reactionsCount;
    }

    public void setReactionsCount(int reactionsCount) {
        this.reactionsCount = reactionsCount;
    }

    public TLVector<TLAbsStoryView> getViews() {
        return views;
    }

    public void setViews(TLVector<TLAbsStoryView> views) {
        this.views = views;
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

    public String getNextOffset() {
        return nextOffset;
    }

    public void setNextOffset(String nextOffset) {
        this.nextOffset = nextOffset;
    }
}
