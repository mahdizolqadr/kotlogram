package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPeerColor extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected Integer color;

    protected Long backgroundEmojiId;

    private final String _constructor = "peerColor#0";

    public TLPeerColor() {
    }

    public TLPeerColor(Integer color, Long backgroundEmojiId) {
        this.color = color;
        this.backgroundEmojiId = backgroundEmojiId;
    }

    private void computeFlags() {
        flags = 0;
        flags = color != null ? (flags | 1) : (flags & ~1);
        flags = backgroundEmojiId != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (color == null) throwNullFieldException("color", flags);
            writeInt(color, stream);
        }
        if ((flags & 2) != 0) {
            if (backgroundEmojiId == null) throwNullFieldException("backgroundEmojiId", flags);
            writeLong(backgroundEmojiId, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        color = (flags & 1) != 0 ? readInt(stream) : null;
        backgroundEmojiId = (flags & 2) != 0 ? readLong(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (color == null) throwNullFieldException("color", flags);
            size += SIZE_INT32;
        }
        if ((flags & 2) != 0) {
            if (backgroundEmojiId == null) throwNullFieldException("backgroundEmojiId", flags);
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

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public Long getBackgroundEmojiId() {
        return backgroundEmojiId;
    }

    public void setBackgroundEmojiId(Long backgroundEmojiId) {
        this.backgroundEmojiId = backgroundEmojiId;
    }
}
