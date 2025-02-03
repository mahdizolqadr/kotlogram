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
public class TLStoryViewPublicForward extends TLAbsStoryView {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsMessage message;

    private final String _constructor = "storyViewPublicForward#0";

    public TLStoryViewPublicForward() {
    }

    public TLStoryViewPublicForward(boolean blocked, boolean blockedMyStoriesFrom, TLAbsMessage message) {
        this.blocked = blocked;
        this.blockedMyStoriesFrom = blockedMyStoriesFrom;
        this.message = message;
    }

    private void computeFlags() {
        flags = 0;
        flags = blocked ? (flags | 1) : (flags & ~1);
        flags = blockedMyStoriesFrom ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(message, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        blocked = (flags & 1) != 0;
        blockedMyStoriesFrom = (flags & 2) != 0;
        message = readTLObject(stream, context, TLAbsMessage.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += message.computeSerializedSize();
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

    public TLAbsMessage getMessage() {
        return message;
    }

    public void setMessage(TLAbsMessage message) {
        this.message = message;
    }
}
