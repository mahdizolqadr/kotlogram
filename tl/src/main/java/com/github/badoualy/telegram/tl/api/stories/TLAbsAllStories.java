package com.github.badoualy.telegram.tl.api.stories;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.api.TLStoriesStealthMode;
import com.github.badoualy.telegram.tl.core.TLObject;
import java.lang.String;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLAllStories}: stories.allStories#0</li>
 * <li>{@link TLAllStoriesNotModified}: stories.allStoriesNotModified#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsAllStories extends TLObject {
    protected int flags;

    protected String state;

    protected TLStoriesStealthMode stealthMode;

    public TLAbsAllStories() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public TLStoriesStealthMode getStealthMode() {
        return stealthMode;
    }

    public void setStealthMode(TLStoriesStealthMode stealthMode) {
        this.stealthMode = stealthMode;
    }
}
