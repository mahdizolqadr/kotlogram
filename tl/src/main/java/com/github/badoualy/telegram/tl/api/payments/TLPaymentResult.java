package com.github.badoualy.telegram.tl.api.payments;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
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
public class TLPaymentResult extends TLAbsPaymentResult {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsUpdates updates;

    private final String _constructor = "payments.paymentResult#0";

    public TLPaymentResult() {
    }

    public TLPaymentResult(TLAbsUpdates updates) {
        this.updates = updates;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(updates, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        updates = readTLObject(stream, context, TLAbsUpdates.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += updates.computeSerializedSize();
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

    public TLAbsUpdates getUpdates() {
        return updates;
    }

    public void setUpdates(TLAbsUpdates updates) {
        this.updates = updates;
    }
}
