package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;
import java.lang.String;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputBotInlineResult}: inputBotInlineResult#0</li>
 * <li>{@link TLInputBotInlineResultDocument}: inputBotInlineResultDocument#0</li>
 * <li>{@link TLInputBotInlineResultGame}: inputBotInlineResultGame#0</li>
 * <li>{@link TLInputBotInlineResultPhoto}: inputBotInlineResultPhoto#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsInputBotInlineResult extends TLObject {
    protected String id;

    protected TLAbsInputBotInlineMessage sendMessage;

    public TLAbsInputBotInlineResult() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TLAbsInputBotInlineMessage getSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(TLAbsInputBotInlineMessage sendMessage) {
        this.sendMessage = sendMessage;
    }
}
