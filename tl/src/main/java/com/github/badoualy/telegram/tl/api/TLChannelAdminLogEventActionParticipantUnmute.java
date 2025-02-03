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
public class TLChannelAdminLogEventActionParticipantUnmute extends TLAbsChannelAdminLogEventAction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLGroupCallParticipant participant;

    private final String _constructor = "channelAdminLogEventActionParticipantUnmute#0";

    public TLChannelAdminLogEventActionParticipantUnmute() {
    }

    public TLChannelAdminLogEventActionParticipantUnmute(TLGroupCallParticipant participant) {
        this.participant = participant;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(participant, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        participant = readTLObject(stream, context, TLGroupCallParticipant.class, TLGroupCallParticipant.CONSTRUCTOR_ID);
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

    public TLGroupCallParticipant getParticipant() {
        return participant;
    }

    public void setParticipant(TLGroupCallParticipant participant) {
        this.participant = participant;
    }
}
