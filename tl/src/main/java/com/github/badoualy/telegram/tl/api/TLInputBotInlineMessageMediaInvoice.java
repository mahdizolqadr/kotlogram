package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
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
public class TLInputBotInlineMessageMediaInvoice extends TLAbsInputBotInlineMessage {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected String title;

    protected String description;

    protected TLInputWebDocument photo;

    protected TLInvoice invoice;

    protected TLBytes payload;

    protected String provider;

    protected TLDataJSON providerData;

    private final String _constructor = "inputBotInlineMessageMediaInvoice#0";

    public TLInputBotInlineMessageMediaInvoice() {
    }

    public TLInputBotInlineMessageMediaInvoice(String title, String description, TLInputWebDocument photo, TLInvoice invoice, TLBytes payload, String provider, TLDataJSON providerData, TLAbsReplyMarkup replyMarkup) {
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.invoice = invoice;
        this.payload = payload;
        this.provider = provider;
        this.providerData = providerData;
        this.replyMarkup = replyMarkup;
    }

    private void computeFlags() {
        flags = 0;
        flags = photo != null ? (flags | 1) : (flags & ~1);
        flags = replyMarkup != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(title, stream);
        writeString(description, stream);
        if ((flags & 1) != 0) {
            if (photo == null) throwNullFieldException("photo", flags);
            writeTLObject(photo, stream);
        }
        writeTLObject(invoice, stream);
        writeTLBytes(payload, stream);
        writeString(provider, stream);
        writeTLObject(providerData, stream);
        if ((flags & 4) != 0) {
            if (replyMarkup == null) throwNullFieldException("replyMarkup", flags);
            writeTLObject(replyMarkup, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        title = readTLString(stream);
        description = readTLString(stream);
        photo = (flags & 1) != 0 ? readTLObject(stream, context, TLInputWebDocument.class, TLInputWebDocument.CONSTRUCTOR_ID) : null;
        invoice = readTLObject(stream, context, TLInvoice.class, TLInvoice.CONSTRUCTOR_ID);
        payload = readTLBytes(stream, context);
        provider = readTLString(stream);
        providerData = readTLObject(stream, context, TLDataJSON.class, TLDataJSON.CONSTRUCTOR_ID);
        replyMarkup = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsReplyMarkup.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(title);
        size += computeTLStringSerializedSize(description);
        if ((flags & 1) != 0) {
            if (photo == null) throwNullFieldException("photo", flags);
            size += photo.computeSerializedSize();
        }
        size += invoice.computeSerializedSize();
        size += computeTLBytesSerializedSize(payload);
        size += computeTLStringSerializedSize(provider);
        size += providerData.computeSerializedSize();
        if ((flags & 4) != 0) {
            if (replyMarkup == null) throwNullFieldException("replyMarkup", flags);
            size += replyMarkup.computeSerializedSize();
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

    public TLInputWebDocument getPhoto() {
        return photo;
    }

    public void setPhoto(TLInputWebDocument photo) {
        this.photo = photo;
    }

    public TLInvoice getInvoice() {
        return invoice;
    }

    public void setInvoice(TLInvoice invoice) {
        this.invoice = invoice;
    }

    public TLBytes getPayload() {
        return payload;
    }

    public void setPayload(TLBytes payload) {
        this.payload = payload;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public TLDataJSON getProviderData() {
        return providerData;
    }

    public void setProviderData(TLDataJSON providerData) {
        this.providerData = providerData;
    }

    public TLAbsReplyMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public void setReplyMarkup(TLAbsReplyMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
    }
}
