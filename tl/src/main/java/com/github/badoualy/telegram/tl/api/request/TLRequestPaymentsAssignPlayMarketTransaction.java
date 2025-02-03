package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputStorePaymentPurpose;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
import com.github.badoualy.telegram.tl.api.TLDataJSON;
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
public class TLRequestPaymentsAssignPlayMarketTransaction extends TLMethod<TLAbsUpdates> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLDataJSON receipt;

    protected TLAbsInputStorePaymentPurpose purpose;

    private final String _constructor = "payments.assignPlayMarketTransaction#0";

    public TLRequestPaymentsAssignPlayMarketTransaction() {
    }

    public TLRequestPaymentsAssignPlayMarketTransaction(TLDataJSON receipt, TLAbsInputStorePaymentPurpose purpose) {
        this.receipt = receipt;
        this.purpose = purpose;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsUpdates deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsUpdates)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsUpdates) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(receipt, stream);
        writeTLObject(purpose, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        receipt = readTLObject(stream, context, TLDataJSON.class, TLDataJSON.CONSTRUCTOR_ID);
        purpose = readTLObject(stream, context, TLAbsInputStorePaymentPurpose.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += receipt.computeSerializedSize();
        size += purpose.computeSerializedSize();
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

    public TLDataJSON getReceipt() {
        return receipt;
    }

    public void setReceipt(TLDataJSON receipt) {
        this.receipt = receipt;
    }

    public TLAbsInputStorePaymentPurpose getPurpose() {
        return purpose;
    }

    public void setPurpose(TLAbsInputStorePaymentPurpose purpose) {
        this.purpose = purpose;
    }
}
