package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLVector;
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
public class TLDocument extends TLAbsDocument {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected long accessHash;

    protected TLBytes fileReference;

    protected int date;

    protected String mimeType;

    protected long size;

    protected TLVector<TLAbsPhotoSize> thumbs;

    protected TLVector<TLAbsVideoSize> videoThumbs;

    protected int dcId;

    protected TLVector<TLAbsDocumentAttribute> attributes;

    private final String _constructor = "document#0";

    public TLDocument() {
    }

    public TLDocument(long id, long accessHash, TLBytes fileReference, int date, String mimeType, long size, TLVector<TLAbsPhotoSize> thumbs, TLVector<TLAbsVideoSize> videoThumbs, int dcId, TLVector<TLAbsDocumentAttribute> attributes) {
        this.id = id;
        this.accessHash = accessHash;
        this.fileReference = fileReference;
        this.date = date;
        this.mimeType = mimeType;
        this.size = size;
        this.thumbs = thumbs;
        this.videoThumbs = videoThumbs;
        this.dcId = dcId;
        this.attributes = attributes;
    }

    private void computeFlags() {
        flags = 0;
        flags = thumbs != null ? (flags | 1) : (flags & ~1);
        flags = videoThumbs != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(id, stream);
        writeLong(accessHash, stream);
        writeTLBytes(fileReference, stream);
        writeInt(date, stream);
        writeString(mimeType, stream);
        writeLong(size, stream);
        if ((flags & 1) != 0) {
            if (thumbs == null) throwNullFieldException("thumbs", flags);
            writeTLVector(thumbs, stream);
        }
        if ((flags & 2) != 0) {
            if (videoThumbs == null) throwNullFieldException("videoThumbs", flags);
            writeTLVector(videoThumbs, stream);
        }
        writeInt(dcId, stream);
        writeTLVector(attributes, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        id = readLong(stream);
        accessHash = readLong(stream);
        fileReference = readTLBytes(stream, context);
        date = readInt(stream);
        mimeType = readTLString(stream);
        size = readLong(stream);
        thumbs = (flags & 1) != 0 ? readTLVector(stream, context) : null;
        videoThumbs = (flags & 2) != 0 ? readTLVector(stream, context) : null;
        dcId = readInt(stream);
        attributes = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += computeTLBytesSerializedSize(fileReference);
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(mimeType);
        size += SIZE_INT64;
        if ((flags & 1) != 0) {
            if (thumbs == null) throwNullFieldException("thumbs", flags);
            size += thumbs.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (videoThumbs == null) throwNullFieldException("videoThumbs", flags);
            size += videoThumbs.computeSerializedSize();
        }
        size += SIZE_INT32;
        size += attributes.computeSerializedSize();
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long accessHash) {
        this.accessHash = accessHash;
    }

    public TLBytes getFileReference() {
        return fileReference;
    }

    public void setFileReference(TLBytes fileReference) {
        this.fileReference = fileReference;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public TLVector<TLAbsPhotoSize> getThumbs() {
        return thumbs;
    }

    public void setThumbs(TLVector<TLAbsPhotoSize> thumbs) {
        this.thumbs = thumbs;
    }

    public TLVector<TLAbsVideoSize> getVideoThumbs() {
        return videoThumbs;
    }

    public void setVideoThumbs(TLVector<TLAbsVideoSize> videoThumbs) {
        this.videoThumbs = videoThumbs;
    }

    public int getDcId() {
        return dcId;
    }

    public void setDcId(int dcId) {
        this.dcId = dcId;
    }

    public TLVector<TLAbsDocumentAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(TLVector<TLAbsDocumentAttribute> attributes) {
        this.attributes = attributes;
    }

    @Override
    public final boolean isEmpty() {
        return false;
    }

    @Override
    public final boolean isNotEmpty() {
        return true;
    }

    @Override
    public final TLDocument getAsDocument() {
        return this;
    }
}
