package com.github.badoualy.telegram.tl.api.theme;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsDocument;
import com.github.badoualy.telegram.tl.core.TLObject;

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

public class TLTheme extends TLObject {

    public static final int CONSTRUCTOR_ID = 0xe802b8dc;

    protected int flags;
    protected boolean creator;
    protected boolean isDefault;
    protected boolean forChat;
    protected long id;
    protected long accessHash;
    protected String slug;
    protected String title;
    protected TLAbsDocument document;
    protected TLThemeSettings settings;
    protected Integer installsCount;

    private final String _constructor = "theme#e802b8dc";

    TLTheme() {
    }

    TLTheme(boolean creator, boolean isDefault, boolean forChat, long id, long accessHash, String slug, String title,
            TLAbsDocument document, TLThemeSettings settings, Integer installsCount) {
        this.creator = creator;
        this.isDefault = isDefault;
        this.forChat = forChat;
        this.id = id;
        this.accessHash = accessHash;
        this.slug = slug;
        this.title = title;
        this.document = document;
        this.settings = settings;
        this.installsCount = installsCount;
    }

    private void computeFlags() {
        flags = 0;
        flags = creator ? (flags | 1) : (flags & ~1);
        flags = isDefault ? (flags | 2) : (flags & ~2);
        flags = forChat ? (flags | 32) : (flags & ~32);
        flags = document != null ? (flags | 4) : (flags & ~4);
        flags = settings != null ? (flags | 8) : (flags & ~8);
        flags = installsCount != null ? (flags | 16) : (flags & ~16);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();
        writeInt(flags, stream);
        writeLong(id, stream);
        writeLong(accessHash, stream);
        writeString(slug, stream);
        writeString(title, stream);
        if ((flags & 4) != 0) {
            if (document == null) {
                throwNullFieldException("document", flags);
            }
            writeTLObject(document, stream);
        }
        if ((flags & 8) != 0) {
            if (settings == null) {
                throwNullFieldException("settings", flags);
            }
            writeTLObject(settings, stream);
        }
        if ((flags & 16) != 0) {
            if (installsCount == null) {
                throwNullFieldException("installsCount", flags);
            }
            writeInt(installsCount, stream);
        }
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        creator = (flags & 1) != 0;
        isDefault = (flags & 2) != 0;
        forChat = (flags & 32) != 0;
        id = readLong(stream);
        accessHash = readLong(stream);
        slug = readTLString(stream);
        title = readTLString(stream);
        document = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsDocument.class, -1) : null;
        settings = (flags & 8) != 0 ?
                readTLObject(stream, context, TLThemeSettings.class, TLThemeSettings.CONSTRUCTOR_ID)
                : null;
        installsCount = (flags & 16) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(slug);
        size += computeTLStringSerializedSize(title);
        if ((flags & 4) != 0) {
            if (document == null) {
                throwNullFieldException("document", flags);
            }
            size += document.computeSerializedSize();
        }
        if ((flags & 8) != 0) {
            if (settings == null) {
                throwNullFieldException("settings", flags);
            }
            size += settings.computeSerializedSize();
        }
        if ((flags & 16) != 0) {
            if (installsCount == null) {
                throwNullFieldException("installsCount", flags);
            }
            size += SIZE_INT32;
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

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public boolean isForChat() {
        return forChat;
    }

    public void setForChat(boolean forChat) {
        this.forChat = forChat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TLAbsDocument getDocument() {
        return document;
    }

    public void setDocument(TLAbsDocument document) {
        this.document = document;
    }

    public TLThemeSettings getSettings() {
        return settings;
    }

    public void setSettings(TLThemeSettings settings) {
        this.settings = settings;
    }

    public Integer getInstallsCount() {
        return installsCount;
    }

    public void setInstallsCount(Integer installsCount) {
        this.installsCount = installsCount;
    }
}
