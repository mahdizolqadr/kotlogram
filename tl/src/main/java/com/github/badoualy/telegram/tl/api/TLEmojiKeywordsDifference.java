package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLEmojiKeywordsDifference extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected String langCode;

    protected int fromVersion;

    protected int version;

    protected TLVector<TLAbsEmojiKeyword> keywords;

    private final String _constructor = "emojiKeywordsDifference#0";

    public TLEmojiKeywordsDifference() {
    }

    public TLEmojiKeywordsDifference(String langCode, int fromVersion, int version, TLVector<TLAbsEmojiKeyword> keywords) {
        this.langCode = langCode;
        this.fromVersion = fromVersion;
        this.version = version;
        this.keywords = keywords;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(langCode, stream);
        writeInt(fromVersion, stream);
        writeInt(version, stream);
        writeTLVector(keywords, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        langCode = readTLString(stream);
        fromVersion = readInt(stream);
        version = readInt(stream);
        keywords = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(langCode);
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += keywords.computeSerializedSize();
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

    public TLVector<TLAbsEmojiKeyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(TLVector<TLAbsEmojiKeyword> keywords) {
        this.keywords = keywords;
    }
}
