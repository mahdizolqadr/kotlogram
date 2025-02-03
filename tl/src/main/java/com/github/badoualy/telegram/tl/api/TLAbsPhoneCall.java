package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLPhoneCall}: phoneCall#0</li>
 * <li>{@link TLPhoneCallAccepted}: phoneCallAccepted#0</li>
 * <li>{@link TLPhoneCallDiscarded}: phoneCallDiscarded#0</li>
 * <li>{@link TLPhoneCallEmpty}: phoneCallEmpty#0</li>
 * <li>{@link TLPhoneCallRequested}: phoneCallRequested#0</li>
 * <li>{@link TLPhoneCallWaiting}: phoneCallWaiting#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsPhoneCall extends TLObject {
    protected long id;

    public TLAbsPhoneCall() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
