package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputFile;
import com.github.badoualy.telegram.tl.api.TLAbsInputUser;
import com.github.badoualy.telegram.tl.api.TLAbsVideoSize;
import com.github.badoualy.telegram.tl.api.photos.TLPhoto;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLRequestPhotosUploadContactProfilePhoto extends TLMethod<TLPhoto> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean suggest;

    protected boolean save;

    protected TLAbsInputUser userId;

    protected TLAbsInputFile file;

    protected TLAbsInputFile video;

    protected Double videoStartTs;

    protected TLAbsVideoSize videoEmojiMarkup;

    private final String _constructor = "photos.uploadContactProfilePhoto#0";

    public TLRequestPhotosUploadContactProfilePhoto() {
    }

    public TLRequestPhotosUploadContactProfilePhoto(boolean suggest, boolean save, TLAbsInputUser userId, TLAbsInputFile file, TLAbsInputFile video, Double videoStartTs, TLAbsVideoSize videoEmojiMarkup) {
        this.suggest = suggest;
        this.save = save;
        this.userId = userId;
        this.file = file;
        this.video = video;
        this.videoStartTs = videoStartTs;
        this.videoEmojiMarkup = videoEmojiMarkup;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLPhoto deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLPhoto)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLPhoto) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = suggest ? (flags | 8) : (flags & ~8);
        flags = save ? (flags | 16) : (flags & ~16);
        flags = file != null ? (flags | 1) : (flags & ~1);
        flags = video != null ? (flags | 2) : (flags & ~2);
        flags = videoStartTs != null ? (flags | 4) : (flags & ~4);
        flags = videoEmojiMarkup != null ? (flags | 32) : (flags & ~32);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(userId, stream);
        if ((flags & 1) != 0) {
            if (file == null) throwNullFieldException("file", flags);
            writeTLObject(file, stream);
        }
        if ((flags & 2) != 0) {
            if (video == null) throwNullFieldException("video", flags);
            writeTLObject(video, stream);
        }
        if ((flags & 4) != 0) {
            if (videoStartTs == null) throwNullFieldException("videoStartTs", flags);
            writeDouble(videoStartTs, stream);
        }
        if ((flags & 32) != 0) {
            if (videoEmojiMarkup == null) throwNullFieldException("videoEmojiMarkup", flags);
            writeTLObject(videoEmojiMarkup, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        suggest = (flags & 8) != 0;
        save = (flags & 16) != 0;
        userId = readTLObject(stream, context, TLAbsInputUser.class, -1);
        file = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsInputFile.class, -1) : null;
        video = (flags & 2) != 0 ? readTLObject(stream, context, TLAbsInputFile.class, -1) : null;
        videoStartTs = (flags & 4) != 0 ? readDouble(stream) : null;
        videoEmojiMarkup = (flags & 32) != 0 ? readTLObject(stream, context, TLAbsVideoSize.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += userId.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (file == null) throwNullFieldException("file", flags);
            size += file.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (video == null) throwNullFieldException("video", flags);
            size += video.computeSerializedSize();
        }
        if ((flags & 4) != 0) {
            if (videoStartTs == null) throwNullFieldException("videoStartTs", flags);
            size += SIZE_DOUBLE;
        }
        if ((flags & 32) != 0) {
            if (videoEmojiMarkup == null) throwNullFieldException("videoEmojiMarkup", flags);
            size += videoEmojiMarkup.computeSerializedSize();
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

    public boolean getSuggest() {
        return suggest;
    }

    public void setSuggest(boolean suggest) {
        this.suggest = suggest;
    }

    public boolean getSave() {
        return save;
    }

    public void setSave(boolean save) {
        this.save = save;
    }

    public TLAbsInputUser getUserId() {
        return userId;
    }

    public void setUserId(TLAbsInputUser userId) {
        this.userId = userId;
    }

    public TLAbsInputFile getFile() {
        return file;
    }

    public void setFile(TLAbsInputFile file) {
        this.file = file;
    }

    public TLAbsInputFile getVideo() {
        return video;
    }

    public void setVideo(TLAbsInputFile video) {
        this.video = video;
    }

    public Double getVideoStartTs() {
        return videoStartTs;
    }

    public void setVideoStartTs(Double videoStartTs) {
        this.videoStartTs = videoStartTs;
    }

    public TLAbsVideoSize getVideoEmojiMarkup() {
        return videoEmojiMarkup;
    }

    public void setVideoEmojiMarkup(TLAbsVideoSize videoEmojiMarkup) {
        this.videoEmojiMarkup = videoEmojiMarkup;
    }
}
