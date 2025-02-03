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
public class TLChannelAdminLogEventActionChangeLinkedChat extends TLAbsChannelAdminLogEventAction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected long prevValue;

    protected long newValue;

    private final String _constructor = "channelAdminLogEventActionChangeLinkedChat#0";

    public TLChannelAdminLogEventActionChangeLinkedChat() {
    }

    public TLChannelAdminLogEventActionChangeLinkedChat(long prevValue, long newValue) {
        this.prevValue = prevValue;
        this.newValue = newValue;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(prevValue, stream);
        writeLong(newValue, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        prevValue = readLong(stream);
        newValue = readLong(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += SIZE_INT64;
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

    public long getPrevValue() {
        return prevValue;
    }

    public void setPrevValue(long prevValue) {
        this.prevValue = prevValue;
    }

    public long getNewValue() {
        return newValue;
    }

    public void setNewValue(long newValue) {
        this.newValue = newValue;
    }
}
