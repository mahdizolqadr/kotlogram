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
public class TLInputWebFileGeoPointLocation extends TLAbsInputWebFileLocation {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsInputGeoPoint geoPoint;

    protected long accessHash;

    protected int w;

    protected int h;

    protected int zoom;

    protected int scale;

    private final String _constructor = "inputWebFileGeoPointLocation#0";

    public TLInputWebFileGeoPointLocation() {
    }

    public TLInputWebFileGeoPointLocation(TLAbsInputGeoPoint geoPoint, long accessHash, int w, int h, int zoom, int scale) {
        this.geoPoint = geoPoint;
        this.accessHash = accessHash;
        this.w = w;
        this.h = h;
        this.zoom = zoom;
        this.scale = scale;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(geoPoint, stream);
        writeLong(accessHash, stream);
        writeInt(w, stream);
        writeInt(h, stream);
        writeInt(zoom, stream);
        writeInt(scale, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        geoPoint = readTLObject(stream, context, TLAbsInputGeoPoint.class, -1);
        accessHash = readLong(stream);
        w = readInt(stream);
        h = readInt(stream);
        zoom = readInt(stream);
        scale = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += geoPoint.computeSerializedSize();
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += SIZE_INT32;
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

    public TLAbsInputGeoPoint getGeoPoint() {
        return geoPoint;
    }

    public void setGeoPoint(TLAbsInputGeoPoint geoPoint) {
        this.geoPoint = geoPoint;
    }

    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long accessHash) {
        this.accessHash = accessHash;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }
}
