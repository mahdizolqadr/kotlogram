package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMyBoost extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected int slot;

    protected TLAbsPeer peer;

    protected int date;

    protected int expires;

    protected Integer cooldownUntilDate;

    private final String _constructor = "myBoost#0";

    public TLMyBoost() {
    }

    public TLMyBoost(int slot, TLAbsPeer peer, int date, int expires, Integer cooldownUntilDate) {
        this.slot = slot;
        this.peer = peer;
        this.date = date;
        this.expires = expires;
        this.cooldownUntilDate = cooldownUntilDate;
    }

    private void computeFlags() {
        flags = 0;
        flags = peer != null ? (flags | 1) : (flags & ~1);
        flags = cooldownUntilDate != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(slot, stream);
        if ((flags & 1) != 0) {
            if (peer == null) throwNullFieldException("peer", flags);
            writeTLObject(peer, stream);
        }
        writeInt(date, stream);
        writeInt(expires, stream);
        if ((flags & 2) != 0) {
            if (cooldownUntilDate == null) throwNullFieldException("cooldownUntilDate", flags);
            writeInt(cooldownUntilDate, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        slot = readInt(stream);
        peer = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsPeer.class, -1) : null;
        date = readInt(stream);
        expires = readInt(stream);
        cooldownUntilDate = (flags & 2) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (peer == null) throwNullFieldException("peer", flags);
            size += peer.computeSerializedSize();
        }
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 2) != 0) {
            if (cooldownUntilDate == null) throwNullFieldException("cooldownUntilDate", flags);
            size += SIZE_INT32;
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

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public TLAbsPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsPeer peer) {
        this.peer = peer;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getExpires() {
        return expires;
    }

    public void setExpires(int expires) {
        this.expires = expires;
    }

    public Integer getCooldownUntilDate() {
        return cooldownUntilDate;
    }

    public void setCooldownUntilDate(Integer cooldownUntilDate) {
        this.cooldownUntilDate = cooldownUntilDate;
    }
}
