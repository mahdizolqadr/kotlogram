package com.github.badoualy.telegram.tl.api.stories;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLStoriesStealthMode;
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
public class TLAllStoriesNotModified extends TLAbsAllStories {
    public static final int CONSTRUCTOR_ID = 0x0;

    private final String _constructor = "stories.allStoriesNotModified#0";

    public TLAllStoriesNotModified() {
    }

    public TLAllStoriesNotModified(String state, TLStoriesStealthMode stealthMode) {
        this.state = state;
        this.stealthMode = stealthMode;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(flags, stream);
        writeString(state, stream);
        writeTLObject(stealthMode, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        state = readTLString(stream);
        stealthMode = readTLObject(stream, context, TLStoriesStealthMode.class, TLStoriesStealthMode.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(state);
        size += stealthMode.computeSerializedSize();
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public TLStoriesStealthMode getStealthMode() {
        return stealthMode;
    }

    public void setStealthMode(TLStoriesStealthMode stealthMode) {
        this.stealthMode = stealthMode;
    }
}
