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
public class TLMessageMediaInvoice extends TLAbsMessageMedia {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean shippingAddressRequested;

    protected boolean test;

    protected String title;

    protected String description;

    protected TLAbsWebDocument photo;

    protected Integer receiptMsgId;

    protected String currency;

    protected long totalAmount;

    protected String startParam;

    protected TLAbsMessageExtendedMedia extendedMedia;

    private final String _constructor = "messageMediaInvoice#0";

    public TLMessageMediaInvoice() {
    }

    public TLMessageMediaInvoice(boolean shippingAddressRequested, boolean test, String title, String description, TLAbsWebDocument photo, Integer receiptMsgId, String currency, long totalAmount, String startParam, TLAbsMessageExtendedMedia extendedMedia) {
        this.shippingAddressRequested = shippingAddressRequested;
        this.test = test;
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.receiptMsgId = receiptMsgId;
        this.currency = currency;
        this.totalAmount = totalAmount;
        this.startParam = startParam;
        this.extendedMedia = extendedMedia;
    }

    private void computeFlags() {
        flags = 0;
        flags = shippingAddressRequested ? (flags | 2) : (flags & ~2);
        flags = test ? (flags | 8) : (flags & ~8);
        flags = photo != null ? (flags | 1) : (flags & ~1);
        flags = receiptMsgId != null ? (flags | 4) : (flags & ~4);
        flags = extendedMedia != null ? (flags | 16) : (flags & ~16);
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
        if ((flags & 4) != 0) {
            if (receiptMsgId == null) throwNullFieldException("receiptMsgId", flags);
            writeInt(receiptMsgId, stream);
        }
        writeString(currency, stream);
        writeLong(totalAmount, stream);
        writeString(startParam, stream);
        if ((flags & 16) != 0) {
            if (extendedMedia == null) throwNullFieldException("extendedMedia", flags);
            writeTLObject(extendedMedia, stream);
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
        receiptMsgId = (flags & 4) != 0 ? readInt(stream) : null;
        currency = readTLString(stream);
        totalAmount = readLong(stream);
        startParam = readTLString(stream);
        extendedMedia = (flags & 16) != 0 ? readTLObject(stream, context, TLAbsMessageExtendedMedia.class, -1) : null;
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
        if ((flags & 4) != 0) {
            if (receiptMsgId == null) throwNullFieldException("receiptMsgId", flags);
            size += SIZE_INT32;
        }
        size += computeTLStringSerializedSize(currency);
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(startParam);
        if ((flags & 16) != 0) {
            if (extendedMedia == null) throwNullFieldException("extendedMedia", flags);
            size += extendedMedia.computeSerializedSize();
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

    public Integer getReceiptMsgId() {
        return receiptMsgId;
    }

    public void setReceiptMsgId(Integer receiptMsgId) {
        this.receiptMsgId = receiptMsgId;
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

    public String getStartParam() {
        return startParam;
    }

    public void setStartParam(String startParam) {
        this.startParam = startParam;
    }

    public TLAbsMessageExtendedMedia getExtendedMedia() {
        return extendedMedia;
    }

    public void setExtendedMedia(TLAbsMessageExtendedMedia extendedMedia) {
        this.extendedMedia = extendedMedia;
    }
}
