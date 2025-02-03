package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputUser;
import com.github.badoualy.telegram.tl.api.TLPhoneCallProtocol;
import com.github.badoualy.telegram.tl.api.phone.TLPhoneCall;
import com.github.badoualy.telegram.tl.core.TLBytes;
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
public class TLRequestPhoneRequestCall extends TLMethod<TLPhoneCall> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean video;

    protected TLAbsInputUser userId;

    protected int randomId;

    protected TLBytes gAHash;

    protected TLPhoneCallProtocol protocol;

    private final String _constructor = "phone.requestCall#0";

    public TLRequestPhoneRequestCall() {
    }

    public TLRequestPhoneRequestCall(boolean video, TLAbsInputUser userId, int randomId, TLBytes gAHash, TLPhoneCallProtocol protocol) {
        this.video = video;
        this.userId = userId;
        this.randomId = randomId;
        this.gAHash = gAHash;
        this.protocol = protocol;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLPhoneCall deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLPhoneCall)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLPhoneCall) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = video ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(userId, stream);
        writeInt(randomId, stream);
        writeTLBytes(gAHash, stream);
        writeTLObject(protocol, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        video = (flags & 1) != 0;
        userId = readTLObject(stream, context, TLAbsInputUser.class, -1);
        randomId = readInt(stream);
        gAHash = readTLBytes(stream, context);
        protocol = readTLObject(stream, context, TLPhoneCallProtocol.class, TLPhoneCallProtocol.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += userId.computeSerializedSize();
        size += SIZE_INT32;
        size += computeTLBytesSerializedSize(gAHash);
        size += protocol.computeSerializedSize();
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

    public TLAbsInputUser getUserId() {
        return userId;
    }

    public void setUserId(TLAbsInputUser userId) {
        this.userId = userId;
    }

    public int getRandomId() {
        return randomId;
    }

    public void setRandomId(int randomId) {
        this.randomId = randomId;
    }

    public TLBytes getGAHash() {
        return gAHash;
    }

    public void setGAHash(TLBytes gAHash) {
        this.gAHash = gAHash;
    }

    public TLPhoneCallProtocol getProtocol() {
        return protocol;
    }

    public void setProtocol(TLPhoneCallProtocol protocol) {
        this.protocol = protocol;
    }
}
