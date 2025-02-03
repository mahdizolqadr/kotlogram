package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsInputStorePaymentPurpose;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
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
public class TLRequestPaymentsLaunchPrepaidGiveaway extends TLMethod<TLAbsUpdates> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsInputPeer peer;

    protected long giveawayId;

    protected TLAbsInputStorePaymentPurpose purpose;

    private final String _constructor = "payments.launchPrepaidGiveaway#0";

    public TLRequestPaymentsLaunchPrepaidGiveaway() {
    }

    public TLRequestPaymentsLaunchPrepaidGiveaway(TLAbsInputPeer peer, long giveawayId, TLAbsInputStorePaymentPurpose purpose) {
        this.peer = peer;
        this.giveawayId = giveawayId;
        this.purpose = purpose;
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

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(peer, stream);
        writeLong(giveawayId, stream);
        writeTLObject(purpose, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        giveawayId = readLong(stream);
        purpose = readTLObject(stream, context, TLAbsInputStorePaymentPurpose.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += peer.computeSerializedSize();
        size += SIZE_INT64;
        size += purpose.computeSerializedSize();
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

    public long getGiveawayId() {
        return giveawayId;
    }

    public void setGiveawayId(long giveawayId) {
        this.giveawayId = giveawayId;
    }

    public TLAbsInputStorePaymentPurpose getPurpose() {
        return purpose;
    }

    public void setPurpose(TLAbsInputStorePaymentPurpose purpose) {
        this.purpose = purpose;
    }
}
