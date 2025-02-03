package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLAutoDownloadSettings extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean disabled;

    protected boolean videoPreloadLarge;

    protected boolean audioPreloadNext;

    protected boolean phonecallsLessData;

    protected boolean storiesPreload;

    protected int photoSizeMax;

    protected long videoSizeMax;

    protected long fileSizeMax;

    protected int videoUploadMaxbitrate;

    protected int smallQueueActiveOperationsMax;

    protected int largeQueueActiveOperationsMax;

    private final String _constructor = "autoDownloadSettings#0";

    public TLAutoDownloadSettings() {
    }

    public TLAutoDownloadSettings(boolean disabled, boolean videoPreloadLarge, boolean audioPreloadNext, boolean phonecallsLessData, boolean storiesPreload, int photoSizeMax, long videoSizeMax, long fileSizeMax, int videoUploadMaxbitrate, int smallQueueActiveOperationsMax, int largeQueueActiveOperationsMax) {
        this.disabled = disabled;
        this.videoPreloadLarge = videoPreloadLarge;
        this.audioPreloadNext = audioPreloadNext;
        this.phonecallsLessData = phonecallsLessData;
        this.storiesPreload = storiesPreload;
        this.photoSizeMax = photoSizeMax;
        this.videoSizeMax = videoSizeMax;
        this.fileSizeMax = fileSizeMax;
        this.videoUploadMaxbitrate = videoUploadMaxbitrate;
        this.smallQueueActiveOperationsMax = smallQueueActiveOperationsMax;
        this.largeQueueActiveOperationsMax = largeQueueActiveOperationsMax;
    }

    private void computeFlags() {
        flags = 0;
        flags = disabled ? (flags | 1) : (flags & ~1);
        flags = videoPreloadLarge ? (flags | 2) : (flags & ~2);
        flags = audioPreloadNext ? (flags | 4) : (flags & ~4);
        flags = phonecallsLessData ? (flags | 8) : (flags & ~8);
        flags = storiesPreload ? (flags | 16) : (flags & ~16);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(photoSizeMax, stream);
        writeLong(videoSizeMax, stream);
        writeLong(fileSizeMax, stream);
        writeInt(videoUploadMaxbitrate, stream);
        writeInt(smallQueueActiveOperationsMax, stream);
        writeInt(largeQueueActiveOperationsMax, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        disabled = (flags & 1) != 0;
        videoPreloadLarge = (flags & 2) != 0;
        audioPreloadNext = (flags & 4) != 0;
        phonecallsLessData = (flags & 8) != 0;
        storiesPreload = (flags & 16) != 0;
        photoSizeMax = readInt(stream);
        videoSizeMax = readLong(stream);
        fileSizeMax = readLong(stream);
        videoUploadMaxbitrate = readInt(stream);
        smallQueueActiveOperationsMax = readInt(stream);
        largeQueueActiveOperationsMax = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT64;
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

    public boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean getVideoPreloadLarge() {
        return videoPreloadLarge;
    }

    public void setVideoPreloadLarge(boolean videoPreloadLarge) {
        this.videoPreloadLarge = videoPreloadLarge;
    }

    public boolean getAudioPreloadNext() {
        return audioPreloadNext;
    }

    public void setAudioPreloadNext(boolean audioPreloadNext) {
        this.audioPreloadNext = audioPreloadNext;
    }

    public boolean getPhonecallsLessData() {
        return phonecallsLessData;
    }

    public void setPhonecallsLessData(boolean phonecallsLessData) {
        this.phonecallsLessData = phonecallsLessData;
    }

    public boolean getStoriesPreload() {
        return storiesPreload;
    }

    public void setStoriesPreload(boolean storiesPreload) {
        this.storiesPreload = storiesPreload;
    }

    public int getPhotoSizeMax() {
        return photoSizeMax;
    }

    public void setPhotoSizeMax(int photoSizeMax) {
        this.photoSizeMax = photoSizeMax;
    }

    public long getVideoSizeMax() {
        return videoSizeMax;
    }

    public void setVideoSizeMax(long videoSizeMax) {
        this.videoSizeMax = videoSizeMax;
    }

    public long getFileSizeMax() {
        return fileSizeMax;
    }

    public void setFileSizeMax(long fileSizeMax) {
        this.fileSizeMax = fileSizeMax;
    }

    public int getVideoUploadMaxbitrate() {
        return videoUploadMaxbitrate;
    }

    public void setVideoUploadMaxbitrate(int videoUploadMaxbitrate) {
        this.videoUploadMaxbitrate = videoUploadMaxbitrate;
    }

    public int getSmallQueueActiveOperationsMax() {
        return smallQueueActiveOperationsMax;
    }

    public void setSmallQueueActiveOperationsMax(int smallQueueActiveOperationsMax) {
        this.smallQueueActiveOperationsMax = smallQueueActiveOperationsMax;
    }

    public int getLargeQueueActiveOperationsMax() {
        return largeQueueActiveOperationsMax;
    }

    public void setLargeQueueActiveOperationsMax(int largeQueueActiveOperationsMax) {
        this.largeQueueActiveOperationsMax = largeQueueActiveOperationsMax;
    }
}
