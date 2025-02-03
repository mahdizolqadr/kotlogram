package com.github.badoualy.telegram.tl.api.help;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
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
public class TLCountry extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean hidden;

    protected String iso2;

    protected String defaultName;

    protected String name;

    protected TLVector<TLCountryCode> countryCodes;

    private final String _constructor = "help.country#0";

    public TLCountry() {
    }

    public TLCountry(boolean hidden, String iso2, String defaultName, String name, TLVector<TLCountryCode> countryCodes) {
        this.hidden = hidden;
        this.iso2 = iso2;
        this.defaultName = defaultName;
        this.name = name;
        this.countryCodes = countryCodes;
    }

    private void computeFlags() {
        flags = 0;
        flags = hidden ? (flags | 1) : (flags & ~1);
        flags = name != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(iso2, stream);
        writeString(defaultName, stream);
        if ((flags & 2) != 0) {
            if (name == null) throwNullFieldException("name", flags);
            writeString(name, stream);
        }
        writeTLVector(countryCodes, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        hidden = (flags & 1) != 0;
        iso2 = readTLString(stream);
        defaultName = readTLString(stream);
        name = (flags & 2) != 0 ? readTLString(stream) : null;
        countryCodes = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(iso2);
        size += computeTLStringSerializedSize(defaultName);
        if ((flags & 2) != 0) {
            if (name == null) throwNullFieldException("name", flags);
            size += computeTLStringSerializedSize(name);
        }
        size += countryCodes.computeSerializedSize();
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

    public boolean getHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getDefaultName() {
        return defaultName;
    }

    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TLVector<TLCountryCode> getCountryCodes() {
        return countryCodes;
    }

    public void setCountryCodes(TLVector<TLCountryCode> countryCodes) {
        this.countryCodes = countryCodes;
    }
}
