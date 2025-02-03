package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
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
public class TLUpdatePhoneCallSignalingData extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected long phoneCallId;

    protected TLBytes data;

    private final String _constructor = "updatePhoneCallSignalingData#0";

    public TLUpdatePhoneCallSignalingData() {
    }

    public TLUpdatePhoneCallSignalingData(long phoneCallId, TLBytes data) {
        this.phoneCallId = phoneCallId;
        this.data = data;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(phoneCallId, stream);
        writeTLBytes(data, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        phoneCallId = readLong(stream);
        data = readTLBytes(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += computeTLBytesSerializedSize(data);
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

    public long getPhoneCallId() {
        return phoneCallId;
    }

    public void setPhoneCallId(long phoneCallId) {
        this.phoneCallId = phoneCallId;
    }

    public TLBytes getData() {
        return data;
    }

    public void setData(TLBytes data) {
        this.data = data;
    }
}
