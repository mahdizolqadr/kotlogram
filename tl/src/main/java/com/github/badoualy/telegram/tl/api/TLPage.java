package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLPage extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean part;

    protected boolean rtl;

    protected boolean v2;

    protected String url;

    protected TLVector<TLAbsPageBlock> blocks;

    protected TLVector<TLAbsPhoto> photos;

    protected TLVector<TLAbsDocument> documents;

    protected Integer views;

    private final String _constructor = "page#0";

    public TLPage() {
    }

    public TLPage(boolean part, boolean rtl, boolean v2, String url, TLVector<TLAbsPageBlock> blocks, TLVector<TLAbsPhoto> photos, TLVector<TLAbsDocument> documents, Integer views) {
        this.part = part;
        this.rtl = rtl;
        this.v2 = v2;
        this.url = url;
        this.blocks = blocks;
        this.photos = photos;
        this.documents = documents;
        this.views = views;
    }

    private void computeFlags() {
        flags = 0;
        flags = part ? (flags | 1) : (flags & ~1);
        flags = rtl ? (flags | 2) : (flags & ~2);
        flags = v2 ? (flags | 4) : (flags & ~4);
        flags = views != null ? (flags | 8) : (flags & ~8);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(url, stream);
        writeTLVector(blocks, stream);
        writeTLVector(photos, stream);
        writeTLVector(documents, stream);
        if ((flags & 8) != 0) {
            if (views == null) throwNullFieldException("views", flags);
            writeInt(views, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        part = (flags & 1) != 0;
        rtl = (flags & 2) != 0;
        v2 = (flags & 4) != 0;
        url = readTLString(stream);
        blocks = readTLVector(stream, context);
        photos = readTLVector(stream, context);
        documents = readTLVector(stream, context);
        views = (flags & 8) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(url);
        size += blocks.computeSerializedSize();
        size += photos.computeSerializedSize();
        size += documents.computeSerializedSize();
        if ((flags & 8) != 0) {
            if (views == null) throwNullFieldException("views", flags);
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

    public boolean getPart() {
        return part;
    }

    public void setPart(boolean part) {
        this.part = part;
    }

    public boolean getRtl() {
        return rtl;
    }

    public void setRtl(boolean rtl) {
        this.rtl = rtl;
    }

    public boolean getV2() {
        return v2;
    }

    public void setV2(boolean v2) {
        this.v2 = v2;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TLVector<TLAbsPageBlock> getBlocks() {
        return blocks;
    }

    public void setBlocks(TLVector<TLAbsPageBlock> blocks) {
        this.blocks = blocks;
    }

    public TLVector<TLAbsPhoto> getPhotos() {
        return photos;
    }

    public void setPhotos(TLVector<TLAbsPhoto> photos) {
        this.photos = photos;
    }

    public TLVector<TLAbsDocument> getDocuments() {
        return documents;
    }

    public void setDocuments(TLVector<TLAbsDocument> documents) {
        this.documents = documents;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }
}
