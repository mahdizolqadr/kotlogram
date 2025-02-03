package com.github.badoualy.telegram.tl.api.messages;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLExportedChatInvite}: messages.exportedChatInvite#0</li>
 * <li>{@link TLExportedChatInviteReplaced}: messages.exportedChatInviteReplaced#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsExportedChatInvite extends TLObject {
    protected com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite invite;

    protected TLVector<TLAbsUser> users;

    public TLAbsExportedChatInvite() {
    }

    public com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite getInvite() {
        return invite;
    }

    public void setInvite(com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite invite) {
        this.invite = invite;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }
}
