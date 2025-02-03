package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.messages.TLAbsChats;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLRequestChannelsGetAdminedPublicChannels extends TLMethod<TLAbsChats> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean byLocation;

    protected boolean checkLimit;

    protected boolean forPersonal;

    private final String _constructor = "channels.getAdminedPublicChannels#0";

    public TLRequestChannelsGetAdminedPublicChannels() {
    }

    public TLRequestChannelsGetAdminedPublicChannels(boolean byLocation, boolean checkLimit, boolean forPersonal) {
        this.byLocation = byLocation;
        this.checkLimit = checkLimit;
        this.forPersonal = forPersonal;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsChats deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsChats)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsChats) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = byLocation ? (flags | 1) : (flags & ~1);
        flags = checkLimit ? (flags | 2) : (flags & ~2);
        flags = forPersonal ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        byLocation = (flags & 1) != 0;
        checkLimit = (flags & 2) != 0;
        forPersonal = (flags & 4) != 0;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
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

    public boolean getByLocation() {
        return byLocation;
    }

    public void setByLocation(boolean byLocation) {
        this.byLocation = byLocation;
    }

    public boolean getCheckLimit() {
        return checkLimit;
    }

    public void setCheckLimit(boolean checkLimit) {
        this.checkLimit = checkLimit;
    }

    public boolean getForPersonal() {
        return forPersonal;
    }

    public void setForPersonal(boolean forPersonal) {
        this.forPersonal = forPersonal;
    }
}
