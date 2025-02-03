package com.github.badoualy.telegram.tl.api.auth;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLLoginToken}: auth.loginToken#0</li>
 * <li>{@link TLLoginTokenMigrateTo}: auth.loginTokenMigrateTo#0</li>
 * <li>{@link TLLoginTokenSuccess}: auth.loginTokenSuccess#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsLoginToken extends TLObject {
    public TLAbsLoginToken() {
    }
}
