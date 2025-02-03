package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLStringVector;
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
public class TLInputStorePaymentPremiumGiveaway extends TLAbsInputStorePaymentPurpose {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean onlyNewSubscribers;

    protected boolean winnersAreVisible;

    protected TLAbsInputPeer boostPeer;

    protected TLVector<TLAbsInputPeer> additionalPeers;

    protected TLStringVector countriesIso2;

    protected String prizeDescription;

    protected long randomId;

    protected int untilDate;

    protected String currency;

    protected long amount;

    private final String _constructor = "inputStorePaymentPremiumGiveaway#0";

    public TLInputStorePaymentPremiumGiveaway() {
    }

    public TLInputStorePaymentPremiumGiveaway(boolean onlyNewSubscribers, boolean winnersAreVisible, TLAbsInputPeer boostPeer, TLVector<TLAbsInputPeer> additionalPeers, TLStringVector countriesIso2, String prizeDescription, long randomId, int untilDate, String currency, long amount) {
        this.onlyNewSubscribers = onlyNewSubscribers;
        this.winnersAreVisible = winnersAreVisible;
        this.boostPeer = boostPeer;
        this.additionalPeers = additionalPeers;
        this.countriesIso2 = countriesIso2;
        this.prizeDescription = prizeDescription;
        this.randomId = randomId;
        this.untilDate = untilDate;
        this.currency = currency;
        this.amount = amount;
    }

    private void computeFlags() {
        flags = 0;
        flags = onlyNewSubscribers ? (flags | 1) : (flags & ~1);
        flags = winnersAreVisible ? (flags | 8) : (flags & ~8);
        flags = additionalPeers != null ? (flags | 2) : (flags & ~2);
        flags = countriesIso2 != null ? (flags | 4) : (flags & ~4);
        flags = prizeDescription != null ? (flags | 16) : (flags & ~16);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(boostPeer, stream);
        if ((flags & 2) != 0) {
            if (additionalPeers == null) throwNullFieldException("additionalPeers", flags);
            writeTLVector(additionalPeers, stream);
        }
        if ((flags & 4) != 0) {
            if (countriesIso2 == null) throwNullFieldException("countriesIso2", flags);
            writeTLVector(countriesIso2, stream);
        }
        if ((flags & 16) != 0) {
            if (prizeDescription == null) throwNullFieldException("prizeDescription", flags);
            writeString(prizeDescription, stream);
        }
        writeLong(randomId, stream);
        writeInt(untilDate, stream);
        writeString(currency, stream);
        writeLong(amount, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        onlyNewSubscribers = (flags & 1) != 0;
        winnersAreVisible = (flags & 8) != 0;
        boostPeer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        additionalPeers = (flags & 2) != 0 ? readTLVector(stream, context) : null;
        countriesIso2 = (flags & 4) != 0 ? readTLStringVector(stream, context) : null;
        prizeDescription = (flags & 16) != 0 ? readTLString(stream) : null;
        randomId = readLong(stream);
        untilDate = readInt(stream);
        currency = readTLString(stream);
        amount = readLong(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += boostPeer.computeSerializedSize();
        if ((flags & 2) != 0) {
            if (additionalPeers == null) throwNullFieldException("additionalPeers", flags);
            size += additionalPeers.computeSerializedSize();
        }
        if ((flags & 4) != 0) {
            if (countriesIso2 == null) throwNullFieldException("countriesIso2", flags);
            size += countriesIso2.computeSerializedSize();
        }
        if ((flags & 16) != 0) {
            if (prizeDescription == null) throwNullFieldException("prizeDescription", flags);
            size += computeTLStringSerializedSize(prizeDescription);
        }
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(currency);
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

    public TLAbsInputPeer getBoostPeer() {
        return boostPeer;
    }

    public void setBoostPeer(TLAbsInputPeer boostPeer) {
        this.boostPeer = boostPeer;
    }

    public TLVector<TLAbsInputPeer> getAdditionalPeers() {
        return additionalPeers;
    }

    public void setAdditionalPeers(TLVector<TLAbsInputPeer> additionalPeers) {
        this.additionalPeers = additionalPeers;
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

    public long getRandomId() {
        return randomId;
    }

    public void setRandomId(long randomId) {
        this.randomId = randomId;
    }

    public int getUntilDate() {
        return untilDate;
    }

    public void setUntilDate(int untilDate) {
        this.untilDate = untilDate;
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
}
