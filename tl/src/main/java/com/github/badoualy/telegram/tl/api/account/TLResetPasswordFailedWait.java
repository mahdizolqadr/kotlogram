package com.github.badoualy.telegram.tl.api.account;

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
public class TLResetPasswordFailedWait extends TLAbsResetPasswordResult {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int retryDate;

    private final String _constructor = "account.resetPasswordFailedWait#0";

    public TLResetPasswordFailedWait() {
    }

    public TLResetPasswordFailedWait(int retryDate) {
        this.retryDate = retryDate;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(retryDate, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        retryDate = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
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

    public int getRetryDate() {
        return retryDate;
    }

    public void setRetryDate(int retryDate) {
        this.retryDate = retryDate;
    }
}
