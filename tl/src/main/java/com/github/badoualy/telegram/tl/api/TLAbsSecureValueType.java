package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLSecureValueTypeAddress}: secureValueTypeAddress#0</li>
 * <li>{@link TLSecureValueTypeBankStatement}: secureValueTypeBankStatement#0</li>
 * <li>{@link TLSecureValueTypeDriverLicense}: secureValueTypeDriverLicense#0</li>
 * <li>{@link TLSecureValueTypeEmail}: secureValueTypeEmail#0</li>
 * <li>{@link TLSecureValueTypeIdentityCard}: secureValueTypeIdentityCard#0</li>
 * <li>{@link TLSecureValueTypeInternalPassport}: secureValueTypeInternalPassport#0</li>
 * <li>{@link TLSecureValueTypePassport}: secureValueTypePassport#0</li>
 * <li>{@link TLSecureValueTypePassportRegistration}: secureValueTypePassportRegistration#0</li>
 * <li>{@link TLSecureValueTypePersonalDetails}: secureValueTypePersonalDetails#0</li>
 * <li>{@link TLSecureValueTypePhone}: secureValueTypePhone#0</li>
 * <li>{@link TLSecureValueTypeRentalAgreement}: secureValueTypeRentalAgreement#0</li>
 * <li>{@link TLSecureValueTypeTemporaryRegistration}: secureValueTypeTemporaryRegistration#0</li>
 * <li>{@link TLSecureValueTypeUtilityBill}: secureValueTypeUtilityBill#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsSecureValueType extends TLObject {
    public TLAbsSecureValueType() {
    }
}
