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
public class TLBroadcastRevenueBalances extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean withdrawalEnabled;

    protected long currentBalance;

    protected long availableBalance;

    protected long overallRevenue;

    private final String _constructor = "broadcastRevenueBalances#0";

    public TLBroadcastRevenueBalances() {
    }

    public TLBroadcastRevenueBalances(boolean withdrawalEnabled, long currentBalance, long availableBalance, long overallRevenue) {
        this.withdrawalEnabled = withdrawalEnabled;
        this.currentBalance = currentBalance;
        this.availableBalance = availableBalance;
        this.overallRevenue = overallRevenue;
    }

    private void computeFlags() {
        flags = 0;
        flags = withdrawalEnabled ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(currentBalance, stream);
        writeLong(availableBalance, stream);
        writeLong(overallRevenue, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        withdrawalEnabled = (flags & 1) != 0;
        currentBalance = readLong(stream);
        availableBalance = readLong(stream);
        overallRevenue = readLong(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT64;
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

    public boolean getWithdrawalEnabled() {
        return withdrawalEnabled;
    }

    public void setWithdrawalEnabled(boolean withdrawalEnabled) {
        this.withdrawalEnabled = withdrawalEnabled;
    }

    public long getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(long currentBalance) {
        this.currentBalance = currentBalance;
    }

    public long getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(long availableBalance) {
        this.availableBalance = availableBalance;
    }

    public long getOverallRevenue() {
        return overallRevenue;
    }

    public void setOverallRevenue(long overallRevenue) {
        this.overallRevenue = overallRevenue;
    }
}
