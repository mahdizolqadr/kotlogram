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
public class TLStoriesStealthMode extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected Integer activeUntilDate;

    protected Integer cooldownUntilDate;

    private final String _constructor = "storiesStealthMode#0";

    public TLStoriesStealthMode() {
    }

    public TLStoriesStealthMode(Integer activeUntilDate, Integer cooldownUntilDate) {
        this.activeUntilDate = activeUntilDate;
        this.cooldownUntilDate = cooldownUntilDate;
    }

    private void computeFlags() {
        flags = 0;
        flags = activeUntilDate != null ? (flags | 1) : (flags & ~1);
        flags = cooldownUntilDate != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (activeUntilDate == null) throwNullFieldException("activeUntilDate", flags);
            writeInt(activeUntilDate, stream);
        }
        if ((flags & 2) != 0) {
            if (cooldownUntilDate == null) throwNullFieldException("cooldownUntilDate", flags);
            writeInt(cooldownUntilDate, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        activeUntilDate = (flags & 1) != 0 ? readInt(stream) : null;
        cooldownUntilDate = (flags & 2) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (activeUntilDate == null) throwNullFieldException("activeUntilDate", flags);
            size += SIZE_INT32;
        }
        if ((flags & 2) != 0) {
            if (cooldownUntilDate == null) throwNullFieldException("cooldownUntilDate", flags);
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

    public Integer getActiveUntilDate() {
        return activeUntilDate;
    }

    public void setActiveUntilDate(Integer activeUntilDate) {
        this.activeUntilDate = activeUntilDate;
    }

    public Integer getCooldownUntilDate() {
        return cooldownUntilDate;
    }

    public void setCooldownUntilDate(Integer cooldownUntilDate) {
        this.cooldownUntilDate = cooldownUntilDate;
    }
}
