package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLChatReactionsAll}: chatReactionsAll#0</li>
 * <li>{@link TLChatReactionsNone}: chatReactionsNone#0</li>
 * <li>{@link TLChatReactionsSome}: chatReactionsSome#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsChatReactions extends TLObject {
    public TLAbsChatReactions() {
    }
}
