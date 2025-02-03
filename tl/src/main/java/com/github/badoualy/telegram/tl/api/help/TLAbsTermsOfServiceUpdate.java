package com.github.badoualy.telegram.tl.api.help;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLTermsOfServiceUpdate}: help.termsOfServiceUpdate#0</li>
 * <li>{@link TLTermsOfServiceUpdateEmpty}: help.termsOfServiceUpdateEmpty#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsTermsOfServiceUpdate extends TLObject {
    protected int expires;

    public TLAbsTermsOfServiceUpdate() {
    }

    public int getExpires() {
        return expires;
    }

    public void setExpires(int expires) {
        this.expires = expires;
    }

    public abstract boolean isEmpty();

    public abstract boolean isNotEmpty();

    public TLTermsOfServiceUpdate getAsTermsOfServiceUpdate() {
        return null;
    }
}
