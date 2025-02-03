package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLInputSecureValue;
import com.github.badoualy.telegram.tl.api.TLSecureValue;
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
public class TLRequestAccountSaveSecureValue extends TLMethod<TLSecureValue> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLInputSecureValue value;

    protected long secureSecretId;

    private final String _constructor = "account.saveSecureValue#0";

    public TLRequestAccountSaveSecureValue() {
    }

    public TLRequestAccountSaveSecureValue(TLInputSecureValue value, long secureSecretId) {
        this.value = value;
        this.secureSecretId = secureSecretId;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLSecureValue deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLSecureValue)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLSecureValue) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(value, stream);
        writeLong(secureSecretId, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        value = readTLObject(stream, context, TLInputSecureValue.class, TLInputSecureValue.CONSTRUCTOR_ID);
        secureSecretId = readLong(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += value.computeSerializedSize();
        size += SIZE_INT64;
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

    public TLInputSecureValue getValue() {
        return value;
    }

    public void setValue(TLInputSecureValue value) {
        this.value = value;
    }

    public long getSecureSecretId() {
        return secureSecretId;
    }

    public void setSecureSecretId(long secureSecretId) {
        this.secureSecretId = secureSecretId;
    }
}
