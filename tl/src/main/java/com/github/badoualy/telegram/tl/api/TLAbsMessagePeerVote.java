package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLMessagePeerVote}: messagePeerVote#0</li>
 * <li>{@link TLMessagePeerVoteInputOption}: messagePeerVoteInputOption#0</li>
 * <li>{@link TLMessagePeerVoteMultiple}: messagePeerVoteMultiple#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsMessagePeerVote extends TLObject {
    protected TLAbsPeer peer;

    protected int date;

    public TLAbsMessagePeerVote() {
    }

    public TLAbsPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsPeer peer) {
        this.peer = peer;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
