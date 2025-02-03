package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputInvoice;
import com.github.badoualy.telegram.tl.api.payments.TLAbsPaymentResult;
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
public class TLRequestPaymentsSendStarsForm extends TLMethod<TLAbsPaymentResult> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected long formId;

    protected TLAbsInputInvoice invoice;

    private final String _constructor = "payments.sendStarsForm#0";

    public TLRequestPaymentsSendStarsForm() {
    }

    public TLRequestPaymentsSendStarsForm(long formId, TLAbsInputInvoice invoice) {
        this.formId = formId;
        this.invoice = invoice;
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

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(formId, stream);
        writeTLObject(invoice, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        formId = readLong(stream);
        invoice = readTLObject(stream, context, TLAbsInputInvoice.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += invoice.computeSerializedSize();
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
}
