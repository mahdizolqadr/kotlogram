package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputMedia;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsInputReplyTo;
import com.github.badoualy.telegram.tl.api.TLAbsMessageEntity;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
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
public class TLRequestMessagesSaveDraft extends TLMethod<TLBool> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean noWebpage;

    protected boolean invertMedia;

    protected TLAbsInputReplyTo replyTo;

    protected TLAbsInputPeer peer;

    protected String message;

    protected TLVector<TLAbsMessageEntity> entities;

    protected TLAbsInputMedia media;

    protected Long effect;

    private final String _constructor = "messages.saveDraft#0";

    public TLRequestMessagesSaveDraft() {
    }

    public TLRequestMessagesSaveDraft(boolean noWebpage, boolean invertMedia, TLAbsInputReplyTo replyTo, TLAbsInputPeer peer, String message, TLVector<TLAbsMessageEntity> entities, TLAbsInputMedia media, Long effect) {
        this.noWebpage = noWebpage;
        this.invertMedia = invertMedia;
        this.replyTo = replyTo;
        this.peer = peer;
        this.message = message;
        this.entities = entities;
        this.media = media;
        this.effect = effect;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLBool)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLBool) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = noWebpage ? (flags | 2) : (flags & ~2);
        flags = invertMedia ? (flags | 64) : (flags & ~64);
        flags = replyTo != null ? (flags | 16) : (flags & ~16);
        flags = entities != null ? (flags | 8) : (flags & ~8);
        flags = media != null ? (flags | 32) : (flags & ~32);
        flags = effect != null ? (flags | 128) : (flags & ~128);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 16) != 0) {
            if (replyTo == null) throwNullFieldException("replyTo", flags);
            writeTLObject(replyTo, stream);
        }
        writeTLObject(peer, stream);
        writeString(message, stream);
        if ((flags & 8) != 0) {
            if (entities == null) throwNullFieldException("entities", flags);
            writeTLVector(entities, stream);
        }
        if ((flags & 32) != 0) {
            if (media == null) throwNullFieldException("media", flags);
            writeTLObject(media, stream);
        }
        if ((flags & 128) != 0) {
            if (effect == null) throwNullFieldException("effect", flags);
            writeLong(effect, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        noWebpage = (flags & 2) != 0;
        invertMedia = (flags & 64) != 0;
        replyTo = (flags & 16) != 0 ? readTLObject(stream, context, TLAbsInputReplyTo.class, -1) : null;
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        message = readTLString(stream);
        entities = (flags & 8) != 0 ? readTLVector(stream, context) : null;
        media = (flags & 32) != 0 ? readTLObject(stream, context, TLAbsInputMedia.class, -1) : null;
        effect = (flags & 128) != 0 ? readLong(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 16) != 0) {
            if (replyTo == null) throwNullFieldException("replyTo", flags);
            size += replyTo.computeSerializedSize();
        }
        size += peer.computeSerializedSize();
        size += computeTLStringSerializedSize(message);
        if ((flags & 8) != 0) {
            if (entities == null) throwNullFieldException("entities", flags);
            size += entities.computeSerializedSize();
        }
        if ((flags & 32) != 0) {
            if (media == null) throwNullFieldException("media", flags);
            size += media.computeSerializedSize();
        }
        if ((flags & 128) != 0) {
            if (effect == null) throwNullFieldException("effect", flags);
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

    public boolean getNoWebpage() {
        return noWebpage;
    }

    public void setNoWebpage(boolean noWebpage) {
        this.noWebpage = noWebpage;
    }

    public boolean getInvertMedia() {
        return invertMedia;
    }

    public void setInvertMedia(boolean invertMedia) {
        this.invertMedia = invertMedia;
    }

    public TLAbsInputReplyTo getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(TLAbsInputReplyTo replyTo) {
        this.replyTo = replyTo;
    }

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TLVector<TLAbsMessageEntity> getEntities() {
        return entities;
    }

    public void setEntities(TLVector<TLAbsMessageEntity> entities) {
        this.entities = entities;
    }

    public TLAbsInputMedia getMedia() {
        return media;
    }

    public void setMedia(TLAbsInputMedia media) {
        this.media = media;
    }

    public Long getEffect() {
        return effect;
    }

    public void setEffect(Long effect) {
        this.effect = effect;
    }
}
