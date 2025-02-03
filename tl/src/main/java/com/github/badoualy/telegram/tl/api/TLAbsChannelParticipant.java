package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLChannelParticipant}: channelParticipant#0</li>
 * <li>{@link TLChannelParticipantAdmin}: channelParticipantAdmin#0</li>
 * <li>{@link TLChannelParticipantBanned}: channelParticipantBanned#0</li>
 * <li>{@link TLChannelParticipantCreator}: channelParticipantCreator#0</li>
 * <li>{@link TLChannelParticipantLeft}: channelParticipantLeft#0</li>
 * <li>{@link TLChannelParticipantSelf}: channelParticipantSelf#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsChannelParticipant extends TLObject {
    public TLAbsChannelParticipant() {
    }
}
