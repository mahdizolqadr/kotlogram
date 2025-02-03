package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLSendMessageCancelAction}: sendMessageCancelAction#0</li>
 * <li>{@link TLSendMessageChooseContactAction}: sendMessageChooseContactAction#0</li>
 * <li>{@link TLSendMessageChooseStickerAction}: sendMessageChooseStickerAction#0</li>
 * <li>{@link TLSendMessageEmojiInteraction}: sendMessageEmojiInteraction#0</li>
 * <li>{@link TLSendMessageEmojiInteractionSeen}: sendMessageEmojiInteractionSeen#0</li>
 * <li>{@link TLSendMessageGamePlayAction}: sendMessageGamePlayAction#0</li>
 * <li>{@link TLSendMessageGeoLocationAction}: sendMessageGeoLocationAction#0</li>
 * <li>{@link TLSendMessageHistoryImportAction}: sendMessageHistoryImportAction#0</li>
 * <li>{@link TLSendMessageRecordAudioAction}: sendMessageRecordAudioAction#0</li>
 * <li>{@link TLSendMessageRecordRoundAction}: sendMessageRecordRoundAction#0</li>
 * <li>{@link TLSendMessageRecordVideoAction}: sendMessageRecordVideoAction#0</li>
 * <li>{@link TLSendMessageTypingAction}: sendMessageTypingAction#0</li>
 * <li>{@link TLSendMessageUploadAudioAction}: sendMessageUploadAudioAction#0</li>
 * <li>{@link TLSendMessageUploadDocumentAction}: sendMessageUploadDocumentAction#0</li>
 * <li>{@link TLSendMessageUploadPhotoAction}: sendMessageUploadPhotoAction#0</li>
 * <li>{@link TLSendMessageUploadRoundAction}: sendMessageUploadRoundAction#0</li>
 * <li>{@link TLSendMessageUploadVideoAction}: sendMessageUploadVideoAction#0</li>
 * <li>{@link TLSpeakingInGroupCallAction}: speakingInGroupCallAction#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsSendMessageAction extends TLObject {
    public TLAbsSendMessageAction() {
    }
}
