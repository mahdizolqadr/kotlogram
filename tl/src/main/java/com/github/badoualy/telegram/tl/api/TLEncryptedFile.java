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
public class TLEncryptedFile extends TLAbsEncryptedFile {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected long id;

    protected long accessHash;

    protected long size;

    protected int dcId;

    protected int keyFingerprint;

    private final String _constructor = "encryptedFile#0";

    public TLEncryptedFile() {
    }

    public TLEncryptedFile(long id, long accessHash, long size, int dcId, int keyFingerprint) {
        this.id = id;
        this.accessHash = accessHash;
        this.size = size;
        this.dcId = dcId;
        this.keyFingerprint = keyFingerprint;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(id, stream);
        writeLong(accessHash, stream);
        writeLong(size, stream);
        writeInt(dcId, stream);
        writeInt(keyFingerprint, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readLong(stream);
        accessHash = readLong(stream);
        size = readLong(stream);
        dcId = readInt(stream);
        keyFingerprint = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += SIZE_INT32;
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

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public int getDcId() {
        return dcId;
    }

    public void setDcId(int dcId) {
        this.dcId = dcId;
    }

    public int getKeyFingerprint() {
        return keyFingerprint;
    }

    public void setKeyFingerprint(int keyFingerprint) {
        this.keyFingerprint = keyFingerprint;
    }

    @Override
    public final boolean isEmpty() {
        return false;
    }

    @Override
    public final boolean isNotEmpty() {
        return true;
    }

    @Override
    public final TLEncryptedFile getAsEncryptedFile() {
        return this;
    }
}
