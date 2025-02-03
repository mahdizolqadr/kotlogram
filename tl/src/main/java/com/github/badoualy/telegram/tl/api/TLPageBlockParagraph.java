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
public class TLPageBlockParagraph extends TLAbsPageBlock {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsRichText text;

    private final String _constructor = "pageBlockParagraph#0";

    public TLPageBlockParagraph() {
    }

    public TLPageBlockParagraph(TLAbsRichText text) {
        this.text = text;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(text, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        text = readTLObject(stream, context, TLAbsRichText.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += text.computeSerializedSize();
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

    public TLAbsRichText getText() {
        return text;
    }

    public void setText(TLAbsRichText text) {
        this.text = text;
    }
}
