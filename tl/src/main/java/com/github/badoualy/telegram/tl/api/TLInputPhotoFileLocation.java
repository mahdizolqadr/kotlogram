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
public class TLInputPhotoFileLocation extends TLAbsInputFileLocation {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected long id;

    protected long accessHash;

    protected TLBytes fileReference;

    protected String thumbSize;

    private final String _constructor = "inputPhotoFileLocation#0";

    public TLInputPhotoFileLocation() {
    }

    public TLInputPhotoFileLocation(long id, long accessHash, TLBytes fileReference, String thumbSize) {
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
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
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
