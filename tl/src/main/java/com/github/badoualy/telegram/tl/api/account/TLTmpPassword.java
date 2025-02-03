package com.github.badoualy.telegram.tl.api.account;

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
public class TLTmpPassword extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLBytes tmpPassword;

    protected int validUntil;

    private final String _constructor = "account.tmpPassword#0";

    public TLTmpPassword() {
    }

    public TLTmpPassword(TLBytes tmpPassword, int validUntil) {
        this.tmpPassword = tmpPassword;
        this.validUntil = validUntil;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLBytes(tmpPassword, stream);
        writeInt(validUntil, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        tmpPassword = readTLBytes(stream, context);
        validUntil = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLBytesSerializedSize(tmpPassword);
        size += SIZE_INT32;
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

    public TLBytes getTmpPassword() {
        return tmpPassword;
    }

    public void setTmpPassword(TLBytes tmpPassword) {
        this.tmpPassword = tmpPassword;
    }

    public int getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(int validUntil) {
        this.validUntil = validUntil;
    }
}
