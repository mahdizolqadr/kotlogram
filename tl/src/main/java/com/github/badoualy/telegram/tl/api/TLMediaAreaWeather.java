package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMediaAreaWeather extends TLAbsMediaArea {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected String emoji;

    protected double temperatureC;

    protected int color;

    private final String _constructor = "mediaAreaWeather#0";

    public TLMediaAreaWeather() {
    }

    public TLMediaAreaWeather(TLMediaAreaCoordinates coordinates, String emoji, double temperatureC, int color) {
        this.coordinates = coordinates;
        this.emoji = emoji;
        this.temperatureC = temperatureC;
        this.color = color;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(coordinates, stream);
        writeString(emoji, stream);
        writeDouble(temperatureC, stream);
        writeInt(color, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        coordinates = readTLObject(stream, context, TLMediaAreaCoordinates.class, TLMediaAreaCoordinates.CONSTRUCTOR_ID);
        emoji = readTLString(stream);
        temperatureC = readDouble(stream);
        color = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += coordinates.computeSerializedSize();
        size += computeTLStringSerializedSize(emoji);
        size += SIZE_DOUBLE;
        size += SIZE_INT32;
        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public TLMediaAreaCoordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(TLMediaAreaCoordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    public double getTemperatureC() {
        return temperatureC;
    }

    public void setTemperatureC(double temperatureC) {
        this.temperatureC = temperatureC;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
