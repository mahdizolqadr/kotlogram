package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputInvoice;
import com.github.badoualy.telegram.tl.api.TLDataJSON;
import com.github.badoualy.telegram.tl.api.payments.TLAbsPaymentForm;
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
public class TLRequestPaymentsGetPaymentForm extends TLMethod<TLAbsPaymentForm> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLAbsInputInvoice invoice;

    protected TLDataJSON themeParams;

    private final String _constructor = "payments.getPaymentForm#0";

    public TLRequestPaymentsGetPaymentForm() {
    }

    public TLRequestPaymentsGetPaymentForm(TLAbsInputInvoice invoice, TLDataJSON themeParams) {
        this.invoice = invoice;
        this.themeParams = themeParams;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsPaymentForm deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsPaymentForm)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsPaymentForm) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = themeParams != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(invoice, stream);
        if ((flags & 1) != 0) {
            if (themeParams == null) throwNullFieldException("themeParams", flags);
            writeTLObject(themeParams, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        invoice = readTLObject(stream, context, TLAbsInputInvoice.class, -1);
        themeParams = (flags & 1) != 0 ? readTLObject(stream, context, TLDataJSON.class, TLDataJSON.CONSTRUCTOR_ID) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += invoice.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (themeParams == null) throwNullFieldException("themeParams", flags);
            size += themeParams.computeSerializedSize();
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

    public TLAbsInputInvoice getInvoice() {
        return invoice;
    }

    public void setInvoice(TLAbsInputInvoice invoice) {
        this.invoice = invoice;
    }

    public TLDataJSON getThemeParams() {
        return themeParams;
    }

    public void setThemeParams(TLDataJSON themeParams) {
        this.themeParams = themeParams;
    }
}
