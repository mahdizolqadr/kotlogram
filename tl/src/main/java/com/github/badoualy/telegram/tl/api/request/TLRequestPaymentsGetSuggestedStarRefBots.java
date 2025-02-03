package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.payments.TLSuggestedStarRefBots;
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
public class TLRequestPaymentsGetSuggestedStarRefBots extends TLMethod<TLSuggestedStarRefBots> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean orderByRevenue;

    protected boolean orderByDate;

    protected TLAbsInputPeer peer;

    protected String offset;

    protected int limit;

    private final String _constructor = "payments.getSuggestedStarRefBots#0";

    public TLRequestPaymentsGetSuggestedStarRefBots() {
    }

    public TLRequestPaymentsGetSuggestedStarRefBots(boolean orderByRevenue, boolean orderByDate, TLAbsInputPeer peer, String offset, int limit) {
        this.orderByRevenue = orderByRevenue;
        this.orderByDate = orderByDate;
        this.peer = peer;
        this.offset = offset;
        this.limit = limit;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLSuggestedStarRefBots deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLSuggestedStarRefBots)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLSuggestedStarRefBots) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = orderByRevenue ? (flags | 1) : (flags & ~1);
        flags = orderByDate ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peer, stream);
        writeString(offset, stream);
        writeInt(limit, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        orderByRevenue = (flags & 1) != 0;
        orderByDate = (flags & 2) != 0;
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        offset = readTLString(stream);
        limit = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        size += computeTLStringSerializedSize(offset);
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

    public boolean getOrderByRevenue() {
        return orderByRevenue;
    }

    public void setOrderByRevenue(boolean orderByRevenue) {
        this.orderByRevenue = orderByRevenue;
    }

    public boolean getOrderByDate() {
        return orderByDate;
    }

    public void setOrderByDate(boolean orderByDate) {
        this.orderByDate = orderByDate;
    }

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
