package com.github.badoualy.telegram.tl.api.account;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsSecureRequiredType;
import com.github.badoualy.telegram.tl.api.TLAbsSecureValueError;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.api.TLSecureValue;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
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
public class TLAuthorizationForm extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLVector<TLAbsSecureRequiredType> requiredTypes;

    protected TLVector<TLSecureValue> values;

    protected TLVector<TLAbsSecureValueError> errors;

    protected TLVector<TLAbsUser> users;

    protected String privacyPolicyUrl;

    private final String _constructor = "account.authorizationForm#0";

    public TLAuthorizationForm() {
    }

    public TLAuthorizationForm(TLVector<TLAbsSecureRequiredType> requiredTypes, TLVector<TLSecureValue> values, TLVector<TLAbsSecureValueError> errors, TLVector<TLAbsUser> users, String privacyPolicyUrl) {
        this.requiredTypes = requiredTypes;
        this.values = values;
        this.errors = errors;
        this.users = users;
        this.privacyPolicyUrl = privacyPolicyUrl;
    }

    private void computeFlags() {
        flags = 0;
        flags = privacyPolicyUrl != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLVector(requiredTypes, stream);
        writeTLVector(values, stream);
        writeTLVector(errors, stream);
        writeTLVector(users, stream);
        if ((flags & 1) != 0) {
            if (privacyPolicyUrl == null) throwNullFieldException("privacyPolicyUrl", flags);
            writeString(privacyPolicyUrl, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        requiredTypes = readTLVector(stream, context);
        values = readTLVector(stream, context);
        errors = readTLVector(stream, context);
        users = readTLVector(stream, context);
        privacyPolicyUrl = (flags & 1) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += requiredTypes.computeSerializedSize();
        size += values.computeSerializedSize();
        size += errors.computeSerializedSize();
        size += users.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (privacyPolicyUrl == null) throwNullFieldException("privacyPolicyUrl", flags);
            size += computeTLStringSerializedSize(privacyPolicyUrl);
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

    public TLVector<TLAbsSecureRequiredType> getRequiredTypes() {
        return requiredTypes;
    }

    public void setRequiredTypes(TLVector<TLAbsSecureRequiredType> requiredTypes) {
        this.requiredTypes = requiredTypes;
    }

    public TLVector<TLSecureValue> getValues() {
        return values;
    }

    public void setValues(TLVector<TLSecureValue> values) {
        this.values = values;
    }

    public TLVector<TLAbsSecureValueError> getErrors() {
        return errors;
    }

    public void setErrors(TLVector<TLAbsSecureValueError> errors) {
        this.errors = errors;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }

    public String getPrivacyPolicyUrl() {
        return privacyPolicyUrl;
    }

    public void setPrivacyPolicyUrl(String privacyPolicyUrl) {
        this.privacyPolicyUrl = privacyPolicyUrl;
    }
}
