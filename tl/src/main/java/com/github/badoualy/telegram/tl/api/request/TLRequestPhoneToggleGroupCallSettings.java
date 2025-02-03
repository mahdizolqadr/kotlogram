package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
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
public class TLRequestPhoneToggleGroupCallSettings extends TLMethod<TLAbsUpdates> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean resetInviteHash;

    protected TLInputGroupCall call;

    protected boolean joinMuted;

    private final String _constructor = "phone.toggleGroupCallSettings#0";

    public TLRequestPhoneToggleGroupCallSettings() {
    }

    public TLRequestPhoneToggleGroupCallSettings(boolean resetInviteHash, TLInputGroupCall call, boolean joinMuted) {
        this.resetInviteHash = resetInviteHash;
        this.call = call;
        this.joinMuted = joinMuted;
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
        flags = resetInviteHash ? (flags | 2) : (flags & ~2);
        flags = joinMuted != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(call, stream);
        if ((flags & 1) != 0) {
            writeBoolean(joinMuted, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        resetInviteHash = (flags & 2) != 0;
        call = readTLObject(stream, context, TLInputGroupCall.class, TLInputGroupCall.CONSTRUCTOR_ID);
        joinMuted = (flags & 1) != 0 ? readTLBool(stream) : false;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += call.computeSerializedSize();
        if ((flags & 1) != 0) {
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

    public boolean getResetInviteHash() {
        return resetInviteHash;
    }

    public void setResetInviteHash(boolean resetInviteHash) {
        this.resetInviteHash = resetInviteHash;
    }

    public TLInputGroupCall getCall() {
        return call;
    }

    public void setCall(TLInputGroupCall call) {
        this.call = call;
    }

    public boolean getJoinMuted() {
        return joinMuted;
    }

    public void setJoinMuted(boolean joinMuted) {
        this.joinMuted = joinMuted;
    }
}
