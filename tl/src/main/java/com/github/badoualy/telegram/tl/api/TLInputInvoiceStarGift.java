package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLInputInvoiceStarGift extends TLAbsInputInvoice {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean hideName;

    protected TLAbsInputUser userId;

    protected long giftId;

    protected TLTextWithEntities message;

    private final String _constructor = "inputInvoiceStarGift#0";

    public TLInputInvoiceStarGift() {
    }

    public TLInputInvoiceStarGift(boolean hideName, TLAbsInputUser userId, long giftId, TLTextWithEntities message) {
        this.hideName = hideName;
        this.userId = userId;
        this.giftId = giftId;
        this.message = message;
    }

    private void computeFlags() {
        flags = 0;
        flags = hideName ? (flags | 1) : (flags & ~1);
        flags = message != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(userId, stream);
        writeLong(giftId, stream);
        if ((flags & 2) != 0) {
            if (message == null) throwNullFieldException("message", flags);
            writeTLObject(message, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        hideName = (flags & 1) != 0;
        userId = readTLObject(stream, context, TLAbsInputUser.class, -1);
        giftId = readLong(stream);
        message = (flags & 2) != 0 ? readTLObject(stream, context, TLTextWithEntities.class, TLTextWithEntities.CONSTRUCTOR_ID) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += userId.computeSerializedSize();
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

    public boolean getHideName() {
        return hideName;
    }

    public void setHideName(boolean hideName) {
        this.hideName = hideName;
    }

    public TLAbsInputUser getUserId() {
        return userId;
    }

    public void setUserId(TLAbsInputUser userId) {
        this.userId = userId;
    }

    public long getGiftId() {
        return giftId;
    }

    public void setGiftId(long giftId) {
        this.giftId = giftId;
    }

    public TLTextWithEntities getMessage() {
        return message;
    }

    public void setMessage(TLTextWithEntities message) {
        this.message = message;
    }
}
