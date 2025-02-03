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
public class TLKeyboardButtonRow extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLVector<TLAbsKeyboardButton> buttons;

    private final String _constructor = "keyboardButtonRow#0";

    public TLKeyboardButtonRow() {
    }

    public TLKeyboardButtonRow(TLVector<TLAbsKeyboardButton> buttons) {
        this.buttons = buttons;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(buttons, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        buttons = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += buttons.computeSerializedSize();
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

    public TLVector<TLAbsKeyboardButton> getButtons() {
        return buttons;
    }

    public void setButtons(TLVector<TLAbsKeyboardButton> buttons) {
        this.buttons = buttons;
    }
}
