package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLRequestedPeerChannel}: requestedPeerChannel#0</li>
 * <li>{@link TLRequestedPeerChat}: requestedPeerChat#0</li>
 * <li>{@link TLRequestedPeerUser}: requestedPeerUser#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsRequestedPeer extends TLObject {
    protected int flags;

    protected TLAbsPhoto photo;

    public TLAbsRequestedPeer() {
    }

    public TLAbsPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(TLAbsPhoto photo) {
        this.photo = photo;
    }
}
