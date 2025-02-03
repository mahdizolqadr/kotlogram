package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputDocument;
import com.github.badoualy.telegram.tl.api.TLAbsInputTheme;
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
public class TLRequestAccountUpdateTheme extends TLMethod<TLTheme> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected String format;

    protected TLAbsInputTheme theme;

    protected String slug;

    protected String title;

    protected TLAbsInputDocument document;

    protected TLVector<TLInputThemeSettings> settings;

    private final String _constructor = "account.updateTheme#0";

    public TLRequestAccountUpdateTheme() {
    }

    public TLRequestAccountUpdateTheme(String format, TLAbsInputTheme theme, String slug, String title, TLAbsInputDocument document, TLVector<TLInputThemeSettings> settings) {
        this.format = format;
        this.theme = theme;
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
        flags = slug != null ? (flags | 1) : (flags & ~1);
        flags = title != null ? (flags | 2) : (flags & ~2);
        flags = document != null ? (flags | 4) : (flags & ~4);
        flags = settings != null ? (flags | 8) : (flags & ~8);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(format, stream);
        writeTLObject(theme, stream);
        if ((flags & 1) != 0) {
            if (slug == null) throwNullFieldException("slug", flags);
            writeString(slug, stream);
        }
        if ((flags & 2) != 0) {
            if (title == null) throwNullFieldException("title", flags);
            writeString(title, stream);
        }
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
        format = readTLString(stream);
        theme = readTLObject(stream, context, TLAbsInputTheme.class, -1);
        slug = (flags & 1) != 0 ? readTLString(stream) : null;
        title = (flags & 2) != 0 ? readTLString(stream) : null;
        document = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsInputDocument.class, -1) : null;
        settings = (flags & 8) != 0 ? readTLVector(stream, context) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(format);
        size += theme.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (slug == null) throwNullFieldException("slug", flags);
            size += computeTLStringSerializedSize(slug);
        }
        if ((flags & 2) != 0) {
            if (title == null) throwNullFieldException("title", flags);
            size += computeTLStringSerializedSize(title);
        }
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

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public TLAbsInputTheme getTheme() {
        return theme;
    }

    public void setTheme(TLAbsInputTheme theme) {
        this.theme = theme;
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
