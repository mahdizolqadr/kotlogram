package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLMessageReplyHeader extends TLAbsMessageReplyHeader {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean replyToScheduled;

    protected boolean forumTopic;

    protected boolean quote;

    protected Integer replyToMsgId;

    protected TLAbsPeer replyToPeerId;

    protected TLMessageFwdHeader replyFrom;

    protected TLAbsMessageMedia replyMedia;

    protected Integer replyToTopId;

    protected String quoteText;

    protected TLVector<TLAbsMessageEntity> quoteEntities;

    protected Integer quoteOffset;

    private final String _constructor = "messageReplyHeader#0";

    public TLMessageReplyHeader() {
    }

    public TLMessageReplyHeader(boolean replyToScheduled, boolean forumTopic, boolean quote, Integer replyToMsgId, TLAbsPeer replyToPeerId, TLMessageFwdHeader replyFrom, TLAbsMessageMedia replyMedia, Integer replyToTopId, String quoteText, TLVector<TLAbsMessageEntity> quoteEntities, Integer quoteOffset) {
        this.replyToScheduled = replyToScheduled;
        this.forumTopic = forumTopic;
        this.quote = quote;
        this.replyToMsgId = replyToMsgId;
        this.replyToPeerId = replyToPeerId;
        this.replyFrom = replyFrom;
        this.replyMedia = replyMedia;
        this.replyToTopId = replyToTopId;
        this.quoteText = quoteText;
        this.quoteEntities = quoteEntities;
        this.quoteOffset = quoteOffset;
    }

    private void computeFlags() {
        flags = 0;
        flags = replyToScheduled ? (flags | 4) : (flags & ~4);
        flags = forumTopic ? (flags | 8) : (flags & ~8);
        flags = quote ? (flags | 512) : (flags & ~512);
        flags = replyToMsgId != null ? (flags | 16) : (flags & ~16);
        flags = replyToPeerId != null ? (flags | 1) : (flags & ~1);
        flags = replyFrom != null ? (flags | 32) : (flags & ~32);
        flags = replyMedia != null ? (flags | 256) : (flags & ~256);
        flags = replyToTopId != null ? (flags | 2) : (flags & ~2);
        flags = quoteText != null ? (flags | 64) : (flags & ~64);
        flags = quoteEntities != null ? (flags | 128) : (flags & ~128);
        flags = quoteOffset != null ? (flags | 1024) : (flags & ~1024);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 16) != 0) {
            if (replyToMsgId == null) throwNullFieldException("replyToMsgId", flags);
            writeInt(replyToMsgId, stream);
        }
        if ((flags & 1) != 0) {
            if (replyToPeerId == null) throwNullFieldException("replyToPeerId", flags);
            writeTLObject(replyToPeerId, stream);
        }
        if ((flags & 32) != 0) {
            if (replyFrom == null) throwNullFieldException("replyFrom", flags);
            writeTLObject(replyFrom, stream);
        }
        if ((flags & 256) != 0) {
            if (replyMedia == null) throwNullFieldException("replyMedia", flags);
            writeTLObject(replyMedia, stream);
        }
        if ((flags & 2) != 0) {
            if (replyToTopId == null) throwNullFieldException("replyToTopId", flags);
            writeInt(replyToTopId, stream);
        }
        if ((flags & 64) != 0) {
            if (quoteText == null) throwNullFieldException("quoteText", flags);
            writeString(quoteText, stream);
        }
        if ((flags & 128) != 0) {
            if (quoteEntities == null) throwNullFieldException("quoteEntities", flags);
            writeTLVector(quoteEntities, stream);
        }
        if ((flags & 1024) != 0) {
            if (quoteOffset == null) throwNullFieldException("quoteOffset", flags);
            writeInt(quoteOffset, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        replyToScheduled = (flags & 4) != 0;
        forumTopic = (flags & 8) != 0;
        quote = (flags & 512) != 0;
        replyToMsgId = (flags & 16) != 0 ? readInt(stream) : null;
        replyToPeerId = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsPeer.class, -1) : null;
        replyFrom = (flags & 32) != 0 ? readTLObject(stream, context, TLMessageFwdHeader.class, TLMessageFwdHeader.CONSTRUCTOR_ID) : null;
        replyMedia = (flags & 256) != 0 ? readTLObject(stream, context, TLAbsMessageMedia.class, -1) : null;
        replyToTopId = (flags & 2) != 0 ? readInt(stream) : null;
        quoteText = (flags & 64) != 0 ? readTLString(stream) : null;
        quoteEntities = (flags & 128) != 0 ? readTLVector(stream, context) : null;
        quoteOffset = (flags & 1024) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 16) != 0) {
            if (replyToMsgId == null) throwNullFieldException("replyToMsgId", flags);
            size += SIZE_INT32;
        }
        if ((flags & 1) != 0) {
            if (replyToPeerId == null) throwNullFieldException("replyToPeerId", flags);
            size += replyToPeerId.computeSerializedSize();
        }
        if ((flags & 32) != 0) {
            if (replyFrom == null) throwNullFieldException("replyFrom", flags);
            size += replyFrom.computeSerializedSize();
        }
        if ((flags & 256) != 0) {
            if (replyMedia == null) throwNullFieldException("replyMedia", flags);
            size += replyMedia.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (replyToTopId == null) throwNullFieldException("replyToTopId", flags);
            size += SIZE_INT32;
        }
        if ((flags & 64) != 0) {
            if (quoteText == null) throwNullFieldException("quoteText", flags);
            size += computeTLStringSerializedSize(quoteText);
        }
        if ((flags & 128) != 0) {
            if (quoteEntities == null) throwNullFieldException("quoteEntities", flags);
            size += quoteEntities.computeSerializedSize();
        }
        if ((flags & 1024) != 0) {
            if (quoteOffset == null) throwNullFieldException("quoteOffset", flags);
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

    public boolean getReplyToScheduled() {
        return replyToScheduled;
    }

    public void setReplyToScheduled(boolean replyToScheduled) {
        this.replyToScheduled = replyToScheduled;
    }

    public boolean getForumTopic() {
        return forumTopic;
    }

    public void setForumTopic(boolean forumTopic) {
        this.forumTopic = forumTopic;
    }

    public boolean getQuote() {
        return quote;
    }

    public void setQuote(boolean quote) {
        this.quote = quote;
    }

    public Integer getReplyToMsgId() {
        return replyToMsgId;
    }

    public void setReplyToMsgId(Integer replyToMsgId) {
        this.replyToMsgId = replyToMsgId;
    }

    public TLAbsPeer getReplyToPeerId() {
        return replyToPeerId;
    }

    public void setReplyToPeerId(TLAbsPeer replyToPeerId) {
        this.replyToPeerId = replyToPeerId;
    }

    public TLMessageFwdHeader getReplyFrom() {
        return replyFrom;
    }

    public void setReplyFrom(TLMessageFwdHeader replyFrom) {
        this.replyFrom = replyFrom;
    }

    public TLAbsMessageMedia getReplyMedia() {
        return replyMedia;
    }

    public void setReplyMedia(TLAbsMessageMedia replyMedia) {
        this.replyMedia = replyMedia;
    }

    public Integer getReplyToTopId() {
        return replyToTopId;
    }

    public void setReplyToTopId(Integer replyToTopId) {
        this.replyToTopId = replyToTopId;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }

    public TLVector<TLAbsMessageEntity> getQuoteEntities() {
        return quoteEntities;
    }

    public void setQuoteEntities(TLVector<TLAbsMessageEntity> quoteEntities) {
        this.quoteEntities = quoteEntities;
    }

    public Integer getQuoteOffset() {
        return quoteOffset;
    }

    public void setQuoteOffset(Integer quoteOffset) {
        this.quoteOffset = quoteOffset;
    }
}
