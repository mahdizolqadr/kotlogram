package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLPrivacyKeyAbout}: privacyKeyAbout#0</li>
 * <li>{@link TLPrivacyKeyAddedByPhone}: privacyKeyAddedByPhone#0</li>
 * <li>{@link TLPrivacyKeyBirthday}: privacyKeyBirthday#0</li>
 * <li>{@link TLPrivacyKeyChatInvite}: privacyKeyChatInvite#0</li>
 * <li>{@link TLPrivacyKeyForwards}: privacyKeyForwards#0</li>
 * <li>{@link TLPrivacyKeyPhoneCall}: privacyKeyPhoneCall#0</li>
 * <li>{@link TLPrivacyKeyPhoneNumber}: privacyKeyPhoneNumber#0</li>
 * <li>{@link TLPrivacyKeyPhoneP2P}: privacyKeyPhoneP2P#0</li>
 * <li>{@link TLPrivacyKeyProfilePhoto}: privacyKeyProfilePhoto#0</li>
 * <li>{@link TLPrivacyKeyStarGiftsAutoSave}: privacyKeyStarGiftsAutoSave#0</li>
 * <li>{@link TLPrivacyKeyStatusTimestamp}: privacyKeyStatusTimestamp#0</li>
 * <li>{@link TLPrivacyKeyVoiceMessages}: privacyKeyVoiceMessages#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsPrivacyKey extends TLObject {
    public TLAbsPrivacyKey() {
    }
}
