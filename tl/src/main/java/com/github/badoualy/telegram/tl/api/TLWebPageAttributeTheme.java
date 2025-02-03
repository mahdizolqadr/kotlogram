package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLWebPageAttributeTheme extends TLAbsWebPageAttribute {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLVector<TLAbsDocument> documents;

    protected TLThemeSettings settings;

    private final String _constructor = "webPageAttributeTheme#0";

    public TLWebPageAttributeTheme() {
    }

    public TLWebPageAttributeTheme(TLVector<TLAbsDocument> documents, TLThemeSettings settings) {
        this.documents = documents;
        this.settings = settings;
    }

    private void computeFlags() {
        flags = 0;
        flags = documents != null ? (flags | 1) : (flags & ~1);
        flags = settings != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (documents == null) throwNullFieldException("documents", flags);
            writeTLVector(documents, stream);
        }
        if ((flags & 2) != 0) {
            if (settings == null) throwNullFieldException("settings", flags);
            writeTLObject(settings, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        documents = (flags & 1) != 0 ? readTLVector(stream, context) : null;
        settings = (flags & 2) != 0 ? readTLObject(stream, context, TLThemeSettings.class, TLThemeSettings.CONSTRUCTOR_ID) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (documents == null) throwNullFieldException("documents", flags);
            size += documents.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (settings == null) throwNullFieldException("settings", flags);
            size += settings.computeSerializedSize();
        }
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

    public TLVector<TLAbsDocument> getDocuments() {
        return documents;
    }

    public void setDocuments(TLVector<TLAbsDocument> documents) {
        this.documents = documents;
    }

    public TLThemeSettings getSettings() {
        return settings;
    }

    public void setSettings(TLThemeSettings settings) {
        this.settings = settings;
    }
}
