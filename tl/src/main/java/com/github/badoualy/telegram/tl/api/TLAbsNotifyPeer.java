package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLNotifyBroadcasts}: notifyBroadcasts#0</li>
 * <li>{@link TLNotifyChats}: notifyChats#0</li>
 * <li>{@link TLNotifyForumTopic}: notifyForumTopic#0</li>
 * <li>{@link TLNotifyPeer}: notifyPeer#0</li>
 * <li>{@link TLNotifyUsers}: notifyUsers#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsNotifyPeer extends TLObject {
    public TLAbsNotifyPeer() {
    }
}
