package com.github.badoualy.telegram.tl.api.secure;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize;

public class TLSecureFile extends TLAbsSecureFile {

    public static final int CONSTRUCTOR_ID = 0xe0277a62;

    protected long id;
    protected long accessHash;
    protected int size;
    protected int dcId;
    protected int date;
    protected TLBytes fileHash;
    protected TLBytes secret;

    private final String _constructor = "secureFile#e0277a62";

    public TLSecureFile() {
    }

    public TLSecureFile(long id, long accessHash, int size, int dcId, int date, TLBytes fileHash, TLBytes secret) {
        this.id = id;
        this.accessHash = accessHash;
        this.size = size;
        this.dcId = dcId;
        this.date = date;
        this.fileHash = fileHash;
        this.secret = secret;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(id, stream);
        writeLong(accessHash, stream);
        writeInt(size, stream);
        writeInt(dcId, stream);
        writeInt(date, stream);
        writeTLBytes(fileHash, stream);
        writeTLBytes(secret, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readLong(stream);
        accessHash = readLong(stream);
        size = readInt(stream);
        dcId = readInt(stream);
        date = readInt(stream);
        fileHash = readTLBytes(stream, context);
        secret = readTLBytes(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += computeTLBytesSerializedSize(fileHash);
        size += computeTLBytesSerializedSize(secret);
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getDcId() {
        return dcId;
    }

    public void setDcId(int dcId) {
        this.dcId = dcId;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public TLBytes getFileHash() {
        return fileHash;
    }

    public void setFileHash(TLBytes fileHash) {
        this.fileHash = fileHash;
    }

    public TLBytes getSecret() {
        return secret;
    }

    public void setSecret(TLBytes secret) {
        this.secret = secret;
    }
}
