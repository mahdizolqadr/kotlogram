package com.github.badoualy.telegram.tl.api.messages;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLChannelMessages}: messages.channelMessages#0</li>
 * <li>{@link TLMessages}: messages.messages#0</li>
 * <li>{@link TLMessagesNotModified}: messages.messagesNotModified#0</li>
 * <li>{@link TLMessagesSlice}: messages.messagesSlice#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsMessages extends TLObject {
    public TLAbsMessages() {
    }
}
