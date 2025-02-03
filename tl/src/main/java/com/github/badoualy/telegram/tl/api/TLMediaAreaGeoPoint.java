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
public class TLMediaAreaGeoPoint extends TLAbsMediaArea {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLAbsGeoPoint geo;

    protected TLGeoPointAddress address;

    private final String _constructor = "mediaAreaGeoPoint#0";

    public TLMediaAreaGeoPoint() {
    }

    public TLMediaAreaGeoPoint(TLMediaAreaCoordinates coordinates, TLAbsGeoPoint geo, TLGeoPointAddress address) {
        this.coordinates = coordinates;
        this.geo = geo;
        this.address = address;
    }

    private void computeFlags() {
        flags = 0;
        flags = address != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(coordinates, stream);
        writeTLObject(geo, stream);
        if ((flags & 1) != 0) {
            if (address == null) throwNullFieldException("address", flags);
            writeTLObject(address, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        coordinates = readTLObject(stream, context, TLMediaAreaCoordinates.class, TLMediaAreaCoordinates.CONSTRUCTOR_ID);
        geo = readTLObject(stream, context, TLAbsGeoPoint.class, -1);
        address = (flags & 1) != 0 ? readTLObject(stream, context, TLGeoPointAddress.class, TLGeoPointAddress.CONSTRUCTOR_ID) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += coordinates.computeSerializedSize();
        size += geo.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (address == null) throwNullFieldException("address", flags);
            size += address.computeSerializedSize();
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

    public TLMediaAreaCoordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(TLMediaAreaCoordinates coordinates) {
        this.coordinates = coordinates;
    }

    public TLAbsGeoPoint getGeo() {
        return geo;
    }

    public void setGeo(TLAbsGeoPoint geo) {
        this.geo = geo;
    }

    public TLGeoPointAddress getAddress() {
        return address;
    }

    public void setAddress(TLGeoPointAddress address) {
        this.address = address;
    }
}
