package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPhotoSize extends TLAbsPhotoSize {

    public static final int CONSTRUCTOR_ID = 0x75c78e60;

    protected int w;

    protected int h;

    protected int size;

    private final String _constructor = "photoSize#75c78e60";

    public TLPhotoSize() {
    }

    public TLPhotoSize(String type, int w, int h, int size) {
        this.type = type;
        this.w = w;
        this.h = h;
        this.size = size;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(type, stream);
        writeInt(w, stream);
        writeInt(h, stream);
        writeInt(size, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        type = readTLString(stream);
        w = readInt(stream);
        h = readInt(stream);
        size = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(type);
        size += SIZE_INT32;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
