package com.github.badoualy.telegram.tl.api.langpack;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

public class TLLangPackDifference extends TLObject {

    public static final int CONSTRUCTOR_ID = 0xf385c1f6;

    protected String langCode;
    protected int fromVersion;
    protected int version;
    protected TLVector<TLAbsLangPackString> strings;

    private final String _constructor = "langPackDifference#f385c1f6";

    public TLLangPackDifference() {
    }

    public TLLangPackDifference(String langCode, int fromVersion, int version, TLVector<TLAbsLangPackString> strings) {
        this.langCode = langCode;
        this.fromVersion = fromVersion;
        this.version = version;
        this.strings = strings;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(langCode, stream);
        writeInt(fromVersion, stream);
        writeInt(version, stream);
        writeTLVector(strings, stream);
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        langCode = readTLString(stream);
        fromVersion = readInt(stream);
        version = readInt(stream);
        strings = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(langCode);
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += strings.computeSerializedSize();
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

    public int getFromVersion() {
        return fromVersion;
    }

    public void setFromVersion(int fromVersion) {
        this.fromVersion = fromVersion;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public TLVector<TLAbsLangPackString> getStrings() {
        return strings;
    }

    public void setStrings(TLVector<TLAbsLangPackString> strings) {
        this.strings = strings;
    }
}
