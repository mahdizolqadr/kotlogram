package com.github.badoualy.telegram.tl.api.langpack;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

public class TLLangPackString extends TLAbsLangPackString {

    public static final int CONSTRUCTOR_ID = 0xcad181f6;

    protected String value;

    private final String _constructor = "langPackString#cad181f6";

    public TLLangPackString() {
    }

    public TLLangPackString(String key, String value) {
        super(key);
        this.value = value;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(key, stream);
        writeString(value, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        key = readTLString(stream);
        value = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(key);
        size += computeTLStringSerializedSize(value);
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
