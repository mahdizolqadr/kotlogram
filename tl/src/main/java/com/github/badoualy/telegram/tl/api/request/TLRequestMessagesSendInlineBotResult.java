package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsInputQuickReplyShortcut;
import com.github.badoualy.telegram.tl.api.TLAbsInputReplyTo;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLRequestMessagesSendInlineBotResult extends TLMethod<TLAbsUpdates> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean silent;

    protected boolean background;

    protected boolean clearDraft;

    protected boolean hideVia;

    protected TLAbsInputPeer peer;

    protected TLAbsInputReplyTo replyTo;

    protected long randomId;

    protected long queryId;

    protected String id;

    protected Integer scheduleDate;

    protected TLAbsInputPeer sendAs;

    protected TLAbsInputQuickReplyShortcut quickReplyShortcut;

    private final String _constructor = "messages.sendInlineBotResult#0";

    public TLRequestMessagesSendInlineBotResult() {
    }

    public TLRequestMessagesSendInlineBotResult(boolean silent, boolean background, boolean clearDraft, boolean hideVia, TLAbsInputPeer peer, TLAbsInputReplyTo replyTo, long randomId, long queryId, String id, Integer scheduleDate, TLAbsInputPeer sendAs, TLAbsInputQuickReplyShortcut quickReplyShortcut) {
        this.silent = silent;
        this.background = background;
        this.clearDraft = clearDraft;
        this.hideVia = hideVia;
        this.peer = peer;
        this.replyTo = replyTo;
        this.randomId = randomId;
        this.queryId = queryId;
        this.id = id;
        this.scheduleDate = scheduleDate;
        this.sendAs = sendAs;
        this.quickReplyShortcut = quickReplyShortcut;
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
        flags = hideVia ? (flags | 2048) : (flags & ~2048);
        flags = replyTo != null ? (flags | 1) : (flags & ~1);
        flags = scheduleDate != null ? (flags | 1024) : (flags & ~1024);
        flags = sendAs != null ? (flags | 8192) : (flags & ~8192);
        flags = quickReplyShortcut != null ? (flags | 131072) : (flags & ~131072);
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
        writeLong(randomId, stream);
        writeLong(queryId, stream);
        writeString(id, stream);
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
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        silent = (flags & 32) != 0;
        background = (flags & 64) != 0;
        clearDraft = (flags & 128) != 0;
        hideVia = (flags & 2048) != 0;
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        replyTo = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsInputReplyTo.class, -1) : null;
        randomId = readLong(stream);
        queryId = readLong(stream);
        id = readTLString(stream);
        scheduleDate = (flags & 1024) != 0 ? readInt(stream) : null;
        sendAs = (flags & 8192) != 0 ? readTLObject(stream, context, TLAbsInputPeer.class, -1) : null;
        quickReplyShortcut = (flags & 131072) != 0 ? readTLObject(stream, context, TLAbsInputQuickReplyShortcut.class, -1) : null;
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
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(id);
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

    public boolean getHideVia() {
        return hideVia;
    }

    public void setHideVia(boolean hideVia) {
        this.hideVia = hideVia;
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

    public long getRandomId() {
        return randomId;
    }

    public void setRandomId(long randomId) {
        this.randomId = randomId;
    }

    public long getQueryId() {
        return queryId;
    }

    public void setQueryId(long queryId) {
        this.queryId = queryId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
