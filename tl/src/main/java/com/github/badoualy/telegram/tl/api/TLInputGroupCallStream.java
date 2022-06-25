package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.call.TLInputGroupCall;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;

public class TLInputGroupCallStream extends TLAbsInputFileLocation {

    public static final int CONSTRUCTOR_ID = 0x598a92a;

    protected int flags;
    protected TLInputGroupCall call;
    protected long timeMs;
    protected int scale;
    protected Integer videoChannel;
    protected Integer videoQuality;

    private final String _constructor = "inputGroupCallStream#598a92a";

    public TLInputGroupCallStream() {
    }

    public TLInputGroupCallStream(TLInputGroupCall call, long timeMs, int scale, Integer videoChannel,
                                  Integer videoQuality) {
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
        writeInt(flags, stream);
        writeTLObject(call, stream);
        writeLong(timeMs, stream);
        writeInt(scale, stream);
        if ((flags & 1) != 0) {
            if (videoChannel == null) {
                throwNullFieldException("videoChannel", flags);
            }
            if (videoQuality == null) {
                throwNullFieldException("videoQuality", flags);
            }
            writeInt(videoChannel, stream);
            writeInt(videoQuality, stream);
        }
    }

    @Override
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
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += call.computeSerializedSize();
        size += SIZE_INT64;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (videoChannel == null) {
                throwNullFieldException("videoChannel", flags);
            }
            if (videoQuality == null) {
                throwNullFieldException("videoQuality", flags);
            }
            size += SIZE_INT32;
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
