package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsInputPhoto;
import com.github.badoualy.telegram.tl.api.TLAbsReportReason;
import com.github.badoualy.telegram.tl.core.TLBool;
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
public class TLRequestAccountReportProfilePhoto extends TLMethod<TLBool> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsInputPeer peer;

    protected TLAbsInputPhoto photoId;

    protected TLAbsReportReason reason;

    protected String message;

    private final String _constructor = "account.reportProfilePhoto#0";

    public TLRequestAccountReportProfilePhoto() {
    }

    public TLRequestAccountReportProfilePhoto(TLAbsInputPeer peer, TLAbsInputPhoto photoId, TLAbsReportReason reason, String message) {
        this.peer = peer;
        this.photoId = photoId;
        this.reason = reason;
        this.message = message;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLBool)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLBool) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(peer, stream);
        writeTLObject(photoId, stream);
        writeTLObject(reason, stream);
        writeString(message, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        photoId = readTLObject(stream, context, TLAbsInputPhoto.class, -1);
        reason = readTLObject(stream, context, TLAbsReportReason.class, -1);
        message = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += peer.computeSerializedSize();
        size += photoId.computeSerializedSize();
        size += reason.computeSerializedSize();
        size += computeTLStringSerializedSize(message);
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

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public TLAbsInputPhoto getPhotoId() {
        return photoId;
    }

    public void setPhotoId(TLAbsInputPhoto photoId) {
        this.photoId = photoId;
    }

    public TLAbsReportReason getReason() {
        return reason;
    }

    public void setReason(TLAbsReportReason reason) {
        this.reason = reason;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
