package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLDraftMessage extends TLAbsDraftMessage {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected boolean noWebpage;

    protected boolean invertMedia;

    protected TLAbsInputReplyTo replyTo;

    protected String message;

    protected TLVector<TLAbsMessageEntity> entities;

    protected TLAbsInputMedia media;

    protected int date;

    protected Long effect;

    private final String _constructor = "draftMessage#0";

    public TLDraftMessage() {
    }

    public TLDraftMessage(boolean noWebpage, boolean invertMedia, TLAbsInputReplyTo replyTo, String message, TLVector<TLAbsMessageEntity> entities, TLAbsInputMedia media, int date, Long effect) {
        this.noWebpage = noWebpage;
        this.invertMedia = invertMedia;
        this.replyTo = replyTo;
        this.message = message;
        this.entities = entities;
        this.media = media;
        this.date = date;
        this.effect = effect;
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
        writeString(message, stream);
        if ((flags & 8) != 0) {
            if (entities == null) throwNullFieldException("entities", flags);
            writeTLVector(entities, stream);
        }
        if ((flags & 32) != 0) {
            if (media == null) throwNullFieldException("media", flags);
            writeTLObject(media, stream);
        }
        writeInt(date, stream);
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
        message = readTLString(stream);
        entities = (flags & 8) != 0 ? readTLVector(stream, context) : null;
        media = (flags & 32) != 0 ? readTLObject(stream, context, TLAbsInputMedia.class, -1) : null;
        date = readInt(stream);
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
        size += computeTLStringSerializedSize(message);
        if ((flags & 8) != 0) {
            if (entities == null) throwNullFieldException("entities", flags);
            size += entities.computeSerializedSize();
        }
        if ((flags & 32) != 0) {
            if (media == null) throwNullFieldException("media", flags);
            size += media.computeSerializedSize();
        }
        size += SIZE_INT32;
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

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public Long getEffect() {
        return effect;
    }

    public void setEffect(Long effect) {
        this.effect = effect;
    }

    @Override
    public final boolean isEmpty() {
        return false;
    }

    @Override
    public final boolean isNotEmpty() {
        return true;
    }

    @Override
    public final TLDraftMessage getAsDraftMessage() {
        return this;
    }
}
