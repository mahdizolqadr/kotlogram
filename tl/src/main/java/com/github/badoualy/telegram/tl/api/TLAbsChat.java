package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLChannel}: channel#0</li>
 * <li>{@link TLChannelForbidden}: channelForbidden#0</li>
 * <li>{@link TLChat}: chat#0</li>
 * <li>{@link TLChatEmpty}: chatEmpty#0</li>
 * <li>{@link TLChatForbidden}: chatForbidden#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsChat extends TLObject {
    protected long id;

    public TLAbsChat() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
