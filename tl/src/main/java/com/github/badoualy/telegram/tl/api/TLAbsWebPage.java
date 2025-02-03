package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLWebPage}: webPage#0</li>
 * <li>{@link TLWebPageEmpty}: webPageEmpty#0</li>
 * <li>{@link TLWebPageNotModified}: webPageNotModified#0</li>
 * <li>{@link TLWebPagePending}: webPagePending#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsWebPage extends TLObject {
    protected int flags;

    public TLAbsWebPage() {
    }
}
