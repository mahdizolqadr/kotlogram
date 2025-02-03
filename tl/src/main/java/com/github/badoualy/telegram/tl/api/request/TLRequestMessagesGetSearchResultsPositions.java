package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsMessagesFilter;
import com.github.badoualy.telegram.tl.api.messages.TLSearchResultsPositions;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestMessagesGetSearchResultsPositions extends TLMethod<TLSearchResultsPositions> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLAbsInputPeer peer;

    protected TLAbsInputPeer savedPeerId;

    protected TLAbsMessagesFilter filter;

    protected int offsetId;

    protected int limit;

    private final String _constructor = "messages.getSearchResultsPositions#0";

    public TLRequestMessagesGetSearchResultsPositions() {
    }

    public TLRequestMessagesGetSearchResultsPositions(TLAbsInputPeer peer, TLAbsInputPeer savedPeerId, TLAbsMessagesFilter filter, int offsetId, int limit) {
        this.peer = peer;
        this.savedPeerId = savedPeerId;
        this.filter = filter;
        this.offsetId = offsetId;
        this.limit = limit;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLSearchResultsPositions deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLSearchResultsPositions)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLSearchResultsPositions) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = savedPeerId != null ? (flags | 4) : (flags & ~4);
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
        writeTLObject(filter, stream);
        writeInt(offsetId, stream);
        writeInt(limit, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        savedPeerId = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsInputPeer.class, -1) : null;
        filter = readTLObject(stream, context, TLAbsMessagesFilter.class, -1);
        offsetId = readInt(stream);
        limit = readInt(stream);
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
        size += filter.computeSerializedSize();
        size += SIZE_INT32;
        size += SIZE_INT32;
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

    public TLAbsMessagesFilter getFilter() {
        return filter;
    }

    public void setFilter(TLAbsMessagesFilter filter) {
        this.filter = filter;
    }

    public int getOffsetId() {
        return offsetId;
    }

    public void setOffsetId(int offsetId) {
        this.offsetId = offsetId;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
