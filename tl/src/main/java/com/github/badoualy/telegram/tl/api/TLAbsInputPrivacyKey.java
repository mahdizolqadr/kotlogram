package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputPrivacyKeyAbout}: inputPrivacyKeyAbout#0</li>
 * <li>{@link TLInputPrivacyKeyAddedByPhone}: inputPrivacyKeyAddedByPhone#0</li>
 * <li>{@link TLInputPrivacyKeyBirthday}: inputPrivacyKeyBirthday#0</li>
 * <li>{@link TLInputPrivacyKeyChatInvite}: inputPrivacyKeyChatInvite#0</li>
 * <li>{@link TLInputPrivacyKeyForwards}: inputPrivacyKeyForwards#0</li>
 * <li>{@link TLInputPrivacyKeyPhoneCall}: inputPrivacyKeyPhoneCall#0</li>
 * <li>{@link TLInputPrivacyKeyPhoneNumber}: inputPrivacyKeyPhoneNumber#0</li>
 * <li>{@link TLInputPrivacyKeyPhoneP2P}: inputPrivacyKeyPhoneP2P#0</li>
 * <li>{@link TLInputPrivacyKeyProfilePhoto}: inputPrivacyKeyProfilePhoto#0</li>
 * <li>{@link TLInputPrivacyKeyStarGiftsAutoSave}: inputPrivacyKeyStarGiftsAutoSave#0</li>
 * <li>{@link TLInputPrivacyKeyStatusTimestamp}: inputPrivacyKeyStatusTimestamp#0</li>
 * <li>{@link TLInputPrivacyKeyVoiceMessages}: inputPrivacyKeyVoiceMessages#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsInputPrivacyKey extends TLObject {
    public TLAbsInputPrivacyKey() {
    }
}
