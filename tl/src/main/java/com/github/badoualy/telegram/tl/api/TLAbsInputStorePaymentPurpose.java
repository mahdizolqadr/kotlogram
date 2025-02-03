package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputStorePaymentGiftPremium}: inputStorePaymentGiftPremium#0</li>
 * <li>{@link TLInputStorePaymentPremiumGiftCode}: inputStorePaymentPremiumGiftCode#0</li>
 * <li>{@link TLInputStorePaymentPremiumGiveaway}: inputStorePaymentPremiumGiveaway#0</li>
 * <li>{@link TLInputStorePaymentPremiumSubscription}: inputStorePaymentPremiumSubscription#0</li>
 * <li>{@link TLInputStorePaymentStarsGift}: inputStorePaymentStarsGift#0</li>
 * <li>{@link TLInputStorePaymentStarsGiveaway}: inputStorePaymentStarsGiveaway#0</li>
 * <li>{@link TLInputStorePaymentStarsTopup}: inputStorePaymentStarsTopup#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsInputStorePaymentPurpose extends TLObject {
    public TLAbsInputStorePaymentPurpose() {
    }
}
