package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLInputStorePaymentStarsGift extends TLAbsInputStorePaymentPurpose {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsInputUser userId;

    protected long stars;

    protected String currency;

    protected long amount;

    private final String _constructor = "inputStorePaymentStarsGift#0";

    public TLInputStorePaymentStarsGift() {
    }

    public TLInputStorePaymentStarsGift(TLAbsInputUser userId, long stars, String currency, long amount) {
        this.userId = userId;
        this.stars = stars;
        this.currency = currency;
        this.amount = amount;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(userId, stream);
        writeLong(stars, stream);
        writeString(currency, stream);
        writeLong(amount, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        userId = readTLObject(stream, context, TLAbsInputUser.class, -1);
        stars = readLong(stream);
        currency = readTLString(stream);
        amount = readLong(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += userId.computeSerializedSize();
        size += SIZE_INT64;
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

    public TLAbsInputUser getUserId() {
        return userId;
    }

    public void setUserId(TLAbsInputUser userId) {
        this.userId = userId;
    }

    public long getStars() {
        return stars;
    }

    public void setStars(long stars) {
        this.stars = stars;
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
