package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.auth.TLAbsSentCode;
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
public class TLRequestAuthResendCode extends TLMethod<TLAbsSentCode> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected String phoneNumber;

    protected String phoneCodeHash;

    protected String reason;

    private final String _constructor = "auth.resendCode#0";

    public TLRequestAuthResendCode() {
    }

    public TLRequestAuthResendCode(String phoneNumber, String phoneCodeHash, String reason) {
        this.phoneNumber = phoneNumber;
        this.phoneCodeHash = phoneCodeHash;
        this.reason = reason;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsSentCode deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsSentCode)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsSentCode) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = reason != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(phoneNumber, stream);
        writeString(phoneCodeHash, stream);
        if ((flags & 1) != 0) {
            if (reason == null) throwNullFieldException("reason", flags);
            writeString(reason, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        phoneNumber = readTLString(stream);
        phoneCodeHash = readTLString(stream);
        reason = (flags & 1) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(phoneNumber);
        size += computeTLStringSerializedSize(phoneCodeHash);
        if ((flags & 1) != 0) {
            if (reason == null) throwNullFieldException("reason", flags);
            size += computeTLStringSerializedSize(reason);
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
