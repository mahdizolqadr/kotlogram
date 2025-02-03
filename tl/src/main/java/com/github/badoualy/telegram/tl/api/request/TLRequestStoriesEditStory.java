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
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestStoriesEditStory extends TLMethod<TLAbsUpdates> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLAbsInputPeer peer;

    protected int id;

    protected TLAbsInputMedia media;

    protected TLVector<TLAbsMediaArea> mediaAreas;

    protected String caption;

    protected TLVector<TLAbsMessageEntity> entities;

    protected TLVector<TLAbsInputPrivacyRule> privacyRules;

    private final String _constructor = "stories.editStory#0";

    public TLRequestStoriesEditStory() {
    }

    public TLRequestStoriesEditStory(TLAbsInputPeer peer, int id, TLAbsInputMedia media, TLVector<TLAbsMediaArea> mediaAreas, String caption, TLVector<TLAbsMessageEntity> entities, TLVector<TLAbsInputPrivacyRule> privacyRules) {
        this.peer = peer;
        this.id = id;
        this.media = media;
        this.mediaAreas = mediaAreas;
        this.caption = caption;
        this.entities = entities;
        this.privacyRules = privacyRules;
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
        flags = media != null ? (flags | 1) : (flags & ~1);
        flags = mediaAreas != null ? (flags | 8) : (flags & ~8);
        flags = caption != null ? (flags | 2) : (flags & ~2);
        flags = entities != null ? (flags | 2) : (flags & ~2);
        flags = privacyRules != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peer, stream);
        writeInt(id, stream);
        if ((flags & 1) != 0) {
            if (media == null) throwNullFieldException("media", flags);
            writeTLObject(media, stream);
        }
        if ((flags & 8) != 0) {
            if (mediaAreas == null) throwNullFieldException("mediaAreas", flags);
            writeTLVector(mediaAreas, stream);
        }
        if ((flags & 2) != 0) {
            if (caption == null) throwNullFieldException("caption", flags);
            writeString(caption, stream);
        }
        if ((flags & 2) != 0) {
            if (entities == null) throwNullFieldException("entities", flags);
            writeTLVector(entities, stream);
        }
        if ((flags & 4) != 0) {
            if (privacyRules == null) throwNullFieldException("privacyRules", flags);
            writeTLVector(privacyRules, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        id = readInt(stream);
        media = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsInputMedia.class, -1) : null;
        mediaAreas = (flags & 8) != 0 ? readTLVector(stream, context) : null;
        caption = (flags & 2) != 0 ? readTLString(stream) : null;
        entities = (flags & 2) != 0 ? readTLVector(stream, context) : null;
        privacyRules = (flags & 4) != 0 ? readTLVector(stream, context) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (media == null) throwNullFieldException("media", flags);
            size += media.computeSerializedSize();
        }
        if ((flags & 8) != 0) {
            if (mediaAreas == null) throwNullFieldException("mediaAreas", flags);
            size += mediaAreas.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (caption == null) throwNullFieldException("caption", flags);
            size += computeTLStringSerializedSize(caption);
        }
        if ((flags & 2) != 0) {
            if (entities == null) throwNullFieldException("entities", flags);
            size += entities.computeSerializedSize();
        }
        if ((flags & 4) != 0) {
            if (privacyRules == null) throwNullFieldException("privacyRules", flags);
            size += privacyRules.computeSerializedSize();
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

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
