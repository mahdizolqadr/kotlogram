package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputGeoPoint;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLRequestContactsGetLocated extends TLMethod<TLAbsUpdates> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean background;

    protected TLAbsInputGeoPoint geoPoint;

    protected Integer selfExpires;

    private final String _constructor = "contacts.getLocated#0";

    public TLRequestContactsGetLocated() {
    }

    public TLRequestContactsGetLocated(boolean background, TLAbsInputGeoPoint geoPoint, Integer selfExpires) {
        this.background = background;
        this.geoPoint = geoPoint;
        this.selfExpires = selfExpires;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsUpdates deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsUpdates)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsUpdates) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = background ? (flags | 2) : (flags & ~2);
        flags = selfExpires != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(geoPoint, stream);
        if ((flags & 1) != 0) {
            if (selfExpires == null) throwNullFieldException("selfExpires", flags);
            writeInt(selfExpires, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        background = (flags & 2) != 0;
        geoPoint = readTLObject(stream, context, TLAbsInputGeoPoint.class, -1);
        selfExpires = (flags & 1) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += geoPoint.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (selfExpires == null) throwNullFieldException("selfExpires", flags);
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

    public boolean getBackground() {
        return background;
    }

    public void setBackground(boolean background) {
        this.background = background;
    }

    public TLAbsInputGeoPoint getGeoPoint() {
        return geoPoint;
    }

    public void setGeoPoint(TLAbsInputGeoPoint geoPoint) {
        this.geoPoint = geoPoint;
    }

    public Integer getSelfExpires() {
        return selfExpires;
    }

    public void setSelfExpires(Integer selfExpires) {
        this.selfExpires = selfExpires;
    }
}
