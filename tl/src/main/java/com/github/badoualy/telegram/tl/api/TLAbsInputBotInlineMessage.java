package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputBotInlineMessageGame}: inputBotInlineMessageGame#0</li>
 * <li>{@link TLInputBotInlineMessageMediaAuto}: inputBotInlineMessageMediaAuto#0</li>
 * <li>{@link TLInputBotInlineMessageMediaContact}: inputBotInlineMessageMediaContact#0</li>
 * <li>{@link TLInputBotInlineMessageMediaGeo}: inputBotInlineMessageMediaGeo#0</li>
 * <li>{@link TLInputBotInlineMessageMediaInvoice}: inputBotInlineMessageMediaInvoice#0</li>
 * <li>{@link TLInputBotInlineMessageMediaVenue}: inputBotInlineMessageMediaVenue#0</li>
 * <li>{@link TLInputBotInlineMessageMediaWebPage}: inputBotInlineMessageMediaWebPage#0</li>
 * <li>{@link TLInputBotInlineMessageText}: inputBotInlineMessageText#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsInputBotInlineMessage extends TLObject {
    protected int flags;

    protected TLAbsReplyMarkup replyMarkup;

    public TLAbsInputBotInlineMessage() {
    }

    public TLAbsReplyMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public void setReplyMarkup(TLAbsReplyMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
    }
}
