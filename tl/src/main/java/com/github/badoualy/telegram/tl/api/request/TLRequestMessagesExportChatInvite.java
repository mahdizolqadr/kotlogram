package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLStarsSubscriptionPricing;
import com.github.badoualy.telegram.tl.core.TLMethod;
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
public class TLRequestMessagesExportChatInvite extends TLMethod<TLAbsExportedChatInvite> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean legacyRevokePermanent;

    protected boolean requestNeeded;

    protected TLAbsInputPeer peer;

    protected Integer expireDate;

    protected Integer usageLimit;

    protected String title;

    protected TLStarsSubscriptionPricing subscriptionPricing;

    private final String _constructor = "messages.exportChatInvite#0";

    public TLRequestMessagesExportChatInvite() {
    }

    public TLRequestMessagesExportChatInvite(boolean legacyRevokePermanent, boolean requestNeeded, TLAbsInputPeer peer, Integer expireDate, Integer usageLimit, String title, TLStarsSubscriptionPricing subscriptionPricing) {
        this.legacyRevokePermanent = legacyRevokePermanent;
        this.requestNeeded = requestNeeded;
        this.peer = peer;
        this.expireDate = expireDate;
        this.usageLimit = usageLimit;
        this.title = title;
        this.subscriptionPricing = subscriptionPricing;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsExportedChatInvite deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsExportedChatInvite)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsExportedChatInvite) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = legacyRevokePermanent ? (flags | 4) : (flags & ~4);
        flags = requestNeeded ? (flags | 8) : (flags & ~8);
        flags = expireDate != null ? (flags | 1) : (flags & ~1);
        flags = usageLimit != null ? (flags | 2) : (flags & ~2);
        flags = title != null ? (flags | 16) : (flags & ~16);
        flags = subscriptionPricing != null ? (flags | 32) : (flags & ~32);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peer, stream);
        if ((flags & 1) != 0) {
            if (expireDate == null) throwNullFieldException("expireDate", flags);
            writeInt(expireDate, stream);
        }
        if ((flags & 2) != 0) {
            if (usageLimit == null) throwNullFieldException("usageLimit", flags);
            writeInt(usageLimit, stream);
        }
        if ((flags & 16) != 0) {
            if (title == null) throwNullFieldException("title", flags);
            writeString(title, stream);
        }
        if ((flags & 32) != 0) {
            if (subscriptionPricing == null) throwNullFieldException("subscriptionPricing", flags);
            writeTLObject(subscriptionPricing, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        legacyRevokePermanent = (flags & 4) != 0;
        requestNeeded = (flags & 8) != 0;
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        expireDate = (flags & 1) != 0 ? readInt(stream) : null;
        usageLimit = (flags & 2) != 0 ? readInt(stream) : null;
        title = (flags & 16) != 0 ? readTLString(stream) : null;
        subscriptionPricing = (flags & 32) != 0 ? readTLObject(stream, context, TLStarsSubscriptionPricing.class, TLStarsSubscriptionPricing.CONSTRUCTOR_ID) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (expireDate == null) throwNullFieldException("expireDate", flags);
            size += SIZE_INT32;
        }
        if ((flags & 2) != 0) {
            if (usageLimit == null) throwNullFieldException("usageLimit", flags);
            size += SIZE_INT32;
        }
        if ((flags & 16) != 0) {
            if (title == null) throwNullFieldException("title", flags);
            size += computeTLStringSerializedSize(title);
        }
        if ((flags & 32) != 0) {
            if (subscriptionPricing == null) throwNullFieldException("subscriptionPricing", flags);
            size += subscriptionPricing.computeSerializedSize();
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

    public boolean getLegacyRevokePermanent() {
        return legacyRevokePermanent;
    }

    public void setLegacyRevokePermanent(boolean legacyRevokePermanent) {
        this.legacyRevokePermanent = legacyRevokePermanent;
    }

    public boolean getRequestNeeded() {
        return requestNeeded;
    }

    public void setRequestNeeded(boolean requestNeeded) {
        this.requestNeeded = requestNeeded;
    }

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public Integer getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Integer expireDate) {
        this.expireDate = expireDate;
    }

    public Integer getUsageLimit() {
        return usageLimit;
    }

    public void setUsageLimit(Integer usageLimit) {
        this.usageLimit = usageLimit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TLStarsSubscriptionPricing getSubscriptionPricing() {
        return subscriptionPricing;
    }

    public void setSubscriptionPricing(TLStarsSubscriptionPricing subscriptionPricing) {
        this.subscriptionPricing = subscriptionPricing;
    }
}
