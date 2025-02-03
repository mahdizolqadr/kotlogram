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
public class TLUpdatePaidReactionPrivacy extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected boolean _private;

    private final String _constructor = "updatePaidReactionPrivacy#0";

    public TLUpdatePaidReactionPrivacy() {
    }

    public TLUpdatePaidReactionPrivacy(boolean _private) {
        this._private = _private;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeBoolean(_private, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        _private = readTLBool(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_BOOLEAN;
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

    public boolean getPrivate() {
        return _private;
    }

    public void setPrivate(boolean _private) {
        this._private = _private;
    }
}
