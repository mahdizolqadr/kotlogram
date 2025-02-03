package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLAvailableEffect extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean premiumRequired;

    protected long id;

    protected String emoticon;

    protected Long staticIconId;

    protected long effectStickerId;

    protected Long effectAnimationId;

    private final String _constructor = "availableEffect#0";

    public TLAvailableEffect() {
    }

    public TLAvailableEffect(boolean premiumRequired, long id, String emoticon, Long staticIconId, long effectStickerId, Long effectAnimationId) {
        this.premiumRequired = premiumRequired;
        this.id = id;
        this.emoticon = emoticon;
        this.staticIconId = staticIconId;
        this.effectStickerId = effectStickerId;
        this.effectAnimationId = effectAnimationId;
    }

    private void computeFlags() {
        flags = 0;
        flags = premiumRequired ? (flags | 4) : (flags & ~4);
        flags = staticIconId != null ? (flags | 1) : (flags & ~1);
        flags = effectAnimationId != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(id, stream);
        writeString(emoticon, stream);
        if ((flags & 1) != 0) {
            if (staticIconId == null) throwNullFieldException("staticIconId", flags);
            writeLong(staticIconId, stream);
        }
        writeLong(effectStickerId, stream);
        if ((flags & 2) != 0) {
            if (effectAnimationId == null) throwNullFieldException("effectAnimationId", flags);
            writeLong(effectAnimationId, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        premiumRequired = (flags & 4) != 0;
        id = readLong(stream);
        emoticon = readTLString(stream);
        staticIconId = (flags & 1) != 0 ? readLong(stream) : null;
        effectStickerId = readLong(stream);
        effectAnimationId = (flags & 2) != 0 ? readLong(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(emoticon);
        if ((flags & 1) != 0) {
            if (staticIconId == null) throwNullFieldException("staticIconId", flags);
            size += SIZE_INT64;
        }
        size += SIZE_INT64;
        if ((flags & 2) != 0) {
            if (effectAnimationId == null) throwNullFieldException("effectAnimationId", flags);
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

    public boolean getPremiumRequired() {
        return premiumRequired;
    }

    public void setPremiumRequired(boolean premiumRequired) {
        this.premiumRequired = premiumRequired;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmoticon() {
        return emoticon;
    }

    public void setEmoticon(String emoticon) {
        this.emoticon = emoticon;
    }

    public Long getStaticIconId() {
        return staticIconId;
    }

    public void setStaticIconId(Long staticIconId) {
        this.staticIconId = staticIconId;
    }

    public long getEffectStickerId() {
        return effectStickerId;
    }

    public void setEffectStickerId(long effectStickerId) {
        this.effectStickerId = effectStickerId;
    }

    public Long getEffectAnimationId() {
        return effectAnimationId;
    }

    public void setEffectAnimationId(Long effectAnimationId) {
        this.effectAnimationId = effectAnimationId;
    }
}
