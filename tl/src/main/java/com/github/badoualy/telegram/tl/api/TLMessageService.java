package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLMessageService extends TLAbsMessage {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected boolean out;

    protected boolean mentioned;

    protected boolean mediaUnread;

    protected boolean silent;

    protected boolean post;

    protected boolean legacy;

    protected TLAbsPeer fromId;

    protected TLAbsPeer peerId;

    protected TLAbsMessageReplyHeader replyTo;

    protected int date;

    protected TLAbsMessageAction action;

    protected Integer ttlPeriod;

    private final String _constructor = "messageService#0";

    public TLMessageService() {
    }

    public TLMessageService(boolean out, boolean mentioned, boolean mediaUnread, boolean silent, boolean post, boolean legacy, int id, TLAbsPeer fromId, TLAbsPeer peerId, TLAbsMessageReplyHeader replyTo, int date, TLAbsMessageAction action, Integer ttlPeriod) {
        this.out = out;
        this.mentioned = mentioned;
        this.mediaUnread = mediaUnread;
        this.silent = silent;
        this.post = post;
        this.legacy = legacy;
        this.id = id;
        this.fromId = fromId;
        this.peerId = peerId;
        this.replyTo = replyTo;
        this.date = date;
        this.action = action;
        this.ttlPeriod = ttlPeriod;
    }

    private void computeFlags() {
        flags = 0;
        flags = out ? (flags | 2) : (flags & ~2);
        flags = mentioned ? (flags | 16) : (flags & ~16);
        flags = mediaUnread ? (flags | 32) : (flags & ~32);
        flags = silent ? (flags | 8192) : (flags & ~8192);
        flags = post ? (flags | 16384) : (flags & ~16384);
        flags = legacy ? (flags | 524288) : (flags & ~524288);
        flags = fromId != null ? (flags | 256) : (flags & ~256);
        flags = replyTo != null ? (flags | 8) : (flags & ~8);
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
        if ((flags & 8) != 0) {
            if (replyTo == null) throwNullFieldException("replyTo", flags);
            writeTLObject(replyTo, stream);
        }
        writeInt(date, stream);
        writeTLObject(action, stream);
        if ((flags & 33554432) != 0) {
            if (ttlPeriod == null) throwNullFieldException("ttlPeriod", flags);
            writeInt(ttlPeriod, stream);
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
        legacy = (flags & 524288) != 0;
        id = readInt(stream);
        fromId = (flags & 256) != 0 ? readTLObject(stream, context, TLAbsPeer.class, -1) : null;
        peerId = readTLObject(stream, context, TLAbsPeer.class, -1);
        replyTo = (flags & 8) != 0 ? readTLObject(stream, context, TLAbsMessageReplyHeader.class, -1) : null;
        date = readInt(stream);
        action = readTLObject(stream, context, TLAbsMessageAction.class, -1);
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
        if ((flags & 8) != 0) {
            if (replyTo == null) throwNullFieldException("replyTo", flags);
            size += replyTo.computeSerializedSize();
        }
        size += SIZE_INT32;
        size += action.computeSerializedSize();
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

    public boolean getLegacy() {
        return legacy;
    }

    public void setLegacy(boolean legacy) {
        this.legacy = legacy;
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

    public TLAbsPeer getPeerId() {
        return peerId;
    }

    public void setPeerId(TLAbsPeer peerId) {
        this.peerId = peerId;
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

    public TLAbsMessageAction getAction() {
        return action;
    }

    public void setAction(TLAbsMessageAction action) {
        this.action = action;
    }

    public Integer getTtlPeriod() {
        return ttlPeriod;
    }

    public void setTtlPeriod(Integer ttlPeriod) {
        this.ttlPeriod = ttlPeriod;
    }
}
