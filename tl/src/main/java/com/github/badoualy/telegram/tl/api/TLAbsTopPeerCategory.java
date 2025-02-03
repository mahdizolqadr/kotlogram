package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLTopPeerCategoryBotsApp}: topPeerCategoryBotsApp#0</li>
 * <li>{@link TLTopPeerCategoryBotsInline}: topPeerCategoryBotsInline#0</li>
 * <li>{@link TLTopPeerCategoryBotsPM}: topPeerCategoryBotsPM#0</li>
 * <li>{@link TLTopPeerCategoryChannels}: topPeerCategoryChannels#0</li>
 * <li>{@link TLTopPeerCategoryCorrespondents}: topPeerCategoryCorrespondents#0</li>
 * <li>{@link TLTopPeerCategoryForwardChats}: topPeerCategoryForwardChats#0</li>
 * <li>{@link TLTopPeerCategoryForwardUsers}: topPeerCategoryForwardUsers#0</li>
 * <li>{@link TLTopPeerCategoryGroups}: topPeerCategoryGroups#0</li>
 * <li>{@link TLTopPeerCategoryPhoneCalls}: topPeerCategoryPhoneCalls#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsTopPeerCategory extends TLObject {
    public TLAbsTopPeerCategory() {
    }
}
