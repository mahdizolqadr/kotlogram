package com.github.badoualy.telegram.tl.api.auth;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLSentCode extends TLAbsSentCode {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLAbsSentCodeType type;

    protected String phoneCodeHash;

    protected TLAbsCodeType nextType;

    protected Integer timeout;

    private final String _constructor = "auth.sentCode#0";

    public TLSentCode() {
    }

    public TLSentCode(TLAbsSentCodeType type, String phoneCodeHash, TLAbsCodeType nextType, Integer timeout) {
        this.type = type;
        this.phoneCodeHash = phoneCodeHash;
        this.nextType = nextType;
        this.timeout = timeout;
    }

    private void computeFlags() {
        flags = 0;
        flags = nextType != null ? (flags | 2) : (flags & ~2);
        flags = timeout != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(type, stream);
        writeString(phoneCodeHash, stream);
        if ((flags & 2) != 0) {
            if (nextType == null) throwNullFieldException("nextType", flags);
            writeTLObject(nextType, stream);
        }
        if ((flags & 4) != 0) {
            if (timeout == null) throwNullFieldException("timeout", flags);
            writeInt(timeout, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        type = readTLObject(stream, context, TLAbsSentCodeType.class, -1);
        phoneCodeHash = readTLString(stream);
        nextType = (flags & 2) != 0 ? readTLObject(stream, context, TLAbsCodeType.class, -1) : null;
        timeout = (flags & 4) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += type.computeSerializedSize();
        size += computeTLStringSerializedSize(phoneCodeHash);
        if ((flags & 2) != 0) {
            if (nextType == null) throwNullFieldException("nextType", flags);
            size += nextType.computeSerializedSize();
        }
        if ((flags & 4) != 0) {
            if (timeout == null) throwNullFieldException("timeout", flags);
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

    public TLAbsSentCodeType getType() {
        return type;
    }

    public void setType(TLAbsSentCodeType type) {
        this.type = type;
    }

    public String getPhoneCodeHash() {
        return phoneCodeHash;
    }

    public void setPhoneCodeHash(String phoneCodeHash) {
        this.phoneCodeHash = phoneCodeHash;
    }

    public TLAbsCodeType getNextType() {
        return nextType;
    }

    public void setNextType(TLAbsCodeType nextType) {
        this.nextType = nextType;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
}
