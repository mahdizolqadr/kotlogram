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
public class TLChannelParticipant extends TLAbsChannelParticipant {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected long userId;

    protected int date;

    protected Integer subscriptionUntilDate;

    private final String _constructor = "channelParticipant#0";

    public TLChannelParticipant() {
    }

    public TLChannelParticipant(long userId, int date, Integer subscriptionUntilDate) {
        this.userId = userId;
        this.date = date;
        this.subscriptionUntilDate = subscriptionUntilDate;
    }

    private void computeFlags() {
        flags = 0;
        flags = subscriptionUntilDate != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(userId, stream);
        writeInt(date, stream);
        if ((flags & 1) != 0) {
            if (subscriptionUntilDate == null) throwNullFieldException("subscriptionUntilDate", flags);
            writeInt(subscriptionUntilDate, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        userId = readLong(stream);
        date = readInt(stream);
        subscriptionUntilDate = (flags & 1) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (subscriptionUntilDate == null) throwNullFieldException("subscriptionUntilDate", flags);
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public Integer getSubscriptionUntilDate() {
        return subscriptionUntilDate;
    }

    public void setSubscriptionUntilDate(Integer subscriptionUntilDate) {
        this.subscriptionUntilDate = subscriptionUntilDate;
    }
}
