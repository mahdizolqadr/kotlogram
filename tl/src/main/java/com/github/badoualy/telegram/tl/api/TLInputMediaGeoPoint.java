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
public class TLInputMediaGeoPoint extends TLAbsInputMedia {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsInputGeoPoint geoPoint;

    private final String _constructor = "inputMediaGeoPoint#0";

    public TLInputMediaGeoPoint() {
    }

    public TLInputMediaGeoPoint(TLAbsInputGeoPoint geoPoint) {
        this.geoPoint = geoPoint;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(geoPoint, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        geoPoint = readTLObject(stream, context, TLAbsInputGeoPoint.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += geoPoint.computeSerializedSize();
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
}
