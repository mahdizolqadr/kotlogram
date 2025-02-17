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
public class TLInputMediaUploadedDocument extends TLAbsInputMedia {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean nosoundVideo;

    protected boolean forceFile;

    protected boolean spoiler;

    protected TLAbsInputFile file;

    protected TLAbsInputFile thumb;

    protected String mimeType;

    protected TLVector<TLAbsDocumentAttribute> attributes;

    protected TLVector<TLAbsInputDocument> stickers;

    protected Integer ttlSeconds;

    private final String _constructor = "inputMediaUploadedDocument#0";

    public TLInputMediaUploadedDocument() {
    }

    public TLInputMediaUploadedDocument(boolean nosoundVideo, boolean forceFile, boolean spoiler, TLAbsInputFile file, TLAbsInputFile thumb, String mimeType, TLVector<TLAbsDocumentAttribute> attributes, TLVector<TLAbsInputDocument> stickers, Integer ttlSeconds) {
        this.nosoundVideo = nosoundVideo;
        this.forceFile = forceFile;
        this.spoiler = spoiler;
        this.file = file;
        this.thumb = thumb;
        this.mimeType = mimeType;
        this.attributes = attributes;
        this.stickers = stickers;
        this.ttlSeconds = ttlSeconds;
    }

    private void computeFlags() {
        flags = 0;
        flags = nosoundVideo ? (flags | 8) : (flags & ~8);
        flags = forceFile ? (flags | 16) : (flags & ~16);
        flags = spoiler ? (flags | 32) : (flags & ~32);
        flags = thumb != null ? (flags | 4) : (flags & ~4);
        flags = stickers != null ? (flags | 1) : (flags & ~1);
        flags = ttlSeconds != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(file, stream);
        if ((flags & 4) != 0) {
            if (thumb == null) throwNullFieldException("thumb", flags);
            writeTLObject(thumb, stream);
        }
        writeString(mimeType, stream);
        writeTLVector(attributes, stream);
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
        nosoundVideo = (flags & 8) != 0;
        forceFile = (flags & 16) != 0;
        spoiler = (flags & 32) != 0;
        file = readTLObject(stream, context, TLAbsInputFile.class, -1);
        thumb = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsInputFile.class, -1) : null;
        mimeType = readTLString(stream);
        attributes = readTLVector(stream, context);
        stickers = (flags & 1) != 0 ? readTLVector(stream, context) : null;
        ttlSeconds = (flags & 2) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += file.computeSerializedSize();
        if ((flags & 4) != 0) {
            if (thumb == null) throwNullFieldException("thumb", flags);
            size += thumb.computeSerializedSize();
        }
        size += computeTLStringSerializedSize(mimeType);
        size += attributes.computeSerializedSize();
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

    public boolean getNosoundVideo() {
        return nosoundVideo;
    }

    public void setNosoundVideo(boolean nosoundVideo) {
        this.nosoundVideo = nosoundVideo;
    }

    public boolean getForceFile() {
        return forceFile;
    }

    public void setForceFile(boolean forceFile) {
        this.forceFile = forceFile;
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

    public TLAbsInputFile getThumb() {
        return thumb;
    }

    public void setThumb(TLAbsInputFile thumb) {
        this.thumb = thumb;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public TLVector<TLAbsDocumentAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(TLVector<TLAbsDocumentAttribute> attributes) {
        this.attributes = attributes;
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
