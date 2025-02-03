package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputPaymentCredentials}: inputPaymentCredentials#0</li>
 * <li>{@link TLInputPaymentCredentialsApplePay}: inputPaymentCredentialsApplePay#0</li>
 * <li>{@link TLInputPaymentCredentialsGooglePay}: inputPaymentCredentialsGooglePay#0</li>
 * <li>{@link TLInputPaymentCredentialsSaved}: inputPaymentCredentialsSaved#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsInputPaymentCredentials extends TLObject {
    public TLAbsInputPaymentCredentials() {
    }
}
