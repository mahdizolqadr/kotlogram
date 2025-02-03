package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLStoryItem extends TLAbsStoryItem {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean pinned;

    protected boolean _public;

    protected boolean closeFriends;

    protected boolean min;

    protected boolean noforwards;

    protected boolean edited;

    protected boolean contacts;

    protected boolean selectedContacts;

    protected boolean out;

    protected int date;

    protected TLAbsPeer fromId;

    protected TLStoryFwdHeader fwdFrom;

    protected int expireDate;

    protected String caption;

    protected TLVector<TLAbsMessageEntity> entities;

    protected TLAbsMessageMedia media;

    protected TLVector<TLAbsMediaArea> mediaAreas;

    protected TLVector<TLAbsPrivacyRule> privacy;

    protected TLStoryViews views;

    protected TLAbsReaction sentReaction;

    private final String _constructor = "storyItem#0";

    public TLStoryItem() {
    }

    public TLStoryItem(boolean pinned, boolean _public, boolean closeFriends, boolean min, boolean noforwards, boolean edited, boolean contacts, boolean selectedContacts, boolean out, int id, int date, TLAbsPeer fromId, TLStoryFwdHeader fwdFrom, int expireDate, String caption, TLVector<TLAbsMessageEntity> entities, TLAbsMessageMedia media, TLVector<TLAbsMediaArea> mediaAreas, TLVector<TLAbsPrivacyRule> privacy, TLStoryViews views, TLAbsReaction sentReaction) {
        this.pinned = pinned;
        this._public = _public;
        this.closeFriends = closeFriends;
        this.min = min;
        this.noforwards = noforwards;
        this.edited = edited;
        this.contacts = contacts;
        this.selectedContacts = selectedContacts;
        this.out = out;
        this.id = id;
        this.date = date;
        this.fromId = fromId;
        this.fwdFrom = fwdFrom;
        this.expireDate = expireDate;
        this.caption = caption;
        this.entities = entities;
        this.media = media;
        this.mediaAreas = mediaAreas;
        this.privacy = privacy;
        this.views = views;
        this.sentReaction = sentReaction;
    }

    private void computeFlags() {
        flags = 0;
        flags = pinned ? (flags | 32) : (flags & ~32);
        flags = _public ? (flags | 128) : (flags & ~128);
        flags = closeFriends ? (flags | 256) : (flags & ~256);
        flags = min ? (flags | 512) : (flags & ~512);
        flags = noforwards ? (flags | 1024) : (flags & ~1024);
        flags = edited ? (flags | 2048) : (flags & ~2048);
        flags = contacts ? (flags | 4096) : (flags & ~4096);
        flags = selectedContacts ? (flags | 8192) : (flags & ~8192);
        flags = out ? (flags | 65536) : (flags & ~65536);
        flags = fromId != null ? (flags | 262144) : (flags & ~262144);
        flags = fwdFrom != null ? (flags | 131072) : (flags & ~131072);
        flags = caption != null ? (flags | 1) : (flags & ~1);
        flags = entities != null ? (flags | 2) : (flags & ~2);
        flags = mediaAreas != null ? (flags | 16384) : (flags & ~16384);
        flags = privacy != null ? (flags | 4) : (flags & ~4);
        flags = views != null ? (flags | 8) : (flags & ~8);
        flags = sentReaction != null ? (flags | 32768) : (flags & ~32768);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(id, stream);
        writeInt(date, stream);
        if ((flags & 262144) != 0) {
            if (fromId == null) throwNullFieldException("fromId", flags);
            writeTLObject(fromId, stream);
        }
        if ((flags & 131072) != 0) {
            if (fwdFrom == null) throwNullFieldException("fwdFrom", flags);
            writeTLObject(fwdFrom, stream);
        }
        writeInt(expireDate, stream);
        if ((flags & 1) != 0) {
            if (caption == null) throwNullFieldException("caption", flags);
            writeString(caption, stream);
        }
        if ((flags & 2) != 0) {
            if (entities == null) throwNullFieldException("entities", flags);
            writeTLVector(entities, stream);
        }
        writeTLObject(media, stream);
        if ((flags & 16384) != 0) {
            if (mediaAreas == null) throwNullFieldException("mediaAreas", flags);
            writeTLVector(mediaAreas, stream);
        }
        if ((flags & 4) != 0) {
            if (privacy == null) throwNullFieldException("privacy", flags);
            writeTLVector(privacy, stream);
        }
        if ((flags & 8) != 0) {
            if (views == null) throwNullFieldException("views", flags);
            writeTLObject(views, stream);
        }
        if ((flags & 32768) != 0) {
            if (sentReaction == null) throwNullFieldException("sentReaction", flags);
            writeTLObject(sentReaction, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        pinned = (flags & 32) != 0;
        _public = (flags & 128) != 0;
        closeFriends = (flags & 256) != 0;
        min = (flags & 512) != 0;
        noforwards = (flags & 1024) != 0;
        edited = (flags & 2048) != 0;
        contacts = (flags & 4096) != 0;
        selectedContacts = (flags & 8192) != 0;
        out = (flags & 65536) != 0;
        id = readInt(stream);
        date = readInt(stream);
        fromId = (flags & 262144) != 0 ? readTLObject(stream, context, TLAbsPeer.class, -1) : null;
        fwdFrom = (flags & 131072) != 0 ? readTLObject(stream, context, TLStoryFwdHeader.class, TLStoryFwdHeader.CONSTRUCTOR_ID) : null;
        expireDate = readInt(stream);
        caption = (flags & 1) != 0 ? readTLString(stream) : null;
        entities = (flags & 2) != 0 ? readTLVector(stream, context) : null;
        media = readTLObject(stream, context, TLAbsMessageMedia.class, -1);
        mediaAreas = (flags & 16384) != 0 ? readTLVector(stream, context) : null;
        privacy = (flags & 4) != 0 ? readTLVector(stream, context) : null;
        views = (flags & 8) != 0 ? readTLObject(stream, context, TLStoryViews.class, TLStoryViews.CONSTRUCTOR_ID) : null;
        sentReaction = (flags & 32768) != 0 ? readTLObject(stream, context, TLAbsReaction.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 262144) != 0) {
            if (fromId == null) throwNullFieldException("fromId", flags);
            size += fromId.computeSerializedSize();
        }
        if ((flags & 131072) != 0) {
            if (fwdFrom == null) throwNullFieldException("fwdFrom", flags);
            size += fwdFrom.computeSerializedSize();
        }
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (caption == null) throwNullFieldException("caption", flags);
            size += computeTLStringSerializedSize(caption);
        }
        if ((flags & 2) != 0) {
            if (entities == null) throwNullFieldException("entities", flags);
            size += entities.computeSerializedSize();
        }
        size += media.computeSerializedSize();
        if ((flags & 16384) != 0) {
            if (mediaAreas == null) throwNullFieldException("mediaAreas", flags);
            size += mediaAreas.computeSerializedSize();
        }
        if ((flags & 4) != 0) {
            if (privacy == null) throwNullFieldException("privacy", flags);
            size += privacy.computeSerializedSize();
        }
        if ((flags & 8) != 0) {
            if (views == null) throwNullFieldException("views", flags);
            size += views.computeSerializedSize();
        }
        if ((flags & 32768) != 0) {
            if (sentReaction == null) throwNullFieldException("sentReaction", flags);
            size += sentReaction.computeSerializedSize();
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

    public boolean getPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }

    public boolean getPublic() {
        return _public;
    }

    public void setPublic(boolean _public) {
        this._public = _public;
    }

    public boolean getCloseFriends() {
        return closeFriends;
    }

    public void setCloseFriends(boolean closeFriends) {
        this.closeFriends = closeFriends;
    }

    public boolean getMin() {
        return min;
    }

    public void setMin(boolean min) {
        this.min = min;
    }

    public boolean getNoforwards() {
        return noforwards;
    }

    public void setNoforwards(boolean noforwards) {
        this.noforwards = noforwards;
    }

    public boolean getEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
    }

    public boolean getContacts() {
        return contacts;
    }

    public void setContacts(boolean contacts) {
        this.contacts = contacts;
    }

    public boolean getSelectedContacts() {
        return selectedContacts;
    }

    public void setSelectedContacts(boolean selectedContacts) {
        this.selectedContacts = selectedContacts;
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

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public TLAbsPeer getFromId() {
        return fromId;
    }

    public void setFromId(TLAbsPeer fromId) {
        this.fromId = fromId;
    }

    public TLStoryFwdHeader getFwdFrom() {
        return fwdFrom;
    }

    public void setFwdFrom(TLStoryFwdHeader fwdFrom) {
        this.fwdFrom = fwdFrom;
    }

    public int getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(int expireDate) {
        this.expireDate = expireDate;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public TLVector<TLAbsMessageEntity> getEntities() {
        return entities;
    }

    public void setEntities(TLVector<TLAbsMessageEntity> entities) {
        this.entities = entities;
    }

    public TLAbsMessageMedia getMedia() {
        return media;
    }

    public void setMedia(TLAbsMessageMedia media) {
        this.media = media;
    }

    public TLVector<TLAbsMediaArea> getMediaAreas() {
        return mediaAreas;
    }

    public void setMediaAreas(TLVector<TLAbsMediaArea> mediaAreas) {
        this.mediaAreas = mediaAreas;
    }

    public TLVector<TLAbsPrivacyRule> getPrivacy() {
        return privacy;
    }

    public void setPrivacy(TLVector<TLAbsPrivacyRule> privacy) {
        this.privacy = privacy;
    }

    public TLStoryViews getViews() {
        return views;
    }

    public void setViews(TLStoryViews views) {
        this.views = views;
    }

    public TLAbsReaction getSentReaction() {
        return sentReaction;
    }

    public void setSentReaction(TLAbsReaction sentReaction) {
        this.sentReaction = sentReaction;
    }
}
