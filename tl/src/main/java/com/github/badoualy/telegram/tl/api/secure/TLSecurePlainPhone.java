package com.github.badoualy.telegram.tl.api.secure;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

public class TLSecurePlainPhone extends TLAbsSecurePlainData {

    public static final int CONSTRUCTOR_ID = 0x7d6099dd;

    protected String phone;

    private final String _constructor = "securePlainPhone#7d6099dd";

    public TLSecurePlainPhone() {
    }

    public TLSecurePlainPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(phone, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        phone = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(phone);
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
