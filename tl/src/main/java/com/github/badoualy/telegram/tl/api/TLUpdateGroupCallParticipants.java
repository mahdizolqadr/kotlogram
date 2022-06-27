package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.call.TLGroupCallParticipant;
import com.github.badoualy.telegram.tl.api.call.TLInputGroupCall;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

public class TLUpdateGroupCallParticipants extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0xf2ebdb4e;

    protected TLInputGroupCall call;
    protected TLVector<TLGroupCallParticipant> participants;
    protected int version;

    private final String _constructor = "updateGroupCallParticipants#f2ebdb4e";

    public TLUpdateGroupCallParticipants() {
    }

    public TLUpdateGroupCallParticipants(TLInputGroupCall call, TLVector<TLGroupCallParticipant> participants,
                                         int version) {
        this.call = call;
        this.participants = participants;
        this.version = version;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(call, stream);
        writeTLVector(participants, stream);
        writeInt(version, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        call = readTLObject(stream, context, TLInputGroupCall.class, TLInputGroupCall.CONSTRUCTOR_ID);
        participants = readTLVector(stream, context);
        version = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += call.computeSerializedSize();
        size += participants.computeSerializedSize();
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

    public TLInputGroupCall getCall() {
        return call;
    }

    public void setCall(TLInputGroupCall call) {
        this.call = call;
    }

    public TLVector<TLGroupCallParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(TLVector<TLGroupCallParticipant> participants) {
        this.participants = participants;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
