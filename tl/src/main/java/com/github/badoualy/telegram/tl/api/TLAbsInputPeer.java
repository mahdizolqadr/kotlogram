package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputPeerChannel}: inputPeerChannel#0</li>
 * <li>{@link TLInputPeerChannelFromMessage}: inputPeerChannelFromMessage#0</li>
 * <li>{@link TLInputPeerChat}: inputPeerChat#0</li>
 * <li>{@link TLInputPeerEmpty}: inputPeerEmpty#0</li>
 * <li>{@link TLInputPeerSelf}: inputPeerSelf#0</li>
 * <li>{@link TLInputPeerUser}: inputPeerUser#0</li>
 * <li>{@link TLInputPeerUserFromMessage}: inputPeerUserFromMessage#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsInputPeer extends TLObject {
    public TLAbsInputPeer() {
    }
}
