package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLStoryView}: storyView#0</li>
 * <li>{@link TLStoryViewPublicForward}: storyViewPublicForward#0</li>
 * <li>{@link TLStoryViewPublicRepost}: storyViewPublicRepost#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsStoryView extends TLObject {
    protected int flags;

    protected boolean blocked;

    protected boolean blockedMyStoriesFrom;

    public TLAbsStoryView() {
    }

    public boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean getBlockedMyStoriesFrom() {
        return blockedMyStoriesFrom;
    }

    public void setBlockedMyStoriesFrom(boolean blockedMyStoriesFrom) {
        this.blockedMyStoriesFrom = blockedMyStoriesFrom;
    }
}
