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
public class TLPageBlockPhoto extends TLAbsPageBlock {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected long photoId;

    protected TLPageCaption caption;

    protected String url;

    protected Long webpageId;

    private final String _constructor = "pageBlockPhoto#0";

    public TLPageBlockPhoto() {
    }

    public TLPageBlockPhoto(long photoId, TLPageCaption caption, String url, Long webpageId) {
        this.photoId = photoId;
        this.caption = caption;
        this.url = url;
        this.webpageId = webpageId;
    }

    private void computeFlags() {
        flags = 0;
        flags = url != null ? (flags | 1) : (flags & ~1);
        flags = webpageId != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(photoId, stream);
        writeTLObject(caption, stream);
        if ((flags & 1) != 0) {
            if (url == null) throwNullFieldException("url", flags);
            writeString(url, stream);
        }
        if ((flags & 1) != 0) {
            if (webpageId == null) throwNullFieldException("webpageId", flags);
            writeLong(webpageId, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        photoId = readLong(stream);
        caption = readTLObject(stream, context, TLPageCaption.class, TLPageCaption.CONSTRUCTOR_ID);
        url = (flags & 1) != 0 ? readTLString(stream) : null;
        webpageId = (flags & 1) != 0 ? readLong(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += caption.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (url == null) throwNullFieldException("url", flags);
            size += computeTLStringSerializedSize(url);
        }
        if ((flags & 1) != 0) {
            if (webpageId == null) throwNullFieldException("webpageId", flags);
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

    public long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(long photoId) {
        this.photoId = photoId;
    }

    public TLPageCaption getCaption() {
        return caption;
    }

    public void setCaption(TLPageCaption caption) {
        this.caption = caption;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getWebpageId() {
        return webpageId;
    }

    public void setWebpageId(Long webpageId) {
        this.webpageId = webpageId;
    }
}
