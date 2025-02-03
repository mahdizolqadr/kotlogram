package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLInputAppEvent extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected double time;

    protected String type;

    protected long peer;

    protected TLAbsJSONValue data;

    private final String _constructor = "inputAppEvent#0";

    public TLInputAppEvent() {
    }

    public TLInputAppEvent(double time, String type, long peer, TLAbsJSONValue data) {
        this.time = time;
        this.type = type;
        this.peer = peer;
        this.data = data;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeDouble(time, stream);
        writeString(type, stream);
        writeLong(peer, stream);
        writeTLObject(data, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        time = readDouble(stream);
        type = readTLString(stream);
        peer = readLong(stream);
        data = readTLObject(stream, context, TLAbsJSONValue.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_DOUBLE;
        size += computeTLStringSerializedSize(type);
        size += SIZE_INT64;
        size += data.computeSerializedSize();
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

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getPeer() {
        return peer;
    }

    public void setPeer(long peer) {
        this.peer = peer;
    }

    public TLAbsJSONValue getData() {
        return data;
    }

    public void setData(TLAbsJSONValue data) {
        this.data = data;
    }
}
