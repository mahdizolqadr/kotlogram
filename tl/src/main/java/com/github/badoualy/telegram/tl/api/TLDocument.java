package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLDocument extends TLAbsDocument {

    public static final int CONSTRUCTOR_ID = 0x1e87342b;

    protected int flags;

    protected long accessHash;

    protected TLBytes fileReference;

    protected int date;

    protected String mimeType;

    protected int size;

    protected TLVector<TLAbsPhotoSize> thumbs;

    protected TLVector<TLVideoSize> videoThumbs;

    protected int dcId;

    protected TLVector<TLAbsDocumentAttribute> attributes;

    private final String _constructor = "document#1e87342b";

    public TLDocument() {
    }

    public TLDocument(long id, long accessHash, TLBytes fileReference, int date, String mimeType,
                      int size, TLVector<TLAbsPhotoSize> thumbs, TLVector<TLVideoSize> videoThumbs,
                      int dcId, TLVector<TLAbsDocumentAttribute> attributes) {
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
        writeInt(size, stream);
        if ((flags & 1) != 0) {
            if (thumbs == null) {
                throwNullFieldException("thumbs", flags);
            }
            writeTLVector(thumbs, stream);
        }
        if ((flags & 2) != 0) {
            if (videoThumbs == null) {
                throwNullFieldException("videoThumbs", flags);
            }
            writeTLVector(videoThumbs, stream);
        }
        writeInt(dcId, stream);
        writeTLVector(attributes, stream);
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        id = readLong(stream);
        accessHash = readLong(stream);
        fileReference = readTLBytes(stream, context);
        date = readInt(stream);
        mimeType = readTLString(stream);
        size = readInt(stream);
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
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (thumbs == null) {
                throwNullFieldException("thumbs", flags);
            }
            size += thumbs.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (videoThumbs == null) {
                throwNullFieldException("videoThumbs", flags);
            }
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public TLVector<TLAbsPhotoSize> getThumbs() {
        return thumbs;
    }

    public void setThumbs(TLVector<TLAbsPhotoSize> thumbs) {
        this.thumbs = thumbs;
    }

    public TLVector<TLVideoSize> getVideoThumbs() {
        return videoThumbs;
    }

    public void setVideoThumbs(TLVector<TLVideoSize> videoThumbs) {
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
