package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputReportReasonChildAbuse}: inputReportReasonChildAbuse#0</li>
 * <li>{@link TLInputReportReasonCopyright}: inputReportReasonCopyright#0</li>
 * <li>{@link TLInputReportReasonFake}: inputReportReasonFake#0</li>
 * <li>{@link TLInputReportReasonGeoIrrelevant}: inputReportReasonGeoIrrelevant#0</li>
 * <li>{@link TLInputReportReasonIllegalDrugs}: inputReportReasonIllegalDrugs#0</li>
 * <li>{@link TLInputReportReasonOther}: inputReportReasonOther#0</li>
 * <li>{@link TLInputReportReasonPersonalDetails}: inputReportReasonPersonalDetails#0</li>
 * <li>{@link TLInputReportReasonPornography}: inputReportReasonPornography#0</li>
 * <li>{@link TLInputReportReasonSpam}: inputReportReasonSpam#0</li>
 * <li>{@link TLInputReportReasonViolence}: inputReportReasonViolence#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsReportReason extends TLObject {
    public TLAbsReportReason() {
    }
}
