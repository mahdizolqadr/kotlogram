package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLChannelParticipant}: channelParticipant#c00c07c0</li>
 * <li>{@link TLChannelParticipantCreator}: channelParticipantCreator#2fe601d3</li>
 * <li>{@link TLChannelParticipantLeft}: channelParticipantLeft#1b03f006</li>
 * <li>{@link TLChannelParticipantBanned}: channelParticipantBanned#6df8014e</li>
 * <li>{@link TLChannelParticipantAdmin}: channelParticipantAdmin#34c3bb53</li>
 * <li>{@link TLChannelParticipantSelf}: channelParticipantSelf#28a8bc67</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsChannelParticipant extends TLObject {

    protected long userId;

    protected TLAbsChannelParticipant() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
