package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputDocumentFileLocation}: inputDocumentFileLocation#bad07584</li>
 * <li>{@link TLInputEncryptedFileLocation}: inputEncryptedFileLocation#f5235d55</li>
 * <li>{@link TLInputFileLocation}: inputFileLocation#dfdaabe1</li>
 * <li>{@link TLInputGroupCallStream}: inputGroupCallStream#598a92a</li>
 * <li>{@link TLInputPeerPhotoFileLocation}: inputPeerPhotoFileLocation#37257e99</li>
 * <li>{@link TLInputPhotoFileLocation}: inputPhotoFileLocation#40181ffe</li>
 * <li>{@link TLInputPhotoLegacyFileLocation}: inputPhotoLegacyFileLocation#d83466f3</li>
 * <li>{@link TLInputSecureFileLocation}: inputSecureFileLocation#cbc7ee28</li>
 * <li>{@link TLInputStickerSetThumb}: inputStickerSetThumb#9d84f3db</li>
 * <li>{@link TLInputTakeoutFileLocation}: inputTakeoutFileLocation#29be5899</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsInputFileLocation extends TLObject {

    protected TLAbsInputFileLocation() {
    }
}
