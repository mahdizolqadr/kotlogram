package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputEncryptedFile}: inputEncryptedFile#0</li>
 * <li>{@link TLInputEncryptedFileBigUploaded}: inputEncryptedFileBigUploaded#0</li>
 * <li>{@link TLInputEncryptedFileEmpty}: inputEncryptedFileEmpty#0</li>
 * <li>{@link TLInputEncryptedFileUploaded}: inputEncryptedFileUploaded#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsInputEncryptedFile extends TLObject {
    public TLAbsInputEncryptedFile() {
    }
}
