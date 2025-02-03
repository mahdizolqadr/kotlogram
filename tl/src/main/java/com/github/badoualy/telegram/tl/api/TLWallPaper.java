package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLWallPaper extends TLAbsWallPaper {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected boolean creator;

    protected boolean pattern;

    protected long accessHash;

    protected String slug;

    protected TLAbsDocument document;

    private final String _constructor = "wallPaper#0";

    public TLWallPaper() {
    }

    public TLWallPaper(long id, boolean creator, boolean ddefault, boolean pattern, boolean dark, long accessHash, String slug, TLAbsDocument document, TLWallPaperSettings settings) {
        this.id = id;
        this.creator = creator;
        this.ddefault = ddefault;
        this.pattern = pattern;
        this.dark = dark;
        this.accessHash = accessHash;
        this.slug = slug;
        this.document = document;
        this.settings = settings;
    }

    private void computeFlags() {
        flags = 0;
        flags = creator ? (flags | 1) : (flags & ~1);
        flags = ddefault ? (flags | 2) : (flags & ~2);
        flags = pattern ? (flags | 8) : (flags & ~8);
        flags = dark ? (flags | 16) : (flags & ~16);
        flags = settings != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeLong(id, stream);
        writeInt(flags, stream);
        writeLong(accessHash, stream);
        writeString(slug, stream);
        writeTLObject(document, stream);
        if ((flags & 4) != 0) {
            if (settings == null) throwNullFieldException("settings", flags);
            writeTLObject(settings, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readLong(stream);
        flags = readInt(stream);
        creator = (flags & 1) != 0;
        ddefault = (flags & 2) != 0;
        pattern = (flags & 8) != 0;
        dark = (flags & 16) != 0;
        accessHash = readLong(stream);
        slug = readTLString(stream);
        document = readTLObject(stream, context, TLAbsDocument.class, -1);
        settings = (flags & 4) != 0 ? readTLObject(stream, context, TLWallPaperSettings.class, TLWallPaperSettings.CONSTRUCTOR_ID) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(slug);
        size += document.computeSerializedSize();
        if ((flags & 4) != 0) {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean getCreator() {
        return creator;
    }

    public void setCreator(boolean creator) {
        this.creator = creator;
    }

    public boolean getDdefault() {
        return ddefault;
    }

    public void setDdefault(boolean ddefault) {
        this.ddefault = ddefault;
    }

    public boolean getPattern() {
        return pattern;
    }

    public void setPattern(boolean pattern) {
        this.pattern = pattern;
    }

    public boolean getDark() {
        return dark;
    }

    public void setDark(boolean dark) {
        this.dark = dark;
    }

    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long accessHash) {
        this.accessHash = accessHash;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public TLAbsDocument getDocument() {
        return document;
    }

    public void setDocument(TLAbsDocument document) {
        this.document = document;
    }

    public TLWallPaperSettings getSettings() {
        return settings;
    }

    public void setSettings(TLWallPaperSettings settings) {
        this.settings = settings;
    }
}
