package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLAutoSaveSettings extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean photos;

    protected boolean videos;

    protected Long videoMaxSize;

    private final String _constructor = "autoSaveSettings#0";

    public TLAutoSaveSettings() {
    }

    public TLAutoSaveSettings(boolean photos, boolean videos, Long videoMaxSize) {
        this.photos = photos;
        this.videos = videos;
        this.videoMaxSize = videoMaxSize;
    }

    private void computeFlags() {
        flags = 0;
        flags = photos ? (flags | 1) : (flags & ~1);
        flags = videos ? (flags | 2) : (flags & ~2);
        flags = videoMaxSize != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 4) != 0) {
            if (videoMaxSize == null) throwNullFieldException("videoMaxSize", flags);
            writeLong(videoMaxSize, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        photos = (flags & 1) != 0;
        videos = (flags & 2) != 0;
        videoMaxSize = (flags & 4) != 0 ? readLong(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 4) != 0) {
            if (videoMaxSize == null) throwNullFieldException("videoMaxSize", flags);
            size += SIZE_INT64;
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

    public boolean getPhotos() {
        return photos;
    }

    public void setPhotos(boolean photos) {
        this.photos = photos;
    }

    public boolean getVideos() {
        return videos;
    }

    public void setVideos(boolean videos) {
        this.videos = videos;
    }

    public Long getVideoMaxSize() {
        return videoMaxSize;
    }

    public void setVideoMaxSize(Long videoMaxSize) {
        this.videoMaxSize = videoMaxSize;
    }
}
