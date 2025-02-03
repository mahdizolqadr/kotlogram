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
public class TLPageRelatedArticle extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected String url;

    protected long webpageId;

    protected String title;

    protected String description;

    protected Long photoId;

    protected String author;

    protected Integer publishedDate;

    private final String _constructor = "pageRelatedArticle#0";

    public TLPageRelatedArticle() {
    }

    public TLPageRelatedArticle(String url, long webpageId, String title, String description, Long photoId, String author, Integer publishedDate) {
        this.url = url;
        this.webpageId = webpageId;
        this.title = title;
        this.description = description;
        this.photoId = photoId;
        this.author = author;
        this.publishedDate = publishedDate;
    }

    private void computeFlags() {
        flags = 0;
        flags = title != null ? (flags | 1) : (flags & ~1);
        flags = description != null ? (flags | 2) : (flags & ~2);
        flags = photoId != null ? (flags | 4) : (flags & ~4);
        flags = author != null ? (flags | 8) : (flags & ~8);
        flags = publishedDate != null ? (flags | 16) : (flags & ~16);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(url, stream);
        writeLong(webpageId, stream);
        if ((flags & 1) != 0) {
            if (title == null) throwNullFieldException("title", flags);
            writeString(title, stream);
        }
        if ((flags & 2) != 0) {
            if (description == null) throwNullFieldException("description", flags);
            writeString(description, stream);
        }
        if ((flags & 4) != 0) {
            if (photoId == null) throwNullFieldException("photoId", flags);
            writeLong(photoId, stream);
        }
        if ((flags & 8) != 0) {
            if (author == null) throwNullFieldException("author", flags);
            writeString(author, stream);
        }
        if ((flags & 16) != 0) {
            if (publishedDate == null) throwNullFieldException("publishedDate", flags);
            writeInt(publishedDate, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        url = readTLString(stream);
        webpageId = readLong(stream);
        title = (flags & 1) != 0 ? readTLString(stream) : null;
        description = (flags & 2) != 0 ? readTLString(stream) : null;
        photoId = (flags & 4) != 0 ? readLong(stream) : null;
        author = (flags & 8) != 0 ? readTLString(stream) : null;
        publishedDate = (flags & 16) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(url);
        size += SIZE_INT64;
        if ((flags & 1) != 0) {
            if (title == null) throwNullFieldException("title", flags);
            size += computeTLStringSerializedSize(title);
        }
        if ((flags & 2) != 0) {
            if (description == null) throwNullFieldException("description", flags);
            size += computeTLStringSerializedSize(description);
        }
        if ((flags & 4) != 0) {
            if (photoId == null) throwNullFieldException("photoId", flags);
            size += SIZE_INT64;
        }
        if ((flags & 8) != 0) {
            if (author == null) throwNullFieldException("author", flags);
            size += computeTLStringSerializedSize(author);
        }
        if ((flags & 16) != 0) {
            if (publishedDate == null) throwNullFieldException("publishedDate", flags);
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getWebpageId() {
        return webpageId;
    }

    public void setWebpageId(long webpageId) {
        this.webpageId = webpageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Integer publishedDate) {
        this.publishedDate = publishedDate;
    }
}
