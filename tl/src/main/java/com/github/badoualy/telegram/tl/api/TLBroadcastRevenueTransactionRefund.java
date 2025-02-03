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
public class TLBroadcastRevenueTransactionRefund extends TLAbsBroadcastRevenueTransaction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int date;

    protected String provider;

    private final String _constructor = "broadcastRevenueTransactionRefund#0";

    public TLBroadcastRevenueTransactionRefund() {
    }

    public TLBroadcastRevenueTransactionRefund(long amount, int date, String provider) {
        this.amount = amount;
        this.date = date;
        this.provider = provider;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(amount, stream);
        writeInt(date, stream);
        writeString(provider, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        amount = readLong(stream);
        date = readInt(stream);
        provider = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(provider);
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

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
