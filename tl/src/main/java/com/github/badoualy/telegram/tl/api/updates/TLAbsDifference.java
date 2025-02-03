package com.github.badoualy.telegram.tl.api.updates;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLDifference}: updates.difference#0</li>
 * <li>{@link TLDifferenceEmpty}: updates.differenceEmpty#0</li>
 * <li>{@link TLDifferenceSlice}: updates.differenceSlice#0</li>
 * <li>{@link TLDifferenceTooLong}: updates.differenceTooLong#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsDifference extends TLObject {
    public TLAbsDifference() {
    }
}
