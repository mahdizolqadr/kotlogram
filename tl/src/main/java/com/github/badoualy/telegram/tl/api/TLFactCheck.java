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
public class TLFactCheck extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean needCheck;

    protected String country;

    protected TLTextWithEntities text;

    protected long hash;

    private final String _constructor = "factCheck#0";

    public TLFactCheck() {
    }

    public TLFactCheck(boolean needCheck, String country, TLTextWithEntities text, long hash) {
        this.needCheck = needCheck;
        this.country = country;
        this.text = text;
        this.hash = hash;
    }

    private void computeFlags() {
        flags = 0;
        flags = needCheck ? (flags | 1) : (flags & ~1);
        flags = country != null ? (flags | 2) : (flags & ~2);
        flags = text != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 2) != 0) {
            if (country == null) throwNullFieldException("country", flags);
            writeString(country, stream);
        }
        if ((flags & 2) != 0) {
            if (text == null) throwNullFieldException("text", flags);
            writeTLObject(text, stream);
        }
        writeLong(hash, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        needCheck = (flags & 1) != 0;
        country = (flags & 2) != 0 ? readTLString(stream) : null;
        text = (flags & 2) != 0 ? readTLObject(stream, context, TLTextWithEntities.class, TLTextWithEntities.CONSTRUCTOR_ID) : null;
        hash = readLong(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 2) != 0) {
            if (country == null) throwNullFieldException("country", flags);
            size += computeTLStringSerializedSize(country);
        }
        if ((flags & 2) != 0) {
            if (text == null) throwNullFieldException("text", flags);
            size += text.computeSerializedSize();
        }
        size += SIZE_INT64;
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

    public boolean getNeedCheck() {
        return needCheck;
    }

    public void setNeedCheck(boolean needCheck) {
        this.needCheck = needCheck;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public TLTextWithEntities getText() {
        return text;
    }

    public void setText(TLTextWithEntities text) {
        this.text = text;
    }

    public long getHash() {
        return hash;
    }

    public void setHash(long hash) {
        this.hash = hash;
    }
}
