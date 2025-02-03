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
public class TLUpdateNewAuthorization extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean unconfirmed;

    protected long hash;

    protected Integer date;

    protected String device;

    protected String location;

    private final String _constructor = "updateNewAuthorization#0";

    public TLUpdateNewAuthorization() {
    }

    public TLUpdateNewAuthorization(boolean unconfirmed, long hash, Integer date, String device, String location) {
        this.unconfirmed = unconfirmed;
        this.hash = hash;
        this.date = date;
        this.device = device;
        this.location = location;
    }

    private void computeFlags() {
        flags = 0;
        flags = unconfirmed ? (flags | 1) : (flags & ~1);
        flags = date != null ? (flags | 1) : (flags & ~1);
        flags = device != null ? (flags | 1) : (flags & ~1);
        flags = location != null ? (flags | 1) : (flags & ~1);

        // Following parameters might be forced to true by another field that updated the flags
        unconfirmed = (flags & 1) != 0;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(hash, stream);
        if ((flags & 1) != 0) {
            if (date == null) throwNullFieldException("date", flags);
            writeInt(date, stream);
        }
        if ((flags & 1) != 0) {
            if (device == null) throwNullFieldException("device", flags);
            writeString(device, stream);
        }
        if ((flags & 1) != 0) {
            if (location == null) throwNullFieldException("location", flags);
            writeString(location, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        unconfirmed = (flags & 1) != 0;
        hash = readLong(stream);
        date = (flags & 1) != 0 ? readInt(stream) : null;
        device = (flags & 1) != 0 ? readTLString(stream) : null;
        location = (flags & 1) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        if ((flags & 1) != 0) {
            if (date == null) throwNullFieldException("date", flags);
            size += SIZE_INT32;
        }
        if ((flags & 1) != 0) {
            if (device == null) throwNullFieldException("device", flags);
            size += computeTLStringSerializedSize(device);
        }
        if ((flags & 1) != 0) {
            if (location == null) throwNullFieldException("location", flags);
            size += computeTLStringSerializedSize(location);
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

    public boolean getUnconfirmed() {
        return unconfirmed;
    }

    public void setUnconfirmed(boolean unconfirmed) {
        this.unconfirmed = unconfirmed;
    }

    public long getHash() {
        return hash;
    }

    public void setHash(long hash) {
        this.hash = hash;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
