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
public class TLStarsSubscription extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean canceled;

    protected boolean canRefulfill;

    protected boolean missingBalance;

    protected boolean botCanceled;

    protected String id;

    protected TLAbsPeer peer;

    protected int untilDate;

    protected TLStarsSubscriptionPricing pricing;

    protected String chatInviteHash;

    protected String title;

    protected TLAbsWebDocument photo;

    protected String invoiceSlug;

    private final String _constructor = "starsSubscription#0";

    public TLStarsSubscription() {
    }

    public TLStarsSubscription(boolean canceled, boolean canRefulfill, boolean missingBalance, boolean botCanceled, String id, TLAbsPeer peer, int untilDate, TLStarsSubscriptionPricing pricing, String chatInviteHash, String title, TLAbsWebDocument photo, String invoiceSlug) {
        this.canceled = canceled;
        this.canRefulfill = canRefulfill;
        this.missingBalance = missingBalance;
        this.botCanceled = botCanceled;
        this.id = id;
        this.peer = peer;
        this.untilDate = untilDate;
        this.pricing = pricing;
        this.chatInviteHash = chatInviteHash;
        this.title = title;
        this.photo = photo;
        this.invoiceSlug = invoiceSlug;
    }

    private void computeFlags() {
        flags = 0;
        flags = canceled ? (flags | 1) : (flags & ~1);
        flags = canRefulfill ? (flags | 2) : (flags & ~2);
        flags = missingBalance ? (flags | 4) : (flags & ~4);
        flags = botCanceled ? (flags | 128) : (flags & ~128);
        flags = chatInviteHash != null ? (flags | 8) : (flags & ~8);
        flags = title != null ? (flags | 16) : (flags & ~16);
        flags = photo != null ? (flags | 32) : (flags & ~32);
        flags = invoiceSlug != null ? (flags | 64) : (flags & ~64);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(id, stream);
        writeTLObject(peer, stream);
        writeInt(untilDate, stream);
        writeTLObject(pricing, stream);
        if ((flags & 8) != 0) {
            if (chatInviteHash == null) throwNullFieldException("chatInviteHash", flags);
            writeString(chatInviteHash, stream);
        }
        if ((flags & 16) != 0) {
            if (title == null) throwNullFieldException("title", flags);
            writeString(title, stream);
        }
        if ((flags & 32) != 0) {
            if (photo == null) throwNullFieldException("photo", flags);
            writeTLObject(photo, stream);
        }
        if ((flags & 64) != 0) {
            if (invoiceSlug == null) throwNullFieldException("invoiceSlug", flags);
            writeString(invoiceSlug, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        canceled = (flags & 1) != 0;
        canRefulfill = (flags & 2) != 0;
        missingBalance = (flags & 4) != 0;
        botCanceled = (flags & 128) != 0;
        id = readTLString(stream);
        peer = readTLObject(stream, context, TLAbsPeer.class, -1);
        untilDate = readInt(stream);
        pricing = readTLObject(stream, context, TLStarsSubscriptionPricing.class, TLStarsSubscriptionPricing.CONSTRUCTOR_ID);
        chatInviteHash = (flags & 8) != 0 ? readTLString(stream) : null;
        title = (flags & 16) != 0 ? readTLString(stream) : null;
        photo = (flags & 32) != 0 ? readTLObject(stream, context, TLAbsWebDocument.class, -1) : null;
        invoiceSlug = (flags & 64) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(id);
        size += peer.computeSerializedSize();
        size += SIZE_INT32;
        size += pricing.computeSerializedSize();
        if ((flags & 8) != 0) {
            if (chatInviteHash == null) throwNullFieldException("chatInviteHash", flags);
            size += computeTLStringSerializedSize(chatInviteHash);
        }
        if ((flags & 16) != 0) {
            if (title == null) throwNullFieldException("title", flags);
            size += computeTLStringSerializedSize(title);
        }
        if ((flags & 32) != 0) {
            if (photo == null) throwNullFieldException("photo", flags);
            size += photo.computeSerializedSize();
        }
        if ((flags & 64) != 0) {
            if (invoiceSlug == null) throwNullFieldException("invoiceSlug", flags);
            size += computeTLStringSerializedSize(invoiceSlug);
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

    public boolean getCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    public boolean getCanRefulfill() {
        return canRefulfill;
    }

    public void setCanRefulfill(boolean canRefulfill) {
        this.canRefulfill = canRefulfill;
    }

    public boolean getMissingBalance() {
        return missingBalance;
    }

    public void setMissingBalance(boolean missingBalance) {
        this.missingBalance = missingBalance;
    }

    public boolean getBotCanceled() {
        return botCanceled;
    }

    public void setBotCanceled(boolean botCanceled) {
        this.botCanceled = botCanceled;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TLAbsPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsPeer peer) {
        this.peer = peer;
    }

    public int getUntilDate() {
        return untilDate;
    }

    public void setUntilDate(int untilDate) {
        this.untilDate = untilDate;
    }

    public TLStarsSubscriptionPricing getPricing() {
        return pricing;
    }

    public void setPricing(TLStarsSubscriptionPricing pricing) {
        this.pricing = pricing;
    }

    public String getChatInviteHash() {
        return chatInviteHash;
    }

    public void setChatInviteHash(String chatInviteHash) {
        this.chatInviteHash = chatInviteHash;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TLAbsWebDocument getPhoto() {
        return photo;
    }

    public void setPhoto(TLAbsWebDocument photo) {
        this.photo = photo;
    }

    public String getInvoiceSlug() {
        return invoiceSlug;
    }

    public void setInvoiceSlug(String invoiceSlug) {
        this.invoiceSlug = invoiceSlug;
    }
}
