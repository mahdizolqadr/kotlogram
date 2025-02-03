package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputStickerSetAnimatedEmoji}: inputStickerSetAnimatedEmoji#0</li>
 * <li>{@link TLInputStickerSetAnimatedEmojiAnimations}: inputStickerSetAnimatedEmojiAnimations#0</li>
 * <li>{@link TLInputStickerSetDice}: inputStickerSetDice#0</li>
 * <li>{@link TLInputStickerSetEmojiChannelDefaultStatuses}: inputStickerSetEmojiChannelDefaultStatuses#0</li>
 * <li>{@link TLInputStickerSetEmojiDefaultStatuses}: inputStickerSetEmojiDefaultStatuses#0</li>
 * <li>{@link TLInputStickerSetEmojiDefaultTopicIcons}: inputStickerSetEmojiDefaultTopicIcons#0</li>
 * <li>{@link TLInputStickerSetEmojiGenericAnimations}: inputStickerSetEmojiGenericAnimations#0</li>
 * <li>{@link TLInputStickerSetEmpty}: inputStickerSetEmpty#0</li>
 * <li>{@link TLInputStickerSetID}: inputStickerSetID#0</li>
 * <li>{@link TLInputStickerSetPremiumGifts}: inputStickerSetPremiumGifts#0</li>
 * <li>{@link TLInputStickerSetShortName}: inputStickerSetShortName#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsInputStickerSet extends TLObject {
    public TLAbsInputStickerSet() {
    }
}
