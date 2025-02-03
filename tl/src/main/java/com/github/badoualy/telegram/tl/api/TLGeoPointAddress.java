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
public class TLGeoPointAddress extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected String countryIso2;

    protected String state;

    protected String city;

    protected String street;

    private final String _constructor = "geoPointAddress#0";

    public TLGeoPointAddress() {
    }

    public TLGeoPointAddress(String countryIso2, String state, String city, String street) {
        this.countryIso2 = countryIso2;
        this.state = state;
        this.city = city;
        this.street = street;
    }

    private void computeFlags() {
        flags = 0;
        flags = state != null ? (flags | 1) : (flags & ~1);
        flags = city != null ? (flags | 2) : (flags & ~2);
        flags = street != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(countryIso2, stream);
        if ((flags & 1) != 0) {
            if (state == null) throwNullFieldException("state", flags);
            writeString(state, stream);
        }
        if ((flags & 2) != 0) {
            if (city == null) throwNullFieldException("city", flags);
            writeString(city, stream);
        }
        if ((flags & 4) != 0) {
            if (street == null) throwNullFieldException("street", flags);
            writeString(street, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        countryIso2 = readTLString(stream);
        state = (flags & 1) != 0 ? readTLString(stream) : null;
        city = (flags & 2) != 0 ? readTLString(stream) : null;
        street = (flags & 4) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(countryIso2);
        if ((flags & 1) != 0) {
            if (state == null) throwNullFieldException("state", flags);
            size += computeTLStringSerializedSize(state);
        }
        if ((flags & 2) != 0) {
            if (city == null) throwNullFieldException("city", flags);
            size += computeTLStringSerializedSize(city);
        }
        if ((flags & 4) != 0) {
            if (street == null) throwNullFieldException("street", flags);
            size += computeTLStringSerializedSize(street);
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

    public String getCountryIso2() {
        return countryIso2;
    }

    public void setCountryIso2(String countryIso2) {
        this.countryIso2 = countryIso2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
