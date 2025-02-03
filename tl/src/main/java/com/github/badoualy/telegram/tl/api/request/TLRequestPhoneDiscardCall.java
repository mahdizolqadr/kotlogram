package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsPhoneCallDiscardReason;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
import com.github.badoualy.telegram.tl.api.TLInputPhoneCall;
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
public class TLRequestPhoneDiscardCall extends TLMethod<TLAbsUpdates> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean video;

    protected TLInputPhoneCall peer;

    protected int duration;

    protected TLAbsPhoneCallDiscardReason reason;

    protected long connectionId;

    private final String _constructor = "phone.discardCall#0";

    public TLRequestPhoneDiscardCall() {
    }

    public TLRequestPhoneDiscardCall(boolean video, TLInputPhoneCall peer, int duration, TLAbsPhoneCallDiscardReason reason, long connectionId) {
        this.video = video;
        this.peer = peer;
        this.duration = duration;
        this.reason = reason;
        this.connectionId = connectionId;
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
        flags = video ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peer, stream);
        writeInt(duration, stream);
        writeTLObject(reason, stream);
        writeLong(connectionId, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        video = (flags & 1) != 0;
        peer = readTLObject(stream, context, TLInputPhoneCall.class, TLInputPhoneCall.CONSTRUCTOR_ID);
        duration = readInt(stream);
        reason = readTLObject(stream, context, TLAbsPhoneCallDiscardReason.class, -1);
        connectionId = readLong(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        size += SIZE_INT32;
        size += reason.computeSerializedSize();
        size += SIZE_INT64;
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

    public boolean getVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public TLInputPhoneCall getPeer() {
        return peer;
    }

    public void setPeer(TLInputPhoneCall peer) {
        this.peer = peer;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public TLAbsPhoneCallDiscardReason getReason() {
        return reason;
    }

    public void setReason(TLAbsPhoneCallDiscardReason reason) {
        this.reason = reason;
    }

    public long getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(long connectionId) {
        this.connectionId = connectionId;
    }
}
