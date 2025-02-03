package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsUrlAuthResult;
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
public class TLRequestMessagesAcceptUrlAuth extends TLMethod<TLAbsUrlAuthResult> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean writeAllowed;

    protected TLAbsInputPeer peer;

    protected Integer msgId;

    protected Integer buttonId;

    protected String url;

    private final String _constructor = "messages.acceptUrlAuth#0";

    public TLRequestMessagesAcceptUrlAuth() {
    }

    public TLRequestMessagesAcceptUrlAuth(boolean writeAllowed, TLAbsInputPeer peer, Integer msgId, Integer buttonId, String url) {
        this.writeAllowed = writeAllowed;
        this.peer = peer;
        this.msgId = msgId;
        this.buttonId = buttonId;
        this.url = url;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsUrlAuthResult deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsUrlAuthResult)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsUrlAuthResult) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = writeAllowed ? (flags | 1) : (flags & ~1);
        flags = peer != null ? (flags | 2) : (flags & ~2);
        flags = msgId != null ? (flags | 2) : (flags & ~2);
        flags = buttonId != null ? (flags | 2) : (flags & ~2);
        flags = url != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 2) != 0) {
            if (peer == null) throwNullFieldException("peer", flags);
            writeTLObject(peer, stream);
        }
        if ((flags & 2) != 0) {
            if (msgId == null) throwNullFieldException("msgId", flags);
            writeInt(msgId, stream);
        }
        if ((flags & 2) != 0) {
            if (buttonId == null) throwNullFieldException("buttonId", flags);
            writeInt(buttonId, stream);
        }
        if ((flags & 4) != 0) {
            if (url == null) throwNullFieldException("url", flags);
            writeString(url, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        writeAllowed = (flags & 1) != 0;
        peer = (flags & 2) != 0 ? readTLObject(stream, context, TLAbsInputPeer.class, -1) : null;
        msgId = (flags & 2) != 0 ? readInt(stream) : null;
        buttonId = (flags & 2) != 0 ? readInt(stream) : null;
        url = (flags & 4) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 2) != 0) {
            if (peer == null) throwNullFieldException("peer", flags);
            size += peer.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (msgId == null) throwNullFieldException("msgId", flags);
            size += SIZE_INT32;
        }
        if ((flags & 2) != 0) {
            if (buttonId == null) throwNullFieldException("buttonId", flags);
            size += SIZE_INT32;
        }
        if ((flags & 4) != 0) {
            if (url == null) throwNullFieldException("url", flags);
            size += computeTLStringSerializedSize(url);
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

    public boolean getWriteAllowed() {
        return writeAllowed;
    }

    public void setWriteAllowed(boolean writeAllowed) {
        this.writeAllowed = writeAllowed;
    }

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public Integer getButtonId() {
        return buttonId;
    }

    public void setButtonId(Integer buttonId) {
        this.buttonId = buttonId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
