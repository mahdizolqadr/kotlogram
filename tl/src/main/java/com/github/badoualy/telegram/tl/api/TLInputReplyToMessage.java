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
public class TLInputReplyToMessage extends TLAbsInputReplyTo {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected int replyToMsgId;

    protected Integer topMsgId;

    protected TLAbsInputPeer replyToPeerId;

    protected String quoteText;

    protected TLVector<TLAbsMessageEntity> quoteEntities;

    protected Integer quoteOffset;

    private final String _constructor = "inputReplyToMessage#0";

    public TLInputReplyToMessage() {
    }

    public TLInputReplyToMessage(int replyToMsgId, Integer topMsgId, TLAbsInputPeer replyToPeerId, String quoteText, TLVector<TLAbsMessageEntity> quoteEntities, Integer quoteOffset) {
        this.replyToMsgId = replyToMsgId;
        this.topMsgId = topMsgId;
        this.replyToPeerId = replyToPeerId;
        this.quoteText = quoteText;
        this.quoteEntities = quoteEntities;
        this.quoteOffset = quoteOffset;
    }

    private void computeFlags() {
        flags = 0;
        flags = topMsgId != null ? (flags | 1) : (flags & ~1);
        flags = replyToPeerId != null ? (flags | 2) : (flags & ~2);
        flags = quoteText != null ? (flags | 4) : (flags & ~4);
        flags = quoteEntities != null ? (flags | 8) : (flags & ~8);
        flags = quoteOffset != null ? (flags | 16) : (flags & ~16);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(replyToMsgId, stream);
        if ((flags & 1) != 0) {
            if (topMsgId == null) throwNullFieldException("topMsgId", flags);
            writeInt(topMsgId, stream);
        }
        if ((flags & 2) != 0) {
            if (replyToPeerId == null) throwNullFieldException("replyToPeerId", flags);
            writeTLObject(replyToPeerId, stream);
        }
        if ((flags & 4) != 0) {
            if (quoteText == null) throwNullFieldException("quoteText", flags);
            writeString(quoteText, stream);
        }
        if ((flags & 8) != 0) {
            if (quoteEntities == null) throwNullFieldException("quoteEntities", flags);
            writeTLVector(quoteEntities, stream);
        }
        if ((flags & 16) != 0) {
            if (quoteOffset == null) throwNullFieldException("quoteOffset", flags);
            writeInt(quoteOffset, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        replyToMsgId = readInt(stream);
        topMsgId = (flags & 1) != 0 ? readInt(stream) : null;
        replyToPeerId = (flags & 2) != 0 ? readTLObject(stream, context, TLAbsInputPeer.class, -1) : null;
        quoteText = (flags & 4) != 0 ? readTLString(stream) : null;
        quoteEntities = (flags & 8) != 0 ? readTLVector(stream, context) : null;
        quoteOffset = (flags & 16) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (topMsgId == null) throwNullFieldException("topMsgId", flags);
            size += SIZE_INT32;
        }
        if ((flags & 2) != 0) {
            if (replyToPeerId == null) throwNullFieldException("replyToPeerId", flags);
            size += replyToPeerId.computeSerializedSize();
        }
        if ((flags & 4) != 0) {
            if (quoteText == null) throwNullFieldException("quoteText", flags);
            size += computeTLStringSerializedSize(quoteText);
        }
        if ((flags & 8) != 0) {
            if (quoteEntities == null) throwNullFieldException("quoteEntities", flags);
            size += quoteEntities.computeSerializedSize();
        }
        if ((flags & 16) != 0) {
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

    public int getReplyToMsgId() {
        return replyToMsgId;
    }

    public void setReplyToMsgId(int replyToMsgId) {
        this.replyToMsgId = replyToMsgId;
    }

    public Integer getTopMsgId() {
        return topMsgId;
    }

    public void setTopMsgId(Integer topMsgId) {
        this.topMsgId = topMsgId;
    }

    public TLAbsInputPeer getReplyToPeerId() {
        return replyToPeerId;
    }

    public void setReplyToPeerId(TLAbsInputPeer replyToPeerId) {
        this.replyToPeerId = replyToPeerId;
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
