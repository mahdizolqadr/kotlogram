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
public class TLChannelAdminLogEventActionParticipantJoinByRequest extends TLAbsChannelAdminLogEventAction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsExportedChatInvite invite;

    protected long approvedBy;

    private final String _constructor = "channelAdminLogEventActionParticipantJoinByRequest#0";

    public TLChannelAdminLogEventActionParticipantJoinByRequest() {
    }

    public TLChannelAdminLogEventActionParticipantJoinByRequest(TLAbsExportedChatInvite invite, long approvedBy) {
        this.invite = invite;
        this.approvedBy = approvedBy;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(invite, stream);
        writeLong(approvedBy, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        invite = readTLObject(stream, context, TLAbsExportedChatInvite.class, -1);
        approvedBy = readLong(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += invite.computeSerializedSize();
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

    public TLAbsExportedChatInvite getInvite() {
        return invite;
    }

    public void setInvite(TLAbsExportedChatInvite invite) {
        this.invite = invite;
    }

    public long getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(long approvedBy) {
        this.approvedBy = approvedBy;
    }
}
