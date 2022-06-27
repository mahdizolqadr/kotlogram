package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.theme.TLThemeSettings;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

public class TLWebPageAttribute extends TLObject {

    public static final int CONSTRUCTOR_ID = 0x54b56617;

    protected int flags;
    protected TLVector<TLAbsDocument> documents;
    protected TLThemeSettings settings;
    private final String _constructor = "webPageAttributeTheme#54b56617";

    TLWebPageAttribute() {
    }

    TLWebPageAttribute(TLVector<TLAbsDocument> documents, TLThemeSettings settings) {
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
            writeTLVector(documents, stream);
        }
        if ((flags & 2) != 0) {
            writeTLObject(settings, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        if ((flags & 1) != 0) {
            documents = readTLVector(stream, context);
        }
        if ((flags & 2) != 0) {
            settings = readTLObject(stream, context, TLThemeSettings.class, TLThemeSettings.CONSTRUCTOR_ID);
        }
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            size += documents.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
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
