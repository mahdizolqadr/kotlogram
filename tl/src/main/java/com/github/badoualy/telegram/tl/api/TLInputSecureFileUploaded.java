package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
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
public class TLInputSecureFileUploaded extends TLAbsInputSecureFile {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int parts;

    protected String md5Checksum;

    protected TLBytes fileHash;

    protected TLBytes secret;

    private final String _constructor = "inputSecureFileUploaded#0";

    public TLInputSecureFileUploaded() {
    }

    public TLInputSecureFileUploaded(long id, int parts, String md5Checksum, TLBytes fileHash, TLBytes secret) {
        this.id = id;
        this.parts = parts;
        this.md5Checksum = md5Checksum;
        this.fileHash = fileHash;
        this.secret = secret;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(id, stream);
        writeInt(parts, stream);
        writeString(md5Checksum, stream);
        writeTLBytes(fileHash, stream);
        writeTLBytes(secret, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readLong(stream);
        parts = readInt(stream);
        md5Checksum = readTLString(stream);
        fileHash = readTLBytes(stream, context);
        secret = readTLBytes(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(md5Checksum);
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

    public int getParts() {
        return parts;
    }

    public void setParts(int parts) {
        this.parts = parts;
    }

    public String getMd5Checksum() {
        return md5Checksum;
    }

    public void setMd5Checksum(String md5Checksum) {
        this.md5Checksum = md5Checksum;
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
