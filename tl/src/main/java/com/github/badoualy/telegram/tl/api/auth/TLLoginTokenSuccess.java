package com.github.badoualy.telegram.tl.api.auth;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLLoginTokenSuccess extends TLAbsLoginToken {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsAuthorization authorization;

    private final String _constructor = "auth.loginTokenSuccess#0";

    public TLLoginTokenSuccess() {
    }

    public TLLoginTokenSuccess(TLAbsAuthorization authorization) {
        this.authorization = authorization;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(authorization, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        authorization = readTLObject(stream, context, TLAbsAuthorization.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += authorization.computeSerializedSize();
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

    public TLAbsAuthorization getAuthorization() {
        return authorization;
    }

    public void setAuthorization(TLAbsAuthorization authorization) {
        this.authorization = authorization;
    }
}
