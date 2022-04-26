package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChatInviteExported extends TLAbsExportedChatInvite {

    public static final int CONSTRUCTOR_ID = 0xb18105e8;

    protected int flags;

    protected boolean revoked;

    protected boolean permanent;

    protected String link;

    protected long adminId;

    protected int date;

    protected Integer startDate;

    protected Integer expireDate;

    protected Integer usageLimit;

    protected Integer usage;

    private final String _constructor = "chatInviteExported#b18105e8";

    public TLChatInviteExported() {
    }


    public TLChatInviteExported(boolean revoked, boolean permanent, String link, long adminId, int date,
                                int startDate, int expireDate, int usageLimit, int usage) {
        this.revoked = revoked;
        this.permanent = permanent;
        this.link = link;
        this.adminId = adminId;
        this.date = date;
        this.startDate = startDate;
        this.expireDate = expireDate;
        this.usageLimit = usageLimit;
        this.usage = usage;
    }

    private void computeFlags() {
        flags = 0;
        flags = revoked ? (flags | 1) : (flags & ~1);
        flags = permanent ? (flags | 32) : (flags & ~32);
        flags = startDate != null ? (flags | 16) : (flags & ~16);
        flags = expireDate != null ? (flags | 2) : (flags & ~2);
        flags = usageLimit != null ? (flags | 4) : (flags & ~4);
        flags = usage != null ? (flags | 8) : (flags & ~8);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(link, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        revoked = (flags & 1) != 0;
        permanent = (flags & 32) != 0;
        link = readTLString(stream);
        adminId = readLong(stream);
        date = readInt(stream);
        if ((flags & 16) != 0) {
            startDate = readInt(stream);
        }
        if ((flags & 2) != 0) {
            expireDate =readInt(stream);
        }
        if ((flags & 4) != 0) {
            usageLimit = readInt(stream);
        }
        if ((flags & 8) != 0) {
            usage = readInt(stream);
        }
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        computeFlags();
        size += computeTLStringSerializedSize(link);
        size += SIZE_INT64;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public final boolean isEmpty() {
        return false;
    }

    @Override
    public final boolean isNotEmpty() {
        return true;
    }

    @Override
    public final TLChatInviteExported getAsChatInviteExported() {
        return this;
    }

    public boolean isRevoked() {
        return revoked;
    }

    public void setRevoked(boolean revoked) {
        this.revoked = revoked;
    }

    public boolean isPermanent() {
        return permanent;
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
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
}
