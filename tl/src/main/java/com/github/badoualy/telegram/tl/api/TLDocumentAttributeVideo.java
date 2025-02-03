package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLDocumentAttributeVideo extends TLAbsDocumentAttribute {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean roundMessage;

    protected boolean supportsStreaming;

    protected boolean nosound;

    protected double duration;

    protected int w;

    protected int h;

    protected Integer preloadPrefixSize;

    protected Double videoStartTs;

    protected String videoCodec;

    private final String _constructor = "documentAttributeVideo#0";

    public TLDocumentAttributeVideo() {
    }

    public TLDocumentAttributeVideo(boolean roundMessage, boolean supportsStreaming, boolean nosound, double duration, int w, int h, Integer preloadPrefixSize, Double videoStartTs, String videoCodec) {
        this.roundMessage = roundMessage;
        this.supportsStreaming = supportsStreaming;
        this.nosound = nosound;
        this.duration = duration;
        this.w = w;
        this.h = h;
        this.preloadPrefixSize = preloadPrefixSize;
        this.videoStartTs = videoStartTs;
        this.videoCodec = videoCodec;
    }

    private void computeFlags() {
        flags = 0;
        flags = roundMessage ? (flags | 1) : (flags & ~1);
        flags = supportsStreaming ? (flags | 2) : (flags & ~2);
        flags = nosound ? (flags | 8) : (flags & ~8);
        flags = preloadPrefixSize != null ? (flags | 4) : (flags & ~4);
        flags = videoStartTs != null ? (flags | 16) : (flags & ~16);
        flags = videoCodec != null ? (flags | 32) : (flags & ~32);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeDouble(duration, stream);
        writeInt(w, stream);
        writeInt(h, stream);
        if ((flags & 4) != 0) {
            if (preloadPrefixSize == null) throwNullFieldException("preloadPrefixSize", flags);
            writeInt(preloadPrefixSize, stream);
        }
        if ((flags & 16) != 0) {
            if (videoStartTs == null) throwNullFieldException("videoStartTs", flags);
            writeDouble(videoStartTs, stream);
        }
        if ((flags & 32) != 0) {
            if (videoCodec == null) throwNullFieldException("videoCodec", flags);
            writeString(videoCodec, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        roundMessage = (flags & 1) != 0;
        supportsStreaming = (flags & 2) != 0;
        nosound = (flags & 8) != 0;
        duration = readDouble(stream);
        w = readInt(stream);
        h = readInt(stream);
        preloadPrefixSize = (flags & 4) != 0 ? readInt(stream) : null;
        videoStartTs = (flags & 16) != 0 ? readDouble(stream) : null;
        videoCodec = (flags & 32) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_DOUBLE;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 4) != 0) {
            if (preloadPrefixSize == null) throwNullFieldException("preloadPrefixSize", flags);
            size += SIZE_INT32;
        }
        if ((flags & 16) != 0) {
            if (videoStartTs == null) throwNullFieldException("videoStartTs", flags);
            size += SIZE_DOUBLE;
        }
        if ((flags & 32) != 0) {
            if (videoCodec == null) throwNullFieldException("videoCodec", flags);
            size += computeTLStringSerializedSize(videoCodec);
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

    public boolean getRoundMessage() {
        return roundMessage;
    }

    public void setRoundMessage(boolean roundMessage) {
        this.roundMessage = roundMessage;
    }

    public boolean getSupportsStreaming() {
        return supportsStreaming;
    }

    public void setSupportsStreaming(boolean supportsStreaming) {
        this.supportsStreaming = supportsStreaming;
    }

    public boolean getNosound() {
        return nosound;
    }

    public void setNosound(boolean nosound) {
        this.nosound = nosound;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
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

    public Integer getPreloadPrefixSize() {
        return preloadPrefixSize;
    }

    public void setPreloadPrefixSize(Integer preloadPrefixSize) {
        this.preloadPrefixSize = preloadPrefixSize;
    }

    public Double getVideoStartTs() {
        return videoStartTs;
    }

    public void setVideoStartTs(Double videoStartTs) {
        this.videoStartTs = videoStartTs;
    }

    public String getVideoCodec() {
        return videoCodec;
    }

    public void setVideoCodec(String videoCodec) {
        this.videoCodec = videoCodec;
    }
}
