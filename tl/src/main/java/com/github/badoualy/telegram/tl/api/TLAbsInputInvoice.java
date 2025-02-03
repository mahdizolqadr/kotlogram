package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputInvoiceChatInviteSubscription}: inputInvoiceChatInviteSubscription#0</li>
 * <li>{@link TLInputInvoiceMessage}: inputInvoiceMessage#0</li>
 * <li>{@link TLInputInvoicePremiumGiftCode}: inputInvoicePremiumGiftCode#0</li>
 * <li>{@link TLInputInvoiceSlug}: inputInvoiceSlug#0</li>
 * <li>{@link TLInputInvoiceStarGift}: inputInvoiceStarGift#0</li>
 * <li>{@link TLInputInvoiceStars}: inputInvoiceStars#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsInputInvoice extends TLObject {
    public TLAbsInputInvoice() {
    }
}
