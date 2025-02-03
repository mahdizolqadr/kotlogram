package com.github.badoualy.telegram.tl.api.help;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLIntVector;
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
public class TLPeerColorProfileSet extends TLAbsPeerColorSet {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLIntVector paletteColors;

    protected TLIntVector bgColors;

    protected TLIntVector storyColors;

    private final String _constructor = "help.peerColorProfileSet#0";

    public TLPeerColorProfileSet() {
    }

    public TLPeerColorProfileSet(TLIntVector paletteColors, TLIntVector bgColors, TLIntVector storyColors) {
        this.paletteColors = paletteColors;
        this.bgColors = bgColors;
        this.storyColors = storyColors;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(paletteColors, stream);
        writeTLVector(bgColors, stream);
        writeTLVector(storyColors, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        paletteColors = readTLIntVector(stream, context);
        bgColors = readTLIntVector(stream, context);
        storyColors = readTLIntVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += paletteColors.computeSerializedSize();
        size += bgColors.computeSerializedSize();
        size += storyColors.computeSerializedSize();
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

    public TLIntVector getPaletteColors() {
        return paletteColors;
    }

    public void setPaletteColors(TLIntVector paletteColors) {
        this.paletteColors = paletteColors;
    }

    public TLIntVector getBgColors() {
        return bgColors;
    }

    public void setBgColors(TLIntVector bgColors) {
        this.bgColors = bgColors;
    }

    public TLIntVector getStoryColors() {
        return storyColors;
    }

    public void setStoryColors(TLIntVector storyColors) {
        this.storyColors = storyColors;
    }
}
