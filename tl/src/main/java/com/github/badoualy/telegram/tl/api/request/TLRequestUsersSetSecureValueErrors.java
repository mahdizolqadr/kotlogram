package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputUser;
import com.github.badoualy.telegram.tl.api.TLAbsSecureValueError;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLMethod;
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
public class TLRequestUsersSetSecureValueErrors extends TLMethod<TLBool> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsInputUser id;

    protected TLVector<TLAbsSecureValueError> errors;

    private final String _constructor = "users.setSecureValueErrors#0";

    public TLRequestUsersSetSecureValueErrors() {
    }

    public TLRequestUsersSetSecureValueErrors(TLAbsInputUser id, TLVector<TLAbsSecureValueError> errors) {
        this.id = id;
        this.errors = errors;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLBool)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLBool) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(id, stream);
        writeTLVector(errors, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readTLObject(stream, context, TLAbsInputUser.class, -1);
        errors = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += id.computeSerializedSize();
        size += errors.computeSerializedSize();
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

    public TLAbsInputUser getId() {
        return id;
    }

    public void setId(TLAbsInputUser id) {
        this.id = id;
    }

    public TLVector<TLAbsSecureValueError> getErrors() {
        return errors;
    }

    public void setErrors(TLVector<TLAbsSecureValueError> errors) {
        this.errors = errors;
    }
}
