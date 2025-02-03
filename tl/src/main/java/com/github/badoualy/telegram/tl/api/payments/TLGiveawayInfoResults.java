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
public class TLGiveawayInfoResults extends TLAbsGiveawayInfo {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected boolean winner;

    protected boolean refunded;

    protected String giftCodeSlug;

    protected Long starsPrize;

    protected int finishDate;

    protected int winnersCount;

    protected Integer activatedCount;

    private final String _constructor = "payments.giveawayInfoResults#0";

    public TLGiveawayInfoResults() {
    }

    public TLGiveawayInfoResults(boolean winner, boolean refunded, int startDate, String giftCodeSlug, Long starsPrize, int finishDate, int winnersCount, Integer activatedCount) {
        this.winner = winner;
        this.refunded = refunded;
        this.startDate = startDate;
        this.giftCodeSlug = giftCodeSlug;
        this.starsPrize = starsPrize;
        this.finishDate = finishDate;
        this.winnersCount = winnersCount;
        this.activatedCount = activatedCount;
    }

    private void computeFlags() {
        flags = 0;
        flags = winner ? (flags | 1) : (flags & ~1);
        flags = refunded ? (flags | 2) : (flags & ~2);
        flags = giftCodeSlug != null ? (flags | 8) : (flags & ~8);
        flags = starsPrize != null ? (flags | 16) : (flags & ~16);
        flags = activatedCount != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(startDate, stream);
        if ((flags & 8) != 0) {
            if (giftCodeSlug == null) throwNullFieldException("giftCodeSlug", flags);
            writeString(giftCodeSlug, stream);
        }
        if ((flags & 16) != 0) {
            if (starsPrize == null) throwNullFieldException("starsPrize", flags);
            writeLong(starsPrize, stream);
        }
        writeInt(finishDate, stream);
        writeInt(winnersCount, stream);
        if ((flags & 4) != 0) {
            if (activatedCount == null) throwNullFieldException("activatedCount", flags);
            writeInt(activatedCount, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        winner = (flags & 1) != 0;
        refunded = (flags & 2) != 0;
        startDate = readInt(stream);
        giftCodeSlug = (flags & 8) != 0 ? readTLString(stream) : null;
        starsPrize = (flags & 16) != 0 ? readLong(stream) : null;
        finishDate = readInt(stream);
        winnersCount = readInt(stream);
        activatedCount = (flags & 4) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 8) != 0) {
            if (giftCodeSlug == null) throwNullFieldException("giftCodeSlug", flags);
            size += computeTLStringSerializedSize(giftCodeSlug);
        }
        if ((flags & 16) != 0) {
            if (starsPrize == null) throwNullFieldException("starsPrize", flags);
            size += SIZE_INT64;
        }
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 4) != 0) {
            if (activatedCount == null) throwNullFieldException("activatedCount", flags);
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

    public boolean getWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public boolean getRefunded() {
        return refunded;
    }

    public void setRefunded(boolean refunded) {
        this.refunded = refunded;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public String getGiftCodeSlug() {
        return giftCodeSlug;
    }

    public void setGiftCodeSlug(String giftCodeSlug) {
        this.giftCodeSlug = giftCodeSlug;
    }

    public Long getStarsPrize() {
        return starsPrize;
    }

    public void setStarsPrize(Long starsPrize) {
        this.starsPrize = starsPrize;
    }

    public int getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(int finishDate) {
        this.finishDate = finishDate;
    }

    public int getWinnersCount() {
        return winnersCount;
    }

    public void setWinnersCount(int winnersCount) {
        this.winnersCount = winnersCount;
    }

    public Integer getActivatedCount() {
        return activatedCount;
    }

    public void setActivatedCount(Integer activatedCount) {
        this.activatedCount = activatedCount;
    }
}
