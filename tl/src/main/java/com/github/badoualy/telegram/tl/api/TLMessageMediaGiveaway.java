package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLLongVector;
import com.github.badoualy.telegram.tl.core.TLStringVector;
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
public class TLMessageMediaGiveaway extends TLAbsMessageMedia {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean onlyNewSubscribers;

    protected boolean winnersAreVisible;

    protected TLLongVector channels;

    protected TLStringVector countriesIso2;

    protected String prizeDescription;

    protected int quantity;

    protected Integer months;

    protected Long stars;

    protected int untilDate;

    private final String _constructor = "messageMediaGiveaway#0";

    public TLMessageMediaGiveaway() {
    }

    public TLMessageMediaGiveaway(boolean onlyNewSubscribers, boolean winnersAreVisible, TLLongVector channels, TLStringVector countriesIso2, String prizeDescription, int quantity, Integer months, Long stars, int untilDate) {
        this.onlyNewSubscribers = onlyNewSubscribers;
        this.winnersAreVisible = winnersAreVisible;
        this.channels = channels;
        this.countriesIso2 = countriesIso2;
        this.prizeDescription = prizeDescription;
        this.quantity = quantity;
        this.months = months;
        this.stars = stars;
        this.untilDate = untilDate;
    }

    private void computeFlags() {
        flags = 0;
        flags = onlyNewSubscribers ? (flags | 1) : (flags & ~1);
        flags = winnersAreVisible ? (flags | 4) : (flags & ~4);
        flags = countriesIso2 != null ? (flags | 2) : (flags & ~2);
        flags = prizeDescription != null ? (flags | 8) : (flags & ~8);
        flags = months != null ? (flags | 16) : (flags & ~16);
        flags = stars != null ? (flags | 32) : (flags & ~32);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLVector(channels, stream);
        if ((flags & 2) != 0) {
            if (countriesIso2 == null) throwNullFieldException("countriesIso2", flags);
            writeTLVector(countriesIso2, stream);
        }
        if ((flags & 8) != 0) {
            if (prizeDescription == null) throwNullFieldException("prizeDescription", flags);
            writeString(prizeDescription, stream);
        }
        writeInt(quantity, stream);
        if ((flags & 16) != 0) {
            if (months == null) throwNullFieldException("months", flags);
            writeInt(months, stream);
        }
        if ((flags & 32) != 0) {
            if (stars == null) throwNullFieldException("stars", flags);
            writeLong(stars, stream);
        }
        writeInt(untilDate, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        onlyNewSubscribers = (flags & 1) != 0;
        winnersAreVisible = (flags & 4) != 0;
        channels = readTLLongVector(stream, context);
        countriesIso2 = (flags & 2) != 0 ? readTLStringVector(stream, context) : null;
        prizeDescription = (flags & 8) != 0 ? readTLString(stream) : null;
        quantity = readInt(stream);
        months = (flags & 16) != 0 ? readInt(stream) : null;
        stars = (flags & 32) != 0 ? readLong(stream) : null;
        untilDate = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += channels.computeSerializedSize();
        if ((flags & 2) != 0) {
            if (countriesIso2 == null) throwNullFieldException("countriesIso2", flags);
            size += countriesIso2.computeSerializedSize();
        }
        if ((flags & 8) != 0) {
            if (prizeDescription == null) throwNullFieldException("prizeDescription", flags);
            size += computeTLStringSerializedSize(prizeDescription);
        }
        size += SIZE_INT32;
        if ((flags & 16) != 0) {
            if (months == null) throwNullFieldException("months", flags);
            size += SIZE_INT32;
        }
        if ((flags & 32) != 0) {
            if (stars == null) throwNullFieldException("stars", flags);
            size += SIZE_INT64;
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

    public boolean getWinnersAreVisible() {
        return winnersAreVisible;
    }

    public void setWinnersAreVisible(boolean winnersAreVisible) {
        this.winnersAreVisible = winnersAreVisible;
    }

    public TLLongVector getChannels() {
        return channels;
    }

    public void setChannels(TLLongVector channels) {
        this.channels = channels;
    }

    public TLStringVector getCountriesIso2() {
        return countriesIso2;
    }

    public void setCountriesIso2(TLStringVector countriesIso2) {
        this.countriesIso2 = countriesIso2;
    }

    public String getPrizeDescription() {
        return prizeDescription;
    }

    public void setPrizeDescription(String prizeDescription) {
        this.prizeDescription = prizeDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public int getUntilDate() {
        return untilDate;
    }

    public void setUntilDate(int untilDate) {
        this.untilDate = untilDate;
    }
}
