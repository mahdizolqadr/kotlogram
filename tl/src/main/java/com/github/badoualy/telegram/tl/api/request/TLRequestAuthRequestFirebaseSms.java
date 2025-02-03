package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBool;
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
public class TLRequestAuthRequestFirebaseSms extends TLMethod<TLBool> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected String phoneNumber;

    protected String phoneCodeHash;

    protected String safetyNetToken;

    protected String playIntegrityToken;

    protected String iosPushSecret;

    private final String _constructor = "auth.requestFirebaseSms#0";

    public TLRequestAuthRequestFirebaseSms() {
    }

    public TLRequestAuthRequestFirebaseSms(String phoneNumber, String phoneCodeHash, String safetyNetToken, String playIntegrityToken, String iosPushSecret) {
        this.phoneNumber = phoneNumber;
        this.phoneCodeHash = phoneCodeHash;
        this.safetyNetToken = safetyNetToken;
        this.playIntegrityToken = playIntegrityToken;
        this.iosPushSecret = iosPushSecret;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLBool)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLBool) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = safetyNetToken != null ? (flags | 1) : (flags & ~1);
        flags = playIntegrityToken != null ? (flags | 4) : (flags & ~4);
        flags = iosPushSecret != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(phoneNumber, stream);
        writeString(phoneCodeHash, stream);
        if ((flags & 1) != 0) {
            if (safetyNetToken == null) throwNullFieldException("safetyNetToken", flags);
            writeString(safetyNetToken, stream);
        }
        if ((flags & 4) != 0) {
            if (playIntegrityToken == null) throwNullFieldException("playIntegrityToken", flags);
            writeString(playIntegrityToken, stream);
        }
        if ((flags & 2) != 0) {
            if (iosPushSecret == null) throwNullFieldException("iosPushSecret", flags);
            writeString(iosPushSecret, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        phoneNumber = readTLString(stream);
        phoneCodeHash = readTLString(stream);
        safetyNetToken = (flags & 1) != 0 ? readTLString(stream) : null;
        playIntegrityToken = (flags & 4) != 0 ? readTLString(stream) : null;
        iosPushSecret = (flags & 2) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(phoneNumber);
        size += computeTLStringSerializedSize(phoneCodeHash);
        if ((flags & 1) != 0) {
            if (safetyNetToken == null) throwNullFieldException("safetyNetToken", flags);
            size += computeTLStringSerializedSize(safetyNetToken);
        }
        if ((flags & 4) != 0) {
            if (playIntegrityToken == null) throwNullFieldException("playIntegrityToken", flags);
            size += computeTLStringSerializedSize(playIntegrityToken);
        }
        if ((flags & 2) != 0) {
            if (iosPushSecret == null) throwNullFieldException("iosPushSecret", flags);
            size += computeTLStringSerializedSize(iosPushSecret);
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

    public String getSafetyNetToken() {
        return safetyNetToken;
    }

    public void setSafetyNetToken(String safetyNetToken) {
        this.safetyNetToken = safetyNetToken;
    }

    public String getPlayIntegrityToken() {
        return playIntegrityToken;
    }

    public void setPlayIntegrityToken(String playIntegrityToken) {
        this.playIntegrityToken = playIntegrityToken;
    }

    public String getIosPushSecret() {
        return iosPushSecret;
    }

    public void setIosPushSecret(String iosPushSecret) {
        this.iosPushSecret = iosPushSecret;
    }
}
