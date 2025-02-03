package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUserStarGift extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean nameHidden;

    protected boolean unsaved;

    protected Long fromId;

    protected int date;

    protected TLStarGift gift;

    protected TLTextWithEntities message;

    protected Integer msgId;

    protected Long convertStars;

    private final String _constructor = "userStarGift#0";

    public TLUserStarGift() {
    }

    public TLUserStarGift(boolean nameHidden, boolean unsaved, Long fromId, int date, TLStarGift gift, TLTextWithEntities message, Integer msgId, Long convertStars) {
        this.nameHidden = nameHidden;
        this.unsaved = unsaved;
        this.fromId = fromId;
        this.date = date;
        this.gift = gift;
        this.message = message;
        this.msgId = msgId;
        this.convertStars = convertStars;
    }

    private void computeFlags() {
        flags = 0;
        flags = nameHidden ? (flags | 1) : (flags & ~1);
        flags = unsaved ? (flags | 32) : (flags & ~32);
        flags = fromId != null ? (flags | 2) : (flags & ~2);
        flags = message != null ? (flags | 4) : (flags & ~4);
        flags = msgId != null ? (flags | 8) : (flags & ~8);
        flags = convertStars != null ? (flags | 16) : (flags & ~16);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 2) != 0) {
            if (fromId == null) throwNullFieldException("fromId", flags);
            writeLong(fromId, stream);
        }
        writeInt(date, stream);
        writeTLObject(gift, stream);
        if ((flags & 4) != 0) {
            if (message == null) throwNullFieldException("message", flags);
            writeTLObject(message, stream);
        }
        if ((flags & 8) != 0) {
            if (msgId == null) throwNullFieldException("msgId", flags);
            writeInt(msgId, stream);
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
        unsaved = (flags & 32) != 0;
        fromId = (flags & 2) != 0 ? readLong(stream) : null;
        date = readInt(stream);
        gift = readTLObject(stream, context, TLStarGift.class, TLStarGift.CONSTRUCTOR_ID);
        message = (flags & 4) != 0 ? readTLObject(stream, context, TLTextWithEntities.class, TLTextWithEntities.CONSTRUCTOR_ID) : null;
        msgId = (flags & 8) != 0 ? readInt(stream) : null;
        convertStars = (flags & 16) != 0 ? readLong(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 2) != 0) {
            if (fromId == null) throwNullFieldException("fromId", flags);
            size += SIZE_INT64;
        }
        size += SIZE_INT32;
        size += gift.computeSerializedSize();
        if ((flags & 4) != 0) {
            if (message == null) throwNullFieldException("message", flags);
            size += message.computeSerializedSize();
        }
        if ((flags & 8) != 0) {
            if (msgId == null) throwNullFieldException("msgId", flags);
            size += SIZE_INT32;
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

    public boolean getUnsaved() {
        return unsaved;
    }

    public void setUnsaved(boolean unsaved) {
        this.unsaved = unsaved;
    }

    public Long getFromId() {
        return fromId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
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

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public Long getConvertStars() {
        return convertStars;
    }

    public void setConvertStars(Long convertStars) {
        this.convertStars = convertStars;
    }
}
