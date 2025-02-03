package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputDocumentFileLocation}: inputDocumentFileLocation#0</li>
 * <li>{@link TLInputEncryptedFileLocation}: inputEncryptedFileLocation#0</li>
 * <li>{@link TLInputFileLocation}: inputFileLocation#0</li>
 * <li>{@link TLInputGroupCallStream}: inputGroupCallStream#0</li>
 * <li>{@link TLInputPeerPhotoFileLocation}: inputPeerPhotoFileLocation#0</li>
 * <li>{@link TLInputPhotoFileLocation}: inputPhotoFileLocation#0</li>
 * <li>{@link TLInputPhotoLegacyFileLocation}: inputPhotoLegacyFileLocation#0</li>
 * <li>{@link TLInputSecureFileLocation}: inputSecureFileLocation#0</li>
 * <li>{@link TLInputStickerSetThumb}: inputStickerSetThumb#0</li>
 * <li>{@link TLInputTakeoutFileLocation}: inputTakeoutFileLocation#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsInputFileLocation extends TLObject {
    public TLAbsInputFileLocation() {
    }
}
