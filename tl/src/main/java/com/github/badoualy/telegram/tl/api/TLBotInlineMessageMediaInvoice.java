package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLBotInlineMessageMediaInvoice extends TLAbsBotInlineMessage {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected boolean shippingAddressRequested;

    protected boolean test;

    protected String title;

    protected String description;

    protected TLAbsWebDocument photo;

    protected String currency;

    protected long totalAmount;

    private final String _constructor = "botInlineMessageMediaInvoice#0";

    public TLBotInlineMessageMediaInvoice() {
    }

    public TLBotInlineMessageMediaInvoice(boolean shippingAddressRequested, boolean test, String title, String description, TLAbsWebDocument photo, String currency, long totalAmount, TLAbsReplyMarkup replyMarkup) {
        this.shippingAddressRequested = shippingAddressRequested;
        this.test = test;
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.currency = currency;
        this.totalAmount = totalAmount;
        this.replyMarkup = replyMarkup;
    }

    private void computeFlags() {
        flags = 0;
        flags = shippingAddressRequested ? (flags | 2) : (flags & ~2);
        flags = test ? (flags | 8) : (flags & ~8);
        flags = photo != null ? (flags | 1) : (flags & ~1);
        flags = replyMarkup != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(title, stream);
        writeString(description, stream);
        if ((flags & 1) != 0) {
            if (photo == null) throwNullFieldException("photo", flags);
            writeTLObject(photo, stream);
        }
        writeString(currency, stream);
        writeLong(totalAmount, stream);
        if ((flags & 4) != 0) {
            if (replyMarkup == null) throwNullFieldException("replyMarkup", flags);
            writeTLObject(replyMarkup, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        shippingAddressRequested = (flags & 2) != 0;
        test = (flags & 8) != 0;
        title = readTLString(stream);
        description = readTLString(stream);
        photo = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsWebDocument.class, -1) : null;
        currency = readTLString(stream);
        totalAmount = readLong(stream);
        replyMarkup = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsReplyMarkup.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(title);
        size += computeTLStringSerializedSize(description);
        if ((flags & 1) != 0) {
            if (photo == null) throwNullFieldException("photo", flags);
            size += photo.computeSerializedSize();
        }
        size += computeTLStringSerializedSize(currency);
        size += SIZE_INT64;
        if ((flags & 4) != 0) {
            if (replyMarkup == null) throwNullFieldException("replyMarkup", flags);
            size += replyMarkup.computeSerializedSize();
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

    public boolean getShippingAddressRequested() {
        return shippingAddressRequested;
    }

    public void setShippingAddressRequested(boolean shippingAddressRequested) {
        this.shippingAddressRequested = shippingAddressRequested;
    }

    public boolean getTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
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

    public TLAbsReplyMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public void setReplyMarkup(TLAbsReplyMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
    }
}
