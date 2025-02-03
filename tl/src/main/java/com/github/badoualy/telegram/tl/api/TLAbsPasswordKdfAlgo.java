package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLPasswordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow}: passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow#0</li>
 * <li>{@link TLPasswordKdfAlgoUnknown}: passwordKdfAlgoUnknown#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsPasswordKdfAlgo extends TLObject {
    public TLAbsPasswordKdfAlgo() {
    }
}
