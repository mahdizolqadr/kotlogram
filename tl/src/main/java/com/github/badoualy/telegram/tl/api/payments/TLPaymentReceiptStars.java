package com.github.badoualy.telegram.tl.api.payments;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.api.TLAbsWebDocument;
import com.github.badoualy.telegram.tl.api.TLInvoice;
import com.github.badoualy.telegram.tl.core.TLVector;
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
public class TLPaymentReceiptStars extends TLAbsPaymentReceipt {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected String transactionId;

    private final String _constructor = "payments.paymentReceiptStars#0";

    public TLPaymentReceiptStars() {
    }

    public TLPaymentReceiptStars(int date, long botId, String title, String description, TLAbsWebDocument photo, TLInvoice invoice, String currency, long totalAmount, String transactionId, TLVector<TLAbsUser> users) {
        this.date = date;
        this.botId = botId;
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.invoice = invoice;
        this.currency = currency;
        this.totalAmount = totalAmount;
        this.transactionId = transactionId;
        this.users = users;
    }

    private void computeFlags() {
        flags = 0;
        flags = photo != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(date, stream);
        writeLong(botId, stream);
        writeString(title, stream);
        writeString(description, stream);
        if ((flags & 4) != 0) {
            if (photo == null) throwNullFieldException("photo", flags);
            writeTLObject(photo, stream);
        }
        writeTLObject(invoice, stream);
        writeString(currency, stream);
        writeLong(totalAmount, stream);
        writeString(transactionId, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        date = readInt(stream);
        botId = readLong(stream);
        title = readTLString(stream);
        description = readTLString(stream);
        photo = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsWebDocument.class, -1) : null;
        invoice = readTLObject(stream, context, TLInvoice.class, TLInvoice.CONSTRUCTOR_ID);
        currency = readTLString(stream);
        totalAmount = readLong(stream);
        transactionId = readTLString(stream);
        users = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(title);
        size += computeTLStringSerializedSize(description);
        if ((flags & 4) != 0) {
            if (photo == null) throwNullFieldException("photo", flags);
            size += photo.computeSerializedSize();
        }
        size += invoice.computeSerializedSize();
        size += computeTLStringSerializedSize(currency);
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(transactionId);
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

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }
}
