package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLUpdateShort}: updateShort#0</li>
 * <li>{@link TLUpdateShortChatMessage}: updateShortChatMessage#0</li>
 * <li>{@link TLUpdateShortMessage}: updateShortMessage#0</li>
 * <li>{@link TLUpdateShortSentMessage}: updateShortSentMessage#0</li>
 * <li>{@link TLUpdates}: updates#0</li>
 * <li>{@link TLUpdatesCombined}: updatesCombined#0</li>
 * <li>{@link TLUpdatesTooLong}: updatesTooLong#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsUpdates extends TLObject {
    public TLAbsUpdates() {
    }
}
