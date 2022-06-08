package com.github.badoualy.telegram.tl.api.call;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLGroupCall}: phoneCall#ffe6ab67</li>
 * <li>{@link TLGroupCallDiscarded}: groupCallDiscarded#7780bcb4</li>
 * </ul>
 */
public abstract class TLAbsGroupCall extends TLObject {

    protected long id;
    protected long accessHash;

    protected TLAbsGroupCall() {
    }

    protected TLAbsGroupCall(long id, long accessHash) {
        this.id = id;
        this.accessHash = accessHash;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long accessHash) {
        this.accessHash = accessHash;
    }
}
