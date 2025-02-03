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
public class TLSearchResultsCalendarPeriod extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int date;

    protected int minMsgId;

    protected int maxMsgId;

    protected int count;

    private final String _constructor = "searchResultsCalendarPeriod#0";

    public TLSearchResultsCalendarPeriod() {
    }

    public TLSearchResultsCalendarPeriod(int date, int minMsgId, int maxMsgId, int count) {
        this.date = date;
        this.minMsgId = minMsgId;
        this.maxMsgId = maxMsgId;
        this.count = count;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(date, stream);
        writeInt(minMsgId, stream);
        writeInt(maxMsgId, stream);
        writeInt(count, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        date = readInt(stream);
        minMsgId = readInt(stream);
        maxMsgId = readInt(stream);
        count = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
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

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMinMsgId() {
        return minMsgId;
    }

    public void setMinMsgId(int minMsgId) {
        this.minMsgId = minMsgId;
    }

    public int getMaxMsgId() {
        return maxMsgId;
    }

    public void setMaxMsgId(int maxMsgId) {
        this.maxMsgId = maxMsgId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
