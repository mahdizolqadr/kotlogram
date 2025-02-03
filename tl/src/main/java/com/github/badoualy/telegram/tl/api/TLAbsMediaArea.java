package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputMediaAreaChannelPost}: inputMediaAreaChannelPost#0</li>
 * <li>{@link TLInputMediaAreaVenue}: inputMediaAreaVenue#0</li>
 * <li>{@link TLMediaAreaChannelPost}: mediaAreaChannelPost#0</li>
 * <li>{@link TLMediaAreaGeoPoint}: mediaAreaGeoPoint#0</li>
 * <li>{@link TLMediaAreaSuggestedReaction}: mediaAreaSuggestedReaction#0</li>
 * <li>{@link TLMediaAreaUrl}: mediaAreaUrl#0</li>
 * <li>{@link TLMediaAreaVenue}: mediaAreaVenue#0</li>
 * <li>{@link TLMediaAreaWeather}: mediaAreaWeather#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsMediaArea extends TLObject {
    protected TLMediaAreaCoordinates coordinates;

    public TLAbsMediaArea() {
    }

    public TLMediaAreaCoordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(TLMediaAreaCoordinates coordinates) {
        this.coordinates = coordinates;
    }
}
