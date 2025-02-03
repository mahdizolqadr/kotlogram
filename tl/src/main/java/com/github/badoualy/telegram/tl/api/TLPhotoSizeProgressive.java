package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLIntVector;
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
public class TLPhotoSizeProgressive extends TLAbsPhotoSize {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int w;

    protected int h;

    protected TLIntVector sizes;

    private final String _constructor = "photoSizeProgressive#0";

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
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
