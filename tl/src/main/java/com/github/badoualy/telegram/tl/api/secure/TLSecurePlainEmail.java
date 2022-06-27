package com.github.badoualy.telegram.tl.api.secure;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

public class TLSecurePlainEmail extends TLAbsSecurePlainData {

    public static final int CONSTRUCTOR_ID = 0x21ec5a5f;

    protected String email;

    private final String _constructor = "securePlainEmail#21ec5a5f";

    public TLSecurePlainEmail() {
    }

    public TLSecurePlainEmail(String email) {
        this.email = email;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(email, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        email = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(email);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
