package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.payments.TLStarsStatus;
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
public class TLRequestPaymentsGetStarsTransactions extends TLMethod<TLStarsStatus> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean inbound;

    protected boolean outbound;

    protected boolean ascending;

    protected String subscriptionId;

    protected TLAbsInputPeer peer;

    protected String offset;

    protected int limit;

    private final String _constructor = "payments.getStarsTransactions#0";

    public TLRequestPaymentsGetStarsTransactions() {
    }

    public TLRequestPaymentsGetStarsTransactions(boolean inbound, boolean outbound, boolean ascending, String subscriptionId, TLAbsInputPeer peer, String offset, int limit) {
        this.inbound = inbound;
        this.outbound = outbound;
        this.ascending = ascending;
        this.subscriptionId = subscriptionId;
        this.peer = peer;
        this.offset = offset;
        this.limit = limit;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLStarsStatus deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLStarsStatus)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLStarsStatus) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = inbound ? (flags | 1) : (flags & ~1);
        flags = outbound ? (flags | 2) : (flags & ~2);
        flags = ascending ? (flags | 4) : (flags & ~4);
        flags = subscriptionId != null ? (flags | 8) : (flags & ~8);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 8) != 0) {
            if (subscriptionId == null) throwNullFieldException("subscriptionId", flags);
            writeString(subscriptionId, stream);
        }
        writeTLObject(peer, stream);
        writeString(offset, stream);
        writeInt(limit, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        inbound = (flags & 1) != 0;
        outbound = (flags & 2) != 0;
        ascending = (flags & 4) != 0;
        subscriptionId = (flags & 8) != 0 ? readTLString(stream) : null;
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        offset = readTLString(stream);
        limit = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 8) != 0) {
            if (subscriptionId == null) throwNullFieldException("subscriptionId", flags);
            size += computeTLStringSerializedSize(subscriptionId);
        }
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

    public boolean getInbound() {
        return inbound;
    }

    public void setInbound(boolean inbound) {
        this.inbound = inbound;
    }

    public boolean getOutbound() {
        return outbound;
    }

    public void setOutbound(boolean outbound) {
        this.outbound = outbound;
    }

    public boolean getAscending() {
        return ascending;
    }

    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
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
