package com.github.badoualy.telegram.tl.api.help;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLStringVector;
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
public class TLCountryCode extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected String countryCode;

    protected TLStringVector prefixes;

    protected TLStringVector patterns;

    private final String _constructor = "help.countryCode#0";

    public TLCountryCode() {
    }

    public TLCountryCode(String countryCode, TLStringVector prefixes, TLStringVector patterns) {
        this.countryCode = countryCode;
        this.prefixes = prefixes;
        this.patterns = patterns;
    }

    private void computeFlags() {
        flags = 0;
        flags = prefixes != null ? (flags | 1) : (flags & ~1);
        flags = patterns != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(countryCode, stream);
        if ((flags & 1) != 0) {
            if (prefixes == null) throwNullFieldException("prefixes", flags);
            writeTLVector(prefixes, stream);
        }
        if ((flags & 2) != 0) {
            if (patterns == null) throwNullFieldException("patterns", flags);
            writeTLVector(patterns, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        countryCode = readTLString(stream);
        prefixes = (flags & 1) != 0 ? readTLStringVector(stream, context) : null;
        patterns = (flags & 2) != 0 ? readTLStringVector(stream, context) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(countryCode);
        if ((flags & 1) != 0) {
            if (prefixes == null) throwNullFieldException("prefixes", flags);
            size += prefixes.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (patterns == null) throwNullFieldException("patterns", flags);
            size += patterns.computeSerializedSize();
        }
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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public TLStringVector getPrefixes() {
        return prefixes;
    }

    public void setPrefixes(TLStringVector prefixes) {
        this.prefixes = prefixes;
    }

    public TLStringVector getPatterns() {
        return patterns;
    }

    public void setPatterns(TLStringVector patterns) {
        this.patterns = patterns;
    }
}
