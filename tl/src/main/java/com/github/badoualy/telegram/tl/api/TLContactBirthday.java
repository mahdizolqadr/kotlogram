package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLContactBirthday extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected long contactId;

    protected TLBirthday birthday;

    private final String _constructor = "contactBirthday#0";

    public TLContactBirthday() {
    }

    public TLContactBirthday(long contactId, TLBirthday birthday) {
        this.contactId = contactId;
        this.birthday = birthday;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(contactId, stream);
        writeTLObject(birthday, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        contactId = readLong(stream);
        birthday = readTLObject(stream, context, TLBirthday.class, TLBirthday.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += birthday.computeSerializedSize();
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

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public TLBirthday getBirthday() {
        return birthday;
    }

    public void setBirthday(TLBirthday birthday) {
        this.birthday = birthday;
    }
}
