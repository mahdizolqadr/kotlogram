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
public class TLNearestDc extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected String country;

    protected int thisDc;

    protected int nearestDc;

    private final String _constructor = "nearestDc#0";

    public TLNearestDc() {
    }

    public TLNearestDc(String country, int thisDc, int nearestDc) {
        this.country = country;
        this.thisDc = thisDc;
        this.nearestDc = nearestDc;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(country, stream);
        writeInt(thisDc, stream);
        writeInt(nearestDc, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        country = readTLString(stream);
        thisDc = readInt(stream);
        nearestDc = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(country);
        size += SIZE_INT32;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getThisDc() {
        return thisDc;
    }

    public void setThisDc(int thisDc) {
        this.thisDc = thisDc;
    }

    public int getNearestDc() {
        return nearestDc;
    }

    public void setNearestDc(int nearestDc) {
        this.nearestDc = nearestDc;
    }
}
