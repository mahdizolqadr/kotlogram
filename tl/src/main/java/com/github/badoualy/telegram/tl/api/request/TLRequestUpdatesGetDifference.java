package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.updates.TLAbsDifference;
import com.github.badoualy.telegram.tl.core.TLMethod;
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
public class TLRequestUpdatesGetDifference extends TLMethod<TLAbsDifference> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected int pts;

    protected Integer ptsLimit;

    protected Integer ptsTotalLimit;

    protected int date;

    protected int qts;

    protected Integer qtsLimit;

    private final String _constructor = "updates.getDifference#0";

    public TLRequestUpdatesGetDifference() {
    }

    public TLRequestUpdatesGetDifference(int pts, Integer ptsLimit, Integer ptsTotalLimit, int date, int qts, Integer qtsLimit) {
        this.pts = pts;
        this.ptsLimit = ptsLimit;
        this.ptsTotalLimit = ptsTotalLimit;
        this.date = date;
        this.qts = qts;
        this.qtsLimit = qtsLimit;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsDifference deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsDifference)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsDifference) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = ptsLimit != null ? (flags | 2) : (flags & ~2);
        flags = ptsTotalLimit != null ? (flags | 1) : (flags & ~1);
        flags = qtsLimit != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(pts, stream);
        if ((flags & 2) != 0) {
            if (ptsLimit == null) throwNullFieldException("ptsLimit", flags);
            writeInt(ptsLimit, stream);
        }
        if ((flags & 1) != 0) {
            if (ptsTotalLimit == null) throwNullFieldException("ptsTotalLimit", flags);
            writeInt(ptsTotalLimit, stream);
        }
        writeInt(date, stream);
        writeInt(qts, stream);
        if ((flags & 4) != 0) {
            if (qtsLimit == null) throwNullFieldException("qtsLimit", flags);
            writeInt(qtsLimit, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        pts = readInt(stream);
        ptsLimit = (flags & 2) != 0 ? readInt(stream) : null;
        ptsTotalLimit = (flags & 1) != 0 ? readInt(stream) : null;
        date = readInt(stream);
        qts = readInt(stream);
        qtsLimit = (flags & 4) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 2) != 0) {
            if (ptsLimit == null) throwNullFieldException("ptsLimit", flags);
            size += SIZE_INT32;
        }
        if ((flags & 1) != 0) {
            if (ptsTotalLimit == null) throwNullFieldException("ptsTotalLimit", flags);
            size += SIZE_INT32;
        }
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 4) != 0) {
            if (qtsLimit == null) throwNullFieldException("qtsLimit", flags);
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

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public Integer getPtsLimit() {
        return ptsLimit;
    }

    public void setPtsLimit(Integer ptsLimit) {
        this.ptsLimit = ptsLimit;
    }

    public Integer getPtsTotalLimit() {
        return ptsTotalLimit;
    }

    public void setPtsTotalLimit(Integer ptsTotalLimit) {
        this.ptsTotalLimit = ptsTotalLimit;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getQts() {
        return qts;
    }

    public void setQts(int qts) {
        this.qts = qts;
    }

    public Integer getQtsLimit() {
        return qtsLimit;
    }

    public void setQtsLimit(Integer qtsLimit) {
        this.qtsLimit = qtsLimit;
    }
}
