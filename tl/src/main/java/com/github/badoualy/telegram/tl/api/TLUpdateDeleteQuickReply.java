package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLUpdateDeleteQuickReply extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int shortcutId;

    private final String _constructor = "updateDeleteQuickReply#0";

    public TLUpdateDeleteQuickReply() {
    }

    public TLUpdateDeleteQuickReply(int shortcutId) {
        this.shortcutId = shortcutId;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(shortcutId, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        shortcutId = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
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

    public int getShortcutId() {
        return shortcutId;
    }

    public void setShortcutId(int shortcutId) {
        this.shortcutId = shortcutId;
    }
}
