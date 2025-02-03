package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLLangPackLanguage extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean official;

    protected boolean rtl;

    protected boolean beta;

    protected String name;

    protected String nativeName;

    protected String langCode;

    protected String baseLangCode;

    protected String pluralCode;

    protected int stringsCount;

    protected int translatedCount;

    protected String translationsUrl;

    private final String _constructor = "langPackLanguage#0";

    public TLLangPackLanguage() {
    }

    public TLLangPackLanguage(boolean official, boolean rtl, boolean beta, String name, String nativeName, String langCode, String baseLangCode, String pluralCode, int stringsCount, int translatedCount, String translationsUrl) {
        this.official = official;
        this.rtl = rtl;
        this.beta = beta;
        this.name = name;
        this.nativeName = nativeName;
        this.langCode = langCode;
        this.baseLangCode = baseLangCode;
        this.pluralCode = pluralCode;
        this.stringsCount = stringsCount;
        this.translatedCount = translatedCount;
        this.translationsUrl = translationsUrl;
    }

    private void computeFlags() {
        flags = 0;
        flags = official ? (flags | 1) : (flags & ~1);
        flags = rtl ? (flags | 4) : (flags & ~4);
        flags = beta ? (flags | 8) : (flags & ~8);
        flags = baseLangCode != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(name, stream);
        writeString(nativeName, stream);
        writeString(langCode, stream);
        if ((flags & 2) != 0) {
            if (baseLangCode == null) throwNullFieldException("baseLangCode", flags);
            writeString(baseLangCode, stream);
        }
        writeString(pluralCode, stream);
        writeInt(stringsCount, stream);
        writeInt(translatedCount, stream);
        writeString(translationsUrl, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        official = (flags & 1) != 0;
        rtl = (flags & 4) != 0;
        beta = (flags & 8) != 0;
        name = readTLString(stream);
        nativeName = readTLString(stream);
        langCode = readTLString(stream);
        baseLangCode = (flags & 2) != 0 ? readTLString(stream) : null;
        pluralCode = readTLString(stream);
        stringsCount = readInt(stream);
        translatedCount = readInt(stream);
        translationsUrl = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(name);
        size += computeTLStringSerializedSize(nativeName);
        size += computeTLStringSerializedSize(langCode);
        if ((flags & 2) != 0) {
            if (baseLangCode == null) throwNullFieldException("baseLangCode", flags);
            size += computeTLStringSerializedSize(baseLangCode);
        }
        size += computeTLStringSerializedSize(pluralCode);
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(translationsUrl);
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

    public boolean getOfficial() {
        return official;
    }

    public void setOfficial(boolean official) {
        this.official = official;
    }

    public boolean getRtl() {
        return rtl;
    }

    public void setRtl(boolean rtl) {
        this.rtl = rtl;
    }

    public boolean getBeta() {
        return beta;
    }

    public void setBeta(boolean beta) {
        this.beta = beta;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public String getBaseLangCode() {
        return baseLangCode;
    }

    public void setBaseLangCode(String baseLangCode) {
        this.baseLangCode = baseLangCode;
    }

    public String getPluralCode() {
        return pluralCode;
    }

    public void setPluralCode(String pluralCode) {
        this.pluralCode = pluralCode;
    }

    public int getStringsCount() {
        return stringsCount;
    }

    public void setStringsCount(int stringsCount) {
        this.stringsCount = stringsCount;
    }

    public int getTranslatedCount() {
        return translatedCount;
    }

    public void setTranslatedCount(int translatedCount) {
        this.translatedCount = translatedCount;
    }

    public String getTranslationsUrl() {
        return translationsUrl;
    }

    public void setTranslationsUrl(String translationsUrl) {
        this.translationsUrl = translationsUrl;
    }
}
