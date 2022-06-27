package com.github.badoualy.telegram.tl.api.channel;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsGeoPoint;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

public class TLChannelLocation extends TLAbsChannelLocation {

    public static final int CONSTRUCTOR_ID = 0x209b82db;

    protected TLAbsGeoPoint geoPoint;

    protected String address;

    private final String _constructor = "channelLocation#209b82db";

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
}
