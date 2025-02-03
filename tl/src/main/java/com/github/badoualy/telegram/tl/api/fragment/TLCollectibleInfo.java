package com.github.badoualy.telegram.tl.api.fragment;

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
public class TLCollectibleInfo extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int purchaseDate;

    protected String currency;

    protected long amount;

    protected String cryptoCurrency;

    protected long cryptoAmount;

    protected String url;

    private final String _constructor = "fragment.collectibleInfo#0";

    public TLCollectibleInfo() {
    }

    public TLCollectibleInfo(int purchaseDate, String currency, long amount, String cryptoCurrency, long cryptoAmount, String url) {
        this.purchaseDate = purchaseDate;
        this.currency = currency;
        this.amount = amount;
        this.cryptoCurrency = cryptoCurrency;
        this.cryptoAmount = cryptoAmount;
        this.url = url;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(purchaseDate, stream);
        writeString(currency, stream);
        writeLong(amount, stream);
        writeString(cryptoCurrency, stream);
        writeLong(cryptoAmount, stream);
        writeString(url, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        purchaseDate = readInt(stream);
        currency = readTLString(stream);
        amount = readLong(stream);
        cryptoCurrency = readTLString(stream);
        cryptoAmount = readLong(stream);
        url = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(currency);
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(cryptoCurrency);
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(url);
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

    public int getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(int purchaseDate) {
        this.purchaseDate = purchaseDate;
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

    public String getCryptoCurrency() {
        return cryptoCurrency;
    }

    public void setCryptoCurrency(String cryptoCurrency) {
        this.cryptoCurrency = cryptoCurrency;
    }

    public long getCryptoAmount() {
        return cryptoAmount;
    }

    public void setCryptoAmount(long cryptoAmount) {
        this.cryptoAmount = cryptoAmount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
