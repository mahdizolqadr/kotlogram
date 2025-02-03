package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;
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
public class TLUpdateShortMessage extends TLAbsUpdates {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean out;

    protected boolean mentioned;

    protected boolean mediaUnread;

    protected boolean silent;

    protected int id;

    protected long userId;

    protected String message;

    protected int pts;

    protected int ptsCount;

    protected int date;

    protected TLMessageFwdHeader fwdFrom;

    protected Long viaBotId;

    protected TLAbsMessageReplyHeader replyTo;

    protected TLVector<TLAbsMessageEntity> entities;

    protected Integer ttlPeriod;

    private final String _constructor = "updateShortMessage#0";

    public TLUpdateShortMessage() {
    }

    public TLUpdateShortMessage(boolean out, boolean mentioned, boolean mediaUnread, boolean silent, int id, long userId, String message, int pts, int ptsCount, int date, TLMessageFwdHeader fwdFrom, Long viaBotId, TLAbsMessageReplyHeader replyTo, TLVector<TLAbsMessageEntity> entities, Integer ttlPeriod) {
        this.out = out;
        this.mentioned = mentioned;
        this.mediaUnread = mediaUnread;
        this.silent = silent;
        this.id = id;
        this.userId = userId;
        this.message = message;
        this.pts = pts;
        this.ptsCount = ptsCount;
        this.date = date;
        this.fwdFrom = fwdFrom;
        this.viaBotId = viaBotId;
        this.replyTo = replyTo;
        this.entities = entities;
        this.ttlPeriod = ttlPeriod;
    }

    private void computeFlags() {
        flags = 0;
        flags = out ? (flags | 2) : (flags & ~2);
        flags = mentioned ? (flags | 16) : (flags & ~16);
        flags = mediaUnread ? (flags | 32) : (flags & ~32);
        flags = silent ? (flags | 8192) : (flags & ~8192);
        flags = fwdFrom != null ? (flags | 4) : (flags & ~4);
        flags = viaBotId != null ? (flags | 2048) : (flags & ~2048);
        flags = replyTo != null ? (flags | 8) : (flags & ~8);
        flags = entities != null ? (flags | 128) : (flags & ~128);
        flags = ttlPeriod != null ? (flags | 33554432) : (flags & ~33554432);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(id, stream);
        writeLong(userId, stream);
        writeString(message, stream);
        writeInt(pts, stream);
        writeInt(ptsCount, stream);
        writeInt(date, stream);
        if ((flags & 4) != 0) {
            if (fwdFrom == null) throwNullFieldException("fwdFrom", flags);
            writeTLObject(fwdFrom, stream);
        }
        if ((flags & 2048) != 0) {
            if (viaBotId == null) throwNullFieldException("viaBotId", flags);
            writeLong(viaBotId, stream);
        }
        if ((flags & 8) != 0) {
            if (replyTo == null) throwNullFieldException("replyTo", flags);
            writeTLObject(replyTo, stream);
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
        mentioned = (flags & 16) != 0;
        mediaUnread = (flags & 32) != 0;
        silent = (flags & 8192) != 0;
        id = readInt(stream);
        userId = readLong(stream);
        message = readTLString(stream);
        pts = readInt(stream);
        ptsCount = readInt(stream);
        date = readInt(stream);
        fwdFrom = (flags & 4) != 0 ? readTLObject(stream, context, TLMessageFwdHeader.class, TLMessageFwdHeader.CONSTRUCTOR_ID) : null;
        viaBotId = (flags & 2048) != 0 ? readLong(stream) : null;
        replyTo = (flags & 8) != 0 ? readTLObject(stream, context, TLAbsMessageReplyHeader.class, -1) : null;
        entities = (flags & 128) != 0 ? readTLVector(stream, context) : null;
        ttlPeriod = (flags & 33554432) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(message);
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 4) != 0) {
            if (fwdFrom == null) throwNullFieldException("fwdFrom", flags);
            size += fwdFrom.computeSerializedSize();
        }
        if ((flags & 2048) != 0) {
            if (viaBotId == null) throwNullFieldException("viaBotId", flags);
            size += SIZE_INT64;
        }
        if ((flags & 8) != 0) {
            if (replyTo == null) throwNullFieldException("replyTo", flags);
            size += replyTo.computeSerializedSize();
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

    public boolean getMentioned() {
        return mentioned;
    }

    public void setMentioned(boolean mentioned) {
        this.mentioned = mentioned;
    }

    public boolean getMediaUnread() {
        return mediaUnread;
    }

    public void setMediaUnread(boolean mediaUnread) {
        this.mediaUnread = mediaUnread;
    }

    public boolean getSilent() {
        return silent;
    }

    public void setSilent(boolean silent) {
        this.silent = silent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public TLMessageFwdHeader getFwdFrom() {
        return fwdFrom;
    }

    public void setFwdFrom(TLMessageFwdHeader fwdFrom) {
        this.fwdFrom = fwdFrom;
    }

    public Long getViaBotId() {
        return viaBotId;
    }

    public void setViaBotId(Long viaBotId) {
        this.viaBotId = viaBotId;
    }

    public TLAbsMessageReplyHeader getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(TLAbsMessageReplyHeader replyTo) {
        this.replyTo = replyTo;
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
