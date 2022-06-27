package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.secure.TLSecureCredentialsEncrypted;
import com.github.badoualy.telegram.tl.api.secure.TLSecureValue;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

public class TLMessageActionSecureValuesSentMe extends TLAbsMessageAction {

    public static final int CONSTRUCTOR_ID = 0x1b287353;

    protected TLVector<TLSecureValue> values;
    protected TLSecureCredentialsEncrypted credentials;

    private final String _constructor = "messageActionSecureValuesSentMe#1b287353";

    public TLMessageActionSecureValuesSentMe() {
    }

    public TLMessageActionSecureValuesSentMe(TLVector<TLSecureValue> values, TLSecureCredentialsEncrypted credentials) {
        this.values = values;
        this.credentials = credentials;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(values, stream);
        writeTLObject(credentials, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        values = readTLVector(stream, context);
        credentials = readTLObject(stream, context, TLSecureCredentialsEncrypted.class, TLSecureCredentialsEncrypted.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += values.computeSerializedSize();
        size += credentials.computeSerializedSize();
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

    public TLVector<TLSecureValue> getValues() {
        return values;
    }

    public void setValues(TLVector<TLSecureValue> values) {
        this.values = values;
    }

    public TLSecureCredentialsEncrypted getCredentials() {
        return credentials;
    }

    public void setCredentials(TLSecureCredentialsEncrypted credentials) {
        this.credentials = credentials;
    }
}
