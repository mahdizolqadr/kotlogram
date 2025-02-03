package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLUpdateAttachMenuBots}: updateAttachMenuBots#0</li>
 * <li>{@link TLUpdateAutoSaveSettings}: updateAutoSaveSettings#0</li>
 * <li>{@link TLUpdateBotBusinessConnect}: updateBotBusinessConnect#0</li>
 * <li>{@link TLUpdateBotCallbackQuery}: updateBotCallbackQuery#0</li>
 * <li>{@link TLUpdateBotChatBoost}: updateBotChatBoost#0</li>
 * <li>{@link TLUpdateBotChatInviteRequester}: updateBotChatInviteRequester#0</li>
 * <li>{@link TLUpdateBotCommands}: updateBotCommands#0</li>
 * <li>{@link TLUpdateBotDeleteBusinessMessage}: updateBotDeleteBusinessMessage#0</li>
 * <li>{@link TLUpdateBotEditBusinessMessage}: updateBotEditBusinessMessage#0</li>
 * <li>{@link TLUpdateBotInlineQuery}: updateBotInlineQuery#0</li>
 * <li>{@link TLUpdateBotInlineSend}: updateBotInlineSend#0</li>
 * <li>{@link TLUpdateBotMenuButton}: updateBotMenuButton#0</li>
 * <li>{@link TLUpdateBotMessageReaction}: updateBotMessageReaction#0</li>
 * <li>{@link TLUpdateBotMessageReactions}: updateBotMessageReactions#0</li>
 * <li>{@link TLUpdateBotNewBusinessMessage}: updateBotNewBusinessMessage#0</li>
 * <li>{@link TLUpdateBotPrecheckoutQuery}: updateBotPrecheckoutQuery#0</li>
 * <li>{@link TLUpdateBotPurchasedPaidMedia}: updateBotPurchasedPaidMedia#0</li>
 * <li>{@link TLUpdateBotShippingQuery}: updateBotShippingQuery#0</li>
 * <li>{@link TLUpdateBotStopped}: updateBotStopped#0</li>
 * <li>{@link TLUpdateBotWebhookJSON}: updateBotWebhookJSON#0</li>
 * <li>{@link TLUpdateBotWebhookJSONQuery}: updateBotWebhookJSONQuery#0</li>
 * <li>{@link TLUpdateBroadcastRevenueTransactions}: updateBroadcastRevenueTransactions#0</li>
 * <li>{@link TLUpdateBusinessBotCallbackQuery}: updateBusinessBotCallbackQuery#0</li>
 * <li>{@link TLUpdateChannel}: updateChannel#0</li>
 * <li>{@link TLUpdateChannelAvailableMessages}: updateChannelAvailableMessages#0</li>
 * <li>{@link TLUpdateChannelMessageForwards}: updateChannelMessageForwards#0</li>
 * <li>{@link TLUpdateChannelMessageViews}: updateChannelMessageViews#0</li>
 * <li>{@link TLUpdateChannelParticipant}: updateChannelParticipant#0</li>
 * <li>{@link TLUpdateChannelPinnedTopic}: updateChannelPinnedTopic#0</li>
 * <li>{@link TLUpdateChannelPinnedTopics}: updateChannelPinnedTopics#0</li>
 * <li>{@link TLUpdateChannelReadMessagesContents}: updateChannelReadMessagesContents#0</li>
 * <li>{@link TLUpdateChannelTooLong}: updateChannelTooLong#0</li>
 * <li>{@link TLUpdateChannelUserTyping}: updateChannelUserTyping#0</li>
 * <li>{@link TLUpdateChannelViewForumAsMessages}: updateChannelViewForumAsMessages#0</li>
 * <li>{@link TLUpdateChannelWebPage}: updateChannelWebPage#0</li>
 * <li>{@link TLUpdateChat}: updateChat#0</li>
 * <li>{@link TLUpdateChatDefaultBannedRights}: updateChatDefaultBannedRights#0</li>
 * <li>{@link TLUpdateChatParticipant}: updateChatParticipant#0</li>
 * <li>{@link TLUpdateChatParticipantAdd}: updateChatParticipantAdd#0</li>
 * <li>{@link TLUpdateChatParticipantAdmin}: updateChatParticipantAdmin#0</li>
 * <li>{@link TLUpdateChatParticipantDelete}: updateChatParticipantDelete#0</li>
 * <li>{@link TLUpdateChatParticipants}: updateChatParticipants#0</li>
 * <li>{@link TLUpdateChatUserTyping}: updateChatUserTyping#0</li>
 * <li>{@link TLUpdateConfig}: updateConfig#0</li>
 * <li>{@link TLUpdateContactsReset}: updateContactsReset#0</li>
 * <li>{@link TLUpdateDcOptions}: updateDcOptions#0</li>
 * <li>{@link TLUpdateDeleteChannelMessages}: updateDeleteChannelMessages#0</li>
 * <li>{@link TLUpdateDeleteMessages}: updateDeleteMessages#0</li>
 * <li>{@link TLUpdateDeleteQuickReply}: updateDeleteQuickReply#0</li>
 * <li>{@link TLUpdateDeleteQuickReplyMessages}: updateDeleteQuickReplyMessages#0</li>
 * <li>{@link TLUpdateDeleteScheduledMessages}: updateDeleteScheduledMessages#0</li>
 * <li>{@link TLUpdateDialogFilter}: updateDialogFilter#0</li>
 * <li>{@link TLUpdateDialogFilterOrder}: updateDialogFilterOrder#0</li>
 * <li>{@link TLUpdateDialogFilters}: updateDialogFilters#0</li>
 * <li>{@link TLUpdateDialogPinned}: updateDialogPinned#0</li>
 * <li>{@link TLUpdateDialogUnreadMark}: updateDialogUnreadMark#0</li>
 * <li>{@link TLUpdateDraftMessage}: updateDraftMessage#0</li>
 * <li>{@link TLUpdateEditChannelMessage}: updateEditChannelMessage#0</li>
 * <li>{@link TLUpdateEditMessage}: updateEditMessage#0</li>
 * <li>{@link TLUpdateEncryptedChatTyping}: updateEncryptedChatTyping#0</li>
 * <li>{@link TLUpdateEncryptedMessagesRead}: updateEncryptedMessagesRead#0</li>
 * <li>{@link TLUpdateEncryption}: updateEncryption#0</li>
 * <li>{@link TLUpdateFavedStickers}: updateFavedStickers#0</li>
 * <li>{@link TLUpdateFolderPeers}: updateFolderPeers#0</li>
 * <li>{@link TLUpdateGeoLiveViewed}: updateGeoLiveViewed#0</li>
 * <li>{@link TLUpdateGroupCall}: updateGroupCall#0</li>
 * <li>{@link TLUpdateGroupCallConnection}: updateGroupCallConnection#0</li>
 * <li>{@link TLUpdateGroupCallParticipants}: updateGroupCallParticipants#0</li>
 * <li>{@link TLUpdateInlineBotCallbackQuery}: updateInlineBotCallbackQuery#0</li>
 * <li>{@link TLUpdateLangPack}: updateLangPack#0</li>
 * <li>{@link TLUpdateLangPackTooLong}: updateLangPackTooLong#0</li>
 * <li>{@link TLUpdateLoginToken}: updateLoginToken#0</li>
 * <li>{@link TLUpdateMessageExtendedMedia}: updateMessageExtendedMedia#0</li>
 * <li>{@link TLUpdateMessageID}: updateMessageID#0</li>
 * <li>{@link TLUpdateMessagePoll}: updateMessagePoll#0</li>
 * <li>{@link TLUpdateMessagePollVote}: updateMessagePollVote#0</li>
 * <li>{@link TLUpdateMessageReactions}: updateMessageReactions#0</li>
 * <li>{@link TLUpdateMoveStickerSetToTop}: updateMoveStickerSetToTop#0</li>
 * <li>{@link TLUpdateNewAuthorization}: updateNewAuthorization#0</li>
 * <li>{@link TLUpdateNewChannelMessage}: updateNewChannelMessage#0</li>
 * <li>{@link TLUpdateNewEncryptedMessage}: updateNewEncryptedMessage#0</li>
 * <li>{@link TLUpdateNewMessage}: updateNewMessage#0</li>
 * <li>{@link TLUpdateNewQuickReply}: updateNewQuickReply#0</li>
 * <li>{@link TLUpdateNewScheduledMessage}: updateNewScheduledMessage#0</li>
 * <li>{@link TLUpdateNewStickerSet}: updateNewStickerSet#0</li>
 * <li>{@link TLUpdateNewStoryReaction}: updateNewStoryReaction#0</li>
 * <li>{@link TLUpdateNotifySettings}: updateNotifySettings#0</li>
 * <li>{@link TLUpdatePaidReactionPrivacy}: updatePaidReactionPrivacy#0</li>
 * <li>{@link TLUpdatePeerBlocked}: updatePeerBlocked#0</li>
 * <li>{@link TLUpdatePeerHistoryTTL}: updatePeerHistoryTTL#0</li>
 * <li>{@link TLUpdatePeerLocated}: updatePeerLocated#0</li>
 * <li>{@link TLUpdatePeerSettings}: updatePeerSettings#0</li>
 * <li>{@link TLUpdatePeerWallpaper}: updatePeerWallpaper#0</li>
 * <li>{@link TLUpdatePendingJoinRequests}: updatePendingJoinRequests#0</li>
 * <li>{@link TLUpdatePhoneCall}: updatePhoneCall#0</li>
 * <li>{@link TLUpdatePhoneCallSignalingData}: updatePhoneCallSignalingData#0</li>
 * <li>{@link TLUpdatePinnedChannelMessages}: updatePinnedChannelMessages#0</li>
 * <li>{@link TLUpdatePinnedDialogs}: updatePinnedDialogs#0</li>
 * <li>{@link TLUpdatePinnedMessages}: updatePinnedMessages#0</li>
 * <li>{@link TLUpdatePinnedSavedDialogs}: updatePinnedSavedDialogs#0</li>
 * <li>{@link TLUpdatePrivacy}: updatePrivacy#0</li>
 * <li>{@link TLUpdatePtsChanged}: updatePtsChanged#0</li>
 * <li>{@link TLUpdateQuickReplies}: updateQuickReplies#0</li>
 * <li>{@link TLUpdateQuickReplyMessage}: updateQuickReplyMessage#0</li>
 * <li>{@link TLUpdateReadChannelDiscussionInbox}: updateReadChannelDiscussionInbox#0</li>
 * <li>{@link TLUpdateReadChannelDiscussionOutbox}: updateReadChannelDiscussionOutbox#0</li>
 * <li>{@link TLUpdateReadChannelInbox}: updateReadChannelInbox#0</li>
 * <li>{@link TLUpdateReadChannelOutbox}: updateReadChannelOutbox#0</li>
 * <li>{@link TLUpdateReadFeaturedEmojiStickers}: updateReadFeaturedEmojiStickers#0</li>
 * <li>{@link TLUpdateReadFeaturedStickers}: updateReadFeaturedStickers#0</li>
 * <li>{@link TLUpdateReadHistoryInbox}: updateReadHistoryInbox#0</li>
 * <li>{@link TLUpdateReadHistoryOutbox}: updateReadHistoryOutbox#0</li>
 * <li>{@link TLUpdateReadMessagesContents}: updateReadMessagesContents#0</li>
 * <li>{@link TLUpdateReadStories}: updateReadStories#0</li>
 * <li>{@link TLUpdateRecentEmojiStatuses}: updateRecentEmojiStatuses#0</li>
 * <li>{@link TLUpdateRecentReactions}: updateRecentReactions#0</li>
 * <li>{@link TLUpdateRecentStickers}: updateRecentStickers#0</li>
 * <li>{@link TLUpdateSavedDialogPinned}: updateSavedDialogPinned#0</li>
 * <li>{@link TLUpdateSavedGifs}: updateSavedGifs#0</li>
 * <li>{@link TLUpdateSavedReactionTags}: updateSavedReactionTags#0</li>
 * <li>{@link TLUpdateSavedRingtones}: updateSavedRingtones#0</li>
 * <li>{@link TLUpdateSentStoryReaction}: updateSentStoryReaction#0</li>
 * <li>{@link TLUpdateServiceNotification}: updateServiceNotification#0</li>
 * <li>{@link TLUpdateSmsJob}: updateSmsJob#0</li>
 * <li>{@link TLUpdateStarsBalance}: updateStarsBalance#0</li>
 * <li>{@link TLUpdateStarsRevenueStatus}: updateStarsRevenueStatus#0</li>
 * <li>{@link TLUpdateStickerSets}: updateStickerSets#0</li>
 * <li>{@link TLUpdateStickerSetsOrder}: updateStickerSetsOrder#0</li>
 * <li>{@link TLUpdateStoriesStealthMode}: updateStoriesStealthMode#0</li>
 * <li>{@link TLUpdateStory}: updateStory#0</li>
 * <li>{@link TLUpdateStoryID}: updateStoryID#0</li>
 * <li>{@link TLUpdateTheme}: updateTheme#0</li>
 * <li>{@link TLUpdateTranscribedAudio}: updateTranscribedAudio#0</li>
 * <li>{@link TLUpdateUser}: updateUser#0</li>
 * <li>{@link TLUpdateUserEmojiStatus}: updateUserEmojiStatus#0</li>
 * <li>{@link TLUpdateUserName}: updateUserName#0</li>
 * <li>{@link TLUpdateUserPhone}: updateUserPhone#0</li>
 * <li>{@link TLUpdateUserStatus}: updateUserStatus#0</li>
 * <li>{@link TLUpdateUserTyping}: updateUserTyping#0</li>
 * <li>{@link TLUpdateWebPage}: updateWebPage#0</li>
 * <li>{@link TLUpdateWebViewResultSent}: updateWebViewResultSent#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsUpdate extends TLObject {
    public TLAbsUpdate() {
    }
}
