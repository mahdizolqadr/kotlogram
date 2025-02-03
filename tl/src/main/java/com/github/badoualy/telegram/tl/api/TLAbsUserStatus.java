package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLUserStatusEmpty}: userStatusEmpty#0</li>
 * <li>{@link TLUserStatusLastMonth}: userStatusLastMonth#0</li>
 * <li>{@link TLUserStatusLastWeek}: userStatusLastWeek#0</li>
 * <li>{@link TLUserStatusOffline}: userStatusOffline#0</li>
 * <li>{@link TLUserStatusOnline}: userStatusOnline#0</li>
 * <li>{@link TLUserStatusRecently}: userStatusRecently#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsUserStatus extends TLObject {
    public TLAbsUserStatus() {
    }
}
