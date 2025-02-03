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
public class TLInputPaymentCredentialsApplePay extends TLAbsInputPaymentCredentials {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLDataJSON paymentData;

    private final String _constructor = "inputPaymentCredentialsApplePay#0";

    public TLInputPaymentCredentialsApplePay() {
    }

    public TLInputPaymentCredentialsApplePay(TLDataJSON paymentData) {
        this.paymentData = paymentData;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(paymentData, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        paymentData = readTLObject(stream, context, TLDataJSON.class, TLDataJSON.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += paymentData.computeSerializedSize();
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

    public TLDataJSON getPaymentData() {
        return paymentData;
    }

    public void setPaymentData(TLDataJSON paymentData) {
        this.paymentData = paymentData;
    }
}
