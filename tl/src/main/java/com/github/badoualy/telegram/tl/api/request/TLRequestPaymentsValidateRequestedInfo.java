package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputInvoice;
import com.github.badoualy.telegram.tl.api.TLPaymentRequestedInfo;
import com.github.badoualy.telegram.tl.api.payments.TLValidatedRequestedInfo;
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
public class TLRequestPaymentsValidateRequestedInfo extends TLMethod<TLValidatedRequestedInfo> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean save;

    protected TLAbsInputInvoice invoice;

    protected TLPaymentRequestedInfo info;

    private final String _constructor = "payments.validateRequestedInfo#0";

    public TLRequestPaymentsValidateRequestedInfo() {
    }

    public TLRequestPaymentsValidateRequestedInfo(boolean save, TLAbsInputInvoice invoice, TLPaymentRequestedInfo info) {
        this.save = save;
        this.invoice = invoice;
        this.info = info;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLValidatedRequestedInfo deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLValidatedRequestedInfo)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLValidatedRequestedInfo) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = save ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(invoice, stream);
        writeTLObject(info, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        save = (flags & 1) != 0;
        invoice = readTLObject(stream, context, TLAbsInputInvoice.class, -1);
        info = readTLObject(stream, context, TLPaymentRequestedInfo.class, TLPaymentRequestedInfo.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += invoice.computeSerializedSize();
        size += info.computeSerializedSize();
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

    public boolean getSave() {
        return save;
    }

    public void setSave(boolean save) {
        this.save = save;
    }

    public TLAbsInputInvoice getInvoice() {
        return invoice;
    }

    public void setInvoice(TLAbsInputInvoice invoice) {
        this.invoice = invoice;
    }

    public TLPaymentRequestedInfo getInfo() {
        return info;
    }

    public void setInfo(TLPaymentRequestedInfo info) {
        this.info = info;
    }
}
