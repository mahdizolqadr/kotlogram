package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLStarsTransactionPeer}: starsTransactionPeer#0</li>
 * <li>{@link TLStarsTransactionPeerAPI}: starsTransactionPeerAPI#0</li>
 * <li>{@link TLStarsTransactionPeerAds}: starsTransactionPeerAds#0</li>
 * <li>{@link TLStarsTransactionPeerAppStore}: starsTransactionPeerAppStore#0</li>
 * <li>{@link TLStarsTransactionPeerFragment}: starsTransactionPeerFragment#0</li>
 * <li>{@link TLStarsTransactionPeerPlayMarket}: starsTransactionPeerPlayMarket#0</li>
 * <li>{@link TLStarsTransactionPeerPremiumBot}: starsTransactionPeerPremiumBot#0</li>
 * <li>{@link TLStarsTransactionPeerUnsupported}: starsTransactionPeerUnsupported#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsStarsTransactionPeer extends TLObject {
    public TLAbsStarsTransactionPeer() {
    }
}
