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
public class TLChannelLocation extends TLAbsChannelLocation {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsGeoPoint geoPoint;

    protected String address;

    private final String _constructor = "channelLocation#0";

    public TLChannelLocation() {
    }

    public TLChannelLocation(TLAbsGeoPoint geoPoint, String address) {
        this.geoPoint = geoPoint;
        this.address = address;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(geoPoint, stream);
        writeString(address, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        geoPoint = readTLObject(stream, context, TLAbsGeoPoint.class, -1);
        address = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += geoPoint.computeSerializedSize();
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

    @Override
    public final boolean isEmpty() {
        return false;
    }

    @Override
    public final boolean isNotEmpty() {
        return true;
    }

    @Override
    public final TLChannelLocation getAsChannelLocation() {
        return this;
    }
}
