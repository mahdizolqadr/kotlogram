package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.account.TLPasswordInputSettings;
import com.github.badoualy.telegram.tl.api.auth.TLAbsAuthorization;
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
public class TLRequestAuthRecoverPassword extends TLMethod<TLAbsAuthorization> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected String code;

    protected TLPasswordInputSettings newSettings;

    private final String _constructor = "auth.recoverPassword#0";

    public TLRequestAuthRecoverPassword() {
    }

    public TLRequestAuthRecoverPassword(String code, TLPasswordInputSettings newSettings) {
        this.code = code;
        this.newSettings = newSettings;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsAuthorization deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsAuthorization)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsAuthorization) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = newSettings != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(code, stream);
        if ((flags & 1) != 0) {
            if (newSettings == null) throwNullFieldException("newSettings", flags);
            writeTLObject(newSettings, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        code = readTLString(stream);
        newSettings = (flags & 1) != 0 ? readTLObject(stream, context, TLPasswordInputSettings.class, TLPasswordInputSettings.CONSTRUCTOR_ID) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(code);
        if ((flags & 1) != 0) {
            if (newSettings == null) throwNullFieldException("newSettings", flags);
            size += newSettings.computeSerializedSize();
        }
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public TLPasswordInputSettings getNewSettings() {
        return newSettings;
    }

    public void setNewSettings(TLPasswordInputSettings newSettings) {
        this.newSettings = newSettings;
    }
}
