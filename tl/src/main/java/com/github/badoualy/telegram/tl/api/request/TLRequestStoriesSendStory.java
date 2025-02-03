package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputMedia;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsInputPrivacyRule;
import com.github.badoualy.telegram.tl.api.TLAbsMediaArea;
import com.github.badoualy.telegram.tl.api.TLAbsMessageEntity;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
import com.github.badoualy.telegram.tl.core.TLMethod;
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
public class TLRequestStoriesSendStory extends TLMethod<TLAbsUpdates> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean pinned;

    protected boolean noforwards;

    protected boolean fwdModified;

    protected TLAbsInputPeer peer;

    protected TLAbsInputMedia media;

    protected TLVector<TLAbsMediaArea> mediaAreas;

    protected String caption;

    protected TLVector<TLAbsMessageEntity> entities;

    protected TLVector<TLAbsInputPrivacyRule> privacyRules;

    protected long randomId;

    protected Integer period;

    protected TLAbsInputPeer fwdFromId;

    protected Integer fwdFromStory;

    private final String _constructor = "stories.sendStory#0";

    public TLRequestStoriesSendStory() {
    }

    public TLRequestStoriesSendStory(boolean pinned, boolean noforwards, boolean fwdModified, TLAbsInputPeer peer, TLAbsInputMedia media, TLVector<TLAbsMediaArea> mediaAreas, String caption, TLVector<TLAbsMessageEntity> entities, TLVector<TLAbsInputPrivacyRule> privacyRules, long randomId, Integer period, TLAbsInputPeer fwdFromId, Integer fwdFromStory) {
        this.pinned = pinned;
        this.noforwards = noforwards;
        this.fwdModified = fwdModified;
        this.peer = peer;
        this.media = media;
        this.mediaAreas = mediaAreas;
        this.caption = caption;
        this.entities = entities;
        this.privacyRules = privacyRules;
        this.randomId = randomId;
        this.period = period;
        this.fwdFromId = fwdFromId;
        this.fwdFromStory = fwdFromStory;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsUpdates deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsUpdates)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsUpdates) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = pinned ? (flags | 4) : (flags & ~4);
        flags = noforwards ? (flags | 16) : (flags & ~16);
        flags = fwdModified ? (flags | 128) : (flags & ~128);
        flags = mediaAreas != null ? (flags | 32) : (flags & ~32);
        flags = caption != null ? (flags | 1) : (flags & ~1);
        flags = entities != null ? (flags | 2) : (flags & ~2);
        flags = period != null ? (flags | 8) : (flags & ~8);
        flags = fwdFromId != null ? (flags | 64) : (flags & ~64);
        flags = fwdFromStory != null ? (flags | 64) : (flags & ~64);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peer, stream);
        writeTLObject(media, stream);
        if ((flags & 32) != 0) {
            if (mediaAreas == null) throwNullFieldException("mediaAreas", flags);
            writeTLVector(mediaAreas, stream);
        }
        if ((flags & 1) != 0) {
            if (caption == null) throwNullFieldException("caption", flags);
            writeString(caption, stream);
        }
        if ((flags & 2) != 0) {
            if (entities == null) throwNullFieldException("entities", flags);
            writeTLVector(entities, stream);
        }
        writeTLVector(privacyRules, stream);
        writeLong(randomId, stream);
        if ((flags & 8) != 0) {
            if (period == null) throwNullFieldException("period", flags);
            writeInt(period, stream);
        }
        if ((flags & 64) != 0) {
            if (fwdFromId == null) throwNullFieldException("fwdFromId", flags);
            writeTLObject(fwdFromId, stream);
        }
        if ((flags & 64) != 0) {
            if (fwdFromStory == null) throwNullFieldException("fwdFromStory", flags);
            writeInt(fwdFromStory, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        pinned = (flags & 4) != 0;
        noforwards = (flags & 16) != 0;
        fwdModified = (flags & 128) != 0;
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        media = readTLObject(stream, context, TLAbsInputMedia.class, -1);
        mediaAreas = (flags & 32) != 0 ? readTLVector(stream, context) : null;
        caption = (flags & 1) != 0 ? readTLString(stream) : null;
        entities = (flags & 2) != 0 ? readTLVector(stream, context) : null;
        privacyRules = readTLVector(stream, context);
        randomId = readLong(stream);
        period = (flags & 8) != 0 ? readInt(stream) : null;
        fwdFromId = (flags & 64) != 0 ? readTLObject(stream, context, TLAbsInputPeer.class, -1) : null;
        fwdFromStory = (flags & 64) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        size += media.computeSerializedSize();
        if ((flags & 32) != 0) {
            if (mediaAreas == null) throwNullFieldException("mediaAreas", flags);
            size += mediaAreas.computeSerializedSize();
        }
        if ((flags & 1) != 0) {
            if (caption == null) throwNullFieldException("caption", flags);
            size += computeTLStringSerializedSize(caption);
        }
        if ((flags & 2) != 0) {
            if (entities == null) throwNullFieldException("entities", flags);
            size += entities.computeSerializedSize();
        }
        size += privacyRules.computeSerializedSize();
        size += SIZE_INT64;
        if ((flags & 8) != 0) {
            if (period == null) throwNullFieldException("period", flags);
            size += SIZE_INT32;
        }
        if ((flags & 64) != 0) {
            if (fwdFromId == null) throwNullFieldException("fwdFromId", flags);
            size += fwdFromId.computeSerializedSize();
        }
        if ((flags & 64) != 0) {
            if (fwdFromStory == null) throwNullFieldException("fwdFromStory", flags);
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

    public boolean getFwdModified() {
        return fwdModified;
    }

    public void setFwdModified(boolean fwdModified) {
        this.fwdModified = fwdModified;
    }

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public TLAbsInputMedia getMedia() {
        return media;
    }

    public void setMedia(TLAbsInputMedia media) {
        this.media = media;
    }

    public TLVector<TLAbsMediaArea> getMediaAreas() {
        return mediaAreas;
    }

    public void setMediaAreas(TLVector<TLAbsMediaArea> mediaAreas) {
        this.mediaAreas = mediaAreas;
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

    public TLVector<TLAbsInputPrivacyRule> getPrivacyRules() {
        return privacyRules;
    }

    public void setPrivacyRules(TLVector<TLAbsInputPrivacyRule> privacyRules) {
        this.privacyRules = privacyRules;
    }

    public long getRandomId() {
        return randomId;
    }

    public void setRandomId(long randomId) {
        this.randomId = randomId;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public TLAbsInputPeer getFwdFromId() {
        return fwdFromId;
    }

    public void setFwdFromId(TLAbsInputPeer fwdFromId) {
        this.fwdFromId = fwdFromId;
    }

    public Integer getFwdFromStory() {
        return fwdFromStory;
    }

    public void setFwdFromStory(Integer fwdFromStory) {
        this.fwdFromStory = fwdFromStory;
    }
}
