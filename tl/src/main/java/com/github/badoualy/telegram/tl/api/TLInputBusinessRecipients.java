package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLInputBusinessRecipients extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean existingChats;

    protected boolean newChats;

    protected boolean contacts;

    protected boolean nonContacts;

    protected boolean excludeSelected;

    protected TLVector<TLAbsInputUser> users;

    private final String _constructor = "inputBusinessRecipients#0";

    public TLInputBusinessRecipients() {
    }

    public TLInputBusinessRecipients(boolean existingChats, boolean newChats, boolean contacts, boolean nonContacts, boolean excludeSelected, TLVector<TLAbsInputUser> users) {
        this.existingChats = existingChats;
        this.newChats = newChats;
        this.contacts = contacts;
        this.nonContacts = nonContacts;
        this.excludeSelected = excludeSelected;
        this.users = users;
    }

    private void computeFlags() {
        flags = 0;
        flags = existingChats ? (flags | 1) : (flags & ~1);
        flags = newChats ? (flags | 2) : (flags & ~2);
        flags = contacts ? (flags | 4) : (flags & ~4);
        flags = nonContacts ? (flags | 8) : (flags & ~8);
        flags = excludeSelected ? (flags | 32) : (flags & ~32);
        flags = users != null ? (flags | 16) : (flags & ~16);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 16) != 0) {
            if (users == null) throwNullFieldException("users", flags);
            writeTLVector(users, stream);
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
        users = (flags & 16) != 0 ? readTLVector(stream, context) : null;
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

    public TLVector<TLAbsInputUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsInputUser> users) {
        this.users = users;
    }
}
