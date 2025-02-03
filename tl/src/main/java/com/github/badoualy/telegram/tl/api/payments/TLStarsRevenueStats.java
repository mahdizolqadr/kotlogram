package com.github.badoualy.telegram.tl.api.payments;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsStatsGraph;
import com.github.badoualy.telegram.tl.api.TLStarsRevenueStatus;
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
public class TLStarsRevenueStats extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsStatsGraph revenueGraph;

    protected TLStarsRevenueStatus status;

    protected double usdRate;

    private final String _constructor = "payments.starsRevenueStats#0";

    public TLStarsRevenueStats() {
    }

    public TLStarsRevenueStats(TLAbsStatsGraph revenueGraph, TLStarsRevenueStatus status, double usdRate) {
        this.revenueGraph = revenueGraph;
        this.status = status;
        this.usdRate = usdRate;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(revenueGraph, stream);
        writeTLObject(status, stream);
        writeDouble(usdRate, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        revenueGraph = readTLObject(stream, context, TLAbsStatsGraph.class, -1);
        status = readTLObject(stream, context, TLStarsRevenueStatus.class, TLStarsRevenueStatus.CONSTRUCTOR_ID);
        usdRate = readDouble(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += revenueGraph.computeSerializedSize();
        size += status.computeSerializedSize();
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

    public TLAbsStatsGraph getRevenueGraph() {
        return revenueGraph;
    }

    public void setRevenueGraph(TLAbsStatsGraph revenueGraph) {
        this.revenueGraph = revenueGraph;
    }

    public TLStarsRevenueStatus getStatus() {
        return status;
    }

    public void setStatus(TLStarsRevenueStatus status) {
        this.status = status;
    }

    public double getUsdRate() {
        return usdRate;
    }

    public void setUsdRate(double usdRate) {
        this.usdRate = usdRate;
    }
}
