package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMessageMediaGeoLive extends TLAbsMessageMedia {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLAbsGeoPoint geo;

    protected Integer heading;

    protected int period;

    protected Integer proximityNotificationRadius;

    private final String _constructor = "messageMediaGeoLive#0";

    public TLMessageMediaGeoLive() {
    }

    public TLMessageMediaGeoLive(TLAbsGeoPoint geo, Integer heading, int period, Integer proximityNotificationRadius) {
        this.geo = geo;
        this.heading = heading;
        this.period = period;
        this.proximityNotificationRadius = proximityNotificationRadius;
    }

    private void computeFlags() {
        flags = 0;
        flags = heading != null ? (flags | 1) : (flags & ~1);
        flags = proximityNotificationRadius != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(geo, stream);
        if ((flags & 1) != 0) {
            if (heading == null) throwNullFieldException("heading", flags);
            writeInt(heading, stream);
        }
        writeInt(period, stream);
        if ((flags & 2) != 0) {
            if (proximityNotificationRadius == null) throwNullFieldException("proximityNotificationRadius", flags);
            writeInt(proximityNotificationRadius, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        geo = readTLObject(stream, context, TLAbsGeoPoint.class, -1);
        heading = (flags & 1) != 0 ? readInt(stream) : null;
        period = readInt(stream);
        proximityNotificationRadius = (flags & 2) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += geo.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (heading == null) throwNullFieldException("heading", flags);
            size += SIZE_INT32;
        }
        size += SIZE_INT32;
        if ((flags & 2) != 0) {
            if (proximityNotificationRadius == null) throwNullFieldException("proximityNotificationRadius", flags);
            size += SIZE_INT32;
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

    public TLAbsGeoPoint getGeo() {
        return geo;
    }

    public void setGeo(TLAbsGeoPoint geo) {
        this.geo = geo;
    }

    public Integer getHeading() {
        return heading;
    }

    public void setHeading(Integer heading) {
        this.heading = heading;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public Integer getProximityNotificationRadius() {
        return proximityNotificationRadius;
    }

    public void setProximityNotificationRadius(Integer proximityNotificationRadius) {
        this.proximityNotificationRadius = proximityNotificationRadius;
    }
}
