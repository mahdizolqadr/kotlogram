package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLPremiumGiftOption extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected int months;

    protected String currency;

    protected long amount;

    protected String botUrl;

    protected String storeProduct;

    private final String _constructor = "premiumGiftOption#0";

    public TLPremiumGiftOption() {
    }

    public TLPremiumGiftOption(int months, String currency, long amount, String botUrl, String storeProduct) {
        this.months = months;
        this.currency = currency;
        this.amount = amount;
        this.botUrl = botUrl;
        this.storeProduct = storeProduct;
    }

    private void computeFlags() {
        flags = 0;
        flags = storeProduct != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(months, stream);
        writeString(currency, stream);
        writeLong(amount, stream);
        writeString(botUrl, stream);
        if ((flags & 1) != 0) {
            if (storeProduct == null) throwNullFieldException("storeProduct", flags);
            writeString(storeProduct, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        months = readInt(stream);
        currency = readTLString(stream);
        amount = readLong(stream);
        botUrl = readTLString(stream);
        storeProduct = (flags & 1) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(currency);
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(botUrl);
        if ((flags & 1) != 0) {
            if (storeProduct == null) throwNullFieldException("storeProduct", flags);
            size += computeTLStringSerializedSize(storeProduct);
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

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
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

    public String getBotUrl() {
        return botUrl;
    }

    public void setBotUrl(String botUrl) {
        this.botUrl = botUrl;
    }

    public String getStoreProduct() {
        return storeProduct;
    }

    public void setStoreProduct(String storeProduct) {
        this.storeProduct = storeProduct;
    }
}
