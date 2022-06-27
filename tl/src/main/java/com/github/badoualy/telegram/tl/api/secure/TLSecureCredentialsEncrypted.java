package com.github.badoualy.telegram.tl.api.secure;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize;

public class TLSecureCredentialsEncrypted extends TLObject {

    public static final int CONSTRUCTOR_ID = 0x33f0ea47;

    protected TLBytes data;
    protected TLBytes hash;
    protected TLBytes secret;

    private final String _constructor = "secureCredentialsEncrypted#33f0ea47";

    public TLSecureCredentialsEncrypted() {
    }

    public TLSecureCredentialsEncrypted(TLBytes data, TLBytes hash, TLBytes secret) {
        this.data = data;
        this.hash = hash;
        this.secret = secret;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLBytes(data, stream);
        writeTLBytes(hash, stream);
        writeTLBytes(secret, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        data = readTLBytes(stream, context);
        hash = readTLBytes(stream, context);
        secret = readTLBytes(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLBytesSerializedSize(data);
        size += computeTLBytesSerializedSize(hash);
        size += computeTLBytesSerializedSize(secret);
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

    public TLBytes getData() {
        return data;
    }

    public void setData(TLBytes data) {
        this.data = data;
    }

    public TLBytes getHash() {
        return hash;
    }

    public void setHash(TLBytes hash) {
        this.hash = hash;
    }

    public TLBytes getSecret() {
        return secret;
    }

    public void setSecret(TLBytes secret) {
        this.secret = secret;
    }
}
