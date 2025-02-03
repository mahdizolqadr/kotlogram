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
public class TLMessageExtendedMediaPreview extends TLAbsMessageExtendedMedia {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected Integer w;

    protected Integer h;

    protected TLAbsPhotoSize thumb;

    protected Integer videoDuration;

    private final String _constructor = "messageExtendedMediaPreview#0";

    public TLMessageExtendedMediaPreview() {
    }

    public TLMessageExtendedMediaPreview(Integer w, Integer h, TLAbsPhotoSize thumb, Integer videoDuration) {
        this.w = w;
        this.h = h;
        this.thumb = thumb;
        this.videoDuration = videoDuration;
    }

    private void computeFlags() {
        flags = 0;
        flags = w != null ? (flags | 1) : (flags & ~1);
        flags = h != null ? (flags | 1) : (flags & ~1);
        flags = thumb != null ? (flags | 2) : (flags & ~2);
        flags = videoDuration != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (w == null) throwNullFieldException("w", flags);
            writeInt(w, stream);
        }
        if ((flags & 1) != 0) {
            if (h == null) throwNullFieldException("h", flags);
            writeInt(h, stream);
        }
        if ((flags & 2) != 0) {
            if (thumb == null) throwNullFieldException("thumb", flags);
            writeTLObject(thumb, stream);
        }
        if ((flags & 4) != 0) {
            if (videoDuration == null) throwNullFieldException("videoDuration", flags);
            writeInt(videoDuration, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        w = (flags & 1) != 0 ? readInt(stream) : null;
        h = (flags & 1) != 0 ? readInt(stream) : null;
        thumb = (flags & 2) != 0 ? readTLObject(stream, context, TLAbsPhotoSize.class, -1) : null;
        videoDuration = (flags & 4) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (w == null) throwNullFieldException("w", flags);
            size += SIZE_INT32;
        }
        if ((flags & 1) != 0) {
            if (h == null) throwNullFieldException("h", flags);
            size += SIZE_INT32;
        }
        if ((flags & 2) != 0) {
            if (thumb == null) throwNullFieldException("thumb", flags);
            size += thumb.computeSerializedSize();
        }
        if ((flags & 4) != 0) {
            if (videoDuration == null) throwNullFieldException("videoDuration", flags);
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

    public Integer getW() {
        return w;
    }

    public void setW(Integer w) {
        this.w = w;
    }

    public Integer getH() {
        return h;
    }

    public void setH(Integer h) {
        this.h = h;
    }

    public TLAbsPhotoSize getThumb() {
        return thumb;
    }

    public void setThumb(TLAbsPhotoSize thumb) {
        this.thumb = thumb;
    }

    public Integer getVideoDuration() {
        return videoDuration;
    }

    public void setVideoDuration(Integer videoDuration) {
        this.videoDuration = videoDuration;
    }
}
