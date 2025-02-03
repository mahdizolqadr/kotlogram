package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
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
public class TLPollAnswer extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLTextWithEntities text;

    protected TLBytes option;

    private final String _constructor = "pollAnswer#0";

    public TLPollAnswer() {
    }

    public TLPollAnswer(TLTextWithEntities text, TLBytes option) {
        this.text = text;
        this.option = option;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(text, stream);
        writeTLBytes(option, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        text = readTLObject(stream, context, TLTextWithEntities.class, TLTextWithEntities.CONSTRUCTOR_ID);
        option = readTLBytes(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += text.computeSerializedSize();
        size += computeTLBytesSerializedSize(option);
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

    public TLTextWithEntities getText() {
        return text;
    }

    public void setText(TLTextWithEntities text) {
        this.text = text;
    }

    public TLBytes getOption() {
        return option;
    }

    public void setOption(TLBytes option) {
        this.option = option;
    }
}
