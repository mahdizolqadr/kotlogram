package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
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
public class TLSecureData extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLBytes data;

    protected TLBytes dataHash;

    protected TLBytes secret;

    private final String _constructor = "secureData#0";

    public TLSecureData() {
    }

    public TLSecureData(TLBytes data, TLBytes dataHash, TLBytes secret) {
        this.data = data;
        this.dataHash = dataHash;
        this.secret = secret;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLBytes(data, stream);
        writeTLBytes(dataHash, stream);
        writeTLBytes(secret, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        data = readTLBytes(stream, context);
        dataHash = readTLBytes(stream, context);
        secret = readTLBytes(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLBytesSerializedSize(data);
        size += computeTLBytesSerializedSize(dataHash);
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

    public TLBytes getDataHash() {
        return dataHash;
    }

    public void setDataHash(TLBytes dataHash) {
        this.dataHash = dataHash;
    }

    public TLBytes getSecret() {
        return secret;
    }

    public void setSecret(TLBytes secret) {
        this.secret = secret;
    }
}
