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
public class TLPeerColorSet extends TLAbsPeerColorSet {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLIntVector colors;

    private final String _constructor = "help.peerColorSet#0";

    public TLPeerColorSet() {
    }

    public TLPeerColorSet(TLIntVector colors) {
        this.colors = colors;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(colors, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        colors = readTLIntVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += colors.computeSerializedSize();
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

    public TLIntVector getColors() {
        return colors;
    }

    public void setColors(TLIntVector colors) {
        this.colors = colors;
    }
}
