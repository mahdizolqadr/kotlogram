package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
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
public class TLSecurePasswordKdfAlgoSHA512 extends TLAbsSecurePasswordKdfAlgo {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLBytes salt;

    private final String _constructor = "securePasswordKdfAlgoSHA512#0";

    public TLSecurePasswordKdfAlgoSHA512() {
    }

    public TLSecurePasswordKdfAlgoSHA512(TLBytes salt) {
        this.salt = salt;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLBytes(salt, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        salt = readTLBytes(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLBytesSerializedSize(salt);
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

    public TLBytes getSalt() {
        return salt;
    }

    public void setSalt(TLBytes salt) {
        this.salt = salt;
    }
}
