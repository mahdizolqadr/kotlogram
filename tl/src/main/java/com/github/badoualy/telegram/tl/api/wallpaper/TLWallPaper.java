package com.github.badoualy.telegram.tl.api.wallpaper;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsDocument;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLWallPaper extends TLAbsWallPaper {

    public static final int CONSTRUCTOR_ID = 0xa437c3ed;

    protected boolean creator;
    protected boolean pattern;
    protected long accessHash;
    protected String slug;
    protected TLAbsDocument document;

    private final String _constructor = "wallPaper#a437c3ed";

    public TLWallPaper() {
    }

    public TLWallPaper(long id, boolean creator, boolean isDefault, boolean pattern, boolean dark, long accessHash,
                       String slug, TLAbsDocument document, TLWallPaperSettings settings) {
        super(id, isDefault, dark, settings);
        this.creator = creator;
        this.pattern = pattern;
        this.accessHash = accessHash;
        this.slug = slug;
        this.document = document;
    }

    private void computeFlags() {
        flags = 0;
        flags = creator ? (flags | 1) : (flags & ~1);
        flags = isDefault ? (flags | 2) : (flags & ~2);
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
            if (settings == null) {
                throwNullFieldException("settings", flags);
            }
            writeTLObject(settings, stream);
        }
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readLong(stream);
        flags = readInt(stream);
        creator = (flags & 1) != 0;
        isDefault = (flags & 2) != 0;
        pattern = (flags & 8) != 0;
        dark = (flags & 16) != 0;
        accessHash = readLong(stream);
        slug = readTLString(stream);
        document = readTLObject(stream, context, TLAbsDocument.class, -1);
        if ((flags & 4) != 0) {
            settings = readTLObject(stream, context, TLWallPaperSettings.class, TLWallPaperSettings.CONSTRUCTOR_ID);
        }
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(slug);
        size += document.computeSerializedSize();
        if ((flags & 4) != 0) {
            if (settings == null) {
                throwNullFieldException("settings", flags);
            }
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

    public boolean isCreator() {
        return creator;
    }

    public void setCreator(boolean creator) {
        this.creator = creator;
    }

    public boolean isPattern() {
        return pattern;
    }

    public void setPattern(boolean pattern) {
        this.pattern = pattern;
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
}
