package com.github.badoualy.telegram.tl.api.call;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

public class TLGroupCallParticipantVideo extends TLObject {

    public static final int CONSTRUCTOR_ID = 0x67753ac8;

    protected int flags;
    protected boolean paused;
    protected String endpoint;
    protected TLVector<TLGroupCallParticipantVideoSourceGroup> sourceGroups;
    protected Integer audioSource;

    private final String _constructor = "groupCallParticipantVideo#67753ac8";

    public TLGroupCallParticipantVideo() {
    }

    public TLGroupCallParticipantVideo(boolean paused, String endpoint,
                                       TLVector<TLGroupCallParticipantVideoSourceGroup> sourceGroups,
                                       Integer audioSource) {
        this.paused = paused;
        this.endpoint = endpoint;
        this.sourceGroups = sourceGroups;
        this.audioSource = audioSource;
    }

    protected void computeFlags() {
        flags = 0;
        flags = paused ? (flags | 1) : (flags & ~1);
        flags = audioSource != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();
        writeInt(flags, stream);
        writeString(endpoint, stream);
        writeTLVector(sourceGroups, stream);
        if ((flags & 2) != 0) {
            if (audioSource == null) {
                throwNullFieldException("audioSource", flags);
            }
            writeInt(audioSource, stream);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        paused = (flags & 1) != 0;
        endpoint = readTLString(stream);
        sourceGroups = readTLVector(stream, context);
        audioSource = (flags & 2) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(endpoint);
        size += sourceGroups.computeSerializedSize();
        if ((flags & 2) != 0) {
            if (audioSource == null) {
                throwNullFieldException("audioSource", flags);
            }
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

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public TLVector<TLGroupCallParticipantVideoSourceGroup> getSourceGroups() {
        return sourceGroups;
    }

    public void setSourceGroups(TLVector<TLGroupCallParticipantVideoSourceGroup> sourceGroups) {
        this.sourceGroups = sourceGroups;
    }

    public Integer getAudioSource() {
        return audioSource;
    }

    public void setAudioSource(Integer audioSource) {
        this.audioSource = audioSource;
    }
}
