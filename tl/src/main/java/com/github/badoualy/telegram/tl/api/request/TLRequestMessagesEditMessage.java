package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputMedia;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
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
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestMessagesEditMessage extends TLMethod<TLAbsUpdates> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean noWebpage;

    protected boolean invertMedia;

    protected TLAbsInputPeer peer;

    protected int id;

    protected String message;

    protected TLAbsInputMedia media;

    protected TLAbsReplyMarkup replyMarkup;

    protected TLVector<TLAbsMessageEntity> entities;

    protected Integer scheduleDate;

    protected Integer quickReplyShortcutId;

    private final String _constructor = "messages.editMessage#0";

    public TLRequestMessagesEditMessage() {
    }

    public TLRequestMessagesEditMessage(boolean noWebpage, boolean invertMedia, TLAbsInputPeer peer, int id, String message, TLAbsInputMedia media, TLAbsReplyMarkup replyMarkup, TLVector<TLAbsMessageEntity> entities, Integer scheduleDate, Integer quickReplyShortcutId) {
        this.noWebpage = noWebpage;
        this.invertMedia = invertMedia;
        this.peer = peer;
        this.id = id;
        this.message = message;
        this.media = media;
        this.replyMarkup = replyMarkup;
        this.entities = entities;
        this.scheduleDate = scheduleDate;
        this.quickReplyShortcutId = quickReplyShortcutId;
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
        flags = noWebpage ? (flags | 2) : (flags & ~2);
        flags = invertMedia ? (flags | 65536) : (flags & ~65536);
        flags = message != null ? (flags | 2048) : (flags & ~2048);
        flags = media != null ? (flags | 16384) : (flags & ~16384);
        flags = replyMarkup != null ? (flags | 4) : (flags & ~4);
        flags = entities != null ? (flags | 8) : (flags & ~8);
        flags = scheduleDate != null ? (flags | 32768) : (flags & ~32768);
        flags = quickReplyShortcutId != null ? (flags | 131072) : (flags & ~131072);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peer, stream);
        writeInt(id, stream);
        if ((flags & 2048) != 0) {
            if (message == null) throwNullFieldException("message", flags);
            writeString(message, stream);
        }
        if ((flags & 16384) != 0) {
            if (media == null) throwNullFieldException("media", flags);
            writeTLObject(media, stream);
        }
        if ((flags & 4) != 0) {
            if (replyMarkup == null) throwNullFieldException("replyMarkup", flags);
            writeTLObject(replyMarkup, stream);
        }
        if ((flags & 8) != 0) {
            if (entities == null) throwNullFieldException("entities", flags);
            writeTLVector(entities, stream);
        }
        if ((flags & 32768) != 0) {
            if (scheduleDate == null) throwNullFieldException("scheduleDate", flags);
            writeInt(scheduleDate, stream);
        }
        if ((flags & 131072) != 0) {
            if (quickReplyShortcutId == null) throwNullFieldException("quickReplyShortcutId", flags);
            writeInt(quickReplyShortcutId, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        noWebpage = (flags & 2) != 0;
        invertMedia = (flags & 65536) != 0;
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        id = readInt(stream);
        message = (flags & 2048) != 0 ? readTLString(stream) : null;
        media = (flags & 16384) != 0 ? readTLObject(stream, context, TLAbsInputMedia.class, -1) : null;
        replyMarkup = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsReplyMarkup.class, -1) : null;
        entities = (flags & 8) != 0 ? readTLVector(stream, context) : null;
        scheduleDate = (flags & 32768) != 0 ? readInt(stream) : null;
        quickReplyShortcutId = (flags & 131072) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        size += SIZE_INT32;
        if ((flags & 2048) != 0) {
            if (message == null) throwNullFieldException("message", flags);
            size += computeTLStringSerializedSize(message);
        }
        if ((flags & 16384) != 0) {
            if (media == null) throwNullFieldException("media", flags);
            size += media.computeSerializedSize();
        }
        if ((flags & 4) != 0) {
            if (replyMarkup == null) throwNullFieldException("replyMarkup", flags);
            size += replyMarkup.computeSerializedSize();
        }
        if ((flags & 8) != 0) {
            if (entities == null) throwNullFieldException("entities", flags);
            size += entities.computeSerializedSize();
        }
        if ((flags & 32768) != 0) {
            if (scheduleDate == null) throwNullFieldException("scheduleDate", flags);
            size += SIZE_INT32;
        }
        if ((flags & 131072) != 0) {
            if (quickReplyShortcutId == null) throwNullFieldException("quickReplyShortcutId", flags);
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TLAbsInputMedia getMedia() {
        return media;
    }

    public void setMedia(TLAbsInputMedia media) {
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

    public Integer getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Integer scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Integer getQuickReplyShortcutId() {
        return quickReplyShortcutId;
    }

    public void setQuickReplyShortcutId(Integer quickReplyShortcutId) {
        this.quickReplyShortcutId = quickReplyShortcutId;
    }
}
