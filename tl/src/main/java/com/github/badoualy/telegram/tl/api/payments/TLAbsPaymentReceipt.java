package com.github.badoualy.telegram.tl.api.payments;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.api.TLAbsWebDocument;
import com.github.badoualy.telegram.tl.api.TLInvoice;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
import java.lang.String;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLPaymentReceipt}: payments.paymentReceipt#0</li>
 * <li>{@link TLPaymentReceiptStars}: payments.paymentReceiptStars#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsPaymentReceipt extends TLObject {
    protected int flags;

    protected int date;

    protected long botId;

    protected String title;

    protected String description;

    protected TLAbsWebDocument photo;

    protected TLInvoice invoice;

    protected String currency;

    protected long totalAmount;

    protected TLVector<TLAbsUser> users;

    public TLAbsPaymentReceipt() {
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }
}
