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
public class TLChannelAdminLogEventActionChangePhoto extends TLAbsChannelAdminLogEventAction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsPhoto prevPhoto;

    protected TLAbsPhoto newPhoto;

    private final String _constructor = "channelAdminLogEventActionChangePhoto#0";

    public TLChannelAdminLogEventActionChangePhoto() {
    }

    public TLChannelAdminLogEventActionChangePhoto(TLAbsPhoto prevPhoto, TLAbsPhoto newPhoto) {
        this.prevPhoto = prevPhoto;
        this.newPhoto = newPhoto;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(prevPhoto, stream);
        writeTLObject(newPhoto, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        prevPhoto = readTLObject(stream, context, TLAbsPhoto.class, -1);
        newPhoto = readTLObject(stream, context, TLAbsPhoto.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += prevPhoto.computeSerializedSize();
        size += newPhoto.computeSerializedSize();
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

    public TLAbsPhoto getPrevPhoto() {
        return prevPhoto;
    }

    public void setPrevPhoto(TLAbsPhoto prevPhoto) {
        this.prevPhoto = prevPhoto;
    }

    public TLAbsPhoto getNewPhoto() {
        return newPhoto;
    }

    public void setNewPhoto(TLAbsPhoto newPhoto) {
        this.newPhoto = newPhoto;
    }
}
