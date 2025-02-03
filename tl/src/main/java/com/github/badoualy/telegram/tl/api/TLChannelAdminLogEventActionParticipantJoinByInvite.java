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
public class TLChannelAdminLogEventActionParticipantJoinByInvite extends TLAbsChannelAdminLogEventAction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean viaChatlist;

    protected TLAbsExportedChatInvite invite;

    private final String _constructor = "channelAdminLogEventActionParticipantJoinByInvite#0";

    public TLChannelAdminLogEventActionParticipantJoinByInvite() {
    }

    public TLChannelAdminLogEventActionParticipantJoinByInvite(boolean viaChatlist, TLAbsExportedChatInvite invite) {
        this.viaChatlist = viaChatlist;
        this.invite = invite;
    }

    private void computeFlags() {
        flags = 0;
        flags = viaChatlist ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(invite, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        viaChatlist = (flags & 1) != 0;
        invite = readTLObject(stream, context, TLAbsExportedChatInvite.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += invite.computeSerializedSize();
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

    public boolean getViaChatlist() {
        return viaChatlist;
    }

    public void setViaChatlist(boolean viaChatlist) {
        this.viaChatlist = viaChatlist;
    }

    public TLAbsExportedChatInvite getInvite() {
        return invite;
    }

    public void setInvite(TLAbsExportedChatInvite invite) {
        this.invite = invite;
    }
}
