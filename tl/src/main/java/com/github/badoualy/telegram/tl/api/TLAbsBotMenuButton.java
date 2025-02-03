package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLBotMenuButton}: botMenuButton#0</li>
 * <li>{@link TLBotMenuButtonCommands}: botMenuButtonCommands#0</li>
 * <li>{@link TLBotMenuButtonDefault}: botMenuButtonDefault#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsBotMenuButton extends TLObject {
    public TLAbsBotMenuButton() {
    }
}
