package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLPhotoCachedSize}: photoCachedSize#21e1ad6</li>
 * <li>{@link TLPhotoPathSize}: photoPathSize#d8214d41</li>
 * <li>{@link TLPhotoSize}: photoSize#75c78e60</li>
 * <li>{@link TLPhotoSizeEmpty}: photoSizeEmpty#e17e23c</li>
 * <li>{@link TLPhotoSizeProgressive}: photoSizeProgressive#fa3efb95</li>
 * <li>{@link TLPhotoStrippedSize}: photoStrippedSize#e0b0bc2e</li>
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
