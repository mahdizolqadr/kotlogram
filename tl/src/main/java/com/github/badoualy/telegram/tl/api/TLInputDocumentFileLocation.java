package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputDocumentFileLocation extends TLAbsInputFileLocation {

    public static final int CONSTRUCTOR_ID = 0xbad07584;

    protected long id;
    protected long accessHash;
    protected TLBytes fileReference;
    protected String thumbSize;

    private final String _constructor = "inputDocumentFileLocation#bad07584";

    public TLInputDocumentFileLocation() {
    }

    public TLInputDocumentFileLocation(long id, long accessHash, TLBytes fileReference, String thumbSize) {
        this.id = id;
        this.accessHash = accessHash;
        this.fileReference = fileReference;
        this.thumbSize = thumbSize;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(id, stream);
        writeLong(accessHash, stream);
        writeTLBytes(fileReference, stream);
        writeString(thumbSize, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readLong(stream);
        accessHash = readLong(stream);
        fileReference = readTLBytes(stream, context);
        thumbSize = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += computeTLBytesSerializedSize(fileReference);
        size += computeTLStringSerializedSize(thumbSize);
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

    public TLBytes getFileReference() {
        return fileReference;
    }

    public void setFileReference(TLBytes fileReference) {
        this.fileReference = fileReference;
    }

    public String getThumbSize() {
        return thumbSize;
    }

    public void setThumbSize(String thumbSize) {
        this.thumbSize = thumbSize;
    }
}
