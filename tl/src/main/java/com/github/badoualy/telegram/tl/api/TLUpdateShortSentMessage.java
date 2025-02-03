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
public class TLUpdateShortSentMessage extends TLAbsUpdates {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean out;

    protected int id;

    protected int pts;

    protected int ptsCount;

    protected int date;

    protected TLAbsMessageMedia media;

    protected TLVector<TLAbsMessageEntity> entities;

    protected Integer ttlPeriod;

    private final String _constructor = "updateShortSentMessage#0";

    public TLUpdateShortSentMessage() {
    }

    public TLUpdateShortSentMessage(boolean out, int id, int pts, int ptsCount, int date, TLAbsMessageMedia media, TLVector<TLAbsMessageEntity> entities, Integer ttlPeriod) {
        this.out = out;
        this.id = id;
        this.pts = pts;
        this.ptsCount = ptsCount;
        this.date = date;
        this.media = media;
        this.entities = entities;
        this.ttlPeriod = ttlPeriod;
    }

    private void computeFlags() {
        flags = 0;
        flags = out ? (flags | 2) : (flags & ~2);
        flags = media != null ? (flags | 512) : (flags & ~512);
        flags = entities != null ? (flags | 128) : (flags & ~128);
        flags = ttlPeriod != null ? (flags | 33554432) : (flags & ~33554432);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(id, stream);
        writeInt(pts, stream);
        writeInt(ptsCount, stream);
        writeInt(date, stream);
        if ((flags & 512) != 0) {
            if (media == null) throwNullFieldException("media", flags);
            writeTLObject(media, stream);
        }
        if ((flags & 128) != 0) {
            if (entities == null) throwNullFieldException("entities", flags);
            writeTLVector(entities, stream);
        }
        if ((flags & 33554432) != 0) {
            if (ttlPeriod == null) throwNullFieldException("ttlPeriod", flags);
            writeInt(ttlPeriod, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        out = (flags & 2) != 0;
        id = readInt(stream);
        pts = readInt(stream);
        ptsCount = readInt(stream);
        date = readInt(stream);
        media = (flags & 512) != 0 ? readTLObject(stream, context, TLAbsMessageMedia.class, -1) : null;
        entities = (flags & 128) != 0 ? readTLVector(stream, context) : null;
        ttlPeriod = (flags & 33554432) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 512) != 0) {
            if (media == null) throwNullFieldException("media", flags);
            size += media.computeSerializedSize();
        }
        if ((flags & 128) != 0) {
            if (entities == null) throwNullFieldException("entities", flags);
            size += entities.computeSerializedSize();
        }
        if ((flags & 33554432) != 0) {
            if (ttlPeriod == null) throwNullFieldException("ttlPeriod", flags);
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

    public boolean getOut() {
        return out;
    }

    public void setOut(boolean out) {
        this.out = out;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getPtsCount() {
        return ptsCount;
    }

    public void setPtsCount(int ptsCount) {
        this.ptsCount = ptsCount;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public TLAbsMessageMedia getMedia() {
        return media;
    }

    public void setMedia(TLAbsMessageMedia media) {
        this.media = media;
    }

    public TLVector<TLAbsMessageEntity> getEntities() {
        return entities;
    }

    public void setEntities(TLVector<TLAbsMessageEntity> entities) {
        this.entities = entities;
    }

    public Integer getTtlPeriod() {
        return ttlPeriod;
    }

    public void setTtlPeriod(Integer ttlPeriod) {
        this.ttlPeriod = ttlPeriod;
    }
}
