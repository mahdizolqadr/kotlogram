package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLPrivacyValueAllowAll}: privacyValueAllowAll#0</li>
 * <li>{@link TLPrivacyValueAllowBots}: privacyValueAllowBots#0</li>
 * <li>{@link TLPrivacyValueAllowChatParticipants}: privacyValueAllowChatParticipants#0</li>
 * <li>{@link TLPrivacyValueAllowCloseFriends}: privacyValueAllowCloseFriends#0</li>
 * <li>{@link TLPrivacyValueAllowContacts}: privacyValueAllowContacts#0</li>
 * <li>{@link TLPrivacyValueAllowPremium}: privacyValueAllowPremium#0</li>
 * <li>{@link TLPrivacyValueAllowUsers}: privacyValueAllowUsers#0</li>
 * <li>{@link TLPrivacyValueDisallowAll}: privacyValueDisallowAll#0</li>
 * <li>{@link TLPrivacyValueDisallowBots}: privacyValueDisallowBots#0</li>
 * <li>{@link TLPrivacyValueDisallowChatParticipants}: privacyValueDisallowChatParticipants#0</li>
 * <li>{@link TLPrivacyValueDisallowContacts}: privacyValueDisallowContacts#0</li>
 * <li>{@link TLPrivacyValueDisallowUsers}: privacyValueDisallowUsers#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsPrivacyRule extends TLObject {
    public TLAbsPrivacyRule() {
    }
}
