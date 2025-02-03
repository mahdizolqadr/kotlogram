package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputGroupCallStream extends TLAbsInputFileLocation {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLInputGroupCall call;

    protected long timeMs;

    protected int scale;

    protected Integer videoChannel;

    protected Integer videoQuality;

    private final String _constructor = "inputGroupCallStream#0";

    public TLInputGroupCallStream() {
    }

    public TLInputGroupCallStream(TLInputGroupCall call, long timeMs, int scale, Integer videoChannel, Integer videoQuality) {
        this.call = call;
        this.timeMs = timeMs;
        this.scale = scale;
        this.videoChannel = videoChannel;
        this.videoQuality = videoQuality;
    }

    private void computeFlags() {
        flags = 0;
        flags = videoChannel != null ? (flags | 1) : (flags & ~1);
        flags = videoQuality != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(call, stream);
        writeLong(timeMs, stream);
        writeInt(scale, stream);
        if ((flags & 1) != 0) {
            if (videoChannel == null) throwNullFieldException("videoChannel", flags);
            writeInt(videoChannel, stream);
        }
        if ((flags & 1) != 0) {
            if (videoQuality == null) throwNullFieldException("videoQuality", flags);
            writeInt(videoQuality, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        call = readTLObject(stream, context, TLInputGroupCall.class, TLInputGroupCall.CONSTRUCTOR_ID);
        timeMs = readLong(stream);
        scale = readInt(stream);
        videoChannel = (flags & 1) != 0 ? readInt(stream) : null;
        videoQuality = (flags & 1) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += call.computeSerializedSize();
        size += SIZE_INT64;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (videoChannel == null) throwNullFieldException("videoChannel", flags);
            size += SIZE_INT32;
        }
        if ((flags & 1) != 0) {
            if (videoQuality == null) throwNullFieldException("videoQuality", flags);
            size += SIZE_INT32;
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

    public TLInputGroupCall getCall() {
        return call;
    }

    public void setCall(TLInputGroupCall call) {
        this.call = call;
    }

    public long getTimeMs() {
        return timeMs;
    }

    public void setTimeMs(long timeMs) {
        this.timeMs = timeMs;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public Integer getVideoChannel() {
        return videoChannel;
    }

    public void setVideoChannel(Integer videoChannel) {
        this.videoChannel = videoChannel;
    }

    public Integer getVideoQuality() {
        return videoQuality;
    }

    public void setVideoQuality(Integer videoQuality) {
        this.videoQuality = videoQuality;
    }
}
