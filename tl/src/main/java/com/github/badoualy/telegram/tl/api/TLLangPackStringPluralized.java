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
public class TLLangPackStringPluralized extends TLAbsLangPackString {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected String zeroValue;

    protected String oneValue;

    protected String twoValue;

    protected String fewValue;

    protected String manyValue;

    protected String otherValue;

    private final String _constructor = "langPackStringPluralized#0";

    public TLLangPackStringPluralized() {
    }

    public TLLangPackStringPluralized(String key, String zeroValue, String oneValue, String twoValue, String fewValue, String manyValue, String otherValue) {
        this.key = key;
        this.zeroValue = zeroValue;
        this.oneValue = oneValue;
        this.twoValue = twoValue;
        this.fewValue = fewValue;
        this.manyValue = manyValue;
        this.otherValue = otherValue;
    }

    private void computeFlags() {
        flags = 0;
        flags = zeroValue != null ? (flags | 1) : (flags & ~1);
        flags = oneValue != null ? (flags | 2) : (flags & ~2);
        flags = twoValue != null ? (flags | 4) : (flags & ~4);
        flags = fewValue != null ? (flags | 8) : (flags & ~8);
        flags = manyValue != null ? (flags | 16) : (flags & ~16);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(key, stream);
        if ((flags & 1) != 0) {
            if (zeroValue == null) throwNullFieldException("zeroValue", flags);
            writeString(zeroValue, stream);
        }
        if ((flags & 2) != 0) {
            if (oneValue == null) throwNullFieldException("oneValue", flags);
            writeString(oneValue, stream);
        }
        if ((flags & 4) != 0) {
            if (twoValue == null) throwNullFieldException("twoValue", flags);
            writeString(twoValue, stream);
        }
        if ((flags & 8) != 0) {
            if (fewValue == null) throwNullFieldException("fewValue", flags);
            writeString(fewValue, stream);
        }
        if ((flags & 16) != 0) {
            if (manyValue == null) throwNullFieldException("manyValue", flags);
            writeString(manyValue, stream);
        }
        writeString(otherValue, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        key = readTLString(stream);
        zeroValue = (flags & 1) != 0 ? readTLString(stream) : null;
        oneValue = (flags & 2) != 0 ? readTLString(stream) : null;
        twoValue = (flags & 4) != 0 ? readTLString(stream) : null;
        fewValue = (flags & 8) != 0 ? readTLString(stream) : null;
        manyValue = (flags & 16) != 0 ? readTLString(stream) : null;
        otherValue = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(key);
        if ((flags & 1) != 0) {
            if (zeroValue == null) throwNullFieldException("zeroValue", flags);
            size += computeTLStringSerializedSize(zeroValue);
        }
        if ((flags & 2) != 0) {
            if (oneValue == null) throwNullFieldException("oneValue", flags);
            size += computeTLStringSerializedSize(oneValue);
        }
        if ((flags & 4) != 0) {
            if (twoValue == null) throwNullFieldException("twoValue", flags);
            size += computeTLStringSerializedSize(twoValue);
        }
        if ((flags & 8) != 0) {
            if (fewValue == null) throwNullFieldException("fewValue", flags);
            size += computeTLStringSerializedSize(fewValue);
        }
        if ((flags & 16) != 0) {
            if (manyValue == null) throwNullFieldException("manyValue", flags);
            size += computeTLStringSerializedSize(manyValue);
        }
        size += computeTLStringSerializedSize(otherValue);
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getZeroValue() {
        return zeroValue;
    }

    public void setZeroValue(String zeroValue) {
        this.zeroValue = zeroValue;
    }

    public String getOneValue() {
        return oneValue;
    }

    public void setOneValue(String oneValue) {
        this.oneValue = oneValue;
    }

    public String getTwoValue() {
        return twoValue;
    }

    public void setTwoValue(String twoValue) {
        this.twoValue = twoValue;
    }

    public String getFewValue() {
        return fewValue;
    }

    public void setFewValue(String fewValue) {
        this.fewValue = fewValue;
    }

    public String getManyValue() {
        return manyValue;
    }

    public void setManyValue(String manyValue) {
        this.manyValue = manyValue;
    }

    public String getOtherValue() {
        return otherValue;
    }

    public void setOtherValue(String otherValue) {
        this.otherValue = otherValue;
    }
}
