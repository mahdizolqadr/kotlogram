package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsEmailVerifyPurpose;
import com.github.badoualy.telegram.tl.api.account.TLSentEmailCode;
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
public class TLRequestAccountSendVerifyEmailCode extends TLMethod<TLSentEmailCode> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsEmailVerifyPurpose purpose;

    protected String email;

    private final String _constructor = "account.sendVerifyEmailCode#0";

    public TLRequestAccountSendVerifyEmailCode() {
    }

    public TLRequestAccountSendVerifyEmailCode(TLAbsEmailVerifyPurpose purpose, String email) {
        this.purpose = purpose;
        this.email = email;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLSentEmailCode deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLSentEmailCode)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLSentEmailCode) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(purpose, stream);
        writeString(email, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        purpose = readTLObject(stream, context, TLAbsEmailVerifyPurpose.class, -1);
        email = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += purpose.computeSerializedSize();
        size += computeTLStringSerializedSize(email);
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

    public TLAbsEmailVerifyPurpose getPurpose() {
        return purpose;
    }

    public void setPurpose(TLAbsEmailVerifyPurpose purpose) {
        this.purpose = purpose;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
