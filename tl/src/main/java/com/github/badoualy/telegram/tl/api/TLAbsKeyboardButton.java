package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;
import java.lang.String;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputKeyboardButtonRequestPeer}: inputKeyboardButtonRequestPeer#0</li>
 * <li>{@link TLInputKeyboardButtonUrlAuth}: inputKeyboardButtonUrlAuth#0</li>
 * <li>{@link TLInputKeyboardButtonUserProfile}: inputKeyboardButtonUserProfile#0</li>
 * <li>{@link TLKeyboardButton}: keyboardButton#0</li>
 * <li>{@link TLKeyboardButtonBuy}: keyboardButtonBuy#0</li>
 * <li>{@link TLKeyboardButtonCallback}: keyboardButtonCallback#0</li>
 * <li>{@link TLKeyboardButtonCopy}: keyboardButtonCopy#0</li>
 * <li>{@link TLKeyboardButtonGame}: keyboardButtonGame#0</li>
 * <li>{@link TLKeyboardButtonRequestGeoLocation}: keyboardButtonRequestGeoLocation#0</li>
 * <li>{@link TLKeyboardButtonRequestPeer}: keyboardButtonRequestPeer#0</li>
 * <li>{@link TLKeyboardButtonRequestPhone}: keyboardButtonRequestPhone#0</li>
 * <li>{@link TLKeyboardButtonRequestPoll}: keyboardButtonRequestPoll#0</li>
 * <li>{@link TLKeyboardButtonSimpleWebView}: keyboardButtonSimpleWebView#0</li>
 * <li>{@link TLKeyboardButtonSwitchInline}: keyboardButtonSwitchInline#0</li>
 * <li>{@link TLKeyboardButtonUrl}: keyboardButtonUrl#0</li>
 * <li>{@link TLKeyboardButtonUrlAuth}: keyboardButtonUrlAuth#0</li>
 * <li>{@link TLKeyboardButtonUserProfile}: keyboardButtonUserProfile#0</li>
 * <li>{@link TLKeyboardButtonWebView}: keyboardButtonWebView#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsKeyboardButton extends TLObject {
    protected String text;

    public TLAbsKeyboardButton() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
