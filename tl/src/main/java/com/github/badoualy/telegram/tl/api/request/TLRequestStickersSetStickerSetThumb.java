package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputDocument;
import com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet;
import com.github.badoualy.telegram.tl.api.messages.TLAbsStickerSet;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLRequestStickersSetStickerSetThumb extends TLMethod<TLAbsStickerSet> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLAbsInputStickerSet stickerset;

    protected TLAbsInputDocument thumb;

    protected Long thumbDocumentId;

    private final String _constructor = "stickers.setStickerSetThumb#0";

    public TLRequestStickersSetStickerSetThumb() {
    }

    public TLRequestStickersSetStickerSetThumb(TLAbsInputStickerSet stickerset, TLAbsInputDocument thumb, Long thumbDocumentId) {
        this.stickerset = stickerset;
        this.thumb = thumb;
        this.thumbDocumentId = thumbDocumentId;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsStickerSet deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsStickerSet)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsStickerSet) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = thumb != null ? (flags | 1) : (flags & ~1);
        flags = thumbDocumentId != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(stickerset, stream);
        if ((flags & 1) != 0) {
            if (thumb == null) throwNullFieldException("thumb", flags);
            writeTLObject(thumb, stream);
        }
        if ((flags & 2) != 0) {
            if (thumbDocumentId == null) throwNullFieldException("thumbDocumentId", flags);
            writeLong(thumbDocumentId, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        stickerset = readTLObject(stream, context, TLAbsInputStickerSet.class, -1);
        thumb = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsInputDocument.class, -1) : null;
        thumbDocumentId = (flags & 2) != 0 ? readLong(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += stickerset.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (thumb == null) throwNullFieldException("thumb", flags);
            size += thumb.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (thumbDocumentId == null) throwNullFieldException("thumbDocumentId", flags);
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

    public TLAbsInputStickerSet getStickerset() {
        return stickerset;
    }

    public void setStickerset(TLAbsInputStickerSet stickerset) {
        this.stickerset = stickerset;
    }

    public TLAbsInputDocument getThumb() {
        return thumb;
    }

    public void setThumb(TLAbsInputDocument thumb) {
        this.thumb = thumb;
    }

    public Long getThumbDocumentId() {
        return thumbDocumentId;
    }

    public void setThumbDocumentId(Long thumbDocumentId) {
        this.thumbDocumentId = thumbDocumentId;
    }
}
