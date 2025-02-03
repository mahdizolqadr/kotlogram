package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLBroadcastRevenueTransactionWithdrawal extends TLAbsBroadcastRevenueTransaction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean pending;

    protected boolean failed;

    protected int date;

    protected String provider;

    protected Integer transactionDate;

    protected String transactionUrl;

    private final String _constructor = "broadcastRevenueTransactionWithdrawal#0";

    public TLBroadcastRevenueTransactionWithdrawal() {
    }

    public TLBroadcastRevenueTransactionWithdrawal(boolean pending, boolean failed, long amount, int date, String provider, Integer transactionDate, String transactionUrl) {
        this.pending = pending;
        this.failed = failed;
        this.amount = amount;
        this.date = date;
        this.provider = provider;
        this.transactionDate = transactionDate;
        this.transactionUrl = transactionUrl;
    }

    private void computeFlags() {
        flags = 0;
        flags = pending ? (flags | 1) : (flags & ~1);
        flags = failed ? (flags | 4) : (flags & ~4);
        flags = transactionDate != null ? (flags | 2) : (flags & ~2);
        flags = transactionUrl != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(amount, stream);
        writeInt(date, stream);
        writeString(provider, stream);
        if ((flags & 2) != 0) {
            if (transactionDate == null) throwNullFieldException("transactionDate", flags);
            writeInt(transactionDate, stream);
        }
        if ((flags & 2) != 0) {
            if (transactionUrl == null) throwNullFieldException("transactionUrl", flags);
            writeString(transactionUrl, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        pending = (flags & 1) != 0;
        failed = (flags & 4) != 0;
        amount = readLong(stream);
        date = readInt(stream);
        provider = readTLString(stream);
        transactionDate = (flags & 2) != 0 ? readInt(stream) : null;
        transactionUrl = (flags & 2) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(provider);
        if ((flags & 2) != 0) {
            if (transactionDate == null) throwNullFieldException("transactionDate", flags);
            size += SIZE_INT32;
        }
        if ((flags & 2) != 0) {
            if (transactionUrl == null) throwNullFieldException("transactionUrl", flags);
            size += computeTLStringSerializedSize(transactionUrl);
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

    public boolean getPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    public boolean getFailed() {
        return failed;
    }

    public void setFailed(boolean failed) {
        this.failed = failed;
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

    public Integer getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Integer transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionUrl() {
        return transactionUrl;
    }

    public void setTransactionUrl(String transactionUrl) {
        this.transactionUrl = transactionUrl;
    }
}
