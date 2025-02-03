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
public class TLEmailVerifyPurposeLoginSetup extends TLAbsEmailVerifyPurpose {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected String phoneNumber;

    protected String phoneCodeHash;

    private final String _constructor = "emailVerifyPurposeLoginSetup#0";

    public TLEmailVerifyPurposeLoginSetup() {
    }

    public TLEmailVerifyPurposeLoginSetup(String phoneNumber, String phoneCodeHash) {
        this.phoneNumber = phoneNumber;
        this.phoneCodeHash = phoneCodeHash;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(phoneNumber, stream);
        writeString(phoneCodeHash, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        phoneNumber = readTLString(stream);
        phoneCodeHash = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(phoneNumber);
        size += computeTLStringSerializedSize(phoneCodeHash);
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
}
