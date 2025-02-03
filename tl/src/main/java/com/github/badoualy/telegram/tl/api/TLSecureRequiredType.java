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
public class TLSecureRequiredType extends TLAbsSecureRequiredType {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean nativeNames;

    protected boolean selfieRequired;

    protected boolean translationRequired;

    protected TLAbsSecureValueType type;

    private final String _constructor = "secureRequiredType#0";

    public TLSecureRequiredType() {
    }

    public TLSecureRequiredType(boolean nativeNames, boolean selfieRequired, boolean translationRequired, TLAbsSecureValueType type) {
        this.nativeNames = nativeNames;
        this.selfieRequired = selfieRequired;
        this.translationRequired = translationRequired;
        this.type = type;
    }

    private void computeFlags() {
        flags = 0;
        flags = nativeNames ? (flags | 1) : (flags & ~1);
        flags = selfieRequired ? (flags | 2) : (flags & ~2);
        flags = translationRequired ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(type, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        nativeNames = (flags & 1) != 0;
        selfieRequired = (flags & 2) != 0;
        translationRequired = (flags & 4) != 0;
        type = readTLObject(stream, context, TLAbsSecureValueType.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += type.computeSerializedSize();
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

    public boolean getNativeNames() {
        return nativeNames;
    }

    public void setNativeNames(boolean nativeNames) {
        this.nativeNames = nativeNames;
    }

    public boolean getSelfieRequired() {
        return selfieRequired;
    }

    public void setSelfieRequired(boolean selfieRequired) {
        this.selfieRequired = selfieRequired;
    }

    public boolean getTranslationRequired() {
        return translationRequired;
    }

    public void setTranslationRequired(boolean translationRequired) {
        this.translationRequired = translationRequired;
    }

    public TLAbsSecureValueType getType() {
        return type;
    }

    public void setType(TLAbsSecureValueType type) {
        this.type = type;
    }
}
