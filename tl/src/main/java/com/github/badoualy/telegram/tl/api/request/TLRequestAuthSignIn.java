package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsEmailVerification;
import com.github.badoualy.telegram.tl.api.auth.TLAbsAuthorization;
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
public class TLRequestAuthSignIn extends TLMethod<TLAbsAuthorization> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected String phoneNumber;

    protected String phoneCodeHash;

    protected String phoneCode;

    protected TLAbsEmailVerification emailVerification;

    private final String _constructor = "auth.signIn#0";

    public TLRequestAuthSignIn() {
    }

    public TLRequestAuthSignIn(String phoneNumber, String phoneCodeHash, String phoneCode, TLAbsEmailVerification emailVerification) {
        this.phoneNumber = phoneNumber;
        this.phoneCodeHash = phoneCodeHash;
        this.phoneCode = phoneCode;
        this.emailVerification = emailVerification;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsAuthorization deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsAuthorization)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsAuthorization) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = phoneCode != null ? (flags | 1) : (flags & ~1);
        flags = emailVerification != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(phoneNumber, stream);
        writeString(phoneCodeHash, stream);
        if ((flags & 1) != 0) {
            if (phoneCode == null) throwNullFieldException("phoneCode", flags);
            writeString(phoneCode, stream);
        }
        if ((flags & 2) != 0) {
            if (emailVerification == null) throwNullFieldException("emailVerification", flags);
            writeTLObject(emailVerification, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        phoneNumber = readTLString(stream);
        phoneCodeHash = readTLString(stream);
        phoneCode = (flags & 1) != 0 ? readTLString(stream) : null;
        emailVerification = (flags & 2) != 0 ? readTLObject(stream, context, TLAbsEmailVerification.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(phoneNumber);
        size += computeTLStringSerializedSize(phoneCodeHash);
        if ((flags & 1) != 0) {
            if (phoneCode == null) throwNullFieldException("phoneCode", flags);
            size += computeTLStringSerializedSize(phoneCode);
        }
        if ((flags & 2) != 0) {
            if (emailVerification == null) throwNullFieldException("emailVerification", flags);
            size += emailVerification.computeSerializedSize();
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneCodeHash() {
        return phoneCodeHash;
    }

    public void setPhoneCodeHash(String phoneCodeHash) {
        this.phoneCodeHash = phoneCodeHash;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public TLAbsEmailVerification getEmailVerification() {
        return emailVerification;
    }

    public void setEmailVerification(TLAbsEmailVerification emailVerification) {
        this.emailVerification = emailVerification;
    }
}
