package com.github.badoualy.telegram.tl.api.upload;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLFileHash;
import com.github.badoualy.telegram.tl.core.TLBytes;
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
public class TLFileCdnRedirect extends TLAbsFile {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int dcId;

    protected TLBytes fileToken;

    protected TLBytes encryptionKey;

    protected TLBytes encryptionIv;

    protected TLVector<TLFileHash> fileHashes;

    private final String _constructor = "upload.fileCdnRedirect#0";

    public TLFileCdnRedirect() {
    }

    public TLFileCdnRedirect(int dcId, TLBytes fileToken, TLBytes encryptionKey, TLBytes encryptionIv, TLVector<TLFileHash> fileHashes) {
        this.dcId = dcId;
        this.fileToken = fileToken;
        this.encryptionKey = encryptionKey;
        this.encryptionIv = encryptionIv;
        this.fileHashes = fileHashes;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(dcId, stream);
        writeTLBytes(fileToken, stream);
        writeTLBytes(encryptionKey, stream);
        writeTLBytes(encryptionIv, stream);
        writeTLVector(fileHashes, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        dcId = readInt(stream);
        fileToken = readTLBytes(stream, context);
        encryptionKey = readTLBytes(stream, context);
        encryptionIv = readTLBytes(stream, context);
        fileHashes = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLBytesSerializedSize(fileToken);
        size += computeTLBytesSerializedSize(encryptionKey);
        size += computeTLBytesSerializedSize(encryptionIv);
        size += fileHashes.computeSerializedSize();
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

    public int getDcId() {
        return dcId;
    }

    public void setDcId(int dcId) {
        this.dcId = dcId;
    }

    public TLBytes getFileToken() {
        return fileToken;
    }

    public void setFileToken(TLBytes fileToken) {
        this.fileToken = fileToken;
    }

    public TLBytes getEncryptionKey() {
        return encryptionKey;
    }

    public void setEncryptionKey(TLBytes encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    public TLBytes getEncryptionIv() {
        return encryptionIv;
    }

    public void setEncryptionIv(TLBytes encryptionIv) {
        this.encryptionIv = encryptionIv;
    }

    public TLVector<TLFileHash> getFileHashes() {
        return fileHashes;
    }

    public void setFileHashes(TLVector<TLFileHash> fileHashes) {
        this.fileHashes = fileHashes;
    }
}
