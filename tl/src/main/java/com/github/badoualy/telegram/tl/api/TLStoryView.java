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
public class TLStoryView extends TLAbsStoryView {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected long userId;

    protected int date;

    protected TLAbsReaction reaction;

    private final String _constructor = "storyView#0";

    public TLStoryView() {
    }

    public TLStoryView(boolean blocked, boolean blockedMyStoriesFrom, long userId, int date, TLAbsReaction reaction) {
        this.blocked = blocked;
        this.blockedMyStoriesFrom = blockedMyStoriesFrom;
        this.userId = userId;
        this.date = date;
        this.reaction = reaction;
    }

    private void computeFlags() {
        flags = 0;
        flags = blocked ? (flags | 1) : (flags & ~1);
        flags = blockedMyStoriesFrom ? (flags | 2) : (flags & ~2);
        flags = reaction != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(userId, stream);
        writeInt(date, stream);
        if ((flags & 4) != 0) {
            if (reaction == null) throwNullFieldException("reaction", flags);
            writeTLObject(reaction, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        blocked = (flags & 1) != 0;
        blockedMyStoriesFrom = (flags & 2) != 0;
        userId = readLong(stream);
        date = readInt(stream);
        reaction = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsReaction.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT32;
        if ((flags & 4) != 0) {
            if (reaction == null) throwNullFieldException("reaction", flags);
            size += reaction.computeSerializedSize();
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

    public boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean getBlockedMyStoriesFrom() {
        return blockedMyStoriesFrom;
    }

    public void setBlockedMyStoriesFrom(boolean blockedMyStoriesFrom) {
        this.blockedMyStoriesFrom = blockedMyStoriesFrom;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public TLAbsReaction getReaction() {
        return reaction;
    }

    public void setReaction(TLAbsReaction reaction) {
        this.reaction = reaction;
    }
}
