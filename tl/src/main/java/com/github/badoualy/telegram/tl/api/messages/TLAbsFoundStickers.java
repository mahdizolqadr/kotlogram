package com.github.badoualy.telegram.tl.api.messages;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;
import java.lang.Integer;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLFoundStickers}: messages.foundStickers#0</li>
 * <li>{@link TLFoundStickersNotModified}: messages.foundStickersNotModified#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsFoundStickers extends TLObject {
    protected int flags;

    protected Integer nextOffset;

    public TLAbsFoundStickers() {
    }

    public Integer getNextOffset() {
        return nextOffset;
    }

    public void setNextOffset(Integer nextOffset) {
        this.nextOffset = nextOffset;
    }
}
