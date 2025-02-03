package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputMediaContact}: inputMediaContact#0</li>
 * <li>{@link TLInputMediaDice}: inputMediaDice#0</li>
 * <li>{@link TLInputMediaDocument}: inputMediaDocument#0</li>
 * <li>{@link TLInputMediaDocumentExternal}: inputMediaDocumentExternal#0</li>
 * <li>{@link TLInputMediaEmpty}: inputMediaEmpty#0</li>
 * <li>{@link TLInputMediaGame}: inputMediaGame#0</li>
 * <li>{@link TLInputMediaGeoLive}: inputMediaGeoLive#0</li>
 * <li>{@link TLInputMediaGeoPoint}: inputMediaGeoPoint#0</li>
 * <li>{@link TLInputMediaInvoice}: inputMediaInvoice#0</li>
 * <li>{@link TLInputMediaPaidMedia}: inputMediaPaidMedia#0</li>
 * <li>{@link TLInputMediaPhoto}: inputMediaPhoto#0</li>
 * <li>{@link TLInputMediaPhotoExternal}: inputMediaPhotoExternal#0</li>
 * <li>{@link TLInputMediaPoll}: inputMediaPoll#0</li>
 * <li>{@link TLInputMediaStory}: inputMediaStory#0</li>
 * <li>{@link TLInputMediaUploadedDocument}: inputMediaUploadedDocument#0</li>
 * <li>{@link TLInputMediaUploadedPhoto}: inputMediaUploadedPhoto#0</li>
 * <li>{@link TLInputMediaVenue}: inputMediaVenue#0</li>
 * <li>{@link TLInputMediaWebPage}: inputMediaWebPage#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsInputMedia extends TLObject {
    public TLAbsInputMedia() {
    }
}
