package com.github.badoualy.telegram.tl.api.help;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLDeepLinkInfo}: help.deepLinkInfo#0</li>
 * <li>{@link TLDeepLinkInfoEmpty}: help.deepLinkInfoEmpty#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsDeepLinkInfo extends TLObject {
    public TLAbsDeepLinkInfo() {
    }

    public abstract boolean isEmpty();

    public abstract boolean isNotEmpty();

    public TLDeepLinkInfo getAsDeepLinkInfo() {
        return null;
    }
}
