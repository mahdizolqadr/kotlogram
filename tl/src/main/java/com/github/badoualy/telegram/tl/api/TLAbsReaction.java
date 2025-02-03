package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLReactionCustomEmoji}: reactionCustomEmoji#0</li>
 * <li>{@link TLReactionEmoji}: reactionEmoji#0</li>
 * <li>{@link TLReactionEmpty}: reactionEmpty#0</li>
 * <li>{@link TLReactionPaid}: reactionPaid#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsReaction extends TLObject {
    public TLAbsReaction() {
    }
}
