package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLMessageViews extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected Integer views;

    protected Integer forwards;

    protected TLMessageReplies replies;

    private final String _constructor = "messageViews#0";

    public TLMessageViews() {
    }

    public TLMessageViews(Integer views, Integer forwards, TLMessageReplies replies) {
        this.views = views;
        this.forwards = forwards;
        this.replies = replies;
    }

    private void computeFlags() {
        flags = 0;
        flags = views != null ? (flags | 1) : (flags & ~1);
        flags = forwards != null ? (flags | 2) : (flags & ~2);
        flags = replies != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (views == null) throwNullFieldException("views", flags);
            writeInt(views, stream);
        }
        if ((flags & 2) != 0) {
            if (forwards == null) throwNullFieldException("forwards", flags);
            writeInt(forwards, stream);
        }
        if ((flags & 4) != 0) {
            if (replies == null) throwNullFieldException("replies", flags);
            writeTLObject(replies, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        views = (flags & 1) != 0 ? readInt(stream) : null;
        forwards = (flags & 2) != 0 ? readInt(stream) : null;
        replies = (flags & 4) != 0 ? readTLObject(stream, context, TLMessageReplies.class, TLMessageReplies.CONSTRUCTOR_ID) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (views == null) throwNullFieldException("views", flags);
            size += SIZE_INT32;
        }
        if ((flags & 2) != 0) {
            if (forwards == null) throwNullFieldException("forwards", flags);
            size += SIZE_INT32;
        }
        if ((flags & 4) != 0) {
            if (replies == null) throwNullFieldException("replies", flags);
            size += replies.computeSerializedSize();
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

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getForwards() {
        return forwards;
    }

    public void setForwards(Integer forwards) {
        this.forwards = forwards;
    }

    public TLMessageReplies getReplies() {
        return replies;
    }

    public void setReplies(TLMessageReplies replies) {
        this.replies = replies;
    }
}
