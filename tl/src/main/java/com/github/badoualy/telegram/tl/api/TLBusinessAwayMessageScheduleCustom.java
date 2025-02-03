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
public class TLBusinessAwayMessageScheduleCustom extends TLAbsBusinessAwayMessageSchedule {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int startDate;

    protected int endDate;

    private final String _constructor = "businessAwayMessageScheduleCustom#0";

    public TLBusinessAwayMessageScheduleCustom() {
    }

    public TLBusinessAwayMessageScheduleCustom(int startDate, int endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(startDate, stream);
        writeInt(endDate, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        startDate = readInt(stream);
        endDate = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
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

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }
}
