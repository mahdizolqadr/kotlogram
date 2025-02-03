package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
import com.github.badoualy.telegram.tl.api.TLInputGroupCall;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLRequestPhoneEditGroupCallParticipant extends TLMethod<TLAbsUpdates> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLInputGroupCall call;

    protected TLAbsInputPeer participant;

    protected boolean muted;

    protected Integer volume;

    protected boolean raiseHand;

    protected boolean videoStopped;

    protected boolean videoPaused;

    protected boolean presentationPaused;

    private final String _constructor = "phone.editGroupCallParticipant#0";

    public TLRequestPhoneEditGroupCallParticipant() {
    }

    public TLRequestPhoneEditGroupCallParticipant(TLInputGroupCall call, TLAbsInputPeer participant, boolean muted, Integer volume, boolean raiseHand, boolean videoStopped, boolean videoPaused, boolean presentationPaused) {
        this.call = call;
        this.participant = participant;
        this.muted = muted;
        this.volume = volume;
        this.raiseHand = raiseHand;
        this.videoStopped = videoStopped;
        this.videoPaused = videoPaused;
        this.presentationPaused = presentationPaused;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsUpdates deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsUpdates)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsUpdates) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = muted != null ? (flags | 1) : (flags & ~1);
        flags = volume != null ? (flags | 2) : (flags & ~2);
        flags = raiseHand != null ? (flags | 4) : (flags & ~4);
        flags = videoStopped != null ? (flags | 8) : (flags & ~8);
        flags = videoPaused != null ? (flags | 16) : (flags & ~16);
        flags = presentationPaused != null ? (flags | 32) : (flags & ~32);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(call, stream);
        writeTLObject(participant, stream);
        if ((flags & 1) != 0) {
            writeBoolean(muted, stream);
        }
        if ((flags & 2) != 0) {
            if (volume == null) throwNullFieldException("volume", flags);
            writeInt(volume, stream);
        }
        if ((flags & 4) != 0) {
            writeBoolean(raiseHand, stream);
        }
        if ((flags & 8) != 0) {
            writeBoolean(videoStopped, stream);
        }
        if ((flags & 16) != 0) {
            writeBoolean(videoPaused, stream);
        }
        if ((flags & 32) != 0) {
            writeBoolean(presentationPaused, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        call = readTLObject(stream, context, TLInputGroupCall.class, TLInputGroupCall.CONSTRUCTOR_ID);
        participant = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        muted = (flags & 1) != 0 ? readTLBool(stream) : false;
        volume = (flags & 2) != 0 ? readInt(stream) : null;
        raiseHand = (flags & 4) != 0 ? readTLBool(stream) : false;
        videoStopped = (flags & 8) != 0 ? readTLBool(stream) : false;
        videoPaused = (flags & 16) != 0 ? readTLBool(stream) : false;
        presentationPaused = (flags & 32) != 0 ? readTLBool(stream) : false;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += call.computeSerializedSize();
        size += participant.computeSerializedSize();
        if ((flags & 1) != 0) {
            size += SIZE_BOOLEAN;
        }
        if ((flags & 2) != 0) {
            if (volume == null) throwNullFieldException("volume", flags);
            size += SIZE_INT32;
        }
        if ((flags & 4) != 0) {
            size += SIZE_BOOLEAN;
        }
        if ((flags & 8) != 0) {
            size += SIZE_BOOLEAN;
        }
        if ((flags & 16) != 0) {
            size += SIZE_BOOLEAN;
        }
        if ((flags & 32) != 0) {
            size += SIZE_BOOLEAN;
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

    public TLAbsInputPeer getParticipant() {
        return participant;
    }

    public void setParticipant(TLAbsInputPeer participant) {
        this.participant = participant;
    }

    public boolean getMuted() {
        return muted;
    }

    public void setMuted(boolean muted) {
        this.muted = muted;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public boolean getRaiseHand() {
        return raiseHand;
    }

    public void setRaiseHand(boolean raiseHand) {
        this.raiseHand = raiseHand;
    }

    public boolean getVideoStopped() {
        return videoStopped;
    }

    public void setVideoStopped(boolean videoStopped) {
        this.videoStopped = videoStopped;
    }

    public boolean getVideoPaused() {
        return videoPaused;
    }

    public void setVideoPaused(boolean videoPaused) {
        this.videoPaused = videoPaused;
    }

    public boolean getPresentationPaused() {
        return presentationPaused;
    }

    public void setPresentationPaused(boolean presentationPaused) {
        this.presentationPaused = presentationPaused;
    }
}
