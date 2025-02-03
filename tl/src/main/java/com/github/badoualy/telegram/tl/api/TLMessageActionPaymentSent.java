package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLMessageActionPaymentSent extends TLAbsMessageAction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean recurringInit;

    protected boolean recurringUsed;

    protected String currency;

    protected long totalAmount;

    protected String invoiceSlug;

    protected Integer subscriptionUntilDate;

    private final String _constructor = "messageActionPaymentSent#0";

    public TLMessageActionPaymentSent() {
    }

    public TLMessageActionPaymentSent(boolean recurringInit, boolean recurringUsed, String currency, long totalAmount, String invoiceSlug, Integer subscriptionUntilDate) {
        this.recurringInit = recurringInit;
        this.recurringUsed = recurringUsed;
        this.currency = currency;
        this.totalAmount = totalAmount;
        this.invoiceSlug = invoiceSlug;
        this.subscriptionUntilDate = subscriptionUntilDate;
    }

    private void computeFlags() {
        flags = 0;
        flags = recurringInit ? (flags | 4) : (flags & ~4);
        flags = recurringUsed ? (flags | 8) : (flags & ~8);
        flags = invoiceSlug != null ? (flags | 1) : (flags & ~1);
        flags = subscriptionUntilDate != null ? (flags | 16) : (flags & ~16);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(currency, stream);
        writeLong(totalAmount, stream);
        if ((flags & 1) != 0) {
            if (invoiceSlug == null) throwNullFieldException("invoiceSlug", flags);
            writeString(invoiceSlug, stream);
        }
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
        invoiceSlug = (flags & 1) != 0 ? readTLString(stream) : null;
        subscriptionUntilDate = (flags & 16) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(currency);
        size += SIZE_INT64;
        if ((flags & 1) != 0) {
            if (invoiceSlug == null) throwNullFieldException("invoiceSlug", flags);
            size += computeTLStringSerializedSize(invoiceSlug);
        }
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

    public String getInvoiceSlug() {
        return invoiceSlug;
    }

    public void setInvoiceSlug(String invoiceSlug) {
        this.invoiceSlug = invoiceSlug;
    }

    public Integer getSubscriptionUntilDate() {
        return subscriptionUntilDate;
    }

    public void setSubscriptionUntilDate(Integer subscriptionUntilDate) {
        this.subscriptionUntilDate = subscriptionUntilDate;
    }
}
