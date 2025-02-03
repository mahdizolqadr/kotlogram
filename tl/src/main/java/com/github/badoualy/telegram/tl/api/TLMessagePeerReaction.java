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
public class TLMessagePeerReaction extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean big;

    protected boolean unread;

    protected boolean my;

    protected TLAbsPeer peerId;

    protected int date;

    protected TLAbsReaction reaction;

    private final String _constructor = "messagePeerReaction#0";

    public TLMessagePeerReaction() {
    }

    public TLMessagePeerReaction(boolean big, boolean unread, boolean my, TLAbsPeer peerId, int date, TLAbsReaction reaction) {
        this.big = big;
        this.unread = unread;
        this.my = my;
        this.peerId = peerId;
        this.date = date;
        this.reaction = reaction;
    }

    private void computeFlags() {
        flags = 0;
        flags = big ? (flags | 1) : (flags & ~1);
        flags = unread ? (flags | 2) : (flags & ~2);
        flags = my ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peerId, stream);
        writeInt(date, stream);
        writeTLObject(reaction, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        big = (flags & 1) != 0;
        unread = (flags & 2) != 0;
        my = (flags & 4) != 0;
        peerId = readTLObject(stream, context, TLAbsPeer.class, -1);
        date = readInt(stream);
        reaction = readTLObject(stream, context, TLAbsReaction.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peerId.computeSerializedSize();
        size += SIZE_INT32;
        size += reaction.computeSerializedSize();
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

    public boolean getBig() {
        return big;
    }

    public void setBig(boolean big) {
        this.big = big;
    }

    public boolean getUnread() {
        return unread;
    }

    public void setUnread(boolean unread) {
        this.unread = unread;
    }

    public boolean getMy() {
        return my;
    }

    public void setMy(boolean my) {
        this.my = my;
    }

    public TLAbsPeer getPeerId() {
        return peerId;
    }

    public void setPeerId(TLAbsPeer peerId) {
        this.peerId = peerId;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public TLAbsReaction getReaction() {
        return reaction;
    }

    public void setReaction(TLAbsReaction reaction) {
        this.reaction = reaction;
    }
}
