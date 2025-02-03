package com.github.badoualy.telegram.tl.api.payments;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.api.TLUserStarGift;
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
public class TLUserStarGifts extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected int count;

    protected TLVector<TLUserStarGift> gifts;

    protected String nextOffset;

    protected TLVector<TLAbsUser> users;

    private final String _constructor = "payments.userStarGifts#0";

    public TLUserStarGifts() {
    }

    public TLUserStarGifts(int count, TLVector<TLUserStarGift> gifts, String nextOffset, TLVector<TLAbsUser> users) {
        this.count = count;
        this.gifts = gifts;
        this.nextOffset = nextOffset;
        this.users = users;
    }

    private void computeFlags() {
        flags = 0;
        flags = nextOffset != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(count, stream);
        writeTLVector(gifts, stream);
        if ((flags & 1) != 0) {
            if (nextOffset == null) throwNullFieldException("nextOffset", flags);
            writeString(nextOffset, stream);
        }
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        count = readInt(stream);
        gifts = readTLVector(stream, context);
        nextOffset = (flags & 1) != 0 ? readTLString(stream) : null;
        users = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += gifts.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (nextOffset == null) throwNullFieldException("nextOffset", flags);
            size += computeTLStringSerializedSize(nextOffset);
        }
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public TLVector<TLUserStarGift> getGifts() {
        return gifts;
    }

    public void setGifts(TLVector<TLUserStarGift> gifts) {
        this.gifts = gifts;
    }

    public String getNextOffset() {
        return nextOffset;
    }

    public void setNextOffset(String nextOffset) {
        this.nextOffset = nextOffset;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }
}
