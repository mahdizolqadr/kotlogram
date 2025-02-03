package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLStarGift extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean limited;

    protected boolean soldOut;

    protected boolean birthday;

    protected long id;

    protected TLAbsDocument sticker;

    protected long stars;

    protected Integer availabilityRemains;

    protected Integer availabilityTotal;

    protected long convertStars;

    protected Integer firstSaleDate;

    protected Integer lastSaleDate;

    private final String _constructor = "starGift#0";

    public TLStarGift() {
    }

    public TLStarGift(boolean limited, boolean soldOut, boolean birthday, long id, TLAbsDocument sticker, long stars, Integer availabilityRemains, Integer availabilityTotal, long convertStars, Integer firstSaleDate, Integer lastSaleDate) {
        this.limited = limited;
        this.soldOut = soldOut;
        this.birthday = birthday;
        this.id = id;
        this.sticker = sticker;
        this.stars = stars;
        this.availabilityRemains = availabilityRemains;
        this.availabilityTotal = availabilityTotal;
        this.convertStars = convertStars;
        this.firstSaleDate = firstSaleDate;
        this.lastSaleDate = lastSaleDate;
    }

    private void computeFlags() {
        flags = 0;
        flags = limited ? (flags | 1) : (flags & ~1);
        flags = soldOut ? (flags | 2) : (flags & ~2);
        flags = birthday ? (flags | 4) : (flags & ~4);
        flags = availabilityRemains != null ? (flags | 1) : (flags & ~1);
        flags = availabilityTotal != null ? (flags | 1) : (flags & ~1);
        flags = firstSaleDate != null ? (flags | 2) : (flags & ~2);
        flags = lastSaleDate != null ? (flags | 2) : (flags & ~2);

        // Following parameters might be forced to true by another field that updated the flags
        limited = (flags & 1) != 0;
        soldOut = (flags & 2) != 0;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(id, stream);
        writeTLObject(sticker, stream);
        writeLong(stars, stream);
        if ((flags & 1) != 0) {
            if (availabilityRemains == null) throwNullFieldException("availabilityRemains", flags);
            writeInt(availabilityRemains, stream);
        }
        if ((flags & 1) != 0) {
            if (availabilityTotal == null) throwNullFieldException("availabilityTotal", flags);
            writeInt(availabilityTotal, stream);
        }
        writeLong(convertStars, stream);
        if ((flags & 2) != 0) {
            if (firstSaleDate == null) throwNullFieldException("firstSaleDate", flags);
            writeInt(firstSaleDate, stream);
        }
        if ((flags & 2) != 0) {
            if (lastSaleDate == null) throwNullFieldException("lastSaleDate", flags);
            writeInt(lastSaleDate, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        limited = (flags & 1) != 0;
        soldOut = (flags & 2) != 0;
        birthday = (flags & 4) != 0;
        id = readLong(stream);
        sticker = readTLObject(stream, context, TLAbsDocument.class, -1);
        stars = readLong(stream);
        availabilityRemains = (flags & 1) != 0 ? readInt(stream) : null;
        availabilityTotal = (flags & 1) != 0 ? readInt(stream) : null;
        convertStars = readLong(stream);
        firstSaleDate = (flags & 2) != 0 ? readInt(stream) : null;
        lastSaleDate = (flags & 2) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += sticker.computeSerializedSize();
        size += SIZE_INT64;
        if ((flags & 1) != 0) {
            if (availabilityRemains == null) throwNullFieldException("availabilityRemains", flags);
            size += SIZE_INT32;
        }
        if ((flags & 1) != 0) {
            if (availabilityTotal == null) throwNullFieldException("availabilityTotal", flags);
            size += SIZE_INT32;
        }
        size += SIZE_INT64;
        if ((flags & 2) != 0) {
            if (firstSaleDate == null) throwNullFieldException("firstSaleDate", flags);
            size += SIZE_INT32;
        }
        if ((flags & 2) != 0) {
            if (lastSaleDate == null) throwNullFieldException("lastSaleDate", flags);
            size += SIZE_INT32;
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

    public boolean getLimited() {
        return limited;
    }

    public void setLimited(boolean limited) {
        this.limited = limited;
    }

    public boolean getSoldOut() {
        return soldOut;
    }

    public void setSoldOut(boolean soldOut) {
        this.soldOut = soldOut;
    }

    public boolean getBirthday() {
        return birthday;
    }

    public void setBirthday(boolean birthday) {
        this.birthday = birthday;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TLAbsDocument getSticker() {
        return sticker;
    }

    public void setSticker(TLAbsDocument sticker) {
        this.sticker = sticker;
    }

    public long getStars() {
        return stars;
    }

    public void setStars(long stars) {
        this.stars = stars;
    }

    public Integer getAvailabilityRemains() {
        return availabilityRemains;
    }

    public void setAvailabilityRemains(Integer availabilityRemains) {
        this.availabilityRemains = availabilityRemains;
    }

    public Integer getAvailabilityTotal() {
        return availabilityTotal;
    }

    public void setAvailabilityTotal(Integer availabilityTotal) {
        this.availabilityTotal = availabilityTotal;
    }

    public long getConvertStars() {
        return convertStars;
    }

    public void setConvertStars(long convertStars) {
        this.convertStars = convertStars;
    }

    public Integer getFirstSaleDate() {
        return firstSaleDate;
    }

    public void setFirstSaleDate(Integer firstSaleDate) {
        this.firstSaleDate = firstSaleDate;
    }

    public Integer getLastSaleDate() {
        return lastSaleDate;
    }

    public void setLastSaleDate(Integer lastSaleDate) {
        this.lastSaleDate = lastSaleDate;
    }
}
