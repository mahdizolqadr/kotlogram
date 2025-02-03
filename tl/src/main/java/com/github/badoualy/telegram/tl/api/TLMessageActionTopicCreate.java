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
public class TLMessageActionTopicCreate extends TLAbsMessageAction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected String title;

    protected int iconColor;

    protected Long iconEmojiId;

    private final String _constructor = "messageActionTopicCreate#0";

    public TLMessageActionTopicCreate() {
    }

    public TLMessageActionTopicCreate(String title, int iconColor, Long iconEmojiId) {
        this.title = title;
        this.iconColor = iconColor;
        this.iconEmojiId = iconEmojiId;
    }

    private void computeFlags() {
        flags = 0;
        flags = iconEmojiId != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(title, stream);
        writeInt(iconColor, stream);
        if ((flags & 1) != 0) {
            if (iconEmojiId == null) throwNullFieldException("iconEmojiId", flags);
            writeLong(iconEmojiId, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        title = readTLString(stream);
        iconColor = readInt(stream);
        iconEmojiId = (flags & 1) != 0 ? readLong(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(title);
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (iconEmojiId == null) throwNullFieldException("iconEmojiId", flags);
            size += SIZE_INT64;
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

    public int getIconColor() {
        return iconColor;
    }

    public void setIconColor(int iconColor) {
        this.iconColor = iconColor;
    }

    public Long getIconEmojiId() {
        return iconEmojiId;
    }

    public void setIconEmojiId(Long iconEmojiId) {
        this.iconEmojiId = iconEmojiId;
    }
}
