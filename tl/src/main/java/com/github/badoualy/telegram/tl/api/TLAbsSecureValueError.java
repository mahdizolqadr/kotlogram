package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;
import java.lang.String;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLSecureValueError}: secureValueError#0</li>
 * <li>{@link TLSecureValueErrorData}: secureValueErrorData#0</li>
 * <li>{@link TLSecureValueErrorFile}: secureValueErrorFile#0</li>
 * <li>{@link TLSecureValueErrorFiles}: secureValueErrorFiles#0</li>
 * <li>{@link TLSecureValueErrorFrontSide}: secureValueErrorFrontSide#0</li>
 * <li>{@link TLSecureValueErrorReverseSide}: secureValueErrorReverseSide#0</li>
 * <li>{@link TLSecureValueErrorSelfie}: secureValueErrorSelfie#0</li>
 * <li>{@link TLSecureValueErrorTranslationFile}: secureValueErrorTranslationFile#0</li>
 * <li>{@link TLSecureValueErrorTranslationFiles}: secureValueErrorTranslationFiles#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsSecureValueError extends TLObject {
    protected TLAbsSecureValueType type;

    protected String text;

    public TLAbsSecureValueError() {
    }

    public TLAbsSecureValueType getType() {
        return type;
    }

    public void setType(TLAbsSecureValueType type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
