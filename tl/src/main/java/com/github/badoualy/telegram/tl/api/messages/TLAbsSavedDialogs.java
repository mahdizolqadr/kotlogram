package com.github.badoualy.telegram.tl.api.messages;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLSavedDialogs}: messages.savedDialogs#0</li>
 * <li>{@link TLSavedDialogsNotModified}: messages.savedDialogsNotModified#0</li>
 * <li>{@link TLSavedDialogsSlice}: messages.savedDialogsSlice#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsSavedDialogs extends TLObject {
    public TLAbsSavedDialogs() {
    }
}
