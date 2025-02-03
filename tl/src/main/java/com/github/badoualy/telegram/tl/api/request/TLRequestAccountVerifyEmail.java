package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsEmailVerification;
import com.github.badoualy.telegram.tl.api.TLAbsEmailVerifyPurpose;
import com.github.badoualy.telegram.tl.api.account.TLAbsEmailVerified;
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
public class TLRequestAccountVerifyEmail extends TLMethod<TLAbsEmailVerified> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsEmailVerifyPurpose purpose;

    protected TLAbsEmailVerification verification;

    private final String _constructor = "account.verifyEmail#0";

    public TLRequestAccountVerifyEmail() {
    }

    public TLRequestAccountVerifyEmail(TLAbsEmailVerifyPurpose purpose, TLAbsEmailVerification verification) {
        this.purpose = purpose;
        this.verification = verification;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsEmailVerified deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsEmailVerified)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsEmailVerified) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(purpose, stream);
        writeTLObject(verification, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        purpose = readTLObject(stream, context, TLAbsEmailVerifyPurpose.class, -1);
        verification = readTLObject(stream, context, TLAbsEmailVerification.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += purpose.computeSerializedSize();
        size += verification.computeSerializedSize();
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

    public TLAbsEmailVerification getVerification() {
        return verification;
    }

    public void setVerification(TLAbsEmailVerification verification) {
        this.verification = verification;
    }
}
