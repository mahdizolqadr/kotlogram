package com.github.badoualy.telegram.tl.api.help;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsDocument;
import com.github.badoualy.telegram.tl.api.TLAbsMessageEntity;
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
public class TLAppUpdate extends TLAbsAppUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean canNotSkip;

    protected int id;

    protected String version;

    protected String text;

    protected TLVector<TLAbsMessageEntity> entities;

    protected TLAbsDocument document;

    protected String url;

    protected TLAbsDocument sticker;

    private final String _constructor = "help.appUpdate#0";

    public TLAppUpdate() {
    }

    public TLAppUpdate(boolean canNotSkip, int id, String version, String text, TLVector<TLAbsMessageEntity> entities, TLAbsDocument document, String url, TLAbsDocument sticker) {
        this.canNotSkip = canNotSkip;
        this.id = id;
        this.version = version;
        this.text = text;
        this.entities = entities;
        this.document = document;
        this.url = url;
        this.sticker = sticker;
    }

    private void computeFlags() {
        flags = 0;
        flags = canNotSkip ? (flags | 1) : (flags & ~1);
        flags = document != null ? (flags | 2) : (flags & ~2);
        flags = url != null ? (flags | 4) : (flags & ~4);
        flags = sticker != null ? (flags | 8) : (flags & ~8);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(id, stream);
        writeString(version, stream);
        writeString(text, stream);
        writeTLVector(entities, stream);
        if ((flags & 2) != 0) {
            if (document == null) throwNullFieldException("document", flags);
            writeTLObject(document, stream);
        }
        if ((flags & 4) != 0) {
            if (url == null) throwNullFieldException("url", flags);
            writeString(url, stream);
        }
        if ((flags & 8) != 0) {
            if (sticker == null) throwNullFieldException("sticker", flags);
            writeTLObject(sticker, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        canNotSkip = (flags & 1) != 0;
        id = readInt(stream);
        version = readTLString(stream);
        text = readTLString(stream);
        entities = readTLVector(stream, context);
        document = (flags & 2) != 0 ? readTLObject(stream, context, TLAbsDocument.class, -1) : null;
        url = (flags & 4) != 0 ? readTLString(stream) : null;
        sticker = (flags & 8) != 0 ? readTLObject(stream, context, TLAbsDocument.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(version);
        size += computeTLStringSerializedSize(text);
        size += entities.computeSerializedSize();
        if ((flags & 2) != 0) {
            if (document == null) throwNullFieldException("document", flags);
            size += document.computeSerializedSize();
        }
        if ((flags & 4) != 0) {
            if (url == null) throwNullFieldException("url", flags);
            size += computeTLStringSerializedSize(url);
        }
        if ((flags & 8) != 0) {
            if (sticker == null) throwNullFieldException("sticker", flags);
            size += sticker.computeSerializedSize();
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

    public boolean getCanNotSkip() {
        return canNotSkip;
    }

    public void setCanNotSkip(boolean canNotSkip) {
        this.canNotSkip = canNotSkip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TLVector<TLAbsMessageEntity> getEntities() {
        return entities;
    }

    public void setEntities(TLVector<TLAbsMessageEntity> entities) {
        this.entities = entities;
    }

    public TLAbsDocument getDocument() {
        return document;
    }

    public void setDocument(TLAbsDocument document) {
        this.document = document;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TLAbsDocument getSticker() {
        return sticker;
    }

    public void setSticker(TLAbsDocument sticker) {
        this.sticker = sticker;
    }
}
