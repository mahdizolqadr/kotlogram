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
public class TLChannelParticipantSelf extends TLAbsChannelParticipant {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean viaRequest;

    protected long userId;

    protected long inviterId;

    protected int date;

    protected Integer subscriptionUntilDate;

    private final String _constructor = "channelParticipantSelf#0";

    public TLChannelParticipantSelf() {
    }

    public TLChannelParticipantSelf(boolean viaRequest, long userId, long inviterId, int date, Integer subscriptionUntilDate) {
        this.viaRequest = viaRequest;
        this.userId = userId;
        this.inviterId = inviterId;
        this.date = date;
        this.subscriptionUntilDate = subscriptionUntilDate;
    }

    private void computeFlags() {
        flags = 0;
        flags = viaRequest ? (flags | 1) : (flags & ~1);
        flags = subscriptionUntilDate != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(userId, stream);
        writeLong(inviterId, stream);
        writeInt(date, stream);
        if ((flags & 2) != 0) {
            if (subscriptionUntilDate == null) throwNullFieldException("subscriptionUntilDate", flags);
            writeInt(subscriptionUntilDate, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        viaRequest = (flags & 1) != 0;
        userId = readLong(stream);
        inviterId = readLong(stream);
        date = readInt(stream);
        subscriptionUntilDate = (flags & 2) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += SIZE_INT32;
        if ((flags & 2) != 0) {
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

    public boolean getViaRequest() {
        return viaRequest;
    }

    public void setViaRequest(boolean viaRequest) {
        this.viaRequest = viaRequest;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getInviterId() {
        return inviterId;
    }

    public void setInviterId(long inviterId) {
        this.inviterId = inviterId;
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
