package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLMessageMediaContact}: messageMediaContact#0</li>
 * <li>{@link TLMessageMediaDice}: messageMediaDice#0</li>
 * <li>{@link TLMessageMediaDocument}: messageMediaDocument#0</li>
 * <li>{@link TLMessageMediaEmpty}: messageMediaEmpty#0</li>
 * <li>{@link TLMessageMediaGame}: messageMediaGame#0</li>
 * <li>{@link TLMessageMediaGeo}: messageMediaGeo#0</li>
 * <li>{@link TLMessageMediaGeoLive}: messageMediaGeoLive#0</li>
 * <li>{@link TLMessageMediaGiveaway}: messageMediaGiveaway#0</li>
 * <li>{@link TLMessageMediaGiveawayResults}: messageMediaGiveawayResults#0</li>
 * <li>{@link TLMessageMediaInvoice}: messageMediaInvoice#0</li>
 * <li>{@link TLMessageMediaPaidMedia}: messageMediaPaidMedia#0</li>
 * <li>{@link TLMessageMediaPhoto}: messageMediaPhoto#0</li>
 * <li>{@link TLMessageMediaPoll}: messageMediaPoll#0</li>
 * <li>{@link TLMessageMediaStory}: messageMediaStory#0</li>
 * <li>{@link TLMessageMediaUnsupported}: messageMediaUnsupported#0</li>
 * <li>{@link TLMessageMediaVenue}: messageMediaVenue#0</li>
 * <li>{@link TLMessageMediaWebPage}: messageMediaWebPage#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsMessageMedia extends TLObject {
    public TLAbsMessageMedia() {
    }
}
