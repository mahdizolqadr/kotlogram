package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMessageActionStarGift extends TLAbsMessageAction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean nameHidden;

    protected boolean saved;

    protected boolean converted;

    protected TLStarGift gift;

    protected TLTextWithEntities message;

    protected Long convertStars;

    private final String _constructor = "messageActionStarGift#0";

    public TLMessageActionStarGift() {
    }

    public TLMessageActionStarGift(boolean nameHidden, boolean saved, boolean converted, TLStarGift gift, TLTextWithEntities message, Long convertStars) {
        this.nameHidden = nameHidden;
        this.saved = saved;
        this.converted = converted;
        this.gift = gift;
        this.message = message;
        this.convertStars = convertStars;
    }

    private void computeFlags() {
        flags = 0;
        flags = nameHidden ? (flags | 1) : (flags & ~1);
        flags = saved ? (flags | 4) : (flags & ~4);
        flags = converted ? (flags | 8) : (flags & ~8);
        flags = message != null ? (flags | 2) : (flags & ~2);
        flags = convertStars != null ? (flags | 16) : (flags & ~16);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(gift, stream);
        if ((flags & 2) != 0) {
            if (message == null) throwNullFieldException("message", flags);
            writeTLObject(message, stream);
        }
        if ((flags & 16) != 0) {
            if (convertStars == null) throwNullFieldException("convertStars", flags);
            writeLong(convertStars, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        nameHidden = (flags & 1) != 0;
        saved = (flags & 4) != 0;
        converted = (flags & 8) != 0;
        gift = readTLObject(stream, context, TLStarGift.class, TLStarGift.CONSTRUCTOR_ID);
        message = (flags & 2) != 0 ? readTLObject(stream, context, TLTextWithEntities.class, TLTextWithEntities.CONSTRUCTOR_ID) : null;
        convertStars = (flags & 16) != 0 ? readLong(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += gift.computeSerializedSize();
        if ((flags & 2) != 0) {
            if (message == null) throwNullFieldException("message", flags);
            size += message.computeSerializedSize();
        }
        if ((flags & 16) != 0) {
            if (convertStars == null) throwNullFieldException("convertStars", flags);
            size += SIZE_INT64;
        }
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

    public boolean getNameHidden() {
        return nameHidden;
    }

    public void setNameHidden(boolean nameHidden) {
        this.nameHidden = nameHidden;
    }

    public boolean getSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public boolean getConverted() {
        return converted;
    }

    public void setConverted(boolean converted) {
        this.converted = converted;
    }

    public TLStarGift getGift() {
        return gift;
    }

    public void setGift(TLStarGift gift) {
        this.gift = gift;
    }

    public TLTextWithEntities getMessage() {
        return message;
    }

    public void setMessage(TLTextWithEntities message) {
        this.message = message;
    }

    public Long getConvertStars() {
        return convertStars;
    }

    public void setConvertStars(Long convertStars) {
        this.convertStars = convertStars;
    }
}
