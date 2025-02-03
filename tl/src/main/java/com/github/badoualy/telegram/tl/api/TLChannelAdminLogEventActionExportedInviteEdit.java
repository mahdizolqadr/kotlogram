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
public class TLChannelAdminLogEventActionExportedInviteEdit extends TLAbsChannelAdminLogEventAction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsExportedChatInvite prevInvite;

    protected TLAbsExportedChatInvite newInvite;

    private final String _constructor = "channelAdminLogEventActionExportedInviteEdit#0";

    public TLChannelAdminLogEventActionExportedInviteEdit() {
    }

    public TLChannelAdminLogEventActionExportedInviteEdit(TLAbsExportedChatInvite prevInvite, TLAbsExportedChatInvite newInvite) {
        this.prevInvite = prevInvite;
        this.newInvite = newInvite;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(prevInvite, stream);
        writeTLObject(newInvite, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        prevInvite = readTLObject(stream, context, TLAbsExportedChatInvite.class, -1);
        newInvite = readTLObject(stream, context, TLAbsExportedChatInvite.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += prevInvite.computeSerializedSize();
        size += newInvite.computeSerializedSize();
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

    public TLAbsExportedChatInvite getPrevInvite() {
        return prevInvite;
    }

    public void setPrevInvite(TLAbsExportedChatInvite prevInvite) {
        this.prevInvite = prevInvite;
    }

    public TLAbsExportedChatInvite getNewInvite() {
        return newInvite;
    }

    public void setNewInvite(TLAbsExportedChatInvite newInvite) {
        this.newInvite = newInvite;
    }
}
