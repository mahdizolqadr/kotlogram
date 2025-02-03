package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputInvoice;
import com.github.badoualy.telegram.tl.api.TLAbsInputPaymentCredentials;
import com.github.badoualy.telegram.tl.api.payments.TLAbsPaymentResult;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLRequestPaymentsSendPaymentForm extends TLMethod<TLAbsPaymentResult> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected long formId;

    protected TLAbsInputInvoice invoice;

    protected String requestedInfoId;

    protected String shippingOptionId;

    protected TLAbsInputPaymentCredentials credentials;

    protected Long tipAmount;

    private final String _constructor = "payments.sendPaymentForm#0";

    public TLRequestPaymentsSendPaymentForm() {
    }

    public TLRequestPaymentsSendPaymentForm(long formId, TLAbsInputInvoice invoice, String requestedInfoId, String shippingOptionId, TLAbsInputPaymentCredentials credentials, Long tipAmount) {
        this.formId = formId;
        this.invoice = invoice;
        this.requestedInfoId = requestedInfoId;
        this.shippingOptionId = shippingOptionId;
        this.credentials = credentials;
        this.tipAmount = tipAmount;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsPaymentResult deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsPaymentResult)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsPaymentResult) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = requestedInfoId != null ? (flags | 1) : (flags & ~1);
        flags = shippingOptionId != null ? (flags | 2) : (flags & ~2);
        flags = tipAmount != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(formId, stream);
        writeTLObject(invoice, stream);
        if ((flags & 1) != 0) {
            if (requestedInfoId == null) throwNullFieldException("requestedInfoId", flags);
            writeString(requestedInfoId, stream);
        }
        if ((flags & 2) != 0) {
            if (shippingOptionId == null) throwNullFieldException("shippingOptionId", flags);
            writeString(shippingOptionId, stream);
        }
        writeTLObject(credentials, stream);
        if ((flags & 4) != 0) {
            if (tipAmount == null) throwNullFieldException("tipAmount", flags);
            writeLong(tipAmount, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        formId = readLong(stream);
        invoice = readTLObject(stream, context, TLAbsInputInvoice.class, -1);
        requestedInfoId = (flags & 1) != 0 ? readTLString(stream) : null;
        shippingOptionId = (flags & 2) != 0 ? readTLString(stream) : null;
        credentials = readTLObject(stream, context, TLAbsInputPaymentCredentials.class, -1);
        tipAmount = (flags & 4) != 0 ? readLong(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += invoice.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (requestedInfoId == null) throwNullFieldException("requestedInfoId", flags);
            size += computeTLStringSerializedSize(requestedInfoId);
        }
        if ((flags & 2) != 0) {
            if (shippingOptionId == null) throwNullFieldException("shippingOptionId", flags);
            size += computeTLStringSerializedSize(shippingOptionId);
        }
        size += credentials.computeSerializedSize();
        if ((flags & 4) != 0) {
            if (tipAmount == null) throwNullFieldException("tipAmount", flags);
            size += SIZE_INT64;
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

    public long getFormId() {
        return formId;
    }

    public void setFormId(long formId) {
        this.formId = formId;
    }

    public TLAbsInputInvoice getInvoice() {
        return invoice;
    }

    public void setInvoice(TLAbsInputInvoice invoice) {
        this.invoice = invoice;
    }

    public String getRequestedInfoId() {
        return requestedInfoId;
    }

    public void setRequestedInfoId(String requestedInfoId) {
        this.requestedInfoId = requestedInfoId;
    }

    public String getShippingOptionId() {
        return shippingOptionId;
    }

    public void setShippingOptionId(String shippingOptionId) {
        this.shippingOptionId = shippingOptionId;
    }

    public TLAbsInputPaymentCredentials getCredentials() {
        return credentials;
    }

    public void setCredentials(TLAbsInputPaymentCredentials credentials) {
        this.credentials = credentials;
    }

    public Long getTipAmount() {
        return tipAmount;
    }

    public void setTipAmount(Long tipAmount) {
        this.tipAmount = tipAmount;
    }
}
