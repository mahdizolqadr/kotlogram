package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLMessageMediaContact}: messageMediaContact#70322949</li>
 * <li>{@link TLMessageMediaDice}: messageMediaDice#3f7ee58b</li>
 * <li>{@link TLMessageMediaDocument}: messageMediaDocument#9cb070d7</li>
 * <li>{@link TLMessageMediaEmpty}: messageMediaEmpty#3ded6320</li>
 * <li>{@link TLMessageMediaGame}: messageMediaGame#fdb19008</li>
 * <li>{@link TLMessageMediaGeo}: messageMediaGeo#56e0d474</li>
 * <li>{@link TLMessageMediaGeoLive}: messageMediaGeoLive#b940c666</li>
 * <li>{@link TLMessageMediaInvoice}: messageMediaInvoice#84551347</li>
 * <li>{@link TLMessageMediaPhoto}: messageMediaPhoto#695150d7</li>
 * <li>{@link TLMessageMediaPoll}: messageMediaPoll#4bd6e798</li>
 * <li>{@link TLMessageMediaUnsupported}: messageMediaUnsupported#9f84f49e</li>
 * <li>{@link TLMessageMediaVenue}: messageMediaVenue#2ec0533f</li>
 * <li>{@link TLMessageMediaWebPage}: messageMediaWebPage#a32dd600</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsMessageMedia extends TLObject {

    public TLAbsMessageMedia() {
    }
}
