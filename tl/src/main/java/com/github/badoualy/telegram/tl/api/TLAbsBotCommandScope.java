package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLBotCommandScopeChatAdmins}: botCommandScopeChatAdmins#0</li>
 * <li>{@link TLBotCommandScopeChats}: botCommandScopeChats#0</li>
 * <li>{@link TLBotCommandScopeDefault}: botCommandScopeDefault#0</li>
 * <li>{@link TLBotCommandScopePeer}: botCommandScopePeer#0</li>
 * <li>{@link TLBotCommandScopePeerAdmins}: botCommandScopePeerAdmins#0</li>
 * <li>{@link TLBotCommandScopePeerUser}: botCommandScopePeerUser#0</li>
 * <li>{@link TLBotCommandScopeUsers}: botCommandScopeUsers#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsBotCommandScope extends TLObject {
    public TLAbsBotCommandScope() {
    }
}
