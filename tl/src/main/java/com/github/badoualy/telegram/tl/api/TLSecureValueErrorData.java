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
public class TLSecureValueErrorData extends TLAbsSecureValueError {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLBytes dataHash;

    protected String field;

    private final String _constructor = "secureValueErrorData#0";

    public TLSecureValueErrorData() {
    }

    public TLSecureValueErrorData(TLAbsSecureValueType type, TLBytes dataHash, String field, String text) {
        this.type = type;
        this.dataHash = dataHash;
        this.field = field;
        this.text = text;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(type, stream);
        writeTLBytes(dataHash, stream);
        writeString(field, stream);
        writeString(text, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        type = readTLObject(stream, context, TLAbsSecureValueType.class, -1);
        dataHash = readTLBytes(stream, context);
        field = readTLString(stream);
        text = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += type.computeSerializedSize();
        size += computeTLBytesSerializedSize(dataHash);
        size += computeTLStringSerializedSize(field);
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

    public TLBytes getDataHash() {
        return dataHash;
    }

    public void setDataHash(TLBytes dataHash) {
        this.dataHash = dataHash;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
