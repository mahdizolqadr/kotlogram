package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLSecurePasswordKdfAlgoPBKDF2HMACSHA512iter100000}: securePasswordKdfAlgoPBKDF2HMACSHA512iter100000#0</li>
 * <li>{@link TLSecurePasswordKdfAlgoSHA512}: securePasswordKdfAlgoSHA512#0</li>
 * <li>{@link TLSecurePasswordKdfAlgoUnknown}: securePasswordKdfAlgoUnknown#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsSecurePasswordKdfAlgo extends TLObject {
    public TLAbsSecurePasswordKdfAlgo() {
    }
}
