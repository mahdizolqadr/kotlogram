package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputCheckPasswordSRP;
import com.github.badoualy.telegram.tl.api.account.TLTmpPassword;
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
public class TLRequestAccountGetTmpPassword extends TLMethod<TLTmpPassword> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsInputCheckPasswordSRP password;

    protected int period;

    private final String _constructor = "account.getTmpPassword#0";

    public TLRequestAccountGetTmpPassword() {
    }

    public TLRequestAccountGetTmpPassword(TLAbsInputCheckPasswordSRP password, int period) {
        this.password = password;
        this.period = period;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLTmpPassword deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLTmpPassword)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLTmpPassword) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(password, stream);
        writeInt(period, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        password = readTLObject(stream, context, TLAbsInputCheckPasswordSRP.class, -1);
        period = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += password.computeSerializedSize();
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

    public TLAbsInputCheckPasswordSRP getPassword() {
        return password;
    }

    public void setPassword(TLAbsInputCheckPasswordSRP password) {
        this.password = password;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
}
