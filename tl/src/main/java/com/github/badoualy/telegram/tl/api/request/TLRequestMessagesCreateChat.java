package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputUser;
import com.github.badoualy.telegram.tl.api.messages.TLInvitedUsers;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestMessagesCreateChat extends TLMethod<TLInvitedUsers> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLVector<TLAbsInputUser> users;

    protected String title;

    protected Integer ttlPeriod;

    private final String _constructor = "messages.createChat#0";

    public TLRequestMessagesCreateChat() {
    }

    public TLRequestMessagesCreateChat(TLVector<TLAbsInputUser> users, String title, Integer ttlPeriod) {
        this.users = users;
        this.title = title;
        this.ttlPeriod = ttlPeriod;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLInvitedUsers deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLInvitedUsers)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLInvitedUsers) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = ttlPeriod != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLVector(users, stream);
        writeString(title, stream);
        if ((flags & 1) != 0) {
            if (ttlPeriod == null) throwNullFieldException("ttlPeriod", flags);
            writeInt(ttlPeriod, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        users = readTLVector(stream, context);
        title = readTLString(stream);
        ttlPeriod = (flags & 1) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += users.computeSerializedSize();
        size += computeTLStringSerializedSize(title);
        if ((flags & 1) != 0) {
            if (ttlPeriod == null) throwNullFieldException("ttlPeriod", flags);
            size += SIZE_INT32;
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

    public TLVector<TLAbsInputUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsInputUser> users) {
        this.users = users;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTtlPeriod() {
        return ttlPeriod;
    }

    public void setTtlPeriod(Integer ttlPeriod) {
        this.ttlPeriod = ttlPeriod;
    }
}
