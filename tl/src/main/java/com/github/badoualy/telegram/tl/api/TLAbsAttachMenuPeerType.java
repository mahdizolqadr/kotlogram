package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLAttachMenuPeerTypeBotPM}: attachMenuPeerTypeBotPM#0</li>
 * <li>{@link TLAttachMenuPeerTypeBroadcast}: attachMenuPeerTypeBroadcast#0</li>
 * <li>{@link TLAttachMenuPeerTypeChat}: attachMenuPeerTypeChat#0</li>
 * <li>{@link TLAttachMenuPeerTypePM}: attachMenuPeerTypePM#0</li>
 * <li>{@link TLAttachMenuPeerTypeSameBotPM}: attachMenuPeerTypeSameBotPM#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsAttachMenuPeerType extends TLObject {
    public TLAbsAttachMenuPeerType() {
    }
}
