package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLQuickReply extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int shortcutId;

    protected String shortcut;

    protected int topMessage;

    protected int count;

    private final String _constructor = "quickReply#0";

    public TLQuickReply() {
    }

    public TLQuickReply(int shortcutId, String shortcut, int topMessage, int count) {
        this.shortcutId = shortcutId;
        this.shortcut = shortcut;
        this.topMessage = topMessage;
        this.count = count;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(shortcutId, stream);
        writeString(shortcut, stream);
        writeInt(topMessage, stream);
        writeInt(count, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        shortcutId = readInt(stream);
        shortcut = readTLString(stream);
        topMessage = readInt(stream);
        count = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(shortcut);
        size += SIZE_INT32;
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

    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }

    public int getTopMessage() {
        return topMessage;
    }

    public void setTopMessage(int topMessage) {
        this.topMessage = topMessage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
