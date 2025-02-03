package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLUpdateUserName extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected long userId;

    protected String firstName;

    protected String lastName;

    protected TLVector<TLUsername> usernames;

    private final String _constructor = "updateUserName#0";

    public TLUpdateUserName() {
    }

    public TLUpdateUserName(long userId, String firstName, String lastName, TLVector<TLUsername> usernames) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.usernames = usernames;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(userId, stream);
        writeString(firstName, stream);
        writeString(lastName, stream);
        writeTLVector(usernames, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        userId = readLong(stream);
        firstName = readTLString(stream);
        lastName = readTLString(stream);
        usernames = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(firstName);
        size += computeTLStringSerializedSize(lastName);
        size += usernames.computeSerializedSize();
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

    public TLVector<TLUsername> getUsernames() {
        return usernames;
    }

    public void setUsernames(TLVector<TLUsername> usernames) {
        this.usernames = usernames;
    }
}
