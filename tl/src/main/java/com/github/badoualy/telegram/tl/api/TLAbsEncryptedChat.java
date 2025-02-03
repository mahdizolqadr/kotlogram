package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLEncryptedChat}: encryptedChat#0</li>
 * <li>{@link TLEncryptedChatDiscarded}: encryptedChatDiscarded#0</li>
 * <li>{@link TLEncryptedChatEmpty}: encryptedChatEmpty#0</li>
 * <li>{@link TLEncryptedChatRequested}: encryptedChatRequested#0</li>
 * <li>{@link TLEncryptedChatWaiting}: encryptedChatWaiting#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsEncryptedChat extends TLObject {
    protected int id;

    public TLAbsEncryptedChat() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
