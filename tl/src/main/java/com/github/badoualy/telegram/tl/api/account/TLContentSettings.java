package com.github.badoualy.telegram.tl.api.account;

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
public class TLContentSettings extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean sensitiveEnabled;

    protected boolean sensitiveCanChange;

    private final String _constructor = "account.contentSettings#0";

    public TLContentSettings() {
    }

    public TLContentSettings(boolean sensitiveEnabled, boolean sensitiveCanChange) {
        this.sensitiveEnabled = sensitiveEnabled;
        this.sensitiveCanChange = sensitiveCanChange;
    }

    private void computeFlags() {
        flags = 0;
        flags = sensitiveEnabled ? (flags | 1) : (flags & ~1);
        flags = sensitiveCanChange ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        sensitiveEnabled = (flags & 1) != 0;
        sensitiveCanChange = (flags & 2) != 0;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
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

    public boolean getSensitiveEnabled() {
        return sensitiveEnabled;
    }

    public void setSensitiveEnabled(boolean sensitiveEnabled) {
        this.sensitiveEnabled = sensitiveEnabled;
    }

    public boolean getSensitiveCanChange() {
        return sensitiveCanChange;
    }

    public void setSensitiveCanChange(boolean sensitiveCanChange) {
        this.sensitiveCanChange = sensitiveCanChange;
    }
}
