package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLStringVector;
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
public class TLEmojiGroup extends TLAbsEmojiGroup {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLStringVector emoticons;

    private final String _constructor = "emojiGroup#0";

    public TLEmojiGroup() {
    }

    public TLEmojiGroup(String title, long iconEmojiId, TLStringVector emoticons) {
        this.title = title;
        this.iconEmojiId = iconEmojiId;
        this.emoticons = emoticons;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(title, stream);
        writeLong(iconEmojiId, stream);
        writeTLVector(emoticons, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        title = readTLString(stream);
        iconEmojiId = readLong(stream);
        emoticons = readTLStringVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(title);
        size += SIZE_INT64;
        size += emoticons.computeSerializedSize();
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getIconEmojiId() {
        return iconEmojiId;
    }

    public void setIconEmojiId(long iconEmojiId) {
        this.iconEmojiId = iconEmojiId;
    }

    public TLStringVector getEmoticons() {
        return emoticons;
    }

    public void setEmoticons(TLStringVector emoticons) {
        this.emoticons = emoticons;
    }
}
