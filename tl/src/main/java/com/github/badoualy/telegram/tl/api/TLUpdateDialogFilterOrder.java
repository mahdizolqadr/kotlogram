package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLIntVector;
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
public class TLUpdateDialogFilterOrder extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLIntVector order;

    private final String _constructor = "updateDialogFilterOrder#0";

    public TLUpdateDialogFilterOrder() {
    }

    public TLUpdateDialogFilterOrder(TLIntVector order) {
        this.order = order;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(order, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        order = readTLIntVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += order.computeSerializedSize();
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

    public TLIntVector getOrder() {
        return order;
    }

    public void setOrder(TLIntVector order) {
        this.order = order;
    }
}
