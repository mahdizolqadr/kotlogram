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
public class TLChannelAdminLogEventActionToggleGroupCallSetting extends TLAbsChannelAdminLogEventAction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected boolean joinMuted;

    private final String _constructor = "channelAdminLogEventActionToggleGroupCallSetting#0";

    public TLChannelAdminLogEventActionToggleGroupCallSetting() {
    }

    public TLChannelAdminLogEventActionToggleGroupCallSetting(boolean joinMuted) {
        this.joinMuted = joinMuted;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeBoolean(joinMuted, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        joinMuted = readTLBool(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_BOOLEAN;
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

    public boolean getJoinMuted() {
        return joinMuted;
    }

    public void setJoinMuted(boolean joinMuted) {
        this.joinMuted = joinMuted;
    }
}
