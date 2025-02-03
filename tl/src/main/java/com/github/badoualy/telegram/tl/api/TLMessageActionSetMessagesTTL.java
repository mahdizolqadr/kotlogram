package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMessageActionSetMessagesTTL extends TLAbsMessageAction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected int period;

    protected Long autoSettingFrom;

    private final String _constructor = "messageActionSetMessagesTTL#0";

    public TLMessageActionSetMessagesTTL() {
    }

    public TLMessageActionSetMessagesTTL(int period, Long autoSettingFrom) {
        this.period = period;
        this.autoSettingFrom = autoSettingFrom;
    }

    private void computeFlags() {
        flags = 0;
        flags = autoSettingFrom != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(period, stream);
        if ((flags & 1) != 0) {
            if (autoSettingFrom == null) throwNullFieldException("autoSettingFrom", flags);
            writeLong(autoSettingFrom, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        period = readInt(stream);
        autoSettingFrom = (flags & 1) != 0 ? readLong(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (autoSettingFrom == null) throwNullFieldException("autoSettingFrom", flags);
            size += SIZE_INT64;
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

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public Long getAutoSettingFrom() {
        return autoSettingFrom;
    }

    public void setAutoSettingFrom(Long autoSettingFrom) {
        this.autoSettingFrom = autoSettingFrom;
    }
}
