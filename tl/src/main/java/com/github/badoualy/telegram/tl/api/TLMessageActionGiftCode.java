package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMessageActionGiftCode extends TLAbsMessageAction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean viaGiveaway;

    protected boolean unclaimed;

    protected TLAbsPeer boostPeer;

    protected int months;

    protected String slug;

    protected String currency;

    protected Long amount;

    protected String cryptoCurrency;

    protected Long cryptoAmount;

    protected TLTextWithEntities message;

    private final String _constructor = "messageActionGiftCode#0";

    public TLMessageActionGiftCode() {
    }

    public TLMessageActionGiftCode(boolean viaGiveaway, boolean unclaimed, TLAbsPeer boostPeer, int months, String slug, String currency, Long amount, String cryptoCurrency, Long cryptoAmount, TLTextWithEntities message) {
        this.viaGiveaway = viaGiveaway;
        this.unclaimed = unclaimed;
        this.boostPeer = boostPeer;
        this.months = months;
        this.slug = slug;
        this.currency = currency;
        this.amount = amount;
        this.cryptoCurrency = cryptoCurrency;
        this.cryptoAmount = cryptoAmount;
        this.message = message;
    }

    private void computeFlags() {
        flags = 0;
        flags = viaGiveaway ? (flags | 1) : (flags & ~1);
        flags = unclaimed ? (flags | 4) : (flags & ~4);
        flags = boostPeer != null ? (flags | 2) : (flags & ~2);
        flags = currency != null ? (flags | 4) : (flags & ~4);
        flags = amount != null ? (flags | 4) : (flags & ~4);
        flags = cryptoCurrency != null ? (flags | 8) : (flags & ~8);
        flags = cryptoAmount != null ? (flags | 8) : (flags & ~8);
        flags = message != null ? (flags | 16) : (flags & ~16);

        // Following parameters might be forced to true by another field that updated the flags
        unclaimed = (flags & 4) != 0;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 2) != 0) {
            if (boostPeer == null) throwNullFieldException("boostPeer", flags);
            writeTLObject(boostPeer, stream);
        }
        writeInt(months, stream);
        writeString(slug, stream);
        if ((flags & 4) != 0) {
            if (currency == null) throwNullFieldException("currency", flags);
            writeString(currency, stream);
        }
        if ((flags & 4) != 0) {
            if (amount == null) throwNullFieldException("amount", flags);
            writeLong(amount, stream);
        }
        if ((flags & 8) != 0) {
            if (cryptoCurrency == null) throwNullFieldException("cryptoCurrency", flags);
            writeString(cryptoCurrency, stream);
        }
        if ((flags & 8) != 0) {
            if (cryptoAmount == null) throwNullFieldException("cryptoAmount", flags);
            writeLong(cryptoAmount, stream);
        }
        if ((flags & 16) != 0) {
            if (message == null) throwNullFieldException("message", flags);
            writeTLObject(message, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        viaGiveaway = (flags & 1) != 0;
        unclaimed = (flags & 4) != 0;
        boostPeer = (flags & 2) != 0 ? readTLObject(stream, context, TLAbsPeer.class, -1) : null;
        months = readInt(stream);
        slug = readTLString(stream);
        currency = (flags & 4) != 0 ? readTLString(stream) : null;
        amount = (flags & 4) != 0 ? readLong(stream) : null;
        cryptoCurrency = (flags & 8) != 0 ? readTLString(stream) : null;
        cryptoAmount = (flags & 8) != 0 ? readLong(stream) : null;
        message = (flags & 16) != 0 ? readTLObject(stream, context, TLTextWithEntities.class, TLTextWithEntities.CONSTRUCTOR_ID) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 2) != 0) {
            if (boostPeer == null) throwNullFieldException("boostPeer", flags);
            size += boostPeer.computeSerializedSize();
        }
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(slug);
        if ((flags & 4) != 0) {
            if (currency == null) throwNullFieldException("currency", flags);
            size += computeTLStringSerializedSize(currency);
        }
        if ((flags & 4) != 0) {
            if (amount == null) throwNullFieldException("amount", flags);
            size += SIZE_INT64;
        }
        if ((flags & 8) != 0) {
            if (cryptoCurrency == null) throwNullFieldException("cryptoCurrency", flags);
            size += computeTLStringSerializedSize(cryptoCurrency);
        }
        if ((flags & 8) != 0) {
            if (cryptoAmount == null) throwNullFieldException("cryptoAmount", flags);
            size += SIZE_INT64;
        }
        if ((flags & 16) != 0) {
            if (message == null) throwNullFieldException("message", flags);
            size += message.computeSerializedSize();
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

    public boolean getViaGiveaway() {
        return viaGiveaway;
    }

    public void setViaGiveaway(boolean viaGiveaway) {
        this.viaGiveaway = viaGiveaway;
    }

    public boolean getUnclaimed() {
        return unclaimed;
    }

    public void setUnclaimed(boolean unclaimed) {
        this.unclaimed = unclaimed;
    }

    public TLAbsPeer getBoostPeer() {
        return boostPeer;
    }

    public void setBoostPeer(TLAbsPeer boostPeer) {
        this.boostPeer = boostPeer;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCryptoCurrency() {
        return cryptoCurrency;
    }

    public void setCryptoCurrency(String cryptoCurrency) {
        this.cryptoCurrency = cryptoCurrency;
    }

    public Long getCryptoAmount() {
        return cryptoAmount;
    }

    public void setCryptoAmount(Long cryptoAmount) {
        this.cryptoAmount = cryptoAmount;
    }

    public TLTextWithEntities getMessage() {
        return message;
    }

    public void setMessage(TLTextWithEntities message) {
        this.message = message;
    }
}
