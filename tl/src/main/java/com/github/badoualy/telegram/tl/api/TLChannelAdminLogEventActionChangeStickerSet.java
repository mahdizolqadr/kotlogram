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
public class TLChannelAdminLogEventActionChangeStickerSet extends TLAbsChannelAdminLogEventAction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsInputStickerSet prevStickerset;

    protected TLAbsInputStickerSet newStickerset;

    private final String _constructor = "channelAdminLogEventActionChangeStickerSet#0";

    public TLChannelAdminLogEventActionChangeStickerSet() {
    }

    public TLChannelAdminLogEventActionChangeStickerSet(TLAbsInputStickerSet prevStickerset, TLAbsInputStickerSet newStickerset) {
        this.prevStickerset = prevStickerset;
        this.newStickerset = newStickerset;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(prevStickerset, stream);
        writeTLObject(newStickerset, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        prevStickerset = readTLObject(stream, context, TLAbsInputStickerSet.class, -1);
        newStickerset = readTLObject(stream, context, TLAbsInputStickerSet.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += prevStickerset.computeSerializedSize();
        size += newStickerset.computeSerializedSize();
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

    public TLAbsInputStickerSet getPrevStickerset() {
        return prevStickerset;
    }

    public void setPrevStickerset(TLAbsInputStickerSet prevStickerset) {
        this.prevStickerset = prevStickerset;
    }

    public TLAbsInputStickerSet getNewStickerset() {
        return newStickerset;
    }

    public void setNewStickerset(TLAbsInputStickerSet newStickerset) {
        this.newStickerset = newStickerset;
    }
}
