package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;
import java.lang.String;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLEmojiGroup}: emojiGroup#0</li>
 * <li>{@link TLEmojiGroupGreeting}: emojiGroupGreeting#0</li>
 * <li>{@link TLEmojiGroupPremium}: emojiGroupPremium#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsEmojiGroup extends TLObject {
    protected String title;

    protected long iconEmojiId;

    public TLAbsEmojiGroup() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getIconEmojiId() {
        return iconEmojiId;
    }

    public void setIconEmojiId(long iconEmojiId) {
        this.iconEmojiId = iconEmojiId;
    }
}
