package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

public class TLUpdateLangPackTooLong extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0x46560264;

    protected String langCode;

    private final String _constructor = "updateLangPackTooLong#46560264";

    public TLUpdateLangPackTooLong() {
    }

    public TLUpdateLangPackTooLong(String langCode) {
        this.langCode = langCode;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(langCode, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        langCode = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(langCode);
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

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }
}
