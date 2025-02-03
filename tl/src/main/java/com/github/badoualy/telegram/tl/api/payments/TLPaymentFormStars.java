package com.github.badoualy.telegram.tl.api.payments;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.api.TLAbsWebDocument;
import com.github.badoualy.telegram.tl.api.TLInvoice;
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
public class TLPaymentFormStars extends TLAbsPaymentForm {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected long botId;

    protected String title;

    protected String description;

    protected TLAbsWebDocument photo;

    protected TLVector<TLAbsUser> users;

    private final String _constructor = "payments.paymentFormStars#0";

    public TLPaymentFormStars() {
    }

    public TLPaymentFormStars(long formId, long botId, String title, String description, TLAbsWebDocument photo, TLInvoice invoice, TLVector<TLAbsUser> users) {
        this.formId = formId;
        this.botId = botId;
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.invoice = invoice;
        this.users = users;
    }

    private void computeFlags() {
        flags = 0;
        flags = photo != null ? (flags | 32) : (flags & ~32);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(formId, stream);
        writeLong(botId, stream);
        writeString(title, stream);
        writeString(description, stream);
        if ((flags & 32) != 0) {
            if (photo == null) throwNullFieldException("photo", flags);
            writeTLObject(photo, stream);
        }
        writeTLObject(invoice, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        formId = readLong(stream);
        botId = readLong(stream);
        title = readTLString(stream);
        description = readTLString(stream);
        photo = (flags & 32) != 0 ? readTLObject(stream, context, TLAbsWebDocument.class, -1) : null;
        invoice = readTLObject(stream, context, TLInvoice.class, TLInvoice.CONSTRUCTOR_ID);
        users = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(title);
        size += computeTLStringSerializedSize(description);
        if ((flags & 32) != 0) {
            if (photo == null) throwNullFieldException("photo", flags);
            size += photo.computeSerializedSize();
        }
        size += invoice.computeSerializedSize();
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

    public long getFormId() {
        return formId;
    }

    public void setFormId(long formId) {
        this.formId = formId;
    }

    public long getBotId() {
        return botId;
    }

    public void setBotId(long botId) {
        this.botId = botId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TLAbsWebDocument getPhoto() {
        return photo;
    }

    public void setPhoto(TLAbsWebDocument photo) {
        this.photo = photo;
    }

    public TLInvoice getInvoice() {
        return invoice;
    }

    public void setInvoice(TLInvoice invoice) {
        this.invoice = invoice;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }
}
