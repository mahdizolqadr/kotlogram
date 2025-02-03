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
public class TLChannelAdminLogEventActionParticipantInvite extends TLAbsChannelAdminLogEventAction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsChannelParticipant participant;

    private final String _constructor = "channelAdminLogEventActionParticipantInvite#0";

    public TLChannelAdminLogEventActionParticipantInvite() {
    }

    public TLChannelAdminLogEventActionParticipantInvite(TLAbsChannelParticipant participant) {
        this.participant = participant;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(participant, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        participant = readTLObject(stream, context, TLAbsChannelParticipant.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += participant.computeSerializedSize();
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

    public TLAbsChannelParticipant getParticipant() {
        return participant;
    }

    public void setParticipant(TLAbsChannelParticipant participant) {
        this.participant = participant;
    }
}
