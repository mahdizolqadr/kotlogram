package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPremiumGiftCodeOption extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected int users;

    protected int months;

    protected String storeProduct;

    protected Integer storeQuantity;

    protected String currency;

    protected long amount;

    private final String _constructor = "premiumGiftCodeOption#0";

    public TLPremiumGiftCodeOption() {
    }

    public TLPremiumGiftCodeOption(int users, int months, String storeProduct, Integer storeQuantity, String currency, long amount) {
        this.users = users;
        this.months = months;
        this.storeProduct = storeProduct;
        this.storeQuantity = storeQuantity;
        this.currency = currency;
        this.amount = amount;
    }

    private void computeFlags() {
        flags = 0;
        flags = storeProduct != null ? (flags | 1) : (flags & ~1);
        flags = storeQuantity != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(users, stream);
        writeInt(months, stream);
        if ((flags & 1) != 0) {
            if (storeProduct == null) throwNullFieldException("storeProduct", flags);
            writeString(storeProduct, stream);
        }
        if ((flags & 2) != 0) {
            if (storeQuantity == null) throwNullFieldException("storeQuantity", flags);
            writeInt(storeQuantity, stream);
        }
        writeString(currency, stream);
        writeLong(amount, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        users = readInt(stream);
        months = readInt(stream);
        storeProduct = (flags & 1) != 0 ? readTLString(stream) : null;
        storeQuantity = (flags & 2) != 0 ? readInt(stream) : null;
        currency = readTLString(stream);
        amount = readLong(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (storeProduct == null) throwNullFieldException("storeProduct", flags);
            size += computeTLStringSerializedSize(storeProduct);
        }
        if ((flags & 2) != 0) {
            if (storeQuantity == null) throwNullFieldException("storeQuantity", flags);
            size += SIZE_INT32;
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

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public String getStoreProduct() {
        return storeProduct;
    }

    public void setStoreProduct(String storeProduct) {
        this.storeProduct = storeProduct;
    }

    public Integer getStoreQuantity() {
        return storeQuantity;
    }

    public void setStoreQuantity(Integer storeQuantity) {
        this.storeQuantity = storeQuantity;
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
