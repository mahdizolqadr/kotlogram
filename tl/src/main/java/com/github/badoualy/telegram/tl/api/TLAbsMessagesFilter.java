package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputMessagesFilterChatPhotos}: inputMessagesFilterChatPhotos#0</li>
 * <li>{@link TLInputMessagesFilterContacts}: inputMessagesFilterContacts#0</li>
 * <li>{@link TLInputMessagesFilterDocument}: inputMessagesFilterDocument#0</li>
 * <li>{@link TLInputMessagesFilterEmpty}: inputMessagesFilterEmpty#0</li>
 * <li>{@link TLInputMessagesFilterGeo}: inputMessagesFilterGeo#0</li>
 * <li>{@link TLInputMessagesFilterGif}: inputMessagesFilterGif#0</li>
 * <li>{@link TLInputMessagesFilterMusic}: inputMessagesFilterMusic#0</li>
 * <li>{@link TLInputMessagesFilterMyMentions}: inputMessagesFilterMyMentions#0</li>
 * <li>{@link TLInputMessagesFilterPhoneCalls}: inputMessagesFilterPhoneCalls#0</li>
 * <li>{@link TLInputMessagesFilterPhotoVideo}: inputMessagesFilterPhotoVideo#0</li>
 * <li>{@link TLInputMessagesFilterPhotos}: inputMessagesFilterPhotos#0</li>
 * <li>{@link TLInputMessagesFilterPinned}: inputMessagesFilterPinned#0</li>
 * <li>{@link TLInputMessagesFilterRoundVideo}: inputMessagesFilterRoundVideo#0</li>
 * <li>{@link TLInputMessagesFilterRoundVoice}: inputMessagesFilterRoundVoice#0</li>
 * <li>{@link TLInputMessagesFilterUrl}: inputMessagesFilterUrl#0</li>
 * <li>{@link TLInputMessagesFilterVideo}: inputMessagesFilterVideo#0</li>
 * <li>{@link TLInputMessagesFilterVoice}: inputMessagesFilterVoice#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsMessagesFilter extends TLObject {
    public TLAbsMessagesFilter() {
    }
}
