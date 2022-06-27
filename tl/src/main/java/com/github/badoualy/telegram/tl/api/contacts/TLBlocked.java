package com.github.badoualy.telegram.tl.api.contacts;

import com.github.badoualy.telegram.tl.api.TLAbsChat;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.api.TLPeerBlocked;
import com.github.badoualy.telegram.tl.core.TLVector;

import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLBlocked extends TLAbsBlocked {

    public static final int CONSTRUCTOR_ID = 0xade1591;

    private final String _constructor = "contacts.blocked#ade1591";

    public TLBlocked() {
    }

    public TLBlocked(TLVector<TLPeerBlocked> blocked, TLVector<TLAbsChat> chats, TLVector<TLAbsUser> users) {
        super(blocked, chats, users);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
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
}
