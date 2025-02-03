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
public class TLSecureSecretSettings extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsSecurePasswordKdfAlgo secureAlgo;

    protected TLBytes secureSecret;

    protected long secureSecretId;

    private final String _constructor = "secureSecretSettings#0";

    public TLSecureSecretSettings() {
    }

    public TLSecureSecretSettings(TLAbsSecurePasswordKdfAlgo secureAlgo, TLBytes secureSecret, long secureSecretId) {
        this.secureAlgo = secureAlgo;
        this.secureSecret = secureSecret;
        this.secureSecretId = secureSecretId;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(secureAlgo, stream);
        writeTLBytes(secureSecret, stream);
        writeLong(secureSecretId, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        secureAlgo = readTLObject(stream, context, TLAbsSecurePasswordKdfAlgo.class, -1);
        secureSecret = readTLBytes(stream, context);
        secureSecretId = readLong(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += secureAlgo.computeSerializedSize();
        size += computeTLBytesSerializedSize(secureSecret);
        size += SIZE_INT64;
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

    public TLAbsSecurePasswordKdfAlgo getSecureAlgo() {
        return secureAlgo;
    }

    public void setSecureAlgo(TLAbsSecurePasswordKdfAlgo secureAlgo) {
        this.secureAlgo = secureAlgo;
    }

    public TLBytes getSecureSecret() {
        return secureSecret;
    }

    public void setSecureSecret(TLBytes secureSecret) {
        this.secureSecret = secureSecret;
    }

    public long getSecureSecretId() {
        return secureSecretId;
    }

    public void setSecureSecretId(long secureSecretId) {
        this.secureSecretId = secureSecretId;
    }
}
