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
public class TLInputPaymentCredentialsSaved extends TLAbsInputPaymentCredentials {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected String id;

    protected TLBytes tmpPassword;

    private final String _constructor = "inputPaymentCredentialsSaved#0";

    public TLInputPaymentCredentialsSaved() {
    }

    public TLInputPaymentCredentialsSaved(String id, TLBytes tmpPassword) {
        this.id = id;
        this.tmpPassword = tmpPassword;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(id, stream);
        writeTLBytes(tmpPassword, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readTLString(stream);
        tmpPassword = readTLBytes(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(id);
        size += computeTLBytesSerializedSize(tmpPassword);
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TLBytes getTmpPassword() {
        return tmpPassword;
    }

    public void setTmpPassword(TLBytes tmpPassword) {
        this.tmpPassword = tmpPassword;
    }
}
