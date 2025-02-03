package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsReaction;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
import com.github.badoualy.telegram.tl.core.TLMethod;
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
public class TLRequestMessagesSendReaction extends TLMethod<TLAbsUpdates> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean big;

    protected boolean addToRecent;

    protected TLAbsInputPeer peer;

    protected int msgId;

    protected TLVector<TLAbsReaction> reaction;

    private final String _constructor = "messages.sendReaction#0";

    public TLRequestMessagesSendReaction() {
    }

    public TLRequestMessagesSendReaction(boolean big, boolean addToRecent, TLAbsInputPeer peer, int msgId, TLVector<TLAbsReaction> reaction) {
        this.big = big;
        this.addToRecent = addToRecent;
        this.peer = peer;
        this.msgId = msgId;
        this.reaction = reaction;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsUpdates deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsUpdates)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsUpdates) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = big ? (flags | 2) : (flags & ~2);
        flags = addToRecent ? (flags | 4) : (flags & ~4);
        flags = reaction != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peer, stream);
        writeInt(msgId, stream);
        if ((flags & 1) != 0) {
            if (reaction == null) throwNullFieldException("reaction", flags);
            writeTLVector(reaction, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        big = (flags & 2) != 0;
        addToRecent = (flags & 4) != 0;
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        msgId = readInt(stream);
        reaction = (flags & 1) != 0 ? readTLVector(stream, context) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (reaction == null) throwNullFieldException("reaction", flags);
            size += reaction.computeSerializedSize();
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

    public boolean getBig() {
        return big;
    }

    public void setBig(boolean big) {
        this.big = big;
    }

    public boolean getAddToRecent() {
        return addToRecent;
    }

    public void setAddToRecent(boolean addToRecent) {
        this.addToRecent = addToRecent;
    }

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public TLVector<TLAbsReaction> getReaction() {
        return reaction;
    }

    public void setReaction(TLVector<TLAbsReaction> reaction) {
        this.reaction = reaction;
    }
}
