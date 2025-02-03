package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
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
public class TLMessageActionPaymentSentMe extends TLAbsMessageAction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean recurringInit;

    protected boolean recurringUsed;

    protected String currency;

    protected long totalAmount;

    protected TLBytes payload;

    protected TLPaymentRequestedInfo info;

    protected String shippingOptionId;

    protected TLPaymentCharge charge;

    protected Integer subscriptionUntilDate;

    private final String _constructor = "messageActionPaymentSentMe#0";

    public TLMessageActionPaymentSentMe() {
    }

    public TLMessageActionPaymentSentMe(boolean recurringInit, boolean recurringUsed, String currency, long totalAmount, TLBytes payload, TLPaymentRequestedInfo info, String shippingOptionId, TLPaymentCharge charge, Integer subscriptionUntilDate) {
        this.recurringInit = recurringInit;
        this.recurringUsed = recurringUsed;
        this.currency = currency;
        this.totalAmount = totalAmount;
        this.payload = payload;
        this.info = info;
        this.shippingOptionId = shippingOptionId;
        this.charge = charge;
        this.subscriptionUntilDate = subscriptionUntilDate;
    }

    private void computeFlags() {
        flags = 0;
        flags = recurringInit ? (flags | 4) : (flags & ~4);
        flags = recurringUsed ? (flags | 8) : (flags & ~8);
        flags = info != null ? (flags | 1) : (flags & ~1);
        flags = shippingOptionId != null ? (flags | 2) : (flags & ~2);
        flags = subscriptionUntilDate != null ? (flags | 16) : (flags & ~16);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(currency, stream);
        writeLong(totalAmount, stream);
        writeTLBytes(payload, stream);
        if ((flags & 1) != 0) {
            if (info == null) throwNullFieldException("info", flags);
            writeTLObject(info, stream);
        }
        if ((flags & 2) != 0) {
            if (shippingOptionId == null) throwNullFieldException("shippingOptionId", flags);
            writeString(shippingOptionId, stream);
        }
        writeTLObject(charge, stream);
        if ((flags & 16) != 0) {
            if (subscriptionUntilDate == null) throwNullFieldException("subscriptionUntilDate", flags);
            writeInt(subscriptionUntilDate, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        recurringInit = (flags & 4) != 0;
        recurringUsed = (flags & 8) != 0;
        currency = readTLString(stream);
        totalAmount = readLong(stream);
        payload = readTLBytes(stream, context);
        info = (flags & 1) != 0 ? readTLObject(stream, context, TLPaymentRequestedInfo.class, TLPaymentRequestedInfo.CONSTRUCTOR_ID) : null;
        shippingOptionId = (flags & 2) != 0 ? readTLString(stream) : null;
        charge = readTLObject(stream, context, TLPaymentCharge.class, TLPaymentCharge.CONSTRUCTOR_ID);
        subscriptionUntilDate = (flags & 16) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(currency);
        size += SIZE_INT64;
        size += computeTLBytesSerializedSize(payload);
        if ((flags & 1) != 0) {
            if (info == null) throwNullFieldException("info", flags);
            size += info.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (shippingOptionId == null) throwNullFieldException("shippingOptionId", flags);
            size += computeTLStringSerializedSize(shippingOptionId);
        }
        size += charge.computeSerializedSize();
        if ((flags & 16) != 0) {
            if (subscriptionUntilDate == null) throwNullFieldException("subscriptionUntilDate", flags);
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

    public boolean getRecurringInit() {
        return recurringInit;
    }

    public void setRecurringInit(boolean recurringInit) {
        this.recurringInit = recurringInit;
    }

    public boolean getRecurringUsed() {
        return recurringUsed;
    }

    public void setRecurringUsed(boolean recurringUsed) {
        this.recurringUsed = recurringUsed;
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

    public TLPaymentRequestedInfo getInfo() {
        return info;
    }

    public void setInfo(TLPaymentRequestedInfo info) {
        this.info = info;
    }

    public String getShippingOptionId() {
        return shippingOptionId;
    }

    public void setShippingOptionId(String shippingOptionId) {
        this.shippingOptionId = shippingOptionId;
    }

    public TLPaymentCharge getCharge() {
        return charge;
    }

    public void setCharge(TLPaymentCharge charge) {
        this.charge = charge;
    }

    public Integer getSubscriptionUntilDate() {
        return subscriptionUntilDate;
    }

    public void setSubscriptionUntilDate(Integer subscriptionUntilDate) {
        this.subscriptionUntilDate = subscriptionUntilDate;
    }
}
