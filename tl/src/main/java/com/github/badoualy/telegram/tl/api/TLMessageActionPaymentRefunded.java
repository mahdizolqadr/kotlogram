package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
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
public class TLMessageActionPaymentRefunded extends TLAbsMessageAction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLAbsPeer peer;

    protected String currency;

    protected long totalAmount;

    protected TLBytes payload;

    protected TLPaymentCharge charge;

    private final String _constructor = "messageActionPaymentRefunded#0";

    public TLMessageActionPaymentRefunded() {
    }

    public TLMessageActionPaymentRefunded(TLAbsPeer peer, String currency, long totalAmount, TLBytes payload, TLPaymentCharge charge) {
        this.peer = peer;
        this.currency = currency;
        this.totalAmount = totalAmount;
        this.payload = payload;
        this.charge = charge;
    }

    private void computeFlags() {
        flags = 0;
        flags = payload != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peer, stream);
        writeString(currency, stream);
        writeLong(totalAmount, stream);
        if ((flags & 1) != 0) {
            if (payload == null) throwNullFieldException("payload", flags);
            writeTLBytes(payload, stream);
        }
        writeTLObject(charge, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        peer = readTLObject(stream, context, TLAbsPeer.class, -1);
        currency = readTLString(stream);
        totalAmount = readLong(stream);
        payload = (flags & 1) != 0 ? readTLBytes(stream, context) : null;
        charge = readTLObject(stream, context, TLPaymentCharge.class, TLPaymentCharge.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        size += computeTLStringSerializedSize(currency);
        size += SIZE_INT64;
        if ((flags & 1) != 0) {
            if (payload == null) throwNullFieldException("payload", flags);
            size += computeTLBytesSerializedSize(payload);
        }
        size += charge.computeSerializedSize();
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

    public TLAbsPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsPeer peer) {
        this.peer = peer;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public TLBytes getPayload() {
        return payload;
    }

    public void setPayload(TLBytes payload) {
        this.payload = payload;
    }

    public TLPaymentCharge getCharge() {
        return charge;
    }

    public void setCharge(TLPaymentCharge charge) {
        this.charge = charge;
    }
}
