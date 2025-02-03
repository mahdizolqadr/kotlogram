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
public class TLInputMediaAreaVenue extends TLAbsMediaArea {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected long queryId;

    protected String resultId;

    private final String _constructor = "inputMediaAreaVenue#0";

    public TLInputMediaAreaVenue() {
    }

    public TLInputMediaAreaVenue(TLMediaAreaCoordinates coordinates, long queryId, String resultId) {
        this.coordinates = coordinates;
        this.queryId = queryId;
        this.resultId = resultId;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(coordinates, stream);
        writeLong(queryId, stream);
        writeString(resultId, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        coordinates = readTLObject(stream, context, TLMediaAreaCoordinates.class, TLMediaAreaCoordinates.CONSTRUCTOR_ID);
        queryId = readLong(stream);
        resultId = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += coordinates.computeSerializedSize();
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(resultId);
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

    public long getQueryId() {
        return queryId;
    }

    public void setQueryId(long queryId) {
        this.queryId = queryId;
    }

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }
}
