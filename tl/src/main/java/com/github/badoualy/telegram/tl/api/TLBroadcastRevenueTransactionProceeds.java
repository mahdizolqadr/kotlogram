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
public class TLBroadcastRevenueTransactionProceeds extends TLAbsBroadcastRevenueTransaction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int fromDate;

    protected int toDate;

    private final String _constructor = "broadcastRevenueTransactionProceeds#0";

    public TLBroadcastRevenueTransactionProceeds() {
    }

    public TLBroadcastRevenueTransactionProceeds(long amount, int fromDate, int toDate) {
        this.amount = amount;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(amount, stream);
        writeInt(fromDate, stream);
        writeInt(toDate, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        amount = readLong(stream);
        fromDate = readInt(stream);
        toDate = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += SIZE_INT32;
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

    public int getFromDate() {
        return fromDate;
    }

    public void setFromDate(int fromDate) {
        this.fromDate = fromDate;
    }

    public int getToDate() {
        return toDate;
    }

    public void setToDate(int toDate) {
        this.toDate = toDate;
    }
}
