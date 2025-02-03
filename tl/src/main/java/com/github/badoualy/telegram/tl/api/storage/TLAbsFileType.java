package com.github.badoualy.telegram.tl.api.storage;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLFileGif}: storage.fileGif#0</li>
 * <li>{@link TLFileJpeg}: storage.fileJpeg#0</li>
 * <li>{@link TLFileMov}: storage.fileMov#0</li>
 * <li>{@link TLFileMp3}: storage.fileMp3#0</li>
 * <li>{@link TLFileMp4}: storage.fileMp4#0</li>
 * <li>{@link TLFilePartial}: storage.filePartial#0</li>
 * <li>{@link TLFilePdf}: storage.filePdf#0</li>
 * <li>{@link TLFilePng}: storage.filePng#0</li>
 * <li>{@link TLFileUnknown}: storage.fileUnknown#0</li>
 * <li>{@link TLFileWebp}: storage.fileWebp#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsFileType extends TLObject {
    public TLAbsFileType() {
    }
}
