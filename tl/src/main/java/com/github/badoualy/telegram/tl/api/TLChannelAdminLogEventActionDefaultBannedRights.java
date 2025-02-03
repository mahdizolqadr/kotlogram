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
public class TLChannelAdminLogEventActionDefaultBannedRights extends TLAbsChannelAdminLogEventAction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLChatBannedRights prevBannedRights;

    protected TLChatBannedRights newBannedRights;

    private final String _constructor = "channelAdminLogEventActionDefaultBannedRights#0";

    public TLChannelAdminLogEventActionDefaultBannedRights() {
    }

    public TLChannelAdminLogEventActionDefaultBannedRights(TLChatBannedRights prevBannedRights, TLChatBannedRights newBannedRights) {
        this.prevBannedRights = prevBannedRights;
        this.newBannedRights = newBannedRights;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(prevBannedRights, stream);
        writeTLObject(newBannedRights, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        prevBannedRights = readTLObject(stream, context, TLChatBannedRights.class, TLChatBannedRights.CONSTRUCTOR_ID);
        newBannedRights = readTLObject(stream, context, TLChatBannedRights.class, TLChatBannedRights.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += prevBannedRights.computeSerializedSize();
        size += newBannedRights.computeSerializedSize();
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

    public TLChatBannedRights getPrevBannedRights() {
        return prevBannedRights;
    }

    public void setPrevBannedRights(TLChatBannedRights prevBannedRights) {
        this.prevBannedRights = prevBannedRights;
    }

    public TLChatBannedRights getNewBannedRights() {
        return newBannedRights;
    }

    public void setNewBannedRights(TLChatBannedRights newBannedRights) {
        this.newBannedRights = newBannedRights;
    }
}
