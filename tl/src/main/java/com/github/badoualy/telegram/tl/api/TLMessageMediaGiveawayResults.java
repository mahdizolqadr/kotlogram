package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLLongVector;
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
public class TLMessageMediaGiveawayResults extends TLAbsMessageMedia {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean onlyNewSubscribers;

    protected boolean refunded;

    protected long channelId;

    protected Integer additionalPeersCount;

    protected int launchMsgId;

    protected int winnersCount;

    protected int unclaimedCount;

    protected TLLongVector winners;

    protected Integer months;

    protected Long stars;

    protected String prizeDescription;

    protected int untilDate;

    private final String _constructor = "messageMediaGiveawayResults#0";

    public TLMessageMediaGiveawayResults() {
    }

    public TLMessageMediaGiveawayResults(boolean onlyNewSubscribers, boolean refunded, long channelId, Integer additionalPeersCount, int launchMsgId, int winnersCount, int unclaimedCount, TLLongVector winners, Integer months, Long stars, String prizeDescription, int untilDate) {
        this.onlyNewSubscribers = onlyNewSubscribers;
        this.refunded = refunded;
        this.channelId = channelId;
        this.additionalPeersCount = additionalPeersCount;
        this.launchMsgId = launchMsgId;
        this.winnersCount = winnersCount;
        this.unclaimedCount = unclaimedCount;
        this.winners = winners;
        this.months = months;
        this.stars = stars;
        this.prizeDescription = prizeDescription;
        this.untilDate = untilDate;
    }

    private void computeFlags() {
        flags = 0;
        flags = onlyNewSubscribers ? (flags | 1) : (flags & ~1);
        flags = refunded ? (flags | 4) : (flags & ~4);
        flags = additionalPeersCount != null ? (flags | 8) : (flags & ~8);
        flags = months != null ? (flags | 16) : (flags & ~16);
        flags = stars != null ? (flags | 32) : (flags & ~32);
        flags = prizeDescription != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(channelId, stream);
        if ((flags & 8) != 0) {
            if (additionalPeersCount == null) throwNullFieldException("additionalPeersCount", flags);
            writeInt(additionalPeersCount, stream);
        }
        writeInt(launchMsgId, stream);
        writeInt(winnersCount, stream);
        writeInt(unclaimedCount, stream);
        writeTLVector(winners, stream);
        if ((flags & 16) != 0) {
            if (months == null) throwNullFieldException("months", flags);
            writeInt(months, stream);
        }
        if ((flags & 32) != 0) {
            if (stars == null) throwNullFieldException("stars", flags);
            writeLong(stars, stream);
        }
        if ((flags & 2) != 0) {
            if (prizeDescription == null) throwNullFieldException("prizeDescription", flags);
            writeString(prizeDescription, stream);
        }
        writeInt(untilDate, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        onlyNewSubscribers = (flags & 1) != 0;
        refunded = (flags & 4) != 0;
        channelId = readLong(stream);
        additionalPeersCount = (flags & 8) != 0 ? readInt(stream) : null;
        launchMsgId = readInt(stream);
        winnersCount = readInt(stream);
        unclaimedCount = readInt(stream);
        winners = readTLLongVector(stream, context);
        months = (flags & 16) != 0 ? readInt(stream) : null;
        stars = (flags & 32) != 0 ? readLong(stream) : null;
        prizeDescription = (flags & 2) != 0 ? readTLString(stream) : null;
        untilDate = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        if ((flags & 8) != 0) {
            if (additionalPeersCount == null) throwNullFieldException("additionalPeersCount", flags);
            size += SIZE_INT32;
        }
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += winners.computeSerializedSize();
        if ((flags & 16) != 0) {
            if (months == null) throwNullFieldException("months", flags);
            size += SIZE_INT32;
        }
        if ((flags & 32) != 0) {
            if (stars == null) throwNullFieldException("stars", flags);
            size += SIZE_INT64;
        }
        if ((flags & 2) != 0) {
            if (prizeDescription == null) throwNullFieldException("prizeDescription", flags);
            size += computeTLStringSerializedSize(prizeDescription);
        }
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

    public boolean getOnlyNewSubscribers() {
        return onlyNewSubscribers;
    }

    public void setOnlyNewSubscribers(boolean onlyNewSubscribers) {
        this.onlyNewSubscribers = onlyNewSubscribers;
    }

    public boolean getRefunded() {
        return refunded;
    }

    public void setRefunded(boolean refunded) {
        this.refunded = refunded;
    }

    public long getChannelId() {
        return channelId;
    }

    public void setChannelId(long channelId) {
        this.channelId = channelId;
    }

    public Integer getAdditionalPeersCount() {
        return additionalPeersCount;
    }

    public void setAdditionalPeersCount(Integer additionalPeersCount) {
        this.additionalPeersCount = additionalPeersCount;
    }

    public int getLaunchMsgId() {
        return launchMsgId;
    }

    public void setLaunchMsgId(int launchMsgId) {
        this.launchMsgId = launchMsgId;
    }

    public int getWinnersCount() {
        return winnersCount;
    }

    public void setWinnersCount(int winnersCount) {
        this.winnersCount = winnersCount;
    }

    public int getUnclaimedCount() {
        return unclaimedCount;
    }

    public void setUnclaimedCount(int unclaimedCount) {
        this.unclaimedCount = unclaimedCount;
    }

    public TLLongVector getWinners() {
        return winners;
    }

    public void setWinners(TLLongVector winners) {
        this.winners = winners;
    }

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        this.months = months;
    }

    public Long getStars() {
        return stars;
    }

    public void setStars(Long stars) {
        this.stars = stars;
    }

    public String getPrizeDescription() {
        return prizeDescription;
    }

    public void setPrizeDescription(String prizeDescription) {
        this.prizeDescription = prizeDescription;
    }

    public int getUntilDate() {
        return untilDate;
    }

    public void setUntilDate(int untilDate) {
        this.untilDate = untilDate;
    }
}
