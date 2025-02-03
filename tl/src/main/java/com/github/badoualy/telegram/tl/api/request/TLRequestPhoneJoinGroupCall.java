package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
import com.github.badoualy.telegram.tl.api.TLDataJSON;
import com.github.badoualy.telegram.tl.api.TLInputGroupCall;
import com.github.badoualy.telegram.tl.core.TLMethod;
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
public class TLRequestPhoneJoinGroupCall extends TLMethod<TLAbsUpdates> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean muted;

    protected boolean videoStopped;

    protected TLInputGroupCall call;

    protected TLAbsInputPeer joinAs;

    protected String inviteHash;

    protected TLDataJSON params;

    private final String _constructor = "phone.joinGroupCall#0";

    public TLRequestPhoneJoinGroupCall() {
    }

    public TLRequestPhoneJoinGroupCall(boolean muted, boolean videoStopped, TLInputGroupCall call, TLAbsInputPeer joinAs, String inviteHash, TLDataJSON params) {
        this.muted = muted;
        this.videoStopped = videoStopped;
        this.call = call;
        this.joinAs = joinAs;
        this.inviteHash = inviteHash;
        this.params = params;
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
        flags = muted ? (flags | 1) : (flags & ~1);
        flags = videoStopped ? (flags | 4) : (flags & ~4);
        flags = inviteHash != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(call, stream);
        writeTLObject(joinAs, stream);
        if ((flags & 2) != 0) {
            if (inviteHash == null) throwNullFieldException("inviteHash", flags);
            writeString(inviteHash, stream);
        }
        writeTLObject(params, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        muted = (flags & 1) != 0;
        videoStopped = (flags & 4) != 0;
        call = readTLObject(stream, context, TLInputGroupCall.class, TLInputGroupCall.CONSTRUCTOR_ID);
        joinAs = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        inviteHash = (flags & 2) != 0 ? readTLString(stream) : null;
        params = readTLObject(stream, context, TLDataJSON.class, TLDataJSON.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += call.computeSerializedSize();
        size += joinAs.computeSerializedSize();
        if ((flags & 2) != 0) {
            if (inviteHash == null) throwNullFieldException("inviteHash", flags);
            size += computeTLStringSerializedSize(inviteHash);
        }
        size += params.computeSerializedSize();
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

    public boolean getVideoStopped() {
        return videoStopped;
    }

    public void setVideoStopped(boolean videoStopped) {
        this.videoStopped = videoStopped;
    }

    public TLInputGroupCall getCall() {
        return call;
    }

    public void setCall(TLInputGroupCall call) {
        this.call = call;
    }

    public TLAbsInputPeer getJoinAs() {
        return joinAs;
    }

    public void setJoinAs(TLAbsInputPeer joinAs) {
        this.joinAs = joinAs;
    }

    public String getInviteHash() {
        return inviteHash;
    }

    public void setInviteHash(String inviteHash) {
        this.inviteHash = inviteHash;
    }

    public TLDataJSON getParams() {
        return params;
    }

    public void setParams(TLDataJSON params) {
        this.params = params;
    }
}
