package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLUpdateBotCallbackQuery}: updateBotCallbackQuery#e73547e1</li>
 * <li>{@link TLUpdateBotInlineQuery}: updateBotInlineQuery#54826690</li>
 * <li>{@link TLUpdateBotInlineSend}: updateBotInlineSend#e48f964</li>
 * <li>{@link TLUpdateBotPrecheckoutQuery}: updateBotPrecheckoutQuery#5d2f3aa9</li>
 * <li>{@link TLUpdateBotShippingQuery}: updateBotShippingQuery#e0cdc940</li>
 * <li>{@link TLUpdateBotWebhookJSON}: updateBotWebhookJSON#8317c0c3</li>
 * <li>{@link TLUpdateBotWebhookJSONQuery}: updateBotWebhookJSONQuery#9b9240a6</li>
 * <li>{@link TLUpdateChannel}: updateChannel#635b4c09</li>
 * <li>{@link TLUpdateChannelMessageViews}: updateChannelMessageViews#f226ac08</li>
 * <li>{@link TLUpdateChannelPinnedMessage}: updateChannelPinnedMessage#98592475</li>
 * <li>{@link TLUpdateChannelTooLong}: updateChannelTooLong#108d941f</li>
 * <li>{@link TLUpdateChannelWebPage}: updateChannelWebPage#2f2ba99f</li>
 * <li>{@link TLUpdateChatAdmins}: updateChatAdmins#6e947941</li>
 * <li>{@link TLUpdateChatParticipantAdd}: updateChatParticipantAdd#3dda5451</li>
 * <li>{@link TLUpdateChatParticipantAdmin}: updateChatParticipantAdmin#d7ca61a2</li>
 * <li>{@link TLUpdateChatParticipantDelete}: updateChatParticipantDelete#e32f3d77</li>
 * <li>{@link TLUpdateChatParticipants}: updateChatParticipants#7761198</li>
 * <li>{@link TLUpdateChatUserTyping}: updateChatUserTyping#83487af0</li>
 * <li>{@link TLUpdateConfig}: updateConfig#a229dd06</li>
 * <li>{@link TLUpdateDcOptions}: updateDcOptions#8e5e9873</li>
 * <li>{@link TLUpdateDeleteChannelMessages}: updateDeleteChannelMessages#c37521c9</li>
 * <li>{@link TLUpdateDeleteMessages}: updateDeleteMessages#a20db0e5</li>
 * <li>{@link TLUpdateDialogPinned}: updateDialogPinned#d711a2cc</li>
 * <li>{@link TLUpdateDraftMessage}: updateDraftMessage#ee2bb969</li>
 * <li>{@link TLUpdateEditChannelMessage}: updateEditChannelMessage#1b3f4df7</li>
 * <li>{@link TLUpdateEditMessage}: updateEditMessage#e40370a3</li>
 * <li>{@link TLUpdateEncryptedChatTyping}: updateEncryptedChatTyping#1710f156</li>
 * <li>{@link TLUpdateEncryptedMessagesRead}: updateEncryptedMessagesRead#38fe25b7</li>
 * <li>{@link TLUpdateEncryption}: updateEncryption#b4a2e88d</li>
 * <li>{@link TLUpdateInlineBotCallbackQuery}: updateInlineBotCallbackQuery#691e9052</li>
 * <li>{@link TLUpdateMessageID}: updateMessageID#4e90bfd6</li>
 * <li>{@link TLUpdateNewChannelMessage}: updateNewChannelMessage#62ba04d9</li>
 * <li>{@link TLUpdateNewEncryptedMessage}: updateNewEncryptedMessage#12bcbd9a</li>
 * <li>{@link TLUpdateNewMessage}: updateNewMessage#1f2b0afd</li>
 * <li>{@link TLUpdateNewStickerSet}: updateNewStickerSet#688a30aa</li>
 * <li>{@link TLUpdateNotifySettings}: updateNotifySettings#bec268ef</li>
 * <li>{@link TLUpdatePeerSettings}: updatePeerSettings#6a7e7366</li>
 * <li>{@link TLUpdatePhoneCall}: updatePhoneCall#ab0f6b1e</li>
 * <li>{@link TLUpdatePinnedDialogs}: updatePinnedDialogs#d8caf68d</li>
 * <li>{@link TLUpdatePrivacy}: updatePrivacy#ee3b272a</li>
 * <li>{@link TLUpdatePtsChanged}: updatePtsChanged#3354678f</li>
 * <li>{@link TLUpdateReadChannelInbox}: updateReadChannelInbox#922e6e10</li>
 * <li>{@link TLUpdateReadChannelOutbox}: updateReadChannelOutbox#b75f99a9</li>
 * <li>{@link TLUpdateReadFeaturedStickers}: updateReadFeaturedStickers#571d2742</li>
 * <li>{@link TLUpdateReadHistoryInbox}: updateReadHistoryInbox#9961fd5c</li>
 * <li>{@link TLUpdateReadHistoryOutbox}: updateReadHistoryOutbox#2f2f21bf</li>
 * <li>{@link TLUpdateReadMessagesContents}: updateReadMessagesContents#68c13933</li>
 * <li>{@link TLUpdateRecentStickers}: updateRecentStickers#9a422c20</li>
 * <li>{@link TLUpdateSavedGifs}: updateSavedGifs#9375341e</li>
 * <li>{@link TLUpdateServiceNotification}: updateServiceNotification#ebe46819</li>
 * <li>{@link TLUpdateStickerSets}: updateStickerSets#43ae3dec</li>
 * <li>{@link TLUpdateStickerSetsOrder}: updateStickerSetsOrder#bb2d201</li>
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
