package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputMessageCallbackQuery}: inputMessageCallbackQuery#0</li>
 * <li>{@link TLInputMessageID}: inputMessageID#0</li>
 * <li>{@link TLInputMessagePinned}: inputMessagePinned#0</li>
 * <li>{@link TLInputMessageReplyTo}: inputMessageReplyTo#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsInputMessage extends TLObject {
    public TLAbsInputMessage() {
    }
}
