package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsMessagesFilter;
import com.github.badoualy.telegram.tl.api.TLAbsReaction;
import com.github.badoualy.telegram.tl.api.messages.TLAbsMessages;
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
public class TLRequestMessagesSearch extends TLMethod<TLAbsMessages> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLAbsInputPeer peer;

    protected String q;

    protected TLAbsInputPeer fromId;

    protected TLAbsInputPeer savedPeerId;

    protected TLVector<TLAbsReaction> savedReaction;

    protected Integer topMsgId;

    protected TLAbsMessagesFilter filter;

    protected int minDate;

    protected int maxDate;

    protected int offsetId;

    protected int addOffset;

    protected int limit;

    protected int maxId;

    protected int minId;

    protected long hash;

    private final String _constructor = "messages.search#0";

    public TLRequestMessagesSearch() {
    }

    public TLRequestMessagesSearch(TLAbsInputPeer peer, String q, TLAbsInputPeer fromId, TLAbsInputPeer savedPeerId, TLVector<TLAbsReaction> savedReaction, Integer topMsgId, TLAbsMessagesFilter filter, int minDate, int maxDate, int offsetId, int addOffset, int limit, int maxId, int minId, long hash) {
        this.peer = peer;
        this.q = q;
        this.fromId = fromId;
        this.savedPeerId = savedPeerId;
        this.savedReaction = savedReaction;
        this.topMsgId = topMsgId;
        this.filter = filter;
        this.minDate = minDate;
        this.maxDate = maxDate;
        this.offsetId = offsetId;
        this.addOffset = addOffset;
        this.limit = limit;
        this.maxId = maxId;
        this.minId = minId;
        this.hash = hash;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsMessages deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsMessages)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsMessages) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = fromId != null ? (flags | 1) : (flags & ~1);
        flags = savedPeerId != null ? (flags | 4) : (flags & ~4);
        flags = savedReaction != null ? (flags | 8) : (flags & ~8);
        flags = topMsgId != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peer, stream);
        writeString(q, stream);
        if ((flags & 1) != 0) {
            if (fromId == null) throwNullFieldException("fromId", flags);
            writeTLObject(fromId, stream);
        }
        if ((flags & 4) != 0) {
            if (savedPeerId == null) throwNullFieldException("savedPeerId", flags);
            writeTLObject(savedPeerId, stream);
        }
        if ((flags & 8) != 0) {
            if (savedReaction == null) throwNullFieldException("savedReaction", flags);
            writeTLVector(savedReaction, stream);
        }
        if ((flags & 2) != 0) {
            if (topMsgId == null) throwNullFieldException("topMsgId", flags);
            writeInt(topMsgId, stream);
        }
        writeTLObject(filter, stream);
        writeInt(minDate, stream);
        writeInt(maxDate, stream);
        writeInt(offsetId, stream);
        writeInt(addOffset, stream);
        writeInt(limit, stream);
        writeInt(maxId, stream);
        writeInt(minId, stream);
        writeLong(hash, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        q = readTLString(stream);
        fromId = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsInputPeer.class, -1) : null;
        savedPeerId = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsInputPeer.class, -1) : null;
        savedReaction = (flags & 8) != 0 ? readTLVector(stream, context) : null;
        topMsgId = (flags & 2) != 0 ? readInt(stream) : null;
        filter = readTLObject(stream, context, TLAbsMessagesFilter.class, -1);
        minDate = readInt(stream);
        maxDate = readInt(stream);
        offsetId = readInt(stream);
        addOffset = readInt(stream);
        limit = readInt(stream);
        maxId = readInt(stream);
        minId = readInt(stream);
        hash = readLong(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        size += computeTLStringSerializedSize(q);
        if ((flags & 1) != 0) {
            if (fromId == null) throwNullFieldException("fromId", flags);
            size += fromId.computeSerializedSize();
        }
        if ((flags & 4) != 0) {
            if (savedPeerId == null) throwNullFieldException("savedPeerId", flags);
            size += savedPeerId.computeSerializedSize();
        }
        if ((flags & 8) != 0) {
            if (savedReaction == null) throwNullFieldException("savedReaction", flags);
            size += savedReaction.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (topMsgId == null) throwNullFieldException("topMsgId", flags);
            size += SIZE_INT32;
        }
        size += filter.computeSerializedSize();
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT64;
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

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public TLAbsInputPeer getFromId() {
        return fromId;
    }

    public void setFromId(TLAbsInputPeer fromId) {
        this.fromId = fromId;
    }

    public TLAbsInputPeer getSavedPeerId() {
        return savedPeerId;
    }

    public void setSavedPeerId(TLAbsInputPeer savedPeerId) {
        this.savedPeerId = savedPeerId;
    }

    public TLVector<TLAbsReaction> getSavedReaction() {
        return savedReaction;
    }

    public void setSavedReaction(TLVector<TLAbsReaction> savedReaction) {
        this.savedReaction = savedReaction;
    }

    public Integer getTopMsgId() {
        return topMsgId;
    }

    public void setTopMsgId(Integer topMsgId) {
        this.topMsgId = topMsgId;
    }

    public TLAbsMessagesFilter getFilter() {
        return filter;
    }

    public void setFilter(TLAbsMessagesFilter filter) {
        this.filter = filter;
    }

    public int getMinDate() {
        return minDate;
    }

    public void setMinDate(int minDate) {
        this.minDate = minDate;
    }

    public int getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(int maxDate) {
        this.maxDate = maxDate;
    }

    public int getOffsetId() {
        return offsetId;
    }

    public void setOffsetId(int offsetId) {
        this.offsetId = offsetId;
    }

    public int getAddOffset() {
        return addOffset;
    }

    public void setAddOffset(int addOffset) {
        this.addOffset = addOffset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int maxId) {
        this.maxId = maxId;
    }

    public int getMinId() {
        return minId;
    }

    public void setMinId(int minId) {
        this.minId = minId;
    }

    public long getHash() {
        return hash;
    }

    public void setHash(long hash) {
        this.hash = hash;
    }
}
