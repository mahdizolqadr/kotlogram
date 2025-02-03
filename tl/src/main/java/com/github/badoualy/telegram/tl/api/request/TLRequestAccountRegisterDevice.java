package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLLongVector;
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
public class TLRequestAccountRegisterDevice extends TLMethod<TLBool> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean noMuted;

    protected int tokenType;

    protected String token;

    protected boolean appSandbox;

    protected TLBytes secret;

    protected TLLongVector otherUids;

    private final String _constructor = "account.registerDevice#0";

    public TLRequestAccountRegisterDevice() {
    }

    public TLRequestAccountRegisterDevice(boolean noMuted, int tokenType, String token, boolean appSandbox, TLBytes secret, TLLongVector otherUids) {
        this.noMuted = noMuted;
        this.tokenType = tokenType;
        this.token = token;
        this.appSandbox = appSandbox;
        this.secret = secret;
        this.otherUids = otherUids;
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
        flags = noMuted ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(tokenType, stream);
        writeString(token, stream);
        writeBoolean(appSandbox, stream);
        writeTLBytes(secret, stream);
        writeTLVector(otherUids, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        noMuted = (flags & 1) != 0;
        tokenType = readInt(stream);
        token = readTLString(stream);
        appSandbox = readTLBool(stream);
        secret = readTLBytes(stream, context);
        otherUids = readTLLongVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(token);
        size += SIZE_BOOLEAN;
        size += computeTLBytesSerializedSize(secret);
        size += otherUids.computeSerializedSize();
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

    public boolean getNoMuted() {
        return noMuted;
    }

    public void setNoMuted(boolean noMuted) {
        this.noMuted = noMuted;
    }

    public int getTokenType() {
        return tokenType;
    }

    public void setTokenType(int tokenType) {
        this.tokenType = tokenType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean getAppSandbox() {
        return appSandbox;
    }

    public void setAppSandbox(boolean appSandbox) {
        this.appSandbox = appSandbox;
    }

    public TLBytes getSecret() {
        return secret;
    }

    public void setSecret(TLBytes secret) {
        this.secret = secret;
    }

    public TLLongVector getOtherUids() {
        return otherUids;
    }

    public void setOtherUids(TLLongVector otherUids) {
        this.otherUids = otherUids;
    }
}
