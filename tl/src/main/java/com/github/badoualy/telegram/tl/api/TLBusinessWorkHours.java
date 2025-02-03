package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
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
public class TLBusinessWorkHours extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean openNow;

    protected String timezoneId;

    protected TLVector<TLBusinessWeeklyOpen> weeklyOpen;

    private final String _constructor = "businessWorkHours#0";

    public TLBusinessWorkHours() {
    }

    public TLBusinessWorkHours(boolean openNow, String timezoneId, TLVector<TLBusinessWeeklyOpen> weeklyOpen) {
        this.openNow = openNow;
        this.timezoneId = timezoneId;
        this.weeklyOpen = weeklyOpen;
    }

    private void computeFlags() {
        flags = 0;
        flags = openNow ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(timezoneId, stream);
        writeTLVector(weeklyOpen, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        openNow = (flags & 1) != 0;
        timezoneId = readTLString(stream);
        weeklyOpen = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(timezoneId);
        size += weeklyOpen.computeSerializedSize();
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

    public boolean getOpenNow() {
        return openNow;
    }

    public void setOpenNow(boolean openNow) {
        this.openNow = openNow;
    }

    public String getTimezoneId() {
        return timezoneId;
    }

    public void setTimezoneId(String timezoneId) {
        this.timezoneId = timezoneId;
    }

    public TLVector<TLBusinessWeeklyOpen> getWeeklyOpen() {
        return weeklyOpen;
    }

    public void setWeeklyOpen(TLVector<TLBusinessWeeklyOpen> weeklyOpen) {
        this.weeklyOpen = weeklyOpen;
    }
}
