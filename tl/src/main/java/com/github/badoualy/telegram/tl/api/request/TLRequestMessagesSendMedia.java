package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputMedia;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsInputQuickReplyShortcut;
import com.github.badoualy.telegram.tl.api.TLAbsInputReplyTo;
import com.github.badoualy.telegram.tl.api.TLAbsMessageEntity;
import com.github.badoualy.telegram.tl.api.TLAbsReplyMarkup;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLRequestMessagesSendMedia extends TLMethod<TLAbsUpdates> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean silent;

    protected boolean background;

    protected boolean clearDraft;

    protected boolean noforwards;

    protected boolean updateStickersetsOrder;

    protected boolean invertMedia;

    protected boolean allowPaidFloodskip;

    protected TLAbsInputPeer peer;

    protected TLAbsInputReplyTo replyTo;

    protected TLAbsInputMedia media;

    protected String message;

    protected long randomId;

    protected TLAbsReplyMarkup replyMarkup;

    protected TLVector<TLAbsMessageEntity> entities;

    protected Integer scheduleDate;

    protected TLAbsInputPeer sendAs;

    protected TLAbsInputQuickReplyShortcut quickReplyShortcut;

    protected Long effect;

    private final String _constructor = "messages.sendMedia#0";

    public TLRequestMessagesSendMedia() {
    }

    public TLRequestMessagesSendMedia(boolean silent, boolean background, boolean clearDraft, boolean noforwards, boolean updateStickersetsOrder, boolean invertMedia, boolean allowPaidFloodskip, TLAbsInputPeer peer, TLAbsInputReplyTo replyTo, TLAbsInputMedia media, String message, long randomId, TLAbsReplyMarkup replyMarkup, TLVector<TLAbsMessageEntity> entities, Integer scheduleDate, TLAbsInputPeer sendAs, TLAbsInputQuickReplyShortcut quickReplyShortcut, Long effect) {
        this.silent = silent;
        this.background = background;
        this.clearDraft = clearDraft;
        this.noforwards = noforwards;
        this.updateStickersetsOrder = updateStickersetsOrder;
        this.invertMedia = invertMedia;
        this.allowPaidFloodskip = allowPaidFloodskip;
        this.peer = peer;
        this.replyTo = replyTo;
        this.media = media;
        this.message = message;
        this.randomId = randomId;
        this.replyMarkup = replyMarkup;
        this.entities = entities;
        this.scheduleDate = scheduleDate;
        this.sendAs = sendAs;
        this.quickReplyShortcut = quickReplyShortcut;
        this.effect = effect;
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
        flags = silent ? (flags | 32) : (flags & ~32);
        flags = background ? (flags | 64) : (flags & ~64);
        flags = clearDraft ? (flags | 128) : (flags & ~128);
        flags = noforwards ? (flags | 16384) : (flags & ~16384);
        flags = updateStickersetsOrder ? (flags | 32768) : (flags & ~32768);
        flags = invertMedia ? (flags | 65536) : (flags & ~65536);
        flags = allowPaidFloodskip ? (flags | 524288) : (flags & ~524288);
        flags = replyTo != null ? (flags | 1) : (flags & ~1);
        flags = replyMarkup != null ? (flags | 4) : (flags & ~4);
        flags = entities != null ? (flags | 8) : (flags & ~8);
        flags = scheduleDate != null ? (flags | 1024) : (flags & ~1024);
        flags = sendAs != null ? (flags | 8192) : (flags & ~8192);
        flags = quickReplyShortcut != null ? (flags | 131072) : (flags & ~131072);
        flags = effect != null ? (flags | 262144) : (flags & ~262144);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peer, stream);
        if ((flags & 1) != 0) {
            if (replyTo == null) throwNullFieldException("replyTo", flags);
            writeTLObject(replyTo, stream);
        }
        writeTLObject(media, stream);
        writeString(message, stream);
        writeLong(randomId, stream);
        if ((flags & 4) != 0) {
            if (replyMarkup == null) throwNullFieldException("replyMarkup", flags);
            writeTLObject(replyMarkup, stream);
        }
        if ((flags & 8) != 0) {
            if (entities == null) throwNullFieldException("entities", flags);
            writeTLVector(entities, stream);
        }
        if ((flags & 1024) != 0) {
            if (scheduleDate == null) throwNullFieldException("scheduleDate", flags);
            writeInt(scheduleDate, stream);
        }
        if ((flags & 8192) != 0) {
            if (sendAs == null) throwNullFieldException("sendAs", flags);
            writeTLObject(sendAs, stream);
        }
        if ((flags & 131072) != 0) {
            if (quickReplyShortcut == null) throwNullFieldException("quickReplyShortcut", flags);
            writeTLObject(quickReplyShortcut, stream);
        }
        if ((flags & 262144) != 0) {
            if (effect == null) throwNullFieldException("effect", flags);
            writeLong(effect, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        silent = (flags & 32) != 0;
        background = (flags & 64) != 0;
        clearDraft = (flags & 128) != 0;
        noforwards = (flags & 16384) != 0;
        updateStickersetsOrder = (flags & 32768) != 0;
        invertMedia = (flags & 65536) != 0;
        allowPaidFloodskip = (flags & 524288) != 0;
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        replyTo = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsInputReplyTo.class, -1) : null;
        media = readTLObject(stream, context, TLAbsInputMedia.class, -1);
        message = readTLString(stream);
        randomId = readLong(stream);
        replyMarkup = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsReplyMarkup.class, -1) : null;
        entities = (flags & 8) != 0 ? readTLVector(stream, context) : null;
        scheduleDate = (flags & 1024) != 0 ? readInt(stream) : null;
        sendAs = (flags & 8192) != 0 ? readTLObject(stream, context, TLAbsInputPeer.class, -1) : null;
        quickReplyShortcut = (flags & 131072) != 0 ? readTLObject(stream, context, TLAbsInputQuickReplyShortcut.class, -1) : null;
        effect = (flags & 262144) != 0 ? readLong(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (replyTo == null) throwNullFieldException("replyTo", flags);
            size += replyTo.computeSerializedSize();
        }
        size += media.computeSerializedSize();
        size += computeTLStringSerializedSize(message);
        size += SIZE_INT64;
        if ((flags & 4) != 0) {
            if (replyMarkup == null) throwNullFieldException("replyMarkup", flags);
            size += replyMarkup.computeSerializedSize();
        }
        if ((flags & 8) != 0) {
            if (entities == null) throwNullFieldException("entities", flags);
            size += entities.computeSerializedSize();
        }
        if ((flags & 1024) != 0) {
            if (scheduleDate == null) throwNullFieldException("scheduleDate", flags);
            size += SIZE_INT32;
        }
        if ((flags & 8192) != 0) {
            if (sendAs == null) throwNullFieldException("sendAs", flags);
            size += sendAs.computeSerializedSize();
        }
        if ((flags & 131072) != 0) {
            if (quickReplyShortcut == null) throwNullFieldException("quickReplyShortcut", flags);
            size += quickReplyShortcut.computeSerializedSize();
        }
        if ((flags & 262144) != 0) {
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

    public boolean getSilent() {
        return silent;
    }

    public void setSilent(boolean silent) {
        this.silent = silent;
    }

    public boolean getBackground() {
        return background;
    }

    public void setBackground(boolean background) {
        this.background = background;
    }

    public boolean getClearDraft() {
        return clearDraft;
    }

    public void setClearDraft(boolean clearDraft) {
        this.clearDraft = clearDraft;
    }

    public boolean getNoforwards() {
        return noforwards;
    }

    public void setNoforwards(boolean noforwards) {
        this.noforwards = noforwards;
    }

    public boolean getUpdateStickersetsOrder() {
        return updateStickersetsOrder;
    }

    public void setUpdateStickersetsOrder(boolean updateStickersetsOrder) {
        this.updateStickersetsOrder = updateStickersetsOrder;
    }

    public boolean getInvertMedia() {
        return invertMedia;
    }

    public void setInvertMedia(boolean invertMedia) {
        this.invertMedia = invertMedia;
    }

    public boolean getAllowPaidFloodskip() {
        return allowPaidFloodskip;
    }

    public void setAllowPaidFloodskip(boolean allowPaidFloodskip) {
        this.allowPaidFloodskip = allowPaidFloodskip;
    }

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public TLAbsInputReplyTo getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(TLAbsInputReplyTo replyTo) {
        this.replyTo = replyTo;
    }

    public TLAbsInputMedia getMedia() {
        return media;
    }

    public void setMedia(TLAbsInputMedia media) {
        this.media = media;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getRandomId() {
        return randomId;
    }

    public void setRandomId(long randomId) {
        this.randomId = randomId;
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

    public Integer getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Integer scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public TLAbsInputPeer getSendAs() {
        return sendAs;
    }

    public void setSendAs(TLAbsInputPeer sendAs) {
        this.sendAs = sendAs;
    }

    public TLAbsInputQuickReplyShortcut getQuickReplyShortcut() {
        return quickReplyShortcut;
    }

    public void setQuickReplyShortcut(TLAbsInputQuickReplyShortcut quickReplyShortcut) {
        this.quickReplyShortcut = quickReplyShortcut;
    }

    public Long getEffect() {
        return effect;
    }

    public void setEffect(Long effect) {
        this.effect = effect;
    }
}
