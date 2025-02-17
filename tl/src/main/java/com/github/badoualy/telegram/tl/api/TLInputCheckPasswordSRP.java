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
public class TLInputCheckPasswordSRP extends TLAbsInputCheckPasswordSRP {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected long srpId;

    protected TLBytes a;

    protected TLBytes m1;

    private final String _constructor = "inputCheckPasswordSRP#0";

    public TLInputCheckPasswordSRP() {
    }

    public TLInputCheckPasswordSRP(long srpId, TLBytes a, TLBytes m1) {
        this.srpId = srpId;
        this.a = a;
        this.m1 = m1;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(srpId, stream);
        writeTLBytes(a, stream);
        writeTLBytes(m1, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        srpId = readLong(stream);
        a = readTLBytes(stream, context);
        m1 = readTLBytes(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += computeTLBytesSerializedSize(a);
        size += computeTLBytesSerializedSize(m1);
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

    public long getSrpId() {
        return srpId;
    }

    public void setSrpId(long srpId) {
        this.srpId = srpId;
    }

    public TLBytes getA() {
        return a;
    }

    public void setA(TLBytes a) {
        this.a = a;
    }

    public TLBytes getM1() {
        return m1;
    }

    public void setM1(TLBytes m1) {
        this.m1 = m1;
    }

    @Override
    public final boolean isEmpty() {
        return false;
    }

    @Override
    public final boolean isNotEmpty() {
        return true;
    }

    @Override
    public final TLInputCheckPasswordSRP getAsInputCheckPasswordSRP() {
        return this;
    }
}
