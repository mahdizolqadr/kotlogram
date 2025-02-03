package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Double;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMediaAreaCoordinates extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected double x;

    protected double y;

    protected double w;

    protected double h;

    protected double rotation;

    protected Double radius;

    private final String _constructor = "mediaAreaCoordinates#0";

    public TLMediaAreaCoordinates() {
    }

    public TLMediaAreaCoordinates(double x, double y, double w, double h, double rotation, Double radius) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.rotation = rotation;
        this.radius = radius;
    }

    private void computeFlags() {
        flags = 0;
        flags = radius != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeDouble(x, stream);
        writeDouble(y, stream);
        writeDouble(w, stream);
        writeDouble(h, stream);
        writeDouble(rotation, stream);
        if ((flags & 1) != 0) {
            if (radius == null) throwNullFieldException("radius", flags);
            writeDouble(radius, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        x = readDouble(stream);
        y = readDouble(stream);
        w = readDouble(stream);
        h = readDouble(stream);
        rotation = readDouble(stream);
        radius = (flags & 1) != 0 ? readDouble(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_DOUBLE;
        size += SIZE_DOUBLE;
        size += SIZE_DOUBLE;
        size += SIZE_DOUBLE;
        size += SIZE_DOUBLE;
        if ((flags & 1) != 0) {
            if (radius == null) throwNullFieldException("radius", flags);
            size += SIZE_DOUBLE;
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

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getRotation() {
        return rotation;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }
}
