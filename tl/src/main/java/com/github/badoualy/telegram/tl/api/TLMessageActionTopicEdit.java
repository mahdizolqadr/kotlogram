package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMessageActionTopicEdit extends TLAbsMessageAction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected String title;

    protected Long iconEmojiId;

    protected boolean closed;

    protected boolean hidden;

    private final String _constructor = "messageActionTopicEdit#0";

    public TLMessageActionTopicEdit() {
    }

    public TLMessageActionTopicEdit(String title, Long iconEmojiId, boolean closed, boolean hidden) {
        this.title = title;
        this.iconEmojiId = iconEmojiId;
        this.closed = closed;
        this.hidden = hidden;
    }

    private void computeFlags() {
        flags = 0;
        flags = title != null ? (flags | 1) : (flags & ~1);
        flags = iconEmojiId != null ? (flags | 2) : (flags & ~2);
        flags = closed != null ? (flags | 4) : (flags & ~4);
        flags = hidden != null ? (flags | 8) : (flags & ~8);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (title == null) throwNullFieldException("title", flags);
            writeString(title, stream);
        }
        if ((flags & 2) != 0) {
            if (iconEmojiId == null) throwNullFieldException("iconEmojiId", flags);
            writeLong(iconEmojiId, stream);
        }
        if ((flags & 4) != 0) {
            writeBoolean(closed, stream);
        }
        if ((flags & 8) != 0) {
            writeBoolean(hidden, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        title = (flags & 1) != 0 ? readTLString(stream) : null;
        iconEmojiId = (flags & 2) != 0 ? readLong(stream) : null;
        closed = (flags & 4) != 0 ? readTLBool(stream) : false;
        hidden = (flags & 8) != 0 ? readTLBool(stream) : false;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (title == null) throwNullFieldException("title", flags);
            size += computeTLStringSerializedSize(title);
        }
        if ((flags & 2) != 0) {
            if (iconEmojiId == null) throwNullFieldException("iconEmojiId", flags);
            size += SIZE_INT64;
        }
        if ((flags & 4) != 0) {
            size += SIZE_BOOLEAN;
        }
        if ((flags & 8) != 0) {
            size += SIZE_BOOLEAN;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getIconEmojiId() {
        return iconEmojiId;
    }

    public void setIconEmojiId(Long iconEmojiId) {
        this.iconEmojiId = iconEmojiId;
    }

    public boolean getClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public boolean getHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
