package com.github.badoualy.telegram.tl.api.upload;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.storage.TLAbsFileType;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLWebFile extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int size;

    protected String mimeType;

    protected TLAbsFileType fileType;

    protected int mtime;

    protected TLBytes bytes;

    private final String _constructor = "upload.webFile#0";

    public TLWebFile() {
    }

    public TLWebFile(int size, String mimeType, TLAbsFileType fileType, int mtime, TLBytes bytes) {
        this.size = size;
        this.mimeType = mimeType;
        this.fileType = fileType;
        this.mtime = mtime;
        this.bytes = bytes;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(size, stream);
        writeString(mimeType, stream);
        writeTLObject(fileType, stream);
        writeInt(mtime, stream);
        writeTLBytes(bytes, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        size = readInt(stream);
        mimeType = readTLString(stream);
        fileType = readTLObject(stream, context, TLAbsFileType.class, -1);
        mtime = readInt(stream);
        bytes = readTLBytes(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(mimeType);
        size += fileType.computeSerializedSize();
        size += SIZE_INT32;
        size += computeTLBytesSerializedSize(bytes);
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public TLAbsFileType getFileType() {
        return fileType;
    }

    public void setFileType(TLAbsFileType fileType) {
        this.fileType = fileType;
    }

    public int getMtime() {
        return mtime;
    }

    public void setMtime(int mtime) {
        this.mtime = mtime;
    }

    public TLBytes getBytes() {
        return bytes;
    }

    public void setBytes(TLBytes bytes) {
        this.bytes = bytes;
    }
}
