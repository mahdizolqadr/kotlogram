package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLReportResultChooseOption extends TLAbsReportResult {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected String title;

    protected TLVector<TLMessageReportOption> options;

    private final String _constructor = "reportResultChooseOption#0";

    public TLReportResultChooseOption() {
    }

    public TLReportResultChooseOption(String title, TLVector<TLMessageReportOption> options) {
        this.title = title;
        this.options = options;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(title, stream);
        writeTLVector(options, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        title = readTLString(stream);
        options = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(title);
        size += options.computeSerializedSize();
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

    public TLVector<TLMessageReportOption> getOptions() {
        return options;
    }

    public void setOptions(TLVector<TLMessageReportOption> options) {
        this.options = options;
    }
}
