package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsMessagesFilter;
import com.github.badoualy.telegram.tl.api.messages.TLSearchCounter;
import com.github.badoualy.telegram.tl.core.TLMethod;
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
public class TLRequestMessagesGetSearchCounters extends TLMethod<TLVector<TLSearchCounter>> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLAbsInputPeer peer;

    protected TLAbsInputPeer savedPeerId;

    protected Integer topMsgId;

    protected TLVector<TLAbsMessagesFilter> filters;

    private final String _constructor = "messages.getSearchCounters#0";

    public TLRequestMessagesGetSearchCounters() {
    }

    public TLRequestMessagesGetSearchCounters(TLAbsInputPeer peer, TLAbsInputPeer savedPeerId, Integer topMsgId, TLVector<TLAbsMessagesFilter> filters) {
        this.peer = peer;
        this.savedPeerId = savedPeerId;
        this.topMsgId = topMsgId;
        this.filters = filters;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLVector<TLSearchCounter> deserializeResponse(InputStream stream, TLContext context) throws IOException {
        return readTLVector(stream, context);
    }

    private void computeFlags() {
        flags = 0;
        flags = savedPeerId != null ? (flags | 4) : (flags & ~4);
        flags = topMsgId != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peer, stream);
        if ((flags & 4) != 0) {
            if (savedPeerId == null) throwNullFieldException("savedPeerId", flags);
            writeTLObject(savedPeerId, stream);
        }
        if ((flags & 1) != 0) {
            if (topMsgId == null) throwNullFieldException("topMsgId", flags);
            writeInt(topMsgId, stream);
        }
        writeTLVector(filters, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        savedPeerId = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsInputPeer.class, -1) : null;
        topMsgId = (flags & 1) != 0 ? readInt(stream) : null;
        filters = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        if ((flags & 4) != 0) {
            if (savedPeerId == null) throwNullFieldException("savedPeerId", flags);
            size += savedPeerId.computeSerializedSize();
        }
        if ((flags & 1) != 0) {
            if (topMsgId == null) throwNullFieldException("topMsgId", flags);
            size += SIZE_INT32;
        }
        size += filters.computeSerializedSize();
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

    public TLAbsInputPeer getSavedPeerId() {
        return savedPeerId;
    }

    public void setSavedPeerId(TLAbsInputPeer savedPeerId) {
        this.savedPeerId = savedPeerId;
    }

    public Integer getTopMsgId() {
        return topMsgId;
    }

    public void setTopMsgId(Integer topMsgId) {
        this.topMsgId = topMsgId;
    }

    public TLVector<TLAbsMessagesFilter> getFilters() {
        return filters;
    }

    public void setFilters(TLVector<TLAbsMessagesFilter> filters) {
        this.filters = filters;
    }
}
