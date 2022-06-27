package com.github.badoualy.telegram.tl.api.contacts;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsChat;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.api.TLPeerBlocked;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLBlockedSlice extends TLAbsBlocked {

    public static final int CONSTRUCTOR_ID = 0xe1664194;

    protected int count;

    private final String _constructor = "contacts.blockedSlice#e1664194";

    public TLBlockedSlice() {
    }

    public TLBlockedSlice(int count, TLVector<TLPeerBlocked> blocked, TLVector<TLAbsChat> chats, TLVector<TLAbsUser> users) {
        super(blocked, chats, users);
        this.count = count;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(count, stream);
        super.serializeBody(stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        count = readInt(stream);
        super.deserializeBody(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += blocked.computeSerializedSize();
        size += chats.computeSerializedSize();
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
}
