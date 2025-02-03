package com.github.badoualy.telegram.tl.api.contacts;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.api.TLContact;
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
public class TLContacts extends TLAbsContacts {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLVector<TLContact> contacts;

    protected int savedCount;

    protected TLVector<TLAbsUser> users;

    private final String _constructor = "contacts.contacts#0";

    public TLContacts() {
    }

    public TLContacts(TLVector<TLContact> contacts, int savedCount, TLVector<TLAbsUser> users) {
        this.contacts = contacts;
        this.savedCount = savedCount;
        this.users = users;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(contacts, stream);
        writeInt(savedCount, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        contacts = readTLVector(stream, context);
        savedCount = readInt(stream);
        users = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += contacts.computeSerializedSize();
        size += SIZE_INT32;
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

    public TLVector<TLContact> getContacts() {
        return contacts;
    }

    public void setContacts(TLVector<TLContact> contacts) {
        this.contacts = contacts;
    }

    public int getSavedCount() {
        return savedCount;
    }

    public void setSavedCount(int savedCount) {
        this.savedCount = savedCount;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }
}
