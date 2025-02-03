package com.github.badoualy.telegram.tl.api.payments;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLGiveawayInfo extends TLAbsGiveawayInfo {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected boolean participating;

    protected boolean preparingResults;

    protected Integer joinedTooEarlyDate;

    protected Long adminDisallowedChatId;

    protected String disallowedCountry;

    private final String _constructor = "payments.giveawayInfo#0";

    public TLGiveawayInfo() {
    }

    public TLGiveawayInfo(boolean participating, boolean preparingResults, int startDate, Integer joinedTooEarlyDate, Long adminDisallowedChatId, String disallowedCountry) {
        this.participating = participating;
        this.preparingResults = preparingResults;
        this.startDate = startDate;
        this.joinedTooEarlyDate = joinedTooEarlyDate;
        this.adminDisallowedChatId = adminDisallowedChatId;
        this.disallowedCountry = disallowedCountry;
    }

    private void computeFlags() {
        flags = 0;
        flags = participating ? (flags | 1) : (flags & ~1);
        flags = preparingResults ? (flags | 8) : (flags & ~8);
        flags = joinedTooEarlyDate != null ? (flags | 2) : (flags & ~2);
        flags = adminDisallowedChatId != null ? (flags | 4) : (flags & ~4);
        flags = disallowedCountry != null ? (flags | 16) : (flags & ~16);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(startDate, stream);
        if ((flags & 2) != 0) {
            if (joinedTooEarlyDate == null) throwNullFieldException("joinedTooEarlyDate", flags);
            writeInt(joinedTooEarlyDate, stream);
        }
        if ((flags & 4) != 0) {
            if (adminDisallowedChatId == null) throwNullFieldException("adminDisallowedChatId", flags);
            writeLong(adminDisallowedChatId, stream);
        }
        if ((flags & 16) != 0) {
            if (disallowedCountry == null) throwNullFieldException("disallowedCountry", flags);
            writeString(disallowedCountry, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        participating = (flags & 1) != 0;
        preparingResults = (flags & 8) != 0;
        startDate = readInt(stream);
        joinedTooEarlyDate = (flags & 2) != 0 ? readInt(stream) : null;
        adminDisallowedChatId = (flags & 4) != 0 ? readLong(stream) : null;
        disallowedCountry = (flags & 16) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 2) != 0) {
            if (joinedTooEarlyDate == null) throwNullFieldException("joinedTooEarlyDate", flags);
            size += SIZE_INT32;
        }
        if ((flags & 4) != 0) {
            if (adminDisallowedChatId == null) throwNullFieldException("adminDisallowedChatId", flags);
            size += SIZE_INT64;
        }
        if ((flags & 16) != 0) {
            if (disallowedCountry == null) throwNullFieldException("disallowedCountry", flags);
            size += computeTLStringSerializedSize(disallowedCountry);
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

    public boolean getParticipating() {
        return participating;
    }

    public void setParticipating(boolean participating) {
        this.participating = participating;
    }

    public boolean getPreparingResults() {
        return preparingResults;
    }

    public void setPreparingResults(boolean preparingResults) {
        this.preparingResults = preparingResults;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public Integer getJoinedTooEarlyDate() {
        return joinedTooEarlyDate;
    }

    public void setJoinedTooEarlyDate(Integer joinedTooEarlyDate) {
        this.joinedTooEarlyDate = joinedTooEarlyDate;
    }

    public Long getAdminDisallowedChatId() {
        return adminDisallowedChatId;
    }

    public void setAdminDisallowedChatId(Long adminDisallowedChatId) {
        this.adminDisallowedChatId = adminDisallowedChatId;
    }

    public String getDisallowedCountry() {
        return disallowedCountry;
    }

    public void setDisallowedCountry(String disallowedCountry) {
        this.disallowedCountry = disallowedCountry;
    }
}
