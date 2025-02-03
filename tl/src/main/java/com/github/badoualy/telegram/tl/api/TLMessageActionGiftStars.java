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
public class TLMessageActionGiftStars extends TLAbsMessageAction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected String currency;

    protected long amount;

    protected long stars;

    protected String cryptoCurrency;

    protected Long cryptoAmount;

    protected String transactionId;

    private final String _constructor = "messageActionGiftStars#0";

    public TLMessageActionGiftStars() {
    }

    public TLMessageActionGiftStars(String currency, long amount, long stars, String cryptoCurrency, Long cryptoAmount, String transactionId) {
        this.currency = currency;
        this.amount = amount;
        this.stars = stars;
        this.cryptoCurrency = cryptoCurrency;
        this.cryptoAmount = cryptoAmount;
        this.transactionId = transactionId;
    }

    private void computeFlags() {
        flags = 0;
        flags = cryptoCurrency != null ? (flags | 1) : (flags & ~1);
        flags = cryptoAmount != null ? (flags | 1) : (flags & ~1);
        flags = transactionId != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(currency, stream);
        writeLong(amount, stream);
        writeLong(stars, stream);
        if ((flags & 1) != 0) {
            if (cryptoCurrency == null) throwNullFieldException("cryptoCurrency", flags);
            writeString(cryptoCurrency, stream);
        }
        if ((flags & 1) != 0) {
            if (cryptoAmount == null) throwNullFieldException("cryptoAmount", flags);
            writeLong(cryptoAmount, stream);
        }
        if ((flags & 2) != 0) {
            if (transactionId == null) throwNullFieldException("transactionId", flags);
            writeString(transactionId, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        currency = readTLString(stream);
        amount = readLong(stream);
        stars = readLong(stream);
        cryptoCurrency = (flags & 1) != 0 ? readTLString(stream) : null;
        cryptoAmount = (flags & 1) != 0 ? readLong(stream) : null;
        transactionId = (flags & 2) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(currency);
        size += SIZE_INT64;
        size += SIZE_INT64;
        if ((flags & 1) != 0) {
            if (cryptoCurrency == null) throwNullFieldException("cryptoCurrency", flags);
            size += computeTLStringSerializedSize(cryptoCurrency);
        }
        if ((flags & 1) != 0) {
            if (cryptoAmount == null) throwNullFieldException("cryptoAmount", flags);
            size += SIZE_INT64;
        }
        if ((flags & 2) != 0) {
            if (transactionId == null) throwNullFieldException("transactionId", flags);
            size += computeTLStringSerializedSize(transactionId);
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

    public long getStars() {
        return stars;
    }

    public void setStars(long stars) {
        this.stars = stars;
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

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
