package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

public class TLPhotoStrippedSize extends TLAbsPhotoSize {

    public static final int CONSTRUCTOR_ID = 0xe0b0bc2e;

    protected TLBytes bytes;

    private final String _constructor = "photoStrippedSize#e0b0bc2e";

    public TLPhotoStrippedSize() {
    }

    public TLPhotoStrippedSize(String type, TLBytes bytes) {
        this.type = type;
        this.bytes = bytes;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(type, stream);
        writeTLBytes(bytes, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        type = readTLString(stream);
        bytes = readTLBytes(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(type);
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

    public TLBytes getBytes() {
        return bytes;
    }

    public void setBytes(TLBytes bytes) {
        this.bytes = bytes;
    }
}
