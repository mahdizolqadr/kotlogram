package com.github.badoualy.telegram.tl.api.auth;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLSentCodeTypeFirebaseSms extends TLAbsSentCodeType {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLBytes nonce;

    protected Long playIntegrityProjectId;

    protected TLBytes playIntegrityNonce;

    protected String receipt;

    protected Integer pushTimeout;

    protected int length;

    private final String _constructor = "auth.sentCodeTypeFirebaseSms#0";

    public TLSentCodeTypeFirebaseSms() {
    }

    public TLSentCodeTypeFirebaseSms(TLBytes nonce, Long playIntegrityProjectId, TLBytes playIntegrityNonce, String receipt, Integer pushTimeout, int length) {
        this.nonce = nonce;
        this.playIntegrityProjectId = playIntegrityProjectId;
        this.playIntegrityNonce = playIntegrityNonce;
        this.receipt = receipt;
        this.pushTimeout = pushTimeout;
        this.length = length;
    }

    private void computeFlags() {
        flags = 0;
        flags = nonce != null ? (flags | 1) : (flags & ~1);
        flags = playIntegrityProjectId != null ? (flags | 4) : (flags & ~4);
        flags = playIntegrityNonce != null ? (flags | 4) : (flags & ~4);
        flags = receipt != null ? (flags | 2) : (flags & ~2);
        flags = pushTimeout != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (nonce == null) throwNullFieldException("nonce", flags);
            writeTLBytes(nonce, stream);
        }
        if ((flags & 4) != 0) {
            if (playIntegrityProjectId == null) throwNullFieldException("playIntegrityProjectId", flags);
            writeLong(playIntegrityProjectId, stream);
        }
        if ((flags & 4) != 0) {
            if (playIntegrityNonce == null) throwNullFieldException("playIntegrityNonce", flags);
            writeTLBytes(playIntegrityNonce, stream);
        }
        if ((flags & 2) != 0) {
            if (receipt == null) throwNullFieldException("receipt", flags);
            writeString(receipt, stream);
        }
        if ((flags & 2) != 0) {
            if (pushTimeout == null) throwNullFieldException("pushTimeout", flags);
            writeInt(pushTimeout, stream);
        }
        writeInt(length, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        nonce = (flags & 1) != 0 ? readTLBytes(stream, context) : null;
        playIntegrityProjectId = (flags & 4) != 0 ? readLong(stream) : null;
        playIntegrityNonce = (flags & 4) != 0 ? readTLBytes(stream, context) : null;
        receipt = (flags & 2) != 0 ? readTLString(stream) : null;
        pushTimeout = (flags & 2) != 0 ? readInt(stream) : null;
        length = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (nonce == null) throwNullFieldException("nonce", flags);
            size += computeTLBytesSerializedSize(nonce);
        }
        if ((flags & 4) != 0) {
            if (playIntegrityProjectId == null) throwNullFieldException("playIntegrityProjectId", flags);
            size += SIZE_INT64;
        }
        if ((flags & 4) != 0) {
            if (playIntegrityNonce == null) throwNullFieldException("playIntegrityNonce", flags);
            size += computeTLBytesSerializedSize(playIntegrityNonce);
        }
        if ((flags & 2) != 0) {
            if (receipt == null) throwNullFieldException("receipt", flags);
            size += computeTLStringSerializedSize(receipt);
        }
        if ((flags & 2) != 0) {
            if (pushTimeout == null) throwNullFieldException("pushTimeout", flags);
            size += SIZE_INT32;
        }
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

    public TLBytes getNonce() {
        return nonce;
    }

    public void setNonce(TLBytes nonce) {
        this.nonce = nonce;
    }

    public Long getPlayIntegrityProjectId() {
        return playIntegrityProjectId;
    }

    public void setPlayIntegrityProjectId(Long playIntegrityProjectId) {
        this.playIntegrityProjectId = playIntegrityProjectId;
    }

    public TLBytes getPlayIntegrityNonce() {
        return playIntegrityNonce;
    }

    public void setPlayIntegrityNonce(TLBytes playIntegrityNonce) {
        this.playIntegrityNonce = playIntegrityNonce;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public Integer getPushTimeout() {
        return pushTimeout;
    }

    public void setPushTimeout(Integer pushTimeout) {
        this.pushTimeout = pushTimeout;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
