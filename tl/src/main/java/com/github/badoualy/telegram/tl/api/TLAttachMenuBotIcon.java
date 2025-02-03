package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
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
public class TLAttachMenuBotIcon extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected String name;

    protected TLAbsDocument icon;

    protected TLVector<TLAttachMenuBotIconColor> colors;

    private final String _constructor = "attachMenuBotIcon#0";

    public TLAttachMenuBotIcon() {
    }

    public TLAttachMenuBotIcon(String name, TLAbsDocument icon, TLVector<TLAttachMenuBotIconColor> colors) {
        this.name = name;
        this.icon = icon;
        this.colors = colors;
    }

    private void computeFlags() {
        flags = 0;
        flags = colors != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(name, stream);
        writeTLObject(icon, stream);
        if ((flags & 1) != 0) {
            if (colors == null) throwNullFieldException("colors", flags);
            writeTLVector(colors, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        name = readTLString(stream);
        icon = readTLObject(stream, context, TLAbsDocument.class, -1);
        colors = (flags & 1) != 0 ? readTLVector(stream, context) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(name);
        size += icon.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (colors == null) throwNullFieldException("colors", flags);
            size += colors.computeSerializedSize();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TLAbsDocument getIcon() {
        return icon;
    }

    public void setIcon(TLAbsDocument icon) {
        this.icon = icon;
    }

    public TLVector<TLAttachMenuBotIconColor> getColors() {
        return colors;
    }

    public void setColors(TLVector<TLAttachMenuBotIconColor> colors) {
        this.colors = colors;
    }
}
