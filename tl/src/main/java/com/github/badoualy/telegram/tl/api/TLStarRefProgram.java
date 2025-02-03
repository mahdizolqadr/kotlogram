package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLStarRefProgram extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected long botId;

    protected int commissionPermille;

    protected Integer durationMonths;

    protected Integer endDate;

    protected TLStarsAmount dailyRevenuePerUser;

    private final String _constructor = "starRefProgram#0";

    public TLStarRefProgram() {
    }

    public TLStarRefProgram(long botId, int commissionPermille, Integer durationMonths, Integer endDate, TLStarsAmount dailyRevenuePerUser) {
        this.botId = botId;
        this.commissionPermille = commissionPermille;
        this.durationMonths = durationMonths;
        this.endDate = endDate;
        this.dailyRevenuePerUser = dailyRevenuePerUser;
    }

    private void computeFlags() {
        flags = 0;
        flags = durationMonths != null ? (flags | 1) : (flags & ~1);
        flags = endDate != null ? (flags | 2) : (flags & ~2);
        flags = dailyRevenuePerUser != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(botId, stream);
        writeInt(commissionPermille, stream);
        if ((flags & 1) != 0) {
            if (durationMonths == null) throwNullFieldException("durationMonths", flags);
            writeInt(durationMonths, stream);
        }
        if ((flags & 2) != 0) {
            if (endDate == null) throwNullFieldException("endDate", flags);
            writeInt(endDate, stream);
        }
        if ((flags & 4) != 0) {
            if (dailyRevenuePerUser == null) throwNullFieldException("dailyRevenuePerUser", flags);
            writeTLObject(dailyRevenuePerUser, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        botId = readLong(stream);
        commissionPermille = readInt(stream);
        durationMonths = (flags & 1) != 0 ? readInt(stream) : null;
        endDate = (flags & 2) != 0 ? readInt(stream) : null;
        dailyRevenuePerUser = (flags & 4) != 0 ? readTLObject(stream, context, TLStarsAmount.class, TLStarsAmount.CONSTRUCTOR_ID) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (durationMonths == null) throwNullFieldException("durationMonths", flags);
            size += SIZE_INT32;
        }
        if ((flags & 2) != 0) {
            if (endDate == null) throwNullFieldException("endDate", flags);
            size += SIZE_INT32;
        }
        if ((flags & 4) != 0) {
            if (dailyRevenuePerUser == null) throwNullFieldException("dailyRevenuePerUser", flags);
            size += dailyRevenuePerUser.computeSerializedSize();
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

    public long getBotId() {
        return botId;
    }

    public void setBotId(long botId) {
        this.botId = botId;
    }

    public int getCommissionPermille() {
        return commissionPermille;
    }

    public void setCommissionPermille(int commissionPermille) {
        this.commissionPermille = commissionPermille;
    }

    public Integer getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(Integer durationMonths) {
        this.durationMonths = durationMonths;
    }

    public Integer getEndDate() {
        return endDate;
    }

    public void setEndDate(Integer endDate) {
        this.endDate = endDate;
    }

    public TLStarsAmount getDailyRevenuePerUser() {
        return dailyRevenuePerUser;
    }

    public void setDailyRevenuePerUser(TLStarsAmount dailyRevenuePerUser) {
        this.dailyRevenuePerUser = dailyRevenuePerUser;
    }
}
