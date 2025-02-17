package com.github.badoualy.telegram.tl.api.account;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsPasswordKdfAlgo;
import com.github.badoualy.telegram.tl.api.TLSecureSecretSettings;
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
public class TLPasswordInputSettings extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLAbsPasswordKdfAlgo newAlgo;

    protected TLBytes newPasswordHash;

    protected String hint;

    protected String email;

    protected TLSecureSecretSettings newSecureSettings;

    private final String _constructor = "account.passwordInputSettings#0";

    public TLPasswordInputSettings() {
    }

    public TLPasswordInputSettings(TLAbsPasswordKdfAlgo newAlgo, TLBytes newPasswordHash, String hint, String email, TLSecureSecretSettings newSecureSettings) {
        this.newAlgo = newAlgo;
        this.newPasswordHash = newPasswordHash;
        this.hint = hint;
        this.email = email;
        this.newSecureSettings = newSecureSettings;
    }

    private void computeFlags() {
        flags = 0;
        flags = newAlgo != null ? (flags | 1) : (flags & ~1);
        flags = newPasswordHash != null ? (flags | 1) : (flags & ~1);
        flags = hint != null ? (flags | 1) : (flags & ~1);
        flags = email != null ? (flags | 2) : (flags & ~2);
        flags = newSecureSettings != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (newAlgo == null) throwNullFieldException("newAlgo", flags);
            writeTLObject(newAlgo, stream);
        }
        if ((flags & 1) != 0) {
            if (newPasswordHash == null) throwNullFieldException("newPasswordHash", flags);
            writeTLBytes(newPasswordHash, stream);
        }
        if ((flags & 1) != 0) {
            if (hint == null) throwNullFieldException("hint", flags);
            writeString(hint, stream);
        }
        if ((flags & 2) != 0) {
            if (email == null) throwNullFieldException("email", flags);
            writeString(email, stream);
        }
        if ((flags & 4) != 0) {
            if (newSecureSettings == null) throwNullFieldException("newSecureSettings", flags);
            writeTLObject(newSecureSettings, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        newAlgo = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsPasswordKdfAlgo.class, -1) : null;
        newPasswordHash = (flags & 1) != 0 ? readTLBytes(stream, context) : null;
        hint = (flags & 1) != 0 ? readTLString(stream) : null;
        email = (flags & 2) != 0 ? readTLString(stream) : null;
        newSecureSettings = (flags & 4) != 0 ? readTLObject(stream, context, TLSecureSecretSettings.class, TLSecureSecretSettings.CONSTRUCTOR_ID) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (newAlgo == null) throwNullFieldException("newAlgo", flags);
            size += newAlgo.computeSerializedSize();
        }
        if ((flags & 1) != 0) {
            if (newPasswordHash == null) throwNullFieldException("newPasswordHash", flags);
            size += computeTLBytesSerializedSize(newPasswordHash);
        }
        if ((flags & 1) != 0) {
            if (hint == null) throwNullFieldException("hint", flags);
            size += computeTLStringSerializedSize(hint);
        }
        if ((flags & 2) != 0) {
            if (email == null) throwNullFieldException("email", flags);
            size += computeTLStringSerializedSize(email);
        }
        if ((flags & 4) != 0) {
            if (newSecureSettings == null) throwNullFieldException("newSecureSettings", flags);
            size += newSecureSettings.computeSerializedSize();
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

    public TLAbsPasswordKdfAlgo getNewAlgo() {
        return newAlgo;
    }

    public void setNewAlgo(TLAbsPasswordKdfAlgo newAlgo) {
        this.newAlgo = newAlgo;
    }

    public TLBytes getNewPasswordHash() {
        return newPasswordHash;
    }

    public void setNewPasswordHash(TLBytes newPasswordHash) {
        this.newPasswordHash = newPasswordHash;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TLSecureSecretSettings getNewSecureSettings() {
        return newSecureSettings;
    }

    public void setNewSecureSettings(TLSecureSecretSettings newSecureSettings) {
        this.newSecureSettings = newSecureSettings;
    }
}
