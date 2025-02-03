package com.github.badoualy.telegram.tl.api.payments;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsChat;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.api.TLStarsAmount;
import com.github.badoualy.telegram.tl.api.TLStarsSubscription;
import com.github.badoualy.telegram.tl.api.TLStarsTransaction;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLStarsStatus extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLStarsAmount balance;

    protected TLVector<TLStarsSubscription> subscriptions;

    protected String subscriptionsNextOffset;

    protected Long subscriptionsMissingBalance;

    protected TLVector<TLStarsTransaction> history;

    protected String nextOffset;

    protected TLVector<TLAbsChat> chats;

    protected TLVector<TLAbsUser> users;

    private final String _constructor = "payments.starsStatus#0";

    public TLStarsStatus() {
    }

    public TLStarsStatus(TLStarsAmount balance, TLVector<TLStarsSubscription> subscriptions, String subscriptionsNextOffset, Long subscriptionsMissingBalance, TLVector<TLStarsTransaction> history, String nextOffset, TLVector<TLAbsChat> chats, TLVector<TLAbsUser> users) {
        this.balance = balance;
        this.subscriptions = subscriptions;
        this.subscriptionsNextOffset = subscriptionsNextOffset;
        this.subscriptionsMissingBalance = subscriptionsMissingBalance;
        this.history = history;
        this.nextOffset = nextOffset;
        this.chats = chats;
        this.users = users;
    }

    private void computeFlags() {
        flags = 0;
        flags = subscriptions != null ? (flags | 2) : (flags & ~2);
        flags = subscriptionsNextOffset != null ? (flags | 4) : (flags & ~4);
        flags = subscriptionsMissingBalance != null ? (flags | 16) : (flags & ~16);
        flags = history != null ? (flags | 8) : (flags & ~8);
        flags = nextOffset != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(balance, stream);
        if ((flags & 2) != 0) {
            if (subscriptions == null) throwNullFieldException("subscriptions", flags);
            writeTLVector(subscriptions, stream);
        }
        if ((flags & 4) != 0) {
            if (subscriptionsNextOffset == null) throwNullFieldException("subscriptionsNextOffset", flags);
            writeString(subscriptionsNextOffset, stream);
        }
        if ((flags & 16) != 0) {
            if (subscriptionsMissingBalance == null) throwNullFieldException("subscriptionsMissingBalance", flags);
            writeLong(subscriptionsMissingBalance, stream);
        }
        if ((flags & 8) != 0) {
            if (history == null) throwNullFieldException("history", flags);
            writeTLVector(history, stream);
        }
        if ((flags & 1) != 0) {
            if (nextOffset == null) throwNullFieldException("nextOffset", flags);
            writeString(nextOffset, stream);
        }
        writeTLVector(chats, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        balance = readTLObject(stream, context, TLStarsAmount.class, TLStarsAmount.CONSTRUCTOR_ID);
        subscriptions = (flags & 2) != 0 ? readTLVector(stream, context) : null;
        subscriptionsNextOffset = (flags & 4) != 0 ? readTLString(stream) : null;
        subscriptionsMissingBalance = (flags & 16) != 0 ? readLong(stream) : null;
        history = (flags & 8) != 0 ? readTLVector(stream, context) : null;
        nextOffset = (flags & 1) != 0 ? readTLString(stream) : null;
        chats = readTLVector(stream, context);
        users = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += balance.computeSerializedSize();
        if ((flags & 2) != 0) {
            if (subscriptions == null) throwNullFieldException("subscriptions", flags);
            size += subscriptions.computeSerializedSize();
        }
        if ((flags & 4) != 0) {
            if (subscriptionsNextOffset == null) throwNullFieldException("subscriptionsNextOffset", flags);
            size += computeTLStringSerializedSize(subscriptionsNextOffset);
        }
        if ((flags & 16) != 0) {
            if (subscriptionsMissingBalance == null) throwNullFieldException("subscriptionsMissingBalance", flags);
            size += SIZE_INT64;
        }
        if ((flags & 8) != 0) {
            if (history == null) throwNullFieldException("history", flags);
            size += history.computeSerializedSize();
        }
        if ((flags & 1) != 0) {
            if (nextOffset == null) throwNullFieldException("nextOffset", flags);
            size += computeTLStringSerializedSize(nextOffset);
        }
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

    public TLStarsAmount getBalance() {
        return balance;
    }

    public void setBalance(TLStarsAmount balance) {
        this.balance = balance;
    }

    public TLVector<TLStarsSubscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(TLVector<TLStarsSubscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public String getSubscriptionsNextOffset() {
        return subscriptionsNextOffset;
    }

    public void setSubscriptionsNextOffset(String subscriptionsNextOffset) {
        this.subscriptionsNextOffset = subscriptionsNextOffset;
    }

    public Long getSubscriptionsMissingBalance() {
        return subscriptionsMissingBalance;
    }

    public void setSubscriptionsMissingBalance(Long subscriptionsMissingBalance) {
        this.subscriptionsMissingBalance = subscriptionsMissingBalance;
    }

    public TLVector<TLStarsTransaction> getHistory() {
        return history;
    }

    public void setHistory(TLVector<TLStarsTransaction> history) {
        this.history = history;
    }

    public String getNextOffset() {
        return nextOffset;
    }

    public void setNextOffset(String nextOffset) {
        this.nextOffset = nextOffset;
    }

    public TLVector<TLAbsChat> getChats() {
        return chats;
    }

    public void setChats(TLVector<TLAbsChat> chats) {
        this.chats = chats;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }
}
