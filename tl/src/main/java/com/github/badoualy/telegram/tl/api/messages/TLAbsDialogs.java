package com.github.badoualy.telegram.tl.api.messages;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLDialogs}: messages.dialogs#0</li>
 * <li>{@link TLDialogsNotModified}: messages.dialogsNotModified#0</li>
 * <li>{@link TLDialogsSlice}: messages.dialogsSlice#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsDialogs extends TLObject {
    public TLAbsDialogs() {
    }
}
