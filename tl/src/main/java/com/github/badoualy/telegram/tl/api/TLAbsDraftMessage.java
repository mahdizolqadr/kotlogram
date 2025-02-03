package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLDraftMessage}: draftMessage#0</li>
 * <li>{@link TLDraftMessageEmpty}: draftMessageEmpty#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsDraftMessage extends TLObject {
    protected int flags;

    public TLAbsDraftMessage() {
    }

    public abstract boolean isEmpty();

    public abstract boolean isNotEmpty();

    public TLDraftMessage getAsDraftMessage() {
        return null;
    }
}
