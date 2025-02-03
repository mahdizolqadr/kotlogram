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
public class TLRequestedPeerUser extends TLAbsRequestedPeer {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected long userId;

    protected String firstName;

    protected String lastName;

    protected String username;

    private final String _constructor = "requestedPeerUser#0";

    public TLRequestedPeerUser() {
    }

    public TLRequestedPeerUser(long userId, String firstName, String lastName, String username, TLAbsPhoto photo) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.photo = photo;
    }

    private void computeFlags() {
        flags = 0;
        flags = firstName != null ? (flags | 1) : (flags & ~1);
        flags = lastName != null ? (flags | 1) : (flags & ~1);
        flags = username != null ? (flags | 2) : (flags & ~2);
        flags = photo != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(userId, stream);
        if ((flags & 1) != 0) {
            if (firstName == null) throwNullFieldException("firstName", flags);
            writeString(firstName, stream);
        }
        if ((flags & 1) != 0) {
            if (lastName == null) throwNullFieldException("lastName", flags);
            writeString(lastName, stream);
        }
        if ((flags & 2) != 0) {
            if (username == null) throwNullFieldException("username", flags);
            writeString(username, stream);
        }
        if ((flags & 4) != 0) {
            if (photo == null) throwNullFieldException("photo", flags);
            writeTLObject(photo, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        userId = readLong(stream);
        firstName = (flags & 1) != 0 ? readTLString(stream) : null;
        lastName = (flags & 1) != 0 ? readTLString(stream) : null;
        username = (flags & 2) != 0 ? readTLString(stream) : null;
        photo = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsPhoto.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        if ((flags & 1) != 0) {
            if (firstName == null) throwNullFieldException("firstName", flags);
            size += computeTLStringSerializedSize(firstName);
        }
        if ((flags & 1) != 0) {
            if (lastName == null) throwNullFieldException("lastName", flags);
            size += computeTLStringSerializedSize(lastName);
        }
        if ((flags & 2) != 0) {
            if (username == null) throwNullFieldException("username", flags);
            size += computeTLStringSerializedSize(username);
        }
        if ((flags & 4) != 0) {
            if (photo == null) throwNullFieldException("photo", flags);
            size += photo.computeSerializedSize();
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TLAbsPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(TLAbsPhoto photo) {
        this.photo = photo;
    }
}
