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
public class TLChannelAdminLogEventActionToggleSlowMode extends TLAbsChannelAdminLogEventAction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int prevValue;

    protected int newValue;

    private final String _constructor = "channelAdminLogEventActionToggleSlowMode#0";

    public TLChannelAdminLogEventActionToggleSlowMode() {
    }

    public TLChannelAdminLogEventActionToggleSlowMode(int prevValue, int newValue) {
        this.prevValue = prevValue;
        this.newValue = newValue;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(prevValue, stream);
        writeInt(newValue, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        prevValue = readInt(stream);
        newValue = readInt(stream);
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

    public int getPrevValue() {
        return prevValue;
    }

    public void setPrevValue(int prevValue) {
        this.prevValue = prevValue;
    }

    public int getNewValue() {
        return newValue;
    }

    public void setNewValue(int newValue) {
        this.newValue = newValue;
    }
}
