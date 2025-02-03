package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLPageBlockAnchor}: pageBlockAnchor#0</li>
 * <li>{@link TLPageBlockAudio}: pageBlockAudio#0</li>
 * <li>{@link TLPageBlockAuthorDate}: pageBlockAuthorDate#0</li>
 * <li>{@link TLPageBlockBlockquote}: pageBlockBlockquote#0</li>
 * <li>{@link TLPageBlockChannel}: pageBlockChannel#0</li>
 * <li>{@link TLPageBlockCollage}: pageBlockCollage#0</li>
 * <li>{@link TLPageBlockCover}: pageBlockCover#0</li>
 * <li>{@link TLPageBlockDetails}: pageBlockDetails#0</li>
 * <li>{@link TLPageBlockDivider}: pageBlockDivider#0</li>
 * <li>{@link TLPageBlockEmbed}: pageBlockEmbed#0</li>
 * <li>{@link TLPageBlockEmbedPost}: pageBlockEmbedPost#0</li>
 * <li>{@link TLPageBlockFooter}: pageBlockFooter#0</li>
 * <li>{@link TLPageBlockHeader}: pageBlockHeader#0</li>
 * <li>{@link TLPageBlockKicker}: pageBlockKicker#0</li>
 * <li>{@link TLPageBlockList}: pageBlockList#0</li>
 * <li>{@link TLPageBlockMap}: pageBlockMap#0</li>
 * <li>{@link TLPageBlockOrderedList}: pageBlockOrderedList#0</li>
 * <li>{@link TLPageBlockParagraph}: pageBlockParagraph#0</li>
 * <li>{@link TLPageBlockPhoto}: pageBlockPhoto#0</li>
 * <li>{@link TLPageBlockPreformatted}: pageBlockPreformatted#0</li>
 * <li>{@link TLPageBlockPullquote}: pageBlockPullquote#0</li>
 * <li>{@link TLPageBlockRelatedArticles}: pageBlockRelatedArticles#0</li>
 * <li>{@link TLPageBlockSlideshow}: pageBlockSlideshow#0</li>
 * <li>{@link TLPageBlockSubheader}: pageBlockSubheader#0</li>
 * <li>{@link TLPageBlockSubtitle}: pageBlockSubtitle#0</li>
 * <li>{@link TLPageBlockTable}: pageBlockTable#0</li>
 * <li>{@link TLPageBlockTitle}: pageBlockTitle#0</li>
 * <li>{@link TLPageBlockUnsupported}: pageBlockUnsupported#0</li>
 * <li>{@link TLPageBlockVideo}: pageBlockVideo#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsPageBlock extends TLObject {
    public TLAbsPageBlock() {
    }
}
