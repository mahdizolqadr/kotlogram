package com.github.badoualy.telegram.tl.api.payments;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.api.TLAbsWebDocument;
import com.github.badoualy.telegram.tl.api.TLInvoice;
import com.github.badoualy.telegram.tl.api.TLPaymentRequestedInfo;
import com.github.badoualy.telegram.tl.api.TLShippingOption;
import com.github.badoualy.telegram.tl.core.TLVector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPaymentReceipt extends TLAbsPaymentReceipt {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected long providerId;

    protected TLPaymentRequestedInfo info;

    protected TLShippingOption shipping;

    protected Long tipAmount;

    protected String credentialsTitle;

    private final String _constructor = "payments.paymentReceipt#0";

    public TLPaymentReceipt() {
    }

    public TLPaymentReceipt(int date, long botId, long providerId, String title, String description, TLAbsWebDocument photo, TLInvoice invoice, TLPaymentRequestedInfo info, TLShippingOption shipping, Long tipAmount, String currency, long totalAmount, String credentialsTitle, TLVector<TLAbsUser> users) {
        this.date = date;
        this.botId = botId;
        this.providerId = providerId;
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.invoice = invoice;
        this.info = info;
        this.shipping = shipping;
        this.tipAmount = tipAmount;
        this.currency = currency;
        this.totalAmount = totalAmount;
        this.credentialsTitle = credentialsTitle;
        this.users = users;
    }

    private void computeFlags() {
        flags = 0;
        flags = photo != null ? (flags | 4) : (flags & ~4);
        flags = info != null ? (flags | 1) : (flags & ~1);
        flags = shipping != null ? (flags | 2) : (flags & ~2);
        flags = tipAmount != null ? (flags | 8) : (flags & ~8);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(date, stream);
        writeLong(botId, stream);
        writeLong(providerId, stream);
        writeString(title, stream);
        writeString(description, stream);
        if ((flags & 4) != 0) {
            if (photo == null) throwNullFieldException("photo", flags);
            writeTLObject(photo, stream);
        }
        writeTLObject(invoice, stream);
        if ((flags & 1) != 0) {
            if (info == null) throwNullFieldException("info", flags);
            writeTLObject(info, stream);
        }
        if ((flags & 2) != 0) {
            if (shipping == null) throwNullFieldException("shipping", flags);
            writeTLObject(shipping, stream);
        }
        if ((flags & 8) != 0) {
            if (tipAmount == null) throwNullFieldException("tipAmount", flags);
            writeLong(tipAmount, stream);
        }
        writeString(currency, stream);
        writeLong(totalAmount, stream);
        writeString(credentialsTitle, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        date = readInt(stream);
        botId = readLong(stream);
        providerId = readLong(stream);
        title = readTLString(stream);
        description = readTLString(stream);
        photo = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsWebDocument.class, -1) : null;
        invoice = readTLObject(stream, context, TLInvoice.class, TLInvoice.CONSTRUCTOR_ID);
        info = (flags & 1) != 0 ? readTLObject(stream, context, TLPaymentRequestedInfo.class, TLPaymentRequestedInfo.CONSTRUCTOR_ID) : null;
        shipping = (flags & 2) != 0 ? readTLObject(stream, context, TLShippingOption.class, TLShippingOption.CONSTRUCTOR_ID) : null;
        tipAmount = (flags & 8) != 0 ? readLong(stream) : null;
        currency = readTLString(stream);
        totalAmount = readLong(stream);
        credentialsTitle = readTLString(stream);
        users = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(title);
        size += computeTLStringSerializedSize(description);
        if ((flags & 4) != 0) {
            if (photo == null) throwNullFieldException("photo", flags);
            size += photo.computeSerializedSize();
        }
        size += invoice.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (info == null) throwNullFieldException("info", flags);
            size += info.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (shipping == null) throwNullFieldException("shipping", flags);
            size += shipping.computeSerializedSize();
        }
        if ((flags & 8) != 0) {
            if (tipAmount == null) throwNullFieldException("tipAmount", flags);
            size += SIZE_INT64;
        }
        size += computeTLStringSerializedSize(currency);
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(credentialsTitle);
        size += users.computeSerializedSize();
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

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public long getBotId() {
        return botId;
    }

    public void setBotId(long botId) {
        this.botId = botId;
    }

    public long getProviderId() {
        return providerId;
    }

    public void setProviderId(long providerId) {
        this.providerId = providerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TLAbsWebDocument getPhoto() {
        return photo;
    }

    public void setPhoto(TLAbsWebDocument photo) {
        this.photo = photo;
    }

    public TLInvoice getInvoice() {
        return invoice;
    }

    public void setInvoice(TLInvoice invoice) {
        this.invoice = invoice;
    }

    public TLPaymentRequestedInfo getInfo() {
        return info;
    }

    public void setInfo(TLPaymentRequestedInfo info) {
        this.info = info;
    }

    public TLShippingOption getShipping() {
        return shipping;
    }

    public void setShipping(TLShippingOption shipping) {
        this.shipping = shipping;
    }

    public Long getTipAmount() {
        return tipAmount;
    }

    public void setTipAmount(Long tipAmount) {
        this.tipAmount = tipAmount;
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

    public String getCredentialsTitle() {
        return credentialsTitle;
    }

    public void setCredentialsTitle(String credentialsTitle) {
        this.credentialsTitle = credentialsTitle;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }
}
