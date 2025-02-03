package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLNotificationSoundDefault}: notificationSoundDefault#0</li>
 * <li>{@link TLNotificationSoundLocal}: notificationSoundLocal#0</li>
 * <li>{@link TLNotificationSoundNone}: notificationSoundNone#0</li>
 * <li>{@link TLNotificationSoundRingtone}: notificationSoundRingtone#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsNotificationSound extends TLObject {
    public TLAbsNotificationSound() {
    }
}
