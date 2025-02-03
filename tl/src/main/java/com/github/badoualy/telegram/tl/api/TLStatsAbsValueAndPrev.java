package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLStatsAbsValueAndPrev extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected double current;

    protected double previous;

    private final String _constructor = "statsAbsValueAndPrev#0";

    public TLStatsAbsValueAndPrev() {
    }

    public TLStatsAbsValueAndPrev(double current, double previous) {
        this.current = current;
        this.previous = previous;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeDouble(current, stream);
        writeDouble(previous, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        current = readDouble(stream);
        previous = readDouble(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_DOUBLE;
        size += SIZE_DOUBLE;
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

    public double getCurrent() {
        return current;
    }

    public void setCurrent(double current) {
        this.current = current;
    }

    public double getPrevious() {
        return previous;
    }

    public void setPrevious(double previous) {
        this.previous = previous;
    }
}
