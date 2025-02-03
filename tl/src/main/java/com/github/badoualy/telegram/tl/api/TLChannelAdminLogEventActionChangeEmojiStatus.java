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
public class TLChannelAdminLogEventActionChangeEmojiStatus extends TLAbsChannelAdminLogEventAction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsEmojiStatus prevValue;

    protected TLAbsEmojiStatus newValue;

    private final String _constructor = "channelAdminLogEventActionChangeEmojiStatus#0";

    public TLChannelAdminLogEventActionChangeEmojiStatus() {
    }

    public TLChannelAdminLogEventActionChangeEmojiStatus(TLAbsEmojiStatus prevValue, TLAbsEmojiStatus newValue) {
        this.prevValue = prevValue;
        this.newValue = newValue;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(prevValue, stream);
        writeTLObject(newValue, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        prevValue = readTLObject(stream, context, TLAbsEmojiStatus.class, -1);
        newValue = readTLObject(stream, context, TLAbsEmojiStatus.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += prevValue.computeSerializedSize();
        size += newValue.computeSerializedSize();
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

    public TLAbsEmojiStatus getPrevValue() {
        return prevValue;
    }

    public void setPrevValue(TLAbsEmojiStatus prevValue) {
        this.prevValue = prevValue;
    }

    public TLAbsEmojiStatus getNewValue() {
        return newValue;
    }

    public void setNewValue(TLAbsEmojiStatus newValue) {
        this.newValue = newValue;
    }
}
