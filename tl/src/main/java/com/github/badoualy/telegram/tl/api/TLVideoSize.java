package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Double;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLVideoSize extends TLAbsVideoSize {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected String type;

    protected int w;

    protected int h;

    protected int size;

    protected Double videoStartTs;

    private final String _constructor = "videoSize#0";

    public TLVideoSize() {
    }

    public TLVideoSize(String type, int w, int h, int size, Double videoStartTs) {
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
            if (videoStartTs == null) throwNullFieldException("videoStartTs", flags);
            writeDouble(videoStartTs, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
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
            if (videoStartTs == null) throwNullFieldException("videoStartTs", flags);
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
