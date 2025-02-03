package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInlineQueryPeerTypeBotPM}: inlineQueryPeerTypeBotPM#0</li>
 * <li>{@link TLInlineQueryPeerTypeBroadcast}: inlineQueryPeerTypeBroadcast#0</li>
 * <li>{@link TLInlineQueryPeerTypeChat}: inlineQueryPeerTypeChat#0</li>
 * <li>{@link TLInlineQueryPeerTypeMegagroup}: inlineQueryPeerTypeMegagroup#0</li>
 * <li>{@link TLInlineQueryPeerTypePM}: inlineQueryPeerTypePM#0</li>
 * <li>{@link TLInlineQueryPeerTypeSameBotPM}: inlineQueryPeerTypeSameBotPM#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsInlineQueryPeerType extends TLObject {
    public TLAbsInlineQueryPeerType() {
    }
}
