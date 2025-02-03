package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLBaseThemeArctic}: baseThemeArctic#0</li>
 * <li>{@link TLBaseThemeClassic}: baseThemeClassic#0</li>
 * <li>{@link TLBaseThemeDay}: baseThemeDay#0</li>
 * <li>{@link TLBaseThemeNight}: baseThemeNight#0</li>
 * <li>{@link TLBaseThemeTinted}: baseThemeTinted#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsBaseTheme extends TLObject {
    public TLAbsBaseTheme() {
    }
}
