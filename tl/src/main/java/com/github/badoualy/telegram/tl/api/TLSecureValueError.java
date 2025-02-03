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
public class TLSecureValueError extends TLAbsSecureValueError {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLBytes hash;

    private final String _constructor = "secureValueError#0";

    public TLSecureValueError() {
    }

    public TLSecureValueError(TLAbsSecureValueType type, TLBytes hash, String text) {
        this.type = type;
        this.hash = hash;
        this.text = text;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(type, stream);
        writeTLBytes(hash, stream);
        writeString(text, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        type = readTLObject(stream, context, TLAbsSecureValueType.class, -1);
        hash = readTLBytes(stream, context);
        text = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += type.computeSerializedSize();
        size += computeTLBytesSerializedSize(hash);
        size += computeTLStringSerializedSize(text);
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

    public TLAbsSecureValueType getType() {
        return type;
    }

    public void setType(TLAbsSecureValueType type) {
        this.type = type;
    }

    public TLBytes getHash() {
        return hash;
    }

    public void setHash(TLBytes hash) {
        this.hash = hash;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
