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
public class TLStarsTopupOption extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean extended;

    protected long stars;

    protected String storeProduct;

    protected String currency;

    protected long amount;

    private final String _constructor = "starsTopupOption#0";

    public TLStarsTopupOption() {
    }

    public TLStarsTopupOption(boolean extended, long stars, String storeProduct, String currency, long amount) {
        this.extended = extended;
        this.stars = stars;
        this.storeProduct = storeProduct;
        this.currency = currency;
        this.amount = amount;
    }

    private void computeFlags() {
        flags = 0;
        flags = extended ? (flags | 2) : (flags & ~2);
        flags = storeProduct != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(stars, stream);
        if ((flags & 1) != 0) {
            if (storeProduct == null) throwNullFieldException("storeProduct", flags);
            writeString(storeProduct, stream);
        }
        writeString(currency, stream);
        writeLong(amount, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        extended = (flags & 2) != 0;
        stars = readLong(stream);
        storeProduct = (flags & 1) != 0 ? readTLString(stream) : null;
        currency = readTLString(stream);
        amount = readLong(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        if ((flags & 1) != 0) {
            if (storeProduct == null) throwNullFieldException("storeProduct", flags);
            size += computeTLStringSerializedSize(storeProduct);
        }
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

    public boolean getExtended() {
        return extended;
    }

    public void setExtended(boolean extended) {
        this.extended = extended;
    }

    public long getStars() {
        return stars;
    }

    public void setStars(long stars) {
        this.stars = stars;
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
}
