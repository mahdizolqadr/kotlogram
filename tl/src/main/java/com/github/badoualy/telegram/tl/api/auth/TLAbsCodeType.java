package com.github.badoualy.telegram.tl.api.auth;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLCodeTypeCall}: auth.codeTypeCall#0</li>
 * <li>{@link TLCodeTypeFlashCall}: auth.codeTypeFlashCall#0</li>
 * <li>{@link TLCodeTypeFragmentSms}: auth.codeTypeFragmentSms#0</li>
 * <li>{@link TLCodeTypeMissedCall}: auth.codeTypeMissedCall#0</li>
 * <li>{@link TLCodeTypeSms}: auth.codeTypeSms#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsCodeType extends TLObject {
    public TLAbsCodeType() {
    }
}
