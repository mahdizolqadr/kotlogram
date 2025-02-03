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
public class TLMessageReportOption extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected String text;

    protected TLBytes option;

    private final String _constructor = "messageReportOption#0";

    public TLMessageReportOption() {
    }

    public TLMessageReportOption(String text, TLBytes option) {
        this.text = text;
        this.option = option;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(text, stream);
        writeTLBytes(option, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        text = readTLString(stream);
        option = readTLBytes(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(text);
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TLBytes getOption() {
        return option;
    }

    public void setOption(TLBytes option) {
        this.option = option;
    }
}
