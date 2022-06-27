package com.github.badoualy.telegram.tl.api.langpack;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

public class TLLangPackStringDeleted extends TLAbsLangPackString {

    public static final int CONSTRUCTOR_ID = 0x2979eeb2;

    private final String _constructor = "langPackStringDeleted#2979eeb2";

    public TLLangPackStringDeleted() {
    }

    public TLLangPackStringDeleted(String key) {
        super(key);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(key, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        key = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(key);
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
}
