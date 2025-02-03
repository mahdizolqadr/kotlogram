package com.github.badoualy.telegram.tl.api.auth;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLSentCodeTypeApp}: auth.sentCodeTypeApp#0</li>
 * <li>{@link TLSentCodeTypeCall}: auth.sentCodeTypeCall#0</li>
 * <li>{@link TLSentCodeTypeEmailCode}: auth.sentCodeTypeEmailCode#0</li>
 * <li>{@link TLSentCodeTypeFirebaseSms}: auth.sentCodeTypeFirebaseSms#0</li>
 * <li>{@link TLSentCodeTypeFlashCall}: auth.sentCodeTypeFlashCall#0</li>
 * <li>{@link TLSentCodeTypeFragmentSms}: auth.sentCodeTypeFragmentSms#0</li>
 * <li>{@link TLSentCodeTypeMissedCall}: auth.sentCodeTypeMissedCall#0</li>
 * <li>{@link TLSentCodeTypeSetUpEmailRequired}: auth.sentCodeTypeSetUpEmailRequired#0</li>
 * <li>{@link TLSentCodeTypeSms}: auth.sentCodeTypeSms#0</li>
 * <li>{@link TLSentCodeTypeSmsPhrase}: auth.sentCodeTypeSmsPhrase#0</li>
 * <li>{@link TLSentCodeTypeSmsWord}: auth.sentCodeTypeSmsWord#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsSentCodeType extends TLObject {
    public TLAbsSentCodeType() {
    }
}
