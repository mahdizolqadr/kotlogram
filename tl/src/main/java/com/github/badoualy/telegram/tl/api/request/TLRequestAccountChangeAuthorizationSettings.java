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
public class TLRequestAccountChangeAuthorizationSettings extends TLMethod<TLBool> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean confirmed;

    protected long hash;

    protected boolean encryptedRequestsDisabled;

    protected boolean callRequestsDisabled;

    private final String _constructor = "account.changeAuthorizationSettings#0";

    public TLRequestAccountChangeAuthorizationSettings() {
    }

    public TLRequestAccountChangeAuthorizationSettings(boolean confirmed, long hash, boolean encryptedRequestsDisabled, boolean callRequestsDisabled) {
        this.confirmed = confirmed;
        this.hash = hash;
        this.encryptedRequestsDisabled = encryptedRequestsDisabled;
        this.callRequestsDisabled = callRequestsDisabled;
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
        flags = confirmed ? (flags | 8) : (flags & ~8);
        flags = encryptedRequestsDisabled != null ? (flags | 1) : (flags & ~1);
        flags = callRequestsDisabled != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(hash, stream);
        if ((flags & 1) != 0) {
            writeBoolean(encryptedRequestsDisabled, stream);
        }
        if ((flags & 2) != 0) {
            writeBoolean(callRequestsDisabled, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        confirmed = (flags & 8) != 0;
        hash = readLong(stream);
        encryptedRequestsDisabled = (flags & 1) != 0 ? readTLBool(stream) : false;
        callRequestsDisabled = (flags & 2) != 0 ? readTLBool(stream) : false;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        if ((flags & 1) != 0) {
            size += SIZE_BOOLEAN;
        }
        if ((flags & 2) != 0) {
            size += SIZE_BOOLEAN;
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

    public boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public long getHash() {
        return hash;
    }

    public void setHash(long hash) {
        this.hash = hash;
    }

    public boolean getEncryptedRequestsDisabled() {
        return encryptedRequestsDisabled;
    }

    public void setEncryptedRequestsDisabled(boolean encryptedRequestsDisabled) {
        this.encryptedRequestsDisabled = encryptedRequestsDisabled;
    }

    public boolean getCallRequestsDisabled() {
        return callRequestsDisabled;
    }

    public void setCallRequestsDisabled(boolean callRequestsDisabled) {
        this.callRequestsDisabled = callRequestsDisabled;
    }
}
