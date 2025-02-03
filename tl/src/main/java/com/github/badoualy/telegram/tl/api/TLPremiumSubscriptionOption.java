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
public class TLPremiumSubscriptionOption extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean current;

    protected boolean canPurchaseUpgrade;

    protected String transaction;

    protected int months;

    protected String currency;

    protected long amount;

    protected String botUrl;

    protected String storeProduct;

    private final String _constructor = "premiumSubscriptionOption#0";

    public TLPremiumSubscriptionOption() {
    }

    public TLPremiumSubscriptionOption(boolean current, boolean canPurchaseUpgrade, String transaction, int months, String currency, long amount, String botUrl, String storeProduct) {
        this.current = current;
        this.canPurchaseUpgrade = canPurchaseUpgrade;
        this.transaction = transaction;
        this.months = months;
        this.currency = currency;
        this.amount = amount;
        this.botUrl = botUrl;
        this.storeProduct = storeProduct;
    }

    private void computeFlags() {
        flags = 0;
        flags = current ? (flags | 2) : (flags & ~2);
        flags = canPurchaseUpgrade ? (flags | 4) : (flags & ~4);
        flags = transaction != null ? (flags | 8) : (flags & ~8);
        flags = storeProduct != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 8) != 0) {
            if (transaction == null) throwNullFieldException("transaction", flags);
            writeString(transaction, stream);
        }
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
        current = (flags & 2) != 0;
        canPurchaseUpgrade = (flags & 4) != 0;
        transaction = (flags & 8) != 0 ? readTLString(stream) : null;
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
        if ((flags & 8) != 0) {
            if (transaction == null) throwNullFieldException("transaction", flags);
            size += computeTLStringSerializedSize(transaction);
        }
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

    public boolean getCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public boolean getCanPurchaseUpgrade() {
        return canPurchaseUpgrade;
    }

    public void setCanPurchaseUpgrade(boolean canPurchaseUpgrade) {
        this.canPurchaseUpgrade = canPurchaseUpgrade;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
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
