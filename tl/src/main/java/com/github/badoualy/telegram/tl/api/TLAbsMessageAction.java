package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLMessageActionBotAllowed}: messageActionBotAllowed#abe9affe</li>
 * <li>{@link TLMessageActionChannelCreate}: messageActionChannelCreate#95d2ac92</li>
 * <li>{@link TLMessageActionChannelMigrateFrom}: messageActionChannelMigrateFrom#ea3948e9</li>
 * <li>{@link TLMessageActionChatAddUser}: messageActionChatAddUser#15cefd00</li>
 * <li>{@link TLMessageActionChatCreate}: messageActionChatCreate#bd47cbad</li>
 * <li>{@link TLMessageActionChatDeletePhoto}: messageActionChatDeletePhoto#95e3fbef</li>
 * <li>{@link TLMessageActionChatDeleteUser}: messageActionChatDeleteUser#a43f30cc</li>
 * <li>{@link TLMessageActionChatEditPhoto}: messageActionChatEditPhoto#7fcb13a8</li>
 * <li>{@link TLMessageActionChatEditTitle}: messageActionChatEditTitle#b5a1ce5a</li>
 * <li>{@link TLMessageActionChatJoinedByLink}: messageActionChatJoinedByLink#31224c3</li>
 * <li>{@link TLMessageActionChatMigrateTo}: messageActionChatMigrateTo#e1037f92</li>
 * <li>{@link TLMessageActionContactSignUp}: messageActionContactSignUp#f3f25f76</li>
 * <li>{@link TLMessageActionCustomAction}: messageActionCustomAction#fae69f56</li>
 * <li>{@link TLMessageActionEmpty}: messageActionEmpty#b6aef7b0</li>
 * <li>{@link TLMessageActionGameScore}: messageActionGameScore#92a72876</li>
 * <li>{@link TLMessageActionGeoProximityReached}: messageActionGeoProximityReached#98e0d697</li>
 * <li>{@link TLMessageActionGroupCall}: messageActionGroupCall#7a0d7f42</li>
 * <li>{@link TLMessageActionGroupCallScheduled}: messageActionGroupCallScheduled#b3a07661</li>
 * <li>{@link TLMessageActionHistoryClear}: messageActionHistoryClear#9fbab604</li>
 * <li>{@link TLMessageActionInviteToGroupCall}: messageActionInviteToGroupCall#502f92f7</li>
 * <li>{@link TLMessageActionPaymentSent}: messageActionPaymentSent#40699cd0</li>
 * <li>{@link TLMessageActionPaymentSentMe}: messageActionPaymentSentMe#8f31b327</li>
 * <li>{@link TLMessageActionPhoneCall}: messageActionPhoneCall#80e11a7f</li>
 * <li>{@link TLMessageActionPinMessage}: messageActionPinMessage#94bd38ed</li>
 * <li>{@link TLMessageActionScreenshotTaken}: messageActionScreenshotTaken#4792929b</li>
 * <li>{@link TLMessageActionSecureValuesSent}: messageActionSecureValuesSent#d95c6154</li>
 * <li>{@link TLMessageActionSecureValuesSentMe}: messageActionSecureValuesSentMe#1b287353</li>
 * <li>{@link TLMessageActionSetChatTheme}: messageActionSetChatTheme#aa786345</li>
 * <li>{@link TLMessageActionSetMessagesTTL}: messageActionSetMessagesTTL#aa1afbfd</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsMessageAction extends TLObject {

    protected TLAbsMessageAction() {
    }
}
