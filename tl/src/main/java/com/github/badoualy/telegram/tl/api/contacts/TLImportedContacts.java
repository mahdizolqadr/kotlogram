package com.github.badoualy.telegram.tl.api.contacts;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.api.TLImportedContact;
import com.github.badoualy.telegram.tl.api.TLPopularContact;
import com.github.badoualy.telegram.tl.core.TLLongVector;
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
public class TLImportedContacts extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLVector<TLImportedContact> imported;

    protected TLVector<TLPopularContact> popularInvites;

    protected TLLongVector retryContacts;

    protected TLVector<TLAbsUser> users;

    private final String _constructor = "contacts.importedContacts#0";

    public TLImportedContacts() {
    }

    public TLImportedContacts(TLVector<TLImportedContact> imported, TLVector<TLPopularContact> popularInvites, TLLongVector retryContacts, TLVector<TLAbsUser> users) {
        this.imported = imported;
        this.popularInvites = popularInvites;
        this.retryContacts = retryContacts;
        this.users = users;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(imported, stream);
        writeTLVector(popularInvites, stream);
        writeTLVector(retryContacts, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        imported = readTLVector(stream, context);
        popularInvites = readTLVector(stream, context);
        retryContacts = readTLLongVector(stream, context);
        users = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += imported.computeSerializedSize();
        size += popularInvites.computeSerializedSize();
        size += retryContacts.computeSerializedSize();
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

    public TLVector<TLImportedContact> getImported() {
        return imported;
    }

    public void setImported(TLVector<TLImportedContact> imported) {
        this.imported = imported;
    }

    public TLVector<TLPopularContact> getPopularInvites() {
        return popularInvites;
    }

    public void setPopularInvites(TLVector<TLPopularContact> popularInvites) {
        this.popularInvites = popularInvites;
    }

    public TLLongVector getRetryContacts() {
        return retryContacts;
    }

    public void setRetryContacts(TLLongVector retryContacts) {
        this.retryContacts = retryContacts;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }
}
