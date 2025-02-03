package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLBroadcastRevenueTransactionProceeds}: broadcastRevenueTransactionProceeds#0</li>
 * <li>{@link TLBroadcastRevenueTransactionRefund}: broadcastRevenueTransactionRefund#0</li>
 * <li>{@link TLBroadcastRevenueTransactionWithdrawal}: broadcastRevenueTransactionWithdrawal#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsBroadcastRevenueTransaction extends TLObject {
    protected long amount;

    public TLAbsBroadcastRevenueTransaction() {
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
