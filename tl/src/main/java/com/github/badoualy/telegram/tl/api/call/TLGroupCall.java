package com.github.badoualy.telegram.tl.api.call;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

public class TLGroupCall extends TLAbsGroupCall {

    public static final int CONSTRUCTOR_ID = 0xd597650c;

    protected int flags;
    protected boolean joinMuted;
    protected boolean canChangeJoinMuted;
    protected boolean joinDateAsc;
    protected boolean scheduleStartSubscribed;
    protected boolean canStartVideo;
    protected boolean recordVideoActive;
    protected boolean rtmpStream;
    protected boolean listenersHidden;
    protected int participantsCount;
    protected String title;
    protected Integer streamDcId;
    protected Integer recordStartDate;
    protected Integer scheduleDate;
    protected Integer unmutedVideoCount;
    protected int unmutedVideoLimit;
    protected int version;

    private final String _constructor = "groupCall#d597650c";

    public TLGroupCall() {
    }

    public TLGroupCall(boolean joinMuted, boolean canChangeJoinMuted, boolean joinDateAsc,
                       boolean scheduleStartSubscribed, boolean canStartVideo, boolean recordVideoActive,
                       boolean rtmpStream, boolean listenersHidden, long id, long accessHash, int participantsCount,
                       String title, Integer streamDcId, Integer recordStartDate, Integer scheduleDate,
                       Integer unmutedVideoCount, int unmutedVideoLimit, int version) {
        super(id, accessHash);
        this.joinMuted = joinMuted;
        this.canChangeJoinMuted = canChangeJoinMuted;
        this.joinDateAsc = joinDateAsc;
        this.scheduleStartSubscribed = scheduleStartSubscribed;
        this.canStartVideo = canStartVideo;
        this.recordVideoActive = recordVideoActive;
        this.rtmpStream = rtmpStream;
        this.listenersHidden = listenersHidden;
        this.participantsCount = participantsCount;
        this.title = title;
        this.streamDcId = streamDcId;
        this.recordStartDate = recordStartDate;
        this.scheduleDate = scheduleDate;
        this.unmutedVideoCount = unmutedVideoCount;
        this.unmutedVideoLimit = unmutedVideoLimit;
        this.version = version;
    }

    protected void computeFlags() {
        flags = 0;
        flags = joinMuted ? (flags | 2) : (flags & ~2);
        flags = canChangeJoinMuted ? (flags | 4) : (flags & ~4);
        flags = joinDateAsc ? (flags | 64) : (flags & ~64);
        flags = scheduleStartSubscribed ? (flags | 256) : (flags & ~256);
        flags = canStartVideo ? (flags | 512) : (flags & ~512);
        flags = recordVideoActive ? (flags | 2048) : (flags & ~2048);
        flags = rtmpStream ? (flags | 4096) : (flags & ~4096);
        flags = listenersHidden ? (flags | 8192) : (flags & ~8192);
        flags = title != null ? (flags | 8) : (flags & ~8);
        flags = streamDcId != null ? (flags | 16) : (flags & ~16);
        flags = recordStartDate != null ? (flags | 32) : (flags & ~32);
        flags = scheduleDate != null ? (flags | 128) : (flags & ~128);
        flags = unmutedVideoCount != null ? (flags | 1024) : (flags & ~1024);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();
        writeInt(flags, stream);
        writeLong(id, stream);
        writeLong(accessHash, stream);
        writeInt(participantsCount, stream);
        if ((flags & 8) != 0) {
            if (title == null) {
                throwNullFieldException("title", flags);
            }
            writeString(title, stream);
        }
        if ((flags & 16) != 0) {
            if (streamDcId == null) {
                throwNullFieldException("streamDcId", flags);
            }
            writeInt(streamDcId, stream);
        }
        if ((flags & 32) != 0) {
            if (recordStartDate == null) {
                throwNullFieldException("recordStartDate", flags);
            }
            writeInt(recordStartDate, stream);
        }
        if ((flags & 128) != 0) {
            if (scheduleDate == null) {
                throwNullFieldException("scheduleDate", flags);
            }
            writeInt(scheduleDate, stream);
        }
        if ((flags & 1024) != 0) {
            if (unmutedVideoCount == null) {
                throwNullFieldException("unmutedVideoCount", flags);
            }
            writeInt(unmutedVideoCount, stream);
        }
        writeInt(unmutedVideoLimit, stream);
        writeInt(version, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        joinMuted = (flags & 2) != 0;
        canChangeJoinMuted = (flags & 4) != 0;
        joinDateAsc = (flags & 64) != 0;
        scheduleStartSubscribed = (flags & 256) != 0;
        canStartVideo = (flags & 512) != 0;
        recordVideoActive = (flags & 2048) != 0;
        rtmpStream = (flags & 4096) != 0;
        listenersHidden = (flags & 8192) != 0;
        id = readLong(stream);
        accessHash = readLong(stream);
        participantsCount = readInt(stream);
        title = (flags & 8) != 0 ? readTLString(stream) : null;
        streamDcId = (flags & 16) != 0 ? readInt(stream) : null;
        recordStartDate = (flags & 32) != 0 ? readInt(stream) : null;
        scheduleDate = (flags & 128) != 0 ? readInt(stream) : null;
        unmutedVideoCount = (flags & 1024) != 0 ? readInt(stream) : null;
        unmutedVideoLimit = readInt(stream);
        version = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += SIZE_INT32;
        if ((flags & 8) != 0) {
            if (title == null) {
                throwNullFieldException("title", flags);
            }
            size += computeTLStringSerializedSize(title);
        }
        if ((flags & 16) != 0) {
            if (streamDcId == null) {
                throwNullFieldException("streamDcId", flags);
            }
            size += SIZE_INT32;
        }
        if ((flags & 32) != 0) {
            if (recordStartDate == null) {
                throwNullFieldException("recordStartDate", flags);
            }
            size += SIZE_INT32;
        }
        if ((flags & 128) != 0) {
            if (scheduleDate == null) {
                throwNullFieldException("scheduleDate", flags);
            }
            size += SIZE_INT32;
        }
        if ((flags & 1024) != 0) {
            if (unmutedVideoCount == null) {
                throwNullFieldException("unmutedVideoCount", flags);
            }
            size += SIZE_INT32;
        }
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

    public boolean isJoinMuted() {
        return joinMuted;
    }

    public void setJoinMuted(boolean joinMuted) {
        this.joinMuted = joinMuted;
    }

    public boolean isCanChangeJoinMuted() {
        return canChangeJoinMuted;
    }

    public void setCanChangeJoinMuted(boolean canChangeJoinMuted) {
        this.canChangeJoinMuted = canChangeJoinMuted;
    }

    public boolean isJoinDateAsc() {
        return joinDateAsc;
    }

    public void setJoinDateAsc(boolean joinDateAsc) {
        this.joinDateAsc = joinDateAsc;
    }

    public boolean isScheduleStartSubscribed() {
        return scheduleStartSubscribed;
    }

    public void setScheduleStartSubscribed(boolean scheduleStartSubscribed) {
        this.scheduleStartSubscribed = scheduleStartSubscribed;
    }

    public boolean isCanStartVideo() {
        return canStartVideo;
    }

    public void setCanStartVideo(boolean canStartVideo) {
        this.canStartVideo = canStartVideo;
    }

    public boolean isRecordVideoActive() {
        return recordVideoActive;
    }

    public void setRecordVideoActive(boolean recordVideoActive) {
        this.recordVideoActive = recordVideoActive;
    }

    public boolean isRtmpStream() {
        return rtmpStream;
    }

    public void setRtmpStream(boolean rtmpStream) {
        this.rtmpStream = rtmpStream;
    }

    public boolean isListenersHidden() {
        return listenersHidden;
    }

    public void setListenersHidden(boolean listenersHidden) {
        this.listenersHidden = listenersHidden;
    }

    public int getParticipantsCount() {
        return participantsCount;
    }

    public void setParticipantsCount(int participantsCount) {
        this.participantsCount = participantsCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStreamDcId() {
        return streamDcId;
    }

    public void setStreamDcId(Integer streamDcId) {
        this.streamDcId = streamDcId;
    }

    public Integer getRecordStartDate() {
        return recordStartDate;
    }

    public void setRecordStartDate(Integer recordStartDate) {
        this.recordStartDate = recordStartDate;
    }

    public Integer getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Integer scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Integer getUnmutedVideoCount() {
        return unmutedVideoCount;
    }

    public void setUnmutedVideoCount(Integer unmutedVideoCount) {
        this.unmutedVideoCount = unmutedVideoCount;
    }

    public int getUnmutedVideoLimit() {
        return unmutedVideoLimit;
    }

    public void setUnmutedVideoLimit(int unmutedVideoLimit) {
        this.unmutedVideoLimit = unmutedVideoLimit;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
