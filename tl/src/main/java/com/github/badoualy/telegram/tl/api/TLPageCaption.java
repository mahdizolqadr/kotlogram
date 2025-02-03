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
public class TLPageCaption extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsRichText text;

    protected TLAbsRichText credit;

    private final String _constructor = "pageCaption#0";

    public TLPageCaption() {
    }

    public TLPageCaption(TLAbsRichText text, TLAbsRichText credit) {
        this.text = text;
        this.credit = credit;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(text, stream);
        writeTLObject(credit, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        text = readTLObject(stream, context, TLAbsRichText.class, -1);
        credit = readTLObject(stream, context, TLAbsRichText.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += text.computeSerializedSize();
        size += credit.computeSerializedSize();
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

    public TLAbsRichText getCredit() {
        return credit;
    }

    public void setCredit(TLAbsRichText credit) {
        this.credit = credit;
    }
}
