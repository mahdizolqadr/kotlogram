package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMessage extends TLAbsMessage {

    public static final int CONSTRUCTOR_ID = 0x85d6cbe2;

    protected int flags;

    protected boolean out;

    protected boolean mentioned;

    protected boolean mediaUnread;

    protected boolean silent;

    protected boolean post;

    protected boolean fromScheduled;

    protected boolean legacy;

    protected boolean editHide;

    protected boolean pinned;

    protected boolean noforwards;

    protected TLAbsPeer fromId;

    protected TLAbsPeer peerId;

    protected TLMessageFwdHeader fwdFrom;

    protected Long viaBotId;

    protected TLMessageReplyHeader replyTo;

    protected int date;

    protected String message;

    protected TLAbsMessageMedia media;

    protected TLAbsReplyMarkup replyMarkup;

    protected TLVector<TLAbsMessageEntity> entities;

    protected Integer views;

    protected Integer forwards;

    protected TLMessageReplies replies;

    protected Integer editDate;

    protected String postAuthor;

    protected Long groupedId;

    protected TLVector<TLRestrictionReason> restrictionReason;

    protected Integer ttlPeriod;

    private final String _constructor = "message#85d6cbe2";

    public TLMessage() {
    }

    public TLMessage(boolean out, boolean mentioned, boolean mediaUnread, boolean silent,
                     boolean post, boolean fromScheduled, boolean legacy, boolean editHide,
                     boolean pinned, boolean noforwards, TLAbsPeer fromId, TLAbsPeer peerId, TLMessageFwdHeader fwdFrom,
                     Long viaBotId, TLMessageReplyHeader replyTo, int date, String message,
                     TLAbsMessageMedia media, TLAbsReplyMarkup replyMarkup,
                     TLVector<TLAbsMessageEntity> entities, Integer views,
                     Integer forwards, TLMessageReplies replies, Integer editDate,
                     String postAuthor, Long groupedId, TLVector<TLRestrictionReason> restrictionReason,
                     Integer ttlPeriod) {
        this.out = out;
        this.mentioned = mentioned;
        this.mediaUnread = mediaUnread;
        this.silent = silent;
        this.post = post;
        this.fromScheduled = fromScheduled;
        this.legacy = legacy;
        this.editHide = editHide;
        this.pinned = pinned;
        this.noforwards = noforwards;
        this.fromId = fromId;
        this.peerId = peerId;
        this.fwdFrom = fwdFrom;
        this.viaBotId = viaBotId;
        this.replyTo = replyTo;
        this.date = date;
        this.message = message;
        this.media = media;
        this.replyMarkup = replyMarkup;
        this.entities = entities;
        this.views = views;
        this.forwards = forwards;
        this.replies = replies;
        this.editDate = editDate;
        this.postAuthor = postAuthor;
        this.groupedId = groupedId;
        this.restrictionReason = restrictionReason;
        this.ttlPeriod = ttlPeriod;
    }

    private void computeFlags() {
        flags = 0;
        flags = out ? (flags | 2) : (flags & ~2);
        flags = mentioned ? (flags | 16) : (flags & ~16);
        flags = mediaUnread ? (flags | 32) : (flags & ~32);
        flags = silent ? (flags | 8192) : (flags & ~8192);
        flags = post ? (flags | 16384) : (flags & ~16384);
        flags = fromScheduled ? (flags | 262144) : (flags & ~262144);
        flags = legacy ? (flags | 524288) : (flags & ~524288);
        flags = editHide ? (flags | 2097152) : (flags & ~2097152);
        flags = pinned ? (flags | 16777216) : (flags & ~16777216);
        flags = noforwards ? (flags | 67108864) : (flags & ~67108864);
        flags = fromId != null ? (flags | 256) : (flags & ~256);
        flags = fwdFrom != null ? (flags | 4) : (flags & ~4);
        flags = viaBotId != null ? (flags | 2048) : (flags & ~2048);
        flags = replyTo != null ? (flags | 8) : (flags & ~8);
        flags = media != null ? (flags | 512) : (flags & ~512);
        flags = replyMarkup != null ? (flags | 64) : (flags & ~64);
        flags = entities != null ? (flags | 128) : (flags & ~128);
        flags = views != null || forwards != null ? (flags | 1024) : (flags & ~1024);
        flags = replies != null ? (flags | 8388608) : (flags & ~8388608);
        flags = editDate != null ? (flags | 32768) : (flags & ~32768);
        flags = postAuthor != null ? (flags | 65536) : (flags & ~65536);
        flags = groupedId != null ? (flags | 131072) : (flags & ~131072);
        flags = restrictionReason != null ? (flags | 4194304) : (flags & ~4194304);
        flags = ttlPeriod != null ? (flags | 33554432) : (flags & ~33554432);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();
        writeInt(flags, stream);
        writeInt(id, stream);
        if ((flags & 256) != 0) {
            if (fromId == null) throwNullFieldException("fromId", flags);
            writeTLObject(fromId, stream);
        }
        writeTLObject(peerId, stream);
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
        writeInt(date, stream);
        writeString(message, stream);
        if ((flags & 512) != 0) {
            if (media == null) throwNullFieldException("media", flags);
            writeTLObject(media, stream);
        }
        if ((flags & 64) != 0) {
            if (replyMarkup == null) throwNullFieldException("replyMarkup", flags);
            writeTLObject(replyMarkup, stream);
        }
        if ((flags & 128) != 0) {
            if (entities == null) throwNullFieldException("entities", flags);
            writeTLVector(entities, stream);
        }
        if ((flags & 1024) != 0) {
            if (views != null) {
                writeInt(views, stream);
            }
            if (forwards != null) {
                writeInt(forwards, stream);
            }
        }
        if ((flags & 8388608) != 0) {
            if (replies == null) throwNullFieldException("replies", flags);
            writeTLObject(replies, stream);
        }
        if ((flags & 32768) != 0) {
            if (editDate == null) throwNullFieldException("editDate", flags);
            writeInt(editDate, stream);
        }
        if ((flags & 65536) != 0) {
            if (postAuthor == null) throwNullFieldException("postAuthor", flags);
            writeString(postAuthor, stream);
        }
        if ((flags & 131072) != 0) {
            if (groupedId == null) throwNullFieldException("groupedId", flags);
            writeLong(groupedId, stream);
        }
        if ((flags & 4194304) != 0) {
            if (restrictionReason == null) throwNullFieldException("restrictionReason", flags);
            writeTLVector(restrictionReason, stream);
        }
        if ((flags & 33554432) != 0) {
            if (ttlPeriod == null) throwNullFieldException("ttlPeriod", flags);
            writeInt(ttlPeriod, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        out = (flags & 2) != 0;
        mentioned = (flags & 16) != 0;
        mediaUnread = (flags & 32) != 0;
        silent = (flags & 8192) != 0;
        post = (flags & 16384) != 0;
        fromScheduled = (flags & 262144) != 0;
        legacy = (flags & 524288) != 0;
        editHide = (flags & 2097152) != 0;
        pinned = (flags & 16777216) != 0;
        noforwards = (flags & 67108864) != 0;
        id = readInt(stream);
        fromId = (flags & 256) != 0 ? readTLObject(stream, context, TLAbsPeer.class, -1) : null;
        peerId = readTLObject(stream, context, TLAbsPeer.class, -1);
        fwdFrom = (flags & 4) != 0 ? readTLObject(stream, context, TLMessageFwdHeader.class,
                TLMessageFwdHeader.CONSTRUCTOR_ID) : null;
        viaBotId = (flags & 2048) != 0 ? readLong(stream) : null;
        replyTo = (flags & 8) != 0 ? readTLObject(stream, context, TLMessageReplyHeader.class, -1) : null;
        date = readInt(stream);
        message = readTLString(stream);
        media = (flags & 512) != 0 ? readTLObject(stream, context, TLAbsMessageMedia.class, -1) : null;
        replyMarkup = (flags & 64) != 0 ? readTLObject(stream, context, TLAbsReplyMarkup.class, -1) : null;
        entities = (flags & 128) != 0 ? readTLVector(stream, context) : null;
        views = (flags & 1024) != 0 ? readInt(stream) : null;
        forwards = (flags & 1024) != 0 ? readInt(stream) : null;
        replies = (flags & 8388608) != 0 ? readTLObject(stream, context, TLMessageReplies.class, -1) : null;
        editDate = (flags & 32768) != 0 ? readInt(stream) : null;
        postAuthor = (flags & 65536) != 0 ? readTLString(stream) : null;
        groupedId = (flags & 131072) != 0 ? readLong(stream) : null;
        restrictionReason = (flags & 4194304) != 0 ? readTLVector(stream, context) : null;
        ttlPeriod = (flags & 33554432) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 256) != 0) {
            if (fromId == null) throwNullFieldException("fromId", flags);
            size += fromId.computeSerializedSize();
        }
        size += peerId.computeSerializedSize();
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
        size += SIZE_INT32;
        computeTLStringSerializedSize(message);
        if ((flags & 512) != 0) {
            if (media == null) throwNullFieldException("media", flags);
            size += media.computeSerializedSize();
        }
        if ((flags & 64) != 0) {
            if (replyMarkup == null) throwNullFieldException("replyMarkup", flags);
            size += replyMarkup.computeSerializedSize();
        }
        if ((flags & 128) != 0) {
            if (entities == null) throwNullFieldException("entities", flags);
            size += entities.computeSerializedSize();
        }
        if ((flags & 1024) != 0) {
            if (views != null) {
                size += SIZE_INT32;
            }
            if (forwards != null) {
                size += SIZE_INT32;
            }
        }
        if ((flags & 8388608) != 0) {
            if (replies == null) throwNullFieldException("replies", flags);
            size += replies.computeSerializedSize();
        }
        if ((flags & 32768) != 0) {
            if (editDate == null) throwNullFieldException("editDate", flags);
            size += SIZE_INT32;
        }
        if ((flags & 65536) != 0) {
            if (postAuthor == null) throwNullFieldException("postAuthor", flags);
            computeTLStringSerializedSize(postAuthor);
        }
        if ((flags & 131072) != 0) {
            if (groupedId == null) throwNullFieldException("groupedId", flags);
            size += SIZE_INT64;
        }
        if ((flags & 4194304) != 0) {
            if (restrictionReason == null) throwNullFieldException("restrictionReason", flags);
            size += restrictionReason.computeSerializedSize();
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

    public boolean isOut() {
        return out;
    }

    public void setOut(boolean out) {
        this.out = out;
    }

    public boolean isMentioned() {
        return mentioned;
    }

    public void setMentioned(boolean mentioned) {
        this.mentioned = mentioned;
    }

    public boolean isMediaUnread() {
        return mediaUnread;
    }

    public void setMediaUnread(boolean mediaUnread) {
        this.mediaUnread = mediaUnread;
    }

    public boolean isSilent() {
        return silent;
    }

    public void setSilent(boolean silent) {
        this.silent = silent;
    }

    public boolean isPost() {
        return post;
    }

    public void setPost(boolean post) {
        this.post = post;
    }

    public boolean isFromScheduled() {
        return fromScheduled;
    }

    public void setFromScheduled(boolean fromScheduled) {
        this.fromScheduled = fromScheduled;
    }

    public boolean isLegacy() {
        return legacy;
    }

    public void setLegacy(boolean legacy) {
        this.legacy = legacy;
    }

    public boolean isEditHide() {
        return editHide;
    }

    public void setEditHide(boolean editHide) {
        this.editHide = editHide;
    }

    public boolean isPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }

    public boolean isNoforwards() {
        return noforwards;
    }

    public void setNoforwards(boolean noforwards) {
        this.noforwards = noforwards;
    }

    public TLAbsPeer getFromId() {
        return fromId;
    }

    public void setFromId(TLAbsPeer fromId) {
        this.fromId = fromId;
    }

    public TLAbsPeer getPeerId() {
        return peerId;
    }

    public void setPeerId(TLAbsPeer peerId) {
        this.peerId = peerId;
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

    public TLMessageReplyHeader getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(TLMessageReplyHeader replyTo) {
        this.replyTo = replyTo;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TLAbsMessageMedia getMedia() {
        return media;
    }

    public void setMedia(TLAbsMessageMedia media) {
        this.media = media;
    }

    public TLAbsReplyMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public void setReplyMarkup(TLAbsReplyMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
    }

    public TLVector<TLAbsMessageEntity> getEntities() {
        return entities;
    }

    public void setEntities(TLVector<TLAbsMessageEntity> entities) {
        this.entities = entities;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getForwards() {
        return forwards;
    }

    public void setForwards(Integer forwards) {
        this.forwards = forwards;
    }

    public TLMessageReplies getReplies() {
        return replies;
    }

    public void setReplies(TLMessageReplies replies) {
        this.replies = replies;
    }

    public Integer getEditDate() {
        return editDate;
    }

    public void setEditDate(Integer editDate) {
        this.editDate = editDate;
    }

    public String getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(String postAuthor) {
        this.postAuthor = postAuthor;
    }

    public Long getGroupedId() {
        return groupedId;
    }

    public void setGroupedId(Long groupedId) {
        this.groupedId = groupedId;
    }

    public TLVector<TLRestrictionReason> getRestrictionReason() {
        return restrictionReason;
    }

    public void setRestrictionReason(TLVector<TLRestrictionReason> restrictionReason) {
        this.restrictionReason = restrictionReason;
    }

    public Integer getTtlPeriod() {
        return ttlPeriod;
    }

    public void setTtlPeriod(Integer ttlPeriod) {
        this.ttlPeriod = ttlPeriod;
    }
}
