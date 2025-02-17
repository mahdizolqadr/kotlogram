package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLChannelMessagesFilter extends TLAbsChannelMessagesFilter {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean excludeNewMessages;

    protected TLVector<TLMessageRange> ranges;

    private final String _constructor = "channelMessagesFilter#0";

    public TLChannelMessagesFilter() {
    }

    public TLChannelMessagesFilter(boolean excludeNewMessages, TLVector<TLMessageRange> ranges) {
        this.excludeNewMessages = excludeNewMessages;
        this.ranges = ranges;
    }

    private void computeFlags() {
        flags = 0;
        flags = excludeNewMessages ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLVector(ranges, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        excludeNewMessages = (flags & 2) != 0;
        ranges = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += ranges.computeSerializedSize();
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

    public boolean getExcludeNewMessages() {
        return excludeNewMessages;
    }

    public void setExcludeNewMessages(boolean excludeNewMessages) {
        this.excludeNewMessages = excludeNewMessages;
    }

    public TLVector<TLMessageRange> getRanges() {
        return ranges;
    }

    public void setRanges(TLVector<TLMessageRange> ranges) {
        this.ranges = ranges;
    }

    @Override
    public final boolean isEmpty() {
        return false;
    }

    @Override
    public final boolean isNotEmpty() {
        return true;
    }

    @Override
    public final TLChannelMessagesFilter getAsChannelMessagesFilter() {
        return this;
    }
}
