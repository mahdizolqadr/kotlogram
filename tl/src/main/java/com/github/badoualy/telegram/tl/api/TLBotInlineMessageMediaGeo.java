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
public class TLBotInlineMessageMediaGeo extends TLAbsBotInlineMessage {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsGeoPoint geo;

    protected Integer heading;

    protected Integer period;

    protected Integer proximityNotificationRadius;

    private final String _constructor = "botInlineMessageMediaGeo#0";

    public TLBotInlineMessageMediaGeo() {
    }

    public TLBotInlineMessageMediaGeo(TLAbsGeoPoint geo, Integer heading, Integer period, Integer proximityNotificationRadius, TLAbsReplyMarkup replyMarkup) {
        this.geo = geo;
        this.heading = heading;
        this.period = period;
        this.proximityNotificationRadius = proximityNotificationRadius;
        this.replyMarkup = replyMarkup;
    }

    private void computeFlags() {
        flags = 0;
        flags = heading != null ? (flags | 1) : (flags & ~1);
        flags = period != null ? (flags | 2) : (flags & ~2);
        flags = proximityNotificationRadius != null ? (flags | 8) : (flags & ~8);
        flags = replyMarkup != null ? (flags | 4) : (flags & ~4);
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
        if ((flags & 2) != 0) {
            if (period == null) throwNullFieldException("period", flags);
            writeInt(period, stream);
        }
        if ((flags & 8) != 0) {
            if (proximityNotificationRadius == null) throwNullFieldException("proximityNotificationRadius", flags);
            writeInt(proximityNotificationRadius, stream);
        }
        if ((flags & 4) != 0) {
            if (replyMarkup == null) throwNullFieldException("replyMarkup", flags);
            writeTLObject(replyMarkup, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        geo = readTLObject(stream, context, TLAbsGeoPoint.class, -1);
        heading = (flags & 1) != 0 ? readInt(stream) : null;
        period = (flags & 2) != 0 ? readInt(stream) : null;
        proximityNotificationRadius = (flags & 8) != 0 ? readInt(stream) : null;
        replyMarkup = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsReplyMarkup.class, -1) : null;
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
        if ((flags & 2) != 0) {
            if (period == null) throwNullFieldException("period", flags);
            size += SIZE_INT32;
        }
        if ((flags & 8) != 0) {
            if (proximityNotificationRadius == null) throwNullFieldException("proximityNotificationRadius", flags);
            size += SIZE_INT32;
        }
        if ((flags & 4) != 0) {
            if (replyMarkup == null) throwNullFieldException("replyMarkup", flags);
            size += replyMarkup.computeSerializedSize();
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

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getProximityNotificationRadius() {
        return proximityNotificationRadius;
    }

    public void setProximityNotificationRadius(Integer proximityNotificationRadius) {
        this.proximityNotificationRadius = proximityNotificationRadius;
    }

    public TLAbsReplyMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public void setReplyMarkup(TLAbsReplyMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
    }
}
