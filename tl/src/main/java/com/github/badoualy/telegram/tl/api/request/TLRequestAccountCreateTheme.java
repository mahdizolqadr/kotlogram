package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputDocument;
import com.github.badoualy.telegram.tl.api.TLInputThemeSettings;
import com.github.badoualy.telegram.tl.api.TLTheme;
import com.github.badoualy.telegram.tl.core.TLMethod;
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
public class TLRequestAccountCreateTheme extends TLMethod<TLTheme> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected String slug;

    protected String title;

    protected TLAbsInputDocument document;

    protected TLVector<TLInputThemeSettings> settings;

    private final String _constructor = "account.createTheme#0";

    public TLRequestAccountCreateTheme() {
    }

    public TLRequestAccountCreateTheme(String slug, String title, TLAbsInputDocument document, TLVector<TLInputThemeSettings> settings) {
        this.slug = slug;
        this.title = title;
        this.document = document;
        this.settings = settings;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLTheme deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLTheme)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLTheme) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = document != null ? (flags | 4) : (flags & ~4);
        flags = settings != null ? (flags | 8) : (flags & ~8);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(slug, stream);
        writeString(title, stream);
        if ((flags & 4) != 0) {
            if (document == null) throwNullFieldException("document", flags);
            writeTLObject(document, stream);
        }
        if ((flags & 8) != 0) {
            if (settings == null) throwNullFieldException("settings", flags);
            writeTLVector(settings, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        slug = readTLString(stream);
        title = readTLString(stream);
        document = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsInputDocument.class, -1) : null;
        settings = (flags & 8) != 0 ? readTLVector(stream, context) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(slug);
        size += computeTLStringSerializedSize(title);
        if ((flags & 4) != 0) {
            if (document == null) throwNullFieldException("document", flags);
            size += document.computeSerializedSize();
        }
        if ((flags & 8) != 0) {
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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TLAbsInputDocument getDocument() {
        return document;
    }

    public void setDocument(TLAbsInputDocument document) {
        this.document = document;
    }

    public TLVector<TLInputThemeSettings> getSettings() {
        return settings;
    }

    public void setSettings(TLVector<TLInputThemeSettings> settings) {
        this.settings = settings;
    }
}
