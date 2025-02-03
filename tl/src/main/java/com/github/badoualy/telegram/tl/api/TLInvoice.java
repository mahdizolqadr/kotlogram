package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLLongVector;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInvoice extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean test;

    protected boolean nameRequested;

    protected boolean phoneRequested;

    protected boolean emailRequested;

    protected boolean shippingAddressRequested;

    protected boolean flexible;

    protected boolean phoneToProvider;

    protected boolean emailToProvider;

    protected boolean recurring;

    protected String currency;

    protected TLVector<TLLabeledPrice> prices;

    protected Long maxTipAmount;

    protected TLLongVector suggestedTipAmounts;

    protected String termsUrl;

    protected Integer subscriptionPeriod;

    private final String _constructor = "invoice#0";

    public TLInvoice() {
    }

    public TLInvoice(boolean test, boolean nameRequested, boolean phoneRequested, boolean emailRequested, boolean shippingAddressRequested, boolean flexible, boolean phoneToProvider, boolean emailToProvider, boolean recurring, String currency, TLVector<TLLabeledPrice> prices, Long maxTipAmount, TLLongVector suggestedTipAmounts, String termsUrl, Integer subscriptionPeriod) {
        this.test = test;
        this.nameRequested = nameRequested;
        this.phoneRequested = phoneRequested;
        this.emailRequested = emailRequested;
        this.shippingAddressRequested = shippingAddressRequested;
        this.flexible = flexible;
        this.phoneToProvider = phoneToProvider;
        this.emailToProvider = emailToProvider;
        this.recurring = recurring;
        this.currency = currency;
        this.prices = prices;
        this.maxTipAmount = maxTipAmount;
        this.suggestedTipAmounts = suggestedTipAmounts;
        this.termsUrl = termsUrl;
        this.subscriptionPeriod = subscriptionPeriod;
    }

    private void computeFlags() {
        flags = 0;
        flags = test ? (flags | 1) : (flags & ~1);
        flags = nameRequested ? (flags | 2) : (flags & ~2);
        flags = phoneRequested ? (flags | 4) : (flags & ~4);
        flags = emailRequested ? (flags | 8) : (flags & ~8);
        flags = shippingAddressRequested ? (flags | 16) : (flags & ~16);
        flags = flexible ? (flags | 32) : (flags & ~32);
        flags = phoneToProvider ? (flags | 64) : (flags & ~64);
        flags = emailToProvider ? (flags | 128) : (flags & ~128);
        flags = recurring ? (flags | 512) : (flags & ~512);
        flags = maxTipAmount != null ? (flags | 256) : (flags & ~256);
        flags = suggestedTipAmounts != null ? (flags | 256) : (flags & ~256);
        flags = termsUrl != null ? (flags | 1024) : (flags & ~1024);
        flags = subscriptionPeriod != null ? (flags | 2048) : (flags & ~2048);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(currency, stream);
        writeTLVector(prices, stream);
        if ((flags & 256) != 0) {
            if (maxTipAmount == null) throwNullFieldException("maxTipAmount", flags);
            writeLong(maxTipAmount, stream);
        }
        if ((flags & 256) != 0) {
            if (suggestedTipAmounts == null) throwNullFieldException("suggestedTipAmounts", flags);
            writeTLVector(suggestedTipAmounts, stream);
        }
        if ((flags & 1024) != 0) {
            if (termsUrl == null) throwNullFieldException("termsUrl", flags);
            writeString(termsUrl, stream);
        }
        if ((flags & 2048) != 0) {
            if (subscriptionPeriod == null) throwNullFieldException("subscriptionPeriod", flags);
            writeInt(subscriptionPeriod, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        test = (flags & 1) != 0;
        nameRequested = (flags & 2) != 0;
        phoneRequested = (flags & 4) != 0;
        emailRequested = (flags & 8) != 0;
        shippingAddressRequested = (flags & 16) != 0;
        flexible = (flags & 32) != 0;
        phoneToProvider = (flags & 64) != 0;
        emailToProvider = (flags & 128) != 0;
        recurring = (flags & 512) != 0;
        currency = readTLString(stream);
        prices = readTLVector(stream, context);
        maxTipAmount = (flags & 256) != 0 ? readLong(stream) : null;
        suggestedTipAmounts = (flags & 256) != 0 ? readTLLongVector(stream, context) : null;
        termsUrl = (flags & 1024) != 0 ? readTLString(stream) : null;
        subscriptionPeriod = (flags & 2048) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(currency);
        size += prices.computeSerializedSize();
        if ((flags & 256) != 0) {
            if (maxTipAmount == null) throwNullFieldException("maxTipAmount", flags);
            size += SIZE_INT64;
        }
        if ((flags & 256) != 0) {
            if (suggestedTipAmounts == null) throwNullFieldException("suggestedTipAmounts", flags);
            size += suggestedTipAmounts.computeSerializedSize();
        }
        if ((flags & 1024) != 0) {
            if (termsUrl == null) throwNullFieldException("termsUrl", flags);
            size += computeTLStringSerializedSize(termsUrl);
        }
        if ((flags & 2048) != 0) {
            if (subscriptionPeriod == null) throwNullFieldException("subscriptionPeriod", flags);
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

    public boolean getTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }

    public boolean getNameRequested() {
        return nameRequested;
    }

    public void setNameRequested(boolean nameRequested) {
        this.nameRequested = nameRequested;
    }

    public boolean getPhoneRequested() {
        return phoneRequested;
    }

    public void setPhoneRequested(boolean phoneRequested) {
        this.phoneRequested = phoneRequested;
    }

    public boolean getEmailRequested() {
        return emailRequested;
    }

    public void setEmailRequested(boolean emailRequested) {
        this.emailRequested = emailRequested;
    }

    public boolean getShippingAddressRequested() {
        return shippingAddressRequested;
    }

    public void setShippingAddressRequested(boolean shippingAddressRequested) {
        this.shippingAddressRequested = shippingAddressRequested;
    }

    public boolean getFlexible() {
        return flexible;
    }

    public void setFlexible(boolean flexible) {
        this.flexible = flexible;
    }

    public boolean getPhoneToProvider() {
        return phoneToProvider;
    }

    public void setPhoneToProvider(boolean phoneToProvider) {
        this.phoneToProvider = phoneToProvider;
    }

    public boolean getEmailToProvider() {
        return emailToProvider;
    }

    public void setEmailToProvider(boolean emailToProvider) {
        this.emailToProvider = emailToProvider;
    }

    public boolean getRecurring() {
        return recurring;
    }

    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public TLVector<TLLabeledPrice> getPrices() {
        return prices;
    }

    public void setPrices(TLVector<TLLabeledPrice> prices) {
        this.prices = prices;
    }

    public Long getMaxTipAmount() {
        return maxTipAmount;
    }

    public void setMaxTipAmount(Long maxTipAmount) {
        this.maxTipAmount = maxTipAmount;
    }

    public TLLongVector getSuggestedTipAmounts() {
        return suggestedTipAmounts;
    }

    public void setSuggestedTipAmounts(TLLongVector suggestedTipAmounts) {
        this.suggestedTipAmounts = suggestedTipAmounts;
    }

    public String getTermsUrl() {
        return termsUrl;
    }

    public void setTermsUrl(String termsUrl) {
        this.termsUrl = termsUrl;
    }

    public Integer getSubscriptionPeriod() {
        return subscriptionPeriod;
    }

    public void setSubscriptionPeriod(Integer subscriptionPeriod) {
        this.subscriptionPeriod = subscriptionPeriod;
    }
}
