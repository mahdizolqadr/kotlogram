package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLGroupCallParticipant extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean muted;

    protected boolean left;

    protected boolean canSelfUnmute;

    protected boolean justJoined;

    protected boolean versioned;

    protected boolean min;

    protected boolean mutedByYou;

    protected boolean volumeByAdmin;

    protected boolean self;

    protected boolean videoJoined;

    protected TLAbsPeer peer;

    protected int date;

    protected Integer activeDate;

    protected int source;

    protected Integer volume;

    protected String about;

    protected Long raiseHandRating;

    protected TLGroupCallParticipantVideo video;

    protected TLGroupCallParticipantVideo presentation;

    private final String _constructor = "groupCallParticipant#0";

    public TLGroupCallParticipant() {
    }

    public TLGroupCallParticipant(boolean muted, boolean left, boolean canSelfUnmute, boolean justJoined, boolean versioned, boolean min, boolean mutedByYou, boolean volumeByAdmin, boolean self, boolean videoJoined, TLAbsPeer peer, int date, Integer activeDate, int source, Integer volume, String about, Long raiseHandRating, TLGroupCallParticipantVideo video, TLGroupCallParticipantVideo presentation) {
        this.muted = muted;
        this.left = left;
        this.canSelfUnmute = canSelfUnmute;
        this.justJoined = justJoined;
        this.versioned = versioned;
        this.min = min;
        this.mutedByYou = mutedByYou;
        this.volumeByAdmin = volumeByAdmin;
        this.self = self;
        this.videoJoined = videoJoined;
        this.peer = peer;
        this.date = date;
        this.activeDate = activeDate;
        this.source = source;
        this.volume = volume;
        this.about = about;
        this.raiseHandRating = raiseHandRating;
        this.video = video;
        this.presentation = presentation;
    }

    private void computeFlags() {
        flags = 0;
        flags = muted ? (flags | 1) : (flags & ~1);
        flags = left ? (flags | 2) : (flags & ~2);
        flags = canSelfUnmute ? (flags | 4) : (flags & ~4);
        flags = justJoined ? (flags | 16) : (flags & ~16);
        flags = versioned ? (flags | 32) : (flags & ~32);
        flags = min ? (flags | 256) : (flags & ~256);
        flags = mutedByYou ? (flags | 512) : (flags & ~512);
        flags = volumeByAdmin ? (flags | 1024) : (flags & ~1024);
        flags = self ? (flags | 4096) : (flags & ~4096);
        flags = videoJoined ? (flags | 32768) : (flags & ~32768);
        flags = activeDate != null ? (flags | 8) : (flags & ~8);
        flags = volume != null ? (flags | 128) : (flags & ~128);
        flags = about != null ? (flags | 2048) : (flags & ~2048);
        flags = raiseHandRating != null ? (flags | 8192) : (flags & ~8192);
        flags = video != null ? (flags | 64) : (flags & ~64);
        flags = presentation != null ? (flags | 16384) : (flags & ~16384);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peer, stream);
        writeInt(date, stream);
        if ((flags & 8) != 0) {
            if (activeDate == null) throwNullFieldException("activeDate", flags);
            writeInt(activeDate, stream);
        }
        writeInt(source, stream);
        if ((flags & 128) != 0) {
            if (volume == null) throwNullFieldException("volume", flags);
            writeInt(volume, stream);
        }
        if ((flags & 2048) != 0) {
            if (about == null) throwNullFieldException("about", flags);
            writeString(about, stream);
        }
        if ((flags & 8192) != 0) {
            if (raiseHandRating == null) throwNullFieldException("raiseHandRating", flags);
            writeLong(raiseHandRating, stream);
        }
        if ((flags & 64) != 0) {
            if (video == null) throwNullFieldException("video", flags);
            writeTLObject(video, stream);
        }
        if ((flags & 16384) != 0) {
            if (presentation == null) throwNullFieldException("presentation", flags);
            writeTLObject(presentation, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        muted = (flags & 1) != 0;
        left = (flags & 2) != 0;
        canSelfUnmute = (flags & 4) != 0;
        justJoined = (flags & 16) != 0;
        versioned = (flags & 32) != 0;
        min = (flags & 256) != 0;
        mutedByYou = (flags & 512) != 0;
        volumeByAdmin = (flags & 1024) != 0;
        self = (flags & 4096) != 0;
        videoJoined = (flags & 32768) != 0;
        peer = readTLObject(stream, context, TLAbsPeer.class, -1);
        date = readInt(stream);
        activeDate = (flags & 8) != 0 ? readInt(stream) : null;
        source = readInt(stream);
        volume = (flags & 128) != 0 ? readInt(stream) : null;
        about = (flags & 2048) != 0 ? readTLString(stream) : null;
        raiseHandRating = (flags & 8192) != 0 ? readLong(stream) : null;
        video = (flags & 64) != 0 ? readTLObject(stream, context, TLGroupCallParticipantVideo.class, TLGroupCallParticipantVideo.CONSTRUCTOR_ID) : null;
        presentation = (flags & 16384) != 0 ? readTLObject(stream, context, TLGroupCallParticipantVideo.class, TLGroupCallParticipantVideo.CONSTRUCTOR_ID) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        size += SIZE_INT32;
        if ((flags & 8) != 0) {
            if (activeDate == null) throwNullFieldException("activeDate", flags);
            size += SIZE_INT32;
        }
        size += SIZE_INT32;
        if ((flags & 128) != 0) {
            if (volume == null) throwNullFieldException("volume", flags);
            size += SIZE_INT32;
        }
        if ((flags & 2048) != 0) {
            if (about == null) throwNullFieldException("about", flags);
            size += computeTLStringSerializedSize(about);
        }
        if ((flags & 8192) != 0) {
            if (raiseHandRating == null) throwNullFieldException("raiseHandRating", flags);
            size += SIZE_INT64;
        }
        if ((flags & 64) != 0) {
            if (video == null) throwNullFieldException("video", flags);
            size += video.computeSerializedSize();
        }
        if ((flags & 16384) != 0) {
            if (presentation == null) throwNullFieldException("presentation", flags);
            size += presentation.computeSerializedSize();
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

    public boolean getMuted() {
        return muted;
    }

    public void setMuted(boolean muted) {
        this.muted = muted;
    }

    public boolean getLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean getCanSelfUnmute() {
        return canSelfUnmute;
    }

    public void setCanSelfUnmute(boolean canSelfUnmute) {
        this.canSelfUnmute = canSelfUnmute;
    }

    public boolean getJustJoined() {
        return justJoined;
    }

    public void setJustJoined(boolean justJoined) {
        this.justJoined = justJoined;
    }

    public boolean getVersioned() {
        return versioned;
    }

    public void setVersioned(boolean versioned) {
        this.versioned = versioned;
    }

    public boolean getMin() {
        return min;
    }

    public void setMin(boolean min) {
        this.min = min;
    }

    public boolean getMutedByYou() {
        return mutedByYou;
    }

    public void setMutedByYou(boolean mutedByYou) {
        this.mutedByYou = mutedByYou;
    }

    public boolean getVolumeByAdmin() {
        return volumeByAdmin;
    }

    public void setVolumeByAdmin(boolean volumeByAdmin) {
        this.volumeByAdmin = volumeByAdmin;
    }

    public boolean getSelf() {
        return self;
    }

    public void setSelf(boolean self) {
        this.self = self;
    }

    public boolean getVideoJoined() {
        return videoJoined;
    }

    public void setVideoJoined(boolean videoJoined) {
        this.videoJoined = videoJoined;
    }

    public TLAbsPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsPeer peer) {
        this.peer = peer;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public Integer getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Integer activeDate) {
        this.activeDate = activeDate;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Long getRaiseHandRating() {
        return raiseHandRating;
    }

    public void setRaiseHandRating(Long raiseHandRating) {
        this.raiseHandRating = raiseHandRating;
    }

    public TLGroupCallParticipantVideo getVideo() {
        return video;
    }

    public void setVideo(TLGroupCallParticipantVideo video) {
        this.video = video;
    }

    public TLGroupCallParticipantVideo getPresentation() {
        return presentation;
    }

    public void setPresentation(TLGroupCallParticipantVideo presentation) {
        this.presentation = presentation;
    }
}
