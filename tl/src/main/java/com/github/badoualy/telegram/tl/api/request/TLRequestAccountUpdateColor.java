package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLMethod;
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
public class TLRequestAccountUpdateColor extends TLMethod<TLBool> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean forProfile;

    protected Integer color;

    protected Long backgroundEmojiId;

    private final String _constructor = "account.updateColor#0";

    public TLRequestAccountUpdateColor() {
    }

    public TLRequestAccountUpdateColor(boolean forProfile, Integer color, Long backgroundEmojiId) {
        this.forProfile = forProfile;
        this.color = color;
        this.backgroundEmojiId = backgroundEmojiId;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLBool)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLBool) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = forProfile ? (flags | 2) : (flags & ~2);
        flags = color != null ? (flags | 4) : (flags & ~4);
        flags = backgroundEmojiId != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 4) != 0) {
            if (color == null) throwNullFieldException("color", flags);
            writeInt(color, stream);
        }
        if ((flags & 1) != 0) {
            if (backgroundEmojiId == null) throwNullFieldException("backgroundEmojiId", flags);
            writeLong(backgroundEmojiId, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        forProfile = (flags & 2) != 0;
        color = (flags & 4) != 0 ? readInt(stream) : null;
        backgroundEmojiId = (flags & 1) != 0 ? readLong(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 4) != 0) {
            if (color == null) throwNullFieldException("color", flags);
            size += SIZE_INT32;
        }
        if ((flags & 1) != 0) {
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

    public boolean getForProfile() {
        return forProfile;
    }

    public void setForProfile(boolean forProfile) {
        this.forProfile = forProfile;
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
