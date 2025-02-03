package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
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
public class TLStarsGiveawayOption extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean extended;

    protected boolean ddefault;

    protected long stars;

    protected int yearlyBoosts;

    protected String storeProduct;

    protected String currency;

    protected long amount;

    protected TLVector<TLStarsGiveawayWinnersOption> winners;

    private final String _constructor = "starsGiveawayOption#0";

    public TLStarsGiveawayOption() {
    }

    public TLStarsGiveawayOption(boolean extended, boolean ddefault, long stars, int yearlyBoosts, String storeProduct, String currency, long amount, TLVector<TLStarsGiveawayWinnersOption> winners) {
        this.extended = extended;
        this.ddefault = ddefault;
        this.stars = stars;
        this.yearlyBoosts = yearlyBoosts;
        this.storeProduct = storeProduct;
        this.currency = currency;
        this.amount = amount;
        this.winners = winners;
    }

    private void computeFlags() {
        flags = 0;
        flags = extended ? (flags | 1) : (flags & ~1);
        flags = ddefault ? (flags | 2) : (flags & ~2);
        flags = storeProduct != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(stars, stream);
        writeInt(yearlyBoosts, stream);
        if ((flags & 4) != 0) {
            if (storeProduct == null) throwNullFieldException("storeProduct", flags);
            writeString(storeProduct, stream);
        }
        writeString(currency, stream);
        writeLong(amount, stream);
        writeTLVector(winners, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        extended = (flags & 1) != 0;
        ddefault = (flags & 2) != 0;
        stars = readLong(stream);
        yearlyBoosts = readInt(stream);
        storeProduct = (flags & 4) != 0 ? readTLString(stream) : null;
        currency = readTLString(stream);
        amount = readLong(stream);
        winners = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT32;
        if ((flags & 4) != 0) {
            if (storeProduct == null) throwNullFieldException("storeProduct", flags);
            size += computeTLStringSerializedSize(storeProduct);
        }
        size += computeTLStringSerializedSize(currency);
        size += SIZE_INT64;
        size += winners.computeSerializedSize();
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

    public boolean getExtended() {
        return extended;
    }

    public void setExtended(boolean extended) {
        this.extended = extended;
    }

    public boolean getDdefault() {
        return ddefault;
    }

    public void setDdefault(boolean ddefault) {
        this.ddefault = ddefault;
    }

    public long getStars() {
        return stars;
    }

    public void setStars(long stars) {
        this.stars = stars;
    }

    public int getYearlyBoosts() {
        return yearlyBoosts;
    }

    public void setYearlyBoosts(int yearlyBoosts) {
        this.yearlyBoosts = yearlyBoosts;
    }

    public String getStoreProduct() {
        return storeProduct;
    }

    public void setStoreProduct(String storeProduct) {
        this.storeProduct = storeProduct;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public TLVector<TLStarsGiveawayWinnersOption> getWinners() {
        return winners;
    }

    public void setWinners(TLVector<TLStarsGiveawayWinnersOption> winners) {
        this.winners = winners;
    }
}
