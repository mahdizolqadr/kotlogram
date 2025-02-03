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
public class TLMessage extends TLAbsMessage {
    public static final int CONSTRUCTOR_ID = 0x0;

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

    protected boolean invertMedia;

    protected int flags2;

    protected boolean offline;

    protected boolean videoProcessingPending;

    protected TLAbsPeer fromId;

    protected Integer fromBoostsApplied;

    protected TLAbsPeer peerId;

    protected TLAbsPeer savedPeerId;

    protected TLMessageFwdHeader fwdFrom;

    protected Long viaBotId;

    protected Long viaBusinessBotId;

    protected TLAbsMessageReplyHeader replyTo;

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

    protected TLMessageReactions reactions;

    protected TLVector<TLRestrictionReason> restrictionReason;

    protected Integer ttlPeriod;

    protected Integer quickReplyShortcutId;

    protected Long effect;

    protected TLFactCheck factcheck;

    private final String _constructor = "message#0";

    public TLMessage() {
    }

    public TLMessage(boolean out, boolean mentioned, boolean mediaUnread, boolean silent, boolean post, boolean fromScheduled, boolean legacy, boolean editHide, boolean pinned, boolean noforwards, boolean invertMedia, boolean offline, boolean videoProcessingPending, int id, TLAbsPeer fromId, Integer fromBoostsApplied, TLAbsPeer peerId, TLAbsPeer savedPeerId, TLMessageFwdHeader fwdFrom, Long viaBotId, Long viaBusinessBotId, TLAbsMessageReplyHeader replyTo, int date, String message, TLAbsMessageMedia media, TLAbsReplyMarkup replyMarkup, TLVector<TLAbsMessageEntity> entities, Integer views, Integer forwards, TLMessageReplies replies, Integer editDate, String postAuthor, Long groupedId, TLMessageReactions reactions, TLVector<TLRestrictionReason> restrictionReason, Integer ttlPeriod, Integer quickReplyShortcutId, Long effect, TLFactCheck factcheck) {
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
        this.invertMedia = invertMedia;
        this.offline = offline;
        this.videoProcessingPending = videoProcessingPending;
        this.id = id;
        this.fromId = fromId;
        this.fromBoostsApplied = fromBoostsApplied;
        this.peerId = peerId;
        this.savedPeerId = savedPeerId;
        this.fwdFrom = fwdFrom;
        this.viaBotId = viaBotId;
        this.viaBusinessBotId = viaBusinessBotId;
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
        this.reactions = reactions;
        this.restrictionReason = restrictionReason;
        this.ttlPeriod = ttlPeriod;
        this.quickReplyShortcutId = quickReplyShortcutId;
        this.effect = effect;
        this.factcheck = factcheck;
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
        flags = invertMedia ? (flags | 134217728) : (flags & ~134217728);
        flags = fromId != null ? (flags | 256) : (flags & ~256);
        flags = fromBoostsApplied != null ? (flags | 536870912) : (flags & ~536870912);
        flags = savedPeerId != null ? (flags | 268435456) : (flags & ~268435456);
        flags = fwdFrom != null ? (flags | 4) : (flags & ~4);
        flags = viaBotId != null ? (flags | 2048) : (flags & ~2048);
        flags = replyTo != null ? (flags | 8) : (flags & ~8);
        flags = media != null ? (flags | 512) : (flags & ~512);
        flags = replyMarkup != null ? (flags | 64) : (flags & ~64);
        flags = entities != null ? (flags | 128) : (flags & ~128);
        flags = views != null ? (flags | 1024) : (flags & ~1024);
        flags = forwards != null ? (flags | 1024) : (flags & ~1024);
        flags = replies != null ? (flags | 8388608) : (flags & ~8388608);
        flags = editDate != null ? (flags | 32768) : (flags & ~32768);
        flags = postAuthor != null ? (flags | 65536) : (flags & ~65536);
        flags = groupedId != null ? (flags | 131072) : (flags & ~131072);
        flags = reactions != null ? (flags | 1048576) : (flags & ~1048576);
        flags = restrictionReason != null ? (flags | 4194304) : (flags & ~4194304);
        flags = ttlPeriod != null ? (flags | 33554432) : (flags & ~33554432);
        flags = quickReplyShortcutId != null ? (flags | 1073741824) : (flags & ~1073741824);

        // Following parameters might be forced to true by another field that updated the flags
        out = (flags & 2) != 0;
        mentioned = (flags & 16) != 0;
    }

    private void computeFlags2() {
        flags2 = 0;
        flags2 = offline ? (flags2 | 2) : (flags2 & ~2);
        flags2 = videoProcessingPending ? (flags2 | 16) : (flags2 & ~16);
        flags2 = viaBusinessBotId != null ? (flags | 1) : (flags2 & ~1);
        flags2 = effect != null ? (flags | 4) : (flags2 & ~4);
        flags2 = factcheck != null ? (flags | 8) : (flags2 & ~8);

        // Following parameters might be forced to true by another field that updated the flags
        offline = (flags2 & 2) != 0;
        videoProcessingPending = (flags2 & 16) != 0;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        computeFlags2();

        writeInt(flags, stream);
        writeInt(flags2, stream);
        writeInt(id, stream);
        if ((flags & 256) != 0) {
            if (fromId == null) throwNullFieldException("fromId", flags);
            writeTLObject(fromId, stream);
        }
        if ((flags & 536870912) != 0) {
            if (fromBoostsApplied == null) throwNullFieldException("fromBoostsApplied", flags);
            writeInt(fromBoostsApplied, stream);
        }
        writeTLObject(peerId, stream);
        if ((flags & 268435456) != 0) {
            if (savedPeerId == null) throwNullFieldException("savedPeerId", flags);
            writeTLObject(savedPeerId, stream);
        }
        if ((flags & 4) != 0) {
            if (fwdFrom == null) throwNullFieldException("fwdFrom", flags);
            writeTLObject(fwdFrom, stream);
        }
        if ((flags & 2048) != 0) {
            if (viaBotId == null) throwNullFieldException("viaBotId", flags);
            writeLong(viaBotId, stream);
        }
        if ((flags2 & 1) != 0) {
            if (viaBusinessBotId == null) throwNullFieldException("viaBusinessBotId", flags2);
            writeLong(viaBusinessBotId, stream);
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
            if (views == null) throwNullFieldException("views", flags);
            writeInt(views, stream);
        }
        if ((flags & 1024) != 0) {
            if (forwards == null) throwNullFieldException("forwards", flags);
            writeInt(forwards, stream);
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
        if ((flags & 1048576) != 0) {
            if (reactions == null) throwNullFieldException("reactions", flags);
            writeTLObject(reactions, stream);
        }
        if ((flags & 4194304) != 0) {
            if (restrictionReason == null) throwNullFieldException("restrictionReason", flags);
            writeTLVector(restrictionReason, stream);
        }
        if ((flags & 33554432) != 0) {
            if (ttlPeriod == null) throwNullFieldException("ttlPeriod", flags);
            writeInt(ttlPeriod, stream);
        }
        if ((flags & 1073741824) != 0) {
            if (quickReplyShortcutId == null) throwNullFieldException("quickReplyShortcutId", flags);
            writeInt(quickReplyShortcutId, stream);
        }
        if ((flags2 & 4) != 0) {
            if (effect == null) throwNullFieldException("effect", flags2);
            writeLong(effect, stream);
        }
        if ((flags2 & 8) != 0) {
            if (factcheck == null) throwNullFieldException("factcheck", flags2);
            writeTLObject(factcheck, stream);
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
        post = (flags & 16384) != 0;
        fromScheduled = (flags & 262144) != 0;
        legacy = (flags & 524288) != 0;
        editHide = (flags & 2097152) != 0;
        pinned = (flags & 16777216) != 0;
        noforwards = (flags & 67108864) != 0;
        invertMedia = (flags & 134217728) != 0;
        flags2 = readInt(stream);
        offline = (flags2 & 2) != 0;
        videoProcessingPending = (flags2 & 16) != 0;
        id = readInt(stream);
        fromId = (flags & 256) != 0 ? readTLObject(stream, context, TLAbsPeer.class, -1) : null;
        fromBoostsApplied = (flags & 536870912) != 0 ? readInt(stream) : null;
        peerId = readTLObject(stream, context, TLAbsPeer.class, -1);
        savedPeerId = (flags & 268435456) != 0 ? readTLObject(stream, context, TLAbsPeer.class, -1) : null;
        fwdFrom = (flags & 4) != 0 ? readTLObject(stream, context, TLMessageFwdHeader.class, TLMessageFwdHeader.CONSTRUCTOR_ID) : null;
        viaBotId = (flags & 2048) != 0 ? readLong(stream) : null;
        viaBusinessBotId = (flags2 & 1) != 0 ? readLong(stream) : null;
        replyTo = (flags & 8) != 0 ? readTLObject(stream, context, TLAbsMessageReplyHeader.class, -1) : null;
        date = readInt(stream);
        message = readTLString(stream);
        media = (flags & 512) != 0 ? readTLObject(stream, context, TLAbsMessageMedia.class, -1) : null;
        replyMarkup = (flags & 64) != 0 ? readTLObject(stream, context, TLAbsReplyMarkup.class, -1) : null;
        entities = (flags & 128) != 0 ? readTLVector(stream, context) : null;
        views = (flags & 1024) != 0 ? readInt(stream) : null;
        forwards = (flags & 1024) != 0 ? readInt(stream) : null;
        replies = (flags & 8388608) != 0 ? readTLObject(stream, context, TLMessageReplies.class, TLMessageReplies.CONSTRUCTOR_ID) : null;
        editDate = (flags & 32768) != 0 ? readInt(stream) : null;
        postAuthor = (flags & 65536) != 0 ? readTLString(stream) : null;
        groupedId = (flags & 131072) != 0 ? readLong(stream) : null;
        reactions = (flags & 1048576) != 0 ? readTLObject(stream, context, TLMessageReactions.class, TLMessageReactions.CONSTRUCTOR_ID) : null;
        restrictionReason = (flags & 4194304) != 0 ? readTLVector(stream, context) : null;
        ttlPeriod = (flags & 33554432) != 0 ? readInt(stream) : null;
        quickReplyShortcutId = (flags & 1073741824) != 0 ? readInt(stream) : null;
        effect = (flags2 & 4) != 0 ? readLong(stream) : null;
        factcheck = (flags2 & 8) != 0 ? readTLObject(stream, context, TLFactCheck.class, TLFactCheck.CONSTRUCTOR_ID) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        computeFlags2();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 256) != 0) {
            if (fromId == null) throwNullFieldException("fromId", flags);
            size += fromId.computeSerializedSize();
        }
        if ((flags & 536870912) != 0) {
            if (fromBoostsApplied == null) throwNullFieldException("fromBoostsApplied", flags);
            size += SIZE_INT32;
        }
        size += peerId.computeSerializedSize();
        if ((flags & 268435456) != 0) {
            if (savedPeerId == null) throwNullFieldException("savedPeerId", flags);
            size += savedPeerId.computeSerializedSize();
        }
        if ((flags & 4) != 0) {
            if (fwdFrom == null) throwNullFieldException("fwdFrom", flags);
            size += fwdFrom.computeSerializedSize();
        }
        if ((flags & 2048) != 0) {
            if (viaBotId == null) throwNullFieldException("viaBotId", flags);
            size += SIZE_INT64;
        }
        if ((flags2 & 1) != 0) {
            if (viaBusinessBotId == null) throwNullFieldException("viaBusinessBotId", flags2);
            size += SIZE_INT64;
        }
        if ((flags & 8) != 0) {
            if (replyTo == null) throwNullFieldException("replyTo", flags);
            size += replyTo.computeSerializedSize();
        }
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(message);
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
            if (views == null) throwNullFieldException("views", flags);
            size += SIZE_INT32;
        }
        if ((flags & 1024) != 0) {
            if (forwards == null) throwNullFieldException("forwards", flags);
            size += SIZE_INT32;
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
            size += computeTLStringSerializedSize(postAuthor);
        }
        if ((flags & 131072) != 0) {
            if (groupedId == null) throwNullFieldException("groupedId", flags);
            size += SIZE_INT64;
        }
        if ((flags & 1048576) != 0) {
            if (reactions == null) throwNullFieldException("reactions", flags);
            size += reactions.computeSerializedSize();
        }
        if ((flags & 4194304) != 0) {
            if (restrictionReason == null) throwNullFieldException("restrictionReason", flags);
            size += restrictionReason.computeSerializedSize();
        }
        if ((flags & 33554432) != 0) {
            if (ttlPeriod == null) throwNullFieldException("ttlPeriod", flags);
            size += SIZE_INT32;
        }
        if ((flags & 1073741824) != 0) {
            if (quickReplyShortcutId == null) throwNullFieldException("quickReplyShortcutId", flags);
            size += SIZE_INT32;
        }
        if ((flags2 & 4) != 0) {
            if (effect == null) throwNullFieldException("effect", flags2);
            size += SIZE_INT64;
        }
        if ((flags2 & 8) != 0) {
            if (factcheck == null) throwNullFieldException("factcheck", flags2);
            size += factcheck.computeSerializedSize();
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

    public boolean getPost() {
        return post;
    }

    public void setPost(boolean post) {
        this.post = post;
    }

    public boolean getFromScheduled() {
        return fromScheduled;
    }

    public void setFromScheduled(boolean fromScheduled) {
        this.fromScheduled = fromScheduled;
    }

    public boolean getLegacy() {
        return legacy;
    }

    public void setLegacy(boolean legacy) {
        this.legacy = legacy;
    }

    public boolean getEditHide() {
        return editHide;
    }

    public void setEditHide(boolean editHide) {
        this.editHide = editHide;
    }

    public boolean getPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }

    public boolean getNoforwards() {
        return noforwards;
    }

    public void setNoforwards(boolean noforwards) {
        this.noforwards = noforwards;
    }

    public boolean getInvertMedia() {
        return invertMedia;
    }

    public void setInvertMedia(boolean invertMedia) {
        this.invertMedia = invertMedia;
    }

    public boolean getOffline() {
        return offline;
    }

    public void setOffline(boolean offline) {
        this.offline = offline;
    }

    public boolean getVideoProcessingPending() {
        return videoProcessingPending;
    }

    public void setVideoProcessingPending(boolean videoProcessingPending) {
        this.videoProcessingPending = videoProcessingPending;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TLAbsPeer getFromId() {
        return fromId;
    }

    public void setFromId(TLAbsPeer fromId) {
        this.fromId = fromId;
    }

    public Integer getFromBoostsApplied() {
        return fromBoostsApplied;
    }

    public void setFromBoostsApplied(Integer fromBoostsApplied) {
        this.fromBoostsApplied = fromBoostsApplied;
    }

    public TLAbsPeer getPeerId() {
        return peerId;
    }

    public void setPeerId(TLAbsPeer peerId) {
        this.peerId = peerId;
    }

    public TLAbsPeer getSavedPeerId() {
        return savedPeerId;
    }

    public void setSavedPeerId(TLAbsPeer savedPeerId) {
        this.savedPeerId = savedPeerId;
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

    public Long getViaBusinessBotId() {
        return viaBusinessBotId;
    }

    public void setViaBusinessBotId(Long viaBusinessBotId) {
        this.viaBusinessBotId = viaBusinessBotId;
    }

    public TLAbsMessageReplyHeader getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(TLAbsMessageReplyHeader replyTo) {
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

    public TLMessageReactions getReactions() {
        return reactions;
    }

    public void setReactions(TLMessageReactions reactions) {
        this.reactions = reactions;
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

    public Integer getQuickReplyShortcutId() {
        return quickReplyShortcutId;
    }

    public void setQuickReplyShortcutId(Integer quickReplyShortcutId) {
        this.quickReplyShortcutId = quickReplyShortcutId;
    }

    public Long getEffect() {
        return effect;
    }

    public void setEffect(Long effect) {
        this.effect = effect;
    }

    public TLFactCheck getFactcheck() {
        return factcheck;
    }

    public void setFactcheck(TLFactCheck factcheck) {
        this.factcheck = factcheck;
    }
}
