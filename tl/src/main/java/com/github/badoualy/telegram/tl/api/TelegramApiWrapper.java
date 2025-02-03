package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.api.account.TLAbsEmailVerified;
import com.github.badoualy.telegram.tl.api.account.TLAbsEmojiStatuses;
import com.github.badoualy.telegram.tl.api.account.TLAbsResetPasswordResult;
import com.github.badoualy.telegram.tl.api.account.TLAbsSavedRingtone;
import com.github.badoualy.telegram.tl.api.account.TLAbsSavedRingtones;
import com.github.badoualy.telegram.tl.api.account.TLAbsThemes;
import com.github.badoualy.telegram.tl.api.account.TLAbsWallPapers;
import com.github.badoualy.telegram.tl.api.account.TLAuthorizationForm;
import com.github.badoualy.telegram.tl.api.account.TLAuthorizations;
import com.github.badoualy.telegram.tl.api.account.TLBusinessChatLinks;
import com.github.badoualy.telegram.tl.api.account.TLConnectedBots;
import com.github.badoualy.telegram.tl.api.account.TLContentSettings;
import com.github.badoualy.telegram.tl.api.account.TLPassword;
import com.github.badoualy.telegram.tl.api.account.TLPasswordInputSettings;
import com.github.badoualy.telegram.tl.api.account.TLPasswordSettings;
import com.github.badoualy.telegram.tl.api.account.TLPrivacyRules;
import com.github.badoualy.telegram.tl.api.account.TLResolvedBusinessChatLinks;
import com.github.badoualy.telegram.tl.api.account.TLSentEmailCode;
import com.github.badoualy.telegram.tl.api.account.TLTakeout;
import com.github.badoualy.telegram.tl.api.account.TLTmpPassword;
import com.github.badoualy.telegram.tl.api.account.TLWebAuthorizations;
import com.github.badoualy.telegram.tl.api.auth.TLAbsAuthorization;
import com.github.badoualy.telegram.tl.api.auth.TLAbsLoginToken;
import com.github.badoualy.telegram.tl.api.auth.TLAbsSentCode;
import com.github.badoualy.telegram.tl.api.auth.TLExportedAuthorization;
import com.github.badoualy.telegram.tl.api.auth.TLLoggedOut;
import com.github.badoualy.telegram.tl.api.auth.TLPasswordRecovery;
import com.github.badoualy.telegram.tl.api.bots.TLBotInfo;
import com.github.badoualy.telegram.tl.api.bots.TLPopularAppBots;
import com.github.badoualy.telegram.tl.api.bots.TLPreviewInfo;
import com.github.badoualy.telegram.tl.api.channels.TLAbsChannelParticipants;
import com.github.badoualy.telegram.tl.api.channels.TLAbsSponsoredMessageReportResult;
import com.github.badoualy.telegram.tl.api.channels.TLAdminLogResults;
import com.github.badoualy.telegram.tl.api.channels.TLChannelParticipant;
import com.github.badoualy.telegram.tl.api.channels.TLSendAsPeers;
import com.github.badoualy.telegram.tl.api.chatlists.TLAbsChatlistInvite;
import com.github.badoualy.telegram.tl.api.chatlists.TLChatlistUpdates;
import com.github.badoualy.telegram.tl.api.chatlists.TLExportedInvites;
import com.github.badoualy.telegram.tl.api.contacts.TLAbsBlocked;
import com.github.badoualy.telegram.tl.api.contacts.TLAbsContacts;
import com.github.badoualy.telegram.tl.api.contacts.TLAbsTopPeers;
import com.github.badoualy.telegram.tl.api.contacts.TLContactBirthdays;
import com.github.badoualy.telegram.tl.api.contacts.TLFound;
import com.github.badoualy.telegram.tl.api.contacts.TLImportedContacts;
import com.github.badoualy.telegram.tl.api.contacts.TLResolvedPeer;
import com.github.badoualy.telegram.tl.api.fragment.TLCollectibleInfo;
import com.github.badoualy.telegram.tl.api.help.TLAbsAppConfig;
import com.github.badoualy.telegram.tl.api.help.TLAbsAppUpdate;
import com.github.badoualy.telegram.tl.api.help.TLAbsCountriesList;
import com.github.badoualy.telegram.tl.api.help.TLAbsDeepLinkInfo;
import com.github.badoualy.telegram.tl.api.help.TLAbsPassportConfig;
import com.github.badoualy.telegram.tl.api.help.TLAbsPeerColors;
import com.github.badoualy.telegram.tl.api.help.TLAbsPromoData;
import com.github.badoualy.telegram.tl.api.help.TLAbsTermsOfServiceUpdate;
import com.github.badoualy.telegram.tl.api.help.TLAbsTimezonesList;
import com.github.badoualy.telegram.tl.api.help.TLAbsUserInfo;
import com.github.badoualy.telegram.tl.api.help.TLInviteText;
import com.github.badoualy.telegram.tl.api.help.TLPremiumPromo;
import com.github.badoualy.telegram.tl.api.help.TLRecentMeUrls;
import com.github.badoualy.telegram.tl.api.help.TLSupport;
import com.github.badoualy.telegram.tl.api.help.TLSupportName;
import com.github.badoualy.telegram.tl.api.messages.TLAbsAllStickers;
import com.github.badoualy.telegram.tl.api.messages.TLAbsAvailableEffects;
import com.github.badoualy.telegram.tl.api.messages.TLAbsAvailableReactions;
import com.github.badoualy.telegram.tl.api.messages.TLAbsChats;
import com.github.badoualy.telegram.tl.api.messages.TLAbsDhConfig;
import com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs;
import com.github.badoualy.telegram.tl.api.messages.TLAbsEmojiGroups;
import com.github.badoualy.telegram.tl.api.messages.TLAbsFavedStickers;
import com.github.badoualy.telegram.tl.api.messages.TLAbsFeaturedStickers;
import com.github.badoualy.telegram.tl.api.messages.TLAbsFoundStickerSets;
import com.github.badoualy.telegram.tl.api.messages.TLAbsFoundStickers;
import com.github.badoualy.telegram.tl.api.messages.TLAbsMessages;
import com.github.badoualy.telegram.tl.api.messages.TLAbsQuickReplies;
import com.github.badoualy.telegram.tl.api.messages.TLAbsReactions;
import com.github.badoualy.telegram.tl.api.messages.TLAbsRecentStickers;
import com.github.badoualy.telegram.tl.api.messages.TLAbsSavedDialogs;
import com.github.badoualy.telegram.tl.api.messages.TLAbsSavedGifs;
import com.github.badoualy.telegram.tl.api.messages.TLAbsSavedReactionTags;
import com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage;
import com.github.badoualy.telegram.tl.api.messages.TLAbsSponsoredMessages;
import com.github.badoualy.telegram.tl.api.messages.TLAbsStickerSet;
import com.github.badoualy.telegram.tl.api.messages.TLAbsStickerSetInstallResult;
import com.github.badoualy.telegram.tl.api.messages.TLAbsStickers;
import com.github.badoualy.telegram.tl.api.messages.TLAffectedFoundMessages;
import com.github.badoualy.telegram.tl.api.messages.TLAffectedHistory;
import com.github.badoualy.telegram.tl.api.messages.TLAffectedMessages;
import com.github.badoualy.telegram.tl.api.messages.TLArchivedStickers;
import com.github.badoualy.telegram.tl.api.messages.TLBotApp;
import com.github.badoualy.telegram.tl.api.messages.TLBotCallbackAnswer;
import com.github.badoualy.telegram.tl.api.messages.TLBotPreparedInlineMessage;
import com.github.badoualy.telegram.tl.api.messages.TLBotResults;
import com.github.badoualy.telegram.tl.api.messages.TLChatAdminsWithInvites;
import com.github.badoualy.telegram.tl.api.messages.TLChatFull;
import com.github.badoualy.telegram.tl.api.messages.TLChatInviteImporters;
import com.github.badoualy.telegram.tl.api.messages.TLCheckedHistoryImportPeer;
import com.github.badoualy.telegram.tl.api.messages.TLDialogFilters;
import com.github.badoualy.telegram.tl.api.messages.TLDiscussionMessage;
import com.github.badoualy.telegram.tl.api.messages.TLExportedChatInvites;
import com.github.badoualy.telegram.tl.api.messages.TLForumTopics;
import com.github.badoualy.telegram.tl.api.messages.TLHighScores;
import com.github.badoualy.telegram.tl.api.messages.TLHistoryImport;
import com.github.badoualy.telegram.tl.api.messages.TLHistoryImportParsed;
import com.github.badoualy.telegram.tl.api.messages.TLInactiveChats;
import com.github.badoualy.telegram.tl.api.messages.TLInvitedUsers;
import com.github.badoualy.telegram.tl.api.messages.TLMessageEditData;
import com.github.badoualy.telegram.tl.api.messages.TLMessageReactionsList;
import com.github.badoualy.telegram.tl.api.messages.TLMessageViews;
import com.github.badoualy.telegram.tl.api.messages.TLMyStickers;
import com.github.badoualy.telegram.tl.api.messages.TLPeerDialogs;
import com.github.badoualy.telegram.tl.api.messages.TLPeerSettings;
import com.github.badoualy.telegram.tl.api.messages.TLPreparedInlineMessage;
import com.github.badoualy.telegram.tl.api.messages.TLSearchCounter;
import com.github.badoualy.telegram.tl.api.messages.TLSearchResultsCalendar;
import com.github.badoualy.telegram.tl.api.messages.TLSearchResultsPositions;
import com.github.badoualy.telegram.tl.api.messages.TLTranscribedAudio;
import com.github.badoualy.telegram.tl.api.messages.TLTranslateResult;
import com.github.badoualy.telegram.tl.api.messages.TLVotesList;
import com.github.badoualy.telegram.tl.api.messages.TLWebPage;
import com.github.badoualy.telegram.tl.api.payments.TLAbsGiveawayInfo;
import com.github.badoualy.telegram.tl.api.payments.TLAbsPaymentForm;
import com.github.badoualy.telegram.tl.api.payments.TLAbsPaymentReceipt;
import com.github.badoualy.telegram.tl.api.payments.TLAbsPaymentResult;
import com.github.badoualy.telegram.tl.api.payments.TLAbsStarGifts;
import com.github.badoualy.telegram.tl.api.payments.TLBankCardData;
import com.github.badoualy.telegram.tl.api.payments.TLCheckedGiftCode;
import com.github.badoualy.telegram.tl.api.payments.TLConnectedStarRefBots;
import com.github.badoualy.telegram.tl.api.payments.TLExportedInvoice;
import com.github.badoualy.telegram.tl.api.payments.TLSavedInfo;
import com.github.badoualy.telegram.tl.api.payments.TLStarsRevenueAdsAccountUrl;
import com.github.badoualy.telegram.tl.api.payments.TLStarsRevenueStats;
import com.github.badoualy.telegram.tl.api.payments.TLStarsRevenueWithdrawalUrl;
import com.github.badoualy.telegram.tl.api.payments.TLStarsStatus;
import com.github.badoualy.telegram.tl.api.payments.TLSuggestedStarRefBots;
import com.github.badoualy.telegram.tl.api.payments.TLUserStarGifts;
import com.github.badoualy.telegram.tl.api.payments.TLValidatedRequestedInfo;
import com.github.badoualy.telegram.tl.api.phone.TLExportedGroupCallInvite;
import com.github.badoualy.telegram.tl.api.phone.TLGroupCall;
import com.github.badoualy.telegram.tl.api.phone.TLGroupCallStreamChannels;
import com.github.badoualy.telegram.tl.api.phone.TLGroupCallStreamRtmpUrl;
import com.github.badoualy.telegram.tl.api.phone.TLGroupParticipants;
import com.github.badoualy.telegram.tl.api.phone.TLJoinAsPeers;
import com.github.badoualy.telegram.tl.api.phone.TLPhoneCall;
import com.github.badoualy.telegram.tl.api.photos.TLAbsPhotos;
import com.github.badoualy.telegram.tl.api.photos.TLPhoto;
import com.github.badoualy.telegram.tl.api.premium.TLBoostsList;
import com.github.badoualy.telegram.tl.api.premium.TLBoostsStatus;
import com.github.badoualy.telegram.tl.api.premium.TLMyBoosts;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountAcceptAuthorization;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountCancelPasswordEmail;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountChangeAuthorizationSettings;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountChangePhone;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountCheckUsername;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountClearRecentEmojiStatuses;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountConfirmPasswordEmail;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountConfirmPhone;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountCreateBusinessChatLink;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountCreateTheme;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountDeclinePasswordReset;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountDeleteAccount;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountDeleteAutoSaveExceptions;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountDeleteBusinessChatLink;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountDeleteSecureValue;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountDisablePeerConnectedBot;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountEditBusinessChatLink;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountFinishTakeoutSession;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetAccountTTL;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetAllSecureValues;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetAuthorizationForm;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetAuthorizations;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetAutoDownloadSettings;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetAutoSaveSettings;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetBotBusinessConnection;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetBusinessChatLinks;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetChannelDefaultEmojiStatuses;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetChannelRestrictedStatusEmojis;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetChatThemes;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetConnectedBots;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetContactSignUpNotification;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetContentSettings;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetDefaultBackgroundEmojis;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetDefaultEmojiStatuses;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetDefaultGroupPhotoEmojis;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetDefaultProfilePhotoEmojis;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetGlobalPrivacySettings;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetMultiWallPapers;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetNotifyExceptions;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetNotifySettings;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetPassword;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetPasswordSettings;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetPrivacy;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetReactionsNotifySettings;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetRecentEmojiStatuses;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetSavedRingtones;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetSecureValue;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetTheme;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetThemes;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetTmpPassword;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetWallPaper;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetWallPapers;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetWebAuthorizations;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountInitTakeoutSession;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountInstallTheme;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountInstallWallPaper;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountInvalidateSignInCodes;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountRegisterDevice;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountReorderUsernames;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountReportPeer;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountReportProfilePhoto;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountResendPasswordEmail;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountResetAuthorization;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountResetNotifySettings;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountResetPassword;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountResetWallPapers;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountResetWebAuthorization;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountResetWebAuthorizations;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountResolveBusinessChatLink;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSaveAutoDownloadSettings;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSaveAutoSaveSettings;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSaveRingtone;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSaveSecureValue;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSaveTheme;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSaveWallPaper;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSendChangePhoneCode;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSendConfirmPhoneCode;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSendVerifyEmailCode;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSendVerifyPhoneCode;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSetAccountTTL;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSetAuthorizationTTL;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSetContactSignUpNotification;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSetContentSettings;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSetGlobalPrivacySettings;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSetPrivacy;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSetReactionsNotifySettings;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountToggleConnectedBotPaused;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountToggleSponsoredMessages;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountToggleUsername;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUnregisterDevice;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateBirthday;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateBusinessAwayMessage;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateBusinessGreetingMessage;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateBusinessIntro;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateBusinessLocation;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateBusinessWorkHours;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateColor;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateConnectedBot;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateDeviceLocked;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateEmojiStatus;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateNotifySettings;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdatePasswordSettings;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdatePersonalChannel;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateProfile;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateStatus;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateTheme;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateUsername;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUploadRingtone;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUploadTheme;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUploadWallPaper;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountVerifyEmail;
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountVerifyPhone;
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthAcceptLoginToken;
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthBindTempAuthKey;
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthCancelCode;
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthCheckPassword;
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthCheckRecoveryPassword;
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthDropTempAuthKeys;
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthExportAuthorization;
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthExportLoginToken;
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthImportAuthorization;
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthImportBotAuthorization;
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthImportLoginToken;
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthImportWebTokenAuthorization;
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthLogOut;
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthRecoverPassword;
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthReportMissingCode;
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthRequestFirebaseSms;
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthRequestPasswordRecovery;
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthResendCode;
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthResetAuthorizations;
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthResetLoginEmail;
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthSendCode;
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthSignIn;
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthSignUp;
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsAddPreviewMedia;
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsAllowSendMessage;
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsAnswerWebhookJSONQuery;
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsCanSendMessage;
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsCheckDownloadFileParams;
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsDeletePreviewMedia;
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsEditPreviewMedia;
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsGetAdminedBots;
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsGetBotCommands;
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsGetBotInfo;
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsGetBotMenuButton;
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsGetPopularAppBots;
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsGetPreviewInfo;
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsGetPreviewMedias;
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsInvokeWebViewCustomMethod;
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsReorderPreviewMedias;
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsReorderUsernames;
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsResetBotCommands;
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsSendCustomRequest;
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsSetBotBroadcastDefaultAdminRights;
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsSetBotCommands;
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsSetBotGroupDefaultAdminRights;
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsSetBotInfo;
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsSetBotMenuButton;
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsToggleUserEmojiStatusPermission;
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsToggleUsername;
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsUpdateStarRefProgram;
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsUpdateUserEmojiStatus;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsCheckUsername;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsConvertToGigagroup;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsCreateChannel;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsCreateForumTopic;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsDeactivateAllUsernames;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsDeleteChannel;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsDeleteHistory;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsDeleteMessages;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsDeleteParticipantHistory;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsDeleteTopicHistory;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsEditAdmin;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsEditBanned;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsEditCreator;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsEditForumTopic;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsEditLocation;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsEditPhoto;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsEditTitle;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsExportMessageLink;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetAdminLog;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetAdminedPublicChannels;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetChannelRecommendations;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetChannels;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetForumTopics;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetForumTopicsByID;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetFullChannel;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetGroupsForDiscussion;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetInactiveChannels;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetLeftChannels;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetMessages;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetParticipant;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetParticipants;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetSendAs;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsInviteToChannel;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsJoinChannel;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsLeaveChannel;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsReadHistory;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsReadMessageContents;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsReorderPinnedForumTopics;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsReorderUsernames;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsReportAntiSpamFalsePositive;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsReportSpam;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsRestrictSponsoredMessages;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsSearchPosts;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsSetBoostsToUnblockRestrictions;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsSetDiscussionGroup;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsSetEmojiStickers;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsSetStickers;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsToggleAntiSpam;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsToggleForum;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsToggleJoinRequest;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsToggleJoinToSend;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsToggleParticipantsHidden;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsTogglePreHistoryHidden;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsToggleSignatures;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsToggleSlowMode;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsToggleUsername;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsToggleViewForumAsMessages;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsUpdateColor;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsUpdateEmojiStatus;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsUpdatePinnedForumTopic;
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsUpdateUsername;
import com.github.badoualy.telegram.tl.api.request.TLRequestChatlistsCheckChatlistInvite;
import com.github.badoualy.telegram.tl.api.request.TLRequestChatlistsDeleteExportedInvite;
import com.github.badoualy.telegram.tl.api.request.TLRequestChatlistsEditExportedInvite;
import com.github.badoualy.telegram.tl.api.request.TLRequestChatlistsExportChatlistInvite;
import com.github.badoualy.telegram.tl.api.request.TLRequestChatlistsGetChatlistUpdates;
import com.github.badoualy.telegram.tl.api.request.TLRequestChatlistsGetExportedInvites;
import com.github.badoualy.telegram.tl.api.request.TLRequestChatlistsGetLeaveChatlistSuggestions;
import com.github.badoualy.telegram.tl.api.request.TLRequestChatlistsHideChatlistUpdates;
import com.github.badoualy.telegram.tl.api.request.TLRequestChatlistsJoinChatlistInvite;
import com.github.badoualy.telegram.tl.api.request.TLRequestChatlistsJoinChatlistUpdates;
import com.github.badoualy.telegram.tl.api.request.TLRequestChatlistsLeaveChatlist;
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsAcceptContact;
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsAddContact;
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsBlock;
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsBlockFromReplies;
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsDeleteByPhones;
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsDeleteContacts;
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsEditCloseFriends;
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsExportContactToken;
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsGetBirthdays;
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsGetBlocked;
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsGetContactIDs;
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsGetContacts;
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsGetLocated;
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsGetSaved;
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsGetStatuses;
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsGetTopPeers;
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsImportContactToken;
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsImportContacts;
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsResetSaved;
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsResetTopPeerRating;
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsResolvePhone;
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsResolveUsername;
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsSearch;
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsSetBlocked;
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsToggleTopPeers;
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsUnblock;
import com.github.badoualy.telegram.tl.api.request.TLRequestFoldersEditPeerFolders;
import com.github.badoualy.telegram.tl.api.request.TLRequestFragmentGetCollectibleInfo;
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpAcceptTermsOfService;
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpDismissSuggestion;
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpEditUserInfo;
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetAppConfig;
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetAppUpdate;
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetCdnConfig;
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetConfig;
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetCountriesList;
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetDeepLinkInfo;
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetInviteText;
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetNearestDc;
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetPassportConfig;
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetPeerColors;
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetPeerProfileColors;
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetPremiumPromo;
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetPromoData;
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetRecentMeUrls;
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetSupport;
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetSupportName;
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetTermsOfServiceUpdate;
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetTimezonesList;
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetUserInfo;
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpHidePromoData;
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpSaveAppLog;
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpSetBotUpdatesStatus;
import com.github.badoualy.telegram.tl.api.request.TLRequestInitConnection;
import com.github.badoualy.telegram.tl.api.request.TLRequestInvokeAfterMsg;
import com.github.badoualy.telegram.tl.api.request.TLRequestInvokeAfterMsgs;
import com.github.badoualy.telegram.tl.api.request.TLRequestInvokeWithApnsSecret;
import com.github.badoualy.telegram.tl.api.request.TLRequestInvokeWithBusinessConnection;
import com.github.badoualy.telegram.tl.api.request.TLRequestInvokeWithGooglePlayIntegrity;
import com.github.badoualy.telegram.tl.api.request.TLRequestInvokeWithLayer;
import com.github.badoualy.telegram.tl.api.request.TLRequestInvokeWithMessagesRange;
import com.github.badoualy.telegram.tl.api.request.TLRequestInvokeWithTakeout;
import com.github.badoualy.telegram.tl.api.request.TLRequestInvokeWithoutUpdates;
import com.github.badoualy.telegram.tl.api.request.TLRequestLangpackGetDifference;
import com.github.badoualy.telegram.tl.api.request.TLRequestLangpackGetLangPack;
import com.github.badoualy.telegram.tl.api.request.TLRequestLangpackGetLanguage;
import com.github.badoualy.telegram.tl.api.request.TLRequestLangpackGetLanguages;
import com.github.badoualy.telegram.tl.api.request.TLRequestLangpackGetStrings;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesAcceptEncryption;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesAcceptUrlAuth;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesAddChatUser;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesCheckChatInvite;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesCheckHistoryImport;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesCheckHistoryImportPeer;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesCheckQuickReplyShortcut;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesClearAllDrafts;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesClearRecentReactions;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesClearRecentStickers;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesClickSponsoredMessage;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesCreateChat;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteChat;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteChatUser;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteExportedChatInvite;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteFactCheck;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteHistory;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteMessages;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeletePhoneCallHistory;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteQuickReplyMessages;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteQuickReplyShortcut;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteRevokedExportedChatInvites;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteSavedHistory;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteScheduledMessages;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDiscardEncryption;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditChatAbout;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditChatAdmin;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditChatDefaultBannedRights;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditChatPhoto;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditChatTitle;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditExportedChatInvite;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditFactCheck;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditInlineBotMessage;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditMessage;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditQuickReplyShortcut;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesExportChatInvite;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesFaveSticker;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesForwardMessages;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetAdminsWithInvites;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetAllDrafts;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetAllStickers;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetArchivedStickers;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetAttachMenuBot;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetAttachMenuBots;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetAttachedStickers;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetAvailableEffects;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetAvailableReactions;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetBotApp;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetBotCallbackAnswer;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetChatInviteImporters;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetChats;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetCommonChats;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetCustomEmojiDocuments;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetDefaultHistoryTTL;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetDefaultTagReactions;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetDhConfig;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetDialogFilters;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetDialogUnreadMarks;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetDialogs;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetDiscussionMessage;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetDocumentByHash;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetEmojiGroups;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetEmojiKeywords;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetEmojiKeywordsDifference;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetEmojiKeywordsLanguages;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetEmojiProfilePhotoGroups;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetEmojiStatusGroups;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetEmojiStickerGroups;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetEmojiStickers;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetEmojiURL;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetExportedChatInvite;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetExportedChatInvites;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetExtendedMedia;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetFactCheck;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetFavedStickers;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetFeaturedEmojiStickers;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetFeaturedStickers;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetFullChat;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetGameHighScores;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetHistory;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetInlineBotResults;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetInlineGameHighScores;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetMaskStickers;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetMessageEditData;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetMessageReactionsList;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetMessageReadParticipants;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetMessages;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetMessagesReactions;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetMessagesViews;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetMyStickers;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetOldFeaturedStickers;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetOnlines;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetOutboxReadDate;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetPaidReactionPrivacy;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetPeerDialogs;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetPeerSettings;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetPinnedDialogs;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetPinnedSavedDialogs;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetPollResults;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetPollVotes;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetPreparedInlineMessage;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetQuickReplies;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetQuickReplyMessages;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetRecentLocations;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetRecentReactions;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetRecentStickers;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetReplies;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetSavedDialogs;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetSavedGifs;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetSavedHistory;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetSavedReactionTags;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetScheduledHistory;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetScheduledMessages;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetSearchCounters;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetSearchResultsCalendar;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetSearchResultsPositions;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetSplitRanges;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetSponsoredMessages;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetStickerSet;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetStickers;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetSuggestedDialogFilters;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetTopReactions;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetUnreadMentions;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetUnreadReactions;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetWebPage;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetWebPagePreview;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesHideAllChatJoinRequests;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesHideChatJoinRequest;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesHidePeerSettingsBar;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesImportChatInvite;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesInitHistoryImport;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesInstallStickerSet;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesMarkDialogUnread;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesMigrateChat;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesProlongWebView;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesRateTranscribedAudio;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReadDiscussion;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReadEncryptedHistory;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReadFeaturedStickers;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReadHistory;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReadMentions;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReadMessageContents;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReadReactions;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReceivedMessages;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReceivedQueue;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReorderPinnedDialogs;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReorderPinnedSavedDialogs;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReorderQuickReplies;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReorderStickerSets;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReport;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReportEncryptedSpam;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReportReaction;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReportSpam;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReportSponsoredMessage;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesRequestAppWebView;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesRequestEncryption;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesRequestMainWebView;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesRequestSimpleWebView;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesRequestUrlAuth;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesRequestWebView;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSaveDefaultSendAs;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSaveDraft;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSaveGif;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSavePreparedInlineMessage;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSaveRecentSticker;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSearch;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSearchCustomEmoji;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSearchEmojiStickerSets;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSearchGlobal;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSearchSentMedia;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSearchStickerSets;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSearchStickers;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendBotRequestedPeer;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendEncrypted;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendEncryptedFile;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendEncryptedService;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendInlineBotResult;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendMedia;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendMessage;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendMultiMedia;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendPaidReaction;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendQuickReplyMessages;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendReaction;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendScheduledMessages;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendScreenshotNotification;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendVote;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendWebViewData;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendWebViewResultMessage;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetBotCallbackAnswer;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetBotPrecheckoutResults;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetBotShippingResults;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetChatAvailableReactions;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetChatTheme;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetChatWallPaper;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetDefaultHistoryTTL;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetDefaultReaction;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetEncryptedTyping;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetGameScore;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetHistoryTTL;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetInlineBotResults;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetInlineGameScore;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetTyping;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesStartBot;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesStartHistoryImport;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesToggleBotInAttachMenu;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesToggleDialogFilterTags;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesToggleDialogPin;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesToggleNoForwards;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesTogglePaidReactionPrivacy;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesTogglePeerTranslations;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesToggleSavedDialogPin;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesToggleStickerSets;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesTranscribeAudio;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesTranslateText;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesUninstallStickerSet;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesUnpinAllMessages;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesUpdateDialogFilter;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesUpdateDialogFiltersOrder;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesUpdatePinnedMessage;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesUpdateSavedReactionTag;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesUploadEncryptedFile;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesUploadImportedMedia;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesUploadMedia;
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesViewSponsoredMessage;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsApplyGiftCode;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsAssignAppStoreTransaction;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsAssignPlayMarketTransaction;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsBotCancelStarsSubscription;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsCanPurchasePremium;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsChangeStarsSubscription;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsCheckGiftCode;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsClearSavedInfo;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsConnectStarRefBot;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsConvertStarGift;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsEditConnectedStarRefBot;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsExportInvoice;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsFulfillStarsSubscription;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetBankCardData;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetConnectedStarRefBot;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetConnectedStarRefBots;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetGiveawayInfo;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetPaymentForm;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetPaymentReceipt;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetPremiumGiftCodeOptions;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetSavedInfo;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetStarGifts;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetStarsGiftOptions;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetStarsGiveawayOptions;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetStarsRevenueAdsAccountUrl;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetStarsRevenueStats;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetStarsRevenueWithdrawalUrl;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetStarsStatus;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetStarsSubscriptions;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetStarsTopupOptions;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetStarsTransactions;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetStarsTransactionsByID;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetSuggestedStarRefBots;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetUserStarGifts;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsLaunchPrepaidGiveaway;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsRefundStarsCharge;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsSaveStarGift;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsSendPaymentForm;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsSendStarsForm;
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsValidateRequestedInfo;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneAcceptCall;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneCheckGroupCall;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneConfirmCall;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneCreateGroupCall;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneDiscardCall;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneDiscardGroupCall;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneEditGroupCallParticipant;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneEditGroupCallTitle;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneExportGroupCallInvite;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneGetCallConfig;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneGetGroupCall;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneGetGroupCallJoinAs;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneGetGroupCallStreamChannels;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneGetGroupCallStreamRtmpUrl;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneGetGroupParticipants;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneInviteToGroupCall;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneJoinGroupCall;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneJoinGroupCallPresentation;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneLeaveGroupCall;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneLeaveGroupCallPresentation;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneReceivedCall;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneRequestCall;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneSaveCallDebug;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneSaveCallLog;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneSaveDefaultGroupCallJoinAs;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneSendSignalingData;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneSetCallRating;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneStartScheduledGroupCall;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneToggleGroupCallRecord;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneToggleGroupCallSettings;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneToggleGroupCallStartSubscription;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhotosDeletePhotos;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhotosGetUserPhotos;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhotosUpdateProfilePhoto;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhotosUploadContactProfilePhoto;
import com.github.badoualy.telegram.tl.api.request.TLRequestPhotosUploadProfilePhoto;
import com.github.badoualy.telegram.tl.api.request.TLRequestPremiumApplyBoost;
import com.github.badoualy.telegram.tl.api.request.TLRequestPremiumGetBoostsList;
import com.github.badoualy.telegram.tl.api.request.TLRequestPremiumGetBoostsStatus;
import com.github.badoualy.telegram.tl.api.request.TLRequestPremiumGetMyBoosts;
import com.github.badoualy.telegram.tl.api.request.TLRequestPremiumGetUserBoosts;
import com.github.badoualy.telegram.tl.api.request.TLRequestSmsjobsFinishJob;
import com.github.badoualy.telegram.tl.api.request.TLRequestSmsjobsGetSmsJob;
import com.github.badoualy.telegram.tl.api.request.TLRequestSmsjobsGetStatus;
import com.github.badoualy.telegram.tl.api.request.TLRequestSmsjobsIsEligibleToJoin;
import com.github.badoualy.telegram.tl.api.request.TLRequestSmsjobsJoin;
import com.github.badoualy.telegram.tl.api.request.TLRequestSmsjobsLeave;
import com.github.badoualy.telegram.tl.api.request.TLRequestSmsjobsUpdateSettings;
import com.github.badoualy.telegram.tl.api.request.TLRequestStatsGetBroadcastRevenueStats;
import com.github.badoualy.telegram.tl.api.request.TLRequestStatsGetBroadcastRevenueTransactions;
import com.github.badoualy.telegram.tl.api.request.TLRequestStatsGetBroadcastRevenueWithdrawalUrl;
import com.github.badoualy.telegram.tl.api.request.TLRequestStatsGetBroadcastStats;
import com.github.badoualy.telegram.tl.api.request.TLRequestStatsGetMegagroupStats;
import com.github.badoualy.telegram.tl.api.request.TLRequestStatsGetMessagePublicForwards;
import com.github.badoualy.telegram.tl.api.request.TLRequestStatsGetMessageStats;
import com.github.badoualy.telegram.tl.api.request.TLRequestStatsGetStoryPublicForwards;
import com.github.badoualy.telegram.tl.api.request.TLRequestStatsGetStoryStats;
import com.github.badoualy.telegram.tl.api.request.TLRequestStatsLoadAsyncGraph;
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersAddStickerToSet;
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersChangeSticker;
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersChangeStickerPosition;
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersCheckShortName;
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersCreateStickerSet;
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersDeleteStickerSet;
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersRemoveStickerFromSet;
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersRenameStickerSet;
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersReplaceSticker;
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersSetStickerSetThumb;
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersSuggestShortName;
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesActivateStealthMode;
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesCanSendStory;
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesDeleteStories;
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesEditStory;
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesExportStoryLink;
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesGetAllReadPeerStories;
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesGetAllStories;
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesGetChatsToSend;
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesGetPeerMaxIDs;
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesGetPeerStories;
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesGetPinnedStories;
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesGetStoriesArchive;
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesGetStoriesByID;
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesGetStoriesViews;
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesGetStoryReactionsList;
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesGetStoryViewsList;
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesIncrementStoryViews;
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesReadStories;
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesReport;
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesSearchPosts;
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesSendReaction;
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesSendStory;
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesToggleAllStoriesHidden;
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesTogglePeerStoriesHidden;
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesTogglePinned;
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesTogglePinnedToTop;
import com.github.badoualy.telegram.tl.api.request.TLRequestUpdatesGetChannelDifference;
import com.github.badoualy.telegram.tl.api.request.TLRequestUpdatesGetDifference;
import com.github.badoualy.telegram.tl.api.request.TLRequestUpdatesGetState;
import com.github.badoualy.telegram.tl.api.request.TLRequestUploadGetCdnFile;
import com.github.badoualy.telegram.tl.api.request.TLRequestUploadGetCdnFileHashes;
import com.github.badoualy.telegram.tl.api.request.TLRequestUploadGetFile;
import com.github.badoualy.telegram.tl.api.request.TLRequestUploadGetFileHashes;
import com.github.badoualy.telegram.tl.api.request.TLRequestUploadGetWebFile;
import com.github.badoualy.telegram.tl.api.request.TLRequestUploadReuploadCdnFile;
import com.github.badoualy.telegram.tl.api.request.TLRequestUploadSaveBigFilePart;
import com.github.badoualy.telegram.tl.api.request.TLRequestUploadSaveFilePart;
import com.github.badoualy.telegram.tl.api.request.TLRequestUsersGetFullUser;
import com.github.badoualy.telegram.tl.api.request.TLRequestUsersGetIsPremiumRequiredToContact;
import com.github.badoualy.telegram.tl.api.request.TLRequestUsersGetUsers;
import com.github.badoualy.telegram.tl.api.request.TLRequestUsersSetSecureValueErrors;
import com.github.badoualy.telegram.tl.api.smsjobs.TLEligibleToJoin;
import com.github.badoualy.telegram.tl.api.smsjobs.TLStatus;
import com.github.badoualy.telegram.tl.api.stats.TLBroadcastRevenueStats;
import com.github.badoualy.telegram.tl.api.stats.TLBroadcastRevenueTransactions;
import com.github.badoualy.telegram.tl.api.stats.TLBroadcastRevenueWithdrawalUrl;
import com.github.badoualy.telegram.tl.api.stats.TLBroadcastStats;
import com.github.badoualy.telegram.tl.api.stats.TLMegagroupStats;
import com.github.badoualy.telegram.tl.api.stats.TLMessageStats;
import com.github.badoualy.telegram.tl.api.stats.TLPublicForwards;
import com.github.badoualy.telegram.tl.api.stats.TLStoryStats;
import com.github.badoualy.telegram.tl.api.stickers.TLSuggestedShortName;
import com.github.badoualy.telegram.tl.api.stories.TLAbsAllStories;
import com.github.badoualy.telegram.tl.api.stories.TLFoundStories;
import com.github.badoualy.telegram.tl.api.stories.TLPeerStories;
import com.github.badoualy.telegram.tl.api.stories.TLStories;
import com.github.badoualy.telegram.tl.api.stories.TLStoryReactionsList;
import com.github.badoualy.telegram.tl.api.stories.TLStoryViews;
import com.github.badoualy.telegram.tl.api.stories.TLStoryViewsList;
import com.github.badoualy.telegram.tl.api.updates.TLAbsChannelDifference;
import com.github.badoualy.telegram.tl.api.updates.TLAbsDifference;
import com.github.badoualy.telegram.tl.api.updates.TLState;
import com.github.badoualy.telegram.tl.api.upload.TLAbsCdnFile;
import com.github.badoualy.telegram.tl.api.upload.TLAbsFile;
import com.github.badoualy.telegram.tl.api.upload.TLWebFile;
import com.github.badoualy.telegram.tl.api.users.TLUserFull;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLIntVector;
import com.github.badoualy.telegram.tl.core.TLLongVector;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLStringVector;
import com.github.badoualy.telegram.tl.core.TLVector;
import com.github.badoualy.telegram.tl.exception.RpcErrorException;
import java.io.IOException;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
@SuppressWarnings({"unused", "unchecked", "RedundantCast"})
public abstract class TelegramApiWrapper implements TelegramApi {
    public abstract <T extends TLObject> T executeRpcQuery(TLMethod<T> method) throws RpcErrorException, IOException;

    @Override
    public TLBool accountAcceptAuthorization(long botId, String scope, String publicKey, TLVector<TLSecureValueHash> valueHashes, TLSecureCredentialsEncrypted credentials) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountAcceptAuthorization(botId, scope, publicKey, valueHashes, credentials));
    }

    @Override
    public TLBool accountCancelPasswordEmail() throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountCancelPasswordEmail());
    }

    @Override
    public TLBool accountChangeAuthorizationSettings(boolean confirmed, long hash, boolean encryptedRequestsDisabled, boolean callRequestsDisabled) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountChangeAuthorizationSettings(confirmed, hash, encryptedRequestsDisabled, callRequestsDisabled));
    }

    @Override
    public TLAbsUser accountChangePhone(String phoneNumber, String phoneCodeHash, String phoneCode) throws RpcErrorException, IOException {
        return (TLAbsUser) executeRpcQuery(new TLRequestAccountChangePhone(phoneNumber, phoneCodeHash, phoneCode));
    }

    @Override
    public TLBool accountCheckUsername(String username) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountCheckUsername(username));
    }

    @Override
    public TLBool accountClearRecentEmojiStatuses() throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountClearRecentEmojiStatuses());
    }

    @Override
    public TLBool accountConfirmPasswordEmail(String code) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountConfirmPasswordEmail(code));
    }

    @Override
    public TLBool accountConfirmPhone(String phoneCodeHash, String phoneCode) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountConfirmPhone(phoneCodeHash, phoneCode));
    }

    @Override
    public TLBusinessChatLink accountCreateBusinessChatLink(TLInputBusinessChatLink link) throws RpcErrorException, IOException {
        return (TLBusinessChatLink) executeRpcQuery(new TLRequestAccountCreateBusinessChatLink(link));
    }

    @Override
    public TLTheme accountCreateTheme(String slug, String title, TLAbsInputDocument document, TLVector<TLInputThemeSettings> settings) throws RpcErrorException, IOException {
        return (TLTheme) executeRpcQuery(new TLRequestAccountCreateTheme(slug, title, document, settings));
    }

    @Override
    public TLBool accountDeclinePasswordReset() throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountDeclinePasswordReset());
    }

    @Override
    public TLBool accountDeleteAccount(String reason, TLAbsInputCheckPasswordSRP password) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountDeleteAccount(reason, password));
    }

    @Override
    public TLBool accountDeleteAutoSaveExceptions() throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountDeleteAutoSaveExceptions());
    }

    @Override
    public TLBool accountDeleteBusinessChatLink(String slug) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountDeleteBusinessChatLink(slug));
    }

    @Override
    public TLBool accountDeleteSecureValue(TLVector<TLAbsSecureValueType> types) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountDeleteSecureValue(types));
    }

    @Override
    public TLBool accountDisablePeerConnectedBot(TLAbsInputPeer peer) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountDisablePeerConnectedBot(peer));
    }

    @Override
    public TLBusinessChatLink accountEditBusinessChatLink(String slug, TLInputBusinessChatLink link) throws RpcErrorException, IOException {
        return (TLBusinessChatLink) executeRpcQuery(new TLRequestAccountEditBusinessChatLink(slug, link));
    }

    @Override
    public TLBool accountFinishTakeoutSession(boolean success) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountFinishTakeoutSession(success));
    }

    @Override
    public TLAccountDaysTTL accountGetAccountTTL() throws RpcErrorException, IOException {
        return (TLAccountDaysTTL) executeRpcQuery(new TLRequestAccountGetAccountTTL());
    }

    @Override
    public TLVector<TLSecureValue> accountGetAllSecureValues() throws RpcErrorException, IOException {
        return (TLVector<TLSecureValue>) executeRpcQuery(new TLRequestAccountGetAllSecureValues());
    }

    @Override
    public TLAuthorizationForm accountGetAuthorizationForm(long botId, String scope, String publicKey) throws RpcErrorException, IOException {
        return (TLAuthorizationForm) executeRpcQuery(new TLRequestAccountGetAuthorizationForm(botId, scope, publicKey));
    }

    @Override
    public TLAuthorizations accountGetAuthorizations() throws RpcErrorException, IOException {
        return (TLAuthorizations) executeRpcQuery(new TLRequestAccountGetAuthorizations());
    }

    @Override
    public com.github.badoualy.telegram.tl.api.account.TLAutoDownloadSettings accountGetAutoDownloadSettings() throws RpcErrorException, IOException {
        return (com.github.badoualy.telegram.tl.api.account.TLAutoDownloadSettings) executeRpcQuery(new TLRequestAccountGetAutoDownloadSettings());
    }

    @Override
    public com.github.badoualy.telegram.tl.api.account.TLAutoSaveSettings accountGetAutoSaveSettings() throws RpcErrorException, IOException {
        return (com.github.badoualy.telegram.tl.api.account.TLAutoSaveSettings) executeRpcQuery(new TLRequestAccountGetAutoSaveSettings());
    }

    @Override
    public TLAbsUpdates accountGetBotBusinessConnection(String connectionId) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestAccountGetBotBusinessConnection(connectionId));
    }

    @Override
    public TLBusinessChatLinks accountGetBusinessChatLinks() throws RpcErrorException, IOException {
        return (TLBusinessChatLinks) executeRpcQuery(new TLRequestAccountGetBusinessChatLinks());
    }

    @Override
    public TLAbsEmojiStatuses accountGetChannelDefaultEmojiStatuses(long hash) throws RpcErrorException, IOException {
        return (TLAbsEmojiStatuses) executeRpcQuery(new TLRequestAccountGetChannelDefaultEmojiStatuses(hash));
    }

    @Override
    public TLAbsEmojiList accountGetChannelRestrictedStatusEmojis(long hash) throws RpcErrorException, IOException {
        return (TLAbsEmojiList) executeRpcQuery(new TLRequestAccountGetChannelRestrictedStatusEmojis(hash));
    }

    @Override
    public TLAbsThemes accountGetChatThemes(long hash) throws RpcErrorException, IOException {
        return (TLAbsThemes) executeRpcQuery(new TLRequestAccountGetChatThemes(hash));
    }

    @Override
    public TLConnectedBots accountGetConnectedBots() throws RpcErrorException, IOException {
        return (TLConnectedBots) executeRpcQuery(new TLRequestAccountGetConnectedBots());
    }

    @Override
    public TLBool accountGetContactSignUpNotification() throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountGetContactSignUpNotification());
    }

    @Override
    public TLContentSettings accountGetContentSettings() throws RpcErrorException, IOException {
        return (TLContentSettings) executeRpcQuery(new TLRequestAccountGetContentSettings());
    }

    @Override
    public TLAbsEmojiList accountGetDefaultBackgroundEmojis(long hash) throws RpcErrorException, IOException {
        return (TLAbsEmojiList) executeRpcQuery(new TLRequestAccountGetDefaultBackgroundEmojis(hash));
    }

    @Override
    public TLAbsEmojiStatuses accountGetDefaultEmojiStatuses(long hash) throws RpcErrorException, IOException {
        return (TLAbsEmojiStatuses) executeRpcQuery(new TLRequestAccountGetDefaultEmojiStatuses(hash));
    }

    @Override
    public TLAbsEmojiList accountGetDefaultGroupPhotoEmojis(long hash) throws RpcErrorException, IOException {
        return (TLAbsEmojiList) executeRpcQuery(new TLRequestAccountGetDefaultGroupPhotoEmojis(hash));
    }

    @Override
    public TLAbsEmojiList accountGetDefaultProfilePhotoEmojis(long hash) throws RpcErrorException, IOException {
        return (TLAbsEmojiList) executeRpcQuery(new TLRequestAccountGetDefaultProfilePhotoEmojis(hash));
    }

    @Override
    public TLGlobalPrivacySettings accountGetGlobalPrivacySettings() throws RpcErrorException, IOException {
        return (TLGlobalPrivacySettings) executeRpcQuery(new TLRequestAccountGetGlobalPrivacySettings());
    }

    @Override
    public TLVector<TLAbsWallPaper> accountGetMultiWallPapers(TLVector<TLAbsInputWallPaper> wallpapers) throws RpcErrorException, IOException {
        return (TLVector<TLAbsWallPaper>) executeRpcQuery(new TLRequestAccountGetMultiWallPapers(wallpapers));
    }

    @Override
    public TLAbsUpdates accountGetNotifyExceptions(boolean compareSound, boolean compareStories, TLAbsInputNotifyPeer peer) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestAccountGetNotifyExceptions(compareSound, compareStories, peer));
    }

    @Override
    public TLPeerNotifySettings accountGetNotifySettings(TLAbsInputNotifyPeer peer) throws RpcErrorException, IOException {
        return (TLPeerNotifySettings) executeRpcQuery(new TLRequestAccountGetNotifySettings(peer));
    }

    @Override
    public TLPassword accountGetPassword() throws RpcErrorException, IOException {
        return (TLPassword) executeRpcQuery(new TLRequestAccountGetPassword());
    }

    @Override
    public TLPasswordSettings accountGetPasswordSettings(TLAbsInputCheckPasswordSRP password) throws RpcErrorException, IOException {
        return (TLPasswordSettings) executeRpcQuery(new TLRequestAccountGetPasswordSettings(password));
    }

    @Override
    public TLPrivacyRules accountGetPrivacy(TLAbsInputPrivacyKey key) throws RpcErrorException, IOException {
        return (TLPrivacyRules) executeRpcQuery(new TLRequestAccountGetPrivacy(key));
    }

    @Override
    public TLReactionsNotifySettings accountGetReactionsNotifySettings() throws RpcErrorException, IOException {
        return (TLReactionsNotifySettings) executeRpcQuery(new TLRequestAccountGetReactionsNotifySettings());
    }

    @Override
    public TLAbsEmojiStatuses accountGetRecentEmojiStatuses(long hash) throws RpcErrorException, IOException {
        return (TLAbsEmojiStatuses) executeRpcQuery(new TLRequestAccountGetRecentEmojiStatuses(hash));
    }

    @Override
    public TLAbsSavedRingtones accountGetSavedRingtones(long hash) throws RpcErrorException, IOException {
        return (TLAbsSavedRingtones) executeRpcQuery(new TLRequestAccountGetSavedRingtones(hash));
    }

    @Override
    public TLVector<TLSecureValue> accountGetSecureValue(TLVector<TLAbsSecureValueType> types) throws RpcErrorException, IOException {
        return (TLVector<TLSecureValue>) executeRpcQuery(new TLRequestAccountGetSecureValue(types));
    }

    @Override
    public TLTheme accountGetTheme(String format, TLAbsInputTheme theme) throws RpcErrorException, IOException {
        return (TLTheme) executeRpcQuery(new TLRequestAccountGetTheme(format, theme));
    }

    @Override
    public TLAbsThemes accountGetThemes(String format, long hash) throws RpcErrorException, IOException {
        return (TLAbsThemes) executeRpcQuery(new TLRequestAccountGetThemes(format, hash));
    }

    @Override
    public TLTmpPassword accountGetTmpPassword(TLAbsInputCheckPasswordSRP password, int period) throws RpcErrorException, IOException {
        return (TLTmpPassword) executeRpcQuery(new TLRequestAccountGetTmpPassword(password, period));
    }

    @Override
    public TLAbsWallPaper accountGetWallPaper(TLAbsInputWallPaper wallpaper) throws RpcErrorException, IOException {
        return (TLAbsWallPaper) executeRpcQuery(new TLRequestAccountGetWallPaper(wallpaper));
    }

    @Override
    public TLAbsWallPapers accountGetWallPapers(long hash) throws RpcErrorException, IOException {
        return (TLAbsWallPapers) executeRpcQuery(new TLRequestAccountGetWallPapers(hash));
    }

    @Override
    public TLWebAuthorizations accountGetWebAuthorizations() throws RpcErrorException, IOException {
        return (TLWebAuthorizations) executeRpcQuery(new TLRequestAccountGetWebAuthorizations());
    }

    @Override
    public TLTakeout accountInitTakeoutSession(boolean contacts, boolean messageUsers, boolean messageChats, boolean messageMegagroups, boolean messageChannels, boolean files, Long fileMaxSize) throws RpcErrorException, IOException {
        return (TLTakeout) executeRpcQuery(new TLRequestAccountInitTakeoutSession(contacts, messageUsers, messageChats, messageMegagroups, messageChannels, files, fileMaxSize));
    }

    @Override
    public TLBool accountInstallTheme(boolean dark, TLAbsInputTheme theme, String format, TLAbsBaseTheme baseTheme) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountInstallTheme(dark, theme, format, baseTheme));
    }

    @Override
    public TLBool accountInstallWallPaper(TLAbsInputWallPaper wallpaper, TLWallPaperSettings settings) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountInstallWallPaper(wallpaper, settings));
    }

    @Override
    public TLBool accountInvalidateSignInCodes(TLStringVector codes) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountInvalidateSignInCodes(codes));
    }

    @Override
    public TLBool accountRegisterDevice(boolean noMuted, int tokenType, String token, boolean appSandbox, TLBytes secret, TLLongVector otherUids) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountRegisterDevice(noMuted, tokenType, token, appSandbox, secret, otherUids));
    }

    @Override
    public TLBool accountReorderUsernames(TLStringVector order) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountReorderUsernames(order));
    }

    @Override
    public TLBool accountReportPeer(TLAbsInputPeer peer, TLAbsReportReason reason, String message) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountReportPeer(peer, reason, message));
    }

    @Override
    public TLBool accountReportProfilePhoto(TLAbsInputPeer peer, TLAbsInputPhoto photoId, TLAbsReportReason reason, String message) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountReportProfilePhoto(peer, photoId, reason, message));
    }

    @Override
    public TLBool accountResendPasswordEmail() throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountResendPasswordEmail());
    }

    @Override
    public TLBool accountResetAuthorization(long hash) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountResetAuthorization(hash));
    }

    @Override
    public TLBool accountResetNotifySettings() throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountResetNotifySettings());
    }

    @Override
    public TLAbsResetPasswordResult accountResetPassword() throws RpcErrorException, IOException {
        return (TLAbsResetPasswordResult) executeRpcQuery(new TLRequestAccountResetPassword());
    }

    @Override
    public TLBool accountResetWallPapers() throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountResetWallPapers());
    }

    @Override
    public TLBool accountResetWebAuthorization(long hash) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountResetWebAuthorization(hash));
    }

    @Override
    public TLBool accountResetWebAuthorizations() throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountResetWebAuthorizations());
    }

    @Override
    public TLResolvedBusinessChatLinks accountResolveBusinessChatLink(String slug) throws RpcErrorException, IOException {
        return (TLResolvedBusinessChatLinks) executeRpcQuery(new TLRequestAccountResolveBusinessChatLink(slug));
    }

    @Override
    public TLBool accountSaveAutoDownloadSettings(boolean low, boolean high, TLAutoDownloadSettings settings) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountSaveAutoDownloadSettings(low, high, settings));
    }

    @Override
    public TLBool accountSaveAutoSaveSettings(boolean users, boolean chats, boolean broadcasts, TLAbsInputPeer peer, TLAutoSaveSettings settings) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountSaveAutoSaveSettings(users, chats, broadcasts, peer, settings));
    }

    @Override
    public TLAbsSavedRingtone accountSaveRingtone(TLAbsInputDocument id, boolean unsave) throws RpcErrorException, IOException {
        return (TLAbsSavedRingtone) executeRpcQuery(new TLRequestAccountSaveRingtone(id, unsave));
    }

    @Override
    public TLSecureValue accountSaveSecureValue(TLInputSecureValue value, long secureSecretId) throws RpcErrorException, IOException {
        return (TLSecureValue) executeRpcQuery(new TLRequestAccountSaveSecureValue(value, secureSecretId));
    }

    @Override
    public TLBool accountSaveTheme(TLAbsInputTheme theme, boolean unsave) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountSaveTheme(theme, unsave));
    }

    @Override
    public TLBool accountSaveWallPaper(TLAbsInputWallPaper wallpaper, boolean unsave, TLWallPaperSettings settings) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountSaveWallPaper(wallpaper, unsave, settings));
    }

    @Override
    public TLAbsSentCode accountSendChangePhoneCode(String phoneNumber, TLCodeSettings settings) throws RpcErrorException, IOException {
        return (TLAbsSentCode) executeRpcQuery(new TLRequestAccountSendChangePhoneCode(phoneNumber, settings));
    }

    @Override
    public TLAbsSentCode accountSendConfirmPhoneCode(String hash, TLCodeSettings settings) throws RpcErrorException, IOException {
        return (TLAbsSentCode) executeRpcQuery(new TLRequestAccountSendConfirmPhoneCode(hash, settings));
    }

    @Override
    public TLSentEmailCode accountSendVerifyEmailCode(TLAbsEmailVerifyPurpose purpose, String email) throws RpcErrorException, IOException {
        return (TLSentEmailCode) executeRpcQuery(new TLRequestAccountSendVerifyEmailCode(purpose, email));
    }

    @Override
    public TLAbsSentCode accountSendVerifyPhoneCode(String phoneNumber, TLCodeSettings settings) throws RpcErrorException, IOException {
        return (TLAbsSentCode) executeRpcQuery(new TLRequestAccountSendVerifyPhoneCode(phoneNumber, settings));
    }

    @Override
    public TLBool accountSetAccountTTL(TLAccountDaysTTL ttl) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountSetAccountTTL(ttl));
    }

    @Override
    public TLBool accountSetAuthorizationTTL(int authorizationTtlDays) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountSetAuthorizationTTL(authorizationTtlDays));
    }

    @Override
    public TLBool accountSetContactSignUpNotification(boolean silent) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountSetContactSignUpNotification(silent));
    }

    @Override
    public TLBool accountSetContentSettings(boolean sensitiveEnabled) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountSetContentSettings(sensitiveEnabled));
    }

    @Override
    public TLGlobalPrivacySettings accountSetGlobalPrivacySettings(TLGlobalPrivacySettings settings) throws RpcErrorException, IOException {
        return (TLGlobalPrivacySettings) executeRpcQuery(new TLRequestAccountSetGlobalPrivacySettings(settings));
    }

    @Override
    public TLPrivacyRules accountSetPrivacy(TLAbsInputPrivacyKey key, TLVector<TLAbsInputPrivacyRule> rules) throws RpcErrorException, IOException {
        return (TLPrivacyRules) executeRpcQuery(new TLRequestAccountSetPrivacy(key, rules));
    }

    @Override
    public TLReactionsNotifySettings accountSetReactionsNotifySettings(TLReactionsNotifySettings settings) throws RpcErrorException, IOException {
        return (TLReactionsNotifySettings) executeRpcQuery(new TLRequestAccountSetReactionsNotifySettings(settings));
    }

    @Override
    public TLBool accountToggleConnectedBotPaused(TLAbsInputPeer peer, boolean paused) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountToggleConnectedBotPaused(peer, paused));
    }

    @Override
    public TLBool accountToggleSponsoredMessages(boolean enabled) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountToggleSponsoredMessages(enabled));
    }

    @Override
    public TLBool accountToggleUsername(String username, boolean active) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountToggleUsername(username, active));
    }

    @Override
    public TLBool accountUnregisterDevice(int tokenType, String token, TLLongVector otherUids) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountUnregisterDevice(tokenType, token, otherUids));
    }

    @Override
    public TLBool accountUpdateBirthday(TLBirthday birthday) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountUpdateBirthday(birthday));
    }

    @Override
    public TLBool accountUpdateBusinessAwayMessage(TLInputBusinessAwayMessage message) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountUpdateBusinessAwayMessage(message));
    }

    @Override
    public TLBool accountUpdateBusinessGreetingMessage(TLInputBusinessGreetingMessage message) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountUpdateBusinessGreetingMessage(message));
    }

    @Override
    public TLBool accountUpdateBusinessIntro(TLInputBusinessIntro intro) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountUpdateBusinessIntro(intro));
    }

    @Override
    public TLBool accountUpdateBusinessLocation(TLAbsInputGeoPoint geoPoint, String address) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountUpdateBusinessLocation(geoPoint, address));
    }

    @Override
    public TLBool accountUpdateBusinessWorkHours(TLBusinessWorkHours businessWorkHours) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountUpdateBusinessWorkHours(businessWorkHours));
    }

    @Override
    public TLBool accountUpdateColor(boolean forProfile, Integer color, Long backgroundEmojiId) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountUpdateColor(forProfile, color, backgroundEmojiId));
    }

    @Override
    public TLAbsUpdates accountUpdateConnectedBot(boolean canReply, boolean deleted, TLAbsInputUser bot, TLInputBusinessBotRecipients recipients) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestAccountUpdateConnectedBot(canReply, deleted, bot, recipients));
    }

    @Override
    public TLBool accountUpdateDeviceLocked(int period) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountUpdateDeviceLocked(period));
    }

    @Override
    public TLBool accountUpdateEmojiStatus(TLAbsEmojiStatus emojiStatus) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountUpdateEmojiStatus(emojiStatus));
    }

    @Override
    public TLBool accountUpdateNotifySettings(TLAbsInputNotifyPeer peer, TLInputPeerNotifySettings settings) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountUpdateNotifySettings(peer, settings));
    }

    @Override
    public TLBool accountUpdatePasswordSettings(TLAbsInputCheckPasswordSRP password, TLPasswordInputSettings newSettings) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountUpdatePasswordSettings(password, newSettings));
    }

    @Override
    public TLBool accountUpdatePersonalChannel(TLAbsInputChannel channel) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountUpdatePersonalChannel(channel));
    }

    @Override
    public TLAbsUser accountUpdateProfile(String firstName, String lastName, String about) throws RpcErrorException, IOException {
        return (TLAbsUser) executeRpcQuery(new TLRequestAccountUpdateProfile(firstName, lastName, about));
    }

    @Override
    public TLBool accountUpdateStatus(boolean offline) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountUpdateStatus(offline));
    }

    @Override
    public TLTheme accountUpdateTheme(String format, TLAbsInputTheme theme, String slug, String title, TLAbsInputDocument document, TLVector<TLInputThemeSettings> settings) throws RpcErrorException, IOException {
        return (TLTheme) executeRpcQuery(new TLRequestAccountUpdateTheme(format, theme, slug, title, document, settings));
    }

    @Override
    public TLAbsUser accountUpdateUsername(String username) throws RpcErrorException, IOException {
        return (TLAbsUser) executeRpcQuery(new TLRequestAccountUpdateUsername(username));
    }

    @Override
    public TLAbsDocument accountUploadRingtone(TLAbsInputFile file, String fileName, String mimeType) throws RpcErrorException, IOException {
        return (TLAbsDocument) executeRpcQuery(new TLRequestAccountUploadRingtone(file, fileName, mimeType));
    }

    @Override
    public TLAbsDocument accountUploadTheme(TLAbsInputFile file, TLAbsInputFile thumb, String fileName, String mimeType) throws RpcErrorException, IOException {
        return (TLAbsDocument) executeRpcQuery(new TLRequestAccountUploadTheme(file, thumb, fileName, mimeType));
    }

    @Override
    public TLAbsWallPaper accountUploadWallPaper(boolean forChat, TLAbsInputFile file, String mimeType, TLWallPaperSettings settings) throws RpcErrorException, IOException {
        return (TLAbsWallPaper) executeRpcQuery(new TLRequestAccountUploadWallPaper(forChat, file, mimeType, settings));
    }

    @Override
    public TLAbsEmailVerified accountVerifyEmail(TLAbsEmailVerifyPurpose purpose, TLAbsEmailVerification verification) throws RpcErrorException, IOException {
        return (TLAbsEmailVerified) executeRpcQuery(new TLRequestAccountVerifyEmail(purpose, verification));
    }

    @Override
    public TLBool accountVerifyPhone(String phoneNumber, String phoneCodeHash, String phoneCode) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountVerifyPhone(phoneNumber, phoneCodeHash, phoneCode));
    }

    @Override
    public TLAuthorization authAcceptLoginToken(TLBytes token) throws RpcErrorException, IOException {
        return (TLAuthorization) executeRpcQuery(new TLRequestAuthAcceptLoginToken(token));
    }

    @Override
    public TLBool authBindTempAuthKey(long permAuthKeyId, long nonce, int expiresAt, TLBytes encryptedMessage) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAuthBindTempAuthKey(permAuthKeyId, nonce, expiresAt, encryptedMessage));
    }

    @Override
    public TLBool authCancelCode(String phoneNumber, String phoneCodeHash) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAuthCancelCode(phoneNumber, phoneCodeHash));
    }

    @Override
    public TLAbsAuthorization authCheckPassword(TLAbsInputCheckPasswordSRP password) throws RpcErrorException, IOException {
        return (TLAbsAuthorization) executeRpcQuery(new TLRequestAuthCheckPassword(password));
    }

    @Override
    public TLBool authCheckRecoveryPassword(String code) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAuthCheckRecoveryPassword(code));
    }

    @Override
    public TLBool authDropTempAuthKeys(TLLongVector exceptAuthKeys) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAuthDropTempAuthKeys(exceptAuthKeys));
    }

    @Override
    public TLExportedAuthorization authExportAuthorization(int dcId) throws RpcErrorException, IOException {
        return (TLExportedAuthorization) executeRpcQuery(new TLRequestAuthExportAuthorization(dcId));
    }

    @Override
    public TLAbsLoginToken authExportLoginToken(int apiId, String apiHash, TLLongVector exceptIds) throws RpcErrorException, IOException {
        return (TLAbsLoginToken) executeRpcQuery(new TLRequestAuthExportLoginToken(apiId, apiHash, exceptIds));
    }

    @Override
    public TLAbsAuthorization authImportAuthorization(long id, TLBytes bytes) throws RpcErrorException, IOException {
        return (TLAbsAuthorization) executeRpcQuery(new TLRequestAuthImportAuthorization(id, bytes));
    }

    @Override
    public TLAbsAuthorization authImportBotAuthorization(int flags, int apiId, String apiHash, String botAuthToken) throws RpcErrorException, IOException {
        return (TLAbsAuthorization) executeRpcQuery(new TLRequestAuthImportBotAuthorization(flags, apiId, apiHash, botAuthToken));
    }

    @Override
    public TLAbsLoginToken authImportLoginToken(TLBytes token) throws RpcErrorException, IOException {
        return (TLAbsLoginToken) executeRpcQuery(new TLRequestAuthImportLoginToken(token));
    }

    @Override
    public TLAbsAuthorization authImportWebTokenAuthorization(int apiId, String apiHash, String webAuthToken) throws RpcErrorException, IOException {
        return (TLAbsAuthorization) executeRpcQuery(new TLRequestAuthImportWebTokenAuthorization(apiId, apiHash, webAuthToken));
    }

    @Override
    public TLLoggedOut authLogOut() throws RpcErrorException, IOException {
        return (TLLoggedOut) executeRpcQuery(new TLRequestAuthLogOut());
    }

    @Override
    public TLAbsAuthorization authRecoverPassword(String code, TLPasswordInputSettings newSettings) throws RpcErrorException, IOException {
        return (TLAbsAuthorization) executeRpcQuery(new TLRequestAuthRecoverPassword(code, newSettings));
    }

    @Override
    public TLBool authReportMissingCode(String phoneNumber, String phoneCodeHash, String mnc) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAuthReportMissingCode(phoneNumber, phoneCodeHash, mnc));
    }

    @Override
    public TLBool authRequestFirebaseSms(String phoneNumber, String phoneCodeHash, String safetyNetToken, String playIntegrityToken, String iosPushSecret) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAuthRequestFirebaseSms(phoneNumber, phoneCodeHash, safetyNetToken, playIntegrityToken, iosPushSecret));
    }

    @Override
    public TLPasswordRecovery authRequestPasswordRecovery() throws RpcErrorException, IOException {
        return (TLPasswordRecovery) executeRpcQuery(new TLRequestAuthRequestPasswordRecovery());
    }

    @Override
    public TLAbsSentCode authResendCode(String phoneNumber, String phoneCodeHash, String reason) throws RpcErrorException, IOException {
        return (TLAbsSentCode) executeRpcQuery(new TLRequestAuthResendCode(phoneNumber, phoneCodeHash, reason));
    }

    @Override
    public TLBool authResetAuthorizations() throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAuthResetAuthorizations());
    }

    @Override
    public TLAbsSentCode authResetLoginEmail(String phoneNumber, String phoneCodeHash) throws RpcErrorException, IOException {
        return (TLAbsSentCode) executeRpcQuery(new TLRequestAuthResetLoginEmail(phoneNumber, phoneCodeHash));
    }

    @Override
    public TLAbsSentCode authSendCode(String phoneNumber, int apiId, String apiHash, TLCodeSettings settings) throws RpcErrorException, IOException {
        return (TLAbsSentCode) executeRpcQuery(new TLRequestAuthSendCode(phoneNumber, apiId, apiHash, settings));
    }

    @Override
    public TLAbsAuthorization authSignIn(String phoneNumber, String phoneCodeHash, String phoneCode, TLAbsEmailVerification emailVerification) throws RpcErrorException, IOException {
        return (TLAbsAuthorization) executeRpcQuery(new TLRequestAuthSignIn(phoneNumber, phoneCodeHash, phoneCode, emailVerification));
    }

    @Override
    public TLAbsAuthorization authSignUp(boolean noJoinedNotifications, String phoneNumber, String phoneCodeHash, String firstName, String lastName) throws RpcErrorException, IOException {
        return (TLAbsAuthorization) executeRpcQuery(new TLRequestAuthSignUp(noJoinedNotifications, phoneNumber, phoneCodeHash, firstName, lastName));
    }

    @Override
    public TLBotPreviewMedia botsAddPreviewMedia(TLAbsInputUser bot, String langCode, TLAbsInputMedia media) throws RpcErrorException, IOException {
        return (TLBotPreviewMedia) executeRpcQuery(new TLRequestBotsAddPreviewMedia(bot, langCode, media));
    }

    @Override
    public TLAbsUpdates botsAllowSendMessage(TLAbsInputUser bot) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestBotsAllowSendMessage(bot));
    }

    @Override
    public TLBool botsAnswerWebhookJSONQuery(long queryId, TLDataJSON data) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestBotsAnswerWebhookJSONQuery(queryId, data));
    }

    @Override
    public TLBool botsCanSendMessage(TLAbsInputUser bot) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestBotsCanSendMessage(bot));
    }

    @Override
    public TLBool botsCheckDownloadFileParams(TLAbsInputUser bot, String fileName, String url) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestBotsCheckDownloadFileParams(bot, fileName, url));
    }

    @Override
    public TLBool botsDeletePreviewMedia(TLAbsInputUser bot, String langCode, TLVector<TLAbsInputMedia> media) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestBotsDeletePreviewMedia(bot, langCode, media));
    }

    @Override
    public TLBotPreviewMedia botsEditPreviewMedia(TLAbsInputUser bot, String langCode, TLAbsInputMedia media, TLAbsInputMedia newMedia) throws RpcErrorException, IOException {
        return (TLBotPreviewMedia) executeRpcQuery(new TLRequestBotsEditPreviewMedia(bot, langCode, media, newMedia));
    }

    @Override
    public TLVector<TLAbsUser> botsGetAdminedBots() throws RpcErrorException, IOException {
        return (TLVector<TLAbsUser>) executeRpcQuery(new TLRequestBotsGetAdminedBots());
    }

    @Override
    public TLVector<TLBotCommand> botsGetBotCommands(TLAbsBotCommandScope scope, String langCode) throws RpcErrorException, IOException {
        return (TLVector<TLBotCommand>) executeRpcQuery(new TLRequestBotsGetBotCommands(scope, langCode));
    }

    @Override
    public TLBotInfo botsGetBotInfo(TLAbsInputUser bot, String langCode) throws RpcErrorException, IOException {
        return (TLBotInfo) executeRpcQuery(new TLRequestBotsGetBotInfo(bot, langCode));
    }

    @Override
    public TLAbsBotMenuButton botsGetBotMenuButton(TLAbsInputUser userId) throws RpcErrorException, IOException {
        return (TLAbsBotMenuButton) executeRpcQuery(new TLRequestBotsGetBotMenuButton(userId));
    }

    @Override
    public TLPopularAppBots botsGetPopularAppBots(String offset, int limit) throws RpcErrorException, IOException {
        return (TLPopularAppBots) executeRpcQuery(new TLRequestBotsGetPopularAppBots(offset, limit));
    }

    @Override
    public TLPreviewInfo botsGetPreviewInfo(TLAbsInputUser bot, String langCode) throws RpcErrorException, IOException {
        return (TLPreviewInfo) executeRpcQuery(new TLRequestBotsGetPreviewInfo(bot, langCode));
    }

    @Override
    public TLVector<TLBotPreviewMedia> botsGetPreviewMedias(TLAbsInputUser bot) throws RpcErrorException, IOException {
        return (TLVector<TLBotPreviewMedia>) executeRpcQuery(new TLRequestBotsGetPreviewMedias(bot));
    }

    @Override
    public TLDataJSON botsInvokeWebViewCustomMethod(TLAbsInputUser bot, String customMethod, TLDataJSON params) throws RpcErrorException, IOException {
        return (TLDataJSON) executeRpcQuery(new TLRequestBotsInvokeWebViewCustomMethod(bot, customMethod, params));
    }

    @Override
    public TLBool botsReorderPreviewMedias(TLAbsInputUser bot, String langCode, TLVector<TLAbsInputMedia> order) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestBotsReorderPreviewMedias(bot, langCode, order));
    }

    @Override
    public TLBool botsReorderUsernames(TLAbsInputUser bot, TLStringVector order) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestBotsReorderUsernames(bot, order));
    }

    @Override
    public TLBool botsResetBotCommands(TLAbsBotCommandScope scope, String langCode) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestBotsResetBotCommands(scope, langCode));
    }

    @Override
    public TLDataJSON botsSendCustomRequest(String customMethod, TLDataJSON params) throws RpcErrorException, IOException {
        return (TLDataJSON) executeRpcQuery(new TLRequestBotsSendCustomRequest(customMethod, params));
    }

    @Override
    public TLBool botsSetBotBroadcastDefaultAdminRights(TLChatAdminRights adminRights) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestBotsSetBotBroadcastDefaultAdminRights(adminRights));
    }

    @Override
    public TLBool botsSetBotCommands(TLAbsBotCommandScope scope, String langCode, TLVector<TLBotCommand> commands) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestBotsSetBotCommands(scope, langCode, commands));
    }

    @Override
    public TLBool botsSetBotGroupDefaultAdminRights(TLChatAdminRights adminRights) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestBotsSetBotGroupDefaultAdminRights(adminRights));
    }

    @Override
    public TLBool botsSetBotInfo(TLAbsInputUser bot, String langCode, String name, String about, String description) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestBotsSetBotInfo(bot, langCode, name, about, description));
    }

    @Override
    public TLBool botsSetBotMenuButton(TLAbsInputUser userId, TLAbsBotMenuButton button) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestBotsSetBotMenuButton(userId, button));
    }

    @Override
    public TLBool botsToggleUserEmojiStatusPermission(TLAbsInputUser bot, boolean enabled) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestBotsToggleUserEmojiStatusPermission(bot, enabled));
    }

    @Override
    public TLBool botsToggleUsername(TLAbsInputUser bot, String username, boolean active) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestBotsToggleUsername(bot, username, active));
    }

    @Override
    public TLStarRefProgram botsUpdateStarRefProgram(TLAbsInputUser bot, int commissionPermille, Integer durationMonths) throws RpcErrorException, IOException {
        return (TLStarRefProgram) executeRpcQuery(new TLRequestBotsUpdateStarRefProgram(bot, commissionPermille, durationMonths));
    }

    @Override
    public TLBool botsUpdateUserEmojiStatus(TLAbsInputUser userId, TLAbsEmojiStatus emojiStatus) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestBotsUpdateUserEmojiStatus(userId, emojiStatus));
    }

    @Override
    public TLBool channelsCheckUsername(TLAbsInputChannel channel, String username) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestChannelsCheckUsername(channel, username));
    }

    @Override
    public TLAbsUpdates channelsConvertToGigagroup(TLAbsInputChannel channel) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsConvertToGigagroup(channel));
    }

    @Override
    public TLAbsUpdates channelsCreateChannel(boolean broadcast, boolean megagroup, boolean forImport, boolean forum, String title, String about, TLAbsInputGeoPoint geoPoint, String address, Integer ttlPeriod) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsCreateChannel(broadcast, megagroup, forImport, forum, title, about, geoPoint, address, ttlPeriod));
    }

    @Override
    public TLAbsUpdates channelsCreateForumTopic(TLAbsInputChannel channel, String title, Integer iconColor, Long iconEmojiId, long randomId, TLAbsInputPeer sendAs) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsCreateForumTopic(channel, title, iconColor, iconEmojiId, randomId, sendAs));
    }

    @Override
    public TLBool channelsDeactivateAllUsernames(TLAbsInputChannel channel) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestChannelsDeactivateAllUsernames(channel));
    }

    @Override
    public TLAbsUpdates channelsDeleteChannel(TLAbsInputChannel channel) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsDeleteChannel(channel));
    }

    @Override
    public TLAbsUpdates channelsDeleteHistory(boolean forEveryone, TLAbsInputChannel channel, int maxId) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsDeleteHistory(forEveryone, channel, maxId));
    }

    @Override
    public TLAffectedMessages channelsDeleteMessages(TLAbsInputChannel channel, TLIntVector id) throws RpcErrorException, IOException {
        return (TLAffectedMessages) executeRpcQuery(new TLRequestChannelsDeleteMessages(channel, id));
    }

    @Override
    public TLAffectedHistory channelsDeleteParticipantHistory(TLAbsInputChannel channel, TLAbsInputPeer participant) throws RpcErrorException, IOException {
        return (TLAffectedHistory) executeRpcQuery(new TLRequestChannelsDeleteParticipantHistory(channel, participant));
    }

    @Override
    public TLAffectedHistory channelsDeleteTopicHistory(TLAbsInputChannel channel, int topMsgId) throws RpcErrorException, IOException {
        return (TLAffectedHistory) executeRpcQuery(new TLRequestChannelsDeleteTopicHistory(channel, topMsgId));
    }

    @Override
    public TLAbsUpdates channelsEditAdmin(TLAbsInputChannel channel, TLAbsInputUser userId, TLChatAdminRights adminRights, String rank) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsEditAdmin(channel, userId, adminRights, rank));
    }

    @Override
    public TLAbsUpdates channelsEditBanned(TLAbsInputChannel channel, TLAbsInputPeer participant, TLChatBannedRights bannedRights) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsEditBanned(channel, participant, bannedRights));
    }

    @Override
    public TLAbsUpdates channelsEditCreator(TLAbsInputChannel channel, TLAbsInputUser userId, TLAbsInputCheckPasswordSRP password) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsEditCreator(channel, userId, password));
    }

    @Override
    public TLAbsUpdates channelsEditForumTopic(TLAbsInputChannel channel, int topicId, String title, Long iconEmojiId, boolean closed, boolean hidden) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsEditForumTopic(channel, topicId, title, iconEmojiId, closed, hidden));
    }

    @Override
    public TLBool channelsEditLocation(TLAbsInputChannel channel, TLAbsInputGeoPoint geoPoint, String address) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestChannelsEditLocation(channel, geoPoint, address));
    }

    @Override
    public TLAbsUpdates channelsEditPhoto(TLAbsInputChannel channel, TLAbsInputChatPhoto photo) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsEditPhoto(channel, photo));
    }

    @Override
    public TLAbsUpdates channelsEditTitle(TLAbsInputChannel channel, String title) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsEditTitle(channel, title));
    }

    @Override
    public TLExportedMessageLink channelsExportMessageLink(boolean grouped, boolean thread, TLAbsInputChannel channel, int id) throws RpcErrorException, IOException {
        return (TLExportedMessageLink) executeRpcQuery(new TLRequestChannelsExportMessageLink(grouped, thread, channel, id));
    }

    @Override
    public TLAdminLogResults channelsGetAdminLog(TLAbsInputChannel channel, String q, TLChannelAdminLogEventsFilter eventsFilter, TLVector<TLAbsInputUser> admins, long maxId, long minId, int limit) throws RpcErrorException, IOException {
        return (TLAdminLogResults) executeRpcQuery(new TLRequestChannelsGetAdminLog(channel, q, eventsFilter, admins, maxId, minId, limit));
    }

    @Override
    public TLAbsChats channelsGetAdminedPublicChannels(boolean byLocation, boolean checkLimit, boolean forPersonal) throws RpcErrorException, IOException {
        return (TLAbsChats) executeRpcQuery(new TLRequestChannelsGetAdminedPublicChannels(byLocation, checkLimit, forPersonal));
    }

    @Override
    public TLAbsChats channelsGetChannelRecommendations(TLAbsInputChannel channel) throws RpcErrorException, IOException {
        return (TLAbsChats) executeRpcQuery(new TLRequestChannelsGetChannelRecommendations(channel));
    }

    @Override
    public TLAbsChats channelsGetChannels(TLVector<TLAbsInputChannel> id) throws RpcErrorException, IOException {
        return (TLAbsChats) executeRpcQuery(new TLRequestChannelsGetChannels(id));
    }

    @Override
    public TLForumTopics channelsGetForumTopics(TLAbsInputChannel channel, String q, int offsetDate, int offsetId, int offsetTopic, int limit) throws RpcErrorException, IOException {
        return (TLForumTopics) executeRpcQuery(new TLRequestChannelsGetForumTopics(channel, q, offsetDate, offsetId, offsetTopic, limit));
    }

    @Override
    public TLForumTopics channelsGetForumTopicsByID(TLAbsInputChannel channel, TLIntVector topics) throws RpcErrorException, IOException {
        return (TLForumTopics) executeRpcQuery(new TLRequestChannelsGetForumTopicsByID(channel, topics));
    }

    @Override
    public TLChatFull channelsGetFullChannel(TLAbsInputChannel channel) throws RpcErrorException, IOException {
        return (TLChatFull) executeRpcQuery(new TLRequestChannelsGetFullChannel(channel));
    }

    @Override
    public TLAbsChats channelsGetGroupsForDiscussion() throws RpcErrorException, IOException {
        return (TLAbsChats) executeRpcQuery(new TLRequestChannelsGetGroupsForDiscussion());
    }

    @Override
    public TLInactiveChats channelsGetInactiveChannels() throws RpcErrorException, IOException {
        return (TLInactiveChats) executeRpcQuery(new TLRequestChannelsGetInactiveChannels());
    }

    @Override
    public TLAbsChats channelsGetLeftChannels(int offset) throws RpcErrorException, IOException {
        return (TLAbsChats) executeRpcQuery(new TLRequestChannelsGetLeftChannels(offset));
    }

    @Override
    public TLAbsMessages channelsGetMessages(TLAbsInputChannel channel, TLVector<TLAbsInputMessage> id) throws RpcErrorException, IOException {
        return (TLAbsMessages) executeRpcQuery(new TLRequestChannelsGetMessages(channel, id));
    }

    @Override
    public TLChannelParticipant channelsGetParticipant(TLAbsInputChannel channel, TLAbsInputPeer participant) throws RpcErrorException, IOException {
        return (TLChannelParticipant) executeRpcQuery(new TLRequestChannelsGetParticipant(channel, participant));
    }

    @Override
    public TLAbsChannelParticipants channelsGetParticipants(TLAbsInputChannel channel, TLAbsChannelParticipantsFilter filter, int offset, int limit, long hash) throws RpcErrorException, IOException {
        return (TLAbsChannelParticipants) executeRpcQuery(new TLRequestChannelsGetParticipants(channel, filter, offset, limit, hash));
    }

    @Override
    public TLSendAsPeers channelsGetSendAs(TLAbsInputPeer peer) throws RpcErrorException, IOException {
        return (TLSendAsPeers) executeRpcQuery(new TLRequestChannelsGetSendAs(peer));
    }

    @Override
    public TLInvitedUsers channelsInviteToChannel(TLAbsInputChannel channel, TLVector<TLAbsInputUser> users) throws RpcErrorException, IOException {
        return (TLInvitedUsers) executeRpcQuery(new TLRequestChannelsInviteToChannel(channel, users));
    }

    @Override
    public TLAbsUpdates channelsJoinChannel(TLAbsInputChannel channel) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsJoinChannel(channel));
    }

    @Override
    public TLAbsUpdates channelsLeaveChannel(TLAbsInputChannel channel) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsLeaveChannel(channel));
    }

    @Override
    public TLBool channelsReadHistory(TLAbsInputChannel channel, int maxId) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestChannelsReadHistory(channel, maxId));
    }

    @Override
    public TLBool channelsReadMessageContents(TLAbsInputChannel channel, TLIntVector id) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestChannelsReadMessageContents(channel, id));
    }

    @Override
    public TLAbsUpdates channelsReorderPinnedForumTopics(boolean force, TLAbsInputChannel channel, TLIntVector order) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsReorderPinnedForumTopics(force, channel, order));
    }

    @Override
    public TLBool channelsReorderUsernames(TLAbsInputChannel channel, TLStringVector order) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestChannelsReorderUsernames(channel, order));
    }

    @Override
    public TLBool channelsReportAntiSpamFalsePositive(TLAbsInputChannel channel, int msgId) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestChannelsReportAntiSpamFalsePositive(channel, msgId));
    }

    @Override
    public TLBool channelsReportSpam(TLAbsInputChannel channel, TLAbsInputPeer participant, TLIntVector id) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestChannelsReportSpam(channel, participant, id));
    }

    @Override
    public TLAbsUpdates channelsRestrictSponsoredMessages(TLAbsInputChannel channel, boolean restricted) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsRestrictSponsoredMessages(channel, restricted));
    }

    @Override
    public TLAbsMessages channelsSearchPosts(String hashtag, int offsetRate, TLAbsInputPeer offsetPeer, int offsetId, int limit) throws RpcErrorException, IOException {
        return (TLAbsMessages) executeRpcQuery(new TLRequestChannelsSearchPosts(hashtag, offsetRate, offsetPeer, offsetId, limit));
    }

    @Override
    public TLAbsUpdates channelsSetBoostsToUnblockRestrictions(TLAbsInputChannel channel, int boosts) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsSetBoostsToUnblockRestrictions(channel, boosts));
    }

    @Override
    public TLBool channelsSetDiscussionGroup(TLAbsInputChannel broadcast, TLAbsInputChannel group) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestChannelsSetDiscussionGroup(broadcast, group));
    }

    @Override
    public TLBool channelsSetEmojiStickers(TLAbsInputChannel channel, TLAbsInputStickerSet stickerset) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestChannelsSetEmojiStickers(channel, stickerset));
    }

    @Override
    public TLBool channelsSetStickers(TLAbsInputChannel channel, TLAbsInputStickerSet stickerset) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestChannelsSetStickers(channel, stickerset));
    }

    @Override
    public TLAbsUpdates channelsToggleAntiSpam(TLAbsInputChannel channel, boolean enabled) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsToggleAntiSpam(channel, enabled));
    }

    @Override
    public TLAbsUpdates channelsToggleForum(TLAbsInputChannel channel, boolean enabled) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsToggleForum(channel, enabled));
    }

    @Override
    public TLAbsUpdates channelsToggleJoinRequest(TLAbsInputChannel channel, boolean enabled) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsToggleJoinRequest(channel, enabled));
    }

    @Override
    public TLAbsUpdates channelsToggleJoinToSend(TLAbsInputChannel channel, boolean enabled) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsToggleJoinToSend(channel, enabled));
    }

    @Override
    public TLAbsUpdates channelsToggleParticipantsHidden(TLAbsInputChannel channel, boolean enabled) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsToggleParticipantsHidden(channel, enabled));
    }

    @Override
    public TLAbsUpdates channelsTogglePreHistoryHidden(TLAbsInputChannel channel, boolean enabled) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsTogglePreHistoryHidden(channel, enabled));
    }

    @Override
    public TLAbsUpdates channelsToggleSignatures(boolean signaturesEnabled, boolean profilesEnabled, TLAbsInputChannel channel) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsToggleSignatures(signaturesEnabled, profilesEnabled, channel));
    }

    @Override
    public TLAbsUpdates channelsToggleSlowMode(TLAbsInputChannel channel, int seconds) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsToggleSlowMode(channel, seconds));
    }

    @Override
    public TLBool channelsToggleUsername(TLAbsInputChannel channel, String username, boolean active) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestChannelsToggleUsername(channel, username, active));
    }

    @Override
    public TLAbsUpdates channelsToggleViewForumAsMessages(TLAbsInputChannel channel, boolean enabled) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsToggleViewForumAsMessages(channel, enabled));
    }

    @Override
    public TLAbsUpdates channelsUpdateColor(boolean forProfile, TLAbsInputChannel channel, Integer color, Long backgroundEmojiId) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsUpdateColor(forProfile, channel, color, backgroundEmojiId));
    }

    @Override
    public TLAbsUpdates channelsUpdateEmojiStatus(TLAbsInputChannel channel, TLAbsEmojiStatus emojiStatus) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsUpdateEmojiStatus(channel, emojiStatus));
    }

    @Override
    public TLAbsUpdates channelsUpdatePinnedForumTopic(TLAbsInputChannel channel, int topicId, boolean pinned) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsUpdatePinnedForumTopic(channel, topicId, pinned));
    }

    @Override
    public TLBool channelsUpdateUsername(TLAbsInputChannel channel, String username) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestChannelsUpdateUsername(channel, username));
    }

    @Override
    public TLAbsChatlistInvite chatlistsCheckChatlistInvite(String slug) throws RpcErrorException, IOException {
        return (TLAbsChatlistInvite) executeRpcQuery(new TLRequestChatlistsCheckChatlistInvite(slug));
    }

    @Override
    public TLBool chatlistsDeleteExportedInvite(TLInputChatlistDialogFilter chatlist, String slug) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestChatlistsDeleteExportedInvite(chatlist, slug));
    }

    @Override
    public TLExportedChatlistInvite chatlistsEditExportedInvite(TLInputChatlistDialogFilter chatlist, String slug, String title, TLVector<TLAbsInputPeer> peers) throws RpcErrorException, IOException {
        return (TLExportedChatlistInvite) executeRpcQuery(new TLRequestChatlistsEditExportedInvite(chatlist, slug, title, peers));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.chatlists.TLExportedChatlistInvite chatlistsExportChatlistInvite(TLInputChatlistDialogFilter chatlist, String title, TLVector<TLAbsInputPeer> peers) throws RpcErrorException, IOException {
        return (com.github.badoualy.telegram.tl.api.chatlists.TLExportedChatlistInvite) executeRpcQuery(new TLRequestChatlistsExportChatlistInvite(chatlist, title, peers));
    }

    @Override
    public TLChatlistUpdates chatlistsGetChatlistUpdates(TLInputChatlistDialogFilter chatlist) throws RpcErrorException, IOException {
        return (TLChatlistUpdates) executeRpcQuery(new TLRequestChatlistsGetChatlistUpdates(chatlist));
    }

    @Override
    public TLExportedInvites chatlistsGetExportedInvites(TLInputChatlistDialogFilter chatlist) throws RpcErrorException, IOException {
        return (TLExportedInvites) executeRpcQuery(new TLRequestChatlistsGetExportedInvites(chatlist));
    }

    @Override
    public TLVector<TLAbsPeer> chatlistsGetLeaveChatlistSuggestions(TLInputChatlistDialogFilter chatlist) throws RpcErrorException, IOException {
        return (TLVector<TLAbsPeer>) executeRpcQuery(new TLRequestChatlistsGetLeaveChatlistSuggestions(chatlist));
    }

    @Override
    public TLBool chatlistsHideChatlistUpdates(TLInputChatlistDialogFilter chatlist) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestChatlistsHideChatlistUpdates(chatlist));
    }

    @Override
    public TLAbsUpdates chatlistsJoinChatlistInvite(String slug, TLVector<TLAbsInputPeer> peers) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChatlistsJoinChatlistInvite(slug, peers));
    }

    @Override
    public TLAbsUpdates chatlistsJoinChatlistUpdates(TLInputChatlistDialogFilter chatlist, TLVector<TLAbsInputPeer> peers) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChatlistsJoinChatlistUpdates(chatlist, peers));
    }

    @Override
    public TLAbsUpdates chatlistsLeaveChatlist(TLInputChatlistDialogFilter chatlist, TLVector<TLAbsInputPeer> peers) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChatlistsLeaveChatlist(chatlist, peers));
    }

    @Override
    public TLAbsUpdates contactsAcceptContact(TLAbsInputUser id) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestContactsAcceptContact(id));
    }

    @Override
    public TLAbsUpdates contactsAddContact(boolean addPhonePrivacyException, TLAbsInputUser id, String firstName, String lastName, String phone) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestContactsAddContact(addPhonePrivacyException, id, firstName, lastName, phone));
    }

    @Override
    public TLBool contactsBlock(boolean myStoriesFrom, TLAbsInputPeer id) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestContactsBlock(myStoriesFrom, id));
    }

    @Override
    public TLAbsUpdates contactsBlockFromReplies(boolean deleteMessage, boolean deleteHistory, boolean reportSpam, int msgId) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestContactsBlockFromReplies(deleteMessage, deleteHistory, reportSpam, msgId));
    }

    @Override
    public TLBool contactsDeleteByPhones(TLStringVector phones) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestContactsDeleteByPhones(phones));
    }

    @Override
    public TLAbsUpdates contactsDeleteContacts(TLVector<TLAbsInputUser> id) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestContactsDeleteContacts(id));
    }

    @Override
    public TLBool contactsEditCloseFriends(TLLongVector id) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestContactsEditCloseFriends(id));
    }

    @Override
    public TLExportedContactToken contactsExportContactToken() throws RpcErrorException, IOException {
        return (TLExportedContactToken) executeRpcQuery(new TLRequestContactsExportContactToken());
    }

    @Override
    public TLContactBirthdays contactsGetBirthdays() throws RpcErrorException, IOException {
        return (TLContactBirthdays) executeRpcQuery(new TLRequestContactsGetBirthdays());
    }

    @Override
    public TLAbsBlocked contactsGetBlocked(boolean myStoriesFrom, int offset, int limit) throws RpcErrorException, IOException {
        return (TLAbsBlocked) executeRpcQuery(new TLRequestContactsGetBlocked(myStoriesFrom, offset, limit));
    }

    @Override
    public TLIntVector contactsGetContactIDs(long hash) throws RpcErrorException, IOException {
        return (TLIntVector) executeRpcQuery(new TLRequestContactsGetContactIDs(hash));
    }

    @Override
    public TLAbsContacts contactsGetContacts(long hash) throws RpcErrorException, IOException {
        return (TLAbsContacts) executeRpcQuery(new TLRequestContactsGetContacts(hash));
    }

    @Override
    public TLAbsUpdates contactsGetLocated(boolean background, TLAbsInputGeoPoint geoPoint, Integer selfExpires) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestContactsGetLocated(background, geoPoint, selfExpires));
    }

    @Override
    public TLVector<TLSavedPhoneContact> contactsGetSaved() throws RpcErrorException, IOException {
        return (TLVector<TLSavedPhoneContact>) executeRpcQuery(new TLRequestContactsGetSaved());
    }

    @Override
    public TLVector<TLContactStatus> contactsGetStatuses() throws RpcErrorException, IOException {
        return (TLVector<TLContactStatus>) executeRpcQuery(new TLRequestContactsGetStatuses());
    }

    @Override
    public TLAbsTopPeers contactsGetTopPeers(boolean correspondents, boolean botsPm, boolean botsInline, boolean phoneCalls, boolean forwardUsers, boolean forwardChats, boolean groups, boolean channels, boolean botsApp, int offset, int limit, long hash) throws RpcErrorException, IOException {
        return (TLAbsTopPeers) executeRpcQuery(new TLRequestContactsGetTopPeers(correspondents, botsPm, botsInline, phoneCalls, forwardUsers, forwardChats, groups, channels, botsApp, offset, limit, hash));
    }

    @Override
    public TLAbsUser contactsImportContactToken(String token) throws RpcErrorException, IOException {
        return (TLAbsUser) executeRpcQuery(new TLRequestContactsImportContactToken(token));
    }

    @Override
    public TLImportedContacts contactsImportContacts(TLVector<TLInputPhoneContact> contacts) throws RpcErrorException, IOException {
        return (TLImportedContacts) executeRpcQuery(new TLRequestContactsImportContacts(contacts));
    }

    @Override
    public TLBool contactsResetSaved() throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestContactsResetSaved());
    }

    @Override
    public TLBool contactsResetTopPeerRating(TLAbsTopPeerCategory category, TLAbsInputPeer peer) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestContactsResetTopPeerRating(category, peer));
    }

    @Override
    public TLResolvedPeer contactsResolvePhone(String phone) throws RpcErrorException, IOException {
        return (TLResolvedPeer) executeRpcQuery(new TLRequestContactsResolvePhone(phone));
    }

    @Override
    public TLResolvedPeer contactsResolveUsername(String username, String referer) throws RpcErrorException, IOException {
        return (TLResolvedPeer) executeRpcQuery(new TLRequestContactsResolveUsername(username, referer));
    }

    @Override
    public TLFound contactsSearch(String q, int limit) throws RpcErrorException, IOException {
        return (TLFound) executeRpcQuery(new TLRequestContactsSearch(q, limit));
    }

    @Override
    public TLBool contactsSetBlocked(boolean myStoriesFrom, TLVector<TLAbsInputPeer> id, int limit) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestContactsSetBlocked(myStoriesFrom, id, limit));
    }

    @Override
    public TLBool contactsToggleTopPeers(boolean enabled) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestContactsToggleTopPeers(enabled));
    }

    @Override
    public TLBool contactsUnblock(boolean myStoriesFrom, TLAbsInputPeer id) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestContactsUnblock(myStoriesFrom, id));
    }

    @Override
    public TLAbsUpdates foldersEditPeerFolders(TLVector<TLInputFolderPeer> folderPeers) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestFoldersEditPeerFolders(folderPeers));
    }

    @Override
    public TLCollectibleInfo fragmentGetCollectibleInfo(TLAbsInputCollectible collectible) throws RpcErrorException, IOException {
        return (TLCollectibleInfo) executeRpcQuery(new TLRequestFragmentGetCollectibleInfo(collectible));
    }

    @Override
    public TLBool helpAcceptTermsOfService(TLDataJSON id) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestHelpAcceptTermsOfService(id));
    }

    @Override
    public TLBool helpDismissSuggestion(TLAbsInputPeer peer, String suggestion) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestHelpDismissSuggestion(peer, suggestion));
    }

    @Override
    public TLAbsUserInfo helpEditUserInfo(TLAbsInputUser userId, String message, TLVector<TLAbsMessageEntity> entities) throws RpcErrorException, IOException {
        return (TLAbsUserInfo) executeRpcQuery(new TLRequestHelpEditUserInfo(userId, message, entities));
    }

    @Override
    public TLAbsAppConfig helpGetAppConfig(int hash) throws RpcErrorException, IOException {
        return (TLAbsAppConfig) executeRpcQuery(new TLRequestHelpGetAppConfig(hash));
    }

    @Override
    public TLAbsAppUpdate helpGetAppUpdate(String source) throws RpcErrorException, IOException {
        return (TLAbsAppUpdate) executeRpcQuery(new TLRequestHelpGetAppUpdate(source));
    }

    @Override
    public TLCdnConfig helpGetCdnConfig() throws RpcErrorException, IOException {
        return (TLCdnConfig) executeRpcQuery(new TLRequestHelpGetCdnConfig());
    }

    @Override
    public TLConfig helpGetConfig() throws RpcErrorException, IOException {
        return (TLConfig) executeRpcQuery(new TLRequestHelpGetConfig());
    }

    @Override
    public TLAbsCountriesList helpGetCountriesList(String langCode, int hash) throws RpcErrorException, IOException {
        return (TLAbsCountriesList) executeRpcQuery(new TLRequestHelpGetCountriesList(langCode, hash));
    }

    @Override
    public TLAbsDeepLinkInfo helpGetDeepLinkInfo(String path) throws RpcErrorException, IOException {
        return (TLAbsDeepLinkInfo) executeRpcQuery(new TLRequestHelpGetDeepLinkInfo(path));
    }

    @Override
    public TLInviteText helpGetInviteText() throws RpcErrorException, IOException {
        return (TLInviteText) executeRpcQuery(new TLRequestHelpGetInviteText());
    }

    @Override
    public TLNearestDc helpGetNearestDc() throws RpcErrorException, IOException {
        return (TLNearestDc) executeRpcQuery(new TLRequestHelpGetNearestDc());
    }

    @Override
    public TLAbsPassportConfig helpGetPassportConfig(int hash) throws RpcErrorException, IOException {
        return (TLAbsPassportConfig) executeRpcQuery(new TLRequestHelpGetPassportConfig(hash));
    }

    @Override
    public TLAbsPeerColors helpGetPeerColors(int hash) throws RpcErrorException, IOException {
        return (TLAbsPeerColors) executeRpcQuery(new TLRequestHelpGetPeerColors(hash));
    }

    @Override
    public TLAbsPeerColors helpGetPeerProfileColors(int hash) throws RpcErrorException, IOException {
        return (TLAbsPeerColors) executeRpcQuery(new TLRequestHelpGetPeerProfileColors(hash));
    }

    @Override
    public TLPremiumPromo helpGetPremiumPromo() throws RpcErrorException, IOException {
        return (TLPremiumPromo) executeRpcQuery(new TLRequestHelpGetPremiumPromo());
    }

    @Override
    public TLAbsPromoData helpGetPromoData() throws RpcErrorException, IOException {
        return (TLAbsPromoData) executeRpcQuery(new TLRequestHelpGetPromoData());
    }

    @Override
    public TLRecentMeUrls helpGetRecentMeUrls(String referer) throws RpcErrorException, IOException {
        return (TLRecentMeUrls) executeRpcQuery(new TLRequestHelpGetRecentMeUrls(referer));
    }

    @Override
    public TLSupport helpGetSupport() throws RpcErrorException, IOException {
        return (TLSupport) executeRpcQuery(new TLRequestHelpGetSupport());
    }

    @Override
    public TLSupportName helpGetSupportName() throws RpcErrorException, IOException {
        return (TLSupportName) executeRpcQuery(new TLRequestHelpGetSupportName());
    }

    @Override
    public TLAbsTermsOfServiceUpdate helpGetTermsOfServiceUpdate() throws RpcErrorException, IOException {
        return (TLAbsTermsOfServiceUpdate) executeRpcQuery(new TLRequestHelpGetTermsOfServiceUpdate());
    }

    @Override
    public TLAbsTimezonesList helpGetTimezonesList(int hash) throws RpcErrorException, IOException {
        return (TLAbsTimezonesList) executeRpcQuery(new TLRequestHelpGetTimezonesList(hash));
    }

    @Override
    public TLAbsUserInfo helpGetUserInfo(TLAbsInputUser userId) throws RpcErrorException, IOException {
        return (TLAbsUserInfo) executeRpcQuery(new TLRequestHelpGetUserInfo(userId));
    }

    @Override
    public TLBool helpHidePromoData(TLAbsInputPeer peer) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestHelpHidePromoData(peer));
    }

    @Override
    public TLBool helpSaveAppLog(TLVector<TLInputAppEvent> events) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestHelpSaveAppLog(events));
    }

    @Override
    public TLBool helpSetBotUpdatesStatus(int pendingUpdatesCount, String message) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestHelpSetBotUpdatesStatus(pendingUpdatesCount, message));
    }

    @Override
    public <T extends TLObject> T initConnection(int apiId, String deviceModel, String systemVersion, String appVersion, String systemLangCode, String langPack, String langCode, TLInputClientProxy proxy, TLAbsJSONValue params, TLMethod<T> query) throws RpcErrorException, IOException {
        return (T) executeRpcQuery(new TLRequestInitConnection(apiId, deviceModel, systemVersion, appVersion, systemLangCode, langPack, langCode, proxy, params, query));
    }

    @Override
    public <T extends TLObject> T invokeAfterMsg(long msgId, TLMethod<T> query) throws RpcErrorException, IOException {
        return (T) executeRpcQuery(new TLRequestInvokeAfterMsg(msgId, query));
    }

    @Override
    public <T extends TLObject> T invokeAfterMsgs(TLLongVector msgIds, TLMethod<T> query) throws RpcErrorException, IOException {
        return (T) executeRpcQuery(new TLRequestInvokeAfterMsgs(msgIds, query));
    }

    @Override
    public <T extends TLObject> T invokeWithApnsSecret(String nonce, String secret, TLMethod<T> query) throws RpcErrorException, IOException {
        return (T) executeRpcQuery(new TLRequestInvokeWithApnsSecret(nonce, secret, query));
    }

    @Override
    public <T extends TLObject> T invokeWithBusinessConnection(String connectionId, TLMethod<T> query) throws RpcErrorException, IOException {
        return (T) executeRpcQuery(new TLRequestInvokeWithBusinessConnection(connectionId, query));
    }

    @Override
    public <T extends TLObject> T invokeWithGooglePlayIntegrity(String nonce, String token, TLMethod<T> query) throws RpcErrorException, IOException {
        return (T) executeRpcQuery(new TLRequestInvokeWithGooglePlayIntegrity(nonce, token, query));
    }

    @Override
    public <T extends TLObject> T invokeWithLayer(int layer, TLMethod<T> query) throws RpcErrorException, IOException {
        return (T) executeRpcQuery(new TLRequestInvokeWithLayer(layer, query));
    }

    @Override
    public <T extends TLObject> T invokeWithMessagesRange(TLMessageRange range, TLMethod<T> query) throws RpcErrorException, IOException {
        return (T) executeRpcQuery(new TLRequestInvokeWithMessagesRange(range, query));
    }

    @Override
    public <T extends TLObject> T invokeWithTakeout(long takeoutId, TLMethod<T> query) throws RpcErrorException, IOException {
        return (T) executeRpcQuery(new TLRequestInvokeWithTakeout(takeoutId, query));
    }

    @Override
    public <T extends TLObject> T invokeWithoutUpdates(TLMethod<T> query) throws RpcErrorException, IOException {
        return (T) executeRpcQuery(new TLRequestInvokeWithoutUpdates(query));
    }

    @Override
    public TLLangPackDifference langpackGetDifference(String langPack, String langCode, int fromVersion) throws RpcErrorException, IOException {
        return (TLLangPackDifference) executeRpcQuery(new TLRequestLangpackGetDifference(langPack, langCode, fromVersion));
    }

    @Override
    public TLLangPackDifference langpackGetLangPack(String langPack, String langCode) throws RpcErrorException, IOException {
        return (TLLangPackDifference) executeRpcQuery(new TLRequestLangpackGetLangPack(langPack, langCode));
    }

    @Override
    public TLLangPackLanguage langpackGetLanguage(String langPack, String langCode) throws RpcErrorException, IOException {
        return (TLLangPackLanguage) executeRpcQuery(new TLRequestLangpackGetLanguage(langPack, langCode));
    }

    @Override
    public TLVector<TLLangPackLanguage> langpackGetLanguages(String langPack) throws RpcErrorException, IOException {
        return (TLVector<TLLangPackLanguage>) executeRpcQuery(new TLRequestLangpackGetLanguages(langPack));
    }

    @Override
    public TLVector<TLAbsLangPackString> langpackGetStrings(String langPack, String langCode, TLStringVector keys) throws RpcErrorException, IOException {
        return (TLVector<TLAbsLangPackString>) executeRpcQuery(new TLRequestLangpackGetStrings(langPack, langCode, keys));
    }

    @Override
    public TLAbsEncryptedChat messagesAcceptEncryption(TLInputEncryptedChat peer, TLBytes gB, long keyFingerprint) throws RpcErrorException, IOException {
        return (TLAbsEncryptedChat) executeRpcQuery(new TLRequestMessagesAcceptEncryption(peer, gB, keyFingerprint));
    }

    @Override
    public TLAbsUrlAuthResult messagesAcceptUrlAuth(boolean writeAllowed, TLAbsInputPeer peer, Integer msgId, Integer buttonId, String url) throws RpcErrorException, IOException {
        return (TLAbsUrlAuthResult) executeRpcQuery(new TLRequestMessagesAcceptUrlAuth(writeAllowed, peer, msgId, buttonId, url));
    }

    @Override
    public TLInvitedUsers messagesAddChatUser(long chatId, TLAbsInputUser userId, int fwdLimit) throws RpcErrorException, IOException {
        return (TLInvitedUsers) executeRpcQuery(new TLRequestMessagesAddChatUser(chatId, userId, fwdLimit));
    }

    @Override
    public TLAbsChatInvite messagesCheckChatInvite(String hash) throws RpcErrorException, IOException {
        return (TLAbsChatInvite) executeRpcQuery(new TLRequestMessagesCheckChatInvite(hash));
    }

    @Override
    public TLHistoryImportParsed messagesCheckHistoryImport(String importHead) throws RpcErrorException, IOException {
        return (TLHistoryImportParsed) executeRpcQuery(new TLRequestMessagesCheckHistoryImport(importHead));
    }

    @Override
    public TLCheckedHistoryImportPeer messagesCheckHistoryImportPeer(TLAbsInputPeer peer) throws RpcErrorException, IOException {
        return (TLCheckedHistoryImportPeer) executeRpcQuery(new TLRequestMessagesCheckHistoryImportPeer(peer));
    }

    @Override
    public TLBool messagesCheckQuickReplyShortcut(String shortcut) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesCheckQuickReplyShortcut(shortcut));
    }

    @Override
    public TLBool messagesClearAllDrafts() throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesClearAllDrafts());
    }

    @Override
    public TLBool messagesClearRecentReactions() throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesClearRecentReactions());
    }

    @Override
    public TLBool messagesClearRecentStickers(boolean attached) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesClearRecentStickers(attached));
    }

    @Override
    public TLBool messagesClickSponsoredMessage(boolean media, boolean fullscreen, TLAbsInputPeer peer, TLBytes randomId) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesClickSponsoredMessage(media, fullscreen, peer, randomId));
    }

    @Override
    public TLInvitedUsers messagesCreateChat(TLVector<TLAbsInputUser> users, String title, Integer ttlPeriod) throws RpcErrorException, IOException {
        return (TLInvitedUsers) executeRpcQuery(new TLRequestMessagesCreateChat(users, title, ttlPeriod));
    }

    @Override
    public TLBool messagesDeleteChat(long chatId) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesDeleteChat(chatId));
    }

    @Override
    public TLAbsUpdates messagesDeleteChatUser(boolean revokeHistory, long chatId, TLAbsInputUser userId) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesDeleteChatUser(revokeHistory, chatId, userId));
    }

    @Override
    public TLBool messagesDeleteExportedChatInvite(TLAbsInputPeer peer, String link) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesDeleteExportedChatInvite(peer, link));
    }

    @Override
    public TLAbsUpdates messagesDeleteFactCheck(TLAbsInputPeer peer, int msgId) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesDeleteFactCheck(peer, msgId));
    }

    @Override
    public TLAffectedHistory messagesDeleteHistory(boolean justClear, boolean revoke, TLAbsInputPeer peer, int maxId, Integer minDate, Integer maxDate) throws RpcErrorException, IOException {
        return (TLAffectedHistory) executeRpcQuery(new TLRequestMessagesDeleteHistory(justClear, revoke, peer, maxId, minDate, maxDate));
    }

    @Override
    public TLAffectedMessages messagesDeleteMessages(boolean revoke, TLIntVector id) throws RpcErrorException, IOException {
        return (TLAffectedMessages) executeRpcQuery(new TLRequestMessagesDeleteMessages(revoke, id));
    }

    @Override
    public TLAffectedFoundMessages messagesDeletePhoneCallHistory(boolean revoke) throws RpcErrorException, IOException {
        return (TLAffectedFoundMessages) executeRpcQuery(new TLRequestMessagesDeletePhoneCallHistory(revoke));
    }

    @Override
    public TLAbsUpdates messagesDeleteQuickReplyMessages(int shortcutId, TLIntVector id) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesDeleteQuickReplyMessages(shortcutId, id));
    }

    @Override
    public TLBool messagesDeleteQuickReplyShortcut(int shortcutId) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesDeleteQuickReplyShortcut(shortcutId));
    }

    @Override
    public TLBool messagesDeleteRevokedExportedChatInvites(TLAbsInputPeer peer, TLAbsInputUser adminId) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesDeleteRevokedExportedChatInvites(peer, adminId));
    }

    @Override
    public TLAffectedHistory messagesDeleteSavedHistory(TLAbsInputPeer peer, int maxId, Integer minDate, Integer maxDate) throws RpcErrorException, IOException {
        return (TLAffectedHistory) executeRpcQuery(new TLRequestMessagesDeleteSavedHistory(peer, maxId, minDate, maxDate));
    }

    @Override
    public TLAbsUpdates messagesDeleteScheduledMessages(TLAbsInputPeer peer, TLIntVector id) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesDeleteScheduledMessages(peer, id));
    }

    @Override
    public TLBool messagesDiscardEncryption(boolean deleteHistory, int chatId) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesDiscardEncryption(deleteHistory, chatId));
    }

    @Override
    public TLBool messagesEditChatAbout(TLAbsInputPeer peer, String about) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesEditChatAbout(peer, about));
    }

    @Override
    public TLBool messagesEditChatAdmin(long chatId, TLAbsInputUser userId, boolean isAdmin) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesEditChatAdmin(chatId, userId, isAdmin));
    }

    @Override
    public TLAbsUpdates messagesEditChatDefaultBannedRights(TLAbsInputPeer peer, TLChatBannedRights bannedRights) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesEditChatDefaultBannedRights(peer, bannedRights));
    }

    @Override
    public TLAbsUpdates messagesEditChatPhoto(long chatId, TLAbsInputChatPhoto photo) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesEditChatPhoto(chatId, photo));
    }

    @Override
    public TLAbsUpdates messagesEditChatTitle(long chatId, String title) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesEditChatTitle(chatId, title));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAbsExportedChatInvite messagesEditExportedChatInvite(boolean revoked, TLAbsInputPeer peer, String link, Integer expireDate, Integer usageLimit, boolean requestNeeded, String title) throws RpcErrorException, IOException {
        return (com.github.badoualy.telegram.tl.api.messages.TLAbsExportedChatInvite) executeRpcQuery(new TLRequestMessagesEditExportedChatInvite(revoked, peer, link, expireDate, usageLimit, requestNeeded, title));
    }

    @Override
    public TLAbsUpdates messagesEditFactCheck(TLAbsInputPeer peer, int msgId, TLTextWithEntities text) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesEditFactCheck(peer, msgId, text));
    }

    @Override
    public TLBool messagesEditInlineBotMessage(boolean noWebpage, boolean invertMedia, TLAbsInputBotInlineMessageID id, String message, TLAbsInputMedia media, TLAbsReplyMarkup replyMarkup, TLVector<TLAbsMessageEntity> entities) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesEditInlineBotMessage(noWebpage, invertMedia, id, message, media, replyMarkup, entities));
    }

    @Override
    public TLAbsUpdates messagesEditMessage(boolean noWebpage, boolean invertMedia, TLAbsInputPeer peer, int id, String message, TLAbsInputMedia media, TLAbsReplyMarkup replyMarkup, TLVector<TLAbsMessageEntity> entities, Integer scheduleDate, Integer quickReplyShortcutId) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesEditMessage(noWebpage, invertMedia, peer, id, message, media, replyMarkup, entities, scheduleDate, quickReplyShortcutId));
    }

    @Override
    public TLBool messagesEditQuickReplyShortcut(int shortcutId, String shortcut) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesEditQuickReplyShortcut(shortcutId, shortcut));
    }

    @Override
    public TLAbsExportedChatInvite messagesExportChatInvite(boolean legacyRevokePermanent, boolean requestNeeded, TLAbsInputPeer peer, Integer expireDate, Integer usageLimit, String title, TLStarsSubscriptionPricing subscriptionPricing) throws RpcErrorException, IOException {
        return (TLAbsExportedChatInvite) executeRpcQuery(new TLRequestMessagesExportChatInvite(legacyRevokePermanent, requestNeeded, peer, expireDate, usageLimit, title, subscriptionPricing));
    }

    @Override
    public TLBool messagesFaveSticker(TLAbsInputDocument id, boolean unfave) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesFaveSticker(id, unfave));
    }

    @Override
    public TLAbsUpdates messagesForwardMessages(boolean silent, boolean background, boolean withMyScore, boolean dropAuthor, boolean dropMediaCaptions, boolean noforwards, boolean allowPaidFloodskip, TLAbsInputPeer fromPeer, TLIntVector id, TLLongVector randomId, TLAbsInputPeer toPeer, Integer topMsgId, Integer scheduleDate, TLAbsInputPeer sendAs, TLAbsInputQuickReplyShortcut quickReplyShortcut) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesForwardMessages(silent, background, withMyScore, dropAuthor, dropMediaCaptions, noforwards, allowPaidFloodskip, fromPeer, id, randomId, toPeer, topMsgId, scheduleDate, sendAs, quickReplyShortcut));
    }

    @Override
    public TLChatAdminsWithInvites messagesGetAdminsWithInvites(TLAbsInputPeer peer) throws RpcErrorException, IOException {
        return (TLChatAdminsWithInvites) executeRpcQuery(new TLRequestMessagesGetAdminsWithInvites(peer));
    }

    @Override
    public TLAbsUpdates messagesGetAllDrafts() throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesGetAllDrafts());
    }

    @Override
    public TLAbsAllStickers messagesGetAllStickers(long hash) throws RpcErrorException, IOException {
        return (TLAbsAllStickers) executeRpcQuery(new TLRequestMessagesGetAllStickers(hash));
    }

    @Override
    public TLArchivedStickers messagesGetArchivedStickers(boolean masks, boolean emojis, long offsetId, int limit) throws RpcErrorException, IOException {
        return (TLArchivedStickers) executeRpcQuery(new TLRequestMessagesGetArchivedStickers(masks, emojis, offsetId, limit));
    }

    @Override
    public TLAttachMenuBotsBot messagesGetAttachMenuBot(TLAbsInputUser bot) throws RpcErrorException, IOException {
        return (TLAttachMenuBotsBot) executeRpcQuery(new TLRequestMessagesGetAttachMenuBot(bot));
    }

    @Override
    public TLAbsAttachMenuBots messagesGetAttachMenuBots(long hash) throws RpcErrorException, IOException {
        return (TLAbsAttachMenuBots) executeRpcQuery(new TLRequestMessagesGetAttachMenuBots(hash));
    }

    @Override
    public TLVector<TLAbsStickerSetCovered> messagesGetAttachedStickers(TLAbsInputStickeredMedia media) throws RpcErrorException, IOException {
        return (TLVector<TLAbsStickerSetCovered>) executeRpcQuery(new TLRequestMessagesGetAttachedStickers(media));
    }

    @Override
    public TLAbsAvailableEffects messagesGetAvailableEffects(int hash) throws RpcErrorException, IOException {
        return (TLAbsAvailableEffects) executeRpcQuery(new TLRequestMessagesGetAvailableEffects(hash));
    }

    @Override
    public TLAbsAvailableReactions messagesGetAvailableReactions(int hash) throws RpcErrorException, IOException {
        return (TLAbsAvailableReactions) executeRpcQuery(new TLRequestMessagesGetAvailableReactions(hash));
    }

    @Override
    public TLBotApp messagesGetBotApp(TLAbsInputBotApp app, long hash) throws RpcErrorException, IOException {
        return (TLBotApp) executeRpcQuery(new TLRequestMessagesGetBotApp(app, hash));
    }

    @Override
    public TLBotCallbackAnswer messagesGetBotCallbackAnswer(boolean game, TLAbsInputPeer peer, int msgId, TLBytes data, TLAbsInputCheckPasswordSRP password) throws RpcErrorException, IOException {
        return (TLBotCallbackAnswer) executeRpcQuery(new TLRequestMessagesGetBotCallbackAnswer(game, peer, msgId, data, password));
    }

    @Override
    public TLChatInviteImporters messagesGetChatInviteImporters(boolean requested, boolean subscriptionExpired, TLAbsInputPeer peer, String link, String q, int offsetDate, TLAbsInputUser offsetUser, int limit) throws RpcErrorException, IOException {
        return (TLChatInviteImporters) executeRpcQuery(new TLRequestMessagesGetChatInviteImporters(requested, subscriptionExpired, peer, link, q, offsetDate, offsetUser, limit));
    }

    @Override
    public TLAbsChats messagesGetChats(TLLongVector id) throws RpcErrorException, IOException {
        return (TLAbsChats) executeRpcQuery(new TLRequestMessagesGetChats(id));
    }

    @Override
    public TLAbsChats messagesGetCommonChats(TLAbsInputUser userId, long maxId, int limit) throws RpcErrorException, IOException {
        return (TLAbsChats) executeRpcQuery(new TLRequestMessagesGetCommonChats(userId, maxId, limit));
    }

    @Override
    public TLVector<TLAbsDocument> messagesGetCustomEmojiDocuments(TLLongVector documentId) throws RpcErrorException, IOException {
        return (TLVector<TLAbsDocument>) executeRpcQuery(new TLRequestMessagesGetCustomEmojiDocuments(documentId));
    }

    @Override
    public TLDefaultHistoryTTL messagesGetDefaultHistoryTTL() throws RpcErrorException, IOException {
        return (TLDefaultHistoryTTL) executeRpcQuery(new TLRequestMessagesGetDefaultHistoryTTL());
    }

    @Override
    public TLAbsReactions messagesGetDefaultTagReactions(long hash) throws RpcErrorException, IOException {
        return (TLAbsReactions) executeRpcQuery(new TLRequestMessagesGetDefaultTagReactions(hash));
    }

    @Override
    public TLAbsDhConfig messagesGetDhConfig(int version, int randomLength) throws RpcErrorException, IOException {
        return (TLAbsDhConfig) executeRpcQuery(new TLRequestMessagesGetDhConfig(version, randomLength));
    }

    @Override
    public TLDialogFilters messagesGetDialogFilters() throws RpcErrorException, IOException {
        return (TLDialogFilters) executeRpcQuery(new TLRequestMessagesGetDialogFilters());
    }

    @Override
    public TLVector<TLAbsDialogPeer> messagesGetDialogUnreadMarks() throws RpcErrorException, IOException {
        return (TLVector<TLAbsDialogPeer>) executeRpcQuery(new TLRequestMessagesGetDialogUnreadMarks());
    }

    @Override
    public TLAbsDialogs messagesGetDialogs(boolean excludePinned, Integer folderId, int offsetDate, int offsetId, TLAbsInputPeer offsetPeer, int limit, long hash) throws RpcErrorException, IOException {
        return (TLAbsDialogs) executeRpcQuery(new TLRequestMessagesGetDialogs(excludePinned, folderId, offsetDate, offsetId, offsetPeer, limit, hash));
    }

    @Override
    public TLDiscussionMessage messagesGetDiscussionMessage(TLAbsInputPeer peer, int msgId) throws RpcErrorException, IOException {
        return (TLDiscussionMessage) executeRpcQuery(new TLRequestMessagesGetDiscussionMessage(peer, msgId));
    }

    @Override
    public TLAbsDocument messagesGetDocumentByHash(TLBytes sha256, long size, String mimeType) throws RpcErrorException, IOException {
        return (TLAbsDocument) executeRpcQuery(new TLRequestMessagesGetDocumentByHash(sha256, size, mimeType));
    }

    @Override
    public TLAbsEmojiGroups messagesGetEmojiGroups(int hash) throws RpcErrorException, IOException {
        return (TLAbsEmojiGroups) executeRpcQuery(new TLRequestMessagesGetEmojiGroups(hash));
    }

    @Override
    public TLEmojiKeywordsDifference messagesGetEmojiKeywords(String langCode) throws RpcErrorException, IOException {
        return (TLEmojiKeywordsDifference) executeRpcQuery(new TLRequestMessagesGetEmojiKeywords(langCode));
    }

    @Override
    public TLEmojiKeywordsDifference messagesGetEmojiKeywordsDifference(String langCode, int fromVersion) throws RpcErrorException, IOException {
        return (TLEmojiKeywordsDifference) executeRpcQuery(new TLRequestMessagesGetEmojiKeywordsDifference(langCode, fromVersion));
    }

    @Override
    public TLVector<TLEmojiLanguage> messagesGetEmojiKeywordsLanguages(TLStringVector langCodes) throws RpcErrorException, IOException {
        return (TLVector<TLEmojiLanguage>) executeRpcQuery(new TLRequestMessagesGetEmojiKeywordsLanguages(langCodes));
    }

    @Override
    public TLAbsEmojiGroups messagesGetEmojiProfilePhotoGroups(int hash) throws RpcErrorException, IOException {
        return (TLAbsEmojiGroups) executeRpcQuery(new TLRequestMessagesGetEmojiProfilePhotoGroups(hash));
    }

    @Override
    public TLAbsEmojiGroups messagesGetEmojiStatusGroups(int hash) throws RpcErrorException, IOException {
        return (TLAbsEmojiGroups) executeRpcQuery(new TLRequestMessagesGetEmojiStatusGroups(hash));
    }

    @Override
    public TLAbsEmojiGroups messagesGetEmojiStickerGroups(int hash) throws RpcErrorException, IOException {
        return (TLAbsEmojiGroups) executeRpcQuery(new TLRequestMessagesGetEmojiStickerGroups(hash));
    }

    @Override
    public TLAbsAllStickers messagesGetEmojiStickers(long hash) throws RpcErrorException, IOException {
        return (TLAbsAllStickers) executeRpcQuery(new TLRequestMessagesGetEmojiStickers(hash));
    }

    @Override
    public TLEmojiURL messagesGetEmojiURL(String langCode) throws RpcErrorException, IOException {
        return (TLEmojiURL) executeRpcQuery(new TLRequestMessagesGetEmojiURL(langCode));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAbsExportedChatInvite messagesGetExportedChatInvite(TLAbsInputPeer peer, String link) throws RpcErrorException, IOException {
        return (com.github.badoualy.telegram.tl.api.messages.TLAbsExportedChatInvite) executeRpcQuery(new TLRequestMessagesGetExportedChatInvite(peer, link));
    }

    @Override
    public TLExportedChatInvites messagesGetExportedChatInvites(boolean revoked, TLAbsInputPeer peer, TLAbsInputUser adminId, Integer offsetDate, String offsetLink, int limit) throws RpcErrorException, IOException {
        return (TLExportedChatInvites) executeRpcQuery(new TLRequestMessagesGetExportedChatInvites(revoked, peer, adminId, offsetDate, offsetLink, limit));
    }

    @Override
    public TLAbsUpdates messagesGetExtendedMedia(TLAbsInputPeer peer, TLIntVector id) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesGetExtendedMedia(peer, id));
    }

    @Override
    public TLVector<TLFactCheck> messagesGetFactCheck(TLAbsInputPeer peer, TLIntVector msgId) throws RpcErrorException, IOException {
        return (TLVector<TLFactCheck>) executeRpcQuery(new TLRequestMessagesGetFactCheck(peer, msgId));
    }

    @Override
    public TLAbsFavedStickers messagesGetFavedStickers(long hash) throws RpcErrorException, IOException {
        return (TLAbsFavedStickers) executeRpcQuery(new TLRequestMessagesGetFavedStickers(hash));
    }

    @Override
    public TLAbsFeaturedStickers messagesGetFeaturedEmojiStickers(long hash) throws RpcErrorException, IOException {
        return (TLAbsFeaturedStickers) executeRpcQuery(new TLRequestMessagesGetFeaturedEmojiStickers(hash));
    }

    @Override
    public TLAbsFeaturedStickers messagesGetFeaturedStickers(long hash) throws RpcErrorException, IOException {
        return (TLAbsFeaturedStickers) executeRpcQuery(new TLRequestMessagesGetFeaturedStickers(hash));
    }

    @Override
    public TLChatFull messagesGetFullChat(long chatId) throws RpcErrorException, IOException {
        return (TLChatFull) executeRpcQuery(new TLRequestMessagesGetFullChat(chatId));
    }

    @Override
    public TLHighScores messagesGetGameHighScores(TLAbsInputPeer peer, int id, TLAbsInputUser userId) throws RpcErrorException, IOException {
        return (TLHighScores) executeRpcQuery(new TLRequestMessagesGetGameHighScores(peer, id, userId));
    }

    @Override
    public TLAbsMessages messagesGetHistory(TLAbsInputPeer peer, int offsetId, int offsetDate, int addOffset, int limit, int maxId, int minId, long hash) throws RpcErrorException, IOException {
        return (TLAbsMessages) executeRpcQuery(new TLRequestMessagesGetHistory(peer, offsetId, offsetDate, addOffset, limit, maxId, minId, hash));
    }

    @Override
    public TLBotResults messagesGetInlineBotResults(TLAbsInputUser bot, TLAbsInputPeer peer, TLAbsInputGeoPoint geoPoint, String query, String offset) throws RpcErrorException, IOException {
        return (TLBotResults) executeRpcQuery(new TLRequestMessagesGetInlineBotResults(bot, peer, geoPoint, query, offset));
    }

    @Override
    public TLHighScores messagesGetInlineGameHighScores(TLAbsInputBotInlineMessageID id, TLAbsInputUser userId) throws RpcErrorException, IOException {
        return (TLHighScores) executeRpcQuery(new TLRequestMessagesGetInlineGameHighScores(id, userId));
    }

    @Override
    public TLAbsAllStickers messagesGetMaskStickers(long hash) throws RpcErrorException, IOException {
        return (TLAbsAllStickers) executeRpcQuery(new TLRequestMessagesGetMaskStickers(hash));
    }

    @Override
    public TLMessageEditData messagesGetMessageEditData(TLAbsInputPeer peer, int id) throws RpcErrorException, IOException {
        return (TLMessageEditData) executeRpcQuery(new TLRequestMessagesGetMessageEditData(peer, id));
    }

    @Override
    public TLMessageReactionsList messagesGetMessageReactionsList(TLAbsInputPeer peer, int id, TLAbsReaction reaction, String offset, int limit) throws RpcErrorException, IOException {
        return (TLMessageReactionsList) executeRpcQuery(new TLRequestMessagesGetMessageReactionsList(peer, id, reaction, offset, limit));
    }

    @Override
    public TLVector<TLReadParticipantDate> messagesGetMessageReadParticipants(TLAbsInputPeer peer, int msgId) throws RpcErrorException, IOException {
        return (TLVector<TLReadParticipantDate>) executeRpcQuery(new TLRequestMessagesGetMessageReadParticipants(peer, msgId));
    }

    @Override
    public TLAbsMessages messagesGetMessages(TLVector<TLAbsInputMessage> id) throws RpcErrorException, IOException {
        return (TLAbsMessages) executeRpcQuery(new TLRequestMessagesGetMessages(id));
    }

    @Override
    public TLAbsUpdates messagesGetMessagesReactions(TLAbsInputPeer peer, TLIntVector id) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesGetMessagesReactions(peer, id));
    }

    @Override
    public TLMessageViews messagesGetMessagesViews(TLAbsInputPeer peer, TLIntVector id, boolean increment) throws RpcErrorException, IOException {
        return (TLMessageViews) executeRpcQuery(new TLRequestMessagesGetMessagesViews(peer, id, increment));
    }

    @Override
    public TLMyStickers messagesGetMyStickers(long offsetId, int limit) throws RpcErrorException, IOException {
        return (TLMyStickers) executeRpcQuery(new TLRequestMessagesGetMyStickers(offsetId, limit));
    }

    @Override
    public TLAbsFeaturedStickers messagesGetOldFeaturedStickers(int offset, int limit, long hash) throws RpcErrorException, IOException {
        return (TLAbsFeaturedStickers) executeRpcQuery(new TLRequestMessagesGetOldFeaturedStickers(offset, limit, hash));
    }

    @Override
    public TLChatOnlines messagesGetOnlines(TLAbsInputPeer peer) throws RpcErrorException, IOException {
        return (TLChatOnlines) executeRpcQuery(new TLRequestMessagesGetOnlines(peer));
    }

    @Override
    public TLOutboxReadDate messagesGetOutboxReadDate(TLAbsInputPeer peer, int msgId) throws RpcErrorException, IOException {
        return (TLOutboxReadDate) executeRpcQuery(new TLRequestMessagesGetOutboxReadDate(peer, msgId));
    }

    @Override
    public TLAbsUpdates messagesGetPaidReactionPrivacy() throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesGetPaidReactionPrivacy());
    }

    @Override
    public TLPeerDialogs messagesGetPeerDialogs(TLVector<TLAbsInputDialogPeer> peers) throws RpcErrorException, IOException {
        return (TLPeerDialogs) executeRpcQuery(new TLRequestMessagesGetPeerDialogs(peers));
    }

    @Override
    public TLPeerSettings messagesGetPeerSettings(TLAbsInputPeer peer) throws RpcErrorException, IOException {
        return (TLPeerSettings) executeRpcQuery(new TLRequestMessagesGetPeerSettings(peer));
    }

    @Override
    public TLPeerDialogs messagesGetPinnedDialogs(int folderId) throws RpcErrorException, IOException {
        return (TLPeerDialogs) executeRpcQuery(new TLRequestMessagesGetPinnedDialogs(folderId));
    }

    @Override
    public TLAbsSavedDialogs messagesGetPinnedSavedDialogs() throws RpcErrorException, IOException {
        return (TLAbsSavedDialogs) executeRpcQuery(new TLRequestMessagesGetPinnedSavedDialogs());
    }

    @Override
    public TLAbsUpdates messagesGetPollResults(TLAbsInputPeer peer, int msgId) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesGetPollResults(peer, msgId));
    }

    @Override
    public TLVotesList messagesGetPollVotes(TLAbsInputPeer peer, int id, TLBytes option, String offset, int limit) throws RpcErrorException, IOException {
        return (TLVotesList) executeRpcQuery(new TLRequestMessagesGetPollVotes(peer, id, option, offset, limit));
    }

    @Override
    public TLPreparedInlineMessage messagesGetPreparedInlineMessage(TLAbsInputUser bot, String id) throws RpcErrorException, IOException {
        return (TLPreparedInlineMessage) executeRpcQuery(new TLRequestMessagesGetPreparedInlineMessage(bot, id));
    }

    @Override
    public TLAbsQuickReplies messagesGetQuickReplies(long hash) throws RpcErrorException, IOException {
        return (TLAbsQuickReplies) executeRpcQuery(new TLRequestMessagesGetQuickReplies(hash));
    }

    @Override
    public TLAbsMessages messagesGetQuickReplyMessages(int shortcutId, TLIntVector id, long hash) throws RpcErrorException, IOException {
        return (TLAbsMessages) executeRpcQuery(new TLRequestMessagesGetQuickReplyMessages(shortcutId, id, hash));
    }

    @Override
    public TLAbsMessages messagesGetRecentLocations(TLAbsInputPeer peer, int limit, long hash) throws RpcErrorException, IOException {
        return (TLAbsMessages) executeRpcQuery(new TLRequestMessagesGetRecentLocations(peer, limit, hash));
    }

    @Override
    public TLAbsReactions messagesGetRecentReactions(int limit, long hash) throws RpcErrorException, IOException {
        return (TLAbsReactions) executeRpcQuery(new TLRequestMessagesGetRecentReactions(limit, hash));
    }

    @Override
    public TLAbsRecentStickers messagesGetRecentStickers(boolean attached, long hash) throws RpcErrorException, IOException {
        return (TLAbsRecentStickers) executeRpcQuery(new TLRequestMessagesGetRecentStickers(attached, hash));
    }

    @Override
    public TLAbsMessages messagesGetReplies(TLAbsInputPeer peer, int msgId, int offsetId, int offsetDate, int addOffset, int limit, int maxId, int minId, long hash) throws RpcErrorException, IOException {
        return (TLAbsMessages) executeRpcQuery(new TLRequestMessagesGetReplies(peer, msgId, offsetId, offsetDate, addOffset, limit, maxId, minId, hash));
    }

    @Override
    public TLAbsSavedDialogs messagesGetSavedDialogs(boolean excludePinned, int offsetDate, int offsetId, TLAbsInputPeer offsetPeer, int limit, long hash) throws RpcErrorException, IOException {
        return (TLAbsSavedDialogs) executeRpcQuery(new TLRequestMessagesGetSavedDialogs(excludePinned, offsetDate, offsetId, offsetPeer, limit, hash));
    }

    @Override
    public TLAbsSavedGifs messagesGetSavedGifs(long hash) throws RpcErrorException, IOException {
        return (TLAbsSavedGifs) executeRpcQuery(new TLRequestMessagesGetSavedGifs(hash));
    }

    @Override
    public TLAbsMessages messagesGetSavedHistory(TLAbsInputPeer peer, int offsetId, int offsetDate, int addOffset, int limit, int maxId, int minId, long hash) throws RpcErrorException, IOException {
        return (TLAbsMessages) executeRpcQuery(new TLRequestMessagesGetSavedHistory(peer, offsetId, offsetDate, addOffset, limit, maxId, minId, hash));
    }

    @Override
    public TLAbsSavedReactionTags messagesGetSavedReactionTags(TLAbsInputPeer peer, long hash) throws RpcErrorException, IOException {
        return (TLAbsSavedReactionTags) executeRpcQuery(new TLRequestMessagesGetSavedReactionTags(peer, hash));
    }

    @Override
    public TLAbsMessages messagesGetScheduledHistory(TLAbsInputPeer peer, long hash) throws RpcErrorException, IOException {
        return (TLAbsMessages) executeRpcQuery(new TLRequestMessagesGetScheduledHistory(peer, hash));
    }

    @Override
    public TLAbsMessages messagesGetScheduledMessages(TLAbsInputPeer peer, TLIntVector id) throws RpcErrorException, IOException {
        return (TLAbsMessages) executeRpcQuery(new TLRequestMessagesGetScheduledMessages(peer, id));
    }

    @Override
    public TLVector<TLSearchCounter> messagesGetSearchCounters(TLAbsInputPeer peer, TLAbsInputPeer savedPeerId, Integer topMsgId, TLVector<TLAbsMessagesFilter> filters) throws RpcErrorException, IOException {
        return (TLVector<TLSearchCounter>) executeRpcQuery(new TLRequestMessagesGetSearchCounters(peer, savedPeerId, topMsgId, filters));
    }

    @Override
    public TLSearchResultsCalendar messagesGetSearchResultsCalendar(TLAbsInputPeer peer, TLAbsInputPeer savedPeerId, TLAbsMessagesFilter filter, int offsetId, int offsetDate) throws RpcErrorException, IOException {
        return (TLSearchResultsCalendar) executeRpcQuery(new TLRequestMessagesGetSearchResultsCalendar(peer, savedPeerId, filter, offsetId, offsetDate));
    }

    @Override
    public TLSearchResultsPositions messagesGetSearchResultsPositions(TLAbsInputPeer peer, TLAbsInputPeer savedPeerId, TLAbsMessagesFilter filter, int offsetId, int limit) throws RpcErrorException, IOException {
        return (TLSearchResultsPositions) executeRpcQuery(new TLRequestMessagesGetSearchResultsPositions(peer, savedPeerId, filter, offsetId, limit));
    }

    @Override
    public TLVector<TLMessageRange> messagesGetSplitRanges() throws RpcErrorException, IOException {
        return (TLVector<TLMessageRange>) executeRpcQuery(new TLRequestMessagesGetSplitRanges());
    }

    @Override
    public TLAbsSponsoredMessages messagesGetSponsoredMessages(TLAbsInputPeer peer) throws RpcErrorException, IOException {
        return (TLAbsSponsoredMessages) executeRpcQuery(new TLRequestMessagesGetSponsoredMessages(peer));
    }

    @Override
    public TLAbsStickerSet messagesGetStickerSet(TLAbsInputStickerSet stickerset, int hash) throws RpcErrorException, IOException {
        return (TLAbsStickerSet) executeRpcQuery(new TLRequestMessagesGetStickerSet(stickerset, hash));
    }

    @Override
    public TLAbsStickers messagesGetStickers(String emoticon, long hash) throws RpcErrorException, IOException {
        return (TLAbsStickers) executeRpcQuery(new TLRequestMessagesGetStickers(emoticon, hash));
    }

    @Override
    public TLVector<TLDialogFilterSuggested> messagesGetSuggestedDialogFilters() throws RpcErrorException, IOException {
        return (TLVector<TLDialogFilterSuggested>) executeRpcQuery(new TLRequestMessagesGetSuggestedDialogFilters());
    }

    @Override
    public TLAbsReactions messagesGetTopReactions(int limit, long hash) throws RpcErrorException, IOException {
        return (TLAbsReactions) executeRpcQuery(new TLRequestMessagesGetTopReactions(limit, hash));
    }

    @Override
    public TLAbsMessages messagesGetUnreadMentions(TLAbsInputPeer peer, Integer topMsgId, int offsetId, int addOffset, int limit, int maxId, int minId) throws RpcErrorException, IOException {
        return (TLAbsMessages) executeRpcQuery(new TLRequestMessagesGetUnreadMentions(peer, topMsgId, offsetId, addOffset, limit, maxId, minId));
    }

    @Override
    public TLAbsMessages messagesGetUnreadReactions(TLAbsInputPeer peer, Integer topMsgId, int offsetId, int addOffset, int limit, int maxId, int minId) throws RpcErrorException, IOException {
        return (TLAbsMessages) executeRpcQuery(new TLRequestMessagesGetUnreadReactions(peer, topMsgId, offsetId, addOffset, limit, maxId, minId));
    }

    @Override
    public TLWebPage messagesGetWebPage(String url, int hash) throws RpcErrorException, IOException {
        return (TLWebPage) executeRpcQuery(new TLRequestMessagesGetWebPage(url, hash));
    }

    @Override
    public TLAbsMessageMedia messagesGetWebPagePreview(String message, TLVector<TLAbsMessageEntity> entities) throws RpcErrorException, IOException {
        return (TLAbsMessageMedia) executeRpcQuery(new TLRequestMessagesGetWebPagePreview(message, entities));
    }

    @Override
    public TLAbsUpdates messagesHideAllChatJoinRequests(boolean approved, TLAbsInputPeer peer, String link) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesHideAllChatJoinRequests(approved, peer, link));
    }

    @Override
    public TLAbsUpdates messagesHideChatJoinRequest(boolean approved, TLAbsInputPeer peer, TLAbsInputUser userId) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesHideChatJoinRequest(approved, peer, userId));
    }

    @Override
    public TLBool messagesHidePeerSettingsBar(TLAbsInputPeer peer) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesHidePeerSettingsBar(peer));
    }

    @Override
    public TLAbsUpdates messagesImportChatInvite(String hash) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesImportChatInvite(hash));
    }

    @Override
    public TLHistoryImport messagesInitHistoryImport(TLAbsInputPeer peer, TLAbsInputFile file, int mediaCount) throws RpcErrorException, IOException {
        return (TLHistoryImport) executeRpcQuery(new TLRequestMessagesInitHistoryImport(peer, file, mediaCount));
    }

    @Override
    public TLAbsStickerSetInstallResult messagesInstallStickerSet(TLAbsInputStickerSet stickerset, boolean archived) throws RpcErrorException, IOException {
        return (TLAbsStickerSetInstallResult) executeRpcQuery(new TLRequestMessagesInstallStickerSet(stickerset, archived));
    }

    @Override
    public TLBool messagesMarkDialogUnread(boolean unread, TLAbsInputDialogPeer peer) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesMarkDialogUnread(unread, peer));
    }

    @Override
    public TLAbsUpdates messagesMigrateChat(long chatId) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesMigrateChat(chatId));
    }

    @Override
    public TLBool messagesProlongWebView(boolean silent, TLAbsInputPeer peer, TLAbsInputUser bot, long queryId, TLAbsInputReplyTo replyTo, TLAbsInputPeer sendAs) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesProlongWebView(silent, peer, bot, queryId, replyTo, sendAs));
    }

    @Override
    public TLBool messagesRateTranscribedAudio(TLAbsInputPeer peer, int msgId, long transcriptionId, boolean good) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesRateTranscribedAudio(peer, msgId, transcriptionId, good));
    }

    @Override
    public TLBool messagesReadDiscussion(TLAbsInputPeer peer, int msgId, int readMaxId) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesReadDiscussion(peer, msgId, readMaxId));
    }

    @Override
    public TLBool messagesReadEncryptedHistory(TLInputEncryptedChat peer, int maxDate) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesReadEncryptedHistory(peer, maxDate));
    }

    @Override
    public TLBool messagesReadFeaturedStickers(TLLongVector id) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesReadFeaturedStickers(id));
    }

    @Override
    public TLAffectedMessages messagesReadHistory(TLAbsInputPeer peer, int maxId) throws RpcErrorException, IOException {
        return (TLAffectedMessages) executeRpcQuery(new TLRequestMessagesReadHistory(peer, maxId));
    }

    @Override
    public TLAffectedHistory messagesReadMentions(TLAbsInputPeer peer, Integer topMsgId) throws RpcErrorException, IOException {
        return (TLAffectedHistory) executeRpcQuery(new TLRequestMessagesReadMentions(peer, topMsgId));
    }

    @Override
    public TLAffectedMessages messagesReadMessageContents(TLIntVector id) throws RpcErrorException, IOException {
        return (TLAffectedMessages) executeRpcQuery(new TLRequestMessagesReadMessageContents(id));
    }

    @Override
    public TLAffectedHistory messagesReadReactions(TLAbsInputPeer peer, Integer topMsgId) throws RpcErrorException, IOException {
        return (TLAffectedHistory) executeRpcQuery(new TLRequestMessagesReadReactions(peer, topMsgId));
    }

    @Override
    public TLVector<TLReceivedNotifyMessage> messagesReceivedMessages(int maxId) throws RpcErrorException, IOException {
        return (TLVector<TLReceivedNotifyMessage>) executeRpcQuery(new TLRequestMessagesReceivedMessages(maxId));
    }

    @Override
    public TLLongVector messagesReceivedQueue(int maxQts) throws RpcErrorException, IOException {
        return (TLLongVector) executeRpcQuery(new TLRequestMessagesReceivedQueue(maxQts));
    }

    @Override
    public TLBool messagesReorderPinnedDialogs(boolean force, int folderId, TLVector<TLAbsInputDialogPeer> order) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesReorderPinnedDialogs(force, folderId, order));
    }

    @Override
    public TLBool messagesReorderPinnedSavedDialogs(boolean force, TLVector<TLAbsInputDialogPeer> order) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesReorderPinnedSavedDialogs(force, order));
    }

    @Override
    public TLBool messagesReorderQuickReplies(TLIntVector order) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesReorderQuickReplies(order));
    }

    @Override
    public TLBool messagesReorderStickerSets(boolean masks, boolean emojis, TLLongVector order) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesReorderStickerSets(masks, emojis, order));
    }

    @Override
    public TLAbsReportResult messagesReport(TLAbsInputPeer peer, TLIntVector id, TLBytes option, String message) throws RpcErrorException, IOException {
        return (TLAbsReportResult) executeRpcQuery(new TLRequestMessagesReport(peer, id, option, message));
    }

    @Override
    public TLBool messagesReportEncryptedSpam(TLInputEncryptedChat peer) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesReportEncryptedSpam(peer));
    }

    @Override
    public TLBool messagesReportReaction(TLAbsInputPeer peer, int id, TLAbsInputPeer reactionPeer) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesReportReaction(peer, id, reactionPeer));
    }

    @Override
    public TLBool messagesReportSpam(TLAbsInputPeer peer) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesReportSpam(peer));
    }

    @Override
    public TLAbsSponsoredMessageReportResult messagesReportSponsoredMessage(TLAbsInputPeer peer, TLBytes randomId, TLBytes option) throws RpcErrorException, IOException {
        return (TLAbsSponsoredMessageReportResult) executeRpcQuery(new TLRequestMessagesReportSponsoredMessage(peer, randomId, option));
    }

    @Override
    public TLWebViewResultUrl messagesRequestAppWebView(boolean writeAllowed, boolean compact, boolean fullscreen, TLAbsInputPeer peer, TLAbsInputBotApp app, String startParam, TLDataJSON themeParams, String platform) throws RpcErrorException, IOException {
        return (TLWebViewResultUrl) executeRpcQuery(new TLRequestMessagesRequestAppWebView(writeAllowed, compact, fullscreen, peer, app, startParam, themeParams, platform));
    }

    @Override
    public TLAbsEncryptedChat messagesRequestEncryption(TLAbsInputUser userId, int randomId, TLBytes gA) throws RpcErrorException, IOException {
        return (TLAbsEncryptedChat) executeRpcQuery(new TLRequestMessagesRequestEncryption(userId, randomId, gA));
    }

    @Override
    public TLWebViewResultUrl messagesRequestMainWebView(boolean compact, boolean fullscreen, TLAbsInputPeer peer, TLAbsInputUser bot, String startParam, TLDataJSON themeParams, String platform) throws RpcErrorException, IOException {
        return (TLWebViewResultUrl) executeRpcQuery(new TLRequestMessagesRequestMainWebView(compact, fullscreen, peer, bot, startParam, themeParams, platform));
    }

    @Override
    public TLWebViewResultUrl messagesRequestSimpleWebView(boolean fromSwitchWebview, boolean fromSideMenu, boolean compact, boolean fullscreen, TLAbsInputUser bot, String url, String startParam, TLDataJSON themeParams, String platform) throws RpcErrorException, IOException {
        return (TLWebViewResultUrl) executeRpcQuery(new TLRequestMessagesRequestSimpleWebView(fromSwitchWebview, fromSideMenu, compact, fullscreen, bot, url, startParam, themeParams, platform));
    }

    @Override
    public TLAbsUrlAuthResult messagesRequestUrlAuth(TLAbsInputPeer peer, Integer msgId, Integer buttonId, String url) throws RpcErrorException, IOException {
        return (TLAbsUrlAuthResult) executeRpcQuery(new TLRequestMessagesRequestUrlAuth(peer, msgId, buttonId, url));
    }

    @Override
    public TLWebViewResultUrl messagesRequestWebView(boolean fromBotMenu, boolean silent, boolean compact, boolean fullscreen, TLAbsInputPeer peer, TLAbsInputUser bot, String url, String startParam, TLDataJSON themeParams, String platform, TLAbsInputReplyTo replyTo, TLAbsInputPeer sendAs) throws RpcErrorException, IOException {
        return (TLWebViewResultUrl) executeRpcQuery(new TLRequestMessagesRequestWebView(fromBotMenu, silent, compact, fullscreen, peer, bot, url, startParam, themeParams, platform, replyTo, sendAs));
    }

    @Override
    public TLBool messagesSaveDefaultSendAs(TLAbsInputPeer peer, TLAbsInputPeer sendAs) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSaveDefaultSendAs(peer, sendAs));
    }

    @Override
    public TLBool messagesSaveDraft(boolean noWebpage, boolean invertMedia, TLAbsInputReplyTo replyTo, TLAbsInputPeer peer, String message, TLVector<TLAbsMessageEntity> entities, TLAbsInputMedia media, Long effect) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSaveDraft(noWebpage, invertMedia, replyTo, peer, message, entities, media, effect));
    }

    @Override
    public TLBool messagesSaveGif(TLAbsInputDocument id, boolean unsave) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSaveGif(id, unsave));
    }

    @Override
    public TLBotPreparedInlineMessage messagesSavePreparedInlineMessage(TLAbsInputBotInlineResult result, TLAbsInputUser userId, TLVector<TLAbsInlineQueryPeerType> peerTypes) throws RpcErrorException, IOException {
        return (TLBotPreparedInlineMessage) executeRpcQuery(new TLRequestMessagesSavePreparedInlineMessage(result, userId, peerTypes));
    }

    @Override
    public TLBool messagesSaveRecentSticker(boolean attached, TLAbsInputDocument id, boolean unsave) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSaveRecentSticker(attached, id, unsave));
    }

    @Override
    public TLAbsMessages messagesSearch(TLAbsInputPeer peer, String q, TLAbsInputPeer fromId, TLAbsInputPeer savedPeerId, TLVector<TLAbsReaction> savedReaction, Integer topMsgId, TLAbsMessagesFilter filter, int minDate, int maxDate, int offsetId, int addOffset, int limit, int maxId, int minId, long hash) throws RpcErrorException, IOException {
        return (TLAbsMessages) executeRpcQuery(new TLRequestMessagesSearch(peer, q, fromId, savedPeerId, savedReaction, topMsgId, filter, minDate, maxDate, offsetId, addOffset, limit, maxId, minId, hash));
    }

    @Override
    public TLAbsEmojiList messagesSearchCustomEmoji(String emoticon, long hash) throws RpcErrorException, IOException {
        return (TLAbsEmojiList) executeRpcQuery(new TLRequestMessagesSearchCustomEmoji(emoticon, hash));
    }

    @Override
    public TLAbsFoundStickerSets messagesSearchEmojiStickerSets(boolean excludeFeatured, String q, long hash) throws RpcErrorException, IOException {
        return (TLAbsFoundStickerSets) executeRpcQuery(new TLRequestMessagesSearchEmojiStickerSets(excludeFeatured, q, hash));
    }

    @Override
    public TLAbsMessages messagesSearchGlobal(boolean broadcastsOnly, boolean groupsOnly, boolean usersOnly, Integer folderId, String q, TLAbsMessagesFilter filter, int minDate, int maxDate, int offsetRate, TLAbsInputPeer offsetPeer, int offsetId, int limit) throws RpcErrorException, IOException {
        return (TLAbsMessages) executeRpcQuery(new TLRequestMessagesSearchGlobal(broadcastsOnly, groupsOnly, usersOnly, folderId, q, filter, minDate, maxDate, offsetRate, offsetPeer, offsetId, limit));
    }

    @Override
    public TLAbsMessages messagesSearchSentMedia(String q, TLAbsMessagesFilter filter, int limit) throws RpcErrorException, IOException {
        return (TLAbsMessages) executeRpcQuery(new TLRequestMessagesSearchSentMedia(q, filter, limit));
    }

    @Override
    public TLAbsFoundStickerSets messagesSearchStickerSets(boolean excludeFeatured, String q, long hash) throws RpcErrorException, IOException {
        return (TLAbsFoundStickerSets) executeRpcQuery(new TLRequestMessagesSearchStickerSets(excludeFeatured, q, hash));
    }

    @Override
    public TLAbsFoundStickers messagesSearchStickers(boolean emojis, String q, String emoticon, TLStringVector langCode, int offset, int limit, long hash) throws RpcErrorException, IOException {
        return (TLAbsFoundStickers) executeRpcQuery(new TLRequestMessagesSearchStickers(emojis, q, emoticon, langCode, offset, limit, hash));
    }

    @Override
    public TLAbsUpdates messagesSendBotRequestedPeer(TLAbsInputPeer peer, int msgId, int buttonId, TLVector<TLAbsInputPeer> requestedPeers) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesSendBotRequestedPeer(peer, msgId, buttonId, requestedPeers));
    }

    @Override
    public TLAbsSentEncryptedMessage messagesSendEncrypted(boolean silent, TLInputEncryptedChat peer, long randomId, TLBytes data) throws RpcErrorException, IOException {
        return (TLAbsSentEncryptedMessage) executeRpcQuery(new TLRequestMessagesSendEncrypted(silent, peer, randomId, data));
    }

    @Override
    public TLAbsSentEncryptedMessage messagesSendEncryptedFile(boolean silent, TLInputEncryptedChat peer, long randomId, TLBytes data, TLAbsInputEncryptedFile file) throws RpcErrorException, IOException {
        return (TLAbsSentEncryptedMessage) executeRpcQuery(new TLRequestMessagesSendEncryptedFile(silent, peer, randomId, data, file));
    }

    @Override
    public TLAbsSentEncryptedMessage messagesSendEncryptedService(TLInputEncryptedChat peer, long randomId, TLBytes data) throws RpcErrorException, IOException {
        return (TLAbsSentEncryptedMessage) executeRpcQuery(new TLRequestMessagesSendEncryptedService(peer, randomId, data));
    }

    @Override
    public TLAbsUpdates messagesSendInlineBotResult(boolean silent, boolean background, boolean clearDraft, boolean hideVia, TLAbsInputPeer peer, TLAbsInputReplyTo replyTo, long randomId, long queryId, String id, Integer scheduleDate, TLAbsInputPeer sendAs, TLAbsInputQuickReplyShortcut quickReplyShortcut) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesSendInlineBotResult(silent, background, clearDraft, hideVia, peer, replyTo, randomId, queryId, id, scheduleDate, sendAs, quickReplyShortcut));
    }

    @Override
    public TLAbsUpdates messagesSendMedia(boolean silent, boolean background, boolean clearDraft, boolean noforwards, boolean updateStickersetsOrder, boolean invertMedia, boolean allowPaidFloodskip, TLAbsInputPeer peer, TLAbsInputReplyTo replyTo, TLAbsInputMedia media, String message, long randomId, TLAbsReplyMarkup replyMarkup, TLVector<TLAbsMessageEntity> entities, Integer scheduleDate, TLAbsInputPeer sendAs, TLAbsInputQuickReplyShortcut quickReplyShortcut, Long effect) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesSendMedia(silent, background, clearDraft, noforwards, updateStickersetsOrder, invertMedia, allowPaidFloodskip, peer, replyTo, media, message, randomId, replyMarkup, entities, scheduleDate, sendAs, quickReplyShortcut, effect));
    }

    @Override
    public TLAbsUpdates messagesSendMessage(boolean noWebpage, boolean silent, boolean background, boolean clearDraft, boolean noforwards, boolean updateStickersetsOrder, boolean invertMedia, boolean allowPaidFloodskip, TLAbsInputPeer peer, TLAbsInputReplyTo replyTo, String message, long randomId, TLAbsReplyMarkup replyMarkup, TLVector<TLAbsMessageEntity> entities, Integer scheduleDate, TLAbsInputPeer sendAs, TLAbsInputQuickReplyShortcut quickReplyShortcut, Long effect) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesSendMessage(noWebpage, silent, background, clearDraft, noforwards, updateStickersetsOrder, invertMedia, allowPaidFloodskip, peer, replyTo, message, randomId, replyMarkup, entities, scheduleDate, sendAs, quickReplyShortcut, effect));
    }

    @Override
    public TLAbsUpdates messagesSendMultiMedia(boolean silent, boolean background, boolean clearDraft, boolean noforwards, boolean updateStickersetsOrder, boolean invertMedia, boolean allowPaidFloodskip, TLAbsInputPeer peer, TLAbsInputReplyTo replyTo, TLVector<TLInputSingleMedia> multiMedia, Integer scheduleDate, TLAbsInputPeer sendAs, TLAbsInputQuickReplyShortcut quickReplyShortcut, Long effect) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesSendMultiMedia(silent, background, clearDraft, noforwards, updateStickersetsOrder, invertMedia, allowPaidFloodskip, peer, replyTo, multiMedia, scheduleDate, sendAs, quickReplyShortcut, effect));
    }

    @Override
    public TLAbsUpdates messagesSendPaidReaction(TLAbsInputPeer peer, int msgId, int count, long randomId, boolean _private) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesSendPaidReaction(peer, msgId, count, randomId, _private));
    }

    @Override
    public TLAbsUpdates messagesSendQuickReplyMessages(TLAbsInputPeer peer, int shortcutId, TLIntVector id, TLLongVector randomId) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesSendQuickReplyMessages(peer, shortcutId, id, randomId));
    }

    @Override
    public TLAbsUpdates messagesSendReaction(boolean big, boolean addToRecent, TLAbsInputPeer peer, int msgId, TLVector<TLAbsReaction> reaction) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesSendReaction(big, addToRecent, peer, msgId, reaction));
    }

    @Override
    public TLAbsUpdates messagesSendScheduledMessages(TLAbsInputPeer peer, TLIntVector id) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesSendScheduledMessages(peer, id));
    }

    @Override
    public TLAbsUpdates messagesSendScreenshotNotification(TLAbsInputPeer peer, TLAbsInputReplyTo replyTo, long randomId) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesSendScreenshotNotification(peer, replyTo, randomId));
    }

    @Override
    public TLAbsUpdates messagesSendVote(TLAbsInputPeer peer, int msgId, TLVector<TLBytes> options) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesSendVote(peer, msgId, options));
    }

    @Override
    public TLAbsUpdates messagesSendWebViewData(TLAbsInputUser bot, long randomId, String buttonText, String data) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesSendWebViewData(bot, randomId, buttonText, data));
    }

    @Override
    public TLWebViewMessageSent messagesSendWebViewResultMessage(String botQueryId, TLAbsInputBotInlineResult result) throws RpcErrorException, IOException {
        return (TLWebViewMessageSent) executeRpcQuery(new TLRequestMessagesSendWebViewResultMessage(botQueryId, result));
    }

    @Override
    public TLBool messagesSetBotCallbackAnswer(boolean alert, long queryId, String message, String url, int cacheTime) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSetBotCallbackAnswer(alert, queryId, message, url, cacheTime));
    }

    @Override
    public TLBool messagesSetBotPrecheckoutResults(boolean success, long queryId, String error) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSetBotPrecheckoutResults(success, queryId, error));
    }

    @Override
    public TLBool messagesSetBotShippingResults(long queryId, String error, TLVector<TLShippingOption> shippingOptions) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSetBotShippingResults(queryId, error, shippingOptions));
    }

    @Override
    public TLAbsUpdates messagesSetChatAvailableReactions(TLAbsInputPeer peer, TLAbsChatReactions availableReactions, Integer reactionsLimit, boolean paidEnabled) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesSetChatAvailableReactions(peer, availableReactions, reactionsLimit, paidEnabled));
    }

    @Override
    public TLAbsUpdates messagesSetChatTheme(TLAbsInputPeer peer, String emoticon) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesSetChatTheme(peer, emoticon));
    }

    @Override
    public TLAbsUpdates messagesSetChatWallPaper(boolean forBoth, boolean revert, TLAbsInputPeer peer, TLAbsInputWallPaper wallpaper, TLWallPaperSettings settings, Integer id) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesSetChatWallPaper(forBoth, revert, peer, wallpaper, settings, id));
    }

    @Override
    public TLBool messagesSetDefaultHistoryTTL(int period) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSetDefaultHistoryTTL(period));
    }

    @Override
    public TLBool messagesSetDefaultReaction(TLAbsReaction reaction) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSetDefaultReaction(reaction));
    }

    @Override
    public TLBool messagesSetEncryptedTyping(TLInputEncryptedChat peer, boolean typing) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSetEncryptedTyping(peer, typing));
    }

    @Override
    public TLAbsUpdates messagesSetGameScore(boolean editMessage, boolean force, TLAbsInputPeer peer, int id, TLAbsInputUser userId, int score) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesSetGameScore(editMessage, force, peer, id, userId, score));
    }

    @Override
    public TLAbsUpdates messagesSetHistoryTTL(TLAbsInputPeer peer, int period) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesSetHistoryTTL(peer, period));
    }

    @Override
    public TLBool messagesSetInlineBotResults(boolean gallery, boolean _private, long queryId, TLVector<TLAbsInputBotInlineResult> results, int cacheTime, String nextOffset, TLInlineBotSwitchPM switchPm, TLInlineBotWebView switchWebview) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSetInlineBotResults(gallery, _private, queryId, results, cacheTime, nextOffset, switchPm, switchWebview));
    }

    @Override
    public TLBool messagesSetInlineGameScore(boolean editMessage, boolean force, TLAbsInputBotInlineMessageID id, TLAbsInputUser userId, int score) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSetInlineGameScore(editMessage, force, id, userId, score));
    }

    @Override
    public TLBool messagesSetTyping(TLAbsInputPeer peer, Integer topMsgId, TLAbsSendMessageAction action) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSetTyping(peer, topMsgId, action));
    }

    @Override
    public TLAbsUpdates messagesStartBot(TLAbsInputUser bot, TLAbsInputPeer peer, long randomId, String startParam) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesStartBot(bot, peer, randomId, startParam));
    }

    @Override
    public TLBool messagesStartHistoryImport(TLAbsInputPeer peer, long importId) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesStartHistoryImport(peer, importId));
    }

    @Override
    public TLBool messagesToggleBotInAttachMenu(boolean writeAllowed, TLAbsInputUser bot, boolean enabled) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesToggleBotInAttachMenu(writeAllowed, bot, enabled));
    }

    @Override
    public TLBool messagesToggleDialogFilterTags(boolean enabled) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesToggleDialogFilterTags(enabled));
    }

    @Override
    public TLBool messagesToggleDialogPin(boolean pinned, TLAbsInputDialogPeer peer) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesToggleDialogPin(pinned, peer));
    }

    @Override
    public TLAbsUpdates messagesToggleNoForwards(TLAbsInputPeer peer, boolean enabled) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesToggleNoForwards(peer, enabled));
    }

    @Override
    public TLBool messagesTogglePaidReactionPrivacy(TLAbsInputPeer peer, int msgId, boolean _private) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesTogglePaidReactionPrivacy(peer, msgId, _private));
    }

    @Override
    public TLBool messagesTogglePeerTranslations(boolean disabled, TLAbsInputPeer peer) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesTogglePeerTranslations(disabled, peer));
    }

    @Override
    public TLBool messagesToggleSavedDialogPin(boolean pinned, TLAbsInputDialogPeer peer) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesToggleSavedDialogPin(pinned, peer));
    }

    @Override
    public TLBool messagesToggleStickerSets(boolean uninstall, boolean archive, boolean unarchive, TLVector<TLAbsInputStickerSet> stickersets) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesToggleStickerSets(uninstall, archive, unarchive, stickersets));
    }

    @Override
    public TLTranscribedAudio messagesTranscribeAudio(TLAbsInputPeer peer, int msgId) throws RpcErrorException, IOException {
        return (TLTranscribedAudio) executeRpcQuery(new TLRequestMessagesTranscribeAudio(peer, msgId));
    }

    @Override
    public TLTranslateResult messagesTranslateText(TLAbsInputPeer peer, TLIntVector id, TLVector<TLTextWithEntities> text, String toLang) throws RpcErrorException, IOException {
        return (TLTranslateResult) executeRpcQuery(new TLRequestMessagesTranslateText(peer, id, text, toLang));
    }

    @Override
    public TLBool messagesUninstallStickerSet(TLAbsInputStickerSet stickerset) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesUninstallStickerSet(stickerset));
    }

    @Override
    public TLAffectedHistory messagesUnpinAllMessages(TLAbsInputPeer peer, Integer topMsgId) throws RpcErrorException, IOException {
        return (TLAffectedHistory) executeRpcQuery(new TLRequestMessagesUnpinAllMessages(peer, topMsgId));
    }

    @Override
    public TLBool messagesUpdateDialogFilter(int id, TLAbsDialogFilter filter) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesUpdateDialogFilter(id, filter));
    }

    @Override
    public TLBool messagesUpdateDialogFiltersOrder(TLIntVector order) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesUpdateDialogFiltersOrder(order));
    }

    @Override
    public TLAbsUpdates messagesUpdatePinnedMessage(boolean silent, boolean unpin, boolean pmOneside, TLAbsInputPeer peer, int id) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesUpdatePinnedMessage(silent, unpin, pmOneside, peer, id));
    }

    @Override
    public TLBool messagesUpdateSavedReactionTag(TLAbsReaction reaction, String title) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesUpdateSavedReactionTag(reaction, title));
    }

    @Override
    public TLAbsEncryptedFile messagesUploadEncryptedFile(TLInputEncryptedChat peer, TLAbsInputEncryptedFile file) throws RpcErrorException, IOException {
        return (TLAbsEncryptedFile) executeRpcQuery(new TLRequestMessagesUploadEncryptedFile(peer, file));
    }

    @Override
    public TLAbsMessageMedia messagesUploadImportedMedia(TLAbsInputPeer peer, long importId, String fileName, TLAbsInputMedia media) throws RpcErrorException, IOException {
        return (TLAbsMessageMedia) executeRpcQuery(new TLRequestMessagesUploadImportedMedia(peer, importId, fileName, media));
    }

    @Override
    public TLAbsMessageMedia messagesUploadMedia(String businessConnectionId, TLAbsInputPeer peer, TLAbsInputMedia media) throws RpcErrorException, IOException {
        return (TLAbsMessageMedia) executeRpcQuery(new TLRequestMessagesUploadMedia(businessConnectionId, peer, media));
    }

    @Override
    public TLBool messagesViewSponsoredMessage(TLAbsInputPeer peer, TLBytes randomId) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesViewSponsoredMessage(peer, randomId));
    }

    @Override
    public TLAbsUpdates paymentsApplyGiftCode(String slug) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestPaymentsApplyGiftCode(slug));
    }

    @Override
    public TLAbsUpdates paymentsAssignAppStoreTransaction(TLBytes receipt, TLAbsInputStorePaymentPurpose purpose) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestPaymentsAssignAppStoreTransaction(receipt, purpose));
    }

    @Override
    public TLAbsUpdates paymentsAssignPlayMarketTransaction(TLDataJSON receipt, TLAbsInputStorePaymentPurpose purpose) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestPaymentsAssignPlayMarketTransaction(receipt, purpose));
    }

    @Override
    public TLBool paymentsBotCancelStarsSubscription(boolean restore, TLAbsInputUser userId, String chargeId) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestPaymentsBotCancelStarsSubscription(restore, userId, chargeId));
    }

    @Override
    public TLBool paymentsCanPurchasePremium(TLAbsInputStorePaymentPurpose purpose) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestPaymentsCanPurchasePremium(purpose));
    }

    @Override
    public TLBool paymentsChangeStarsSubscription(TLAbsInputPeer peer, String subscriptionId, boolean canceled) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestPaymentsChangeStarsSubscription(peer, subscriptionId, canceled));
    }

    @Override
    public TLCheckedGiftCode paymentsCheckGiftCode(String slug) throws RpcErrorException, IOException {
        return (TLCheckedGiftCode) executeRpcQuery(new TLRequestPaymentsCheckGiftCode(slug));
    }

    @Override
    public TLBool paymentsClearSavedInfo(boolean credentials, boolean info) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestPaymentsClearSavedInfo(credentials, info));
    }

    @Override
    public TLConnectedStarRefBots paymentsConnectStarRefBot(TLAbsInputPeer peer, TLAbsInputUser bot) throws RpcErrorException, IOException {
        return (TLConnectedStarRefBots) executeRpcQuery(new TLRequestPaymentsConnectStarRefBot(peer, bot));
    }

    @Override
    public TLBool paymentsConvertStarGift(TLAbsInputUser userId, int msgId) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestPaymentsConvertStarGift(userId, msgId));
    }

    @Override
    public TLConnectedStarRefBots paymentsEditConnectedStarRefBot(boolean revoked, TLAbsInputPeer peer, String link) throws RpcErrorException, IOException {
        return (TLConnectedStarRefBots) executeRpcQuery(new TLRequestPaymentsEditConnectedStarRefBot(revoked, peer, link));
    }

    @Override
    public TLExportedInvoice paymentsExportInvoice(TLAbsInputMedia invoiceMedia) throws RpcErrorException, IOException {
        return (TLExportedInvoice) executeRpcQuery(new TLRequestPaymentsExportInvoice(invoiceMedia));
    }

    @Override
    public TLBool paymentsFulfillStarsSubscription(TLAbsInputPeer peer, String subscriptionId) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestPaymentsFulfillStarsSubscription(peer, subscriptionId));
    }

    @Override
    public TLBankCardData paymentsGetBankCardData(String number) throws RpcErrorException, IOException {
        return (TLBankCardData) executeRpcQuery(new TLRequestPaymentsGetBankCardData(number));
    }

    @Override
    public TLConnectedStarRefBots paymentsGetConnectedStarRefBot(TLAbsInputPeer peer, TLAbsInputUser bot) throws RpcErrorException, IOException {
        return (TLConnectedStarRefBots) executeRpcQuery(new TLRequestPaymentsGetConnectedStarRefBot(peer, bot));
    }

    @Override
    public TLConnectedStarRefBots paymentsGetConnectedStarRefBots(TLAbsInputPeer peer, Integer offsetDate, String offsetLink, int limit) throws RpcErrorException, IOException {
        return (TLConnectedStarRefBots) executeRpcQuery(new TLRequestPaymentsGetConnectedStarRefBots(peer, offsetDate, offsetLink, limit));
    }

    @Override
    public TLAbsGiveawayInfo paymentsGetGiveawayInfo(TLAbsInputPeer peer, int msgId) throws RpcErrorException, IOException {
        return (TLAbsGiveawayInfo) executeRpcQuery(new TLRequestPaymentsGetGiveawayInfo(peer, msgId));
    }

    @Override
    public TLAbsPaymentForm paymentsGetPaymentForm(TLAbsInputInvoice invoice, TLDataJSON themeParams) throws RpcErrorException, IOException {
        return (TLAbsPaymentForm) executeRpcQuery(new TLRequestPaymentsGetPaymentForm(invoice, themeParams));
    }

    @Override
    public TLAbsPaymentReceipt paymentsGetPaymentReceipt(TLAbsInputPeer peer, int msgId) throws RpcErrorException, IOException {
        return (TLAbsPaymentReceipt) executeRpcQuery(new TLRequestPaymentsGetPaymentReceipt(peer, msgId));
    }

    @Override
    public TLVector<TLPremiumGiftCodeOption> paymentsGetPremiumGiftCodeOptions(TLAbsInputPeer boostPeer) throws RpcErrorException, IOException {
        return (TLVector<TLPremiumGiftCodeOption>) executeRpcQuery(new TLRequestPaymentsGetPremiumGiftCodeOptions(boostPeer));
    }

    @Override
    public TLSavedInfo paymentsGetSavedInfo() throws RpcErrorException, IOException {
        return (TLSavedInfo) executeRpcQuery(new TLRequestPaymentsGetSavedInfo());
    }

    @Override
    public TLAbsStarGifts paymentsGetStarGifts(int hash) throws RpcErrorException, IOException {
        return (TLAbsStarGifts) executeRpcQuery(new TLRequestPaymentsGetStarGifts(hash));
    }

    @Override
    public TLVector<TLStarsGiftOption> paymentsGetStarsGiftOptions(TLAbsInputUser userId) throws RpcErrorException, IOException {
        return (TLVector<TLStarsGiftOption>) executeRpcQuery(new TLRequestPaymentsGetStarsGiftOptions(userId));
    }

    @Override
    public TLVector<TLStarsGiveawayOption> paymentsGetStarsGiveawayOptions() throws RpcErrorException, IOException {
        return (TLVector<TLStarsGiveawayOption>) executeRpcQuery(new TLRequestPaymentsGetStarsGiveawayOptions());
    }

    @Override
    public TLStarsRevenueAdsAccountUrl paymentsGetStarsRevenueAdsAccountUrl(TLAbsInputPeer peer) throws RpcErrorException, IOException {
        return (TLStarsRevenueAdsAccountUrl) executeRpcQuery(new TLRequestPaymentsGetStarsRevenueAdsAccountUrl(peer));
    }

    @Override
    public TLStarsRevenueStats paymentsGetStarsRevenueStats(boolean dark, TLAbsInputPeer peer) throws RpcErrorException, IOException {
        return (TLStarsRevenueStats) executeRpcQuery(new TLRequestPaymentsGetStarsRevenueStats(dark, peer));
    }

    @Override
    public TLStarsRevenueWithdrawalUrl paymentsGetStarsRevenueWithdrawalUrl(TLAbsInputPeer peer, long stars, TLAbsInputCheckPasswordSRP password) throws RpcErrorException, IOException {
        return (TLStarsRevenueWithdrawalUrl) executeRpcQuery(new TLRequestPaymentsGetStarsRevenueWithdrawalUrl(peer, stars, password));
    }

    @Override
    public TLStarsStatus paymentsGetStarsStatus(TLAbsInputPeer peer) throws RpcErrorException, IOException {
        return (TLStarsStatus) executeRpcQuery(new TLRequestPaymentsGetStarsStatus(peer));
    }

    @Override
    public TLStarsStatus paymentsGetStarsSubscriptions(boolean missingBalance, TLAbsInputPeer peer, String offset) throws RpcErrorException, IOException {
        return (TLStarsStatus) executeRpcQuery(new TLRequestPaymentsGetStarsSubscriptions(missingBalance, peer, offset));
    }

    @Override
    public TLVector<TLStarsTopupOption> paymentsGetStarsTopupOptions() throws RpcErrorException, IOException {
        return (TLVector<TLStarsTopupOption>) executeRpcQuery(new TLRequestPaymentsGetStarsTopupOptions());
    }

    @Override
    public TLStarsStatus paymentsGetStarsTransactions(boolean inbound, boolean outbound, boolean ascending, String subscriptionId, TLAbsInputPeer peer, String offset, int limit) throws RpcErrorException, IOException {
        return (TLStarsStatus) executeRpcQuery(new TLRequestPaymentsGetStarsTransactions(inbound, outbound, ascending, subscriptionId, peer, offset, limit));
    }

    @Override
    public TLStarsStatus paymentsGetStarsTransactionsByID(TLAbsInputPeer peer, TLVector<TLInputStarsTransaction> id) throws RpcErrorException, IOException {
        return (TLStarsStatus) executeRpcQuery(new TLRequestPaymentsGetStarsTransactionsByID(peer, id));
    }

    @Override
    public TLSuggestedStarRefBots paymentsGetSuggestedStarRefBots(boolean orderByRevenue, boolean orderByDate, TLAbsInputPeer peer, String offset, int limit) throws RpcErrorException, IOException {
        return (TLSuggestedStarRefBots) executeRpcQuery(new TLRequestPaymentsGetSuggestedStarRefBots(orderByRevenue, orderByDate, peer, offset, limit));
    }

    @Override
    public TLUserStarGifts paymentsGetUserStarGifts(TLAbsInputUser userId, String offset, int limit) throws RpcErrorException, IOException {
        return (TLUserStarGifts) executeRpcQuery(new TLRequestPaymentsGetUserStarGifts(userId, offset, limit));
    }

    @Override
    public TLAbsUpdates paymentsLaunchPrepaidGiveaway(TLAbsInputPeer peer, long giveawayId, TLAbsInputStorePaymentPurpose purpose) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestPaymentsLaunchPrepaidGiveaway(peer, giveawayId, purpose));
    }

    @Override
    public TLAbsUpdates paymentsRefundStarsCharge(TLAbsInputUser userId, String chargeId) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestPaymentsRefundStarsCharge(userId, chargeId));
    }

    @Override
    public TLBool paymentsSaveStarGift(boolean unsave, TLAbsInputUser userId, int msgId) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestPaymentsSaveStarGift(unsave, userId, msgId));
    }

    @Override
    public TLAbsPaymentResult paymentsSendPaymentForm(long formId, TLAbsInputInvoice invoice, String requestedInfoId, String shippingOptionId, TLAbsInputPaymentCredentials credentials, Long tipAmount) throws RpcErrorException, IOException {
        return (TLAbsPaymentResult) executeRpcQuery(new TLRequestPaymentsSendPaymentForm(formId, invoice, requestedInfoId, shippingOptionId, credentials, tipAmount));
    }

    @Override
    public TLAbsPaymentResult paymentsSendStarsForm(long formId, TLAbsInputInvoice invoice) throws RpcErrorException, IOException {
        return (TLAbsPaymentResult) executeRpcQuery(new TLRequestPaymentsSendStarsForm(formId, invoice));
    }

    @Override
    public TLValidatedRequestedInfo paymentsValidateRequestedInfo(boolean save, TLAbsInputInvoice invoice, TLPaymentRequestedInfo info) throws RpcErrorException, IOException {
        return (TLValidatedRequestedInfo) executeRpcQuery(new TLRequestPaymentsValidateRequestedInfo(save, invoice, info));
    }

    @Override
    public TLPhoneCall phoneAcceptCall(TLInputPhoneCall peer, TLBytes gB, TLPhoneCallProtocol protocol) throws RpcErrorException, IOException {
        return (TLPhoneCall) executeRpcQuery(new TLRequestPhoneAcceptCall(peer, gB, protocol));
    }

    @Override
    public TLIntVector phoneCheckGroupCall(TLInputGroupCall call, TLIntVector sources) throws RpcErrorException, IOException {
        return (TLIntVector) executeRpcQuery(new TLRequestPhoneCheckGroupCall(call, sources));
    }

    @Override
    public TLPhoneCall phoneConfirmCall(TLInputPhoneCall peer, TLBytes gA, long keyFingerprint, TLPhoneCallProtocol protocol) throws RpcErrorException, IOException {
        return (TLPhoneCall) executeRpcQuery(new TLRequestPhoneConfirmCall(peer, gA, keyFingerprint, protocol));
    }

    @Override
    public TLAbsUpdates phoneCreateGroupCall(boolean rtmpStream, TLAbsInputPeer peer, int randomId, String title, Integer scheduleDate) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestPhoneCreateGroupCall(rtmpStream, peer, randomId, title, scheduleDate));
    }

    @Override
    public TLAbsUpdates phoneDiscardCall(boolean video, TLInputPhoneCall peer, int duration, TLAbsPhoneCallDiscardReason reason, long connectionId) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestPhoneDiscardCall(video, peer, duration, reason, connectionId));
    }

    @Override
    public TLAbsUpdates phoneDiscardGroupCall(TLInputGroupCall call) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestPhoneDiscardGroupCall(call));
    }

    @Override
    public TLAbsUpdates phoneEditGroupCallParticipant(TLInputGroupCall call, TLAbsInputPeer participant, boolean muted, Integer volume, boolean raiseHand, boolean videoStopped, boolean videoPaused, boolean presentationPaused) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestPhoneEditGroupCallParticipant(call, participant, muted, volume, raiseHand, videoStopped, videoPaused, presentationPaused));
    }

    @Override
    public TLAbsUpdates phoneEditGroupCallTitle(TLInputGroupCall call, String title) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestPhoneEditGroupCallTitle(call, title));
    }

    @Override
    public TLExportedGroupCallInvite phoneExportGroupCallInvite(boolean canSelfUnmute, TLInputGroupCall call) throws RpcErrorException, IOException {
        return (TLExportedGroupCallInvite) executeRpcQuery(new TLRequestPhoneExportGroupCallInvite(canSelfUnmute, call));
    }

    @Override
    public TLDataJSON phoneGetCallConfig() throws RpcErrorException, IOException {
        return (TLDataJSON) executeRpcQuery(new TLRequestPhoneGetCallConfig());
    }

    @Override
    public TLGroupCall phoneGetGroupCall(TLInputGroupCall call, int limit) throws RpcErrorException, IOException {
        return (TLGroupCall) executeRpcQuery(new TLRequestPhoneGetGroupCall(call, limit));
    }

    @Override
    public TLJoinAsPeers phoneGetGroupCallJoinAs(TLAbsInputPeer peer) throws RpcErrorException, IOException {
        return (TLJoinAsPeers) executeRpcQuery(new TLRequestPhoneGetGroupCallJoinAs(peer));
    }

    @Override
    public TLGroupCallStreamChannels phoneGetGroupCallStreamChannels(TLInputGroupCall call) throws RpcErrorException, IOException {
        return (TLGroupCallStreamChannels) executeRpcQuery(new TLRequestPhoneGetGroupCallStreamChannels(call));
    }

    @Override
    public TLGroupCallStreamRtmpUrl phoneGetGroupCallStreamRtmpUrl(TLAbsInputPeer peer, boolean revoke) throws RpcErrorException, IOException {
        return (TLGroupCallStreamRtmpUrl) executeRpcQuery(new TLRequestPhoneGetGroupCallStreamRtmpUrl(peer, revoke));
    }

    @Override
    public TLGroupParticipants phoneGetGroupParticipants(TLInputGroupCall call, TLVector<TLAbsInputPeer> ids, TLIntVector sources, String offset, int limit) throws RpcErrorException, IOException {
        return (TLGroupParticipants) executeRpcQuery(new TLRequestPhoneGetGroupParticipants(call, ids, sources, offset, limit));
    }

    @Override
    public TLAbsUpdates phoneInviteToGroupCall(TLInputGroupCall call, TLVector<TLAbsInputUser> users) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestPhoneInviteToGroupCall(call, users));
    }

    @Override
    public TLAbsUpdates phoneJoinGroupCall(boolean muted, boolean videoStopped, TLInputGroupCall call, TLAbsInputPeer joinAs, String inviteHash, TLDataJSON params) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestPhoneJoinGroupCall(muted, videoStopped, call, joinAs, inviteHash, params));
    }

    @Override
    public TLAbsUpdates phoneJoinGroupCallPresentation(TLInputGroupCall call, TLDataJSON params) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestPhoneJoinGroupCallPresentation(call, params));
    }

    @Override
    public TLAbsUpdates phoneLeaveGroupCall(TLInputGroupCall call, int source) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestPhoneLeaveGroupCall(call, source));
    }

    @Override
    public TLAbsUpdates phoneLeaveGroupCallPresentation(TLInputGroupCall call) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestPhoneLeaveGroupCallPresentation(call));
    }

    @Override
    public TLBool phoneReceivedCall(TLInputPhoneCall peer) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestPhoneReceivedCall(peer));
    }

    @Override
    public TLPhoneCall phoneRequestCall(boolean video, TLAbsInputUser userId, int randomId, TLBytes gAHash, TLPhoneCallProtocol protocol) throws RpcErrorException, IOException {
        return (TLPhoneCall) executeRpcQuery(new TLRequestPhoneRequestCall(video, userId, randomId, gAHash, protocol));
    }

    @Override
    public TLBool phoneSaveCallDebug(TLInputPhoneCall peer, TLDataJSON debug) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestPhoneSaveCallDebug(peer, debug));
    }

    @Override
    public TLBool phoneSaveCallLog(TLInputPhoneCall peer, TLAbsInputFile file) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestPhoneSaveCallLog(peer, file));
    }

    @Override
    public TLBool phoneSaveDefaultGroupCallJoinAs(TLAbsInputPeer peer, TLAbsInputPeer joinAs) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestPhoneSaveDefaultGroupCallJoinAs(peer, joinAs));
    }

    @Override
    public TLBool phoneSendSignalingData(TLInputPhoneCall peer, TLBytes data) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestPhoneSendSignalingData(peer, data));
    }

    @Override
    public TLAbsUpdates phoneSetCallRating(boolean userInitiative, TLInputPhoneCall peer, int rating, String comment) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestPhoneSetCallRating(userInitiative, peer, rating, comment));
    }

    @Override
    public TLAbsUpdates phoneStartScheduledGroupCall(TLInputGroupCall call) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestPhoneStartScheduledGroupCall(call));
    }

    @Override
    public TLAbsUpdates phoneToggleGroupCallRecord(boolean start, boolean video, TLInputGroupCall call, String title, boolean videoPortrait) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestPhoneToggleGroupCallRecord(start, video, call, title, videoPortrait));
    }

    @Override
    public TLAbsUpdates phoneToggleGroupCallSettings(boolean resetInviteHash, TLInputGroupCall call, boolean joinMuted) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestPhoneToggleGroupCallSettings(resetInviteHash, call, joinMuted));
    }

    @Override
    public TLAbsUpdates phoneToggleGroupCallStartSubscription(TLInputGroupCall call, boolean subscribed) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestPhoneToggleGroupCallStartSubscription(call, subscribed));
    }

    @Override
    public TLLongVector photosDeletePhotos(TLVector<TLAbsInputPhoto> id) throws RpcErrorException, IOException {
        return (TLLongVector) executeRpcQuery(new TLRequestPhotosDeletePhotos(id));
    }

    @Override
    public TLAbsPhotos photosGetUserPhotos(TLAbsInputUser userId, int offset, long maxId, int limit) throws RpcErrorException, IOException {
        return (TLAbsPhotos) executeRpcQuery(new TLRequestPhotosGetUserPhotos(userId, offset, maxId, limit));
    }

    @Override
    public TLPhoto photosUpdateProfilePhoto(boolean fallback, TLAbsInputUser bot, TLAbsInputPhoto id) throws RpcErrorException, IOException {
        return (TLPhoto) executeRpcQuery(new TLRequestPhotosUpdateProfilePhoto(fallback, bot, id));
    }

    @Override
    public TLPhoto photosUploadContactProfilePhoto(boolean suggest, boolean save, TLAbsInputUser userId, TLAbsInputFile file, TLAbsInputFile video, Double videoStartTs, TLAbsVideoSize videoEmojiMarkup) throws RpcErrorException, IOException {
        return (TLPhoto) executeRpcQuery(new TLRequestPhotosUploadContactProfilePhoto(suggest, save, userId, file, video, videoStartTs, videoEmojiMarkup));
    }

    @Override
    public TLPhoto photosUploadProfilePhoto(boolean fallback, TLAbsInputUser bot, TLAbsInputFile file, TLAbsInputFile video, Double videoStartTs, TLAbsVideoSize videoEmojiMarkup) throws RpcErrorException, IOException {
        return (TLPhoto) executeRpcQuery(new TLRequestPhotosUploadProfilePhoto(fallback, bot, file, video, videoStartTs, videoEmojiMarkup));
    }

    @Override
    public TLMyBoosts premiumApplyBoost(TLIntVector slots, TLAbsInputPeer peer) throws RpcErrorException, IOException {
        return (TLMyBoosts) executeRpcQuery(new TLRequestPremiumApplyBoost(slots, peer));
    }

    @Override
    public TLBoostsList premiumGetBoostsList(boolean gifts, TLAbsInputPeer peer, String offset, int limit) throws RpcErrorException, IOException {
        return (TLBoostsList) executeRpcQuery(new TLRequestPremiumGetBoostsList(gifts, peer, offset, limit));
    }

    @Override
    public TLBoostsStatus premiumGetBoostsStatus(TLAbsInputPeer peer) throws RpcErrorException, IOException {
        return (TLBoostsStatus) executeRpcQuery(new TLRequestPremiumGetBoostsStatus(peer));
    }

    @Override
    public TLMyBoosts premiumGetMyBoosts() throws RpcErrorException, IOException {
        return (TLMyBoosts) executeRpcQuery(new TLRequestPremiumGetMyBoosts());
    }

    @Override
    public TLBoostsList premiumGetUserBoosts(TLAbsInputPeer peer, TLAbsInputUser userId) throws RpcErrorException, IOException {
        return (TLBoostsList) executeRpcQuery(new TLRequestPremiumGetUserBoosts(peer, userId));
    }

    @Override
    public TLBool smsjobsFinishJob(String jobId, String error) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestSmsjobsFinishJob(jobId, error));
    }

    @Override
    public TLSmsJob smsjobsGetSmsJob(String jobId) throws RpcErrorException, IOException {
        return (TLSmsJob) executeRpcQuery(new TLRequestSmsjobsGetSmsJob(jobId));
    }

    @Override
    public TLStatus smsjobsGetStatus() throws RpcErrorException, IOException {
        return (TLStatus) executeRpcQuery(new TLRequestSmsjobsGetStatus());
    }

    @Override
    public TLEligibleToJoin smsjobsIsEligibleToJoin() throws RpcErrorException, IOException {
        return (TLEligibleToJoin) executeRpcQuery(new TLRequestSmsjobsIsEligibleToJoin());
    }

    @Override
    public TLBool smsjobsJoin() throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestSmsjobsJoin());
    }

    @Override
    public TLBool smsjobsLeave() throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestSmsjobsLeave());
    }

    @Override
    public TLBool smsjobsUpdateSettings(boolean allowInternational) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestSmsjobsUpdateSettings(allowInternational));
    }

    @Override
    public TLBroadcastRevenueStats statsGetBroadcastRevenueStats(boolean dark, TLAbsInputPeer peer) throws RpcErrorException, IOException {
        return (TLBroadcastRevenueStats) executeRpcQuery(new TLRequestStatsGetBroadcastRevenueStats(dark, peer));
    }

    @Override
    public TLBroadcastRevenueTransactions statsGetBroadcastRevenueTransactions(TLAbsInputPeer peer, int offset, int limit) throws RpcErrorException, IOException {
        return (TLBroadcastRevenueTransactions) executeRpcQuery(new TLRequestStatsGetBroadcastRevenueTransactions(peer, offset, limit));
    }

    @Override
    public TLBroadcastRevenueWithdrawalUrl statsGetBroadcastRevenueWithdrawalUrl(TLAbsInputPeer peer, TLAbsInputCheckPasswordSRP password) throws RpcErrorException, IOException {
        return (TLBroadcastRevenueWithdrawalUrl) executeRpcQuery(new TLRequestStatsGetBroadcastRevenueWithdrawalUrl(peer, password));
    }

    @Override
    public TLBroadcastStats statsGetBroadcastStats(boolean dark, TLAbsInputChannel channel) throws RpcErrorException, IOException {
        return (TLBroadcastStats) executeRpcQuery(new TLRequestStatsGetBroadcastStats(dark, channel));
    }

    @Override
    public TLMegagroupStats statsGetMegagroupStats(boolean dark, TLAbsInputChannel channel) throws RpcErrorException, IOException {
        return (TLMegagroupStats) executeRpcQuery(new TLRequestStatsGetMegagroupStats(dark, channel));
    }

    @Override
    public TLPublicForwards statsGetMessagePublicForwards(TLAbsInputChannel channel, int msgId, String offset, int limit) throws RpcErrorException, IOException {
        return (TLPublicForwards) executeRpcQuery(new TLRequestStatsGetMessagePublicForwards(channel, msgId, offset, limit));
    }

    @Override
    public TLMessageStats statsGetMessageStats(boolean dark, TLAbsInputChannel channel, int msgId) throws RpcErrorException, IOException {
        return (TLMessageStats) executeRpcQuery(new TLRequestStatsGetMessageStats(dark, channel, msgId));
    }

    @Override
    public TLPublicForwards statsGetStoryPublicForwards(TLAbsInputPeer peer, int id, String offset, int limit) throws RpcErrorException, IOException {
        return (TLPublicForwards) executeRpcQuery(new TLRequestStatsGetStoryPublicForwards(peer, id, offset, limit));
    }

    @Override
    public TLStoryStats statsGetStoryStats(boolean dark, TLAbsInputPeer peer, int id) throws RpcErrorException, IOException {
        return (TLStoryStats) executeRpcQuery(new TLRequestStatsGetStoryStats(dark, peer, id));
    }

    @Override
    public TLAbsStatsGraph statsLoadAsyncGraph(String token, Long x) throws RpcErrorException, IOException {
        return (TLAbsStatsGraph) executeRpcQuery(new TLRequestStatsLoadAsyncGraph(token, x));
    }

    @Override
    public TLAbsStickerSet stickersAddStickerToSet(TLAbsInputStickerSet stickerset, TLInputStickerSetItem sticker) throws RpcErrorException, IOException {
        return (TLAbsStickerSet) executeRpcQuery(new TLRequestStickersAddStickerToSet(stickerset, sticker));
    }

    @Override
    public TLAbsStickerSet stickersChangeSticker(TLAbsInputDocument sticker, String emoji, TLMaskCoords maskCoords, String keywords) throws RpcErrorException, IOException {
        return (TLAbsStickerSet) executeRpcQuery(new TLRequestStickersChangeSticker(sticker, emoji, maskCoords, keywords));
    }

    @Override
    public TLAbsStickerSet stickersChangeStickerPosition(TLAbsInputDocument sticker, int position) throws RpcErrorException, IOException {
        return (TLAbsStickerSet) executeRpcQuery(new TLRequestStickersChangeStickerPosition(sticker, position));
    }

    @Override
    public TLBool stickersCheckShortName(String shortName) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestStickersCheckShortName(shortName));
    }

    @Override
    public TLAbsStickerSet stickersCreateStickerSet(boolean masks, boolean emojis, boolean textColor, TLAbsInputUser userId, String title, String shortName, TLAbsInputDocument thumb, TLVector<TLInputStickerSetItem> stickers, String software) throws RpcErrorException, IOException {
        return (TLAbsStickerSet) executeRpcQuery(new TLRequestStickersCreateStickerSet(masks, emojis, textColor, userId, title, shortName, thumb, stickers, software));
    }

    @Override
    public TLBool stickersDeleteStickerSet(TLAbsInputStickerSet stickerset) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestStickersDeleteStickerSet(stickerset));
    }

    @Override
    public TLAbsStickerSet stickersRemoveStickerFromSet(TLAbsInputDocument sticker) throws RpcErrorException, IOException {
        return (TLAbsStickerSet) executeRpcQuery(new TLRequestStickersRemoveStickerFromSet(sticker));
    }

    @Override
    public TLAbsStickerSet stickersRenameStickerSet(TLAbsInputStickerSet stickerset, String title) throws RpcErrorException, IOException {
        return (TLAbsStickerSet) executeRpcQuery(new TLRequestStickersRenameStickerSet(stickerset, title));
    }

    @Override
    public TLAbsStickerSet stickersReplaceSticker(TLAbsInputDocument sticker, TLInputStickerSetItem newSticker) throws RpcErrorException, IOException {
        return (TLAbsStickerSet) executeRpcQuery(new TLRequestStickersReplaceSticker(sticker, newSticker));
    }

    @Override
    public TLAbsStickerSet stickersSetStickerSetThumb(TLAbsInputStickerSet stickerset, TLAbsInputDocument thumb, Long thumbDocumentId) throws RpcErrorException, IOException {
        return (TLAbsStickerSet) executeRpcQuery(new TLRequestStickersSetStickerSetThumb(stickerset, thumb, thumbDocumentId));
    }

    @Override
    public TLSuggestedShortName stickersSuggestShortName(String title) throws RpcErrorException, IOException {
        return (TLSuggestedShortName) executeRpcQuery(new TLRequestStickersSuggestShortName(title));
    }

    @Override
    public TLAbsUpdates storiesActivateStealthMode(boolean past, boolean future) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestStoriesActivateStealthMode(past, future));
    }

    @Override
    public TLBool storiesCanSendStory(TLAbsInputPeer peer) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestStoriesCanSendStory(peer));
    }

    @Override
    public TLIntVector storiesDeleteStories(TLAbsInputPeer peer, TLIntVector id) throws RpcErrorException, IOException {
        return (TLIntVector) executeRpcQuery(new TLRequestStoriesDeleteStories(peer, id));
    }

    @Override
    public TLAbsUpdates storiesEditStory(TLAbsInputPeer peer, int id, TLAbsInputMedia media, TLVector<TLAbsMediaArea> mediaAreas, String caption, TLVector<TLAbsMessageEntity> entities, TLVector<TLAbsInputPrivacyRule> privacyRules) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestStoriesEditStory(peer, id, media, mediaAreas, caption, entities, privacyRules));
    }

    @Override
    public TLExportedStoryLink storiesExportStoryLink(TLAbsInputPeer peer, int id) throws RpcErrorException, IOException {
        return (TLExportedStoryLink) executeRpcQuery(new TLRequestStoriesExportStoryLink(peer, id));
    }

    @Override
    public TLAbsUpdates storiesGetAllReadPeerStories() throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestStoriesGetAllReadPeerStories());
    }

    @Override
    public TLAbsAllStories storiesGetAllStories(boolean next, boolean hidden, String state) throws RpcErrorException, IOException {
        return (TLAbsAllStories) executeRpcQuery(new TLRequestStoriesGetAllStories(next, hidden, state));
    }

    @Override
    public TLAbsChats storiesGetChatsToSend() throws RpcErrorException, IOException {
        return (TLAbsChats) executeRpcQuery(new TLRequestStoriesGetChatsToSend());
    }

    @Override
    public TLIntVector storiesGetPeerMaxIDs(TLVector<TLAbsInputPeer> id) throws RpcErrorException, IOException {
        return (TLIntVector) executeRpcQuery(new TLRequestStoriesGetPeerMaxIDs(id));
    }

    @Override
    public TLPeerStories storiesGetPeerStories(TLAbsInputPeer peer) throws RpcErrorException, IOException {
        return (TLPeerStories) executeRpcQuery(new TLRequestStoriesGetPeerStories(peer));
    }

    @Override
    public TLStories storiesGetPinnedStories(TLAbsInputPeer peer, int offsetId, int limit) throws RpcErrorException, IOException {
        return (TLStories) executeRpcQuery(new TLRequestStoriesGetPinnedStories(peer, offsetId, limit));
    }

    @Override
    public TLStories storiesGetStoriesArchive(TLAbsInputPeer peer, int offsetId, int limit) throws RpcErrorException, IOException {
        return (TLStories) executeRpcQuery(new TLRequestStoriesGetStoriesArchive(peer, offsetId, limit));
    }

    @Override
    public TLStories storiesGetStoriesByID(TLAbsInputPeer peer, TLIntVector id) throws RpcErrorException, IOException {
        return (TLStories) executeRpcQuery(new TLRequestStoriesGetStoriesByID(peer, id));
    }

    @Override
    public TLStoryViews storiesGetStoriesViews(TLAbsInputPeer peer, TLIntVector id) throws RpcErrorException, IOException {
        return (TLStoryViews) executeRpcQuery(new TLRequestStoriesGetStoriesViews(peer, id));
    }

    @Override
    public TLStoryReactionsList storiesGetStoryReactionsList(boolean forwardsFirst, TLAbsInputPeer peer, int id, TLAbsReaction reaction, String offset, int limit) throws RpcErrorException, IOException {
        return (TLStoryReactionsList) executeRpcQuery(new TLRequestStoriesGetStoryReactionsList(forwardsFirst, peer, id, reaction, offset, limit));
    }

    @Override
    public TLStoryViewsList storiesGetStoryViewsList(boolean justContacts, boolean reactionsFirst, boolean forwardsFirst, TLAbsInputPeer peer, String q, int id, String offset, int limit) throws RpcErrorException, IOException {
        return (TLStoryViewsList) executeRpcQuery(new TLRequestStoriesGetStoryViewsList(justContacts, reactionsFirst, forwardsFirst, peer, q, id, offset, limit));
    }

    @Override
    public TLBool storiesIncrementStoryViews(TLAbsInputPeer peer, TLIntVector id) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestStoriesIncrementStoryViews(peer, id));
    }

    @Override
    public TLIntVector storiesReadStories(TLAbsInputPeer peer, int maxId) throws RpcErrorException, IOException {
        return (TLIntVector) executeRpcQuery(new TLRequestStoriesReadStories(peer, maxId));
    }

    @Override
    public TLAbsReportResult storiesReport(TLAbsInputPeer peer, TLIntVector id, TLBytes option, String message) throws RpcErrorException, IOException {
        return (TLAbsReportResult) executeRpcQuery(new TLRequestStoriesReport(peer, id, option, message));
    }

    @Override
    public TLFoundStories storiesSearchPosts(String hashtag, TLAbsMediaArea area, TLAbsInputPeer peer, String offset, int limit) throws RpcErrorException, IOException {
        return (TLFoundStories) executeRpcQuery(new TLRequestStoriesSearchPosts(hashtag, area, peer, offset, limit));
    }

    @Override
    public TLAbsUpdates storiesSendReaction(boolean addToRecent, TLAbsInputPeer peer, int storyId, TLAbsReaction reaction) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestStoriesSendReaction(addToRecent, peer, storyId, reaction));
    }

    @Override
    public TLAbsUpdates storiesSendStory(boolean pinned, boolean noforwards, boolean fwdModified, TLAbsInputPeer peer, TLAbsInputMedia media, TLVector<TLAbsMediaArea> mediaAreas, String caption, TLVector<TLAbsMessageEntity> entities, TLVector<TLAbsInputPrivacyRule> privacyRules, long randomId, Integer period, TLAbsInputPeer fwdFromId, Integer fwdFromStory) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestStoriesSendStory(pinned, noforwards, fwdModified, peer, media, mediaAreas, caption, entities, privacyRules, randomId, period, fwdFromId, fwdFromStory));
    }

    @Override
    public TLBool storiesToggleAllStoriesHidden(boolean hidden) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestStoriesToggleAllStoriesHidden(hidden));
    }

    @Override
    public TLBool storiesTogglePeerStoriesHidden(TLAbsInputPeer peer, boolean hidden) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestStoriesTogglePeerStoriesHidden(peer, hidden));
    }

    @Override
    public TLIntVector storiesTogglePinned(TLAbsInputPeer peer, TLIntVector id, boolean pinned) throws RpcErrorException, IOException {
        return (TLIntVector) executeRpcQuery(new TLRequestStoriesTogglePinned(peer, id, pinned));
    }

    @Override
    public TLBool storiesTogglePinnedToTop(TLAbsInputPeer peer, TLIntVector id) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestStoriesTogglePinnedToTop(peer, id));
    }

    @Override
    public TLAbsChannelDifference updatesGetChannelDifference(boolean force, TLAbsInputChannel channel, TLAbsChannelMessagesFilter filter, int pts, int limit) throws RpcErrorException, IOException {
        return (TLAbsChannelDifference) executeRpcQuery(new TLRequestUpdatesGetChannelDifference(force, channel, filter, pts, limit));
    }

    @Override
    public TLAbsDifference updatesGetDifference(int pts, Integer ptsLimit, Integer ptsTotalLimit, int date, int qts, Integer qtsLimit) throws RpcErrorException, IOException {
        return (TLAbsDifference) executeRpcQuery(new TLRequestUpdatesGetDifference(pts, ptsLimit, ptsTotalLimit, date, qts, qtsLimit));
    }

    @Override
    public TLState updatesGetState() throws RpcErrorException, IOException {
        return (TLState) executeRpcQuery(new TLRequestUpdatesGetState());
    }

    @Override
    public TLAbsCdnFile uploadGetCdnFile(TLBytes fileToken, long offset, int limit) throws RpcErrorException, IOException {
        return (TLAbsCdnFile) executeRpcQuery(new TLRequestUploadGetCdnFile(fileToken, offset, limit));
    }

    @Override
    public TLVector<TLFileHash> uploadGetCdnFileHashes(TLBytes fileToken, long offset) throws RpcErrorException, IOException {
        return (TLVector<TLFileHash>) executeRpcQuery(new TLRequestUploadGetCdnFileHashes(fileToken, offset));
    }

    @Override
    public TLAbsFile uploadGetFile(boolean precise, boolean cdnSupported, TLAbsInputFileLocation location, long offset, int limit) throws RpcErrorException, IOException {
        return (TLAbsFile) executeRpcQuery(new TLRequestUploadGetFile(precise, cdnSupported, location, offset, limit));
    }

    @Override
    public TLVector<TLFileHash> uploadGetFileHashes(TLAbsInputFileLocation location, long offset) throws RpcErrorException, IOException {
        return (TLVector<TLFileHash>) executeRpcQuery(new TLRequestUploadGetFileHashes(location, offset));
    }

    @Override
    public TLWebFile uploadGetWebFile(TLAbsInputWebFileLocation location, int offset, int limit) throws RpcErrorException, IOException {
        return (TLWebFile) executeRpcQuery(new TLRequestUploadGetWebFile(location, offset, limit));
    }

    @Override
    public TLVector<TLFileHash> uploadReuploadCdnFile(TLBytes fileToken, TLBytes requestToken) throws RpcErrorException, IOException {
        return (TLVector<TLFileHash>) executeRpcQuery(new TLRequestUploadReuploadCdnFile(fileToken, requestToken));
    }

    @Override
    public TLBool uploadSaveBigFilePart(long fileId, int filePart, int fileTotalParts, TLBytes bytes) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestUploadSaveBigFilePart(fileId, filePart, fileTotalParts, bytes));
    }

    @Override
    public TLBool uploadSaveFilePart(long fileId, int filePart, TLBytes bytes) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestUploadSaveFilePart(fileId, filePart, bytes));
    }

    @Override
    public TLUserFull usersGetFullUser(TLAbsInputUser id) throws RpcErrorException, IOException {
        return (TLUserFull) executeRpcQuery(new TLRequestUsersGetFullUser(id));
    }

    @Override
    public TLVector<TLBool> usersGetIsPremiumRequiredToContact(TLVector<TLAbsInputUser> id) throws RpcErrorException, IOException {
        return (TLVector<TLBool>) executeRpcQuery(new TLRequestUsersGetIsPremiumRequiredToContact(id));
    }

    @Override
    public TLVector<TLAbsUser> usersGetUsers(TLVector<TLAbsInputUser> id) throws RpcErrorException, IOException {
        return (TLVector<TLAbsUser>) executeRpcQuery(new TLRequestUsersGetUsers(id));
    }

    @Override
    public TLBool usersSetSecureValueErrors(TLAbsInputUser id, TLVector<TLAbsSecureValueError> errors) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestUsersSetSecureValueErrors(id, errors));
    }
}
