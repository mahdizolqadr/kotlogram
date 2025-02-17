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
public class TLBotApp extends TLAbsBotApp {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected long id;

    protected long accessHash;

    protected String shortName;

    protected String title;

    protected String description;

    protected TLAbsPhoto photo;

    protected TLAbsDocument document;

    protected long hash;

    private final String _constructor = "botApp#0";

    public TLBotApp() {
    }

    public TLBotApp(long id, long accessHash, String shortName, String title, String description, TLAbsPhoto photo, TLAbsDocument document, long hash) {
        this.id = id;
        this.accessHash = accessHash;
        this.shortName = shortName;
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.document = document;
        this.hash = hash;
    }

    private void computeFlags() {
        flags = 0;
        flags = document != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(id, stream);
        writeLong(accessHash, stream);
        writeString(shortName, stream);
        writeString(title, stream);
        writeString(description, stream);
        writeTLObject(photo, stream);
        if ((flags & 1) != 0) {
            if (document == null) throwNullFieldException("document", flags);
            writeTLObject(document, stream);
        }
        writeLong(hash, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        id = readLong(stream);
        accessHash = readLong(stream);
        shortName = readTLString(stream);
        title = readTLString(stream);
        description = readTLString(stream);
        photo = readTLObject(stream, context, TLAbsPhoto.class, -1);
        document = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsDocument.class, -1) : null;
        hash = readLong(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(shortName);
        size += computeTLStringSerializedSize(title);
        size += computeTLStringSerializedSize(description);
        size += photo.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (document == null) throwNullFieldException("document", flags);
            size += document.computeSerializedSize();
        }
        size += SIZE_INT64;
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

    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long accessHash) {
        this.accessHash = accessHash;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TLAbsPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(TLAbsPhoto photo) {
        this.photo = photo;
    }

    public TLAbsDocument getDocument() {
        return document;
    }

    public void setDocument(TLAbsDocument document) {
        this.document = document;
    }

    public long getHash() {
        return hash;
    }

    public void setHash(long hash) {
        this.hash = hash;
    }
}
