package com.github.badoualy.telegram.tl.api.help;

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
public class TLPeerColorOption extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean hidden;

    protected int colorId;

    protected TLAbsPeerColorSet colors;

    protected TLAbsPeerColorSet darkColors;

    protected Integer channelMinLevel;

    protected Integer groupMinLevel;

    private final String _constructor = "help.peerColorOption#0";

    public TLPeerColorOption() {
    }

    public TLPeerColorOption(boolean hidden, int colorId, TLAbsPeerColorSet colors, TLAbsPeerColorSet darkColors, Integer channelMinLevel, Integer groupMinLevel) {
        this.hidden = hidden;
        this.colorId = colorId;
        this.colors = colors;
        this.darkColors = darkColors;
        this.channelMinLevel = channelMinLevel;
        this.groupMinLevel = groupMinLevel;
    }

    private void computeFlags() {
        flags = 0;
        flags = hidden ? (flags | 1) : (flags & ~1);
        flags = colors != null ? (flags | 2) : (flags & ~2);
        flags = darkColors != null ? (flags | 4) : (flags & ~4);
        flags = channelMinLevel != null ? (flags | 8) : (flags & ~8);
        flags = groupMinLevel != null ? (flags | 16) : (flags & ~16);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(colorId, stream);
        if ((flags & 2) != 0) {
            if (colors == null) throwNullFieldException("colors", flags);
            writeTLObject(colors, stream);
        }
        if ((flags & 4) != 0) {
            if (darkColors == null) throwNullFieldException("darkColors", flags);
            writeTLObject(darkColors, stream);
        }
        if ((flags & 8) != 0) {
            if (channelMinLevel == null) throwNullFieldException("channelMinLevel", flags);
            writeInt(channelMinLevel, stream);
        }
        if ((flags & 16) != 0) {
            if (groupMinLevel == null) throwNullFieldException("groupMinLevel", flags);
            writeInt(groupMinLevel, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        hidden = (flags & 1) != 0;
        colorId = readInt(stream);
        colors = (flags & 2) != 0 ? readTLObject(stream, context, TLAbsPeerColorSet.class, -1) : null;
        darkColors = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsPeerColorSet.class, -1) : null;
        channelMinLevel = (flags & 8) != 0 ? readInt(stream) : null;
        groupMinLevel = (flags & 16) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 2) != 0) {
            if (colors == null) throwNullFieldException("colors", flags);
            size += colors.computeSerializedSize();
        }
        if ((flags & 4) != 0) {
            if (darkColors == null) throwNullFieldException("darkColors", flags);
            size += darkColors.computeSerializedSize();
        }
        if ((flags & 8) != 0) {
            if (channelMinLevel == null) throwNullFieldException("channelMinLevel", flags);
            size += SIZE_INT32;
        }
        if ((flags & 16) != 0) {
            if (groupMinLevel == null) throwNullFieldException("groupMinLevel", flags);
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

    public boolean getHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public TLAbsPeerColorSet getColors() {
        return colors;
    }

    public void setColors(TLAbsPeerColorSet colors) {
        this.colors = colors;
    }

    public TLAbsPeerColorSet getDarkColors() {
        return darkColors;
    }

    public void setDarkColors(TLAbsPeerColorSet darkColors) {
        this.darkColors = darkColors;
    }

    public Integer getChannelMinLevel() {
        return channelMinLevel;
    }

    public void setChannelMinLevel(Integer channelMinLevel) {
        this.channelMinLevel = channelMinLevel;
    }

    public Integer getGroupMinLevel() {
        return groupMinLevel;
    }

    public void setGroupMinLevel(Integer groupMinLevel) {
        this.groupMinLevel = groupMinLevel;
    }
}
