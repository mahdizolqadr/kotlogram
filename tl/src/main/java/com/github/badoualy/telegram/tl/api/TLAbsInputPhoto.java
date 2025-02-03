package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputPhoto}: inputPhoto#0</li>
 * <li>{@link TLInputPhotoEmpty}: inputPhotoEmpty#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsInputPhoto extends TLObject {
    public TLAbsInputPhoto() {
    }

    public abstract boolean isEmpty();

    public abstract boolean isNotEmpty();

    public TLInputPhoto getAsInputPhoto() {
        return null;
    }

    public static TLInputPhotoEmpty newEmpty() {
        return new TLInputPhotoEmpty();
    }

    public static TLInputPhoto newNotEmpty() {
        return new TLInputPhoto();
    }
}
