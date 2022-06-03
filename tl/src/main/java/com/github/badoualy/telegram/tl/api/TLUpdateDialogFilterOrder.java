package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLIntVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLIntVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

public class TLUpdateDialogFilterOrder extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0xa5d72105;

    protected TLIntVector order;

    private final String _constructor = "updateDialogFilterOrder#a5d72105";

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
