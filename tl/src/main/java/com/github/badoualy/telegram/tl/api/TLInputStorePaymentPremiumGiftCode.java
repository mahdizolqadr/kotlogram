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
public class TLInputStorePaymentPremiumGiftCode extends TLAbsInputStorePaymentPurpose {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLVector<TLAbsInputUser> users;

    protected TLAbsInputPeer boostPeer;

    protected String currency;

    protected long amount;

    protected TLTextWithEntities message;

    private final String _constructor = "inputStorePaymentPremiumGiftCode#0";

    public TLInputStorePaymentPremiumGiftCode() {
    }

    public TLInputStorePaymentPremiumGiftCode(TLVector<TLAbsInputUser> users, TLAbsInputPeer boostPeer, String currency, long amount, TLTextWithEntities message) {
        this.users = users;
        this.boostPeer = boostPeer;
        this.currency = currency;
        this.amount = amount;
        this.message = message;
    }

    private void computeFlags() {
        flags = 0;
        flags = boostPeer != null ? (flags | 1) : (flags & ~1);
        flags = message != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLVector(users, stream);
        if ((flags & 1) != 0) {
            if (boostPeer == null) throwNullFieldException("boostPeer", flags);
            writeTLObject(boostPeer, stream);
        }
        writeString(currency, stream);
        writeLong(amount, stream);
        if ((flags & 2) != 0) {
            if (message == null) throwNullFieldException("message", flags);
            writeTLObject(message, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        users = readTLVector(stream, context);
        boostPeer = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsInputPeer.class, -1) : null;
        currency = readTLString(stream);
        amount = readLong(stream);
        message = (flags & 2) != 0 ? readTLObject(stream, context, TLTextWithEntities.class, TLTextWithEntities.CONSTRUCTOR_ID) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += users.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (boostPeer == null) throwNullFieldException("boostPeer", flags);
            size += boostPeer.computeSerializedSize();
        }
        size += computeTLStringSerializedSize(currency);
        size += SIZE_INT64;
        if ((flags & 2) != 0) {
            if (message == null) throwNullFieldException("message", flags);
            size += message.computeSerializedSize();
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

    public TLVector<TLAbsInputUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsInputUser> users) {
        this.users = users;
    }

    public TLAbsInputPeer getBoostPeer() {
        return boostPeer;
    }

    public void setBoostPeer(TLAbsInputPeer boostPeer) {
        this.boostPeer = boostPeer;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public TLTextWithEntities getMessage() {
        return message;
    }

    public void setMessage(TLTextWithEntities message) {
        this.message = message;
    }
}
