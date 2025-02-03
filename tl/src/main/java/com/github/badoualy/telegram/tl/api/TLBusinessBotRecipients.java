package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLLongVector;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLBusinessBotRecipients extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean existingChats;

    protected boolean newChats;

    protected boolean contacts;

    protected boolean nonContacts;

    protected boolean excludeSelected;

    protected TLLongVector users;

    protected TLLongVector excludeUsers;

    private final String _constructor = "businessBotRecipients#0";

    public TLBusinessBotRecipients() {
    }

    public TLBusinessBotRecipients(boolean existingChats, boolean newChats, boolean contacts, boolean nonContacts, boolean excludeSelected, TLLongVector users, TLLongVector excludeUsers) {
        this.existingChats = existingChats;
        this.newChats = newChats;
        this.contacts = contacts;
        this.nonContacts = nonContacts;
        this.excludeSelected = excludeSelected;
        this.users = users;
        this.excludeUsers = excludeUsers;
    }

    private void computeFlags() {
        flags = 0;
        flags = existingChats ? (flags | 1) : (flags & ~1);
        flags = newChats ? (flags | 2) : (flags & ~2);
        flags = contacts ? (flags | 4) : (flags & ~4);
        flags = nonContacts ? (flags | 8) : (flags & ~8);
        flags = excludeSelected ? (flags | 32) : (flags & ~32);
        flags = users != null ? (flags | 16) : (flags & ~16);
        flags = excludeUsers != null ? (flags | 64) : (flags & ~64);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 16) != 0) {
            if (users == null) throwNullFieldException("users", flags);
            writeTLVector(users, stream);
        }
        if ((flags & 64) != 0) {
            if (excludeUsers == null) throwNullFieldException("excludeUsers", flags);
            writeTLVector(excludeUsers, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        existingChats = (flags & 1) != 0;
        newChats = (flags & 2) != 0;
        contacts = (flags & 4) != 0;
        nonContacts = (flags & 8) != 0;
        excludeSelected = (flags & 32) != 0;
        users = (flags & 16) != 0 ? readTLLongVector(stream, context) : null;
        excludeUsers = (flags & 64) != 0 ? readTLLongVector(stream, context) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 16) != 0) {
            if (users == null) throwNullFieldException("users", flags);
            size += users.computeSerializedSize();
        }
        if ((flags & 64) != 0) {
            if (excludeUsers == null) throwNullFieldException("excludeUsers", flags);
            size += excludeUsers.computeSerializedSize();
        }
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

    public boolean getExistingChats() {
        return existingChats;
    }

    public void setExistingChats(boolean existingChats) {
        this.existingChats = existingChats;
    }

    public boolean getNewChats() {
        return newChats;
    }

    public void setNewChats(boolean newChats) {
        this.newChats = newChats;
    }

    public boolean getContacts() {
        return contacts;
    }

    public void setContacts(boolean contacts) {
        this.contacts = contacts;
    }

    public boolean getNonContacts() {
        return nonContacts;
    }

    public void setNonContacts(boolean nonContacts) {
        this.nonContacts = nonContacts;
    }

    public boolean getExcludeSelected() {
        return excludeSelected;
    }

    public void setExcludeSelected(boolean excludeSelected) {
        this.excludeSelected = excludeSelected;
    }

    public TLLongVector getUsers() {
        return users;
    }

    public void setUsers(TLLongVector users) {
        this.users = users;
    }

    public TLLongVector getExcludeUsers() {
        return excludeUsers;
    }

    public void setExcludeUsers(TLLongVector excludeUsers) {
        this.excludeUsers = excludeUsers;
    }
}
