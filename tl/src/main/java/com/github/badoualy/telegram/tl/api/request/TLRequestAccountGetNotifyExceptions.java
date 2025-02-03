package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputNotifyPeer;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
import com.github.badoualy.telegram.tl.core.TLMethod;
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
public class TLRequestAccountGetNotifyExceptions extends TLMethod<TLAbsUpdates> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean compareSound;

    protected boolean compareStories;

    protected TLAbsInputNotifyPeer peer;

    private final String _constructor = "account.getNotifyExceptions#0";

    public TLRequestAccountGetNotifyExceptions() {
    }

    public TLRequestAccountGetNotifyExceptions(boolean compareSound, boolean compareStories, TLAbsInputNotifyPeer peer) {
        this.compareSound = compareSound;
        this.compareStories = compareStories;
        this.peer = peer;
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
        flags = compareSound ? (flags | 2) : (flags & ~2);
        flags = compareStories ? (flags | 4) : (flags & ~4);
        flags = peer != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (peer == null) throwNullFieldException("peer", flags);
            writeTLObject(peer, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        compareSound = (flags & 2) != 0;
        compareStories = (flags & 4) != 0;
        peer = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsInputNotifyPeer.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (peer == null) throwNullFieldException("peer", flags);
            size += peer.computeSerializedSize();
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

    public boolean getCompareSound() {
        return compareSound;
    }

    public void setCompareSound(boolean compareSound) {
        this.compareSound = compareSound;
    }

    public boolean getCompareStories() {
        return compareStories;
    }

    public void setCompareStories(boolean compareStories) {
        this.compareStories = compareStories;
    }

    public TLAbsInputNotifyPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputNotifyPeer peer) {
        this.peer = peer;
    }
}
