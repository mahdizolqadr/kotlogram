package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLIntVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLIntVector;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

public class TLPhotoSizeProgressive extends TLAbsPhotoSize {

    public static final int CONSTRUCTOR_ID = 0xfa3efb95;

    protected int w;

    protected int h;

    protected TLIntVector sizes;

    private final String _constructor = "photoSizeProgressive#fa3efb95";

    public TLPhotoSizeProgressive() {
    }

    public TLPhotoSizeProgressive(String type, int w, int h, TLIntVector sizes) {
        this.type = type;
        this.w = w;
        this.h = h;
        this.sizes = sizes;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(type, stream);
        writeInt(w, stream);
        writeInt(h, stream);
        writeTLVector(sizes, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        type = readTLString(stream);
        w = readInt(stream);
        h = readInt(stream);
        sizes = readTLIntVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(type);
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += sizes.computeSerializedSize();
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

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public TLIntVector getSizes() {
        return sizes;
    }

    public void setSizes(TLIntVector sizes) {
        this.sizes = sizes;
    }
}
