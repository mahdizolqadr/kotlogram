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
public class TLMediaAreaUrl extends TLAbsMediaArea {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected String url;

    private final String _constructor = "mediaAreaUrl#0";

    public TLMediaAreaUrl() {
    }

    public TLMediaAreaUrl(TLMediaAreaCoordinates coordinates, String url) {
        this.coordinates = coordinates;
        this.url = url;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(coordinates, stream);
        writeString(url, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        coordinates = readTLObject(stream, context, TLMediaAreaCoordinates.class, TLMediaAreaCoordinates.CONSTRUCTOR_ID);
        url = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += coordinates.computeSerializedSize();
        size += computeTLStringSerializedSize(url);
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
