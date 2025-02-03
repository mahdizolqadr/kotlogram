package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLInputPaymentCredentials extends TLAbsInputPaymentCredentials {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean save;

    protected TLDataJSON data;

    private final String _constructor = "inputPaymentCredentials#0";

    public TLInputPaymentCredentials() {
    }

    public TLInputPaymentCredentials(boolean save, TLDataJSON data) {
        this.save = save;
        this.data = data;
    }

    private void computeFlags() {
        flags = 0;
        flags = save ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(data, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        save = (flags & 1) != 0;
        data = readTLObject(stream, context, TLDataJSON.class, TLDataJSON.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
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

    public boolean getSave() {
        return save;
    }

    public void setSave(boolean save) {
        this.save = save;
    }

    public TLDataJSON getData() {
        return data;
    }

    public void setData(TLDataJSON data) {
        this.data = data;
    }
}
