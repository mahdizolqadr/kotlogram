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
public class TLBusinessLocation extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLAbsGeoPoint geoPoint;

    protected String address;

    private final String _constructor = "businessLocation#0";

    public TLBusinessLocation() {
    }

    public TLBusinessLocation(TLAbsGeoPoint geoPoint, String address) {
        this.geoPoint = geoPoint;
        this.address = address;
    }

    private void computeFlags() {
        flags = 0;
        flags = geoPoint != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (geoPoint == null) throwNullFieldException("geoPoint", flags);
            writeTLObject(geoPoint, stream);
        }
        writeString(address, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        geoPoint = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsGeoPoint.class, -1) : null;
        address = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (geoPoint == null) throwNullFieldException("geoPoint", flags);
            size += geoPoint.computeSerializedSize();
        }
        size += computeTLStringSerializedSize(address);
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

    public TLAbsGeoPoint getGeoPoint() {
        return geoPoint;
    }

    public void setGeoPoint(TLAbsGeoPoint geoPoint) {
        this.geoPoint = geoPoint;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
