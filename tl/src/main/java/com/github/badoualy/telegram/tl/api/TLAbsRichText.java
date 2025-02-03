package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLTextAnchor}: textAnchor#0</li>
 * <li>{@link TLTextBold}: textBold#0</li>
 * <li>{@link TLTextConcat}: textConcat#0</li>
 * <li>{@link TLTextEmail}: textEmail#0</li>
 * <li>{@link TLTextEmpty}: textEmpty#0</li>
 * <li>{@link TLTextFixed}: textFixed#0</li>
 * <li>{@link TLTextImage}: textImage#0</li>
 * <li>{@link TLTextItalic}: textItalic#0</li>
 * <li>{@link TLTextMarked}: textMarked#0</li>
 * <li>{@link TLTextPhone}: textPhone#0</li>
 * <li>{@link TLTextPlain}: textPlain#0</li>
 * <li>{@link TLTextStrike}: textStrike#0</li>
 * <li>{@link TLTextSubscript}: textSubscript#0</li>
 * <li>{@link TLTextSuperscript}: textSuperscript#0</li>
 * <li>{@link TLTextUnderline}: textUnderline#0</li>
 * <li>{@link TLTextUrl}: textUrl#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsRichText extends TLObject {
    public TLAbsRichText() {
    }
}
