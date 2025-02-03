package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;
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
public class TLInputMediaUploadedPhoto extends TLAbsInputMedia {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean spoiler;

    protected TLAbsInputFile file;

    protected TLVector<TLAbsInputDocument> stickers;

    protected Integer ttlSeconds;

    private final String _constructor = "inputMediaUploadedPhoto#0";

    public TLInputMediaUploadedPhoto() {
    }

    public TLInputMediaUploadedPhoto(boolean spoiler, TLAbsInputFile file, TLVector<TLAbsInputDocument> stickers, Integer ttlSeconds) {
        this.spoiler = spoiler;
        this.file = file;
        this.stickers = stickers;
        this.ttlSeconds = ttlSeconds;
    }

    private void computeFlags() {
        flags = 0;
        flags = spoiler ? (flags | 4) : (flags & ~4);
        flags = stickers != null ? (flags | 1) : (flags & ~1);
        flags = ttlSeconds != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(file, stream);
        if ((flags & 1) != 0) {
            if (stickers == null) throwNullFieldException("stickers", flags);
            writeTLVector(stickers, stream);
        }
        if ((flags & 2) != 0) {
            if (ttlSeconds == null) throwNullFieldException("ttlSeconds", flags);
            writeInt(ttlSeconds, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        spoiler = (flags & 4) != 0;
        file = readTLObject(stream, context, TLAbsInputFile.class, -1);
        stickers = (flags & 1) != 0 ? readTLVector(stream, context) : null;
        ttlSeconds = (flags & 2) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += file.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (stickers == null) throwNullFieldException("stickers", flags);
            size += stickers.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
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

    public TLAbsInputFile getFile() {
        return file;
    }

    public void setFile(TLAbsInputFile file) {
        this.file = file;
    }

    public TLVector<TLAbsInputDocument> getStickers() {
        return stickers;
    }

    public void setStickers(TLVector<TLAbsInputDocument> stickers) {
        this.stickers = stickers;
    }

    public Integer getTtlSeconds() {
        return ttlSeconds;
    }

    public void setTtlSeconds(Integer ttlSeconds) {
        this.ttlSeconds = ttlSeconds;
    }
}
