package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLChannelParticipantsAdmins}: channelParticipantsAdmins#0</li>
 * <li>{@link TLChannelParticipantsBanned}: channelParticipantsBanned#0</li>
 * <li>{@link TLChannelParticipantsBots}: channelParticipantsBots#0</li>
 * <li>{@link TLChannelParticipantsContacts}: channelParticipantsContacts#0</li>
 * <li>{@link TLChannelParticipantsKicked}: channelParticipantsKicked#0</li>
 * <li>{@link TLChannelParticipantsMentions}: channelParticipantsMentions#0</li>
 * <li>{@link TLChannelParticipantsRecent}: channelParticipantsRecent#0</li>
 * <li>{@link TLChannelParticipantsSearch}: channelParticipantsSearch#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsChannelParticipantsFilter extends TLObject {
    public TLAbsChannelParticipantsFilter() {
    }
}
