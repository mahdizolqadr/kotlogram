package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLUpdateBotCallbackQuery}: updateBotCallbackQuery#b9cfc48d</li>
 * <li>{@link TLUpdateBotCommands}: updateBotCommands#4d712f2e</li>
 * <li>{@link TLUpdateBotInlineQuery}: updateBotInlineQuery#496f379c</li>
 * <li>{@link TLUpdateBotInlineSend}: updateBotInlineSend#12f12a07</li>
 * <li>{@link TLUpdateBotPrecheckoutQuery}: updateBotPrecheckoutQuery#8caa9a96</li>
 * <li>{@link TLUpdateBotShippingQuery}: updateBotShippingQuery#b5aefd7d</li>
 * <li>{@link TLUpdateBotStopped}: updateBotStopped#c4870a49</li>
 * <li>{@link TLUpdateBotWebhookJSON}: updateBotWebhookJSON#8317c0c3</li>
 * <li>{@link TLUpdateBotWebhookJSONQuery}: updateBotWebhookJSONQuery#9b9240a6</li>
 * <li>{@link TLUpdateChannel}: updateChannel#635b4c09</li>
 * <li>{@link TLUpdateChannelAvailableMessages}: updateChannelAvailableMessages#b23fc698</li>
 * <li>{@link TLUpdateChannelMessageForwards}: updateChannelMessageForwards#d29a27f4</li>
 * <li>{@link TLUpdateChannelMessageViews}: updateChannelMessageViews#f226ac08</li>
 * <li>{@link TLUpdateChannelParticipant}: updateChannelParticipant#985d3abb</li>
 * <li>{@link TLUpdateChannelPinnedMessage}: updateChannelPinnedMessage#98592475</li>
 * <li>{@link TLUpdateChannelReadMessagesContents}: updateChannelReadMessagesContents#44bdd535</li>
 * <li>{@link TLUpdateChannelTooLong}: updateChannelTooLong#108d941f</li>
 * <li>{@link TLUpdateChannelWebPage}: updateChannelWebPage#2f2ba99f</li>
 * <li>{@link TLUpdateChat}: updateChat#f89a6a4e</li>
 * <li>{@link TLUpdateChatAdmins}: updateChatAdmins#6e947941</li>
 * <li>{@link TLUpdateChatDefaultBannedRights}: updateChatDefaultBannedRights#54c01850</li>
 * <li>{@link TLUpdateChatParticipant}: updateChatParticipant#d087663a</li>
 * <li>{@link TLUpdateChatParticipantAdd}: updateChatParticipantAdd#3dda5451</li>
 * <li>{@link TLUpdateChatParticipantAdmin}: updateChatParticipantAdmin#d7ca61a2</li>
 * <li>{@link TLUpdateChatParticipantDelete}: updateChatParticipantDelete#e32f3d77</li>
 * <li>{@link TLUpdateChatParticipants}: updateChatParticipants#7761198</li>
 * <li>{@link TLUpdateChatUserTyping}: updateChatUserTyping#83487af0</li>
 * <li>{@link TLUpdateConfig}: updateConfig#a229dd06</li>
 * <li>{@link TLUpdateContactsReset}: updateContactsReset#7084a7be</li>
 * <li>{@link TLUpdateDcOptions}: updateDcOptions#8e5e9873</li>
 * <li>{@link TLUpdateDeleteChannelMessages}: updateDeleteChannelMessages#c32d5b12</li>
 * <li>{@link TLUpdateDeleteMessages}: updateDeleteMessages#a20db0e5</li>
 * <li>{@link TLUpdateDeleteScheduledMessages}: updateDeleteScheduledMessages#90866cee</li>
 * <li>{@link TLUpdateDialogFilter}: updateDialogFilter#26ffde7d</li>
 * <li>{@link TLUpdateDialogFilterOrder}: updateDialogFilterOrder#a5d72105</li>
 * <li>{@link TLUpdateDialogFilters}: updateDialogFilters#3504914f</li>
 * <li>{@link TLUpdateDialogPinned}: updateDialogPinned#6e6fe51c</li>
 * <li>{@link TLUpdateDialogUnreadMark}: updateDialogUnreadMark#e16459c3</li>
 * <li>{@link TLUpdateDraftMessage}: updateDraftMessage#ee2bb969</li>
 * <li>{@link TLUpdateEditChannelMessage}: updateEditChannelMessage#1b3f4df7</li>
 * <li>{@link TLUpdateEditMessage}: updateEditMessage#e40370a3</li>
 * <li>{@link TLUpdateEncryptedChatTyping}: updateEncryptedChatTyping#1710f156</li>
 * <li>{@link TLUpdateEncryptedMessagesRead}: updateEncryptedMessagesRead#38fe25b7</li>
 * <li>{@link TLUpdateEncryption}: updateEncryption#b4a2e88d</li>
 * <li>{@link TLUpdateFavedStickers}: updateFavedStickers#e511996d</li>
 * <li>{@link TLUpdateFolderPeers}: updateFolderPeers#19360dc0</li>
 * <li>{@link TLUpdateGeoLiveViewed}: updateGeoLiveViewed#871fb939</li>
 * <li>{@link TLUpdateGroupCall}: updateGroupCall#14b24500</li>
 * <li>{@link TLUpdateGroupCallConnection}: updateGroupCallConnection#b783982</li>
 * <li>{@link TLUpdateGroupCallParticipants}: updateGroupCallParticipants#f2ebdb4e</li>
 * <li>{@link TLUpdateInlineBotCallbackQuery}: updateInlineBotCallbackQuery#691e9052</li>
 * <li>{@link TLUpdateLangPack}: updateLangPack#56022f4d</li>
 * <li>{@link TLUpdateLangPackTooLong}: updateLangPackTooLong#46560264</li>
 * <li>{@link TLUpdateLoginToken}: updateLoginToken#564fe691</li>
 * <li>{@link TLUpdateMessageID}: updateMessageID#4e90bfd6</li>
 * <li>{@link TLUpdateMessagePoll}: updateMessagePoll#aca1657b</li>
 * <li>{@link TLUpdateNewChannelMessage}: updateNewChannelMessage#62ba04d9</li>
 * <li>{@link TLUpdateNewEncryptedMessage}: updateNewEncryptedMessage#12bcbd9a</li>
 * <li>{@link TLUpdateNewMessage}: updateNewMessage#1f2b0afd</li>
 * <li>{@link TLUpdateNewScheduledMessage}: updateNewScheduledMessage#39a51dfb</li>
 * <li>{@link TLUpdateNewStickerSet}: updateNewStickerSet#688a30aa</li>
 * <li>{@link TLUpdateNotifySettings}: updateNotifySettings#bec268ef</li>
 * <li>{@link TLUpdatePeerBlocked}: updatePeerBlocked#246a4b22</li>
 * <li>{@link TLUpdatePeerHistoryTTL}: updatePeerHistoryTTL#bb9bb9a5</li>
 * <li>{@link TLUpdatePeerLocated}: updatePeerLocated#b4afcfb0</li>
 * <li>{@link TLUpdatePeerSettings}: updatePeerSettings#6a7e7366</li>
 * <li>{@link TLUpdatePhoneCall}: updatePhoneCall#ab0f6b1e</li>
 * <li>{@link TLUpdatePhoneCallSignalingData}: updatePhoneCallSignalingData#2661bf09</li>
 * <li>{@link TLUpdatePinnedChannelMessages}: updatePinnedChannelMessages#5bb98608</li>
 * <li>{@link TLUpdatePinnedDialogs}: updatePinnedDialogs#fa0f3ca2</li>
 * <li>{@link TLUpdatePinnedMessages}: updatePinnedMessages#ed85eab5</li>
 * <li>{@link TLUpdatePrivacy}: updatePrivacy#ee3b272a</li>
 * <li>{@link TLUpdatePtsChanged}: updatePtsChanged#3354678f</li>
 * <li>{@link TLUpdateReadChannelDiscussionInbox}: updateReadChannelDiscussionInbox#d6b19546</li>
 * <li>{@link TLUpdateReadChannelDiscussionOutbox}: updateReadChannelDiscussionOutbox#695c9e7c</li>
 * <li>{@link TLUpdateReadChannelInbox}: updateReadChannelInbox#922e6e10</li>
 * <li>{@link TLUpdateReadChannelOutbox}: updateReadChannelOutbox#b75f99a9</li>
 * <li>{@link TLUpdateReadChannelUserTyping}: updateChannelUserTyping#8c88c923</li>
 * <li>{@link TLUpdateReadFeaturedStickers}: updateReadFeaturedStickers#571d2742</li>
 * <li>{@link TLUpdateReadHistoryInbox}: updateReadHistoryInbox#9c974fdf</li>
 * <li>{@link TLUpdateReadHistoryOutbox}: updateReadHistoryOutbox#2f2f21bf</li>
 * <li>{@link TLUpdateReadMessagesContents}: updateReadMessagesContents#68c13933</li>
 * <li>{@link TLUpdateRecentStickers}: updateRecentStickers#9a422c20</li>
 * <li>{@link TLUpdateSavedGifs}: updateSavedGifs#9375341e</li>
 * <li>{@link TLUpdateServiceNotification}: updateServiceNotification#ebe46819</li>
 * <li>{@link TLUpdateStickerSets}: updateStickerSets#43ae3dec</li>
 * <li>{@link TLUpdateStickerSetsOrder}: updateStickerSetsOrder#bb2d201</li>
 * <li>{@link TLUpdateTheme}: updateTheme#8216fba3</li>
 * <li>{@link TLUpdateUserName}: updateUserName#c3f202e0</li>
 * <li>{@link TLUpdateUserPhone}: updateUserPhone#5492a13</li>
 * <li>{@link TLUpdateUserPhoto}: updateUserPhoto#f227868c</li>
 * <li>{@link TLUpdateUserStatus}: updateUserStatus#e5bdf8de</li>
 * <li>{@link TLUpdateUserTyping}: updateUserTyping#c01e857f</li>
 * <li>{@link TLUpdateWebPage}: updateWebPage#7f891213</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsUpdate extends TLObject {

    public TLAbsUpdate() {
    }
}
