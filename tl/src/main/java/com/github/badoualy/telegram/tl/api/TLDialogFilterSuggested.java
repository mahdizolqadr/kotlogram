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
public class TLDialogFilterSuggested extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsDialogFilter filter;

    protected String description;

    private final String _constructor = "dialogFilterSuggested#0";

    public TLDialogFilterSuggested() {
    }

    public TLDialogFilterSuggested(TLAbsDialogFilter filter, String description) {
        this.filter = filter;
        this.description = description;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(filter, stream);
        writeString(description, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        filter = readTLObject(stream, context, TLAbsDialogFilter.class, -1);
        description = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += filter.computeSerializedSize();
        size += computeTLStringSerializedSize(description);
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

    public TLAbsDialogFilter getFilter() {
        return filter;
    }

    public void setFilter(TLAbsDialogFilter filter) {
        this.filter = filter;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
