package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLMessageMediaPhoto extends TLAbsMessageMedia {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean spoiler;

    protected TLAbsPhoto photo;

    protected Integer ttlSeconds;

    private final String _constructor = "messageMediaPhoto#0";

    public TLMessageMediaPhoto() {
    }

    public TLMessageMediaPhoto(boolean spoiler, TLAbsPhoto photo, Integer ttlSeconds) {
        this.spoiler = spoiler;
        this.photo = photo;
        this.ttlSeconds = ttlSeconds;
    }

    private void computeFlags() {
        flags = 0;
        flags = spoiler ? (flags | 8) : (flags & ~8);
        flags = photo != null ? (flags | 1) : (flags & ~1);
        flags = ttlSeconds != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (photo == null) throwNullFieldException("photo", flags);
            writeTLObject(photo, stream);
        }
        if ((flags & 4) != 0) {
            if (ttlSeconds == null) throwNullFieldException("ttlSeconds", flags);
            writeInt(ttlSeconds, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        spoiler = (flags & 8) != 0;
        photo = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsPhoto.class, -1) : null;
        ttlSeconds = (flags & 4) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (photo == null) throwNullFieldException("photo", flags);
            size += photo.computeSerializedSize();
        }
        if ((flags & 4) != 0) {
            if (ttlSeconds == null) throwNullFieldException("ttlSeconds", flags);
            size += SIZE_INT32;
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

    public boolean getSpoiler() {
        return spoiler;
    }

    public void setSpoiler(boolean spoiler) {
        this.spoiler = spoiler;
    }

    public TLAbsPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(TLAbsPhoto photo) {
        this.photo = photo;
    }

    public Integer getTtlSeconds() {
        return ttlSeconds;
    }

    public void setTtlSeconds(Integer ttlSeconds) {
        this.ttlSeconds = ttlSeconds;
    }
}
