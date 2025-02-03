package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLBytes;
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
public class TLRequestAuthBindTempAuthKey extends TLMethod<TLBool> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected long permAuthKeyId;

    protected long nonce;

    protected int expiresAt;

    protected TLBytes encryptedMessage;

    private final String _constructor = "auth.bindTempAuthKey#0";

    public TLRequestAuthBindTempAuthKey() {
    }

    public TLRequestAuthBindTempAuthKey(long permAuthKeyId, long nonce, int expiresAt, TLBytes encryptedMessage) {
        this.permAuthKeyId = permAuthKeyId;
        this.nonce = nonce;
        this.expiresAt = expiresAt;
        this.encryptedMessage = encryptedMessage;
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

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(permAuthKeyId, stream);
        writeLong(nonce, stream);
        writeInt(expiresAt, stream);
        writeTLBytes(encryptedMessage, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        permAuthKeyId = readLong(stream);
        nonce = readLong(stream);
        expiresAt = readInt(stream);
        encryptedMessage = readTLBytes(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += computeTLBytesSerializedSize(encryptedMessage);
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

    public long getPermAuthKeyId() {
        return permAuthKeyId;
    }

    public void setPermAuthKeyId(long permAuthKeyId) {
        this.permAuthKeyId = permAuthKeyId;
    }

    public long getNonce() {
        return nonce;
    }

    public void setNonce(long nonce) {
        this.nonce = nonce;
    }

    public int getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(int expiresAt) {
        this.expiresAt = expiresAt;
    }

    public TLBytes getEncryptedMessage() {
        return encryptedMessage;
    }

    public void setEncryptedMessage(TLBytes encryptedMessage) {
        this.encryptedMessage = encryptedMessage;
    }
}
