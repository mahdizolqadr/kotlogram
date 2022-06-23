package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

public class TLVideoSize extends TLObject {

    public static final int CONSTRUCTOR_ID = 0xde33b094;

    protected int flags;

    protected String type;

    protected int w;

    protected int h;

    protected int size;

    protected Double videoStartTs;

    private final String _constructor = "videoSize#de33b094";

    public TLVideoSize() {
    }

    public TLVideoSize(String type, int w, int h, int size, double videoStartTs) {
        this.type = type;
        this.w = w;
        this.h = h;
        this.size = size;
        this.videoStartTs = videoStartTs;
    }

    private void computeFlags() {
        flags = 0;
        flags = videoStartTs != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();
        writeInt(flags, stream);
        writeString(type, stream);
        writeInt(w, stream);
        writeInt(h, stream);
        writeInt(size, stream);
        if ((flags & 1) != 0) {
            if (videoStartTs == null) {
                throwNullFieldException("videoStartTs", flags);
            }
            writeDouble(videoStartTs, stream);
        }
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        type = readTLString(stream);
        w = readInt(stream);
        h = readInt(stream);
        size = readInt(stream);
        videoStartTs = (flags & 1) != 0 ? readDouble(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(type);
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (videoStartTs == null) {
                throwNullFieldException("videoStartTs", flags);
            }
            size += SIZE_DOUBLE;
        }
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Double getVideoStartTs() {
        return videoStartTs;
    }

    public void setVideoStartTs(Double videoStartTs) {
        this.videoStartTs = videoStartTs;
    }
}
