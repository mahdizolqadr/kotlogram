package com.github.badoualy.telegram.tl.api.peer;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputPeerChannel}: inputPeerChannel#20adaef8</li>
 * <li>{@link TLInputPeerChannelFromMessage}: inputPeerChannelFromMessage#bd2a0840</li>
 * <li>{@link TLInputPeerChat}: inputPeerChat#35a95cb9</li>
 * <li>{@link TLInputPeerEmpty}: inputPeerEmpty#7f3b18ea</li>
 * <li>{@link TLInputPeerSelf}: inputPeerSelf#7da07ec9</li>
 * <li>{@link TLInputPeerUser}: inputPeerUser#7b8e7de6</li>
 * <li>{@link TLInputPeerUserFromMessage}: inputPeerUserFromMessage#a87b0a1c</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsInputPeer extends TLObject {

    protected TLAbsInputPeer() {
    }
}
