package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLMessageActionBoostApply}: messageActionBoostApply#0</li>
 * <li>{@link TLMessageActionBotAllowed}: messageActionBotAllowed#0</li>
 * <li>{@link TLMessageActionChannelCreate}: messageActionChannelCreate#0</li>
 * <li>{@link TLMessageActionChannelMigrateFrom}: messageActionChannelMigrateFrom#0</li>
 * <li>{@link TLMessageActionChatAddUser}: messageActionChatAddUser#0</li>
 * <li>{@link TLMessageActionChatCreate}: messageActionChatCreate#0</li>
 * <li>{@link TLMessageActionChatDeletePhoto}: messageActionChatDeletePhoto#0</li>
 * <li>{@link TLMessageActionChatDeleteUser}: messageActionChatDeleteUser#0</li>
 * <li>{@link TLMessageActionChatEditPhoto}: messageActionChatEditPhoto#0</li>
 * <li>{@link TLMessageActionChatEditTitle}: messageActionChatEditTitle#0</li>
 * <li>{@link TLMessageActionChatJoinedByLink}: messageActionChatJoinedByLink#0</li>
 * <li>{@link TLMessageActionChatJoinedByRequest}: messageActionChatJoinedByRequest#0</li>
 * <li>{@link TLMessageActionChatMigrateTo}: messageActionChatMigrateTo#0</li>
 * <li>{@link TLMessageActionContactSignUp}: messageActionContactSignUp#0</li>
 * <li>{@link TLMessageActionCustomAction}: messageActionCustomAction#0</li>
 * <li>{@link TLMessageActionEmpty}: messageActionEmpty#0</li>
 * <li>{@link TLMessageActionGameScore}: messageActionGameScore#0</li>
 * <li>{@link TLMessageActionGeoProximityReached}: messageActionGeoProximityReached#0</li>
 * <li>{@link TLMessageActionGiftCode}: messageActionGiftCode#0</li>
 * <li>{@link TLMessageActionGiftPremium}: messageActionGiftPremium#0</li>
 * <li>{@link TLMessageActionGiftStars}: messageActionGiftStars#0</li>
 * <li>{@link TLMessageActionGiveawayLaunch}: messageActionGiveawayLaunch#0</li>
 * <li>{@link TLMessageActionGiveawayResults}: messageActionGiveawayResults#0</li>
 * <li>{@link TLMessageActionGroupCall}: messageActionGroupCall#0</li>
 * <li>{@link TLMessageActionGroupCallScheduled}: messageActionGroupCallScheduled#0</li>
 * <li>{@link TLMessageActionHistoryClear}: messageActionHistoryClear#0</li>
 * <li>{@link TLMessageActionInviteToGroupCall}: messageActionInviteToGroupCall#0</li>
 * <li>{@link TLMessageActionPaymentRefunded}: messageActionPaymentRefunded#0</li>
 * <li>{@link TLMessageActionPaymentSent}: messageActionPaymentSent#0</li>
 * <li>{@link TLMessageActionPaymentSentMe}: messageActionPaymentSentMe#0</li>
 * <li>{@link TLMessageActionPhoneCall}: messageActionPhoneCall#0</li>
 * <li>{@link TLMessageActionPinMessage}: messageActionPinMessage#0</li>
 * <li>{@link TLMessageActionPrizeStars}: messageActionPrizeStars#0</li>
 * <li>{@link TLMessageActionRequestedPeer}: messageActionRequestedPeer#0</li>
 * <li>{@link TLMessageActionRequestedPeerSentMe}: messageActionRequestedPeerSentMe#0</li>
 * <li>{@link TLMessageActionScreenshotTaken}: messageActionScreenshotTaken#0</li>
 * <li>{@link TLMessageActionSecureValuesSent}: messageActionSecureValuesSent#0</li>
 * <li>{@link TLMessageActionSecureValuesSentMe}: messageActionSecureValuesSentMe#0</li>
 * <li>{@link TLMessageActionSetChatTheme}: messageActionSetChatTheme#0</li>
 * <li>{@link TLMessageActionSetChatWallPaper}: messageActionSetChatWallPaper#0</li>
 * <li>{@link TLMessageActionSetMessagesTTL}: messageActionSetMessagesTTL#0</li>
 * <li>{@link TLMessageActionStarGift}: messageActionStarGift#0</li>
 * <li>{@link TLMessageActionSuggestProfilePhoto}: messageActionSuggestProfilePhoto#0</li>
 * <li>{@link TLMessageActionTopicCreate}: messageActionTopicCreate#0</li>
 * <li>{@link TLMessageActionTopicEdit}: messageActionTopicEdit#0</li>
 * <li>{@link TLMessageActionWebViewDataSent}: messageActionWebViewDataSent#0</li>
 * <li>{@link TLMessageActionWebViewDataSentMe}: messageActionWebViewDataSentMe#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsMessageAction extends TLObject {
    public TLAbsMessageAction() {
    }
}
