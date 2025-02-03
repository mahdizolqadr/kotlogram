package com.github.badoualy.telegram.tl.api.phone;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsChat;
import com.github.badoualy.telegram.tl.api.TLAbsGroupCall;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.api.TLGroupCallParticipant;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
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
public class TLGroupCall extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsGroupCall call;

    protected TLVector<TLGroupCallParticipant> participants;

    protected String participantsNextOffset;

    protected TLVector<TLAbsChat> chats;

    protected TLVector<TLAbsUser> users;

    private final String _constructor = "phone.groupCall#0";

    public TLGroupCall() {
    }

    public TLGroupCall(TLAbsGroupCall call, TLVector<TLGroupCallParticipant> participants, String participantsNextOffset, TLVector<TLAbsChat> chats, TLVector<TLAbsUser> users) {
        this.call = call;
        this.participants = participants;
        this.participantsNextOffset = participantsNextOffset;
        this.chats = chats;
        this.users = users;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(call, stream);
        writeTLVector(participants, stream);
        writeString(participantsNextOffset, stream);
        writeTLVector(chats, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        call = readTLObject(stream, context, TLAbsGroupCall.class, -1);
        participants = readTLVector(stream, context);
        participantsNextOffset = readTLString(stream);
        chats = readTLVector(stream, context);
        users = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += call.computeSerializedSize();
        size += participants.computeSerializedSize();
        size += computeTLStringSerializedSize(participantsNextOffset);
        size += chats.computeSerializedSize();
        size += users.computeSerializedSize();
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

    public TLAbsGroupCall getCall() {
        return call;
    }

    public void setCall(TLAbsGroupCall call) {
        this.call = call;
    }

    public TLVector<TLGroupCallParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(TLVector<TLGroupCallParticipant> participants) {
        this.participants = participants;
    }

    public String getParticipantsNextOffset() {
        return participantsNextOffset;
    }

    public void setParticipantsNextOffset(String participantsNextOffset) {
        this.participantsNextOffset = participantsNextOffset;
    }

    public TLVector<TLAbsChat> getChats() {
        return chats;
    }

    public void setChats(TLVector<TLAbsChat> chats) {
        this.chats = chats;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }
}
