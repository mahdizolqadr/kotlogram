package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLDocumentAttributeAnimated}: documentAttributeAnimated#0</li>
 * <li>{@link TLDocumentAttributeAudio}: documentAttributeAudio#0</li>
 * <li>{@link TLDocumentAttributeCustomEmoji}: documentAttributeCustomEmoji#0</li>
 * <li>{@link TLDocumentAttributeFilename}: documentAttributeFilename#0</li>
 * <li>{@link TLDocumentAttributeHasStickers}: documentAttributeHasStickers#0</li>
 * <li>{@link TLDocumentAttributeImageSize}: documentAttributeImageSize#0</li>
 * <li>{@link TLDocumentAttributeSticker}: documentAttributeSticker#0</li>
 * <li>{@link TLDocumentAttributeVideo}: documentAttributeVideo#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsDocumentAttribute extends TLObject {
    public TLAbsDocumentAttribute() {
    }
}
