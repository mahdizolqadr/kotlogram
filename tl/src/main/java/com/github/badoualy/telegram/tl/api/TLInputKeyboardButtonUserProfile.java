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
public class TLInputKeyboardButtonUserProfile extends TLAbsKeyboardButton {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsInputUser userId;

    private final String _constructor = "inputKeyboardButtonUserProfile#0";

    public TLInputKeyboardButtonUserProfile() {
    }

    public TLInputKeyboardButtonUserProfile(String text, TLAbsInputUser userId) {
        this.text = text;
        this.userId = userId;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(text, stream);
        writeTLObject(userId, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        text = readTLString(stream);
        userId = readTLObject(stream, context, TLAbsInputUser.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(text);
        size += userId.computeSerializedSize();
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TLAbsInputUser getUserId() {
        return userId;
    }

    public void setUserId(TLAbsInputUser userId) {
        this.userId = userId;
    }
}
