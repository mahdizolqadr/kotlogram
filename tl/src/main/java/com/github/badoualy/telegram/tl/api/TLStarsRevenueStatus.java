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
public class TLStarsRevenueStatus extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean withdrawalEnabled;

    protected TLStarsAmount currentBalance;

    protected TLStarsAmount availableBalance;

    protected TLStarsAmount overallRevenue;

    protected Integer nextWithdrawalAt;

    private final String _constructor = "starsRevenueStatus#0";

    public TLStarsRevenueStatus() {
    }

    public TLStarsRevenueStatus(boolean withdrawalEnabled, TLStarsAmount currentBalance, TLStarsAmount availableBalance, TLStarsAmount overallRevenue, Integer nextWithdrawalAt) {
        this.withdrawalEnabled = withdrawalEnabled;
        this.currentBalance = currentBalance;
        this.availableBalance = availableBalance;
        this.overallRevenue = overallRevenue;
        this.nextWithdrawalAt = nextWithdrawalAt;
    }

    private void computeFlags() {
        flags = 0;
        flags = withdrawalEnabled ? (flags | 1) : (flags & ~1);
        flags = nextWithdrawalAt != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(currentBalance, stream);
        writeTLObject(availableBalance, stream);
        writeTLObject(overallRevenue, stream);
        if ((flags & 2) != 0) {
            if (nextWithdrawalAt == null) throwNullFieldException("nextWithdrawalAt", flags);
            writeInt(nextWithdrawalAt, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        withdrawalEnabled = (flags & 1) != 0;
        currentBalance = readTLObject(stream, context, TLStarsAmount.class, TLStarsAmount.CONSTRUCTOR_ID);
        availableBalance = readTLObject(stream, context, TLStarsAmount.class, TLStarsAmount.CONSTRUCTOR_ID);
        overallRevenue = readTLObject(stream, context, TLStarsAmount.class, TLStarsAmount.CONSTRUCTOR_ID);
        nextWithdrawalAt = (flags & 2) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += currentBalance.computeSerializedSize();
        size += availableBalance.computeSerializedSize();
        size += overallRevenue.computeSerializedSize();
        if ((flags & 2) != 0) {
            if (nextWithdrawalAt == null) throwNullFieldException("nextWithdrawalAt", flags);
            size += SIZE_INT32;
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

    public boolean getWithdrawalEnabled() {
        return withdrawalEnabled;
    }

    public void setWithdrawalEnabled(boolean withdrawalEnabled) {
        this.withdrawalEnabled = withdrawalEnabled;
    }

    public TLStarsAmount getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(TLStarsAmount currentBalance) {
        this.currentBalance = currentBalance;
    }

    public TLStarsAmount getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(TLStarsAmount availableBalance) {
        this.availableBalance = availableBalance;
    }

    public TLStarsAmount getOverallRevenue() {
        return overallRevenue;
    }

    public void setOverallRevenue(TLStarsAmount overallRevenue) {
        this.overallRevenue = overallRevenue;
    }

    public Integer getNextWithdrawalAt() {
        return nextWithdrawalAt;
    }

    public void setNextWithdrawalAt(Integer nextWithdrawalAt) {
        this.nextWithdrawalAt = nextWithdrawalAt;
    }
}
