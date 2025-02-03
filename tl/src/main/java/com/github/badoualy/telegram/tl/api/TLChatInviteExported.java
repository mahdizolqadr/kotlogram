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
public class TLChatInviteExported extends TLAbsExportedChatInvite {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean revoked;

    protected boolean permanent;

    protected boolean requestNeeded;

    protected String link;

    protected long adminId;

    protected int date;

    protected Integer startDate;

    protected Integer expireDate;

    protected Integer usageLimit;

    protected Integer usage;

    protected Integer requested;

    protected Integer subscriptionExpired;

    protected String title;

    protected TLStarsSubscriptionPricing subscriptionPricing;

    private final String _constructor = "chatInviteExported#0";

    public TLChatInviteExported() {
    }

    public TLChatInviteExported(boolean revoked, boolean permanent, boolean requestNeeded, String link, long adminId, int date, Integer startDate, Integer expireDate, Integer usageLimit, Integer usage, Integer requested, Integer subscriptionExpired, String title, TLStarsSubscriptionPricing subscriptionPricing) {
        this.revoked = revoked;
        this.permanent = permanent;
        this.requestNeeded = requestNeeded;
        this.link = link;
        this.adminId = adminId;
        this.date = date;
        this.startDate = startDate;
        this.expireDate = expireDate;
        this.usageLimit = usageLimit;
        this.usage = usage;
        this.requested = requested;
        this.subscriptionExpired = subscriptionExpired;
        this.title = title;
        this.subscriptionPricing = subscriptionPricing;
    }

    private void computeFlags() {
        flags = 0;
        flags = revoked ? (flags | 1) : (flags & ~1);
        flags = permanent ? (flags | 32) : (flags & ~32);
        flags = requestNeeded ? (flags | 64) : (flags & ~64);
        flags = startDate != null ? (flags | 16) : (flags & ~16);
        flags = expireDate != null ? (flags | 2) : (flags & ~2);
        flags = usageLimit != null ? (flags | 4) : (flags & ~4);
        flags = usage != null ? (flags | 8) : (flags & ~8);
        flags = requested != null ? (flags | 128) : (flags & ~128);
        flags = subscriptionExpired != null ? (flags | 1024) : (flags & ~1024);
        flags = title != null ? (flags | 256) : (flags & ~256);
        flags = subscriptionPricing != null ? (flags | 512) : (flags & ~512);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(link, stream);
        writeLong(adminId, stream);
        writeInt(date, stream);
        if ((flags & 16) != 0) {
            if (startDate == null) throwNullFieldException("startDate", flags);
            writeInt(startDate, stream);
        }
        if ((flags & 2) != 0) {
            if (expireDate == null) throwNullFieldException("expireDate", flags);
            writeInt(expireDate, stream);
        }
        if ((flags & 4) != 0) {
            if (usageLimit == null) throwNullFieldException("usageLimit", flags);
            writeInt(usageLimit, stream);
        }
        if ((flags & 8) != 0) {
            if (usage == null) throwNullFieldException("usage", flags);
            writeInt(usage, stream);
        }
        if ((flags & 128) != 0) {
            if (requested == null) throwNullFieldException("requested", flags);
            writeInt(requested, stream);
        }
        if ((flags & 1024) != 0) {
            if (subscriptionExpired == null) throwNullFieldException("subscriptionExpired", flags);
            writeInt(subscriptionExpired, stream);
        }
        if ((flags & 256) != 0) {
            if (title == null) throwNullFieldException("title", flags);
            writeString(title, stream);
        }
        if ((flags & 512) != 0) {
            if (subscriptionPricing == null) throwNullFieldException("subscriptionPricing", flags);
            writeTLObject(subscriptionPricing, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        revoked = (flags & 1) != 0;
        permanent = (flags & 32) != 0;
        requestNeeded = (flags & 64) != 0;
        link = readTLString(stream);
        adminId = readLong(stream);
        date = readInt(stream);
        startDate = (flags & 16) != 0 ? readInt(stream) : null;
        expireDate = (flags & 2) != 0 ? readInt(stream) : null;
        usageLimit = (flags & 4) != 0 ? readInt(stream) : null;
        usage = (flags & 8) != 0 ? readInt(stream) : null;
        requested = (flags & 128) != 0 ? readInt(stream) : null;
        subscriptionExpired = (flags & 1024) != 0 ? readInt(stream) : null;
        title = (flags & 256) != 0 ? readTLString(stream) : null;
        subscriptionPricing = (flags & 512) != 0 ? readTLObject(stream, context, TLStarsSubscriptionPricing.class, TLStarsSubscriptionPricing.CONSTRUCTOR_ID) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(link);
        size += SIZE_INT64;
        size += SIZE_INT32;
        if ((flags & 16) != 0) {
            if (startDate == null) throwNullFieldException("startDate", flags);
            size += SIZE_INT32;
        }
        if ((flags & 2) != 0) {
            if (expireDate == null) throwNullFieldException("expireDate", flags);
            size += SIZE_INT32;
        }
        if ((flags & 4) != 0) {
            if (usageLimit == null) throwNullFieldException("usageLimit", flags);
            size += SIZE_INT32;
        }
        if ((flags & 8) != 0) {
            if (usage == null) throwNullFieldException("usage", flags);
            size += SIZE_INT32;
        }
        if ((flags & 128) != 0) {
            if (requested == null) throwNullFieldException("requested", flags);
            size += SIZE_INT32;
        }
        if ((flags & 1024) != 0) {
            if (subscriptionExpired == null) throwNullFieldException("subscriptionExpired", flags);
            size += SIZE_INT32;
        }
        if ((flags & 256) != 0) {
            if (title == null) throwNullFieldException("title", flags);
            size += computeTLStringSerializedSize(title);
        }
        if ((flags & 512) != 0) {
            if (subscriptionPricing == null) throwNullFieldException("subscriptionPricing", flags);
            size += subscriptionPricing.computeSerializedSize();
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

    public boolean getRevoked() {
        return revoked;
    }

    public void setRevoked(boolean revoked) {
        this.revoked = revoked;
    }

    public boolean getPermanent() {
        return permanent;
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    public boolean getRequestNeeded() {
        return requestNeeded;
    }

    public void setRequestNeeded(boolean requestNeeded) {
        this.requestNeeded = requestNeeded;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public Integer getStartDate() {
        return startDate;
    }

    public void setStartDate(Integer startDate) {
        this.startDate = startDate;
    }

    public Integer getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Integer expireDate) {
        this.expireDate = expireDate;
    }

    public Integer getUsageLimit() {
        return usageLimit;
    }

    public void setUsageLimit(Integer usageLimit) {
        this.usageLimit = usageLimit;
    }

    public Integer getUsage() {
        return usage;
    }

    public void setUsage(Integer usage) {
        this.usage = usage;
    }

    public Integer getRequested() {
        return requested;
    }

    public void setRequested(Integer requested) {
        this.requested = requested;
    }

    public Integer getSubscriptionExpired() {
        return subscriptionExpired;
    }

    public void setSubscriptionExpired(Integer subscriptionExpired) {
        this.subscriptionExpired = subscriptionExpired;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TLStarsSubscriptionPricing getSubscriptionPricing() {
        return subscriptionPricing;
    }

    public void setSubscriptionPricing(TLStarsSubscriptionPricing subscriptionPricing) {
        this.subscriptionPricing = subscriptionPricing;
    }
}
