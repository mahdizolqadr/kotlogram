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
public class TLMessageReactor extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean top;

    protected boolean my;

    protected boolean anonymous;

    protected TLAbsPeer peerId;

    protected int count;

    private final String _constructor = "messageReactor#0";

    public TLMessageReactor() {
    }

    public TLMessageReactor(boolean top, boolean my, boolean anonymous, TLAbsPeer peerId, int count) {
        this.top = top;
        this.my = my;
        this.anonymous = anonymous;
        this.peerId = peerId;
        this.count = count;
    }

    private void computeFlags() {
        flags = 0;
        flags = top ? (flags | 1) : (flags & ~1);
        flags = my ? (flags | 2) : (flags & ~2);
        flags = anonymous ? (flags | 4) : (flags & ~4);
        flags = peerId != null ? (flags | 8) : (flags & ~8);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 8) != 0) {
            if (peerId == null) throwNullFieldException("peerId", flags);
            writeTLObject(peerId, stream);
        }
        writeInt(count, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        top = (flags & 1) != 0;
        my = (flags & 2) != 0;
        anonymous = (flags & 4) != 0;
        peerId = (flags & 8) != 0 ? readTLObject(stream, context, TLAbsPeer.class, -1) : null;
        count = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 8) != 0) {
            if (peerId == null) throwNullFieldException("peerId", flags);
            size += peerId.computeSerializedSize();
        }
        size += SIZE_INT32;
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

    public boolean getTop() {
        return top;
    }

    public void setTop(boolean top) {
        this.top = top;
    }

    public boolean getMy() {
        return my;
    }

    public void setMy(boolean my) {
        this.my = my;
    }

    public boolean getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(boolean anonymous) {
        this.anonymous = anonymous;
    }

    public TLAbsPeer getPeerId() {
        return peerId;
    }

    public void setPeerId(TLAbsPeer peerId) {
        this.peerId = peerId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
