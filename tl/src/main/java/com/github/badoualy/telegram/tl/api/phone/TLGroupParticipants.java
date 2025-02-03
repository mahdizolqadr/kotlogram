package com.github.badoualy.telegram.tl.api.phone;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsChat;
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
public class TLGroupParticipants extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int count;

    protected TLVector<TLGroupCallParticipant> participants;

    protected String nextOffset;

    protected TLVector<TLAbsChat> chats;

    protected TLVector<TLAbsUser> users;

    protected int version;

    private final String _constructor = "phone.groupParticipants#0";

    public TLGroupParticipants() {
    }

    public TLGroupParticipants(int count, TLVector<TLGroupCallParticipant> participants, String nextOffset, TLVector<TLAbsChat> chats, TLVector<TLAbsUser> users, int version) {
        this.count = count;
        this.participants = participants;
        this.nextOffset = nextOffset;
        this.chats = chats;
        this.users = users;
        this.version = version;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(count, stream);
        writeTLVector(participants, stream);
        writeString(nextOffset, stream);
        writeTLVector(chats, stream);
        writeTLVector(users, stream);
        writeInt(version, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        count = readInt(stream);
        participants = readTLVector(stream, context);
        nextOffset = readTLString(stream);
        chats = readTLVector(stream, context);
        users = readTLVector(stream, context);
        version = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += participants.computeSerializedSize();
        size += computeTLStringSerializedSize(nextOffset);
        size += chats.computeSerializedSize();
        size += users.computeSerializedSize();
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public TLVector<TLGroupCallParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(TLVector<TLGroupCallParticipant> participants) {
        this.participants = participants;
    }

    public String getNextOffset() {
        return nextOffset;
    }

    public void setNextOffset(String nextOffset) {
        this.nextOffset = nextOffset;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
