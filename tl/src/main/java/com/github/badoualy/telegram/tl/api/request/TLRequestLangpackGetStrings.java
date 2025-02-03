package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsLangPackString;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLStringVector;
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
public class TLRequestLangpackGetStrings extends TLMethod<TLVector<TLAbsLangPackString>> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected String langPack;

    protected String langCode;

    protected TLStringVector keys;

    private final String _constructor = "langpack.getStrings#0";

    public TLRequestLangpackGetStrings() {
    }

    public TLRequestLangpackGetStrings(String langPack, String langCode, TLStringVector keys) {
        this.langPack = langPack;
        this.langCode = langCode;
        this.keys = keys;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLVector<TLAbsLangPackString> deserializeResponse(InputStream stream, TLContext context) throws IOException {
        return readTLVector(stream, context);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(langPack, stream);
        writeString(langCode, stream);
        writeTLVector(keys, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        langPack = readTLString(stream);
        langCode = readTLString(stream);
        keys = readTLStringVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(langPack);
        size += computeTLStringSerializedSize(langCode);
        size += keys.computeSerializedSize();
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

    public String getLangPack() {
        return langPack;
    }

    public void setLangPack(String langPack) {
        this.langPack = langPack;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public TLStringVector getKeys() {
        return keys;
    }

    public void setKeys(TLStringVector keys) {
        this.keys = keys;
    }
}
