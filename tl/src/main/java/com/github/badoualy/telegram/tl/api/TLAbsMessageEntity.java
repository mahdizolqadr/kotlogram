package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputMessageEntityMentionName}: inputMessageEntityMentionName#0</li>
 * <li>{@link TLMessageEntityBankCard}: messageEntityBankCard#0</li>
 * <li>{@link TLMessageEntityBlockquote}: messageEntityBlockquote#0</li>
 * <li>{@link TLMessageEntityBold}: messageEntityBold#0</li>
 * <li>{@link TLMessageEntityBotCommand}: messageEntityBotCommand#0</li>
 * <li>{@link TLMessageEntityCashtag}: messageEntityCashtag#0</li>
 * <li>{@link TLMessageEntityCode}: messageEntityCode#0</li>
 * <li>{@link TLMessageEntityCustomEmoji}: messageEntityCustomEmoji#0</li>
 * <li>{@link TLMessageEntityEmail}: messageEntityEmail#0</li>
 * <li>{@link TLMessageEntityHashtag}: messageEntityHashtag#0</li>
 * <li>{@link TLMessageEntityItalic}: messageEntityItalic#0</li>
 * <li>{@link TLMessageEntityMention}: messageEntityMention#0</li>
 * <li>{@link TLMessageEntityMentionName}: messageEntityMentionName#0</li>
 * <li>{@link TLMessageEntityPhone}: messageEntityPhone#0</li>
 * <li>{@link TLMessageEntityPre}: messageEntityPre#0</li>
 * <li>{@link TLMessageEntitySpoiler}: messageEntitySpoiler#0</li>
 * <li>{@link TLMessageEntityStrike}: messageEntityStrike#0</li>
 * <li>{@link TLMessageEntityTextUrl}: messageEntityTextUrl#0</li>
 * <li>{@link TLMessageEntityUnderline}: messageEntityUnderline#0</li>
 * <li>{@link TLMessageEntityUnknown}: messageEntityUnknown#0</li>
 * <li>{@link TLMessageEntityUrl}: messageEntityUrl#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsMessageEntity extends TLObject {
    protected int offset;

    protected int length;

    public TLAbsMessageEntity() {
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
