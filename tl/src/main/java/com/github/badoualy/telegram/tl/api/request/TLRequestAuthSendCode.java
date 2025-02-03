package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLCodeSettings;
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
public class TLRequestAuthSendCode extends TLMethod<TLAbsSentCode> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected String phoneNumber;

    protected int apiId;

    protected String apiHash;

    protected TLCodeSettings settings;

    private final String _constructor = "auth.sendCode#0";

    public TLRequestAuthSendCode() {
    }

    public TLRequestAuthSendCode(String phoneNumber, int apiId, String apiHash, TLCodeSettings settings) {
        this.phoneNumber = phoneNumber;
        this.apiId = apiId;
        this.apiHash = apiHash;
        this.settings = settings;
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

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(phoneNumber, stream);
        writeInt(apiId, stream);
        writeString(apiHash, stream);
        writeTLObject(settings, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        phoneNumber = readTLString(stream);
        apiId = readInt(stream);
        apiHash = readTLString(stream);
        settings = readTLObject(stream, context, TLCodeSettings.class, TLCodeSettings.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(phoneNumber);
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(apiHash);
        size += settings.computeSerializedSize();
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

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

    public String getApiHash() {
        return apiHash;
    }

    public void setApiHash(String apiHash) {
        this.apiHash = apiHash;
    }

    public TLCodeSettings getSettings() {
        return settings;
    }

    public void setSettings(TLCodeSettings settings) {
        this.settings = settings;
    }
}
