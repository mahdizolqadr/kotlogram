package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;
import java.lang.String;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLPhotoCachedSize}: photoCachedSize#0</li>
 * <li>{@link TLPhotoPathSize}: photoPathSize#0</li>
 * <li>{@link TLPhotoSize}: photoSize#0</li>
 * <li>{@link TLPhotoSizeEmpty}: photoSizeEmpty#0</li>
 * <li>{@link TLPhotoSizeProgressive}: photoSizeProgressive#0</li>
 * <li>{@link TLPhotoStrippedSize}: photoStrippedSize#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsPhotoSize extends TLObject {
    protected String type;

    public TLAbsPhotoSize() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
