package com.github.badoualy.telegram.tl.api.stats;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsStatsGraph;
import com.github.badoualy.telegram.tl.api.TLBroadcastRevenueBalances;
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
public class TLBroadcastRevenueStats extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsStatsGraph topHoursGraph;

    protected TLAbsStatsGraph revenueGraph;

    protected TLBroadcastRevenueBalances balances;

    protected double usdRate;

    private final String _constructor = "stats.broadcastRevenueStats#0";

    public TLBroadcastRevenueStats() {
    }

    public TLBroadcastRevenueStats(TLAbsStatsGraph topHoursGraph, TLAbsStatsGraph revenueGraph, TLBroadcastRevenueBalances balances, double usdRate) {
        this.topHoursGraph = topHoursGraph;
        this.revenueGraph = revenueGraph;
        this.balances = balances;
        this.usdRate = usdRate;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(topHoursGraph, stream);
        writeTLObject(revenueGraph, stream);
        writeTLObject(balances, stream);
        writeDouble(usdRate, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        topHoursGraph = readTLObject(stream, context, TLAbsStatsGraph.class, -1);
        revenueGraph = readTLObject(stream, context, TLAbsStatsGraph.class, -1);
        balances = readTLObject(stream, context, TLBroadcastRevenueBalances.class, TLBroadcastRevenueBalances.CONSTRUCTOR_ID);
        usdRate = readDouble(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += topHoursGraph.computeSerializedSize();
        size += revenueGraph.computeSerializedSize();
        size += balances.computeSerializedSize();
        size += SIZE_DOUBLE;
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

    public TLAbsStatsGraph getTopHoursGraph() {
        return topHoursGraph;
    }

    public void setTopHoursGraph(TLAbsStatsGraph topHoursGraph) {
        this.topHoursGraph = topHoursGraph;
    }

    public TLAbsStatsGraph getRevenueGraph() {
        return revenueGraph;
    }

    public void setRevenueGraph(TLAbsStatsGraph revenueGraph) {
        this.revenueGraph = revenueGraph;
    }

    public TLBroadcastRevenueBalances getBalances() {
        return balances;
    }

    public void setBalances(TLBroadcastRevenueBalances balances) {
        this.balances = balances;
    }

    public double getUsdRate() {
        return usdRate;
    }

    public void setUsdRate(double usdRate) {
        this.usdRate = usdRate;
    }
}
