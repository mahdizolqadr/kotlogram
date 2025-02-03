package com.github.badoualy.telegram.tl.api.help;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLUserInfo}: help.userInfo#0</li>
 * <li>{@link TLUserInfoEmpty}: help.userInfoEmpty#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsUserInfo extends TLObject {
    public TLAbsUserInfo() {
    }

    public abstract boolean isEmpty();

    public abstract boolean isNotEmpty();

    public TLUserInfo getAsUserInfo() {
        return null;
    }
}
