package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputMedia;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsMessageMedia;
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
public class TLRequestMessagesUploadMedia extends TLMethod<TLAbsMessageMedia> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected String businessConnectionId;

    protected TLAbsInputPeer peer;

    protected TLAbsInputMedia media;

    private final String _constructor = "messages.uploadMedia#0";

    public TLRequestMessagesUploadMedia() {
    }

    public TLRequestMessagesUploadMedia(String businessConnectionId, TLAbsInputPeer peer, TLAbsInputMedia media) {
        this.businessConnectionId = businessConnectionId;
        this.peer = peer;
        this.media = media;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsMessageMedia deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsMessageMedia)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsMessageMedia) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = businessConnectionId != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (businessConnectionId == null) throwNullFieldException("businessConnectionId", flags);
            writeString(businessConnectionId, stream);
        }
        writeTLObject(peer, stream);
        writeTLObject(media, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        businessConnectionId = (flags & 1) != 0 ? readTLString(stream) : null;
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        media = readTLObject(stream, context, TLAbsInputMedia.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (businessConnectionId == null) throwNullFieldException("businessConnectionId", flags);
            size += computeTLStringSerializedSize(businessConnectionId);
        }
        size += peer.computeSerializedSize();
        size += media.computeSerializedSize();
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

    public String getBusinessConnectionId() {
        return businessConnectionId;
    }

    public void setBusinessConnectionId(String businessConnectionId) {
        this.businessConnectionId = businessConnectionId;
    }

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public TLAbsInputMedia getMedia() {
        return media;
    }

    public void setMedia(TLAbsInputMedia media) {
        this.media = media;
    }
}
